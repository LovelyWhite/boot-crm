package com.itheima.core.web.controller;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;

import java.io.IOException;

/**
 * 用户控制器类
 */
@Controller
@RequestMapping("/request")
public class UserController {
	// 依赖注入
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(String usercode, String password, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		// 通过账号和密码查询用户
		User user = userService.findUser(usercode, password);
		if(user != null){		
			// 将用户对象添加到Session
			session.setAttribute("USER_SESSION", user);
			//model.addAttribute("msg", "success");
			response.getWriter().write("success");
		}
		else
			response.getWriter().write("fail");
         // 返回到登录页面
		return null;
	}
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout.do" ,method = RequestMethod.POST)
	public String logout(HttpSession session,HttpServletResponse response) throws IOException {
	    // 清除Session
	    session.invalidate();
	    response.getWriter().write("success");
	    // 重定向到登录页面的跳转方法
	    return null;
	}

}
