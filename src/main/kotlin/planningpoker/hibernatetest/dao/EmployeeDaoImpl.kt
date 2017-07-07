package planningpoker.hibernatetest.dao

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import planningpoker.hibernatetest.model.Employee
import java.io.Serializable

@Repository
open class EmployeeDaoImpl : EmployeeDao {

    @Autowired
    private lateinit var sessionFactory: SessionFactory

    private val session: Session
        get() = sessionFactory.currentSession

    override fun save(employee: Employee): Serializable =
            session.save(employee)

    override fun findById(id: Serializable): Employee? =
            session.get(Employee::class.java, id)
}