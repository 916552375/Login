
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>JspServlet</title>
  </head>
  <body>
  <form action="login" method="post">
    <table>
      <tr>
        <th colspan="2">用户登录</th>
      </tr>
      <tr>
        <td>用户名：</td>
        <td><input type="text" id="userName" name="userName" value="${userName }"/></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" id="password" name="password" value="${password}"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="登录"/></td>
        <td><font color="red">${error }</font></td>
      </tr>
    </table>
  </form>
  </body>
</html>
