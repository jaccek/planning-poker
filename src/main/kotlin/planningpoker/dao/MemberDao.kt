package planningpoker.dao

import planningpoker.model.hibernate.Member
import planningpoker.model.hibernate.Room

interface MemberDao {

    fun create(member: Member)

    fun update(member: Member)

    fun delete(member: Member)

    fun getByRoom(room: Room): List<Member>
}
