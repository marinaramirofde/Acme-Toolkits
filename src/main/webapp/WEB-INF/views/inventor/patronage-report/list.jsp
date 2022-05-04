<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.patronageReport.list.label.patronageId" path="patronageId"/>
	<acme:list-column code="inventor.patronageReport.list.label.creationMoment" path="creationMoment"/>
</acme:list>

