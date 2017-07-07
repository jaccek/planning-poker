package planningpoker.hibernatetest

import planningpoker.hibernatetest.model.Employee

interface EmployeeService {

    fun getEmployee(id: Int): Employee?

    fun addNewEmployee(employee: Employee)
}
