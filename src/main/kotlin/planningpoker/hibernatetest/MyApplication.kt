package planningpoker.hibernatetest

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import planningpoker.hibernatetest.model.Employee

@Component
class MyApplication {

    companion object {
        val logger = Logger.getLogger(MyApplication::class.java)
    }

    @Autowired
    private lateinit var employeeService: EmployeeService

    fun performDbTasks() {
        val employee = Employee(
                id = 1,
                firstName = "Jon",
                lastName = "Smith",
                salary = 2000)

        employeeService.addNewEmployee(employee)

        val retrieved = employeeService.getEmployee(employee.id!!)
        logger.debug("Retrived employee: $retrieved")
    }
}