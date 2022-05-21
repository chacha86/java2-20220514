package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	ArticleRepository repo = new ArticleRepository();
	ArticleView articleView = new ArticleView();
	
	Scanner sc = new Scanner(System.in);
	
	public void run() {	

		repo.makeTestData();
		
		while (true) {
			System.out.print(">> ");
			String cmd = sc.nextLine();

			if (cmd.equals("help")) {
				articleView.printHelp();

			} else if (cmd.equals("add")) {
				addArticle();
				
			} else if (cmd.equals("list")) {
				articleView.printArticles(repo.getArticles());

			} else if (cmd.equals("update")) {
				updateArticle();
				articleView.printArticles(repo.getArticles());
				
			} else if(cmd.equals("search")) {
				searchArticles();				
				
			} else if(cmd.equals("read")) {
				readArticle();
				
			} else if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}
	}
	
	private void readArticle() {
		
		System.out.print("상세보기 할 게시물 번호 : ");
		int targetIdx = Integer.parseInt(sc.nextLine());
		targetIdx--;
		
		Article article = repo.getArticleOne(targetIdx);
		
		if(article == null) {
			System.out.println("없는 게시물입니다.");
			
		} else {
			articleView.printArticleDetail(article, targetIdx);
		}
	}
	
	private void searchArticles() {
		
		System.out.print("검색 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		ArrayList<Article> searchedList = repo.getSearchedArticleList(keyword);		
		articleView.printArticles(searchedList);
		
	}
	
	public void updateArticle() {
		// CRUD

		System.out.print("수정할 게시물 번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		int index = no - 1;

		Article article = repo.getArticleOne(index);

		if(article == null) {
			System.out.println("없는 게시물입니다.");
		} else {		
			System.out.print("새제목 : ");
			String title = sc.nextLine();
			System.out.print("새내용 : ");
			String body = sc.nextLine();
	
			Article newArticle = new Article(title, body);
			repo.updateArticle(newArticle, index);
	
			System.out.println("수정이 완료되었습니다.");
		}
//		printArticles();
		
	}

	public void addArticle() {
		System.out.print("제목 :");
		String title = sc.nextLine();

		System.out.print("내용 :");
		String body = sc.nextLine();

		Article article = new Article(title, body);
		repo.addArticle(article);

		System.out.println("게시물이 저장되었습니다.");

	}
	
	
}
