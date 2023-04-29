package com.portfolio

import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import com.portfolio.components.*
import com.portfolio.content.*
import com.portfolio.style.AppStylesheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        Layout {
            Header()
            MainContentLayout {
                Intro()
                ComposeWebLibraries()
                GetStarted()
                //CodeSamples()
                JoinUs()
            }
            PageFooter()
        }
    }
}