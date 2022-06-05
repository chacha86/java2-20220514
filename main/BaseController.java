package main;

import java.util.Scanner;

public class BaseController {
	
	
	ApplicationData application = null;
	ArticleRepository repo = new ArticleRepository();
	ArticleView articleView = new ArticleView();
	Scanner sc = new Scanner(System.in);
	LoginFlag flag;
	
	public BaseController(ApplicationData application) {
		this.application = application;
	}
	
	// public - 전체 공개
	// protected - 같은 패키지 + 상속관계
	// default - 같은 패키지
	// private - 자기 자신
	
	protected boolean isLogined() {
		if(application.getLoginedMember() == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		}
		
		return true;
	}
}
