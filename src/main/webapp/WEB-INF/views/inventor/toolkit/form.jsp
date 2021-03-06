<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textbox code="inventor.toolkit.form.label.description" path="description"/>	
	<acme:input-textbox code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-textbox code="inventor.toolkit.form.label.link" path="link"/>
	<jstl:if test="${command == 'show'}">	
	<acme:input-money code="inventor.toolkit.form.label.retailPrice" path="retailPrice"/>
	<acme:button code="inventor.toolkit.form.button.items" action="/inventor/quantity/list?id=${id}"/>
	
	</jstl:if>
	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(command, 'show, update, publish, delete') && published == false && itemPresence == true}">
		    <acme:submit code="inventor.toolkit.form.button.publish" action="/inventor/toolkit/publish"/>
		    <acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
			<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
			<acme:button code="inventor.toolkit.form.button.createQuantity" action="/inventor/quantity/create?masterId=${id}"/>
		</jstl:when>
		<jstl:when test="${acme:anyOf(command, 'show, update, publish, delete') && published == false }">
		    <acme:submit code="inventor.toolkit.form.button.update" action="/inventor/toolkit/update"/>
			<acme:submit code="inventor.toolkit.form.button.delete" action="/inventor/toolkit/delete"/>
			<acme:button code="inventor.toolkit.form.button.createQuantity" action="/inventor/quantity/create?masterId=${id}"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
			<acme:submit code="inventor.toolkit.form.button.create" action="/inventor/toolkit/create"/>
		</jstl:when>
	</jstl:choose>
</acme:form>
