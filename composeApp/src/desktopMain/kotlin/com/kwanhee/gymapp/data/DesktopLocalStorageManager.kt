package com.kwanhee.gymapp.data

actual class LocalStorageManager {

    actual fun saveUserState(userState: UserGymState) {
    }

    actual fun getUserState(): UserGymState? {
        return null
    }

    actual fun saveFriendState(friendState: FriendState) {
    }

    actual fun getFriendState(friendId: String): FriendState? {
        return null
    }

    actual fun clearAll() {
    }

    private companion object {
        const val USER_STATE_KEY = "user_gym_state"
        const val FRIEND_STATE_PREFIX = "friend_state_"
        fun friendStateKey(friendId: String) = "$FRIEND_STATE_PREFIX$friendId"
    }
}