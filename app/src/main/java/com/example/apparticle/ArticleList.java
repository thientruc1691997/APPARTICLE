package com.example.apparticle;

import java.util.ArrayList;

public class ArticleList {
    public ArticleList(ArrayList<Article> articles) {
        this.articles = articles;
    }

    private ArrayList<Article> articles;

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
