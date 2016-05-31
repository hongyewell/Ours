package com.ours.dao;


import com.ours.pojo.test;
import com.ours.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDao {

    private SqlSession session;

    public TestDao() {
        session = MyBatisUtil.getSqlSession();
    }


    public void insertOursTest(String title, String content) {
        String insertOursTest = "com.ours.mapping.testMapper.insertOursTest";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", title);
        params.put("content", content);
        session.insert(insertOursTest, params);
        session.commit();



    }


    public List<test> selectOursTest(){
        List<test> test = new ArrayList<test>();
        String selectOursTest = "com.ours.mapping.testMapper.selectOursTest";
        test =  session.selectList(selectOursTest);
        return test;
    }

    public static void main(String[] args) {
        TestDao t = new TestDao();
        List testLsit = t.selectOursTest();
        System.out.println(testLsit);
    }

}
