<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>
        
        <div class="container">
		<div class="page-header">
			<h1>Inventor</h1>
			<p class="lead">Product Inventor</p>
			
		</div>
		
		<div class="container">
		 <table class="table table-hover table-stripped">
				<tr>
					<th>Photo Thumb </th>
					<th>ProductId</th>
					<th>ProductName</th>
					<th>ProductDescription</th>
					<th>ProductStatus</th>
					<th>ProductCondition</th>
					<th>ProductPrice</th>
					<th>ProductUnits</th>
					<th></th>
				</tr>
				<c:forEach items="${products}" var="product">
				<tr>
				    <td><img alt="Image" src="<c:url value="/resources/images/${product.productId}.png"/>"
				         width="100" height="100"></td>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.productDes}</td>
					<td>${product.productStatus}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice}</td>
					<td>${product.productUnits}</td>
					<td><a href="<spring:url value="/viewProduct/${product.productId}"/>">
					    <span class="glyphicon glyphicon-info-sign" /></a>
					    <a href="<spring:url value="/deleteProduct/${product.productId}"/>">
					    <span class="glyphicon glyphicon-remove" /></a>
					</td>
				</tr>
				
				</c:forEach>	
		</table>
		<h3><a href="<spring:url value="/addProduct" />" class="btn btn-primary">Add Product</a></h3>
		</div>
		
	</div>
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>	