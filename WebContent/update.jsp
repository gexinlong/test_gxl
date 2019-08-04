<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改学生班级信息表</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改学生班级信息表</h3>
        <form action="${pageContext.request.contextPath }/UpdateServlet" method="post">
        	<input type="hidden" value="${stu.id }" name = "id"> 
        	 <div class="form-group">
	            <label for="email">学号：</label>
	            <input type="text" class="form-control" value="${stu.xuehao }" name="xuehao" placeholder="请输入学号"/>
         	 </div>
	         <div class="form-group">
	            <label for="name">姓名：</label>
	            <input type="text" class="form-control" value="${stu.name }" id="name" name="name"  placeholder="请输入姓名" />
	         </div>

          <div class="form-group">
            <label>性别：</label>
           		 <c:if test="${stu.sex == '男' }">
	              	<input type="radio" name="sex" value="男"  checked="checked"/>男
	                <input type="radio" name="sex" value="女"  />女
                </c:if>
                 <c:if test="${stu.sex == '女' }">
	              	<input type="radio" name="sex" value="男" />男
	                <input type="radio" name="sex" value="女"  checked="checked" />女
                </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${stu.age }" id="age"  name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for=""cname"">班级：</label>
            <input type="text" class="form-control" value="${stu.cname }" name="cname" placeholder="请输入班级"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
             </div>
        </form>
        </div>
    </body>
</html>