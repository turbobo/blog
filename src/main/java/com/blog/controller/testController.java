package com.blog.controller;

import com.blog.pojo.Blog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/testController")
public class testController {

    //@ResponseBody注释说明返回的信息不是要跳转到的页面，而是作为数据写回ResponseBody中
    //这里的返回值就是ajax中success后得到的值
    @ResponseBody
    @RequestMapping("/testAdd")
    //得到ajax的数据，参数写json数据的key值，就能得到value值
    public void login(HttpServletRequest req){
//    String longitude111=req.getParameter("longtitude");
//    System.out.println(longitude111);
    try {
//        在服务端进行接收的时候不能直接用参数接受，可以以流的形式来读取json字符串，在用工具类来解析json数据，如下：
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuffer sb=new StringBuffer();
        String s=null;
        while((s=br.readLine())!=null){
            sb.append(s);
        }
        System.out.println("testController.login -----sb类型------"+sb+"    "+sb.getClass().getName().toString());
        String[] str=sb.toString().split("&");
        System.out.println("testController.login str-----------"+str);
        System.out.println("testController.login str-----------"+str[0]);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
