<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<!-- "identity.name", "identity.surname","identity.email" -->
	<acme:input-textbox code="any.user-account.form.label.identity.name" path="identity.name"/>
	<acme:input-textbox code="any.user-account.form.label.identity.surname" path="identity.surname"/>		
	<acme:input-textbox code="any.user-account.form.label.identity.email" path="identity.email"/>	
	
</acme:form>
