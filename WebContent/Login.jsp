<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
   .errorMessage{
     color: red;
   }
</style>
</head>
<body>
<s:actionerror/>
   <form action="login">
      <table>
      <tr>
         <td>User Name:</td>
         <td><s:textfield name="userName"/></td>
      </tr>
      <tr>
         <td>Password:</td>
         <td><s:password name="password"/></td>
      </tr>
      <tr>
         <td>
           <img src="getCaptchaImage.action"/>
         </td>
         <td><s:textfield name="validateString"/></td>
      </tr>
       <tr>
          <td colspan="2" align="center"><s:submit/></td>
       </tr>
      </table>
      
   </form>
</body>
</html>