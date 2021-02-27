package ar.com.genomasoft.fenix.rest;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ar.com.genomasoft.fenix.model.Employee;
import ar.com.genomasoft.fenix.service.EmployeeService;
import ar.com.genomasoft.jproject.core.daos.ConditionEntry;
import ar.com.genomasoft.jproject.core.daos.ConditionSimple;
import ar.com.genomasoft.jproject.core.daos.SearchOption;
import ar.com.genomasoft.jproject.core.exception.BaseException;
import ar.com.genomasoft.jproject.webutils.webservices.BaseClientAuditedEntityWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("Employee - Servicio web REST")
@RequestMapping(path = "/api/employee")
public class EmployeeRest extends BaseClientAuditedEntityWebService<Employee, EmployeeService> {
	
	@Autowired
	EmployeeService employeServ;

	@PostMapping(path = "/saveEmployee/{firstname}/{lastName}/{email}/{phone}/{date}/{salary}/{comission}")
	@Transactional
	public @ResponseBody void saveEmployee(
			@PathVariable("firstname") String nameParam,
			@PathVariable("lastName") String lastNameParam,
			@PathVariable("email") String emailParam,
			@PathVariable("phone") String phoneParam,
			@PathVariable("date") String dateParam,
			@PathVariable("salary") int salaryParam,
			@PathVariable("comission") int comissionParam
			) throws BaseException {

		// New object
		Employee empl = new Employee();

		empl.setFirstName(nameParam);
		empl.setLastName(lastNameParam);
		empl.setEmail(emailParam);
		empl.setPhoneNumber(phoneParam);
		empl.setHireDate(dateParam);
		empl.setSalary(salaryParam);
		empl.setCommissionPct(comissionParam);
		empl.setCreatedByUser(2);
		empl.setClientId(2);


		employeServ.save(empl);
  }
	
	
}
