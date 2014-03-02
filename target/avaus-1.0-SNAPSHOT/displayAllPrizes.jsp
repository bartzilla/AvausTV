<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>

<head>
    <title>Avaus TV</title>
</head>

<body>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">

<jsp:include page="/header.jsp"/>

<div id="prizes">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>List of Events available for the given Customer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allPrizes}" var="nextPrize">
        <tr>
            <td>${nextPrize.description}</td>


            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>

<jsp:include page="/footer.jsp"/>
</body>

</html>