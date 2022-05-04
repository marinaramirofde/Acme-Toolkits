<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	
	<acme:input-textbox code="inventor.quantity.form.label.amount" path="amount"/>
	<acme:input-textbox code="inventor.quantity.form.label.item.code" path="item.code"/>
		
	<acme:submit code="inventor.quantity.form.button.createQuantity" action="/inventor/quantity/create"/>
	
</acme:form>
