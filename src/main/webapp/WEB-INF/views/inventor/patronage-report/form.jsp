<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="inventor.patronageReport.form.label.sequenceNumber" path="sequenceNumber" readonly = "true"/>
	<acme:input-moment code="inventor.patronageReport.form.label.creationMoment" path="creationMoment" readonly = "true"/>
	<acme:input-textarea code="inventor.patronageReport.form.label.memorandum" path="memorandum" />
	<acme:input-url code="inventor.patronageReport.form.label.info" path="info"/>
	<jstl:if test="${!readonly}">
	<acme:input-checkbox code="inventor.patronageReport.form.label.confirmation" path="confirmation"/>
	<acme:submit code="inventor.patronageReport.form.button.create" action="/inventor/patronage-report/create"/>
	</jstl:if>
</acme:form> 