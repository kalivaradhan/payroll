<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="employeeList.title"/></title>
    <meta name="menu" content="Master"/>
</head>

<div class="col-sm-10">
    <h2><fmt:message key='employeeList.heading'/></h2>

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/employeeform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="employeeList" class="table table-condensed table-striped table-hover"
            requestURI="" id="employeeList" export="true" pagesize="25" defaultsort="1">
        <display:column property="name" sortable="true" titleKey="employee.name"
            href="employeeform" media="html" paramId="id" paramProperty="id"/>
        <display:column property="office" sortable="true" titleKey="employee.office"/>
        <display:column property="interests" sortable="true" titleKey="employee.interests"/>
        <display:column property="fullTimeEmployee" sortable="true"
            titleKey="employee.fullTimeEmployee"/>
        <display:column property="certifications" sortable="true"
            titleKey="employee.certifications"/>

        <display:setProperty name="paging.banner.item_name">
            <fmt:message key="employeeList.employee"/>
        </display:setProperty>
        <display:setProperty name="paging.banner.items_name">
            <fmt:message key="employeeList.employees"/>
        </display:setProperty>

        <display:setProperty name="export.excel.filename">
            <fmt:message key="employeeList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename">
            <fmt:message key="employeeList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename">
            <fmt:message key="employeeList.title"/>.pdf</display:setProperty>
    </display:table>
</div>