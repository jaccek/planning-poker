package planningpoker.service

import planningpoker.model.hibernate.Member
import planningpoker.model.hibernate.Room

interface MemberService {

    fun createMember(member: Member, room: Room)

    fun updateMember(member: Member)
}
