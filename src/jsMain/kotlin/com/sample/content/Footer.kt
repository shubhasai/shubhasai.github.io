package com.portfolio.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.portfolio.style.*


@Composable
fun PageFooter() {
    Footer({
        style {
            flexShrink(0)
            boxSizing("border-box")
        }
    }) {
        Section({
            classes(WtSections.wtSectionBgGrayDark)
            style {
                padding(24.px, 0.px)
            }
        }) {
            Div({ classes(WtContainer.wtContainer) }) {
                Div({
                    classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
                    style {
                        justifyContent(JustifyContent.Center)
                        flexWrap(FlexWrap.Wrap)
                    }
                }) {

                    Div({
                        classes(WtCols.wtColInline)
                    }) {
                        P({
                            classes(WtTexts.wtText1, WtTexts.wtText1ThemeDark)
                        }) {
                            Text("Follow me")
                        }
                    }

                    Div({
                        classes(WtCols.wtColInline)
                    }) {
                        getSocialLinks().forEach { SocialIconLink(it) }
                    }
                }

                CopyrightInFooter()
            }
        }
    }
}

@Composable
private fun CopyrightInFooter() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter, WtOffsets.wtTopOffset48)
        style {
            justifyContent(JustifyContent.SpaceEvenly)
            flexWrap(FlexWrap.Wrap)
            padding(0.px, 12.px)
        }
    }) {
        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Copyright © 2023  Shubhasai Mohapatra")
        }

        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Developed with Compose Multiplatform for Web and Kotlin")
        }
    }
}

@Composable
private fun SocialIconLink(link: SocialLink) {
    A(attrs = {
        classes(WtTexts.wtSocialButtonItem)
        target(ATarget.Blank)
    }, href = link.url) {
        Img(src = link.iconSvg) {}
    }
}

data class SocialLink(
    val id: String,
    val url: String,
    val title: String,
    val iconSvg: String
)

private fun getSocialLinks(): List<SocialLink> {
    return listOf(
        SocialLink("facebook", "https://www.facebook.com/shubhasai.mohapatra.3/", "Join me on Facebook", "ic_fb.svg"),
        SocialLink("twitter", "https://twitter.com/m_shubhasai", "Join me on Twitter", "ic_twitter.svg"),
        SocialLink(
            "linkedin",
            "https://www.linkedin.com/in/shubhasai-mohapatra/",
            "Connect with me on Linkedin",
            "ic_linkedin.svg"
        ),
//        SocialLink("youtube", "https://www.youtube.com/user/JetBrainsTV", "JetBrains on YouTube", "ic_youtube.svg"),
        SocialLink("instagram", "https://www.instagram.com/m_shubhasai/", "Folllow me on Instagram", "ic_insta.svg")
//        SocialLink("blog", "https://blog.jetbrains.com/", "JetBrains blog", "ic_jb_blog.svg"),
//        SocialLink("rss", "https://blog.jetbrains.com/feed/", "JetBrains RSS Feed", "ic_feed.svg"),
    )
}