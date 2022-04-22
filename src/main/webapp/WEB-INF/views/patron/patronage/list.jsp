<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.patron.list.label.company" path="company" width="20%"/>
	<acme:list-column code="any.patron.list.label.info" path="info" width="10%"/>
	<acme:list-column code="any.patron.list.label.statement" path="statement" width="70%"/>	
</acme:list>
