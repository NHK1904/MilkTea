<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Product" %>


<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/newcss.css" rel="stylesheet" />

    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div id="content" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach items="${data}" var="item">
                        <div class="col mb-5" >
                            <div class="card h-100">
                                <!-- Product image-->
                                <img class="card-img-top" src="${item.getImage()}" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="card-title show_txt"><a href="detail?pid=${item.getId()}" title="View Product">${item.getName()}</a></h5><br>
                                        <!-- Product price-->
                                        $${item.getPrice()} 
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">ADD</a></div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </section>
        <%@include file="Footer.jsp" %>        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            function searchByName(param){
                            var txtSearch = param.value;
                            $.ajax({
                                url: "/Assignment_SE1718_khangnhhe163895/search",
                                type: "get", //send it through get method
                                data: {
                                    txt: txtSearch
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML = data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
        </script>   
    </body>
</html>
