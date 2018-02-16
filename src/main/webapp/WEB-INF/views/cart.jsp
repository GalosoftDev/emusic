<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	<div class="container-wrapper">
		<div class="container">
			<section>
				<div class="jumbotron">
					<div class="container">
						<h1>Cart</h1>
						<p>All the products in your shopping cart</p>
					</div>
				</div>
			</section>
			
			<section>
				<div class="container">
					<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove" />Clear cart</a>
				</div>
				
				<table>
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr>
						<th>productName</th>
						<th>productPrice</th>
						<th>quantity</th>
						<th>totalPrice</th>
						<th>remove button</th>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>grandTotal</th>
						<th></th>
					</tr>
				</table>
				
				<a href= "<spring:url value="/productList" />">Continue Shopping</a>
				
			</section>
		</div>	
	</div>

<%@ include file="/WEB-INF/views/templates/footer.jsp" %>	
     