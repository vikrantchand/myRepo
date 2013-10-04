<!DOCTYPE html>
<html lang="en">
<head>
<title>Register With us!</title>
<meta charset="utf-8">
<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
	media="all">
<link rel="stylesheet" href="resources/css/layout.css" type="text/css"
	media="all">
<link rel="stylesheet" href="resources/css/style.css" type="text/css"
	media="all">
<script type="text/javascript" src="resources/js/jquery-1.5.2.js"></script>
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

    <link rel="stylesheet" href="resources/css/redmond/jquery-ui.css">
    <link rel="stylesheet" href="resources/css/redmond/jquery.ui.theme.css">
    <link rel="stylesheet" href="resources/css/jqgrid/ui.jqgrid.css">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js" type="text/javascript"></script>
    <script src="http://www.trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
    <script src="http://www.trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>
<script src="resources/js/multifield.js"></script>
<script src="resources/js/validator.min.js"></script>
<script src="resources/js/validator.js"></script>
<script src="resources/js/applyValidation.js"></script>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

</head>
<body id="page1">
<script>

function getData(){
	 var name=document.getElementById("name").value;
	 var email=document.getElementById("email").value;
	 var mobile=document.getElementById("mobile").value;
	 var occupation=document.getElementById("occupation").value;
	 var phone=document.getElementById("phone").value;
	 var password=document.getElementById("password").value;
	 var gender=document.getElementById("gender").value;
	 var dob=document.getElementById("dob").value;
	 
	 
	 var obj={"name":name,"email":email,"mobile":mobile,"occupation":occupation,"phone":phone,"password":password,"gender":gender,"dob":dob,
 "city":"Jaipur" , "state":"Rajasthan","streetAddress":"Lions lane","ZIP":"302034","locality":"jksghj" };
	return JSON.stringify(obj);
	 
}



