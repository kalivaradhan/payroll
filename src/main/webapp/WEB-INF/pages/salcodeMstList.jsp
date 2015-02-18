<%@ include file="/common/taglibs.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:::salary Master:::</title>
<meta name="menu" content="Master"/>
</head>
<div class="col-sm-10">
    <h2>Salary Element Master</h2>

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/salcodeMstForm' />">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
	
    <display:table name="salcodeMstList" class="table table-condensed table-striped table-hover"
            requestURI="" id="salcodeMstList" export="true" pagesize="25" defaultsort="1">
        <display:column property="PA_SLCM_SALCODE" href="salcodeMstForm" sortable="true" titleKey="Code" media="html" paramId="PA_SLCM_SALCODE" paramProperty="PA_SLCM_SALCODE"/>
        <display:column property="PA_SLCM_SALDESC" sortable="true" titleKey="Desc"/>
        <display:column property="PA_SLCM_SHRTNAME" sortable="true" titleKey="Short Name"/>
        <display:column property="PA_SLCM_SALTYPE" sortable="true" titleKey="Salary Type"/>
        <display:column property="PA_SLCM_REGCODE" sortable="true" titleKey="Reg Code"/>
        <display:column property="PA_SLCM_STATUS" sortable="true" titleKey="Status"/>

        <%-- <display:setProperty name="paging.banner.item_name">
            <fmt:message key="Salary Element"/>
        </display:setProperty>
        <display:setProperty name="paging.banner.items_name">
            <fmt:message key="Salary Elements"/>
        </display:setProperty>

        <display:setProperty name="export.excel.filename">
            <fmt:message key="Salary Element"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename">
            <fmt:message key="Salary Element"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename">
            <fmt:message key="Salary Element"/>.pdf</display:setProperty> --%>
    </display:table>
</div>