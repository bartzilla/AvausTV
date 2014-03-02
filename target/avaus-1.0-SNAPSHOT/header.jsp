<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand" href="http://www.avaus.fi/" target="_blank">Avaus TV</a>
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Home</a></li>
            </ul>
        </div>
    </div>

</nav>
<div class="container-fluid">
    <div th:include="layout :: left"></div>
    <div class="row-fluid">
        <div class="span8">
            <div class="jumbotron">
                <h1>Avaus TV</h1>

                <p>Type in a Customer's Account Number:</p>

                <p>

                <form method="POST" ACTION="findPrizesForCustomer.do" class="form-horizontal">
                    <input name="ACCOUNT_NUMBER" type="text" placeholder="" class="form-control input-md">
                    <span class="help-block">Available numbers: 1111, 2222, 3333 </span>
                    <button type="submit" class="btn btn-primary btn-lg">Go, Go, Go!</button>
                </form>
                </p>
            </div>
        </div>
    </div>
</div>
<h3 style=" color: red"><c:out value="${message}"/></h3>

