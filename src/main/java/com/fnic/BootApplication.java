package com.fnic;

import com.fnic.bean.Person;
import com.fnic.service.OrderService;
import com.fnic.sysframe.config.ConfigSettings;
import com.fnic.mybatis.iot.dao.UserMapper;
import com.fnic.mybatis.iot.model.User;
import com.fnic.mybatis.iot.model.UserExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//@EnableTransactionManagement(proxyTargetClass = true)
@EnableTransactionManagement
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@RestController
@EnableConfigurationProperties
@MapperScan(basePackages="com.fnic.mybatis")
@EnableCaching
public class BootApplication {

	//@Value("${book.name}")
	private String bookName;

	@Autowired
	private ConfigSettings configSettings;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderService orderService;

	@RequestMapping("/")
	public String index()
	{
		return "hello world:" + bookName;
	}

	@RequestMapping("/test1")
	public String test1() {
		return "hello world((((999" + configSettings.getName();
	}

	@RequestMapping("/search")
	public Person search(String personName)
	{
		return new Person(personName,23,"222222");
	}

	@RequestMapping("/queryUser")
	public List<User> queryUser() {

		UserExample userExample = new UserExample();

		List<User> list = userMapper.selectByExample(userExample);
		return list;
	}

	@RequestMapping("/insertUser")
	public Map<String, Object> insertUser(User user) throws Exception {

		Map<String,Object> rspMap = new HashMap<String,Object>();
//		int count = userMapper.insert(user);
//
//		if(count > 0) {
//            throw new Exception();
//        }
		rspMap.put("rspCode","0000");
		rspMap.put("rspDesc","0000");

		return rspMap;
	}

	@RequestMapping("/userLogin")
	public Map<String, Object> userLogin(User user) throws Exception {

		Map<String, Object> rspMap = new HashMap<String, Object>();
//		int count = userMapper.insert(user);
		rspMap.put("rspCode", "0000");
		rspMap.put("rspDesc", "0000");

		return rspMap;
	}

	@RequestMapping("/testPress")
	public Map<String, Object> testPress(User user) throws Exception {

		Map<String, Object> rspMap = new HashMap<String, Object>();
//		int count = userMapper.insert(user);

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			try {
				orderService.testPress();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


		rspMap.put("rspCode", "0000");
		rspMap.put("rspDesc", "0000");

		return rspMap;
	}

	@RequestMapping(value = "/testMqttPress/{number}", method = RequestMethod.GET)
	public Map<String, Object> testMqttPress(@PathVariable("number")int i) throws Exception {

		Map<String, Object> rspMap = new HashMap<String, Object>();

		final int num = i;
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			try {
				orderService.testMqttPress(num);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


		rspMap.put("rspCode", "0000");
		rspMap.put("rspDesc", "0000");

		return rspMap;
	}

	@RequestMapping(value = "/testMqttPressAttr/{number}", method = RequestMethod.GET)
	public Map<String, Object> testMqttPressAttr(@PathVariable("number")int i) throws Exception {

		Map<String, Object> rspMap = new HashMap<String, Object>();

		final int num = i;
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			try {
				orderService.testMqttPressAttr(num);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


		rspMap.put("rspCode", "0000");
		rspMap.put("rspDesc", "0000");

		return rspMap;
	}

	@RequestMapping(value = "/testMqttConnect/{number}", method = RequestMethod.GET)
	public Map<String, Object> testMqttConnect(@PathVariable("number")int i) throws Exception {

		Map<String, Object> rspMap = new HashMap<String, Object>();

		final int num = i;
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			try {
				orderService.testMqttConnect(num);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


		rspMap.put("rspCode", "0000");
		rspMap.put("rspDesc", "0000");

		return rspMap;
	}

	public static void main(String[] args)
	{

		SpringApplication.run(BootApplication.class, args);
	}
}
