package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.service.BoardService;

@Controller
public  class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//컨트롤러에서 세션을 어떻게 찾는가
	@GetMapping({"/", ""})
	public String index(Model model) {
		// /WEB-INF/views/index.jsp
		model.addAttribute("boards", boardService.글목록());
		return "index";
	}
	
	//USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "/board/saveForm";
	}
}
