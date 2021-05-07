package org.sopt.androidseminar.data

import org.sopt.androidseminar.presentation.model.FollowingUserInfo

interface FollowingDataSource {
    fun fetchFollowingData(): List<FollowingUserInfo>
}