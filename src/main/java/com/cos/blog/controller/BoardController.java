package com.cos.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;

@Controller
public  class BoardController {
	
	
	//컨트롤러에서 세션을 어떻게 찾는가
	@GetMapping({"/", ""})
	public String index() {
		// /WEB-INF/views/index.jsp
		
		return "index";
	}
	
	//USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "/board/saveForm";
	}
}
