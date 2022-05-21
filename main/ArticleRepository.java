package main;

import java.util.ArrayList;

public class ArticleRepository {
	
	private ArrayList<Article> articles = new ArrayList<>();
	

	public void makeTestData() {		
		
		Article a1 = new Article("제목1", "내용1");
		Article a2 = new Article("제목2", "내용2");
		Article a3 = new Article("제목3", "내용3");
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
	}
	
	// C
	
	public void addArticle(Article article) {
		articles.add(article);
	}
	
	// R
	public Article getArticleOne(int idx) {
		
		if (idx < 0 || idx >= articles.size()) {
			return null;
		}
		
		return articles.get(idx);
	}
	
	public ArrayList<Article> getSearchedArticleList(String keyword) {
		
		ArrayList<Article> searchedArticleList = new ArrayList<>();
		
		for(int i = 0; i < articles.size(); i++) {
			if(articles.get(i).getTitle().contains(keyword)) {
				searchedArticleList.add(articles.get(i));
			}
		}
		
		return searchedArticleList;
	}
	
	public ArrayList<Article> getArticles() {
		return this.articles;
	}
	
	// U
	public void updateArticle(Article article, int idx) {
		articles.set(idx, article);
	}
	
	// D
	public void deleteArticle(int idx) {
		articles.remove(idx);
	}
}
