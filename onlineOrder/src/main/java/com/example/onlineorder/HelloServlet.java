package com.example.onlineorder;
import com.example.onlineorder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import org.apache.commons.io.IOUtils; // get raw data and convert it to json

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");// 返回数据类型： json
    ObjectMapper mapper = new ObjectMapper();

    Customer customer = new Customer();

    customer.setFirstName("Rick");
    customer.setLastName("Sun");
    response.getWriter().println(mapper.writeValueAsString(customer));
//
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        JSONObject obj = new JSONObject(IOUtils.toString(request.getReader())); // 读取request body data

        String lastName= obj.getString("last_name");
        int age = obj.getInt("age");
        String email = obj.getString("email");

        System.out.println("Email is: " + email);
        System.out.println("Age is: " + age);
        System.out.println("Last name is: " + lastName);





    }
    public void destroy() {
    }
}