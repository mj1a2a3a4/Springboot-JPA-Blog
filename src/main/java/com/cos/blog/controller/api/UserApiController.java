package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		log.info("UserApiController : save 호출됨");
		//실제로 DB예 insert를 하고 아래에서 return이 되면 되요.
		user.setRole(RoleType.USER);
		int result = userService.save(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	
	// 전통적인 로그인 방식
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
		System.out.println("UserApiController : login 호출됨");
		User principal = userService.로그인(user);
		
		if(principal != null) {
			session.setAttribute("principal", principal);
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
