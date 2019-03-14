package com.fnic.controller;

import com.fnic.mybatis.iot.dao.*;
import com.fnic.mybatis.iot.model.*;
import com.fnic.service.OrderService;
import com.fnic.sysframe.utils.UserUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by hjhuang on 2017/5/18.
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private TProductTypeMapper productTypeMapper;

    @Autowired
    private TProductMapper productMapper;

    @Autowired
    private TProductItemMapper productItemMapper;

    @Autowired
    private TProductCombMapper productCombMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TShoppingCartMapper shoppingCartMapper;

    @Autowired
    private TSubOrderMapper subOrderMapper;

    @Autowired
    private TQosOrderMapper qosOrderMapper;

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping("/queryProductType")
    public List<Map<String,Object>> queryProductType() {

        this.logger.debug("@@@@@@@@@@@@@@queryProductType:");

        TProductTypeExample productTypeExample = new TProductTypeExample();
        List<TProductType> productTypeList = productTypeMapper.selectByExample(productTypeExample);

        List<Map<String,Object>> tempProductTypeList = Lists.newArrayList();
        for(TProductType productType : productTypeList) {

            TProductCombExample productCombExample = new TProductCombExample();
            productCombExample.createCriteria().andCombTypeEqualTo("T").andCombIdEqualTo(productType.getProductTypeId());
            List<TProductComb> productList = productCombMapper.selectByExample(productCombExample);
            List<Map<String,Object>> tempProductList = Lists.newArrayList();

            Map<String,Object> tempProductType = Maps.newHashMap();
            tempProductType.put("prouctTypeId",productType.getProductTypeId());
            tempProductType.put("productTypeName",productType.getProductTypeName());


            for(TProductComb product : productList) {
                Map<String,Object> tempProduct = Maps.newHashMap();
                tempProduct.put("productId",product.getItemId());
                tempProduct.put("productName",product.getProductName());
                tempProduct.put("productIcon",product.getProductIcon());
                tempProduct.put("productDesc",product.getProductDesc());
                tempProduct.put("productPrice",product.getPrice());

                productCombExample.clear();
                productCombExample.createCriteria().andCombTypeEqualTo("P").andCombIdEqualTo(product.getItemId());
                List<TProductComb> prodcutPackageList = productCombMapper.selectByExample(productCombExample);

                List<Map<String,Object>> tempPackageList = Lists.newArrayList();

                for(TProductComb productPackage : prodcutPackageList) {
                    Map<String,Object> tempPackage = Maps.newHashMap();
                    productCombExample.clear();
                    productCombExample.createCriteria().andCombTypeEqualTo("K").andCombIdEqualTo(productPackage.getItemId());
                    List<TProductComb> productItemList = productCombMapper.selectByExample(productCombExample);

                    List<Map<String,Object>> tempProductItemList = Lists.newArrayList();

                    for(TProductComb productItem : productItemList) {
                        Map<String,Object> tempProductItem = Maps.newHashMap();
                        tempProductItem.put("productItemId",productItem.getItemId());
                        tempProductItem.put("productItemName",productItem.getProductItemName());
                        tempProductItem.put("price",productItem.getPrice());

                        tempProductItemList.add(tempProductItem);
                    }

                    tempPackage.put("productPackageId",productPackage.getItemId());
                    tempPackage.put("productItemList",tempProductItemList);
                    tempPackageList.add(tempPackage);
                }

                tempProduct.put("productPackageList", tempPackageList);

                tempProductList.add(tempProduct);
            }

            tempProductType.put("productList",tempProductList);
            tempProductTypeList.add(tempProductType);
        }
        return tempProductTypeList;
    }

    @RequestMapping("submitShoppingCart")
    public Map<String,Object> submitShoppingCart(@RequestBody Map<String,Object> inputParam) {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","9999");
        rspMap.put("rspDesc","error");

        boolean result = false;
        try {
            result = orderService.submitShoppingCart(inputParam);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(result) {
            rspMap.put("rspCode","0000");
            rspMap.put("rspDesc","Success");
        }

        return rspMap;
    }

    @RequestMapping("queryCartList")
    public Map<String,Object> queryCartList() {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","Success");

        TShoppingCartExample shoppingCartExample = new TShoppingCartExample();
        shoppingCartExample.createCriteria().andOperUserIdEqualTo(UserUtil.getUser().getId());
        List<TShoppingCart> list = shoppingCartMapper.selectByExample(shoppingCartExample);

        rspMap.put("cartList",list);

        return rspMap;
    }

    @RequestMapping("submitOrder")
    public Map<String,Object> submitOrder(@RequestBody Map<String,Object> inputParam) {

        Map<String,Object> rspMap = Maps.newHashMap();
        String rspCode = "9999";
        rspMap.put("rspDesc","error");

        StringBuffer errorStr = new StringBuffer();
        List<Integer> idList = (List<Integer>) inputParam.get("idList");
        List<Integer> operList = Lists.newArrayList() ;

        TShoppingCartExample shoppingCartExample = new TShoppingCartExample();
        shoppingCartExample.createCriteria().andIdIn(idList);

        List<TShoppingCart> cartList = shoppingCartMapper.selectByExample(shoppingCartExample);

        if(cartList.size()>0) {
            List<String> productList = Lists.newArrayList();
            for(TShoppingCart shoppingCart : cartList ) {
                //产品新增
                if(shoppingCart.getOperType().equals("0")) {
                    TSubOrderExample subOrderExample = new TSubOrderExample();
                    subOrderExample.createCriteria().andItemIdEqualTo(shoppingCart.getGoodsId()).andItemTypeEqualTo("P");
                    int count = subOrderMapper.countByExample(subOrderExample);

                    if(count>0) {
                        rspCode = "0001";
                        errorStr.append(shoppingCart.getGoodsName());
                    }else {
                        operList.add(shoppingCart.getId());
                    }
                }
            }
            if(rspCode.equals("0001")) {
                errorStr.append("产品已经订购。");
            }
        }

        boolean result = false;
        if(operList.size()>0) {
            try {
                result = orderService.submitOrder(operList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            errorStr.append("没有要操作的订单！");
        }

        if(result) {
            rspMap.put("rspCode","0000");
            rspMap.put("rspDesc","订单提交成功");
        }else {
            rspMap.put("rspCode",rspCode);
            rspMap.put("rspDesc",errorStr.toString());
        }

        return rspMap;
    }

    @RequestMapping("queryOosOrderList")
    public Map<String,Object> queryOosOrderList() {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","Success");

        TQosOrderExample qosOrderExample = new TQosOrderExample() ;
        qosOrderExample.createCriteria().andAccountIdEqualTo(UserUtil.getUser().getAccountId());
        List<TQosOrder> list = qosOrderMapper.selectByExample(qosOrderExample);

        rspMap.put("qosOrderList",list);

        return rspMap;
    }

    @RequestMapping("queryOrderList")
    public Map<String,Object> queryOrderList(@RequestBody Map<String,Object> param) {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","Success");

        TOrderExample orderExample = new TOrderExample() ;
        orderExample.createCriteria().andAccountIdEqualTo(UserUtil.getUser().getAccountId());
        List<TOrder> list = orderMapper.selectByExample(orderExample);

        rspMap.put("orderList",list);

        return rspMap;
    }

    @RequestMapping(value="test")
    public Map<String,Object> test() {

        try {
            kafkaTemplate.send("test","2222222");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,Object> rspMap = Maps.newHashMap();
        String rspCode = "0000";
        rspMap.put("rspDesc","sssss");

        return rspMap;
    }

    @RequestMapping(value="testJson")
    public Map<String,Object> testJson(@RequestBody Map<String,Object> param) {

        logger.debug("@@@@@@@@@@@" + param);

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","sssss");

        return rspMap;
    }
}
