package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM -> JAVA (다른 언어) Object -> 테이블로 매핑해주는 기술
 //User 클래스가 MySQL에 테이블이 생성이 된다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert //insert시에  null인 필드를 제외시켜준다.
@Entity
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; //오라클에서는 시퀀스 , mysql에서는  auto_increment
	
	@Column(nullable = false, length = 100, unique = true)
	private String username;  //아이디
	
	@Column(nullable = false, length = 100) //길이가 긴 이유 = 해쉬를 써써 비밀번호를 암호화할 예정
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//DB는 RoleType이라는 게 없다.
	//@ColumnDefault("user")
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다.
	
	//카카오로그인시 kakao 
	private String oauth;
	
	@CreationTimestamp // 시간이 자동으로 입력
	private Timestamp createDate;
	
}
