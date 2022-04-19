<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!-- "budget", "code", "creationMoment", "endMoment", "info", "legalStuff","startMoment","status","patron.id"-->	
	<acme:input-moment code="inventor.patronage.form.label.creationMoment" path="creationMoment"/>
	<acme:input-moment code="inventor.patronage.form.label.endMoment" path="endMoment"/>
	<acme:input-moment code="inventor.patronage.form.label.startMoment" path="startMoment"/>
	<acme:input-textbox code="inventor.patronage.form.label.code" path="code"/>			
	<acme:input-textbox code="inventor.patronage.form.label.info" path="info"/>
	<acme:input-money code="inventor.patronage.form.label.budget" path="budget"/>
	<acme:input-money code="inventor.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-select code="inventor.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
	</acme:input-select>
	<acme:input-textbox code="inventor.patronage.form.label.patron.id" path="patron.id"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.company" path="patron.company"/>
	<acme:button code="inventor.patronage.form.label.patron" action="/any/patron/show?id=${PatronId}"/>
	
</acme:form>
