package planningpoker.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import planningpoker.dao.RoomDao
import planningpoker.model.hibernate.Room
import java.sql.Timestamp

@Service
@Transactional
class RoomServiceImpl : RoomService {

    @Autowired
    private lateinit var roomDao: RoomDao

    override fun findRoomByName(roomName: String) =
            roomDao.findByName(roomName)
    
    override fun createRoom(room: Room) =
            roomDao.add(room.apply {
                lastUpdate = Timestamp(System.currentTimeMillis())
            })

    override fun updateRoom(room: Room) =
            roomDao.update(room.apply {
                lastUpdate = Timestamp(System.currentTimeMillis())
            })

    override fun deleteRoom(room: Room) =
            roomDao.delete(room)
}
