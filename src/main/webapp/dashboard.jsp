<%@ page session="true" %>
<%@ page import="MODEL.OTTPlatform" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<!-- Navigation Bar -->
<div class="navbar">
    <div class="logo">Subscription System</div>
<ul class="nav-links">       
 <li><a href="index.html">Home</a></li>
        <li><a href="currentplan.jsp">Current Plans</a></li>
        <li><a href="login.html">Logout</a></li>
    </ul>
</div>

<!-- Dashboard Content -->
<div class="dashboard">
    <h2>Select OTT Platform</h2>
<!-- Ã°ÂÂÂ´ ERROR MESSAGE (ONLY SHOWS WHEN SET FROM CONTROLLER) -->
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red; font-weight:bold; margin-bottom:15px;">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>
    <!-- <div class="ott-container">

        Netflix
        <div class="ott-card">
            <img src="assets/net.png" alt="Netflix">
            <h3>Netflix</h3>
            <p>Movies • Series • Originals</p><br><br>
            <a href="netplan.jsp" class="ott-btn">View Plans</a><br><br>
            <a href="currentplan.jsp" class	="ott-btn">Current Plans</a>
        </div>

        Amazon Prime
        <div class="ott-card">
            <img src="assets/prime.png" alt="Amazon Prime">
            <h3>Amazon Prime</h3>
            <p>Movies • Free Delivery • Music</p>
            <a href="primeplan.jsp" class="ott-btn">View Plans</a>
            <br><br>
            <a href="currentplan.jsp" class="ott-btn">Current Plans</a>
        </div>

        Hotstar
        <div class="ott-card">
            <img src="assets/hotstar.png" alt="Hotstar">
            <h3>Jio Hotstar</h3>
            <p>Sports , Movies , TV Shows , WebSeries</p><br><br>
            <a href="hotstarplan.jsp" class="ott-btn">View Plans</a><br><br>
            <a href="currentplan.jsp" class="ott-btn">Current Plans</a>
        </div>
         <div class="ott-card">
            <img src="assets/aha.png" alt="ahaa">
            <h3>aha</h3>
            <p>Sports , Movies , TV Shows , WebSeries </p>
            <a href="ahaplan.jsp" class="ott-btn">View Plans</a>
        <br><br>
            <a href="currentplan.jsp" class="ott-btn">Current Plans</a>
        </div>

    </div> -->
    <div class="ott-container">

<%
    List<OTTPlatform> platforms =
        (List<OTTPlatform>) request.getAttribute("platforms");

    if (platforms != null) {
        for (OTTPlatform p : platforms) {
%>

    <div class="ott-card">
    <div class="ott-image">
        <img src="<%= p.getImage() %>" alt="<%= p.getName() %>">
    </div>
    <div class="ott-content">
        <h3><%= p.getName() %></h3>
        <h5>ID: <%= p.getId() %></h5>
        <p><%= p.getDescription() %></p>
   <a href="viewplans.jsp?platformId=<%= p.getId() %>" class="ott-btn">
    View Plans
</a>

    </div>
</div>

<%
        }
    }
%>

</div>
    
</div>

</body>
</html>
