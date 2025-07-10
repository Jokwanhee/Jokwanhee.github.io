package com.kwanhee.gymapp.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class StoredUserState(
    val name: String,
    val status: String, // GymStatus의 name을 저장
    val lastUpdated: Long
)

// 로컬 저장소 관리 (플랫폼별 구현 필요)
expect class LocalStorageManager() {
    fun saveUserState(userState: UserGymState)
    fun getUserState(): UserGymState?
    fun saveFriendState(friendState: FriendState)
    fun getFriendState(friendId: String): FriendState?
    fun clearAll()
}

// 공통 JSON 변환 로직
object StorageHelper {
    private val json = Json { ignoreUnknownKeys = true }

    fun userStateToJson(userState: UserGymState): String {
        val storedState = StoredUserState(
            name = userState.name,
            status = userState.status.name,
            lastUpdated = userState.lastUpdated
        )
        return json.encodeToString(storedState)
    }

    fun jsonToUserState(jsonString: String): UserGymState? {
        return try {
            val storedState = json.decodeFromString<StoredUserState>(jsonString)
            UserGymState(
                name = storedState.name,
                status = GymStatus.valueOf(storedState.status),
                lastUpdated = storedState.lastUpdated
            )
        } catch (e: Exception) {
            null
        }
    }

    fun friendStateToJson(friendState: FriendState): String {
        val storedState = StoredUserState(
            name = friendState.name,
            status = friendState.status.name,
            lastUpdated = friendState.lastUpdated
        )
        return json.encodeToString(storedState)
    }

    fun jsonToFriendState(friendId: String, jsonString: String): FriendState? {
        return try {
            val storedState = json.decodeFromString<StoredUserState>(jsonString)
            FriendState(
                friendId = friendId,
                name = storedState.name,
                status = GymStatus.valueOf(storedState.status),
                lastUpdated = storedState.lastUpdated
            )
        } catch (e: Exception) {
            null
        }
    }
}
