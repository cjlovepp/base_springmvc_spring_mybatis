package com.project.front.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.commons.web.base.controller.BaseController;
import com.project.front.web.entity.BaseUser;
import com.project.front.web.service.BaseUserService;

@Controller
@RequestMapping("front/baseUser/")
public class BaseUserController extends BaseController {

	@Autowired
	private BaseUserService userService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		
		@SuppressWarnings("unchecked")
		List<BaseUser> list = (List<BaseUser>) baseService.getAll(BaseUser.class);
		String accountId = "0000000000";
		BaseUser user = userService.findByAccountId("findByAccountId", accountId);
		request.setAttribute("TotalRow", list.size());
		request.setAttribute("helloWorld", "哈哈，世界真美好！");
		request.setAttribute("user", user);
		return "front/helloWorld";
	}
}
