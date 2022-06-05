package main;

import java.util.Scanner;

public class Board {

	ArticleView articleView = new ArticleView();	
	ApplicationData application = new ApplicationData();
	Scanner sc = new Scanner(System.in);
	ArticleController ac = new ArticleController(application);
	MemberController mc = new MemberController(application);

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
		
		Member loginedMember = application.getLoginedMember();
		
		if(loginedMember != null) {
			System.out.printf("%s(%s))  >>  ", loginedMember.getNickname(), loginedMember.getLoginId());
			
		} else {				
			System.out.print(">>  ");
			
		}
		
		String cmd = sc.nextLine();
		
		return cmd;
	}

}
