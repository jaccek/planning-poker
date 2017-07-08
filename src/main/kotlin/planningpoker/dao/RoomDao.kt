package planningpoker.dao

import planningpoker.model.hibernate.Room

interface RoomDao {

    fun add(room: Room)

    fun update(room: Room)

    fun delete(room: Room)

    fun findByName(roomName: String): Room?
}
