package planningpoker.entity

data class RoomState(
        val roomName: String,
        val users: List<UserVote>
)

data class UserVote(
        val user: User,
        val vote: Vote
)

data class User (
        val username: String
)

enum class Vote(val vote: String) {
    NOT_VOTED("..."),
    VOTE_1("1"),
    VOTE_3("3"),
    VOTE_5("5"),
    VOTE_8("8"),
    VOTE_13("13"),
    VOTE_20("20"),
    VOTE_40("40"),
    VOTE_100("100"),
    VOTE_INFINITY("\u221e"),
    VOTE_ABSTAINED("?");

    override fun toString(): String {
        return vote
    }
}
