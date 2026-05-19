<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="DAO.dao"%>
<%@ page import="MODEL.OTTPlatform"%>

<%
    // ✅ Get platformId as INT
    int platformId = Integer.parseInt(request.getParameter("platformId"));

    dao d = new dao();

    // ✅ Correct DAO call
    List<OTTPlatform> plans = d.getPlansByPlatformId(platformId);
%>

<!DOCTYPE html>
<html>
<head>
<title>Plans</title>
<meta charset="UTF-8">

<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="navbar">
		<div class="logo">OTT Plans</div>
		<ul class="nav-links">
			<li><a href="DashboardController">Dashboard</a></li>
<!-- 			<li><a href="manage-plans.jsp">Plans</a></li>
 -->			<!-- <li><a href="manageOtt">OTT Platforms</a></li> -->
			<li><a href="login.jsp">Logout</a></li>
		</ul>
		</div>
	

	<div class="container">
		<h2>Available Plans</h2>

		<div class="plans-grid">
			<% if (plans == null || plans.isEmpty()) { %>
			<p>No plans available for this platform.</p>
			<% } else { %>
			<% for (OTTPlatform p : plans) { %>

			<div class="card">
				<h3><%= p.getName()%></h3>
				<p class="price">
					₹
					<%= p.getPrice() %></p>
				<p class="duration"><%= p.getDuration() %>
				days
				</p>

				<form action="subscribe" method="post">
					<input type="hidden" name="platform" value="<%= platformId %>">
					<input type="hidden" name="planName" value="<%= p.getName() %>">
					<button type="submit" class="subscribe-btn">Subscribe</button>
				</form>
			</div>

			<% } %>
			<% } %>
		</div>
	</div>

</body>
</html>
