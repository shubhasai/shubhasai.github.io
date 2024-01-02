package com.portfolio.content

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.portfolio.components.ContainerInSection
import com.portfolio.style.*
import org.jetbrains.compose.web.attributes.*
import org.w3c.dom.HTMLElement

@Composable
fun Intro() {
    ContainerInSection(WtSections.wtSectionBgGrayDark) {
        Div({
            id("home_section")
            classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.SpaceBetween)
            }
        }) {

            // First Div for Lottie animation (40% width)
            Div({
                classes(WtCols.wtCol3, WtCols.wtColMd3)
                style {
                    alignSelf(AlignSelf.Center)
                }
            }) {
                // Embed Lottie animation
                DotLottiePlayer()
            }

            // Second Div for text content (60% width)
            Div({
                classes(WtCols.wtCol9, WtCols.wtColMd9, WtCols.wtColSm12, WtOffsets.wtTopOffsetSm12)
                style {
                    width(60.percent)
                }
            }) {
                Div({
                }) {
                    H1(attrs = { classes(WtTexts.wtHero) }) {
                        Text("A passionate ")
                        Span({
                            classes(WtTexts.wtHero)
                            style {
                                display(DisplayStyle.InlineBlock)
                                whiteSpace("nowrap")
                            }
                        }) {
                            Text("Android Developer")

//                        Span(attrs = { classes(AppStylesheet.composeTitleTag) }) {
//                            Text("Technology preview")
//                        }
                        }
                    }
                    Div({
                        classes(WtDisplay.wtDisplayMdNone)
                    }) {
                        IntroAboutComposeWeb()
                    }
                }
            }
        }
    }
}

@Composable
private fun DotLottiePlayer() {
    TagElement<HTMLElement>("dotlottie-player", {
        attr("src", "https://lottie.host/4290260e-55bb-41d2-b5fc-4216a01d80bc/Wvnvy42qGy.json")
        attr("background", "transparent")
        attr("speed", "1")
        style {
            property("width", "100.percent")
            property("height", "100.percent")
        }
        attr("loop", "")
        attr("autoplay", "")
    }, content = null)
}



@Composable
fun IntroAboutComposeWeb() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM)
    }) {
        Div({
            classes(WtCols.wtCol9, WtCols.wtColMd9, WtCols.wtColSm12)
        }) {
            P({
                classes(WtTexts.wtSubtitle2, WtOffsets.wtTopOffset24)
                style {
                    color(Color("#fff"))
                }
            }) {
                Text("Currently working with Android, Kotlin, Compose Multiplatform, KMM. Experienced with Google's ")

                A(href = "https://developer.android.com/jetpack/compose", attrs = {
                    classes(WtTexts.wtLink)
                    target(ATarget.Blank)
                }) {
                    Text("modern libraries")
                }

                Text(" and technologies for Android  ")
                Span(attrs = {
                    classes(WtTexts.wtText1, WtOffsets.wtTopOffset24)
                    style {
                        color(Color.beige)
                        //property("cursor", "pointer")
                        property("text-decoration", "underline")
                    }
                })

        }

            //ComposeWebStatusMessage()

            //IntroCodeSample()

            A(
                attrs = {
                    classes(WtTexts.wtButton, WtOffsets.wtTopOffset24)
                    target(ATarget.Blank)
                },
                href = "https://github.com/shubhasai"
            ) {
                Text("Find me on GitHub")
            }

            A(
                attrs = {
                    classes(WtTexts.wtButton, WtOffsets.wtTopOffset24)
                    target(ATarget.Blank)
                },
                href = "https://docs.google.com/document/d/1ikzk_HxjLzVG3AqOVU0u5436AWHhTc52/edit?usp=sharing&ouid=117304446647628663497&rtpof=true&sd=true"
            ) {
                Text("Find my Resume")
            }
        }
    }
}

@Composable
private fun IntroCodeSample() {
    Div({
        style {
            marginTop(24.px)
            backgroundColor(rgba(39, 40, 44, 0.05))
            borderRadius(8.px)
            property("font-family", "'JetBrains Mono', monospace")
        }
    }) {
        Div({
            style {
                property("padding", "12px 16px")
            }
        }) {
            FormattedCodeSnippet(
                code = """
                fun greet() = listOf("Hello", "Hallo", "Hola", "Servus").random()

                renderComposable("greetingContainer") {
                    var greeting by remember { mutableStateOf(greet()) }
                    Button(attrs = { onClick { greeting = greet() } }) {
                        Text(greeting)
                    }
                } 
            """.trimIndent()
            )
        }

        Hr {
            style {
                height(1.px)
                border(width = 0.px)
                backgroundColor(rgba(39, 40, 44, 0.15))
            }
        }

        IntroCodeSampleResult()
    }
}

@Composable
private fun IntroCodeSampleResult() {
    Div({
        style {
            property("padding", "12px 16px")
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            alignItems(AlignItems.Center)
        }
    }) {
        Span({
            classes(WtTexts.wtText2)
            style {
                marginRight(8.px)
            }
        }) {
            Text("Result:")
        }

        fun greet() = listOf("Hello", "Hallo", "Hola", "Servus").random()

        Div({
            id("greetingContainer")
        }) {
            var greeting by remember { mutableStateOf(greet()) }
            Button(attrs = { onClick { greeting = greet() } }) {
                Text(greeting)
            }
        }
    }
}

@Composable
private fun ComposeWebStatusMessage() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeXs, WtOffsets.wtTopOffset24)
    }) {
        Div({
            classes(WtCols.wtColInline)
        }) {
            Img(src = "ic_info.svg", attrs = {
                style {
                    width(24.px)
                    height(24.px)
                }
            })
        }

        Div({
            classes(WtCols.wtColAutoFill)
        }) {
            P({
                classes(WtTexts.wtText3)
            }) {
                Text(
                    "With its current status Technology Preview, Compose for Web " +
                            "is not production-ready, and should only be used in experiments. " +
                            "We are hard at work to bring you great learning materials, tutorials, " +
                            "and documentation, and optimize the performance of Compose for Web in the future!"
                )
            }
        }
    }
}
