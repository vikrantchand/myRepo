<!DOCTYPE html>
<html lang="en">
<head>
<title>Register With us!</title>
<meta charset="utf-8">

<script src="resources/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/cufon-yui.js"></script>
<script type="text/javascript" src="resources/js/cufon-replace.js"></script>
<script type="text/javascript" src="resources/js/Cabin_400.font.js"></script>
<script type="text/javascript" src="resources/js/tabs.js"></script>
<script type="text/javascript" src="resources/js/jquery.jqtransform.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="resources/js/atooltip.jquery.js"></script>
<script type="text/javascript" src="resources/js/script.js"></script>
<link rel="stylesheet" href="resources/css/fv.css" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body id="page1">
<script>
jQuery(document).ready(function($){
	
	(function($){
	    $.fn.serializeObject = function(){

	        var self = this,
	            json = {},
	            push_counters = {},
	            patterns = {
	                "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
	                "key":      /[a-zA-Z0-9_]+|(?=\[\])/g,
	                "push":     /^$/,
	                "fixed":    /^\d+$/,
	                "named":    /^[a-zA-Z0-9_]+$/
	            };


	        this.build = function(base, key, value){
	            base[key] = value;
	            return base;
	        };

	        this.push_counter = function(key){
	            if(push_counters[key] === undefined){
	                push_counters[key] = 0;
	            }
	            return push_counters[key]++;
	        };

	        $.each($(this).serializeArray(), function(){

	            // skip invalid keys
	            if(!patterns.validate.test(this.name)){
	                return;
	            }

	            var k,
	                keys = this.name.match(patterns.key),
	                merge = this.value,
	                reverse_key = this.name;

	            while((k = keys.pop()) !== undefined){

	                // adjust reverse_key
	                reverse_key = reverse_key.replace(new RegExp("\\[" + k + "\\]$"), '');

	                // push
	                if(k.match(patterns.push)){
	                    merge = self.build([], self.push_counter(reverse_key), merge);
	                }

	                // fixed
	                else if(k.match(patterns.fixed)){
	                    merge = self.build([], k, merge);
	                }

	                // named
	                else if(k.match(patterns.named)){
	                    merge = self.build({}, k, merge);
	                }
	            }

	            json = $.extend(true, json, merge);
	        });

	        return json;
	    };
	})(jQuery);
	
	$('#Go').click(function(){
		 var data=JSON.stringify($("#bookTickets").serializeObject());
		$.ajax({
			 type: 'POST',
             url: 'ticket',
			 dataType: "json",
             data : data,
             contentType: "application/json",
             success: function(data){
				 alert(data);
			 },
				error:function(){
		      alert("failure");
				}
			
		});
		return false;
		
		});

});

</script>
	<div class="main">
		<%@include file="Header.jsp"%>
		<!--content -->
		<section id="content">
			<div id='wrap'>
				<form id="bookTickets">
				
					<table id="passengers">
						<tr>
							<th>Name</th>
							<th>age</th>
							<th>Gender</th>
						</tr>

						<c:forEach begin="0" end="${param.noOfPassengers-1}" step="1" varStatus="countLoop">
						
							<tr>
								<td style="border: 0px solid #000; padding: 15px;"><input  class="required" placeholder="Full Name" type="text" name="passengerList[${countLoop.index}][name]" id="name"
									maxlength="35"></td>
								<td style="border: 0px solid #000;  padding: 15px;"><input class="required" type="text" placeholder="Age"  name="passengerList[${countLoop.index}][age]" id="age" maxlength="3" size="4"></td>
								<td style="border: 0px solid #000;  padding: 15px;"><select name="passengerList[${countLoop.index}][gender]" id="gender">
										<option value="Male">Male</option>
										<option value="Female">Female</option>
								</select></td>
							</tr>





						</c:forEach>
					</table>
										<input type="hidden" id="noOfPassengers" name="noOfPassengers" value="${param.noOfPassengers}">
										<input type="hidden" id="scheduleId" name="scheduleId" value="${param.scheduleId}">
					<br>
				<input type="button" name="Go" id="Go" value="Book Tickets">
				</form>


			</div>
		</section>
		<!--content end-->
		<!--footer -->
		<%@include file="Footer.jsp"%>
		<!--footer end-->
	</div>
	<form id="new" action="new.html"/>

</body>
</html>