<%--
   Description:Update a permission scheme.
   Author:Sun Chongyang 
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.nastation.pm.business.*"%>
<%@ page import="com.nastation.pm.bean.*"%>
<%@ page import="com.nastation.pm.util.*"%>
<%@ page import="com.nastation.pm.beanhbm.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3>
                    &quot;Edit Permission Scheme:
                    <s:property value="name" />
                </h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12"></div>
        </div>
    </div>
    <%@include file="/jsp/showErrorMessage.jsp"%>
    <form name="simpleform" method="post" action="doUpdatePermissionScheme.jsp" class="bs-example bs-example-form" role="form" />
    <div class="input-group">
        <span class="input-group-addon">名称</span>
        <input type="text" value="<s:property value="name"/>" size="30" name="name" class="form-control" placeholder="name" />
    </div>
    <div class="input-group">
        <span class="input-group-addon">描述</span>
        <textarea wrap="virtual" name="description" class="form-control" placeholder="description"><s:property value="desc"/></textarea>
    </div>
    <input id="schemeId" type="hidden" value="<s:property value="schemeId"/>" name="schemeId" />
    <input id="更新" class="btn btn-info btn-block" type="submit" title="按 Alt+S 提交" accesskey="S" value="更新" name="更新" />
    <input id="cancelButton" type="button" onclick="location.href='viewPermissionSchemes.jsp'" value="取消" title="取消 (Alt + `)" accesskey="`" class="btn btn-warning btn-block" />
    </form>
</body>
</html>