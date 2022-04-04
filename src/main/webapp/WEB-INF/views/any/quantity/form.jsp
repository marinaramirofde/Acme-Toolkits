<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!-- "assemblyNotes", "code","description","link","published","title","item name" -->
	<acme:input-textbox code="any.quantity.form.label.assemblyNotes" path="toolkit.assemblyNotes"/>
	<acme:input-textbox code="any.quantity.form.label.code" path="toolkit.code"/>		
	<acme:input-textbox code="any.quantity.form.label.description" path="toolkit.description"/>	
	<acme:input-url code="any.quantity.form.label.link" path="toolkit.link"/>
	<acme:input-textbox code="any.quantity.form.label.published" path="toolkit.published"/>
	<acme:input-textbox code="any.quantity.form.label.title" path="toolkit.title"/>	
	<acme:input-textbox code="any.quantity.form.label.item.name" path="item.name"/>	
	<acme:input-textbox code="any.quantity.form.label.item" path="item.id"/>
	<acme:button code="any.quantity.form.label.item" action="/any/item/show?id=${ItemId}"/>
		
	
</acme:form>
