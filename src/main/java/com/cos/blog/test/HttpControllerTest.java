package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(HTML 파일)
//@Controller

//사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	private static final String TAG = "HttpControllerTest : ";
	
	//인터넷 브라우저 요청은 무조건 get요청밖에 할 수 없다.
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		return "get 요청 : "+ m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
			
		return "post 요청 : "+ m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest() {
		
		return "put 요청";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		
		return "delete 요청";
	}
}
