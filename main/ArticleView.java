package main;

import java.util.ArrayList;

public class ArticleView {

	public void printArticles(ArrayList<Article> articles) {
		// list 전체 출력
		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);

			System.out.printf("번호: %d\n", article.getId());
			System.out.printf("제목: %s\n", article.getTitle());
			System.out.printf("등록일: %s\n", article.getRegDate());
			System.out.printf("작성자 : %s\n", article.getNickname());
			System.out.printf("조회수: %d\n", article.getHit());
			System.out.println("==========================");
		}
	}

	public void printArticleDetail(Article article) {
		System.out.printf("========= %d번 게시물 =========\n", article.getId());
		System.out.printf("번호 : %d\n", article.getId());
		System.out.printf("제목 : %s\n", article.getTitle());
		System.out.printf("등록일: %s\n", article.getRegDate());
		System.out.printf("작성자 : %s\n", article.getNickname());
		System.out.printf("조회수: %d\n", article.getHit());
		System.out.println("------------------------------");
		System.out.printf("내용 : %s\n", article.getBody());
		System.out.println("------------------------------");
		System.out.println("===============================");
	}

	public void printHelp() {
		System.out.println("add    : 게시물 등록");
		System.out.println("list   : 게시물 목록");
		System.out.println("update : 게시물 수정");
		System.out.println("eixt   : 프로그램 종료");
	}
}
