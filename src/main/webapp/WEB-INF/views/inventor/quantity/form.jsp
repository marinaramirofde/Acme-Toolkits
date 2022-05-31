<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	
	<acme:input-textbox code="inventor.quantity.form.label.amount" path="amount"/>
	
	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(command, 'show, update')}">
		    <acme:input-textbox code="inventor.quantity.form.label.item.code" path="item.code" readonly = "true"/>
		    <acme:input-textbox code="inventor.quantity.form.label.name" path="item.name" readonly = "true"/>		
			<acme:input-textbox code="inventor.quantity.form.label.technology" path="item.technology" readonly = "true"/>	
			<acme:input-textbox code="inventor.quantity.form.label.description" path="item.description" readonly = "true"/>
	        <acme:input-money code="inventor.quantity.form.label.retailPrice" path="item.retailPrice" readonly = "true"/>
	        <acme:input-url code="inventor.quantity.form.label.link" path="item.link" readonly = "true"/>	
	        <acme:input-textbox code="inventor.quantity.form.label.type" path="item.type" readonly = "true"/>
		    <acme:submit code="inventor.toolkit.form.button.update" action="/inventor/quantity/update"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
		   	<acme:input-select code="inventor.quantity.form.label.item.code"  path="item.code">
		  	  	<jstl:forEach items="${items}" var="item">
		   	  	<acme:input-option code="${item.getCode()}" value="${item.getCode()}" selected="${item.getCode()==codeX}"/>
		   	  	</jstl:forEach>
		   	</acme:input-select>
		    <acme:submit code="inventor.quantity.form.button.createQuantity" action="/inventor/quantity/create"/>
		</jstl:when>
	</jstl:choose>
	
	
		
	
	
</acme:form>
