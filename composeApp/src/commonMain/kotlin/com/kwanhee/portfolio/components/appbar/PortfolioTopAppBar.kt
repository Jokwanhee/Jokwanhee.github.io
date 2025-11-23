package com.kwanhee.portfolio.components.appbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kwanhee.portfolio.ui.KwanheeColors
import com.kwanhee.portfolio.ui.KwanheeTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioTopAppBar() {
    TopAppBar(
        title = {
            Text(
                "Kwanhee Jo Portfolio",
                fontWeight = FontWeight.Bold,
                color = KwanheeColors.onBackground,
            )
        },
        actions = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextButton(onClick = { /*TODO*/ }) { Text("About", color = KwanheeColors.onBackground) }
                TextButton(onClick = { /*TODO*/ }) { Text("Projects", color = KwanheeColors.onBackground) }
                TextButton(onClick = { /*TODO*/ }) { Text("Contact", color = KwanheeColors.onBackground) }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = KwanheeColors.secondary)
                ) {
                    Text("Resume", color = KwanheeColors.onBackground)
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = KwanheeColors.background
        )
    )
}

@Preview
@Composable
private fun PortfolioTopAppBarPreview() {
    KwanheeTheme {
        PortfolioTopAppBar()
    }
}