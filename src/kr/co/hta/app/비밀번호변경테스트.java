package kr.co.hta.app;

import java.sql.SQLException;

import kr.co.hta.service.UserService;
import kr.co.hta.util.Keyboard;
import kr.co.hta.vo.User;

public class 비밀번호변경테스트 {

	public static void main(String[] args) throws SQLException {
	
		System.out.println("### 비밀번호 변경 테스트");
		
		System.out.println("# 아이디, 이전 비밀번호, 새 비밀번호를 입력하세요");
	
		System.out.println("아이디 입력 > ");
		String userId = Keyboard.nextString();
		
		System.out.println("이전 비밀번호 입력 > ");
		String oldPassword = Keyboard.nextString();
		
		System.out.println("새 비밀번호 입력 > ");
		String newPassword = Keyboard.nextString();
		
		UserService userService = UserService.getInstance();
		// 비밀번호 변경 서비스호출
		userService.changePassword(userId, oldPassword, newPassword);
		// 사용자정조회서비스 호출
		User user = userService.getUserInfo(userId);
		System.out.println("### 사용자 정보 ###");
		System.out.println("아 이 디: " + user.getId());
		System.out.println("이    름: " + user.getName());
		System.out.println("비밀번호: " + user.getPassword());
		System.out.println("이 메 일: " + user.getEmail());
		System.out.println("포 인 트: " + user.getPoint());
		System.out.println("탈퇴여부: " + user.getDisabled());
		System.out.println("생성일자: " + user.getCreateDate());
		
	}
}
