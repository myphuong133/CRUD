<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add New Emp</h1>
<form action="save-servlet" method="post">

    <table border='1'>

        <tr>
            <td>Name</td>
            <td><input type="text" name="nameEmp"/></td>
        </tr>

        <tr>
            <td>Password</td>
            <td><input type="password" name="passEmp"/></td>
        </tr>

        <tr>
            <td>Email</td>
            <td><input type="email" name="emailEmp"/></td>
        </tr>

        <tr>
            <td>Country</td>
            <td>
                <select name="countryEmp" style="width: 100%">
                    <option>India</option>
                    <option>USA</option>
                    <option>UK</option>
                    <option>Japan</option>
                    <option>VietNam</option>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                <input width:100% type="submit" value="Save">
            </td>
        </tr>
    </table>
</form>
    <a href="/view-servlet">View Employee</a>
</body>
</html>
