
$(document).ready(function(){

	 

});


//Desarrollado con spring boot

//function saveEmployee(){
//
//	var employee ={};
//	
//	employee["id"] 				= '';
//	employee["firstname"] 		= $("#txtName").val();
//	employee["lastName"] 	    = $("#txtLastname").val();
//	employee["email"] 			= $("#txtEmail").val();
//	employee["phoneNumber"] 	= $("#txtPhone").val();
//	employee["hireDate"] 		= $("#txtDate").val();
//	employee["salary"] 	        = $("#txtSalary").val();
//	employee["commissionPct"] 	= $("#txtComission").val();
//    employee["version"]			= '';	
//		
//	$.ajax({
//	    type: 'POST',
//	    url: _path + "api/employee",
//	    data: JSON.stringify(employee),
//	    dataTYpe: 'json',
//	    contentType: 'application/json',
//		beforeSend: function(xhr){
//			xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
//			modalWaitShow();
//		}
//	}).done(function(){
//	
//		 $("#txtName").val('');
//		 $("#txtLastname").val('');
//		 $("#txtEmail").val('');
//		 $("#txtPhone").val('');
//		 $("#txtDate").val('');
//		 $("#txtSalary").val('');
//		 $("#txtComission").val('');
//		 
//		modalSuccess("Operación realizada correctamente.");
//				    
//		cargarSelect();		
//	})
//	.fail(function(data){
//		modalError("La operación no pudo realizarse correctamente.", data)
//	});
//
//}

//GUARDO LOS EMPLEADOS

function save(){

	var firstname=$("#txtName").val();
	var lastname=$("#txtLastname").val();
	var email=$("#txtEmail").val();
	var phone=$("#txtPhone").val();
	var date=$("#txtDate").val();
	var salary=$("#txtSalary").val();
	var comission=$("#txtComission").val();
	
	
	$.ajax({
	    type: "POST",
	    url: _path + "api/employee/saveEmployee/"+ firstname + lastname + email + phone + date + salary + comission ,
		beforeSend: function(xhr){xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );	}
	}).done(function(){
		
		alert("Guardo");
		
		cargarSelect();
		
		
	})
	.fail(function(data){


	});

}


//Todos las funciones en adelante estan desarrolladas con spring boot 

//Guardo la direccion

function saveDirection(){
	 
	 var direccion ={};
	
	    direccion["id"] 				= '';
	    direccion["streetAddres"] 		= $("#txtStreet").val();
	    direccion["postalCode"] 	    = $("#txtPostal").val();
	    direccion["city"] 			    = $("#txtCity").val();
	    direccion["stateProvince"]    	= $("#txtProvince").val();
	    direccion["country"] 		    = $("#txtCountry").val();
	    direccion["employee"]           = empleado;
	    direccion["version"]			= '';

			
		$.ajax({
		    type: 'POST',
		    url: _path + "api/employee",
		    data: JSON.stringify(direccion),
		    dataTYpe: 'json',
		    contentType: 'application/json',
			beforeSend: function(xhr){
				xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );
				modalWaitShow();
			}
		}).done(function(){
		
			 $("#txtStreet").val('');
			 $("#txtPost").val('');
			 $("#txtEmail").val('');
			 $("#txtCity").val('');
			 $("#txtProvince").val('');
			 $("#txtCountry").val('');
			 
			 
			modalSuccess("Operación realizada correctamente.");
					    
			cargarSelect();		
		})
		.fail(function(data){
			modalError("La operación no pudo realizarse correctamente.", data)
		});
	
	}
	
	





//LOS CARGO EN UNA LISTA 
function cargarSelect(){

$.ajax({
	    type: "GET",
	    url: _path + "api/employee"  ,
		beforeSend: function(xhr){xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );	}
	}).done(function(employeeList){
		
		
		
		
		$('#selectEmployee').empty()
		
		//recorriendo todos los empleados
		 employeeList.rows.forEach(function(emp){
             //y los agrego al selector
             $('#selectEmployee').append('<option version=' + emp.version +  ' value=' + emp.id + '>' + emp.firstName + 
                '</option>');
                
            });
            
	
		
	})
	.fail(function(data){
		alert("Error al cargar Select")
	});
	
}


//SELECCIONO DEL SELECTOR UN EMPLEADO Y CARGO SUS DATOS EN OTRO FORMULARIO 
function loadEmployee(){

	var idEmployee= $( "#selectEmployee option:selected" ).attr('value');

	$.ajax({
	    type: "GET",
	    url: _path + "api/employee" + idEmployee ,
		beforeSend: function(xhr){xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );	}
	}).done(function(employee){
	
		
		 $("#txtName").val('');
		 $("#txtLastname").val('');
		 $("#txtEmail").val('');
		 $("#txtPhone").val('');
		 $("#txtDate").val('');
		 $("#txtSalary").val('');
		 $("#txtComission").val('');
		 
		 $("#txtName_new").val(employee.firstName);
		 $("#txtLastname_new").val(employee.lastName);
		 $("#txtEmail_new").val(employee.email);
		 $("#txtPhone_new").val(employee.phoneNumber);
		 $("#txtDate_new").val(employee.hireDate);
		 $("#txtSalary_new").val(employee.salary);
		 $("#txtComission_new").val(employee.commissionPct);
	
	 
		 
		  
	
            
	
		
	})
	.fail(function(data){
		alert("Error al cargar Form")
	});
	
	


}




//Modifico su información y la actualizo 
function update(){
  
  var idEmployee= $( "#selectEmployee option:selected" ).attr('value');
  var version= $( "#selectEmployee option:selected" ).attr('version');
  
  
    employee["id"] 				= idEmployee;
	employee["firstname"] 		= $("#txtName_new").val();
	employee["lastName"] 	    = $("#txtLastname_new").val();
	employee["email"] 			= $("#txtEmail_new").val();
	employee["phoneNumber"] 	= $("#txtPhone_new").val();
	employee["hireDate"] 		= $("#txtDate_new").val();
	employee["salary"] 	        = $("#txtSalary_new").val();
	employee["commissionPct"] 	= $("#txtComission_new").val();
    employee["version"]			= version;	

$.ajax({
	    type: "PUT",
	    url: _path + "api/employee" + idEmployee ,
	    data: JSON.stringify(employee),
	    dataTYpe: 'json',
	    contentType: 'application/json',
		beforeSend: function(xhr){xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );	}
	}).done(function(){
	
	
	 alert("Empleado actualizado correctamente")
	
		 $("#txtName_new").val('');
		 $("#txtLastname_new").val('');
		 $("#txtEmail_new").val('');
		 $("#txtPhone_new").val('');
		 $("#txtDate_new").val('');
		 $("#txtSalary_new").val('');
		 $("#txtComission_new").val('');
	
	cargarSelect();	
		
	})
	.fail(function(data){
		alert("Error al cargar Form")
	});
	
}




//Elimino la información de un empleado seleccionado

function deleteEmployee(){

var idEmployee= $( "#selectEmployee option:selected" ).attr('value');
var version= $( "#selectEmployee option:selected" ).attr('version');

$.ajax({
	    type: "DELETE",
	    url: _path + "api/employee" + idEmployee + '?version=' + version ,
		beforeSend: function(xhr){xhr.setRequestHeader('X-CSRF-TOKEN', _csrf );	}
	}).done(function(){
	
	
	 alert("Empleado eliminado correctamente");
	
			
	cargarSelect();	
		
	})
	.fail(function(data){
		alert("Error al cargar Form")
	});

}