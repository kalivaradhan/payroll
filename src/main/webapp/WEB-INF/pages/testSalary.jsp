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

    <display:table name="testSalary" class="table table-condensed table-striped table-hover"
            requestURI="" id="testSalary" export="true" pagesize="25" defaultsort="1">
        <display:column property="salcode" sortable="true" titleKey="Code"/>
        <display:column property="saldesc" sortable="true" titleKey="Description"/>
        <display:column property="shrtname" sortable="true" titleKey="Short Name"/>
    </display:table>
</div>