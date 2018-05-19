<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp" />
<body>
<div class="container" style="margin-top: 60px;">
    <div class="col-md-4">
        <%--@elvariable id="location" type=""--%>
        <form:form action="#" method="get" modelAttribute="location">
            <div class="form-group">
                <label class="control-label">Latitude</label>
                <form:input path="lat" type="text" class="form-control"/>
            </div>
            <div class="form-group">
                <label class="control-label">Longitude</label>
                <form:input path="lon" type="text" class="form-control"/>
            </div>
        </form:form>
    </div>

    <div class="col-md-4">
        <div id="googleMap" style="width:500px;height:380px;"></div>
    </div>
</div>
</body>
</html>
