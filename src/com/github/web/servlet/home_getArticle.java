package com.github.web.servlet;

import com.alibaba.fastjson.JSON;
import com.github.domain.simpletext;
import com.github.domain.simpletext_article;
import com.github.service.TextService;
import com.github.service.impl.TextServiceImpl;
import com.github.service.impl.monitorServiceImpl;
import com.github.service.monitorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/homeGetArticle")
public class home_getArticle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        monitorService monitorService = new monitorServiceImpl();
        monitorService.view();
        TextService textService = new TextServiceImpl();
        List<simpletext_article> canToHomeArtivcle = textService.getCanToHomeArtivcle();
        JSON.writeJSONString(resp.getWriter(), canToHomeArtivcle);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
