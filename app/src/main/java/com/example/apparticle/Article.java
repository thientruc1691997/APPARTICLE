package com.example.apparticle;

import com.google.firebase.database.PropertyName;

public class Article {

    @PropertyName("article_id")
    private int article_id;
    @PropertyName("article_title")
    private String article_title;
    @PropertyName("article_image")
    private String article_image;
    @PropertyName("article_description")
    private String article_description;

    public int getArticleId() {
        return article_id;
    }

    public void setArticleId(int article_id) {
        this.article_id = article_id;
    }

    public String getArticleTitle() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticleImage() {
        return article_image;
    }

    public void setArticleImage(String article_image) {
        this.article_image = article_image;
    }

    public String getArticleDescription() {
        return article_description;
    }

    public void setArticleDescription(String article_description) {
        this.article_description = article_description;
    }

    public Article(String article_description, int article_id, String article_image, String article_title) {
        this.article_id = article_id;
        this.article_title = article_title;
        this.article_image = article_image;
        this.article_description = article_description;
    }

    public Article() {
    }
}
