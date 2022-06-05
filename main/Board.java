package main;

import java.util.Scanner;

public class Board {

	ArticleRepository repo = new ArticleRepository();
	ArticleView articleView = new ArticleView();	
	Member loginedMember = null;
	
	Scanner sc = new Scanner(System.in);
	ArticleController ac = new ArticleController();
	MemberController mc = new MemberController();
	
	public Board() {
		repo.makeTestData();
		loginedMember = repo.getMemberByLoginId("hong123");
	}
	
	public void run() {	
		
		while (true) {
			
			String cmd = printInputCommand();

			String[] cmdBits = cmd.split(" ");
			
			if(cmdBits.length < 2) {
				System.out.println("잘못된 명령어 입니다.");
				continue;
			}
			
			String module = cmdBits[0];
			String action = cmdBits[1];
			
			if(module.equals("article")) {				
				ac.doCommand(action);
				
			} else if(module.equals("member")) {				
				mc.doCommand(action);
				
			} else if(module.equals("common")) {
				
				if (action.equals("help")) {
					articleView.printHelp();

				} else if (action.equals("exit")) {
					System.out.println("프로그램을 종료합니다.");
					break;
					
				} else {
					System.out.println("알 수 없는 명령어입니다.");
				}
			}			
		}
	}

	private String printInputCommand() {
		
		if(loginedMember != null) {
			System.out.printf("%s(%s))  >>  ", loginedMember.getNickname(), loginedMember.getLoginId());
			
		} else {				
			System.out.print(">>  ");
			
		}
		
		String cmd = sc.nextLine();
		
		return cmd;
	}

}
