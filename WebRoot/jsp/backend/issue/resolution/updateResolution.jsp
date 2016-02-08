<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nastation.pm.util.*"%>
<%@ page import="com.nastation.pm.bean.*"%>
<%@ page import="com.nastation.pm.business.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>
	<%
		String idStr = request.getParameter("id");
		int id = 0;
		if (StringUtils.isNotBlank(idStr)) {
			id = Integer.parseInt(idStr);
		}
		ResolutionBO resolutionBO = new ResolutionBO();
		Resolution resolution = resolutionBO.getResolution(id);
	%>

	<body>
		<%@include file="/jsp/showErrorMessage.jsp"%>
		<form action="doUpdateResolution.jsp" method="post">
			<table class="simpleform maxWidth">
				<tbody>
					<tr>
						<td class="simpleformheader" colspan="2">
							<h3 class="formtitle">
								Edit Resolution:
								<%=resolution.getName()%>
							</h3>
						</td>
					</tr>
					<tr>
						<td class="fieldLabelArea">
							名称:
						</td>
						<td class="fieldValueArea" bgcolor="#ffffff">
							<input type="text" value="<%=resolution.getName()%>" size="30"
								name="name" />
						</td>
					</tr>
					<tr>
						<td class="fieldLabelArea">
							描述:
						</td>
						<td class="fieldValueArea" bgcolor="#ffffff">
							<input type="text" value="<%=resolution.getDescription()%>"
								size="60" name="description" />
						</td>
					</tr>
					<tr class="hidden">
						<td>
							<input id="id" type="hidden" value="<%=resolution.getId()%>"
								name="id" />
							<input id="isDefault" type="hidden"
								value="<%=resolution.getIsDefault()%>" name="isDefault" />
						</td>
					</tr>
					<tr>
						<td class="fullyCentered simpleformfooter" colspan="2">
							<input id="更新" class="spaced" type="submit" title="按 Alt+S 提交"
								accesskey="S" value="更新" name="更新" />
							<input id="cancelButton" type="button"
								onclick="location.href='viewResolutions.jsp'" value="取消"
								title="取消 (Alt + `)" accesskey="`" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>
