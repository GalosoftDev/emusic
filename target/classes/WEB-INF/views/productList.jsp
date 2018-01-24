<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>
        
        <table class="table table-hover table-stripped">
		<tr>
		    <th>Thumbnail</th>
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
			<td><a href="<spring:url value="/viewProduct/${product.productId}" />">
			    <span class="glyphicon glyphicon-info-sign" /></a></td>
		</tr>
		
		</c:forEach>	
	</table>
	
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>	
     