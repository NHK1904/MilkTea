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
        <link href="css/Detail.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="Menu.jsp" %>

        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="container">
                    <div class="card">
                        <div class="container-fliud">
                            <div class="wrapper row">
                                <div class="preview col-md-6">

                                    <div class="preview-pic tab-content">
                                        <div class="tab-pane active" id="pic-1"><img src="${detail.getImage()}" /></div>
                                    </div>
                                    

                                </div>
                                <div class="details col-md-6">
                                    <h3 class="product-title">${detail.getName()}</h3>
                                    <div class="rating">
                                        <div class="stars">
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star"></span>
                                            <span class="fa fa-star"></span>
                                        </div>
                                        <span class="review-no">${detail.getTitle()}</span>
                                    </div>
                                    <p class="product-description">${detail.getDes()}</p>
                                    <h4 class="price">Price: <span>$${detail.getPrice()}</span></h4>
                                    <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
                                    
                                    <div class="action">
                                        <button class="add-to-cart btn btn-default" type="button">add to cart</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="Footer.jsp" %>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
