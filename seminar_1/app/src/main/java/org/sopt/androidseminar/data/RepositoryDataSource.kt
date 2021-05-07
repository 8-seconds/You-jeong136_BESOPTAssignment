package org.sopt.androidseminar.data

import org.sopt.androidseminar.presentation.model.RepositoryInfo

interface RepositoryDataSource {
    fun fetchRepoData(): List<RepositoryInfo>
}