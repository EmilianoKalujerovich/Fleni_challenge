package ar.com.genomasoft.fenix.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.genomasoft.fenix.dao.EmployeeDao;
import ar.com.genomasoft.fenix.model.Employee;
import ar.com.genomasoft.jproject.core.services.BaseClientAuditedEntityServiceImpl;

@Service
public class EmployeeServiceImpl extends BaseClientAuditedEntityServiceImpl<Employee, EmployeeDao>
		implements EmployeeService {

}
