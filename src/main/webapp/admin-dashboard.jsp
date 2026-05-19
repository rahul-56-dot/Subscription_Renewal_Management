<%@ page import="java.sql.ResultSet" %>
<center>
<h2>All User Subscriptions</h2>
</center>
<%
String msg = request.getParameter("msg");
if ("mailSent".equals(msg)) {
%>
<script>alert("Email sent successfully!");</script>
<% } else if ("mailError".equals(msg)) { %>
<script>alert("Failed to send email");</script>
<% } %>

<%
String user = (String) session.getAttribute("username");
if (user == null) {
    response.sendRedirect("login.html");
    return;
}
%>
<center>
<h2>Welcome, <%= user %></h2>
</center>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        padding: 10px 12px;
        border: 1px solid #ccc;
        text-align: center;
    }
    th {
        background-color: #3498db;
        color: #fff;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    .status-badge {
        padding: 4px 8px;
        border-radius: 4px;
        font-weight: bold;
    }
    .active { background-color: #2ecc71; color: #fff; }
    .expired { background-color: #e74c3c; color: #fff; }
    .inactive { background-color: #95a5a6; color: #fff; }
    button {
        padding: 6px 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    .deactivate-btn {
        background-color: #e74c3c;
        color: white;
    }
    .alert-btn {
        background-color: #3498db;
        color: white;
    }
</style>

<table>
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Plan</th>
        <th>End Date</th>
        <th>Days Left</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>

<%
ResultSet rs = (ResultSet) request.getAttribute("plans");
while(rs != null && rs.next()){
    int daysLeft = rs.getInt("days_left");
    String status = rs.getString("status");
%>

<tr>
    <td><%= rs.getString("username") %></td>
    <td><%= rs.getString("email") %></td>
    <td><%= rs.getString("plan_name") %></td>
    <td><%= rs.getDate("end_date") %></td>
    <td><%= daysLeft %></td>

    <td>
        <%
            if("INACTIVE".equalsIgnoreCase(status)){
        %>
            <span class="status-badge inactive">INACTIVE</span>
        <%
            } else if(daysLeft <= 0){
        %>
            <span class="status-badge expired">EXPIRED</span>
        <%
            } else {
        %>
            <span class="status-badge active">ACTIVE</span>
        <%
            }
        %>
    </td>

    <td>
        <!-- SEND ALERT -->
        <form action="sendAlert" method="post" style="display:inline;">
            <input type="hidden" name="email" value="<%= rs.getString("email") %>">
            <input type="hidden" name="username" value="<%= rs.getString("username") %>">
            <input type="hidden" name="plan" value="<%= rs.getString("plan_name") %>">
            <button type="submit" class="alert-btn">Send Alert</button>
        </form>

        <!-- DEACTIVATE PLAN -->
        <% if("ACTIVE".equalsIgnoreCase(status)){ %>
        <form action="deactivatePlan" method="post" style="display:inline;">
            <input type="hidden" name="subId" value="<%= rs.getInt("sub_id") %>">
            <button type="submit" class="deactivate-btn" onclick="return confirm('Deactivate this plan?');">
                Deactivate
            </button>
        </form>
        <% } %>
    </td>
</tr>

<% } %>
</table>
