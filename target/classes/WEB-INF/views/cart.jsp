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
			
			<section class="container" ng-app="cartApp">
				<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
				                 
				<div>
					<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove" />Clear cart</a>
				</div>
				
				<table class = "table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr ng-repeat = "item in cart.cartItems">
						<th>{{item.product.productName}}</th>
						<th>{{item.product.productPrice}}</th>
						<th>{{item.quantity}}</th>
						<th>{{item.totalPrice}}</th>
						<th><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
						    <span class="glyphicon glyphicon-remove"/></a></th>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{cart.grandTotal}}</th>
						<th></th>
					</tr>
				</table>
				
				<a href= "<spring:url value="/productList" />" class="btn btn-primary">Continue Shopping</a>
			   </div>
			</section>
		</div>	
	</div>

<%@ include file="/WEB-INF/views/templates/footer.jsp" %>	
     