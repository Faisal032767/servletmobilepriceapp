<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>HomeJsp</title>
<link rel="stylesheet" href="./index.css">
</head>
<body>
	<div id="pop" class="popover">
		<p>Are you sure , you want to delete</p>
		<button id="yes">Yes</button>
		<button id="no">No</button>
	</div>
	<h1 style="color:white">Mobile And Its Price </h1>
	<div class="container">
		<div class="box1">
			<ol>
				<li>@Mobile Info.</li>
				<li><button class="add">+ add new mobile</button></li>
			</ol>
		</div>
		<!-- box1 end-->
		
		<!--     option taking from user -->
		<div id="column-display">
        &nbsp;&nbsp;<span> No. Of Row To Display</span> &nbsp;&nbsp;
        <select>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
          <option value="9">9</option>
          <option value="10">10</option>
        </select>
      </div>
		
		
		<!--     option taking from user END -->
		

		<div class="data-show">
			<table id="data">
				<tr>
					<td><label for="">Id</label></td>
					<td><label for="">Name</label></td>
					<td><label for="">Price</label></td>
					<td colspan="2"><label for="">Modify</label></td>
				</tr>


				<%
				ResultSet rs = (ResultSet) session.getAttribute("resultSet");

				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int price = rs.getInt(3);

					out.println(" <tr>");

					out.println("<td><input type='text'name='id' id='name' pattern='[0-9]+' title='Enter number only' required disabled='disabled' value=' " + id +

					"'/></td>");

					out.println("<td><input type='text'name='id' id='name' disabled='disabled' value=' " + name +

					"'/></td>");

					out.println("<td><input type='text'name='id' id='name' pattern='[0-9]+' title='Enter number only' required disabled='disabled' value=' " + price +

					"'/></td>");

					out.println("<td style='text-align: center;'> <button id='btn-edit' style='width: 60px;' value='" + id
					+ "'>Edit</button></td>");

					out.println("<td> <button id='btn-del' name='btn' id='popovertar'  value='" + id + "'>Delete</button></td>");

					out.println(" </tr>");
				}
				%>
				<tr ><td colspan="5">
				<% int total=(int)session.getAttribute("total"); %>
				
				<% int end=(int)session.getAttribute("end"); %>
			
				<% 
					//int end=4;
					int divi=total%end==0? total/end: total/end+1; 
			            		
					for(int i=0;i<divi;i++)
					{   int send=i*end;
					
					%>
						<button class='pagi-btn' value="<%=send %>" ><%=i+1 %></button>
						
				<%	}
				%>
				</td></tr>
				
			</table>
		</div>
	</div>
	<!-- container-end -->
	<!-- ======================NEW USER ====================== -->

	<!-- adding data box provided by user -->
	<form action="addServ" method='post'>
		<div class="box2">
			<p>Add New Mobile</p>
			<table id="user">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" pattern="[0-9]+" title="Enter Number Only" /></td>
				</tr>

				<tr>
					<td>Name</td>
					<td><input type="text" name="name" required /></td>
				</tr>

				<tr>
					<td>Price</td>
					<td><input type="text" name="price" pattern="[0-9]+" title="Enter Number only" /></td>
				</tr>
			</table>
			<button id="box2-btn">Submit</button>
		</div>
	</form>
</body>



<script src="./index.js"></script>
<script src="./pagination4.js"></script>




</html>
