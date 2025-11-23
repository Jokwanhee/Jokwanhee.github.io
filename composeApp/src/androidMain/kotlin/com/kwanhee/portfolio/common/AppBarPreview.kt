package com.kwanhee.portfolio.common

import androidx.compose.runtime.Composable
import com.kwanhee.portfolio.WebPreview
import com.kwanhee.portfolio.components.appbar.PortfolioTopAppBar
import com.kwanhee.portfolio.ui.KwanheeTheme

@WebPreview
@Composable
private fun PortfolioTopAppBarPreview() {
    KwanheeTheme {
        PortfolioTopAppBar()
    }
}