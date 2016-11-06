<html>
<head>
<meta charset="utf-8">
    <title>Spring MVC Form Handling</title>
    <script src="jquery-1.12.3.min.js"></script>
</head>
<body>
  <div style="background-color:black;width:800px;height:300px;color:white;position: absolute;left:18%;">
  	<div id="errormsg" style="position:absolute;left:45%;top:73%;color:white;">username : admin , password : admin</div>
    <div style="position: absolute;left:16%;">
    <h2>Spring mvc+freemaker+mybatis Login system</h2>
    <div style="position: absolute;left:25%;top:150%" id="mainform">
    <form method="POST" action="">
       <table style="color:white;">
        <tr>
            <td><p>username</p></td>
            <td colspan="2"><input id="username" type="text" name="userName" style="width:200px;margin-left:20px;"></td>
        </tr>
        <tr style="height:80px;">
            <td>password</td>
            <td colspan="2"><input id="passwd" type="password" name="password" style="width:200px;margin-left:20px;"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="Submit" id="submit"/>
            </td>
        </tr>
      </table>
    </form>
  </div>
  </div>
  </div>
<script>
$(document).ready(function(){
	$("#submit").click(function(){
		$.post("CheckValid",{userName:$("#username").val(),password:$("#passwd").val()},function(result){
			if (result == "valid"){
				document.getElementById("mainform").innerHTML='';
				document.getElementById("mainform").innerHTML='<h3>Login successfully!!this page will change after 5 seconds</h3>';
				window.setTimeout(function(){window.location.href='changePage.html';},5000);
			}
			else{
				document.getElementById('errormsg').innerHTML='ERROR : wrong password or username does not exists!';
			}
		});
	});
});
</script>

</body>
</html>
