package planningpoker.hibernatetest.model

import javax.persistence.*


// TODO: which solution is better: using optionals or default values (eg. empty string)?
@Entity
@Table(name = "EMPLOYEE")
data class Employee(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        var id: Int? = null,

        @Column(name = "first_name", length = 20)
        var firstName: String? = null,

        @Column(name = "last_name", length = 20)
        var lastName: String? = null,

        @Column(name = "salary")
        var salary: Int? = null
)
