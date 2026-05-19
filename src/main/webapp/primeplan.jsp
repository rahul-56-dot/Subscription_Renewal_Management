<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Plans</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="navbar">
		<div class="logo">Amozon Prime Plans</div>
		<ul class="nav-links">

			<li><a href="dashboard.html">Dashboard</a></li>
			<!--  <li><a href="login.html">Logout</a></li> -->
		</ul>
	</div>

	<div style="text-align: center;">
		<h2>Available Plans</h2>
		<!-- ð´ ERROR MESSAGE (ONLY SHOWS WHEN SET FROM CONTROLLER) -->
		<% if (request.getAttribute("error") != null) { %>
		<p style="color: red; font-weight: bold; margin-bottom: 15px;">
			<%= request.getAttribute("error") %>
		</p>
		<% } %>
		<div class="card">
			<h3>Basic</h3>
			<p>Rs 299 / 30 days</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Prime"> <input
					type="hidden" name="duration" value="30">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<div class="card">
			<h3>3 Months Plan</h3>
			<p>Rs 599</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="3 Months Plan">
				<input type="hidden" name="duration" value="90"> <input
					type="hidden" name="returnPage" value="primeplan.jsp">

				<button type="submit">Subscribe</button>
			</form>
		</div>
		<div class="card">
			<h3>Annual Prime</h3>
			<p>Rs 1499/year</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Annual Prime"> <input
					type="hidden" name="duration" value="365"> <input
					type="hidden" name="returnPage" value="primeplan.jsp">

				<button type="submit">Subscribe</button>
			</form>
		</div>
		<div class="card">
			<h3>Annual prime Lite</h3>
			<p>Rs 999</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Annual prime Lite">
				<input type="hidden" name="duration" value="365"> <input
					type="hidden" name="returnPage" value="primeplan.jsp">

				<button type="submit">Subscribe</button>
			</form>
		</div>

	</div>

</body>
</html>
