package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print(">> ");
			String cmd = sc.nextLine();

			if (cmd.equals("help")) {
				System.out.println("도움말 기능");

			} else if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
		}
	}

}
