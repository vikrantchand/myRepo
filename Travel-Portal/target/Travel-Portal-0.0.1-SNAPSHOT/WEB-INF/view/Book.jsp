<!DOCTYPE html>
<html lang="en">
<head>
<title>Book</title>
<meta charset="utf-8">
<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
	media="all">
<link rel="stylesheet" href="resources/css/layout.css" type="text/css"
	media="all">
<link rel="stylesheet" href="resources/css/style.css" type="text/css"
	media="all">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="resources/js/atooltip.jquery.js"></script>
<script type="text/javascript" src="resources/js/cufon-yui.js"></script>
<script type="text/javascript" src="resources/js/cufon-replace.js"></script>
<script type="text/javascript" src="resources/js/Cabin_400.font.js"></script>
<script type="text/javascript" src="resources/js/tabs.js"></script>
<script type="text/javascript" src="resources/js/jquery.jqtransform.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="resources/js/atooltip.jquery.js"></script>
<script type="text/javascript" src="resources/js/script.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>


 <script type="text/javascript">

  $(function() {
    $( "#departureDate" ).datepicker({ minDate: -15, maxDate: "+3M +10D" });
 
        $( "#departureDate" ).datepicker( "option", "dateFormat","yy-mm-dd" );
     
  });
  $(function() {
    var availableTags = [
      "Jaipur",
      "Delhi",
      "Dehradun",
      "Indore",
      "Ajmer",
      "Mumbai",
      "Pune",
      "Goa",
      "Shimla"

    ];
	$( "#cityFrom" ).autocomplete({
      source: availableTags
    });
	$( "#cityTo" ).autocomplete({
      source: availableTags
    });
  });

  </script>




</head>
<body id="page3">
	<div class="main">
		<%@include file="Header.jsp"%>
		<!--content -->
		<section id="content">
			<div class="wrapper pad1">
				<article class="col1">
					<div class="box1">
						<h2 class="top">Hot Offers of the Week</h2>
						<div class="pad">
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span><a
									href="Book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span><a
									href="Book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span><a
									href="Book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span><a
									href="Book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span><a
									href="Book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span><a
									href="Book2.html">Basel</a></li>
							</ul>
							<strong>Manchester</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 97.-</span><a
									href="Book2.html">Basel</a></li>
								<li><span class="right color1">from GBP 103.-</span><a
									href="Book2.html">Zurich</a></li>
							</ul>
							<strong>Edinburgh</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 165.-</span><a
									href="Book2.html">Zurich</a></li>
							</ul>
							<strong>Birmingham</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 143.-</span><a
									href="Book2.html">Zurich</a></li>
							</ul>
							<strong>London (LCY)</strong><br>
							<ul class="pad_bot1 list1">
								<li><span class="right color1">from GBP 176.-</span><a
									href="Book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 109.-</span><a
									href="Book2.html">Zurich</a></li>
							</ul>
							<strong>London (LHR)</strong><br>
							<ul class="pad_bot2 list1">
								<li><span class="right color1">from GBP 100.-</span><a
									href="Book2.html">Geneva</a></li>
								<li><span class="right color1">from GBP 112.-</span><a
									href="Book2.html">Zurich</a></li>
								<li><span class="right color1">from GBP 88.-</span><a
									href="Book2.html">Basel</a></li>
							</ul>
						</div>
					</div>
				</article>
				<article class="col2">
					<div class="tabs2">

						<div class="content">
							<div class="tab-content" id="Flight">
								<form  id="getFlights" class="form_5"
									action="flights">


									<div class="pad">
										<div class="wrapper under">
											<h2 class="box1">Book Domestic & International Flight
												Tickets</h2>
											<br> <br>

											<div class="col1">
												<div class="row">
													<span class="left">From</span> <input type="text"
														class="input" name="cityFrom" id="cityFrom">

												</div>
												<div class="row">
													<span class="left">To</span> <input type="text"
														class="input" name="cityTo" id="cityTo">

												</div>
											</div>
											<div class="check_box">
												<input type="checkbox" name="isOneWay" checked> <span>One
													Way Trip</span>

											</div>
											<div class="check_box">
												<input type="checkbox" name="isDirect"> <span>Direct
													flights</span>
											</div>
										</div>
										<div class="wrapper under">
											<span class="left">Departure Date:</span>
											<p>
												<input type="text" class="input" name="departureDate" id="departureDate"/>
											</p>
											<span class="right">Return Date Date:</span>
											<p>
												<input type="text" class="input" name="returnDate" />
											</p>

											<br> <br>


											<div class="wrapper pad_bot1">
												<span class="left">Passengers</span>
												<div class="cols marg_right1">
													<div class="row">
														<input type="text" class="input2" name="totalAdults"
															value="1" /> <span class="left">Adults</span>

													</div>
													<div class="row">
														<input type="text" class="input2" value="0"
															name="totalChildern" /> <span class="left">Children</span>

													</div>
												</div>
												<div class="cols">
													<div class="select1">
														<span class="left">Class</span><select id="seatCatagory"><option>Economy</option></select>

													</div>
													<div class="select1">
														<span class="left">Airline</span><select id="airlines"><option>Airlines</option></select>

													</div>
												</div>

												<input type="submit">

											</div>
										</div>
									</div>
								</form>

								<table id="projectTable"></table>
							</div>
						</div>
					</div>
				</article>
			</div>
		</section>
		<%@include file="Footer.jsp"%>
	</div>

	<!--content end-->
	
	<!--footer end-->

	<script type="text/javascript">
		Cufon.now();
	</script>

</body>
</html>