<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="室内装修设计交易平台" />
<meta name="description" content="装修招标,设计本装修、装饰、招标网,设计本免费提供新的家装、公装设计装修招标信息。" />
<link href="https://stc.shejiben.com/css/global.css?20181112" rel="stylesheet" type="text/css" />
<link href="https://static.shejiben.com/common/widgets/ui/float_tool.css?20181112" rel="stylesheet" type="text/css" />
<link href="https://stc.shejiben.com/css/sjs/common.css?20181112" rel="stylesheet" type="text/css" />
<link href="https://stc.shejiben.com/css/sjs/userCenter.css" rel="stylesheet" type="text/css" />
<link href="https://stc.shejiben.com/css/sjs/userCenter.css" rel="stylesheet" type="text/css" />

<link href="css/needlist_style.css" rel="stylesheet" type="text/css" media="all" />


<link type="text/css" rel="stylesheet" href="css/common.css" />
 <link href="css/bootstrap3.css" rel="stylesheet">
    <link href="css/bootstrap-responsive3.css" rel="stylesheet">
	
	<!-- Extra Styles, not needed for Mega Menu or Boostrap -->
	<link href="css/style3.css" rel="stylesheet">
	
	<!-- Mega Menu Style, you kinda really need Bootstrap in order for this to work -->
	<link href="css/mega-menu3.css" rel="stylesheet">

<script  type="text/javascript" src="https://stc.shejiben.com/gb_js/sea.js"></script>
<script type="text/javascript">
    seajs.config({
        alias : {
            'jquery': 'https://stc.shejiben.com/gb_js/jquery_module.js',  //jquery version must be 1.7x
            'common': 'https://stc.shejiben.com/gb_js/main.js?20181109',
            'form': 'https://stc.shejiben.com/gb_js/module.form.js?20181109',
            'ui': 'https://stc.shejiben.com/gb_js/module.ui.js',
            'colorbox': 'https://stc.shejiben.com/gb_js/jquery.colorbox.min.js?20181109',
            'newHeader': 'https://stc.shejiben.com/gb_js/sjsCenter/userCenter.js?20181109'
        },
        preload : ['jquery', 'common']  //预加载jquery和main.js
    });
</script>
<title>需求列表</title>
</head>
<body>




<header class="container" >
	
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner" style="height: 60px;"> 
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					</a>
					
						<div class="nav-collapse collapse">
							<ul class="nav">
							
							<li><a href="index.jsp">首页</a></li>
						<li><a href="findall.action">看案例</a></li>
						<li><a href="findneeds">找需求</a></li>
								
								<li><a href="4menus.htm">论坛</a></li>
								<li><a href="styles.htm">装修攻略</a></li>
								<s:if test="%{#session.id==null}"> 
							<li><a href="login.jsp">登陆</a></li>
							<li><a href="contact.html">注册</a></li>
						</s:if>
						<s:else>
							<li><a href="judge.action" target="_Blank">个人主页</a><li>
						</s:else>
							</ul>
						</div><!--/.nav-collapse -->
				</div><!-- Container -->
			</div><!-- Nav Bar - Inner -->
		</div><!-- Nav Bar -->
	
	</header><!-- /container -->









<div class="dmato"></div><div class="content_width" id="content">
<div class="content_width ">
<script type="text/javascript">
seajs.use(['newHeader','common'], function( Header,common) {
    $(document).ready(function() {
        Header.init();
        common.initHeader();
    });
});
</script>

<div class="content order_lobby">
  <div class="selec_ele">
    <form action="./findneeds">
      <div class="sele selec_city">
        <label>所在城市：</label>
        <div>
          <a href="./findneeds" class="cur" style="margin-left: 15px;">不限</a>
          <s:textfield name="city" value="%{#request.city}"/>
          <s:submit value="搜索" style="position: absolute;

left: 400px;

top: 40px;

width: 50px;

height: 30px;

