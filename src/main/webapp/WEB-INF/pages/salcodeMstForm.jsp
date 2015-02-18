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
	<form:form commandName="salcodeMst" name="SalcodeMstForm" action="salcodeMstForm" method="post" cssClass="well">
	<input type="hidden" name="isNew" value="${(not empty salcodeMst.PA_SLCM_SALCODE && salcodeMst.PA_SLCM_SALCODE != '0') ? 'false' : 'true'}"/>
	
	<spring:bind path="salcodeMst.PA_SLCM_SALCODE">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALCODE"/>
        <form:input path="PA_SLCM_SALCODE" id="PA_SLCM_SALCODE" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="PA_SLCM_SALCODE" cssClass="help-block"/>
    </div>
    <spring:bind path="salcodeMst.PA_SLCM_SALDESC">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALDESC"/>
        <form:input path="PA_SLCM_SALDESC" id="PA_SLCM_SALDESC" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="PA_SLCM_SALDESC" cssClass="help-block"/>
    </div>
    <spring:bind path="salcodeMst.PA_SLCM_SHRTNAME">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SHRTNAME"/>
        <form:input path="PA_SLCM_SHRTNAME" id="PA_SLCM_SHRTNAME" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="PA_SLCM_SHRTNAME" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_SALTYPE">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALTYPE"/>
        <form:select path="PA_SLCM_SALTYPE" id="salType" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="E">E-Earnings</option>
            <option value="D">D-Deductions</option>
        </form:select>
        <form:errors path="PA_SLCM_SALTYPE" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_PERIOD">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_PERIOD"/>
        <form:select path="PA_SLCM_PERIOD" id="salPeriod" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="M">M-Monthly</option>
            <option value="D">D-Daily</option>
            <option value="Y">Y-Yearly</option>
            <option value="A">A-Adhoc</option>
            <option value="R">R-Random</option>
        </form:select>
        <form:errors path="PA_SLCM_PERIOD" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_SALCAT">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_SALCAT"/>
        <form:select path="PA_SLCM_SALCAT" id="salCategory" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="P">P-Perks</option>
            <option value="A">A-Allowance</option>
            <option value="O">O-Others</option>
        </form:select>
        <form:errors path="PA_SLCM_SALCAT" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_PRORATA">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_PRORATA"/>
        <form:select path="PA_SLCM_PRORATA" id="prorata" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="Y">Y-Yes</option>
            <option value="N">N-No</option>
        </form:select>
        <form:errors path="PA_SLCM_PRORATA" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_STATUS">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_STATUS"/>
        <form:select path="PA_SLCM_STATUS" id="status" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="A">A-Active</option>
            <option value="I">I-Inactive</option>
        </form:select>
        <form:errors path="PA_SLCM_STATUS" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_ITTAXBL">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_ITTAXBL"/>
        <form:select path="PA_SLCM_ITTAXBL" id="taxable" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="Y">Y-Yes</option>
            <option value="N">N-No</option>
        </form:select>
        <form:errors path="PA_SLCM_ITTAXBL" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_CCEMPJVTAG">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_CCEMPJVTAG"/>
        <form:select path="PA_SLCM_CCEMPJVTAG" id="prorata" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="N">N-No</option>
            <option value="E">E-Employee</option>
            <option value="C">C-Cost centre</option>
        </form:select>
        <form:errors path="PA_SLCM_CCEMPJVTAG" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_ITPJTN">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_ITPJTN"/>
        <form:select path="PA_SLCM_ITPJTN" id="projection" cssClass="form-control">
            <option value="">-Select-</option>
            <option value="Y">Y-Yes</option>
            <option value="N">N-No</option>
        </form:select>
        <form:errors path="PA_SLCM_ITPJTN" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_REGCODE">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_REGCODE"/>
        <form:input path="PA_SLCM_REGCODE" id="PA_SLCM_REGCODE" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="PA_SLCM_REGCODE" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_REGSLOT">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_REGSLOT"/>
        <form:input path="PA_SLCM_REGSLOT" id="PA_SLCM_REGSLOT" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="PA_SLCM_REGSLOT" cssClass="help-block"/>
    </div>
	<spring:bind path="salcodeMst.PA_SLCM_REGSLOT_TITL">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label styleClass="control-label" key="salcodeMst.PA_SLCM_REGSLOT_TITL"/>
        <form:input path="PA_SLCM_REGSLOT_TITL" id="PA_SLCM_REGSLOT_TITL" maxlength="50" autofocus="true" cssClass="form-control"/>
        <form:errors path="PA_SLCM_REGSLOT_TITL" cssClass="help-block"/>
    </div>
    
    <div class="form-group form-actions">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>

        <c:if test="${not empty salcodeMst.PA_SLCM_SALCODE && salcodeMst.PA_SLCM_SALCODE != '0'}">
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

<v:javascript formName="salcodeMst" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>
	