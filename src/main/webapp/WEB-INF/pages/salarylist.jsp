<%@ include file="/common/taglibs.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:::salary Master:::</title>
<meta name="menu" content="Master"/>
</head>


<div class="col-sm-10">
    <h2>Salary Element Master</h2>

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/salaryform'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="salaryList" class="table table-condensed table-striped table-hover"
            requestURI="" id="salaryList" export="true" pagesize="25" defaultsort="1">
        <display:column property="salcode" sortable="true" titleKey="Code"
            href="salaryform" media="html" paramId="salcode" paramProperty="salcode"/>
        <display:column property="saldesc" sortable="true" titleKey="Description"/>
        <display:column property="shrtname" sortable="true" titleKey="Short Name"/>

        <display:setProperty name="paging.banner.item_name">
            <fmt:message key="Salary Element"/>
        </display:setProperty>
        <display:setProperty name="paging.banner.items_name">
            <fmt:message key="Salary Elements"/>
        </display:setProperty>

        <display:setProperty name="export.excel.filename">
            <fmt:message key="salaryList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename">
            <fmt:message key="salaryList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename">
            <fmt:message key="salaryList.title"/>.pdf</display:setProperty>
    </display:table>
</div>