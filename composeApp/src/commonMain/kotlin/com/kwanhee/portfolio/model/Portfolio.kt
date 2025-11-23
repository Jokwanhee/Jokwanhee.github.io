package com.kwanhee.portfolio.model

data class Portfolio(
    val aboutMe: AboutMe = AboutMe(),
    val projects: List<Project>,
)

data class AboutMe(
    val name: String = "조관희",
    val title: String = "과정의 중요함을 알고 문제를 해결하는 개발자 조관희입니다.",
    val subTitle: String = "서브 타이틀"
)

data class Project(
    val id: String, // test01
    val title: String,
    val summary: String,
    val detailFilePath: String, // /resources/test01.md
)