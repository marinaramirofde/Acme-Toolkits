<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="administrator.system-configuration.form.label.system-currency" path="systemCurrency"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.accepted-currencies" path="acceptedCurrencies"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.strong-terms" path="strongTerms"/>
	<acme:input-double code="administrator.system-configuration.form.label.strong-threshold" path="strongThreshold"/>
	<acme:input-textbox code="administrator.system-configuration.form.label.weak-terms" path="weakTerms"/>
	<acme:input-double code="administrator.system-configuration.form.label.weak-threshold" path="weakThreshold"/>	
</acme:form>
