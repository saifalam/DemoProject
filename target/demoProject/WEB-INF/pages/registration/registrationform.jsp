<%--
  Created by IntelliJ IDEA.
  User: saif
  Date: 3/27/15
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="signUpPart">
  <h2>User Registration Form</h2>
  <form:form method="POST" commandName="viewModel">
    <table>
      <tr>
        <td>Name:</td>
        <td><form:input path="fullName" /></td>
        <td><form:errors path="fullName" cssClass="error" /></td>
      </tr>

      <tr>
        <td>Username:</td>
        <td><form:input path="userName" /></td>
        <td><form:errors path="userName" cssClass="error" /></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cssClass="error" /></td>
      </tr>

      <tr>
        <td>Birthday:</td>
        <td><form:input path="dateOfBirth" placeholder="MM/dd/yyyy"/></td>
        <td><form:errors path="dateOfBirth" cssClass="error" /></td>
      </tr>
      <tr>
        <td>Phone:</td>
        <td><form:input path="mobileNo" /></td>
        <td><form:errors path="mobileNo" cssClass="error" /></td>
      </tr>

      <tr>
        <td>Gender:</td>
        <td><form:select path="gender">
          <form:option value="" label="Select Gender" />
          <form:option value="MALE" label="Male" />
          <form:option value="FEMALE" label="Female" />
        </form:select></td>
        <td><form:errors path="gender" cssClass="error" /></td>
      </tr>

      <tr>
        <td>&nbsp;</td>
        <td colspan="2"><input type="submit" value="Save User"></td>
      </tr>
    </table>

  </form:form>

</div>

