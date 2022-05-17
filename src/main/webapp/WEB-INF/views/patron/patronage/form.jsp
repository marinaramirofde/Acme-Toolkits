<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!-- "budget", "code", "creationMoment", "endMoment", "info", "legalStuff","startMoment","status","patron.fullName","patron.info","patron.statement"-->	
	<acme:input-moment code="patron.patronage.form.label.creationMoment" path="creationMoment" readonly = "true"/>
	<acme:input-moment code="patron.patronage.form.label.endMoment" path="endMoment"/>
	<acme:input-moment code="patron.patronage.form.label.startMoment" path="startMoment"/>
	<acme:input-textbox code="patron.patronage.form.label.code" path="code"/>			
	<acme:input-textbox code="patron.patronage.form.label.info" path="info"/>
	<acme:input-money code="patron.patronage.form.label.budget" path="budget"/>
	<acme:input-textbox code="patron.patronage.form.label.legalStuff" path="legalStuff"/>
	<acme:input-select code="patron.patronage.form.label.status" path="status">
		<acme:input-option code="PROPOSED" value="PROPOSED" selected="${status == 'PROPOSED'}"/>
		<acme:input-option code="ACCEPTED" value="ACCEPTED" selected="${status == 'ACCEPTED'}"/>
		<acme:input-option code="DENIED" value="DENIED" selected="${status == 'DENIED'}"/>
	</acme:input-select>
	
	<jstl:choose>	 
	    <jstl:when test="${acme:anyOf(command, 'show') && published == true}">
	    <acme:input-textbox code="patron.patronage.form.label.inventor.id" path="inventor.id"/>
	    <acme:input-textbox code="patron.patronage.form.label.inventor.fullName" path="inventorFullName"/>
	    </jstl:when>
		<jstl:when test="${acme:anyOf(command, 'show, update, publish, delete') && published == false}">
			<acme:input-select code="patron.patronage.form.label.inventor.fullName"  path="inventor.id">
		  	  	<jstl:forEach items="${inventors}" var="inventor">
		   	  	<acme:input-option code="${inventor.getIdentity().getFullName()}" value="${inventor.getId()}" selected="${inventor.getId()==inventorX}"/>
		   	  	</jstl:forEach>
		   	</acme:input-select>
	        <acme:input-textbox code="patron.patronage.form.label.inventor.fullName" readonly="true" path="inventorFullName"/>
	
			<acme:submit code="patron.patronage.form.button.update" action="/patron/patronage/update"/>
			<acme:submit code="patron.patronage.form.button.publish" action="/patron/patronage/publish"/>
			<acme:submit code="patron.patronage.form.button.delete" action="/patron/patronage/delete"/>
		</jstl:when>
		<jstl:when test="${command == 'create'}">
		    <acme:input-select code="patron.patronage.form.label.inventor.fullName"  path="inventor.id">
		  	  	<jstl:forEach items="${inventors}" var="inventor">
		   	  	<acme:input-option code="${inventor.getIdentity().getFullName()}" value="${inventor.getId()}" selected="${inventor.getId()==inventorX}"/>
		   	  	</jstl:forEach>
		   	</acme:input-select>
			<acme:submit code="patron.patronage.form.button.create" action="/patron/patronage/create"/>
		</jstl:when>
	</jstl:choose>
	

	
</acme:form>
