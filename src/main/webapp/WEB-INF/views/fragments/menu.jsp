<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.roles.Provider,acme.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
	
	<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">

			<acme:menu-suboption code="54183920Z: Lorenzo Casas, Angel" action="https://www.youtube.com/"/>
			<acme:menu-suboption code="47557390Z: Avila Sanchez, Rafael" action="https://es.wikipedia.org/" />
			<acme:menu-suboption code="47394372C: Suarez Perea, Daniel" action="http://www.twitter.com/"/>
			<acme:menu-suboption code="47428674Y: Montalban Martin, Raul" action="http://www.twitch.com/"/>
			<acme:menu-suboption code="X7517297T: Danko, Siamion" action="https://www.youtube.com/"/>
			<acme:menu-suboption code="75902954X: Ramiro Fernandez, Marina" action="https://www.pinterest.de/"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.item.list-all-tools" action="/any/item/list-all-tools"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.chirp.list-recent-chirps" action="/any/chirp/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.toolkit.list-all" action="/any/quantity/list-all-toolkits"/>
			<acme:menu-separator/>
		        <acme:menu-suboption code="master.menu.any.user-account.list" action="/any/user-account/list-all-userAccounts"/>
			<acme:menu-separator/>
		</acme:menu-option>
		
		
		<acme:menu-option code="master.menu.authenticated" access="hasRole('Authenticated')">
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.authenticated.item.list-all-tools" action="/any/item/list-all-tools"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.toolkit.list-all" action="/any/quantity/list-all-toolkits"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.authenticated.system-configuration" action="/authenticated/system-configuration/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.authenticated.announcement.list" action="/authenticated/announcement/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.any.user-account.list" action="/any/user-account/list-all-userAccounts"/>
			
			<acme:menu-suboption code="master.menu.any.chirp.list-recent-chirps" action="/any/chirp/list"/>
			
			
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
            <acme:menu-suboption code="master.menu.patron.patronage-report.list-mine-patronage-report" action="/patron/patronage-report/list-patronage-reports"/>
            <acme:menu-suboption code="master.menu.patron.patronages.list-all-mine-patronages" action="/patron/patronage/list-all-mine-patronages"/>
        </acme:menu-option>

        <acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
            
           
            <acme:menu-suboption code="master.menu.inventor.item.list-all-mine-items" action="/inventor/item/list-all-mine-items"/>

             <acme:menu-suboption code="master.menu.inventor.patronage.list-all-mine-patronages" action="/inventor/patronage/list-all-mine-patronages"/>

			 <acme:menu-suboption code="master.menu.inventor.patronage-reports.list-all-mine-patronage-reports" action="/inventor/patronage-report/list-inventor-patronage-reports"/>
             
             <acme:menu-suboption code="master.menu.inventor.toolkits.list" action="/inventor/toolkit/list"/>
        <acme:menu-separator/>
	   </acme:menu-option>
	
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-suboption code="master.menu.administrator.system-configuration" action="/administrator/system-configuration/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
			
		</acme:menu-option>
		
		

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		
		
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			
			<acme:menu-suboption code="master.menu.user-account.become-inventor" action="/authenticated/inventor/create" access="!hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.inventor" action="/authenticated/inventor/update" access="hasRole('Inventor')"/>
			<acme:menu-suboption code="master.menu.user-account.become-patron" action="/authenticated/patron/create" access="!hasRole('Patron')"/>
			<acme:menu-suboption code="master.menu.user-account.patron" action="/authenticated/patron/update" access="hasRole('Patron')"/>
			
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

