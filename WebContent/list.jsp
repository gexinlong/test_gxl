<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生班级信息管理</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script type="text/javascript">
    	function delStu(id){
    	    var flag = confirm("确定删除？")
    		if(flag){
    			location.href = "${pageContext.request.contextPath}/DelServlet?id="+id;
    		} 
    	}
    	 window.onload=function(){
       	  document.getElementById("delSelected").onclick = function(){
       		  var flag = false;
   				var cbs = document.getElementsByName("cb");
   				
   				for(var i=0;i<cbs.length;i++){
   					if(cbs[i].checked){ 
   						flag=true;
   						break;
   					}
   				}
   				if(flag){
   					if(confirm("确定要删除选中的条目码?")){
   		        		 $("form").submit();
   					}
   				}
       	  }
     		document.getElementById("firstCb").onclick=function(){
     			var cbs = document.getElementsByName("cb");
     			for(var i=0;i<cbs.length;i++){
     				cbs[i].checked = this.checked;
     			}
     		}
         }
         
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">学生班级信息表</h3>
    
    <div style="float: left; margin: 5px">
    	 <form action="">
    	 
    	 </form>
         <a class="btn btn-primary" href="add.jsp">添加学生班级</a>
         <a class="btn btn-primary" href="javascript:void(0)" id="delSelected">删除选中</a>
    </div>
    
    <form action="${pageContext.request.contextPath }/DelAllServlet">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
        	<th><input type="checkbox" id="firstCb"></th> 
            <th>编号</th>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>班级</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pb.list }" var="stu" varStatus="vs">
	        <tr>
	        	<td><input type="checkbox" name="cb" value="${stu.id }"></td>
	            <td>${vs.count}</td>
	            <td>${stu.xuehao }</td>
	            <td>${stu.name }</td>
	            <td>${stu.sex }</td>
	            <td>${stu.age }</td>
	            <td>${stu.cname }</td>
	            <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath }/FindStuUser?id=${stu.id}">修改</a>&nbsp;
	            <a class="btn btn-default btn-sm" href="javascript:delStu('${stu.id }')">删除</a></td>
	        </tr>
        </c:forEach>
    </table>
    </form>
    <div>
    	<nav aria-label="Page navigation">
		  <ul class="pagination">
		  <!-- 对第一页做处理 -->
		  	<c:if test="${pb.currentPage == 1 }">
		    	<li class="disabled">
		    	<a href="${pageContext.request.contextPath }/SelectByPageServlet?currentPage=${pb.currentPage-1}&rows=5" aria-label="Previous">
		       		 <span aria-hidden="true">&laquo;</span>
		     	 </a>
		   		</li>
		    </c:if>
		    <c:if test="${pb.currentPage != 1 }">
		    	<li>
		    		<a href="${pageContext.request.contextPath }/SelectByPageServlet?currentPage=${pb.currentPage-1}&rows=5" aria-label="Previous">
		       		 	<span aria-hidden="true">&laquo;</span>
		     	 	</a>
		   		</li>
		   </c:if>
		    <!-- 遍历页数 -->
		    <c:forEach begin="1" end="${pb.totalPage }" var="i">
		    	<c:if test="${pb.currentPage == i }">
		   	 		<li class="active"><a href="${pageContext.request.contextPath }/SelectByPageServlet?currentPage=${i}&rows=5">${i }</a></li>
		   		 </c:if>
		   		 
		   		 <c:if test="${pb.currentPage != i }">
		   	 		<li><a href="${pageContext.request.contextPath }/SelectByPageServlet?currentPage=${i}&rows=5">${i }</a></li>
		   		 </c:if>
		    </c:forEach>
		    
		    <!--对最后一页做处理  -->
		<c:if test="${pb.currentPage == pb.totalPage }">
			   <li class="disabled">
			      <a href="${pageContext.request.contextPath }/SelectByPageServlet?currentPage=${pb.totalPage}&rows=5" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		    
		    <c:if test="${pb.currentPage != pb.totalPage }">
			   <li>
			      <a href="${pageContext.request.contextPath }/SelectByPageServlet?currentPage=${pb.currentPage+1}&rows=5" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		    <span style="font-size: 25px;margin-left: 5px;">
		    	共${pb.totalCount }条记录,共${pb.totalPage }页
		    </span>
		  </ul>
		</nav>
    </div>

</div>

</body>
</html>
