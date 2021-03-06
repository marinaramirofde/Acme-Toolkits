<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.item.list.label.name" path="name" width="20%"/>
	<acme:list-column code="inventor.item.list.label.code" path="code" width="10%"/>
	<acme:list-column code="inventor.item.list.label.type" path="type" width="70%"/>

	<jstl:if test="${command == 'listToolkitItems'}">
		<acme:list-column code="inventor.item.list.label.amount" path="amount" width="10%"/>	
	</jstl:if>

</acme:list>

<jstl:if test="${acme:anyOf(command, 'list-all-mine-items')}">
	<acme:button code="inventor.item.list.button.create" action="/inventor/item/create"/>
</jstl:if>	