font-size: 12px;"/>
        </div>
      </div>

      <div class="sele selec_area">
            <label>项目面积：</label>
            <div>
               <s:if test="#request.area0==0 && #request.area1==0">
                 <a href="./findneeds?area0=0&area1=0&city=${city}&money0=${money0}&money1=${money1}" class="cur" style="margin-left: 15px;">不限</a>
               </s:if>
               <s:else>
                <a href="./findneeds?area0=0&area1=0&city=${city}&money0=${money0}&money1=${money1}" class="" style="margin-left: 15px;">不限</a>
               </s:else>
               
               <s:if test="#request.area0==0 && #request.area1==50">
                 <a href="./findneeds?area0=0&area1=50&city=${city}&money0=${money0}&money1=${money1}" class="cur" style="margin-left: 15px;">0-50平米</a>
               </s:if>
               <s:else>
                 <a href="./findneeds?area0=0&area1=50&city=${city}&money0=${money0}&money1=${money1}" class="" style="margin-left: 15px;">0-50平米</a>
               </s:else>
               
               <s:if test="#request.area0==50 && #request.area1==100">
                 <a href="./findneeds?area0=50&area1=100&city=${city}&money0=${money0}&money1=${money1}" class="cur" style="margin-left: 15px;">50-100平米</a>
               </s:if>
               <s:else>
                 <a href="./findneeds?area0=50&area1=100&city=${city}&money0=${money0}&money1=${money1}" class="" style="margin-left: 15px;">50-100平米</a>
               </s:else>
               
               <s:if test="#request.area0==100 && #request.area1==150">
                 <a href="./findneeds?area0=100&area1=150&city=${city}&money0=${money0}&money1=${money1}" class="cur" style="margin-left: 15px;">100-150平米</a>
               </s:if>
               <s:else>
                 <a href="./findneeds?area0=100&area1=150&city=${city}&money0=${money0}&money1=${money1}" class="" style="margin-left: 15px;">100-150平米</a>
               </s:else>
               
               <s:if test="#request.area0==150 && #request.area1==200">
                 <a href="./findneeds?area0=150&area1=200&city=${city}&money0=${money0}&money1=${money1}" class="cur" style="margin-left: 15px;">150-200平米</a>
               </s:if>
               <s:else>
                 <a href="./findneeds?area0=150&area1=200&city=${city}&money0=${money0}&money1=${money1}" class="" style="margin-left: 15px;">150-200平米</a>
               </s:else>
               
               <s:if test="#request.area0==200 && #request.area1==0">
                 <a href="./findneeds?area0=200&area1=0&city=${city}&money0=${money0}&money1=${money1}" class="cur" style="margin-left: 15px;">200平米以上</a>
               </s:if>
               <s:else>
                 <a href="./findneeds?area0=200&area1=0&city=${city}&money0=${money0}&money1=${money1}" class="" style="margin-left: 15px;">200平米以上</a>
               </s:else>
            </div>
        </div>
        
        <div class="sele selec_budget">
            <label>设计预算：</label>
            <div>
             <s:if test="#request.money0==0 && #request.money1==0">
               <a href="./findneeds?money0=0&money1=0&city=${city}&area0=${area0}&area1=${area1}"  class="cur" rel="nofollow" style="margin-left: 15px;">不限</a>
             </s:if>
             <s:else>
               <a href="./findneeds?money0=0&money1=0&city=${city}&area0=${area0}&area1=${area1}" class="" rel="nofollow" style="margin-left: 15px;">不限</a>
             </s:else>  
             
             <s:if test="#request.money0==0 && #request.money1==5000">
               <a href="./findneeds?money0=0&money1=5000&city=${city}&area0=${area0}&area1=${area1}" class="cur" rel="nofollow" style="margin-left: 15px;">5000以下</a>
             </s:if>
             <s:else>
               <a href="./findneeds?money0=0&money1=5000&city=${city}&area0=${area0}&area1=${area1}" class="" rel="nofollow" style="margin-left: 15px;">5000以下</a>
             </s:else>
             
             <s:if test="#request.money0==5000 && #request.money1==10000">
               <a href="./findneeds?money0=5000&money1=10000&city=${city}&area0=${area0}&area1=${area1}" class="cur" rel="nofollow" style="margin-left: 15px;">5000-10000元</a>
             </s:if>  
             <s:else>
               <a href="./findneeds?money0=5000&money1=10000&city=${city}&area0=${area0}&area1=${area1}" class="" rel="nofollow" style="margin-left: 15px;">5000-10000元</a>
             </s:else>
             
             <s:if test="#request.money0==10000 && #request.money1==50000">
               <a href="./findneeds?money0=10000&money1=50000&city=${city}&area0=${area0}&area1=${area1}" class="cur" rel="nofollow" style="margin-left: 15px;">10000-50000元</a>
             </s:if>
             <s:else>
               <a href="./findneeds?money0=10000&money1=50000&city=${city}&area0=${area0}&area1=${area1}" class="" rel="nofollow" style="margin-left: 15px;">10000-50000元</a>
             </s:else>
              
             <s:if test="#request.money0==50000 && #request.money1==100000">
               <a href="./findneeds?money0=50000&money1=100000&city=${city}&area0=${area0}&area1=${area1}" class="cur" rel="nofollow" style="margin-left: 15px;">50000-100000</a>
             </s:if>
             <s:else>
               <a href="./findneeds?money0=50000&money1=100000&city=${city}&area0=${area0}&area1=${area1}" class="" rel="nofollow" style="margin-left: 15px;">50000-100000</a>
             </s:else>
             
             <s:if test="#request.money0==100000 && #request.money1==0">
               <a href="./findneeds?money0=100000&money1=0&city=${city}&area0=${area0}&area1=${area1}" class="cur" rel="nofollow" style="margin-left: 15px;">100000元以上</a>
             </s:if>
             <s:else>
               <a href="./findneeds?money0=100000&money1=0&city=${city}&area0=${area0}&area1=${area1}" class="" rel="nofollow" style="margin-left: 15px;">100000元以上</a>
             </s:else>
            </div>
        </div>
        </form>
    </div>
    
    <div class="selec_sort">
        <div class="selec_s_">
           <a href="./findneeds?order=1&city=${city}&area0=${area0}&area1=${area1}&money0=${money0}&money1=${money1}" class="cur">发布时间<span></span></a>
           <a href="./findneeds?order=2&city=${city}&area0=${area0}&area1=${area1}&money0=${money0}&money1=${money1}" class="">总面积<span></span></a>
        </div>
    </div>
    
    <div class="prod_list">
        <div class="list_" style="width: 1000px;">        
             <s:iterator value="needs1" id="needs"> 
              <div class="list_info" style="width: 260px;

display: inline-block;">
                <div class="_info" style="width: 200px;

display: inline-block;">
                    <div><a href="./needsByID?needsId=${needs.needsId}" target="_blank"><s:property value="#needs.title"/></a>
                         <span class="price"><s:property value="#needs.money"/></span></div>
                         <a href="./needsByID?needsId=${needs.needsId}" style="margin-left: 800px;font-size:14px">查看详情</a>
                    <div class="jc_info">
                        <span style="padding-left:0;"><s:property value="#needs.city"/></span>                     
                        <span><s:property value="#needs.area"/>500m²</span>
                         <span>简约</span><span>杭州</span>
                        <span style="border-right:none;"><s:date name="%{#needs.time1}" format="yyyy-MM-dd HH:mm:ss"/></span>
                    </div>
                </div>
                <div class="btne apply_index"></div>
            </div>     
            </s:iterator>                                
            <div class="page">
			</div>                   
	    </div>
    </div>
</div>


</div></div>
</body>
</html>