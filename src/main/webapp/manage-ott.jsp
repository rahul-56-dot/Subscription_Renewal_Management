<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="MODEL.OTTPlatform"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage OTT Platforms</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<!-- NAVBAR -->
	<div class="navbar">
		<div class="logo">Admin Panel</div>
		<ul class="nav-links">
			<li><a href="admin-dashboard.jsp">Dashboard</a></li>
			<li><a href="manage-plans.jsp">Plans</a></li>
			<li><a href="manageOtt">OTT Platforms</a></li>
			<li><a href="login.jsp">Logout</a></li>
		</ul>
	</div>

	<div class="sub-container">

		<!-- ADD OTT PLATFORM -->
		<h2>Add OTT Platform</h2>

		<form action="addOtt" method="post" class="form-box">
         <input type="text" name="id" placeholder="Platform Id" required>
			<input type="text" name="name" placeholder="OTT Name (Netflix)"
				required> <input type="text" name="description"
				placeholder="Description (Streaming Platform)" required> <input
				type="text" name="image"
				placeholder="Logo Path (assets/netflix.png)" required>

			<button type="submit">Add Platform</button>
		</form>


		<hr>

		<!-- LIST OTT PLATFORMS -->
		<h2>Available OTT Platforms</h2>

		<table class="styled-table">
			<tr>
				<th>ID</th>
				<th>Platform Name</th>
				<th>Description</th>
				<!-- ✅ NEW -->
				<th>Logo</th>
				<th>Action</th>
			</tr>

			<%
            List<OTTPlatform> platforms =
                (List<OTTPlatform>) request.getAttribute("platforms");

            if (platforms != null && !platforms.isEmpty()) {
                for (OTTPlatform p : platforms) {
        %>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getName() %></td>

				<!-- ✅ show description -->
				<td><%= p.getDescription() %></td>

				<td><img src="<%= p.getImage() %>" width="50" height="50">
				</td>
				<td><a href="deleteOtt?id=<%= p.getId() %>"
					onclick="return confirm('Delete this platform?')"> ❌ Delete </a></td>
				<td><a href="managePlans.jsp?platformId=<%= p.getId() %>">📝
						Manage Plans</a> <a href="deleteOtt?id=<%= p.getId() %>"
					onclick="return confirm('Delete this platform?')"> ❌ Delete </a></td>
			</tr>
			<%
                }
            } else {
        %>
			<tr>
				<td colspan="5">No OTT Platforms Available</td>
			</tr>
			<% } %>
		</table>

	</div>

</body>
</html>
