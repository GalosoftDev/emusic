<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product details</h1>
			<p class="lead">Here you can check details</p>
		</div>
		<div class="container" ng-app="cartApp">
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
				<br/>
				<c:set var="role" scope="page" value="${param.role}"/>
				<c:set var="url" scope="page" value="/productList"/>
				<c:if test="${role == 'admin'}">
					<c:set var="url" scope="page" value="/productInventory"/>
				</c:if>
				
				<p ng-controller="cartCtrl">
				    <a href="#" class="btn btn-primary" ng-click="testCart()">Test Angular Spring</a>
				    
					<a href= "<c:url value="${url}" />" class="btn btn-default">Back</a>
					
					<a href= "#" class="btn btn-warning" ng-click="addToCart('11')">
					   <span class="glyphicon glyphicon-shopping-cart"/>Order Now</a>
					   
					<a href= "<spring:url value="/cart" />" class="btn btn-default">
					   <span class="glyphicon glyphicon-hand-right"/>View Cart</a>    
				</p>	
			</div>
		</div>
	</div>
</div>
	
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>