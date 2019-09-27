<%@ page language="java" contentType="text/html; charset=UTF-8"
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新留言</title>
<link href="./bootstrap4/css/bootstrap.min.css" rel="stylesheet"><!-- 加载jquery -->
<script type="text/javascript" src="./js/jquery-3.4.0.js"></script>
<script type="text/javascript" src="./bootstrap4/js/bootstrap.min.js"></script><!-- 加载结束 -->
<style>
	.img1{
		height:300px;
	}
	.f1{
		font-size:20px;
		color:#005182;
	}
	.f2{
		font-size:22px;
	}
	span{
		color:#eeaa33;
		font-size:37px;
	}
	.text1{
		width:200px;
		height:60px;
	}
	table{
		width:300px;
		height:150px;
	}
	a{
		margin:0 5px
	}
</style>

</head>
<body>
<script>
function checkNull(form){
	if(form.note_title.value==""){
		alert("请输入title");
		form.note_title.focus();
		return false;
	}
	if(form.note_content.value==""){
		alert("请输入content");
		form.note_content.focus();
		return false;
	}
	return true;
}
</script>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
%>
<center>
<% if(session.getAttribute("username")!=null){%>
<img src="images/images1.jpg" width="100%" height="80px">
<p><span>JSP学习论坛留言板</span></p>
<hr>
<form action="../insertNotes" method="post" onsubmit="return checkNull();">
	<table border=0>
		<tr>
		<td colspan=2>添加新留言</td>
		</tr>
		<tr>
			<th class="f1">标题:</th>
			<td>&nbsp;<input type="text" name="note_title"></td>
		</tr>
		<tr>
			<th class="f1">内容:</th>
			<td>&nbsp;<textarea rows="8" cols="29"  name="note_content"></textarea></td>
			<!-- <td>&nbsp;<input class="text1" type="text" name="note_content"></td> -->
		</tr>
		<tr>
			<td colspan=2><center>
				<input type="submit" value="发送">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置">
			</center></td>
		</tr>
	</table>
	<a href="list_notes1.jsp" class="f2">返回留言表页面</a>
</form>
<% }else{%>
<img src="images/images1.jpg" width="100%" height="80px">
<hr>
	<!-- 用户未登陆，提示用户登录并跳转（自动刷新页面） -->
	<p>用户未登陆，将在30秒后自动跳转登录页面。<br>
	您也可以点击<a href=login.htm>点此链接</a>跳转登录页面！</p>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-12">
					<div class="carousel slide" id="carousel-574400">
						<ol class="carousel-indicators">
							<li data-slide-to="0" data-target="#carousel-574400" class="active">
							</li>
							<li data-slide-to="1" data-target="#carousel-574400">
							</li>
							<li data-slide-to="2" data-target="#carousel-574400">
							</li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="d-block w-100 img1" alt="Carousel Bootstrap First" src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg" />
								<div class="carousel-caption">
									<h4>
										经典语录一：
									</h4>
									<p>
										人生苦短，必须精彩，活出个样来给自己看！走出风雨的人生，方见彩虹！让短暂的人生留有星豆之光！
									</p>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100 img1" alt="Carousel Bootstrap Second" src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg" />
								<div class="carousel-caption">
									<h4>
										经典语录二：
									</h4>
									<p>
										真正成功的人生，不在于成就的大小，而在于你是否努力地去实现自我，喊出自己的声音，走出属于自己的道路。
									</p>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block w-100 img1" alt="Carousel Bootstrap Third" src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg" />
								<div class="carousel-caption">
									<h4>
										经典语录三：
									</h4>
									<p>
										生活处处有困难，个子高的老撞头，个子矮的惹人笑，有钱的招红眼，没钱的招冷眼，我一正常年轻帅小伙，什么挫折不能过。
									</p>
								</div>
							</div>
						</div> <a class="carousel-control-prev" href="#carousel-574400" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-574400" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	<%response.setHeader("refresh", "30;URL=login.htm");
}%>
<script type="text/javascript">
$('.carousel').carousel({
	interval:2000,
	pause:false
})
</script>
</center>
</body>
</html>