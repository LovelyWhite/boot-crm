package com.itheima.core.web.controller;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Customer;
import com.itheima.core.po.User;
import com.itheima.core.service.CustomerService;
import static com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect;

/**
 * 客户管理控制器类
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	// 依赖注入
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list.do")
	public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows, String custName, String custSource, String custIndustry, String custLevel, HttpServletResponse response) throws IOException {
		// 条件查询所有客户
		Page<Customer> customers = customerService.findCustomerList(page, rows, custName,  custSource, custIndustry,custLevel);
		response.getWriter().write(JSON.toJSONString(customers,DisableCircularReferenceDetect));
		return null;
	}
	
	/**
	 * 创建客户
	 */
	@RequestMapping("/create.do")
	@ResponseBody
	public String customerCreate(Customer customer,HttpSession session) {
	    // 获取Session中的当前用户信息
	    User user = (User) session.getAttribute("USER_SESSION");
	    // 将当前用户id存储在客户对象中
	    customer.setCust_create_id(user.getUser_id());
	    // 创建Date对象
	    Date date = new Date();
	    // 得到一个Timestamp格式的时间，存入mysql中的时间格式“yyyy/MM/dd HH:mm:ss”
	    Timestamp timeStamp = new Timestamp(date.getTime());
	    customer.setCust_createtime(timeStamp);
	    // 执行Service层中的创建方法，返回的是受影响的行数
	    int rows = customerService.createCustomer(customer);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	/**
	 * 更新客户
	 */
	@RequestMapping(value = "/update.do",method = RequestMethod.POST)
	public String customerUpdate(Customer customer,HttpServletResponse response) throws IOException {
		int rows = customerService.updateCustomer(customer);
		if (rows > 0) {
			response.getWriter().write("OK");
		} else {
			response.getWriter().write("FAIL");
		}
		return null;
	}

	/**
	 * 删除客户
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public String customerDelete(Integer id) {
	    int rows = customerService.deleteCustomer(id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}


}
