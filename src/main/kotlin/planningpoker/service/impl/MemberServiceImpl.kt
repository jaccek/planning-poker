package planningpoker.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import planningpoker.dao.MemberDao
import planningpoker.model.hibernate.Member
import planningpoker.model.hibernate.Room
import planningpoker.service.MemberService

@Service
@Transactional
open class MemberServiceImpl : MemberService {

    @Autowired
    private lateinit var memberDao: MemberDao

    override fun createMember(member: Member, room: Room) {
        member.room = room
        memberDao.create(member)
    }

    override fun updateMember(member: Member) =
            memberDao.update(member)
}
