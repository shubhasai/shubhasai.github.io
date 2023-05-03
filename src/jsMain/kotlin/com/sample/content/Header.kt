package com.portfolio.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.portfolio.style.*
import kotlinx.browser.window

@Composable
fun Header() {
    Section(attrs = {
        classes(WtSections.wtSectionBgGrayDark)
    }) {
        Div({ classes(WtContainer.wtContainer)
        style {
            display(DisplayStyle.Flex)
        }}) {
            Div({
                classes(WtRows.wtRow, WtRows.wtRowSizeM)
                style {
                    alignSelf(AlignSelf.Center)
                }
            }) {
                Logo()
                // TODO: support i18n
                //LanguageButton()
            }
        }
    }
}

@Composable
private fun Logo() {
    Div(attrs = {
        classes(WtCols.wtColInline)
        style {
            alignSelf(AlignSelf.Center)
        }
    }) {
        A(attrs = {
            target(ATarget.Blank)
        }, href = "https://shubhasaimohapatra.in") {
            Div(attrs = {
                classes("jetbrains-logo", "_logo-jetbrains-square", "_size-5")
            }) {}
        }
    }
}

@Composable
private fun LanguageButton() {
    Div(attrs = {
        classes(WtCols.wtColInline)
    }) {
        Button(attrs = {
            classes(WtTexts.wtButton, WtTexts.wtLangButton)
            onClick { window.alert("Oops! This feature is yet to be implemented") }
        }) {
            Img(src = "ic_lang.svg", attrs = { style {
                paddingLeft(8.px)
                paddingRight(8.px)
            }})
            Text("English")
        }
    }
}