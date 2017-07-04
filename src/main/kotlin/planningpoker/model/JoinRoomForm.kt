package planningpoker.model

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class JoinRoomForm(
        @field:NotNull
        @field:Size(min = 6, max = 16)
        var roomName: String? = null,

        @field:NotNull
        @field:Size(min = 6, max = 16)
        var username: String? = null
)
