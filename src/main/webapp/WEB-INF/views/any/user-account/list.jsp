<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>

    <!-- "roleList", "identity.name", "identity.surname" -->
	<acme:list-column code="any.user-account.list.label.roleList" path="roleList" width="20%"/>
	<acme:list-column code="any.user-account.list.label.identity.name" path="identity.name" width="10%"/>
	<acme:list-column code="any.user-account.list.label.identity.surname" path="identity.surname" width="70%"/>	
</acme:list>
