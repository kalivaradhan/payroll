<%@ include file="/common/taglibs.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>:::Salary Element Master:::</title>
	<meta name="menu" content="Master"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="salcodeMstList.salcodeMst"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-3">
    <h2><fmt:message key='salcodeMst.heading'/></h2>
</div>
<div class="col-sm-7">
	<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
	<form:form commandName="salcodeMst" name="salcodeMst" action="salcodeMstForm" method="post"
	    cssClass="well">
	<input type="hidden" name="isNew"
	    value="${(not empty salcodeMst.PA_SLCM_SALCODE && salcodeMst.PA_SLCM_SALCODE != '0') ? 'false' : 'true'}"/>
	
	<spring:bind path="salcodeMst.PA_SLCM_SALCODE">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALCODE"/>
        <form:input name="PA_SLCM_SALCODE" path="PA_SLCM_SALCODE" id="PA_SLCM_SALCODE"
            maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="PA_SLCM_SALCODE" cssClass="help-block"/>
    </div>
    <spring:bind path="salcodeMst.PA_SLCM_SALDESC">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALDESC"/>
        <form:input name="PA_SLCM_SALDESC" path="PA_SLCM_SALDESC" id="PA_SLCM_SALDESC"
            maxlength="50" cssClass="form-control"/>
        <form:errors path="PA_SLCM_SALDESC" cssClass="help-block"/>
    </div>
    <spring:bind path="salcodeMst.PA_SLCM_SHRTNAME">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SHRTNAME"/>
        <form:inputt name="PA_SLCM_SHRTNAME" path="PA_SLCM_SHRTNAME" id="PA_SLCM_SHRTNAME"
            maxlength="50" cssClass="form-control"/>
        <form:errors path="PA_SLCM_SHRTNAME" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_SALTYPE">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALTYPE"/>
        <form:select path="PA_SLCM_SALTYPE" id="salType" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_SALTYPE=="" ? 'selected' : ''}>-Select-</option>
            <option value="E" ${salcodeMst.PA_SLCM_SALTYPE=="E" ? 'selected' : ''}>E-Earnings</option>
            <option value="D" ${salcodeMst.PA_SLCM_SALTYPE=="D" ? 'selected' : ''}>D-Deductions</option>
        </form:select>
        <form:errors path="PA_SLCM_SALTYPE" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_PERIOD">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_PERIOD"/>
        <form:select path="PA_SLCM_PERIOD" id="salPeriod" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_PERIOD=="" ? 'selected' : ''}>-Select-</option>
            <option value="M" ${salcodeMst.PA_SLCM_PERIOD=="M" ? 'selected' : ''}>M-Monthly</option>
            <option value="D" ${salcodeMst.PA_SLCM_PERIOD=="D" ? 'selected' : ''}>D-Daily</option>
            <option value="Y" ${salcodeMst.PA_SLCM_PERIOD=="Y" ? 'selected' : ''}>Y-Yearly</option>
            <option value="A" ${salcodeMst.PA_SLCM_PERIOD=="A" ? 'selected' : ''}>A-Adhoc</option>
            <option value="R" ${salcodeMst.PA_SLCM_PERIOD=="R" ? 'selected' : ''}>R-Random</option>
        </form:select>
        <form:errors path="PA_SLCM_PERIOD" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_SALCAT">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALCAT"/>
        <form:select path="PA_SLCM_SALCAT" id="salCategory" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_SALCAT=="" ? 'selected' : ''}>-Select-</option>
            <option value="P" ${salcodeMst.PA_SLCM_SALCAT=="P" ? 'selected' : ''}>P-Perks</option>
            <option value="A" ${salcodeMst.PA_SLCM_SALCAT=="A" ? 'selected' : ''}>A-Allowance</option>
            <option value="O" ${salcodeMst.PA_SLCM_SALCAT=="O" ? 'selected' : ''}>O-Others</option>
        </form:select>
        <form:errors path="PA_SLCM_SALCAT" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_PRORATA">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_PRORATA"/>
        <form:select path="PA_SLCM_PRORATA" id="prorata" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_PRORATA=="" ? 'selected' : ''}>-Select-</option>
            <option value="Y" ${salcodeMst.PA_SLCM_PRORATA=="Y" ? 'selected' : ''}>Y-Yes</option>
            <option value="N" ${salcodeMst.PA_SLCM_PRORATA=="N" ? 'selected' : ''}>N-No</option>
        </form:select>
        <form:errors path="PA_SLCM_PRORATA" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_STATUS">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_STATUS"/>
        <form:select path="PA_SLCM_STATUS" id="status" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_STATUS=="" ? 'selected' : ''}>-Select-</option>
            <option value="A" ${salcodeMst.PA_SLCM_STATUS=="A" ? 'selected' : ''}>A-Active</option>
            <option value="I" ${salcodeMst.PA_SLCM_STATUS=="I" ? 'selected' : ''}>I-Inactive</option>
        </form:select>
        <form:errors path="PA_SLCM_STATUS" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_ITTAXBL">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_ITTAXBL"/>
        <form:select path="PA_SLCM_ITTAXBL" id="taxable" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_ITTAXBL=="" ? 'selected' : ''}>-Select-</option>
            <option value="Y" ${salcodeMst.PA_SLCM_ITTAXBL=="Y" ? 'selected' : ''}>Y-Yes</option>
            <option value="N" ${salcodeMst.PA_SLCM_ITTAXBL=="N" ? 'selected' : ''}>N-No</option>
        </form:select>
        <form:errors path="PA_SLCM_ITTAXBL" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_CCEMPJVTAG">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_CCEMPJVTAG"/>
        <form:select path="PA_SLCM_CCEMPJVTAG" id="prorata" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_CCEMPJVTAG=="" ? 'selected' : ''}>-Select-</option>
            <option value="N" ${salcodeMst.PA_SLCM_CCEMPJVTAG=="N" ? 'selected' : ''}>N-No</option>
            <option value="E" ${salcodeMst.PA_SLCM_CCEMPJVTAG=="E" ? 'selected' : ''}>E-Employee</option>
            <option value="C" ${salcodeMst.PA_SLCM_CCEMPJVTAG=="C" ? 'selected' : ''}>C-Cost centre</option>
        </form:select>
        <form:errors path="PA_SLCM_CCEMPJVTAG" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_ITPJTN">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_ITPJTN"/>
        <form:select path="PA_SLCM_ITPJTN" id="projection" cssClass="form-control">
            <option value="" ${salcodeMst.PA_SLCM_ITPJTN=="" ? 'selected' : ''}>-Select-</option>
            <option value="Y" ${salcodeMst.PA_SLCM_ITPJTN=="Y" ? 'selected' : ''}>Y-Yes</option>
            <option value="N" ${salcodeMst.PA_SLCM_ITPJTN=="N" ? 'selected' : ''}>N-No</option>
        </form:select>
        <form:errors path="PA_SLCM_ITPJTN" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_REGCODE">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_REGCODE"/>
        <form:input path="PA_SLCM_REGCODE" id="PA_SLCM_REGCODE" maxlength="50"
            cssClass="form-control"/>
        <form:errors path="PA_SLCM_REGCODE" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_REGSLOT">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_REGSLOT"/>
        <form:input path="PA_SLCM_REGSLOT" id="PA_SLCM_REGSLOT" maxlength="50"
            cssClass="form-control"/>
        <form:errors path="PA_SLCM_REGSLOT" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_REGSLOT_TITL">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_REGSLOT_TITL"/>
        <form:input path="PA_SLCM_REGSLOT_TITL" id="PA_SLCM_REGSLOT_TITL" maxlength="50"
            cssClass="form-control"/>
        <form:errors path="PA_SLCM_REGSLOT_TITL" cssClass="help-block"/>
    </div>
    
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>

        <c:if test="${not empty salcodeMst.PA_SLCM_SALCODE && salcodeMst.PA_SLCM_SALCODE != '0'}">
          <button type="submit" class="btn btn-default" name="delete"
                  onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
              <i class="icon-trash"></i> <fmt:message key="button.delete"/>
          </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
	</form:form>
</div>

<v:javascript formName="salcodeMst" cdata="false" dynamicJavascript="true"
    staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>