<%@page import="MODEL.OTTPlatform"%>
<%@ page import="DAO.dao" %>
<%@ page import="MODEL.model" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%
    HttpSession session2 = request.getSession(false);
    if(session2 == null || session2.getAttribute("username") == null){
        response.sendRedirect("login.html");
        return;
    }

    String username = (String) session2.getAttribute("username");

    // ✅ Clean cast — no underscores
    List<model> plans = (List<model>) request.getAttribute("plans");
    if (plans == null) {
        dao d = new dao();
        try {
            plans = d.getAllSubscriptions(username);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Current Plan</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .table-container {
            margin: 40px auto;
            width: 80%;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #3498db;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
            color: black;
        }
        .btn {
            display: inline-block;
            padding: 8px 15px;
            background-color: #3498db;
            color: black;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<div class="navbar">
    <div class="logo">Current Plans</div>
    <ul class="nav-links">
        <li><a href="DashboardController">Dashboard</a></li>
    </ul>
</div>

<div class="table-container">
    <h2>Your Subscription History</h2>

    <% if(plans != null && !plans.isEmpty()){ %>
    <table>
        <tr>
            <th>Platform</th>
            <th>Plan Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Status</th>
            <th>Days Remaining</th>
        </tr>
        <% for(model plan : plans){ %>
        <tr>
            <td><%= plan.getOttPlatform() != null ? plan.getOttPlatform().getName() : "N/A" %></td>
            <td><%= plan.getPlanName() %></td>
            <td><%= plan.getStartDate() %></td>
            <td><%= plan.getEndDate() %></td>
            <td><%= plan.getStatus() %></td>
            <td><%= ChronoUnit.DAYS.between(java.time.LocalDate.now(), plan.getEndDate()) %></td>
        </tr>
        <% } %>
    </table>
    <% } else { %>
        <p>No subscriptions found</p>
    <% } %>

</div>

</body>
</html>