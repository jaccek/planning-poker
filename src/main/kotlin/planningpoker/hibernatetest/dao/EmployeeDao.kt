package planningpoker.hibernatetest.dao

import planningpoker.hibernatetest.model.Employee
import java.io.Serializable

interface EmployeeDao {

    fun save(employee: Employee): Serializable

    fun findById(id: Serializable): Employee?
}