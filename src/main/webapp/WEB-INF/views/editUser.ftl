<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
</head>
<body>
<form name="user" action="/updateUser" method="post">
    <p>Id</p>
    <input title="Id" type="hidden" name="id" value="${user.id}" disabled>
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${user.name}">
    <p>Email</p>
    <input title="Email" type="text" name="email" value="${user.email}">
    <p>Age</p>
    <input title="Age" type="text" name="age" value="${user.age}">
    <input type="submit" value="ok">
</form>
</body>
</html>