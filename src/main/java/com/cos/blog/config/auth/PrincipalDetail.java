package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Getter;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetail 타입의 오브젝트를 
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
@Getter
public class PrincipalDetail implements UserDetails{
	
	private User user; //콤포지션 : 객체를 품고 있음. 

	public PrincipalDetail(User user) {
		this.user=user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}
	
	//계정이 만료되지 않았는지 리턴한다. (true: 만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	
	//계정이 잠겨있지 않았는지 리턴한다.
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//비밀번호가 만료되지 않았는지 리턴한다.(true) 만료안됨.
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//계정이 활성화인지 리턴한다.(true: 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//계정의 권한을 리턴한다.
	//계정이 갖고 있는 권한 목록을 리턴한다.(권한이 여러개 있으면 루프를 돌아야함) 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_"+user.getRole();});
//		collectors.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				//스프링에서 롤을 받을때 규칙 : 프리픽스로 ROLE_를 붙여야함. 
//				return "ROLE_"+user.getRole();
//			}
//		});
		return collectors;
	}
}
