<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>

    <form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
      <table>
        <tr><td>User:</td><td><input type='text' name='j_username' value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/></td></tr>
        <tr><td>Password:</td><td><input type='password' name='j_password'></td></tr>
        <tr><td><input type="checkbox" name="_spring_security_remember_me"></td><td>Don't ask for my password for two weeks</td></tr>

        <tr><td colspan='2'><input name="submit" type="submit"></td></tr>
        <tr><td colspan='2'><input name="reset" type="reset"></td></tr>
      </table>
      
        <table border="1">
            <TR>

                <TD>user</TD>
                <TD><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></TD>
            </TR>
            <TR>
                <TD>Login failed due to: </TD>
                <TD><c:out value="${SPRING_SECURITY_LAST_EXCEPTION}"/></TD>

            </TR>
         


        </table>
      
      

    </body>
</html>
