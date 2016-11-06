package com.stephen.controller;

import com.stephen.controller.CheckvalidDAO;
//import com.stephen.controller.mybatisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StephenHelloworld {
	private String UserName="-1";
	private String PassWord="-1";
	
	@RequestMapping(value="CheckValid",method=RequestMethod.POST)
	@ResponseBody
	public String  CheckValid(HttpServletRequest request,ModelMap model) throws IOException {
		
		String username=request.getParameter("userName");
		String userpasswd="-1";
		CheckvalidDAO checker=new CheckvalidDAO();
		userpasswd=checker.selectByUsername(username);
		String localpasswd=request.getParameter("password");
		if(userpasswd == null){
			return "invalid";
		}
		if(userpasswd.equals("-2")){
			model.addAttribute("checked", "no sqlsessionfactory!!!!!");
			return "invalid";
		}
		if(userpasswd.equals(localpasswd)){
			//model.addAttribute("checked", "password is vaild!!");
			this.UserName=username;
			this.PassWord=userpasswd;
			return "valid";
		}
		else{
			//model.addAttribute("checked", "password is wrong!!"+userpasswd);
			return "invalid";
		}
	}
	
	@RequestMapping("changePage.html")
	public String ChangePage(ModelMap model){
		model.addAttribute("username",this.UserName);
		model.addAttribute("password",this.PassWord);
		model.addAttribute("checked", "login successfully enjoy!!!");
		return "result";
	}

}
