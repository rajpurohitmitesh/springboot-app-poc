

<html lang="en">
<body>

<head>
<script language="javascript">


function deleteRecord(id){
    var doIt=confirm('Do you want to delete the record?');
  if(doIt){
   var f=document.form;
    f.method="post";
    f.action="deleteEmployee" ;
    f.submit();
    }
  else{

    }
}
</script>
</head>

 <center>


            
            
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
<tr><td><input type="submit" value="Edit"></td><br>
</form>
<form name="form">  
<input type="hidden" value="<%= request.getParameter("eid") %>" name="eid">
<td><input type="submit" value="Delete" onclick="deleteRecord(<%= request.getParameter("eid") %>);" ></td></tr>
</table>
</form>



    </center>
</body>
</html>