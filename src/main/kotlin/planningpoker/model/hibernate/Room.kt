package planningpoker.model.hibernate

import javax.persistence.*

@Entity
@Table(name = "room")
data class Room(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        var id: Int = 0,

        @Column(name = "name", unique = true, nullable = false)
        var name: String = ""
)
