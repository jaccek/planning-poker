package planningpoker.model.hibernate

import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "room_update")
data class RoomUpdate(

        @Id
        @Column(name = "room_id", nullable = false, unique = true)
        var roomId: Int = 0,

        @Column(name = "last_update", nullable = false)
        var lastUpdate: Timestamp = Timestamp(System.currentTimeMillis())
)
