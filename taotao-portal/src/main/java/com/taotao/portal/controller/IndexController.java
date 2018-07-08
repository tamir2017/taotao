package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.portal.service.ContentService;

@Controller
public class IndexController {
	
	@Autowired
	private ContentService ContentService;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		//取大广告位内容
		String json = ContentService.getAd1List();
		//传递给页面
		model.addAttribute("ad1", json);
		
		return "index";
	}
	
	@RequestMapping(value="/posttest",method=RequestMethod.POST)
	@ResponseBody
	public String postTest(String name, String pass) {
		System.out.println(name);
		System.out.println(pass);
		return "OK";
	}
	
}

