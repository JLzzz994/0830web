<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WEB-INF下的jsp</title>
</head>
<body>
		<h1>success</h1>
		
		<h1>${sessionScope.un }</h1>
		
		<hr>
		<h1>从page域取</h1>
		<h2>${pageScope.map }</h2>
		<h2>${pageScope.model }</h2>
		<h2>${pageScope.modelMap }</h2>
		<h2>${pageScope.modelAndView }</h2>
		<hr>
		<h1>从request域取</h1>
		<h2>${requestScope.map }</h2>
		<h2>${requestScope.model }</h2>
		<h2>${requestScope.modelMap }</h2>
		<h2>${requestScope.modelAndView }</h2>
		<hr>
		<h1>从session域取</h1>
		<h2>${sessionScope.map }</h2>
		<h2>${sessionScope.model }</h2>
		<h2>${sessionScope.modelMap }</h2>
		<h2>${sessionScope.modelAndView }</h2>
		<h2>${sessionScope.session }</h2>
		<h1>从application域取</h1>
		<h2>${applicationScope.map }</h2>
		<h2>${applicationScope.model }</h2>
		<h2>${applicationScope.modelMap }</h2>
		<h2>${applicationScope.modelAndView }</h2>
		<h2>${applicationScope.application }</h2>

</body>
</html>