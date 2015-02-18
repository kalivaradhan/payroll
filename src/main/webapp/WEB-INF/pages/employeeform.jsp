<%@ include file="/common/taglibs.jsp"%>
<head>
<title>Add Employee</title>
<meta name="menu" content="Master"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="employeeList.employee"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-3">
    <h2><fmt:message key='employeeDetail.heading'/></h2>
</div>
<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>

    <form:form commandName="employee" method="post" action="employeeform" id="employeeForm"
               cssClass="well" onsubmit="return validateEmployee(this)"
               enctype="multipart/form-data">
    <form:hidden path="id"/>

    <spring:bind path="employee.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="employee.name"/>
        <form:input path="name" id="name" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="name" cssClass="help-block"/>
    </div>

    <spring:bind path="employee.office">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="employee.office"/>
        <form:select path="office" id="office" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="Alpha">Alpha</option>
            <option value="Bravo">Bravo</option>
            <option value="Charlie">Charlie</option>
        </form:select>
        <form:errors path="office" cssClass="help-block"/>
    </div>
    
    <spring:bind path="employee.interests">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="employee.interests"/>
        <form:textarea path="interests" rows="5" cols="30" class="form-control"/>
        <form:errors path="interests" cssClass="help-block"/>
    </div>

    <spring:bind path="employee.fullTimeEmployee">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="employee.fullTimeEmployee"/>&nbsp;&nbsp;
        <form:radiobutton path="fullTimeEmployee" value="Yes"/>&nbsp;Yes 
        <form:radiobutton path="fullTimeEmployee" value="No"/>&nbsp;No
        <form:errors path="fullTimeEmployee" cssClass="help-block"/>
    </div>
    
    <spring:bind path="employee.certifications">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="employee.certifications"/>&nbsp;&nbsp;
        <form:checkbox path="certifications" value="Oracle"/>&nbsp;Oracle 
        <form:checkbox path="certifications" value="Microsoft"/>&nbsp;Microsoft 
        <form:checkbox path="certifications" value="Cisco"/>&nbsp;Cisco
        <form:errors path="certifications" cssClass="help-block"/>
    </div>

    <spring:bind path="employee.profilePhoto">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="employee.profilePhoto"/>&nbsp;&nbsp;
        <input class="" name="profilePhoto" type="file" title="">
        <form:errors path="profilePhoto" cssClass="help-block"/>
    </div>

    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>

        <c:if test="${not empty employee.id}">
          <button type="submit" class="btn btn-default" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
              <i class="icon-trash"></i> <fmt:message key="button.delete"/>
          </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
    </form:form>
</div>

<v:javascript formName="employee" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>
