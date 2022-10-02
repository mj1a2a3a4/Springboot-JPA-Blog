package com.cos.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserApiController {
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		log.info("UserApiController : save 호출됨");
		//실제로 DB예 insert를 하고 아래에서 return이 되면 되요.
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
}
