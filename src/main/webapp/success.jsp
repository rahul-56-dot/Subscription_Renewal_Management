<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Subscription Successful</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .success-box {
            margin: 80px auto;
            width: 50%;
            padding: 30px;
            text-align: center;
            border: 2px solid #4CAF50;
            border-radius: 10px;
            background-color: #f4fff4;
        }
        .success-box h2 {
            color: #2e7d32;
        }
        .success-box p {
            font-size: 16px;
            margin-top: 10px;
        }
        .btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #e50914;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

<div class="navbar">
    <div class="logo">Netflix Subscription</div>
    <ul>
        <li><a href="dashboard.html">Dashboard</a></li>
        <li><a href="currentplan.jsp">My Plan</a></li>
    </ul>
</div>

<div class="success-box">
    <h2>🎉 Subscription Successful!</h2>
    <p>Your subscription has been activated successfully.</p>
    <p>Enjoy streaming without interruptions.</p>

    <a href="currentplan.jsp" class="btn">View My Plan</a>
</div>

</body>
</html>
