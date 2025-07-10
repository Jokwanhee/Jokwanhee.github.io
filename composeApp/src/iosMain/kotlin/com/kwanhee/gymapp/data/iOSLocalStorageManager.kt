package com.kwanhee.gymapp.data

// Copyright 2025 dev.kwan
import platform.Foundation.NSUserDefaults
import platform.Foundation.setValue

actual class LocalStorageManager {
    private val userDefaults: NSUserDefaults = NSUserDefaults.standardUserDefaults

    actual fun saveUserState(userState: UserGymState) {
        val jsonString = StorageHelper.userStateToJson(userState)
        userDefaults.setValue(jsonString, forKey = USER_STATE_KEY)
    }

    actual fun getUserState(): UserGymState? {
        val jsonString = userDefaults.stringForKey(USER_STATE_KEY)
        return jsonString?.let { StorageHelper.jsonToUserState(it) }
    }

    actual fun saveFriendState(friendState: FriendState) {
        val jsonString = StorageHelper.friendStateToJson(friendState)
        // 친구 ID를 키의 일부로 사용하여 각 친구의 상태를 개별적으로 저장
        userDefaults.setValue(jsonString, forKey = friendStateKey(friendState.friendId))
    }

    actual fun getFriendState(friendId: String): FriendState? {
        val jsonString = userDefaults.stringForKey(friendStateKey(friendId))
        return jsonString?.let { StorageHelper.jsonToFriendState(friendId, it) }
    }

    actual fun clearAll() {
        // 주의: 이 방법은 앱의 모든 NSUserDefaults를 지웁니다.
        // 특정 키들만 지우고 싶다면 해당 키들을 직접 removeObjectForKey를 호출해야 합니다.
        userDefaults.dictionaryRepresentation().keys.forEach { key ->
            // GymApp 관련 키만 선택적으로 삭제하는 것이 더 안전할 수 있습니다.
            // 예를 들어, 키가 특정 접두사로 시작하는 경우 등.
            // 여기서는 모든 키를 삭제하지만, 실제 앱에서는 주의가 필요합니다.
            if (key is String && (key == USER_STATE_KEY || key.startsWith(FRIEND_STATE_PREFIX))) {
                userDefaults.removeObjectForKey(key)
            }
        }
        // 만약 정말로 모든 NSUserDefaults를 삭제해야 한다면:
        // val domainName = NSBundle.mainBundle.bundleIdentifier
        // if (domainName != null) {
        //     userDefaults.removePersistentDomainForName(domainName)
        //     userDefaults.synchronize() // 변경사항 즉시 반영 (필수는 아님)
        // }
    }

    private companion object {
        const val USER_STATE_KEY = "user_gym_state"
        const val FRIEND_STATE_PREFIX = "friend_state_"
        fun friendStateKey(friendId: String) = "$FRIEND_STATE_PREFIX$friendId"
    }
}