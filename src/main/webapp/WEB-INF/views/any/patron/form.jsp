<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!-- "company", "info", "statement" -->
	<acme:input-textbox code="any.patron.form.label.company" path="company"/>
	<acme:input-textbox code="any.patron.form.label.info" path="info"/>		
	<acme:input-textbox code="any.patron.form.label.statement" path="statement"/>	
	
</acme:form>
