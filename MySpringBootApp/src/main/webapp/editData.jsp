
<html>

<head> </head>

<body bgcolor="grey">


<center>
<form action="updateEmployee">  
<input type="hidden" value="<%= request.getParameter("eid") %>" name="eid">
<table border="1">


 <tr bgcolor="00FF7F">
          <th align="center"><b>Employee ID</b></th>
          <th align="center"><b>Employee Name</b></th>
          <th align="center"><b>Employee Role</b></th>
          <th align="center"><b>Employee Address</b></th>
         </tr>
<tr>
<td align="center"><input type="text" name="eid"   value='${test.eid}' disabled/></td>
<td align="center"><input type="text" name="ename" value='${test.ename}'/></td>
<td align="center"><input type="text" name="erole" value='${test.erole}'/></td>
<td align="center"><input type="text" name="eadd"  value='${test.eadd}'/></td>
</tr>

</table>
<input type="submit" value="Save">
</form>
</center>



</body>
</html>
