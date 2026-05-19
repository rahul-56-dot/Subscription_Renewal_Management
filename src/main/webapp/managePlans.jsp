<%@ page import="java.util.List" %>
<%@ page import="MODEL.OTTPlatform" %>
<%@ page import="DAO.dao" %>

<%
    int platformId = Integer.parseInt(request.getParameter("platformId"));

    dao d = new dao();
    OTTPlatform platform = d.getPlatformById(platformId);
    List<OTTPlatform> plans = d.getPlansByPlatformId(platformId);

    if (platform == null) {
%>
        <h3 style="color:red;">Platform not found</h3>
<%
        return;
    }
%>

<h2>Manage Plans for: <%= platform.getName() %></h2>

<!-- Add Plan Form -->
<form action="addPlan" method="post">
    <input type="hidden" name="platformId" value="<%= platform.getPlatform() %>">

    <input type="text" name="planName" placeholder="Plan Name" required>
    <input type="text" name="duration" placeholder="Duration (e.g., 1 Month / 30 Days)" required>
    <input type="number" step="0.01" name="price" placeholder="Price" required>

    <button type="submit">Add Plan</button>
</form>

<hr>

<!-- Existing Plans Table -->
<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Plan Name</th>
        <th>Duration</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>

<%
    if (plans != null && !plans.isEmpty()) {
        for (OTTPlatform plan : plans) {
%>
        <tr>
            <td><%= plan.getId() %></td>
            <td><%= plan.getName() %></td>
            <td><%= plan.getDuration() %></td>
            <td><%= plan.getPrice() %></td>
            <td>
                <a href="editPlan.jsp?id=<%= plan.getId() %>">✏️ Edit</a>
                |
                <a href="deletePlan?id=<%= plan.getId() %>"
                   onclick="return confirm('Delete this plan?')">❌ Delete</a>
            </td>
        </tr>
<%
        }
    } else {
%>
        <tr>
            <td colspan="5">No Plans Available</td>
        </tr>
<%
    }
%>
</table>
