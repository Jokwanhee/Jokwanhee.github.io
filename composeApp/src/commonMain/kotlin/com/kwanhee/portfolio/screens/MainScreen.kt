// Copyright 2025 dev.kwan
package com.kwanhee.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kwanhee.portfolio.components.appbar.PortfolioTopAppBar
import com.kwanhee.portfolio.model.Project
import com.kwanhee.portfolio.ui.KwanheeColors

@Composable
fun MainScreen() {
    Scaffold(
        containerColor = KwanheeColors.background,
        topBar = { PortfolioTopAppBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 80.dp), // 좌우 여백
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { Spacer(modifier = Modifier.height(64.dp)) }

            item { HeroSection() }

            item { Spacer(modifier = Modifier.height(80.dp)) }

//            item { FeaturedProjectsSection(sampleProjects) }

            item { Spacer(modifier = Modifier.height(120.dp)) }
        }
    }
}


@Composable
private fun HeroSection() {
    Card(
        modifier = Modifier.fillMaxWidth(0.9f),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = KwanheeColors.background)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(400.dp).padding(48.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            // TODO: 배경 이미지를 여기에 추가하세요.
            Column {
                Text(
                    "Crafting Seamless Digital Experiences",
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Bold,
                    color = KwanheeColors.foreground,
                    lineHeight = 60.sp
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    "I'm a UI/UX designer passionate about creating intuitive and engaging interfaces. With a focus on user-centered design, I strive to deliver solutions that are both aesthetically pleasing and highly functional.",
                    fontSize = 16.sp,
                    color = KwanheeColors.foreground.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
private fun FeaturedProjectsSection(projects: List<Project>) {
    Column(
        modifier = Modifier.fillMaxWidth(0.9f),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            "Featured Projects",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = KwanheeColors.onBackground
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(projects) { project ->
                ProjectCard(project)
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = KwanheeColors.onSecondary)
        ) {
            Text("View All Projects", color = KwanheeColors.onBackground, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        }
    }
}

@Composable
private fun ProjectCard(project: Project) {
    Column(
        modifier = Modifier.width(350.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 이미지 플레이스홀더
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(KwanheeColors.background)
        ) {
            // TODO: 여기에 실제 프로젝트 이미지를 로드하세요.
            // 예: Image(painterResource("..."), ...)
        }
        Text(project.title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = KwanheeColors.onBackground)
        Text(project.summary, fontSize = 14.sp, color = KwanheeColors.onBackground, lineHeight = 20.sp)
    }
}