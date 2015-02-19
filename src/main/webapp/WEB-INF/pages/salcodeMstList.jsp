<%@ include file="/common/taglibs.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>:::salary Master:::</title>
    <meta name="menu" content="Master"/>
    <script type="text/javascript">
        var salType = {"E":"E-Earnings", "D":"D-Deductions"};
        var regCode = {"E":"E-Earnings", "D":"D-Deductions"};
        var status = {"A":"A-Active", "I":"I-Inactive"};
    </script>
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
        <display:column property="PA_SLCM_SALCODE" href="salcodeMstForm" sortable="true"
            titleKey="Code" media="html" paramId="PA_SLCM_SALCODE" paramProperty="PA_SLCM_SALCODE"/>
        <display:column property="PA_SLCM_SALDESC" sortable="true" titleKey="Desc"/>
        <display:column property="PA_SLCM_SHRTNAME" sortable="true" titleKey="Short Name"/>
        <display:column property="PA_SLCM_SALTYPE" sortable="true" titleKey="Salary Type">
            <script type="text/javascript">
                var PA_SLCM_SALTYPE = salType["${salcodeMstList.PA_SLCM_SALTYPE}"];
                var PA_SLCM_SALTYPE_ID = "PA_SLCM_SALTYPE_"+${salcodeMstList.PA_SLCM_SALCODE};
                console.log(document.getElementById(PA_SLCM_SALTYPE_ID));
                if(null != document.getElementById(PA_SLCM_SALTYPE_ID) && undefined != document.getElementById(PA_SLCM_SALTYPE_ID)){
                	document.getElementById(PA_SLCM_SALTYPE_ID).innerHTML = PA_SLCM_SALTYPE;
 				}
            </script>
            <div id=PA_SLCM_SALTYPE_${salcodeMstList.PA_SLCM_SALCODE}> </div>
        </display:column>
        <display:column property="PA_SLCM_REGCODE" sortable="true" titleKey="Reg Code">
            <script type="text/javascript">
                /*var PA_SLCM_REGCODE = regCode.[${salcodeMstList.PA_SLCM_REGCODE}];
                alert(PA_SLCM_REGCODE);
                document.getElementById("PA_SLCM_REGCODE").html = PA_SLCM_REGCODE;*/
            </script>
            <div id="PA_SLCM_REGCODE"></div>
        </display:column>
        <display:column property="PA_SLCM_STATUS" sortable="true" titleKey="Status">
            <script type="text/javascript">
                /*var PA_SLCM_STATUS = status.[${salcodeMstList.PA_SLCM_STATUS}];
                alert(PA_SLCM_STATUS);
                document.getElementById("PA_SLCM_STATUS").html = PA_SLCM_STATUS;*/
            </script>
            <div id="PA_SLCM_STATUS"></div>
        </display:column>

        <display:setProperty name="paging.banner.item_name">
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
            <fmt:message key="Salary Element"/>.pdf</display:setProperty>
    </display:table>
</div>