package com.github.web.adminservlet;

import com.alibaba.fastjson.JSON;
import com.github.domain.simpletext;
import com.github.domain.simpletext_article;
import com.github.service.TextService;
import com.github.service.impl.TextServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/passarticle")
public class passarticle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int textid = Integer.parseInt(req.getParameter("textid"));
        TextService textService = new TextServiceImpl();
        textService.addHomearticle(textid);

        List<simpletext_article> canToHomeArtivcle = textService.getCanToHomeArtivcle();
        JSON.writeJSONString(resp.getWriter(), canToHomeArtivcle);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
