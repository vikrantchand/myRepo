<!DOCTYPE html>
<html lang="en">
<head>
<title>Register With us!</title>
<meta charset="utf-8">


<link rel="stylesheet" href="resources/css/fv.css" type="text/css" />
<link rel="stylesheet" href="resources/css/redmond/jquery-ui.css">
<link rel="stylesheet" href="resources/css/redmond/jquery.ui.theme.css">
<link rel="stylesheet" href="resources/css/jqgrid/ui.jqgrid.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js" type="text/javascript"></script>
<script src="http://www.trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="http://www.trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script  src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>
<style type="text/css">
.ui-jqgrid tr.jqgrow td {
	vertical-align: middle !important
}
</style>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


</head>
<body id="page1">
	<script>
		jQuery(document)
				.ready(
						function($) {

							/* var obj1=$('#registerForm').serialize(); */
							var userEntity = getData();
							$
									.ajax({
										type : 'POST',
										url : 'flight',
										dataType : "json",
										data : userEntity,
										contentType : "application/json",
										success : function(data) {
											jQuery("#projectTable")
													.jqGrid(
															{
																datatype : "local",
																data : data,
																colNames : [
																		'Provider',
																		'City',
																		'Date',
																		'Time',
																		'City',
																		'Date',
																		'Time',
																		'Duration',
																		'Fare',
																		'Book' ],
																colModel : [
																		{
																			name : 'flightEntity.flightProvider',
																			index : 'Flight Provider',
																			width : 83,
																			align : 'center',
																			formatter : function(cellvalue, options, rowObject )
																					{
																							return   '<img src="resources/images/'+cellvalue+'.jpg" /><br>'+cellvalue+'-'+rowObject.flightEntity.flightId ;
																					}
																		},
																		{
																			name : 'flightRouteEntity.departureCity',
																			index : 'City',
																			width : 83,
																			align : 'center'

																		},
																		{
																			name : 'departureDate',
																			index : 'Date',
																			width : 83,
																			align : 'center'
																		},
																		{
																			name : 'departureTime',
																			index : 'Time',
																			width : 83,
																			align : 'center'
																		},
																		{
																			name : 'flightRouteEntity.destinationCity',
																			index : 'City',
																			width : 83,
																			align : 'center'
																		},
																		{
																			name : 'arrivalDate',
																			index : 'Date',
																			width : 83,
																			align : 'center'
																		},
																		{
																			name : 'arrivalTime',
																			index : 'Time',
																			width : 83,
																			align : 'center'
																		},
																		{
																			name : 'arrivalTime',
																			index : 'Duration',
																			width : 83,
																			align : 'center',
																			formatter : function(
																					cellvalue,
																					options,
																					rowObject) {
																				date1 = (rowObject.departureDate)
																						.split("-");
																				date2 = (rowObject.arrivalDate)
																						.split("-");
																				start = (rowObject.departureTime)
																						.split(":");
																				end = (rowObject.arrivalTime)
																						.split(":");

																				var diff = Math
																						.abs(new Date(
																								date1[0]
																										+ '/'
																										+ date1[1]
																										+ '/'
																										+ date1[2]
																										+ " "
																										+ start[0]
																										+ ':'
																										+ start[1])
																								- new Date(
																										date2[0]
																												+ '/'
																												+ date2[1]
																												+ '/'
																												+ date2[2]
																												+ " "
																												+ end[0]
																												+ ':'
																												+ end[1]));
																				
																				var hours = Math
																						.floor(diff / 1000 / 60 / 60);
																				diff -= hours * 1000 * 60 * 60;
																				var minutes = Math
																						.floor(diff / 1000 / 60);

																				return hours
																						+ ' hr'
																						+ minutes
																						+ ' mins';
																			}

																		},
																		{
																			name : 'fare',
																			index : 'Fare',
																			width : 83,
																			align : 'center'
																		},
																		{
																			name : '',
																			index : 'Command',
																			width : 83,
																			align : 'center',
																			formatter : function(cellvalue, options, rowObject )
																					{
																							return  "<input type='button' name='book' id='book' value='Book'>" ;
																					}
																		} ],

																rowNum : 20,
																rowList : [ 20,
																		60, 100 ],
																height : 600,
																viewrecords : true,
																jsonReader : {
																	root : "rows",
																	page : "page",
																	total : "total",
																	records : "records",
																	repeatitems : false,
																	cell : "cell",
																	id : "id"
																},
																afterInsertRow: function (rowid, data,rowObject) {
																	$("td:eq(9)","#"+rowid).click(function () {
																		document.getElementById("scheduleId").value=rowObject.scheduleId;
																		document.getElementById("noOfPassengers").value="${param.totalAdults}";
																			$( "#form1" ).submit();
																				
																				
															});
 }

															});
															jQuery("#projectTable").jqGrid('setGroupHeaders', {
								useColSpanStyle: true, 
									groupHeaders:[
											{startColumnName: 'flightRouteEntity.departureCity', numberOfColumns: 3, titleText: 'Departure'},
											{startColumnName: 'flightRouteEntity.destinationCity', numberOfColumns: 3, titleText: 'Arrival'}
												]
													});

										},
										error : function() {
											alert("failure");
										}

									});
							return false;

						});
						
						

		function getData() {
			var cityFrom = "${param.cityFrom}";
			var cityTo = "${param.cityTo}";
			var departureDate = "${param.departureDate}";
			var returnDate = "${param.returnDate}";
			var isOneWay = "${param.isOneWay}";
			var isDirect = "${param.isDirect}";
			var totalAdults = "${param.totalAdults}";
			var totalChildern = "${param.totalChildern}";
			var seatCatagory = "${param.seatCatagory}";
			var airlines = "${param.airlines}";

			var obj = {
				"cityFrom" : cityFrom,
				"cityTo" : cityTo,
				"departureDate" : departureDate,
				"returnDate" : returnDate,
				"isOneWay" : isOneWay,
				"isDirect" : isDirect,
				"totalAdults" : totalAdults,
				"totalChildern" : totalChildern,
				"seatCatagory" : seatCatagory,
				"airlines" : airlines
			};
			return JSON.stringify(obj);
		}
	</script>

	<div class="main">
		<%@include file="Header.jsp"%>
		<!--content -->
		<section id="content">
		<br>
				<h2>One way Flights From ${param.cityFrom} to ${param.cityTo} | Leaving from ${param.cityFrom} on  ${param.departureDate}</h2>
			<div id='wrap'>
				<table id="projectTable"></table>
				<form action="travellers" id="form1">
				<input type ="hidden" name="scheduleId" id="scheduleId">
				<input type ="hidden" name="noOfPassengers" id="noOfPassengers">
				
				
				</form>
			</div>
		</section>
		<!--content end-->
		<!--footer -->
		<%@include file="Footer.jsp"%>
		<!--footer end-->
	</div>

</body>
</html>