<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Aha Plans</title>
<link rel="stylesheet" href="style.css">
<!--     <style>
        /* Simple responsive card layout */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #111;
            color: #fff;
            padding: 10px 20px;
        }
        .navbar .logo {
            display: inline-block;
            font-size: 24px;
            font-weight: bold;
        }
        .navbar ul {
            display: inline-block;
            list-style: none;
            margin: 0;
            padding: 0;
            float: right;
        }
        .navbar ul li {
            display: inline-block;
            margin-left: 20px;
        }
        .navbar ul li a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
        }
        .plans-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin: 30px 10px;
            gap: 20px;
        }
        .card {
            background-color: #fff;
            width: 220px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 2px 6px rgba(0,0,0,0.2);
            text-align: center;
        }
        .card h3 {
            margin-bottom: 10px;
            color: #333;
        }
        .card p {
            margin-bottom: 15px;
            color: #666;
            font-weight: bold;
        }
        .card button {
            background-color: #e50914;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }
        .card button:hover {
            background-color: #b0060f;
        }
        .error-msg {
            color: red;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style> -->
</head>
<body>

	<div class="navbar">
		<div class="logo">Aha Plans</div>
		<ul class="nav-links">
			<li><a href="DashboardController">Dashboard</a></li>
		</ul>
	</div>

	<div style="text-align: center;">
		<h2>Available Plans</h2>

		<!-- ERROR MESSAGE -->
		<% if (request.getAttribute("error") != null) { %>
		<p class="error-msg"><%= request.getAttribute("error") %></p>
		<% } %>

		<!--  <div class="plans-container"> -->

		<!-- Aha Gold Plan -->
		<div class="card">
			<h3>Aha Gold</h3>
			<p>Rs 999 / year</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Aha Gold"> <input
					type="hidden" name="duration" value="365"> <input
					type="hidden" name="returnPage" value="ahaplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<!-- Telugu Annual Premium -->
		<div class="card">
			<h3>Telugu Annual Premium</h3>
			<p>Rs 699 / year</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Telugu Annual Premium">
				<input type="hidden" name="duration" value="365"> <input
					type="hidden" name="returnPage" value="ahaplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<!-- Quarterly Plan -->
		<div class="card">
			<h3>Quarterly Plan</h3>
			<p>Rs 299 / 3 months</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Quarterly Plan">
				<input type="hidden" name="duration" value="90"> <input
					type="hidden" name="returnPage" value="ahaplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<!-- Basic Annual Plan -->
		<div class="card">
			<h3>Basic Annual Plan</h3>
			<p>Rs 499 / year</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Basic Annual Plan">
				<input type="hidden" name="duration" value="365"> <input
					type="hidden" name="returnPage" value="ahaplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

		<!-- Pocket Plan -->
		<div class="card">
			<h3>Pocket Plan</h3>
			<p>Rs 99 / 3 months</p>
			<form action="subscribeController" method="post">
				<input type="hidden" name="planName" value="Pocket Plan"> <input
					type="hidden" name="duration" value="90"> <input
					type="hidden" name="returnPage" value="ahaplan.jsp">
				<button type="submit">Subscribe</button>
			</form>
		</div>

	</div>
	<!-- </div>
 -->
</body>
</html>
