<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        table {
          font-family: arial, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }

        td, th {
          border: 1px solid #dddddd;
          text-align: left;
          padding: 8px;
        }

        tr:nth-child(even) {
          background-color: #dddddd;
        }
    </style>
</head>
<body>

    <table>
        <tr>
            <th>Descrição</th>
            <th>Data</th>
            <th>Valor</th>
            <th>Categoria</th>
            <th></th>
        </tr>
        <c:forEach var="despesa" items="${despesas}">
            <tr>
                <td>${ despesa.getDescricao() }</td>
                <td>${ despesa.getData() }</td>
                <td>${ despesa.getValor() }</td>
                <td>${ despesa.getCategoria() }</td>
                <td><a href="controller?action=DeleteDespesa&id=${despesa.id}">Remover</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>