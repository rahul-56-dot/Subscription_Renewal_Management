<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Plans</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="navbar">
		<div class="logo">Amozon Prime Plans</div>
		<ul class="nav-links">

			<li><a href="dashboard.jsp">Dashboard</a></li>
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
			<p>Rs 149 / 3 months</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Hotstar Basic">
				<input type="hidden" name="duration" value="90">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<div class="card">
			<h3>Basic</h3>
			<p>Rs 499/year</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Basic Year Plan">
				<input type="hidden" name="duration" value="365">
				<button type="submit">Subscribe</button>
			</form>
		</div>
		<div class="card">
			<h3>Premiun</h3>
			<p>Rs 299/month</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Premium Plan"> <input
					type="hidden" name="duration" value="30">
				<button type="submit">Subscribe</button>
			</form>
		</div>
		<div class="card">
			<h3>Premium</h3>
			<p>Rs 499/ 3 Months</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Premium 3 Months Plan">
				<input type="hidden" name="duration" value="90">
				<button type="submit">Subscribe</button>
			</form>
		</div>
		<div class="card">
			<h3>Premium</h3>
			<p>Rs 1499/ Year</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Premium Year Plan ">
				<input type="hidden" name="duration" value="365">
				<button type="submit">Subscribe</button>
			</form>
		</div>
	</div>

</body>
</html>
