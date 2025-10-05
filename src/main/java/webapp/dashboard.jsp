<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sprintappweb.model.Usuario" %>
<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Usuários Cadastrados</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
        </tr>
        <%
            if (usuarios != null) {
                for (Usuario u : usuarios) {
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getNome() %></td>
            <td><%= u.getEmail() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <a href="cadastro.html">Novo Cadastro</a>
</body>
</html>
