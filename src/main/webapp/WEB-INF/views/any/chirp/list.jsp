<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="any.chirp.list.label.title" path="title" width="20%"/>
	<acme:list-column code="any.chirp.list.label.creationMoment" path="creationMoment" width="10%"/>
	<acme:list-column code="any.chirp.list.label.author" path="author" width="70%"/>	
</acme:list>

<acme:button code="any.chirp.list.button.create" action="/any/chirp/create"/>
