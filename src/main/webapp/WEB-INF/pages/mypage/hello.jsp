



<div id="content_main" class="row">
	<%--<nav class="navbar navbar-inverse navbar-fixed-top">--%>
		<%--<div class="container">--%>
			<%--<div class="navbar-header">--%>
				<%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">--%>
					<%--<span class="sr-only">Toggle navigation</span>--%>
					<%--<span class="icon-bar"></span>--%>
					<%--<span class="icon-bar"></span>--%>
					<%--<span class="icon-bar"></span>--%>
				<%--</button>--%>
				<%--<a class="navbar-brand" href="#">Demo Project</a>--%>
			<%--</div>--%>
			<%--<div id="navbar" class="navbar-collapse collapse">--%>
				<%--<form class="navbar-form navbar-right" action="/registration">--%>
					<%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
					<%--&lt;%&ndash;<input placeholder="Email" class="form-control" type="text">&ndash;%&gt;--%>
					<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
					<%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
					<%--&lt;%&ndash;<input placeholder="Password" class="form-control" type="password">&ndash;%&gt;--%>
					<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
					<%--<button id="bSignIn" type="button" class="btn btn-success">Sign in</button>--%>
					<%--<button id="bSignUp" type="submit" class="btn btn-danger">Sign up</button>--%>
				<%--</form>--%>
			<%--</div><!--/.navbar-collapse -->--%>
		<%--</div>--%>
	<%--</nav>--%>
	<div class="welcomePart">
		<h1>${message}</h1>
	</div>

	<div class="signInPart">
		<form class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputUsername" class="sr-only">Username</label>
			<input id="inputUserName" class="form-control" placeholder="Username" required="" autofocus="" type="text">
			<label for="inputPassword" class="sr-only">Password</label>
			<input id="inputPassword" class="form-control" placeholder="Password" required="" type="password">
			<div class="checkbox">
				<label>
					<input value="remember-me" type="checkbox"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>


</div>
<%--<script src="/contents/js/jquery-ui-1.10.4.min.js"></script>--%>
<script src="/contents/js/jquery-1.10.1.min.js"></script>
<script>
	$(document).ready(function(){
		$(".welcomePart").show();
		$(".signInPart").hide();


		$('#bSignIn').click(function(){
			$(".welcomePart").hide();
			$(".signInPart").show();
		});

//		$('#bSignUp').click(function(){
//			$(".welcomePart").hide();
//			$(".signInPart").hide();
//			$(".signUpPart").show();
//		});

	});


</script>


