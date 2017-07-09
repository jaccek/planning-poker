package planningpoker.service

import planningpoker.model.hibernate.Room

interface RoomService {

    fun findRoomByName(roomName: String): Room?

    fun createRoomIfNotExists(room: Room)

    fun updateRoom(room: Room)

    fun deleteRoom(room: Room)
}
