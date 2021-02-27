package ar.com.genomasoft.fenix.dao;

import org.springframework.stereotype.Repository;

import ar.com.genomasoft.fenix.model.Employee;
import ar.com.genomasoft.jproject.core.daos.BaseClientAuditedEntityDaoImpl;

@Repository
public class EmployeeDaoImpl extends BaseClientAuditedEntityDaoImpl<Employee> implements EmployeeDao {

}
