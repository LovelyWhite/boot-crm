package com.itheima.core.web.controller;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.common.utils.FaceMatch;
import com.itheima.common.utils.ReturnValue;
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
				response.getWriter().write(new ReturnValue(1,"密码登录成功",session.getAttribute("USER_SESSION")).toString());
			}
			else
				response.getWriter().write(new ReturnValue(0,"密码登陆失败",null).toString());
			// 返回到登录页面
			return null;
		}
		else if("face".equals(method))
		{
			JSONObject result = null;
			boolean ok = true;
			ArrayList<User> users = (ArrayList<User>) userService.getUsers();
			for (User u : users) {
				if (u.getUser_pic() !=null && !u.getUser_pic().equals("")) {
					result = FaceMatch.match(u.getUser_pic(),pic);
					if(result!=null && 0==result.getInt("error_code"))
					{
						if (result.getJSONObject("result").getDouble("score") > 90) {
                            session.setAttribute("USER_SESSION", u);
							ok = false;
							break;
						}
					}

				}
			}
			if(ok)
			{
				assert result != null;
				response.getWriter().write(new ReturnValue(0,"识别失败|error_msg:"+(result!=null?result.getString("error_msg")+"|error_code:"+result.getInt("error_code"):"error"),null).toString());
			}
			else
			{
				response.getWriter().write(new ReturnValue(1,"人脸识别成功", session.getAttribute("USER_SESSION")).toString());
			}
			return null;
		}
		else
		{
			response.getWriter().write(new ReturnValue(0,"请提交正确数据",null).toString());
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
	    response.getWriter().write(new ReturnValue(1,"success",null).toString());
	    // 重定向到登录页面的跳转方法
	    return null;
	}

	@RequestMapping("updateUser.do")
	public String setFace (User user,HttpServletResponse response) throws IOException {
		int rows = userService.updateUser(user);
		if(rows > 0){
			response.getWriter().write( new ReturnValue(1,"保存成功",null).toString());
		}else{
			response.getWriter().write( new ReturnValue(0,"保存失败",null).toString());
		}
		return null;
	}
}
