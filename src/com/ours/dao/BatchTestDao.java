package com.ours.dao;


import com.ours.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchTestDao {

    private SqlSession session;

    public BatchTestDao() {
        session = MyBatisUtil.getSqlSession();
    }


    public void insertBatchTest(List<Map<String, String>> paramsList) {
        String insertBatchTest = "com.ours.mapping.batchTestMapper.insertBatchTest";

        session.insert(insertBatchTest, paramsList);
        session.commit();


    }


    public static void main(String[] args) {

        List<Map<String, String>> paramsList = new ArrayList<>();
        Map<String, String> paramsMap = null;

        for (int i = 1; i < 50; i++) {
            paramsMap = new HashMap();
            paramsMap.put("username", "name" + i);
            paramsMap.put("userage", "age" + i);
            paramsList.add(paramsMap);
        }



        BatchTestDao t = new BatchTestDao();
        t.insertBatchTest(paramsList);

    }

}
