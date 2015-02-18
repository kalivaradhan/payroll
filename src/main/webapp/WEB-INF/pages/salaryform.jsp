<%@ include file="/common/taglibs.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:::Salary Element Master:::</title>
<meta name="menu" content="Master"/>
</head>


<form:form commandName="salary" name="SalcodeMst" action="salaryform" method="post">
<form:hidden path="salcode"/>

<spring:bind path="salary.salcode">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
</spring:bind>
<spring:bind path="salary.saldesc">
 <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
</spring:bind>
<spring:bind path="salary.shrtname">
 <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
</spring:bind>
<spring:bind path="salary.saltype">
 <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
</spring:bind>
<table border="0" align="center" style="width=100%" cellspacing="0" cellpadding="5">

    <tr><td>Sal. Code</td>
    	<td><form:input type="text" name="salcode" path="salcode" /></td>
    </tr>
    <tr><td>Description</td>
    	<td><form:input type="text" name="saldesc" path="saldesc" /></td>
    </tr>
    <tr><td>Short Name</td>
    	<td><form:input type="text" name="shrtname" path="shrtname" /></td>
    </tr>
    <tr><td>Sal. Type</td>
    	<td><form:input type="text" name="saltype" path="saltype" /></td>
    </tr>
    <tr><td>Sal. Category</td>
    	<td><form:input type="text" name="salcat" path="salcat" /></td>
    </tr>
    <tr><td>Regcode</td>
    	<td><form:input type="text" name="regcode" path="regcode" /></td>
    </tr>
</table>
<table border="2" align="center" cellspacing="0">
    <tr>
        <td><input type="submit" value="Save"></td>
        <td><input type="submit" name="cancel" value="Exit"></td>
    </tr>
</table>
</form:form>
