

<html lang="en">
<body>

 <center>
 <table border="1">


<tr>
<td align="center">EID</td>
<td align="center" >ENAME</td>
<td align="center">EROLE</td>
<td align="center">EADD</td>
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
<tr><td><input type="submit" value="Edit"></td><br>
</form>
<form action="deleteEmployee">  
<input type="hidden" value="<%= request.getParameter("eid") %>" name="eid">
<td><input type="submit" value="Delete"></td></tr>
</table>
</form>

    </center>
</body>
</html>