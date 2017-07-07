package planningpoker.hibernatetest

import planningpoker.hibernatetest.model.Employee
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import planningpoker.hibernatetest.dao.EmployeeDao

@Service
@Transactional(readOnly = false)
class EmployeeServiceImpl: EmployeeService {

    companion object {
        val logger: Logger = Logger.getLogger(EmployeeServiceImpl::class.java)
    }

    @Autowired
    private lateinit var employeeDao: EmployeeDao

    override fun getEmployee(id: Int): Employee? {
        logger.debug("Getting employee with id $id")
        return employeeDao.findById(id)
    }

    override fun addNewEmployee(employee: Employee) {
        val id = employeeDao.save(employee) as Int
        logger.debug("Id of new Employee: $id")
    }
}
