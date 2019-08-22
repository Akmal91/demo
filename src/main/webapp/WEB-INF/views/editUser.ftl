<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
</head>
<body>
<form name="employee" action="/updateUser" method="post">
    <input title="Id" type="hidden" name="id" value="${employee.id}">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${employee.name}">
    <p>Last name</p>
    <input title="Last name" type="text" name="last_name" value="${employee.last_name}">
    <p>Middle name</p>
    <input title="Middle name" type="text" name="middle_name" value="${employee.middle_name}">
    <p>Email</p>
    <input title="Email" type="email" name="email" value="${employee.email}">
    <p>Nationality</p>
    <input title="Nationality" type="text" name="nationality" value="${employee.nationality}">
    <p>Date of birth</p>
    <input title="Date of birth" type="date" name="date_of_birth" value="${employee.date_of_birth}">
    <p>Study</p>
    <input title="Study" type="text" name="study" value="${employee.study}">
    <p>Date of finish</p>
    <input title="Date of finish" type="date" name="date_of_finish" value="${employee.date_of_finish}">
    <p>Phone</p>
    <input title="Phone" type="text" name="phone" value="${employee.phone}">
    <p>Education</p>
    <input title="Education" type="text" name="education" value="${employee.education}">
    <input type="submit" value="ok">
</form>
</body>
</html>