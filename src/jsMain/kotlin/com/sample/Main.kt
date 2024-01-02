package com.portfolio

import org.jetbrains.compose.web.renderComposable
import com.portfolio.components.*
import com.portfolio.content.*
import com.portfolio.style.AppStylesheet
import com.sample.content.BackgroundVideo
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)
        val videoUrl = "bggif.gif"

        BackgroundVideo(videoUrl)

        // All your other content goes here, layered above the video
        Div({
            style {
                position(Position.Relative)
                width(100.vw)
                minHeight(100.vh)
                property("zIndex","1")  // This ensures that the content is above the background video
            }
        }) {
            Layout {
                Header()
            }
            Layout {
                MainContentLayout {
                    Intro()
                    SkillSection()
                    Works()
                    Projects()
                    JoinUs()
                }
            }
            Layout {
                PageFooter()
            }
        }
    }
}

