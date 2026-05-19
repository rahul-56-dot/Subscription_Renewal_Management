<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Plans</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="navbar">
		<div class="logo">Netflix Plans</div>
		<ul class="nav-links">
			<li><a href="dashboard.html">Dashboard</a></li>
		</ul>
	</div>

	<div style="text-align: center;">
		<h2>Available Plans</h2>

		<!-- 🔴 ERROR MESSAGE (ONLY SHOWS WHEN SET FROM CONTROLLER) -->
		<% if (request.getAttribute("error") != null) { %>
		<p style="color: red; font-weight: bold; margin-bottom: 15px;">
			<%= request.getAttribute("error") %>
		</p>
		<% } %>

		<div class="card">
			<h3>Basic</h3>
			<p>Rs 199 / 30 days</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Netflix Basic">
				<input type="hidden" name="duration" value="30"> <input
					type="hidden" name="returnPage" value="netplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<div class="card">
			<h3>Premium</h3>
			<p>Rs 499 / 30 days</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Netflix Premium">
				<input type="hidden" name="duration" value="30"> <input
					type="hidden" name="returnPage" value="netplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<div class="card">
			<h3>45 Days Plan</h3>
			<p>Rs 799 / 45 days</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="45 Days Plan"> <input
					type="hidden" name="duration" value="45"> <input
					type="hidden" name="returnPage" value="netplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<div class="card">
			<h3>3 Months Plan</h3>
			<p>Rs 899 / 90 days</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="3 Months Plan">
				<input type="hidden" name="duration" value="90"> <input
					type="hidden" name="returnPage" value="netplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<div class="card">
			<h3>1 Year Plan</h3>
			<p>Rs 1999 / 365 days</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="1 Year Plan"> <input
					type="hidden" name="duration" value="365"> <input
					type="hidden" name="returnPage" value="netplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>
	</div>

</body>
</html>
