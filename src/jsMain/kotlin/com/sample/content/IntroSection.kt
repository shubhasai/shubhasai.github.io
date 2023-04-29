package com.portfolio.content

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.portfolio.components.ContainerInSection
import com.portfolio.style.*

@Composable
fun Intro() {
    ContainerInSection(WtSections.wtSectionBgGrayDark) {
        Div({
            classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
        }) {

            Div({
                classes(WtCols.wtCol2, WtCols.wtColMd3)
                style {
                    alignSelf(AlignSelf.Start)
                }
            }) {
                Img(src = "i1.svg", attrs = { classes(AppStylesheet.composeLogo) })
            }

            Div({
                classes(
                    WtCols.wtCol10,
                    WtCols.wtColMd8,
                    WtCols.wtColSm12,
                    WtOffsets.wtTopOffsetSm12
                )
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


        Div(attrs = {
            classes(WtDisplay.wtDisplayNone, WtDisplay.wtDisplayMdBlock)
        }) {
            IntroAboutComposeWeb()
        }
    }
}

@Composable
private fun IntroAboutComposeWeb() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM)
    }) {

        Div({
            classes(WtCols.wtCol9, WtCols.wtColMd9, WtCols.wtColSm12)
        }) {
            P({ classes(WtTexts.wtSubtitle2, WtOffsets.wtTopOffset24)
                style  {
                    color(Color("#fff"))
                }}) {
                Text("Currently working with Android, Kotlin, Compose Multiplatform, KMM. Experienced with Google's ")

                A(href = "https://developer.android.com/jetpack/compose", attrs = {
                    classes(WtTexts.wtLink)
                    target(ATarget.Blank)
                }) {
                    Text("modern libraries")
                }

                Text(" and technologies for Android")
            }

            P({
                classes(WtTexts.wtText1, WtOffsets.wtTopOffset24)
                style  {
                    color(Color("#fff"))
                }
            }) {
            Text(
                "Hey there, I'm Shubhasai Mohapatra, a third-year student of Electronics and Telecommunication Engineering at IIIT Bhubaneswar. I'm a computer nerd and love to code in C, C++, Python, and Kotlin. My goal is to create practical solutions that make life easier for people. I'm a huge fan of Android development and can't wait to see where my passion for coding takes me."
            )
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
