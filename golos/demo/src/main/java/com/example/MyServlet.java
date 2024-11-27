package com.example;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // Установка кодировки
        final PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (password.length() < 8) {
            request.setAttribute("errorMessage", "Пароль должен содержать больше 8 символов");
            request.getRequestDispatcher("reg.jsp").forward(request, response);
            return;
        }
        try {
            DBEditor.addendum(password,name,email);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		out.print("<div>" + "Поздравляем,ваш голос учтён" + "</div>");
        MyJavaClass.processData(name);
        MyJavaClass.processData(email);
        MyJavaClass.processData(password);


    }

    public static class MyJavaClass {
            public static void processData(String data) {
    
            System.out.println("Полученные данные: " + data);
        }
    }


 



}

