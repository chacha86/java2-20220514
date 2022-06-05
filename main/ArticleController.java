package main;

import java.util.ArrayList;

public class ArticleController extends BaseController {
	
	ApplicationData application = null;
	
	public ArticleController(ApplicationData application) {
		
		super(application);		
		
		this.application = application;		
		Member loginedMember = repo.getMemberByLoginId("hong123");
		application.setLoginedMember(loginedMember);
		
		repo.makeTestData();
	}
	
	public void doCommand(String cmd) {

		if (cmd.equals("add")) {

			if (isLogined()) {
				addArticle();
			}

		} else if (cmd.equals("list")) {
			articleView.printArticles(repo.getArticles());

		} else if (cmd.equals("update")) {
			updateArticle();
			articleView.printArticles(repo.getArticles());

		} else if (cmd.equals("search")) {
			searchArticles();

		} else if (cmd.equals("read")) {
			if (isLogined()) {
				readArticle();
			}

		} else if (cmd.equals("delete")) {
			deleteArticle();

		} else {
			System.out.println("잘못된 명령어 입니다.");
		}
		
	}

	public void addArticle() {
		System.out.print("제목 :");
		String title = sc.nextLine();

		System.out.print("내용 :");
		String body = sc.nextLine();

		repo.addArticle(title, body, application.getLoginedMember().getNickname());
		System.out.println("게시물이 저장되었습니다.");

	}

	private void deleteArticle() {
		System.out.print("삭제 할 게시물 번호 : ");
		int targetId = Integer.parseInt(sc.nextLine());

		Article article = repo.getArticleOne(targetId);
		repo.deleteArticle(article);

		System.out.println("삭제가 완료되었습니다.");

	}

	private void readArticle() {

		System.out.print("상세보기 할 게시물 번호 : ");
		int targetId = Integer.parseInt(sc.nextLine());

		Article article = repo.getArticleOne(targetId);

		if (article == null) {
			System.out.println("없는 게시물입니다.");

		} else {
			repo.increaseReadCnt(article);
			ArrayList<Reply> replies = repo.getRepliesByArticleId(article.getId());
			articleView.printArticleDetail(article, replies);
			readProcess(article);
		}
	}

	private void readProcess(Article article) {

		while (true) {
			System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
			int readCmdNo = Integer.parseInt(sc.nextLine());

			if (readCmdNo == 1) {

				addReply(article);
				ArrayList<Reply> replies = repo.getRepliesByArticleId(article.getId());
				articleView.printArticleDetail(article, replies);

			} else if (readCmdNo == 2) {
				System.out.println("[추천]");
			} else if (readCmdNo == 3) {
				System.out.println("[수정]");
			} else if (readCmdNo == 4) {
				System.out.println("[삭제]");
			} else if (readCmdNo == 5) {
				break;
			}
		}
	}

	private void addReply(Article article) {
		System.out.print("댓글 내용을 입력해주세요 : ");
		String body = sc.nextLine();
		repo.addReply(article.getId(), body, application.getLoginedMember().getNickname());
		System.out.println("댓글이 등록되었습니다.");
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
		int targetId = Integer.parseInt(sc.nextLine());

		Article article = repo.getArticleOne(targetId);

		if (article == null) {
			System.out.println("없는 게시물입니다.");
		} else {
			System.out.print("새제목 : ");
			String title = sc.nextLine();
			System.out.print("새내용 : ");
			String body = sc.nextLine();

			repo.updateArticle(article, title, body);

			System.out.println("수정이 완료되었습니다.");
		}
	}

}
