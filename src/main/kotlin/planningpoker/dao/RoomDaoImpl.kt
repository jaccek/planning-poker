package planningpoker.dao

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import planningpoker.model.hibernate.Room
import java.sql.Timestamp

@Repository
open class RoomDaoImpl : RoomDao {

    @Autowired
    private lateinit var sessionFactory: SessionFactory

    private val session: Session
        get() = sessionFactory.currentSession

    override fun add(room: Room) {
        session.save(room)
    }

    override fun update(room: Room) {
        session.update(room)
    }

    override fun delete(room: Room) {
        session.delete(room)
    }

    override fun findByName(roomName: String): Room? {
        val criteria = session.createCriteria(Room::class.java)     // TODO: use JPA criteria
        return criteria.add(Restrictions.eq("name", roomName)).uniqueResult() as Room?
    }
}
