package com.kwanhee.gymapp.data

import kotlinx.browser.localStorage

// WASM JS용 로컬 저장소 구현
actual class LocalStorageManager {
    private val userStateKey = "gym_user_state"
    private val friendStatePrefix = "gym_friend_"

    actual fun saveUserState(userState: UserGymState) {
        val jsonString = StorageHelper.userStateToJson(userState)
        localStorage.setItem(userStateKey, jsonString)
    }

    actual fun getUserState(): UserGymState? {
        val jsonString = localStorage.getItem(userStateKey) ?: return null
        return StorageHelper.jsonToUserState(jsonString)
    }

    actual fun saveFriendState(friendState: FriendState) {
        val jsonString = StorageHelper.friendStateToJson(friendState)
        localStorage.setItem("$friendStatePrefix${friendState.friendId}", jsonString)
    }

    actual fun getFriendState(friendId: String): FriendState? {
        val jsonString = localStorage.getItem("$friendStatePrefix$friendId") ?: return null
        return StorageHelper.jsonToFriendState(friendId, jsonString)
    }

    actual fun clearAll() {
        localStorage.removeItem(userStateKey)
        // 모든 친구 상태도 삭제
        for (i in 0 until localStorage.length) {
            val key = localStorage.key(i)
            if (key?.startsWith(friendStatePrefix) == true) {
                localStorage.removeItem(key)
            }
        }
    }
}
