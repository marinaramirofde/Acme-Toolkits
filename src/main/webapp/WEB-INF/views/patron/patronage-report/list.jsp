<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>	
	<acme:list-column code="patron.patronage-report.list.label.patronageId" path="patronageId" width="40%"/>
	<acme:list-column code="patron.patronage-report.list.label.creationMoment" path="creationMoment" width="30%"/>
	<acme:list-column code="patron.patronage-report.list.label.info" path="info" width="30%"/>
</acme:list>
