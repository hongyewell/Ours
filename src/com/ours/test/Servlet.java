package com.ours.test;

import com.google.gson.Gson;
import com.ours.dao.TestDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("hello world");
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        TestDao t = new TestDao();

        if (type.equals("post")){
            String title = request.getParameter("title");
            String  content = request.getParameter("content");

            t.insertOursTest(title,content);
            System.out.println("content----"+content);
        }else {
            List testList =  t.selectOursTest();
            response.setContentType("text/html; charset=utf-8");
            Gson gson = new Gson();
            String testJson =  gson.toJson(testList);
            PrintWriter pw = response.getWriter();
            pw.write(testJson);
            System.out.println(testJson);


        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
