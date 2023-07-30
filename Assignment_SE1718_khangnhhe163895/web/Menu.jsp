<%-- 
    Document   : Menu
    Created on : Mar 16, 2023, 10:19:36 PM
    Author     : khang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" />

    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">MILK TEA</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="home">Home</a></li>
                            <c:if test="${sessionScope.acc == null}">
                            <li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acc != null}">
                            <li class="nav-item"><a class="nav-link" href="">${sessionScope.acc.user}</a></li>
                            <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                            </c:if>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="all" >All</a></li>
                                    <c:forEach items="${cate}" var="item">
                                    <li><a class="dropdown-item" href="category?cid=${item.getCid()}">${item.getCname()}</a></li>
                                    </c:forEach>
                            </ul>z  
                        </li>
                        <c:if test="${sessionScope.acc != null}">
                            <li class="nav-item"><a class="nav-link" href="manager">Manager Product</a></li>
                            </c:if>
                    </ul>
                    <form class="d-flex" action="newsearch" method="get">
                        <input oninput="searchByName(this)" class="form-control me-2" type="search" name="txt" placeholder="Tìm kiếm" aria-label="Tìm kiếm">
                    </form>
                    <form class="d-flex">
                        <!--                        <input type="text" name="name">
                                                <input type="submit" value="Search">-->
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5" >
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">MILK TEA</h1>
                    <p class="lead fw-normal text-white-50 mb-0"></p>
                </div>
            </div>
        </header>
    </body>
</html>
