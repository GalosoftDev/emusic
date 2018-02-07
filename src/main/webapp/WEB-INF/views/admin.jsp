<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Manager  Page</h1>
			<p class="lead">Here the admin can update the products</p>
		</div>
		
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				Welcome:${pageContext.request.userPrincipal.name} | <a href= "<c:url value="/j_spring_security_logout" />" >Logout</a>
			</h2>
		</c:if>
		
		<h3><a href="<c:url value="/productInventory" />" >Product Inventory</a></h3>
		
	</div>
</div>
	
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>