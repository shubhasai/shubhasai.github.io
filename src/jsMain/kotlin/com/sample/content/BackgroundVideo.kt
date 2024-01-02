package com.sample.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Source
import org.jetbrains.compose.web.dom.Video

@Composable
fun BackgroundVideo(videoUrl: String) {
    Div({
        style {
            position(Position.Fixed)
            top(0.px)
            right(0.px)
            bottom(0.px)
            left(0.px)
            property("z-index", "-1")  // Ensure the video stays behind other content
        }
    }) {
        Video(attrs = {
            classes("background-video")
            style {
                width(100.percent)
                height(100.percent)
                property("objectFit", "cover")
            }
            attr("autoplay", "autoplay")  // Enable autoplay
            attr("loop", "loop")          // Loop the video
            attr("muted", "muted")        // Mute the video
        }) {
            Source({
                attr("src", videoUrl)
                attr("type", "video/mp4")
            })
        }
    }
}
