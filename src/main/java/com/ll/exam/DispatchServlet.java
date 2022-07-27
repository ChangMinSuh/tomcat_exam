package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.member.MemberController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        Rq rq = new Rq(req, res);

        MemberController memberController = new MemberController();
        ArticleController articleController = new ArticleController();

        switch (rq.getMethod()) {
            case "GET":
                switch (rq.getActionPath()) {
                    case "/usr/article/detail" -> articleController.showDetail(rq);
                    case "/usr/article/list" -> articleController.showList(rq);
                    case "/usr/article/write" -> articleController.showWrite(rq);
                    case "/usr/member/login" -> memberController.showLogin(rq);
                }
                break;
            case "POST":
                switch (rq.getActionPath()) {
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        doGet(req, res);
    }
}
