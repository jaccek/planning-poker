package planningpoker.model.hibernate

import planningpoker.model.entity.Vote
import javax.persistence.*

@Entity
@Table(name = "member")
data class Member(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, unique = true)
        var id: Int = 0,

        @Column(name = "name", nullable = false)
        var name: String = "",

        @Enumerated(EnumType.STRING)
        @Column(name = "vote")
        var vote: Vote = Vote.NOT_VOTED,

        @ManyToOne
        @JoinColumn(name = "room_id")
        var room: Room? = null
)
