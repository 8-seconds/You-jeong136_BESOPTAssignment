package org.sopt.androidseminar.data

import org.sopt.androidseminar.presentation.model.FollowingUserInfo

class LocalFollowingDataSource: FollowingDataSource{
    override fun fetchFollowingData(): List<FollowingUserInfo> {
        return listOf<FollowingUserInfo>(
                FollowingUserInfo(
                        userImage = "지금은 빈킨",
                        userName = "jinsu1"
                ),
                FollowingUserInfo(
                        userImage = "지금은 빈킨",
                        userName = "jinsu2"
                ),
                FollowingUserInfo(
                        userImage = "지금은 빈킨",
                        userName = "jinsu3"
                ), FollowingUserInfo(
                userImage = "지금은 빈킨",
                userName = "jinsu4"
                )
        )

    }
}