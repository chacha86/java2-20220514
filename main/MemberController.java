package main;

import java.util.Scanner;

public class MemberController extends BaseController {

	ApplicationData application = null;
	
	public MemberController(ApplicationData application) {
		super(application);
		this.application = application;
	}
	
	public void doCommand(String cmd) {		

		if (cmd.equals("signup")) {
			signup();

		} else if (cmd.equals("mlist")) {
			articleView.printMembers(repo.getMembers());

		} else if (cmd.equals("login")) {
			login();

		} else if (cmd.equals("logout")) {
			logout();

		} else {
			System.out.println("잘못된 명령어 입니다.");
		}
	}
	
	private void logout() {
		application.setLoginedMember(null);
		System.out.println("로그아웃 되셨습니다.");
		
	}

	private void login() {
		System.out.print("아이디 :");
		String loginId = sc.nextLine();

		System.out.print("비밀번호 :");
		String loginPw = sc.nextLine();
		
		LoginFlag result = repo.doLogin(loginId, loginPw);
		
		if(result == flag.LOGIN_SUCCESS) {
			Member member = repo.getMemberByLoginId(loginId);
			loginSuccessProcess(member);
			
		} else if(result == flag.NOT_EXIST_LOGIN_ID) {
			System.out.println("없는 아이디입니다.");
			
		} else {
			System.out.println("비밀번호를 틀렸습니다.");
			
		}
		
	}

	private void loginSuccessProcess(Member member) {
		// 1. 환영인사.
		System.out.printf("%s님 안녕하세요!!\n", member.getNickname());
	
		// 2. 로그인 유저 정보 세팅
		application.setLoginedMember(member);
		
	}

	private void signup() {
		System.out.print("아이디 :");
		String loginId = sc.nextLine();

		System.out.print("비밀번호 :");
		String loginPw = sc.nextLine();
		
		System.out.print("이름 :");
		String nickname = sc.nextLine();
		
		repo.addMember(loginId, loginPw, nickname);
		System.out.println("회원가입이 완료되었습니다.");
	}

}
