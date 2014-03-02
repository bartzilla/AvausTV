<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>

<head>
	<title>All books for our store</title>
	<link href="styles.css" rel="Stylesheet" type="text/css"/>
</head>
  
<body>
HElloS

	<div id="prizes">
		<ul>
			<c:forEach items="${allPrizes}" var="nextPrize">
			
			<li>
				<h2>${nextBook.description}</h2>
				<%--<p>--%>
					<%--<span> by  ${nextBook.author}  --%>
					       <%--<fmt:formatNumber value="${nextBook.price}"--%>
					       					 <%--type="currency"--%>
					       					 <%--currencyCode="USD" />			--%>
				<%----%>
					<%--<form method='post' action='<c:url value="addToCart.do"/>'>--%>
						<%--<input type='hidden' name='id' value='${nextBook.id}'/>--%>
						<%--<input type='image' src='cart-button.png'/>--%>
				    <%--</form>--%>
				<%--</span>--%>
				<%--</p>--%>
				
			</li>
			
			</c:forEach>
		
		</ul>
	</div>
		

</body>

</html>