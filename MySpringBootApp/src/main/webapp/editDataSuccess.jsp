

<html lang="en">
<body>

 <center>
 <h3> Employee data updated.... <h3>
 <table border="1">

 <tr bgcolor="00FF7F">
          <th align="center"><b>Employee ID</b></th>
          <th align="center"><b>Employee Name</b></th>
          <th align="center"><b>Employee Role</b></th>
          <th align="center"><b>Employee Address</b></th>
         </tr>

<tr>
<td align="center">${test.eid}</td>
<td align="center">${test.ename}</td>
<td align="center">${test.erole}</td>
<td align="center">${test.eadd}</td>
</tr>

</table>


<form action="editEmployeeView">   
<table border="1">
<input type="hidden" value="<%= request.getParameter("eid") %>" name="eid">
<tr><td></td><td><input type="submit" value="Edit"></td>
</form>

<form action="deleteEmployee">  
<input type="hidden" value="<%= request.getParameter("eid") %>" name="eid">
<td><input type="submit" value="Delete"></td></tr>
</form>

</table>


    </center>
</body>
</html>