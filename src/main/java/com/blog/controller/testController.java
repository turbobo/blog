package com.blog.controller;

import com.alibaba.fastjson.JSONArray;
import com.blog.pojo.Blog;
import com.blog.pojo.User;
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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    public void testAdd(HttpServletRequest req){
//    String longitude111=req.getParameter("longtitude");
//    System.out.println(longitude111);
        try {
//        在服务端进行接收的时候不能直接用参数接受，可以以流的形式来读取json字符串，再用工具类来解析json数据，如下：
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

    @ResponseBody
    @RequestMapping("/test2")
    //得到ajax的数据，参数写json数据的key值，就能得到value值
//    public void test2(HttpServletRequest req){
      public void test2(String users){   //直接获得ajax数据
//        List<User> list = Newtonsoft.Json.JsonConvert.DeserializeObject<List<User>>(textDataInfo);
        System.out.println("testController.test2------users----"+users);
        //转为json数组 jsonArray [{"id":"11111","nickname":"jack"},{"id":"22222","nickname":"jack2222"}]
        JSONArray jsonArray = JSONArray.parseArray(users);
        System.out.println("testController.test2   jsonArray"+jsonArray);
        for (int i = 0; i < jsonArray.size(); i++) {
            //3种方法都可都可以取出数组数据
//            System.out.println(i+"--get---"+jsonArray.get(i));  //0-----{"nickname":"jack","id":"11111"}
//            System.out.println(i+"---getString--"+jsonArray.getString(i));    都可以取出数组数据
            System.out.println(i+"---getJSONObject--"+jsonArray.getJSONObject(i));
            System.out.println(i+"---getJSONObject--"+jsonArray.getJSONObject(i).get("id"));

        }
//
//        0-----{"nickname":"jack","id":"11111"}
//        1-----{"nickname":"jack2222","id":"22222"}

        }

}
