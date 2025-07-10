package com.kwanhee.gymapp.data

actual class LocalStorageManager {
    actual fun saveUserState(userState: UserGymState) {
    }

    actual fun getUserState(): UserGymState? {
        TODO("Not yet implemented")
    }

    actual fun saveFriendState(friendState: FriendState) {
    }

    actual fun getFriendState(friendId: String): FriendState? {
        TODO("Not yet implemented")
    }

    actual fun clearAll() {
    }

}