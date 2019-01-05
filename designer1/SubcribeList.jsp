 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%> 
<html> 
<head>
	<title>我的历史订单</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/DIndexstyle.css">
</head>
<body class="body">

<!-- 工具集 -->
<div class="my-btn-box">
    <span class="fr">
        <div class="layui-input-inline">
            <input type="text" id="search" name="search" autocomplete="off" placeholder="请输入姓名" class="layui-input">
        </div>
        <button class="layui-btn mgl-20">查询</button>
    </span>
</div>

<!-- 表格 -->
<table class="layui-table">
<s:if test="%{#session.designer!=null}">
<thread>
<tr><td>预约项目名称</td><td>预约者姓名</td><td>预算</td><td>预约时间</td><td>操作</td></tr>
</thread>
<s:iterator value="#session.designer.subscribe">
 <tr>
 <td><s:property value="title"/></td>
 <td><s:property value="subscriber.name"/></td>
  <td><s:property value="money"/></td>
 <td><s:date name="time" format="yyyy-MM-dd HH:mm:ss"/></td>
 <td><a href="putSubscribe.action?subscribe.subscribeID=<s:property value='subscribeID'/>"  target="_blank" class="layui-btn layui-btn-mini layui-btn-normal">查看详情</a></td>
 </tr>
 </s:iterator>
 </s:if>
 <s:elseif test="%{#session.employer!=null}">
 <thread>
<tr><td>预约项目名称</td><td>设计师姓名</td><td>预算</td><td>预约时间</td><td>操作</td></tr>
</thread>
 <s:iterator value="#session.employer.subscribe">
 <tr>
 <td><s:property value="title"/></td>
 <td><s:property value="scriber.name"/></td>
  <td><s:property value="money"/></td>
 <td><s:date name="time" format="yyyy-MM-dd HH:mm:ss"/></td>
 <td><a href="putSubscribe.action?subscribe.subscribeID=<s:property value='subscribeID'/>"  target="_blank" class="layui-btn layui-btn-mini layui-btn-normal">查看详情</a></td>
 </tr>
 </s:iterator>
 </s:elseif>
</table>
</body>
</html>	