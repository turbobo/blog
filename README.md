# Spring Boot个人博客项目随笔

> **作者：朱一鸣** 
>
> **qq：691639910**

项目参照b站李仁密老师的Spring Boot开发小而美的个人博客。

**把持久层修改为了mybatis**，可以作为刚学完springboot的练习项目。

目录中有blog.sql文件，可以直接执行生成对应的数据库和表 

功能：**前端展示 + 后台管理**，**添加了萌萌的看板娘**

博客地址：**http://www.zhuyiming.top/**

**技术组合：**

*  后端：Spring Boot + mybatis 
*  数据库：MySQL
*  前端UI：Semantic UI框架 + thymeleaf模板

**工具与环境：**

*  IDEA
*  Maven 3.6.2
*  JDK 12
*  springboot 2.2.5

**运行：**

*  直接在数据库运行blog.sql生成数据库文件
*  在dev.xml或pro.xml中修改数据连接信息
*  在dev.xml或pro.xml中加入启动端口号  server: port: 8089






