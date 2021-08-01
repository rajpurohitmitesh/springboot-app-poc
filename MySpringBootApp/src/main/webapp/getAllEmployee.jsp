<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.example.demo.model.Employee"%>

<html>

<head>
<%@ page isELIgnored="false" %>
</head>


<body bgcolor="grey">

<center>



 <h1>Displaying Employee Data</h1>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th align="center"><b>Employee ID</b></th>
          <th align="center"><b>Employee Name</b></th>
          <th align="center"><b>Employee Role</b></th>
          <th align="center"><b>Employee Address</b></th>
         </tr>
      
        <%ArrayList<Employee> std = 
            (ArrayList<Employee>)request.getAttribute("e1");
        for(Employee s:std){%>
        <%-- Arranging data in tabular form
        --%>
            <tr>
                <td align="center"><%=s.getEid()%></td>
                <td align="center"><%=s.getEname()%></td>
                <td align="center"><%=s.getErole()%></td>
                <td align="center"><%=s.getEadd()%></td>
                <form action="editEmployeeView">   <input type="hidden" value="<%=s.getEid()%>" name="eid"/>  <td><input type="submit" value="Edit"/></td></form>
			<td><input type="submit" value="Delete"/></td>
            </tr>
            <%}%>
        </table> 
        <hr/>



</center>
</body>
</html>
