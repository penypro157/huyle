<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JuniePC
  Date: 22/12/17
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
    <script language="javascript" src="/resources/js/comment.js"></script>
</head>
<body>


    <c:forEach items="${productList}" var="product"><br>
        ${product.categoryEntity.name}<br>
        <img src="/resources/image/${product.photo}" alt="" ><br>
          <a href="/detail?id=${product.id}" >${product.name}</a> <br>
       ${product.description}<br>
       ${product.price}<br>
        ${product.warranty}<br>




    </c:forEach>

</form>
</body>
</html>
