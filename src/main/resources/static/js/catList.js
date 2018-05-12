/**
 * 
 */
//$(function(){
// NOTE ilker above is shorthand for below line
$(function(){
	// create new user or edit one
	$('.nBtn, .table .eBtn').on('click', function(event){
//		console.log("ILKER -->");	// NOTE ilker, this is JS way to 
//		debugger;	// NOTE ilker, this is JS way of putting breakpoint hard coded into your code.If you uncomment this, this JS code will stop at this line for you to continue in debugger of DevTool of browser

		// NOTE ilker if you have href="" in anchor tag this jQuery marker triggers on, then you need to have below line to be able to see modal popup
		//         or if you have th:href="@{detail/(petId=${cats.petId})}", then you need below line to stop it from showing the result as json object
		event.preventDefault();	
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text=='Edit') {
			// NOTE ilker, make ajax (REST) call via jQuery's get. Then once REST service returns data (in data4cats variable) back, below function executes "asynchronously"
			$.get(href, function(data4cats, status){
				$('.myForm #petId').val(data4cats.petId);
				$('.myForm #name').val(data4cats.name);
				$('.myForm #type').val(data4cats.type);
				$('.myForm #ownerName').val(data4cats.ownerName);
				$('.myForm #address').val(data4cats.address);
				$('.myForm #age').val(data4cats.age);
				$('.myForm #isSpayed').val(data4cats.isSpayed);
				$('.myForm #birthdate').val(data4cats.birthdate);
			});
			// NOTE ilker, let Bootstrap modal popup via below jQuery call
			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')
		} else {
			// NOTE ilker, hide petId input div. And disable petId input. Since petId is "@GeneratedValue(strategy=GenerationType.AUTO)" in catsEntity and inputs that can not be parsed to Integer will cause 400 Bad Request upon POST of form, no need for user to be able to enter anything here
			$('.myForm #petId').prop("disabled", true); // example of setting an attribute of the element
			$('.myForm #petId').prop("type", "hidden"); // NOTE this does not hide the label, just hides the input element, so below line is better
			$('.myForm #petId').parent().hide();	// NOTE ilker using jQuery APIs parent() to get parent div of #petId input and then hide() to hide that div
			// initialize the fields of modal
			$('.myForm #petId').val('');	// NOTE ilker for post form submission to be auto serialized to catsEntity at catsController's method, this needs to be initialized to a value that can be parsed to Integer since petId attribute is an Integer. Otherwise you will get 400 Bad Request upon POST submit
			$('.myForm #name').val('');
			$('.myForm #type').val('');
			$('.myForm #ownerName').val('');
			$('.myForm #address').val('');
			$('.myForm #age').val('');
			$('.myForm #isSpayed').val('');
			$('.myForm #birthdate').val('');
			// let Bootstrap modal popup via below jQuery call
			$('.myForm #exampleModal').modal();	// modal(), modal('show'), modal('toggle')			
		}
	});
	
	$('.table .dBtn').on('click', function(event){
		event.preventDefault();	
		var href = $(this).attr('href');
		$('#exampleModal4delete #dConfBtn').attr('href', href);
		// let Bootstrap modal popup via below jQuery call
		$('#exampleModal4delete').modal();	// modal(), modal('show'), modal('toggle')			
		

	});
		
});