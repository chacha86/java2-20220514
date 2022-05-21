package main;

public class Article {

	private String title;
	private String body;
	
	public Article(String title, String body) {
		this.title = title; // this는 인스턴스를 의미.
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
