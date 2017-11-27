package com.fnic;

import com.fnic.bean.Person;
import com.fnic.sysframe.config.ConfigSettings;
import com.fnic.mybatis.dao.UserMapper;
import com.fnic.mybatis.model.User;
import com.fnic.mybatis.model.UserExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@EnableTransactionManagement
@SpringBootApplication
@RestController
@EnableConfigurationProperties
@MapperScan(basePackages="com.fnic.mybatis.dao")
public class BootApplication {

	@Value("${book.name}")
	private String bookName;

	@Autowired
	private ConfigSettings configSettings;

	@Autowired
	private UserMapper userMapper;

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

	public static void main(String[] args)
	{

		SpringApplication.run(BootApplication.class, args);
	}
}
