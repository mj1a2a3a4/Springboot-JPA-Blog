package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //의존성 주입 
	private UserRepository userRepository;
	
	@PostMapping("/dummy/join")
	public String join( User user) {
		System.out.println("username : "+ user.getUsername());
		System.out.println("pass	word : "+ user.getPassword());
		System.out.println("email : "+ user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
	
	
	//{id} 주소로 파라메터를 전달 받을 수 있음.
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user /4을 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될 것 아냐?
		//그럼 return null이 리턴이 되자나. 그럼 프로그램에 문제가 있지 않겠니?
		//Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해
		// .get() , orElseGet() , orElseThrow()
		//	User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
		//
		//	@Override
		//	public User get() {
		//			return new User();
		//		}
		//	});
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 사용자는 없습니다.");
			}
		});
		return user;
	}
	
	@GetMapping("/dummy/user")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user/page")
	public Page<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> users = userRepository.findAll(pageable);
		
		return users;
	}
	//email, password 
	//save 함수는 id를 전달하지 않으면 insert를 해주고
	//save 함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	//save 함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해줌.
	@Transactional  //함수 종료시 자동 commit이 됨.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		//JSON 데이터를 요청 -> JAVA OBJECT로 변환해서 받아줌.
		//MessageConverter의 Jaskson 라이브러리가 변환함
		System.out.println("id : "+ id);
		System.out.println("password : "+ requestUser.getPassword());
		System.out.println("email : "+ requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		//userRepository.save(user);
		//더티 체킹
		return user;	
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 ID는 DB에 없습니다.";
		}
		return "회원 삭제되었습니다 id : "+id;
	}
}
