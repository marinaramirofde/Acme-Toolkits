<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!-- "budget", "code", "creationMoment", "endMoment", "info", "legalStuff","startMoment","status","patron.fullName","patron.info","patron.statement"-->	
	<acme:input-moment code="inventor.patronage.form.label.creationMoment" path="creationMoment"/>
	<acme:input-moment code="inventor.patronage.form.label.endMoment" path="endMoment"/>
	<acme:input-moment code="inventor.patronage.form.label.startMoment" path="startMoment"/>
	<acme:input-textbox code="inventor.patronage.form.label.code" path="code"/>			
	<acme:input-textbox code="inventor.patronage.form.label.info" path="info"/>
	<acme:input-money code="inventor.patronage.form.label.budget" path="budget"/>
	<acme:input-money code="inventor.patronage.form.label.legalStuff" path="legalStuff"/>
	
	<jstl:if test="${status != 'PROPOSED'}">
		<acme:input-textbox code="inventor.patronage.form.label.status" path="status" readonly="true"/>
	</jstl:if>
	
	<jstl:if test="${status == 'PROPOSED'}">
	<acme:input-select code="inventor.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
	</acme:input-select>
	</jstl:if>
	
	<acme:submit test="${acme:anyOf(command, 'show, update') && status == 'PROPOSED'}" 
	code="inventor.patronage.form.button.update" action="/inventor/patronage/update"/>
	
	<acme:input-textbox code="inventor.patronage.form.label.patron.fullName" path="patronFullName"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.company" path="patron.company"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.info" path="patron.info"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.statement" path="patron.statement"/>
	
	<acme:button code="inventor.patronage.form.button.patronageReports" action="/inventor/patronage-report/list-inventor-patronage-reports?masterId=${id}"/>
	<acme:button code="inventor.patronage.form.button.create" action="/inventor/patronage-report/create?masterId=${id}"/>
	
</acme:form>
