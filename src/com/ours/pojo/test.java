package com.ours.pojo;

/**
 * Created by Administrator on 2016/5/17.
 */
public class Test {
    private int id;
    private String content;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Test(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public Test(int id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
    }

    public Test() {
    }
}
