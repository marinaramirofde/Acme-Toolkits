<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="any.item.list.label.code" path="code" width="10%"/>
	<acme:list-column code="any.item.list.label.type" path="type" width="70%"/>	
	
	<jstl:if test="${command == 'list-all-item-toolkit'}">
	<acme:list-column code="any.item.list.label.amount" path="amount" width="10%"/>	
	</jstl:if>	
</acme:list>
