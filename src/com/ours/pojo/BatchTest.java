package com.ours.pojo;

/**
 * Created by Administrator on 2016/5/31.
 */
public class BatchTest {
    private String username;
    private String userage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public BatchTest(String username, String userage) {
        this.username = username;
        this.userage = userage;
    }

    @Override
    public String toString() {
        return "BatchTest{" +
                "username='" + username + '\'' +
                ", userage='" + userage + '\'' +
                '}';
    }
}
