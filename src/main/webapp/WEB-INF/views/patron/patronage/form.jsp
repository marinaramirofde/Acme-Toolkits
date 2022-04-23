<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!-- "budget", "code", "creationMoment", "endMoment", "info", "legalStuff","startMoment","status","patron.fullName","patron.info","patron.statement"-->	
	<acme:input-moment code="patron.patronage.form.label.creationMoment" path="creationMoment"/>
	<acme:input-moment code="patron.patronage.form.label.endMoment" path="endMoment"/>
	<acme:input-moment code="patron.patronage.form.label.startMoment" path="startMoment"/>
	<acme:input-textbox code="patron.patronage.form.label.code" path="code"/>			
	<acme:input-textbox code="patron.patronage.form.label.info" path="info"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<acme:input-money code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-select code="patron.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
	</acme:input-select>
	<acme:input-textbox code="patron.patronage.form.label.inventor.fullName" path="inventorFullName"/>
	<acme:input-textbox code="patron.patronage.form.label.inventor.company" path="inventor.company"/>
	<acme:input-textbox code="patron.patronage.form.label.inventor.info" path="inventor.info"/>
	<acme:input-textbox code="patron.patronage.form.label.inventor.statement" path="inventor.statement"/>
	

	
</acme:form>
