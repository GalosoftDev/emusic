<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product details</h1>
			<p class="lead">Here you can check details</p>
		</div>
		
		<div class="row">
			<div class="col-md-5">
				<img alt="Image" src="<c:url value="/resources/images/${product.productId}.png"/>">
			</div>
			<div class="col-md-5">
				<h3>Name: ${product.productName}</h3>
				<p>Description: ${product.productDes}</p>
				<p>Status: ${product.productStatus}</p>
				<p>Condition: ${product.productCondition}</p>
				<p>Price: ${product.productPrice}</p>
				<p>Units: ${product.productUnits}</p>
			</div>
		</div>
		
	</div>
</div>
	
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>