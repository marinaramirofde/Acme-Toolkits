<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="inventor.patronage.list.label.info" path="info" width="20%"/>
	<acme:list-column code="inventor.patronage.list.label.code" path="code" width="10%"/>
	<acme:list-column code="inventor.patronage.list.label.legalStuff" path="legalStuff" width="70%"/>	
</acme:list>
