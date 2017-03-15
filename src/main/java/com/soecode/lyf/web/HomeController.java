package com.soecode.lyf.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 
 * @author liujie
 * @version 1.0
 * @since 页面跳转
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		return "/login";
	}

	@RequestMapping(value = "/jiankong", method = RequestMethod.GET)
	public String jiankong(HttpServletRequest request, Map<String, String> map, HttpServletResponse response,
			HttpSession session) {
		return "/user/jiankong";
	}

}