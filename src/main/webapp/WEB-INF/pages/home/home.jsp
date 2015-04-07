<%--
  Created by IntelliJ IDEA.
  User: saif
  Date: 4/7/15
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="content_main" class="row">

  <div class="welcomePart">
    <h1>${message}</h1>
    <form action="/j_spring_security_logout">
      <input type="submit" name="logout" value="logout">
    </form>
  </div>

</div>
<%--<script src="/contents/js/jquery-ui-1.10.4.min.js"></script>--%>
<script src="/contents/js/jquery-1.10.1.min.js"></script>
<script>
  $(document).ready(function(){
    $(".welcomePart").show();
  });


</script>


