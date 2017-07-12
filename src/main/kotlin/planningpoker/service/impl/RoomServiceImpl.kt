package planningpoker.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import planningpoker.dao.RoomDao
import planningpoker.model.hibernate.Room
import planningpoker.service.RoomService

@Service
@Transactional
class RoomServiceImpl : RoomService {

    @Autowired
    private lateinit var roomDao: RoomDao
    // TODO: roomUpdatesDao

    override fun findRoomByName(roomName: String) =
            roomDao.findByName(roomName)

    override fun createRoomIfNotExists(room: Room) {
        if (findRoomByName(room.name) == null) {
            roomDao.add(room)
        }
    }

    override fun updateRoom(room: Room) =
            roomDao.update(room)

    override fun deleteRoom(room: Room) =
            roomDao.delete(room)
}
