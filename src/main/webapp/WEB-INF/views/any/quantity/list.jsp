<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>



<acme:list>
	<acme:list-column code="any.quantity.list.label.title" path="toolkit.title" width="20%"/>
	<acme:list-column code="any.quantity.list.label.code" path="toolkit.code" width="10%"/>
	<acme:list-column code="any.quantity.list.label.item.name" path="item.name" width="10%"/>
	<acme:list-column code="any.quantity.list.label.description" path="toolkit.description" width="70%"/>
		
</acme:list>
