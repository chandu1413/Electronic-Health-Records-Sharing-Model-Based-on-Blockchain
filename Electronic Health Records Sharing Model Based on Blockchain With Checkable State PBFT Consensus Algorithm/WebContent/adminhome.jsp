<%@page import="com.model.RequestedUsersModel"%>
<%@page import="com.model.RegisterModel"%>
<%@page import="java.util.List"%>
<%@page import="com.configurations.AppConfig"%>
<%@page import="com.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Company Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Company - v4.9.1
  * Template URL: https://bootstrapmade.com/company-free-html-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

     
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a href="index.jsp" class="active">Home</a></li>
          <li><a href="adminhome.jsp?page=view">View Users</a></li>
          <li><a href="adminhome.jsp?page=viewf">View Hospitals</a></li>
           <li><a href="adminhome.jsp?page=viewK">View Records requests</a></li>
          <li><a href="">Logout</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

      <div class="header-social-links d-flex">
        <a href="#" class="twitter"><i class="bu bi-twitter"></i></a>
        <a href="#" class="facebook"><i class="bu bi-facebook"></i></a>
        <a href="#" class="instagram"><i class="bu bi-instagram"></i></a>
        <a href="#" class="linkedin"><i class="bu bi-linkedin"></i></i></a>
      </div>

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div id="heroCarousel" data-bs-interval="5000" class="carousel slide carousel-fade" data-bs-ride="carousel">

      <div class="carousel-inner" role="listbox">

        <!-- Slide 1 -->
        <div class="carousel-item active" style="background-image: url(assets/img/slide/slide-1.jpg);">
          <div class="carousel-container">
            <div class="carousel-content animate__animated animate__fadeInUp">
              <h2>Welcome to <span>Admin</span></h2>
              <p>Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
              <div class="text-center"><a href="" class="btn-get-started">Read More</a></div>
            </div>
          </div>
        </div>

        <!-- Slide 2 -->
        <div class="carousel-item" style="background-image: url(assets/img/slide/slide-2.jpg);">
          <div class="carousel-container">
            <div class="carousel-content animate__animated animate__fadeInUp">
                 <h2>Welcome to <span>Admin</span></h2>
              <p>Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
              <div class="text-center"><a href="" class="btn-get-started">Read More</a></div>
            </div>
          </div>
        </div>

        <!-- Slide 3 -->
        <div class="carousel-item" style="background-image: url(assets/img/slide/slide-3.jpg);">
          <div class="carousel-container">
            <div class="carousel-content animate__animated animate__fadeInUp">
                 <h2>Welcome to <span>Admin</span></h2>
              <p>Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
              <div class="text-center"><a href="" class="btn-get-started">Read More</a></div>
            </div>
          </div>
        </div>

      </div>

      <a class="carousel-control-prev" href="#heroCarousel" role="button" data-bs-slide="prev">
        <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
      </a>

      <a class="carousel-control-next" href="#heroCarousel" role="button" data-bs-slide="next">
        <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
      </a>

      <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

    </div>
  </section><!-- End Hero -->
<%
if(request.getParameter("page") !=null){
if(request.getParameter("page").equalsIgnoreCase("view")){%>

 <main id="main">

<div class="container">
<%
AdminService adminService=AppConfig.getAdminService();
List<RegisterModel> regs=adminService.getUsers();

%>
   <table class="table">
  <tr>
  <td>User Id</td>
  <td>Name</td>
  <td>Email id </td>
  </tr>
  <%
  for(RegisterModel rm:regs){%>
	  
	    <tr>
  <td><%=rm.getUserid() %></td>
  <td><%=rm.getName() %></td>
  <td><%=rm.getEmailid() %></td>
   
  </tr>
 <% }%>

   </table>

</div>
  </main>
	


<%}

if(request.getParameter("page").equalsIgnoreCase("viewf") ){ %>

<main id="main">

<div class="container">
<%
AdminService adminService=AppConfig.getAdminService();
List<RegisterModel> regs=adminService.getFUsers();

%>
  <table class="table">
 <tr>
 <td>User Id</td>
 <td>Name</td>
 <td>Email id </td>
 <td>Address</td>
 <td>Mobile</td>
 <td>Status</td>
 </tr>
 <%
 for(RegisterModel rm:regs){%>
	  
	    <tr>
 <td><%=rm.getUserid() %></td>
 <td><%=rm.getName() %></td>
 <td><%=rm.getEmailid() %></td>
 <td><%=rm.getAddress() %></td>
 <td><%=rm.getMobile() %></td>
 <%
 if(rm.getStatus()==0){%>
	
	<td><a href="Approve?userid=<%=rm.getUserid()%>">Not Approved</a></td>
	 
 <%}else{
 %>
 <td>Approved</td>
 
 <%} %>
 </tr>
<% }%>

  </table>

</div>
 </main>
	


<%}
if(request.getParameter("page").equalsIgnoreCase("viewk") ){
	AdminService adminService=AppConfig.getAdminService();
	List<RequestedUsersModel> regs=adminService.getKycRequest();
	%>
	 <table class="table">
 <tr>
 <td>Requested Id</td>
 <td>Finance Email Id</td>
 <td>User Email Id </td>
 <td>Status</td>
 </tr>
 

 <%
 for(RequestedUsersModel reg: regs){%>
	  <tr>
	  <td><%=reg.getRequestedId() %></td>
	 <td><%=reg.getFinanaceEmail() %></td>
	 <td><%=reg.getUserEmail() %></td>
	 <td><a href="approveKyc?requestId=<%=reg.getRequestedId()%>"><%=reg.getStatus() %></a></td>
	  </tr>
 
	 
 <% }
 
 %>
 
 

 
 </table>
	
	
	
<% }
}%>

 ${viewf}
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>