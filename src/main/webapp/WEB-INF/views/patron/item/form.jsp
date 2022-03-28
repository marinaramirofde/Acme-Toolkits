<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!--  "title","name", "code", "technology", "description", "retailPrice", "link","type" -->
	<acme:input-textbox code="administrator.item.form.label.title" path="title"/>	
	<acme:input-textbox code="administrator.item.form.label.name" path="name"/>
	<acme:input-textbox code="administrator.item.form.label.code" path="code"/>		
	<acme:input-textbox code="administrator.item.form.label.technology" path="technology"/>	
	<acme:input-textbox code="administrator.item.form.label.description" path="description"/>
	<acme:input-money code="administrator.item.form.label.retailPrice" path="retailPrice"/>
	<acme:input-url code="administrator.item.form.label.link" path="link"/>	
	<acme:input-select code="administrator.item.form.label.type" path="type">
		<acme:input-option code="TOOL" value="TOOL" selected="${status == 'TOOL'}"/>
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${status == 'COMPONENT'}"/>
	</acme:input-select>
	
</acme:form>