jQuery(document).ready(function($){
	$('#registerForm').submit(function(){
		/* var obj1=$('#registerForm').serialize(); */
		var userEntity=getData();
		$.ajax({
			 type: 'POST',
             url: 'user',
			 dataType: "json",
             data : userEntity,
             contentType: "application/json",
             success: function(data){
				 alert('success');
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
				<!-- 	<div class='options'>
						<label> <input type='checkbox' id='vfields' /> Vertical
							orientation
						</label> <label> <input type='checkbox' id='alerts' /> Disable
							alerts
						</label>
					</div> -->
				<h1 title='how forms should be done.'>
					<h4>Create An Account On Airlines</h4>
					<section class='form'>
						<form  id="registerForm" >
							
							<fieldset>
								<div class="item">
									<label> <span>Name</span> <input
										data-validate-length-range="2" data-validate-words="1"
										name="name" placeholder="ex. Vikrant Choudhary"
										required="required" type="text" id="name" />
									</label>
									<div class='tooltip help'>
										<span>?</span>
										<div class='content'>
											<b></b>
											<p>Name must be at least 2 characters</p>
										</div>
									</div>
								</div>
								<div class="item">
									<label> <span>Occupation</span> <input class='optional'
										name="occupation" data-validate-length-range="5,20"
										type="text" id="occupation" />
									</label>
									<div class='tooltip help'>
										<span>?</span>
										<div class='content'>
											<b></b>
											<p>
												An optional field. This field is only validated when it has
												a value.<br /> <em>Minimum 5 chars for this example.</em>
											</p>
										</div>
									</div>
									<span class='extra'>(optional)</span>
								</div>
								<div class="item">
									<label> <span>email</span> <input name="email"
										class='email' required="required" type="email" id="email" />
									</label>
								</div>
								<div class="item">
									<label> <span>Confirm email address</span> <input
										type="email" class='email' name="confirm_email"
										data-validate-linked='email' required='required'>
									</label>
								</div>
								<div class="item">
									<label> <span>Mobile No.</span> <input type="number"
										class='number' name="mobile"
										data-validate-length-range="10,10"
										data-validate-pattern="numeric" required='required'
										id="mobile">
									</label>
									<div class='tooltip help'>
										<span>?</span>
										<div class='content'>
											<b></b>
											<p>Number must be of 10 digits without Country Code</p>
										</div>
									</div>
								</div>
								<div class="item">
									<label> <span>DOB</span> <input class='date'
										type="date" name="dob" required='required' id="dob">
									</label>
								</div>
								<div class="item">
									<label> <span>Password</span> <input type="password"
										name="password" data-validate-length-range="6,10"
										required='required' id="password">
									</label>
									<div class='tooltip help'>
										<span>?</span>
										<div class='content'>
											<b></b>
											<p>Should be of length between 6 and 10 characters</p>
										</div>
									</div>
								</div>
								<div class="item">
									<label> <span>Repeat password</span> <input
										type="password" name="password2"
										data-validate-linked='password' required='required'>
									</label>
								</div>
								<div class="item">
									<label> <span>Telephone</span> <input type="tel" id="phone"
										class='tel' name="phone" data-validate-length-range="8,20">
									</label>
									<div class='tooltip help'>
										<span>?</span>
										<div class='content'>
											<b></b>
											<p>Notice that for a phone number user can input a '+'
												sign, a dash '-' or a space ' '</p>
										</div>
									</div>
								</div>
								<div class="item">
									<label> <span>Gender</span> <select class="required"
										name="gender" id="gender">
											<option value="">-- Gender --</option>
											<option value="Male">Male</option>
											<option value="Female">Female</option>

									</select>
									</label>
									<div class='tooltip help'>
										<span>?</span>
										<div class='content'>
											<b></b>
											<p>Choose something or choose not. what shall it be?</p>
										</div>
									</div>
								</div>

								<!-- <div class="item multi required">
									<label for='multi_first'> <span>Multifield</span>
									</label>
									<div class='input'>
										<input type="text" name="multi1" maxlength='4'
											id='multi_first'> <input type="text" name="multi2"
											maxlength='4'> <input type="text" name="multi3"
											maxlength='4'> <input type="text" name="multi4"
											maxlength='4'> <input type="text" name="multi5"
											maxlength='4'> <input type="text" name="multi6"
											maxlength='4'> <input data-validate-length-range="24"
											data-validate-pattern="alphanumeric" id="serial"
											name="serial" type="hidden" required='required' />
									</div>
									<div class='tooltip help'>
										<span>?</span>
										<div class='content'>
											<b></b>
											<p>This is a multifield, which let the user input a
												serial number or credit card number for example, and the
												trick is to validate the combined result, which is stored in
												a hidden field</p>
										</div>
									</div>
								</div> -->

								<tags:captcha
									privateKey="6LdZe8QSAAAAAA8DQu_WXpuxQpTVaQM0EYPvO1M5"
									publicKey="6LdZe8QSAAAAANw5tJUftmtx1m45kYk3fw8aNd1N"></tags:captcha>


							</fieldset>

							<button id='send' type='submit'>Submit</button>
						</form>
						
					</section>
			</div>
			  <table id="projectTable"></table>
 
			<script>
			validator.message['date'] = 'not a real date';

			// validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
			$('form').on('blur',
					'input[required], input.optional, select.required',
					validator.checkField).on('change', 'select.required',
					validator.checkField);

			$('.multi.required').on('keyup', 'input', function() {
				validator.checkField.apply($(this).siblings().last()[0]);
			}).on('blur', 'input', function() {
				validator.checkField.apply($(this).siblings().last()[0]);
			});

			// bind the validation to the form submit event
			//$('#send').click('submit');//.prop('disabled', true);

			$('form').submit(function(e) {
				e.preventDefault();
				var submit = true;
				// evaluate the form using generic validaing
				if (!validator.checkAll($(this))) {
					submit = false;
				}

				if (submit)
					this.submit();
				return false;
			});

			/* FOR DEMO ONLY */
			$('#vfields').change(function() {
				$('form').toggleClass('mode2');
			}).prop('checked', false);

			$('#alerts').change(function() {
				validator.defaults.alerts = (this.checked) ? false : true;
				if (this.checked)
					$('form .alert').remove();
			}).prop('checked', false);
			Cufon.now();
			</script>




		</section>
	
		<!--footer -->
		<%@include file="Footer.jsp"%>
		<!--footer end-->
	</div>
	<script type="text/javascript">
		
	</script>
	<script>
	
	$(document).ready(function() {
		tabs.init();
	});
	jQuery(document).ready(function($) {
		$('#form_1, #form_2, #form_3').jqTransform({
			imgPath : 'jqtransformplugin/img/'
		});
	});
	$(window).load(function() {
		$('#slider').nivoSlider({
			effect : 'fade', //Specify sets like: 'fold,fade,sliceDown, sliceDownLeft, sliceUp, sliceUpLeft, sliceUpDown, sliceUpDownLeft' 
			slices : 15,
			animSpeed : 500,
			pauseTime : 6000,
			startSlide : 0, //Set starting Slide (0 index)
			directionNav : false, //Next & Prev
			directionNavHide : false, //Only show on hover
			controlNav : false, //1,2,3...
			controlNavThumbs : false, //Use thumbnails for Control Nav
			controlNavThumbsFromRel : false, //Use image rel for thumbs
			controlNavThumbsSearch : '.jpg', //Replace this with...
			controlNavThumbsReplace : '_thumb.jpg', //...this in thumb Image src
			keyboardNav : true, //Use left & right arrows
			pauseOnHover : true, //Stop animation while hovering
			manualAdvance : false, //Force manual transitions
			captionOpacity : 1, //Universal caption opacity
			beforeChange : function() {
			},
			afterChange : function() {
			},
			slideshowEnd : function() {
			} //Triggers after all slides have been shown
		});
	});
	</script> 
</body>
</html>