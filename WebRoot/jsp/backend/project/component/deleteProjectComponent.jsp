<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page import="com.nastation.pm.business.*"%>
<%@ page import="com.nastation.pm.bean.*"%>
<%@ page import="com.nastation.pm.beanhbm.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div style="border: 1px solid rgb(187, 187, 187); padding: 2px;">
    <table>
        <tr>
            <td colspan="2">
                <h3 class="formtitle">
                    Delete Component:
                    <s:property value="name" />
                </h3>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <p>Confirm that you want to delete this component, and specify what is to be done with the issues currently attached to it.</p>
                <p>Deleting this component will not alter any issues, as there are 0 issues associated with it.</p>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" class="spaced" title="按 Alt+S 提交" accesskey="S" onclick="location.href='<c:url value="/jsp/backend/project/component/doDeleteProjectComponent.jsp"/>?projectId=<s:property value="id"/>&idd=<s:property value="iid"/>'" value="Delete" id="删除" name="删除" />
                <input type="button" onclick="location.href='<c:url value="/jsp/backend/project/viewProjectDetail.jsp"/>?projectId=<s:property value="id"/>'" value="取消" title="取消 (Alt + `)" accesskey="`" id="cancelButton" />
            </td>
        </tr>
    </table>
</div>