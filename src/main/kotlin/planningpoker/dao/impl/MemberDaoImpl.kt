package planningpoker.dao.impl

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import planningpoker.dao.MemberDao
import planningpoker.model.hibernate.Member
import planningpoker.model.hibernate.Room

@Repository
open class MemberDaoImpl: MemberDao {

    @Autowired
    private lateinit var sessionFactory: SessionFactory

    private val session: Session
        get() = sessionFactory.currentSession

    override fun create(member: Member) {
        session.save(member)
    }

    override fun update(member: Member) {
        session.update(member)
    }

    override fun delete(member: Member) {
        session.delete(member)
    }

    override fun getByRoom(room: Room): List<Member> {
        val criteria = session.createCriteria(Member::class.java)   // TODO: use JPA criteria
        return criteria.add(Restrictions.eq("room_id", room.id))
                .list()
                .map { it as? Member }
                .filterNotNull()
    }
}
