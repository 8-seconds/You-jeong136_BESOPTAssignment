package org.sopt.androidseminar.data

import org.sopt.androidseminar.presentation.model.RepositoryInfo

class LocalRepositoryDataSource: RepositoryDataSource {
    override fun fetchRepoData(): List<RepositoryInfo> {
        return listOf<RepositoryInfo>(
            RepositoryInfo(
                repoName = "레포지터리1",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "말이 엄청 긴 레포지터리 이름 실험: ellipsize, maxLine 옛날옛날에 어는 마을에 마음이 착한 목화솜이 살았어요2",
                repoDesc = "마찬가지로 말이 엄청 긴 레포지터리 설명 실험: ellipsize, maxLinem 옛날옛날에 어느마을에 마음이 착한 목화솜이 살았어요",
                repoLang = "한국어"
            ),
            RepositoryInfo(
                repoName = "레포지터리3",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리4",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리5",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리6",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리7",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리8",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리9",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리10",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리11",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리12",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            ),
            RepositoryInfo(
                repoName = "레포지터리13",
                repoDesc = "레포지터리 설명",
                repoLang = "언어"
            )
        )
    }
}