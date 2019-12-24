package com.itheima.core.web.controller;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.common.utils.FaceMatch;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

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
	public String login(String usercode, String password,String pic,String method, Model model, HttpSession session, HttpServletResponse response) throws IOException {
		if("password".equals(method))
		{
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
		else if("face".equals(method))
		{
			boolean ok = true;
			ArrayList<User> users = (ArrayList<User>) userService.getUsers();
			for (User u : users) {
				if (u.getUser_pic() !=null && !u.getUser_pic().equals("")) {
					JSONObject result = FaceMatch.match(u.getUser_pic(),pic	);
					if ((double) result.get("score") > 90) {
						ok = false;
						break;
					}
				}
			}
			if(ok)
			{
				response.getWriter().write("not");
			}
			else
			{
				response.getWriter().write("success");
			}
			return null;
		}
		else
		{
			response.getWriter().write("fail");
			return null;
		}
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
	/**
	 * 删除客户
	 */
	@RequestMapping("setFace.do")
	@ResponseBody
	public String setFace (String pic,HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
		int rows = userService.setFace(user.getUser_code(),pic);
		if(rows > 0){
			return "OK";
		}else{
			return "FAIL";
		}
	}
}
