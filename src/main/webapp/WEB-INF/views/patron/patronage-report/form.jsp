<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="patron.patronage-report.form.label.sequenceNumber" path="sequenceNumber"/>
	<acme:input-moment code="patron.patronage-report.form.label.creationMoment" path="creationMoment" readonly = "true"/>
	<acme:input-textarea code="patron.patronage-report.form.label.memorandum" path="memorandum"/>
	<acme:input-url code="patron.patronage-report.form.label.info" path="info"/>
</acme:form>
