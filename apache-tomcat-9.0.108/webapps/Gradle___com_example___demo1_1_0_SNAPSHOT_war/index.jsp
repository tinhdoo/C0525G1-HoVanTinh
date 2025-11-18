<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "" %>Currency converter</h1>
<br/>
<form action="convert">
<table>
    <tr>
        <td>
            <p>Nhập số tiền USD: </p>
            <input type="number" name="usd">
        </td>
    </tr>
    <tr>
        <td>
            <button type="submit">Tính</button>
        </td>
    </tr>

</table>
</form>

</body>
</html>