package com.portfolio.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*
import com.portfolio.style.*
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.css.*


data class LinkOnCard(val linkText: String, val linkUrl: String)

@Composable
private fun CardTitle(title: String, darkTheme: Boolean = false) {
    H3({
        classes(WtTexts.wtH3)
        if (darkTheme) {
            classes(WtTexts.wtH3ThemeDark)
        }
    }) {
        Text(title)
    }
}

@Composable
private fun CardLink(link: LinkOnCard) {
    A(
        attrs = {
            classes(WtTexts.wtLink, WtOffsets.wtTopOffset24)
            style {
                marginTop(10.px)
                borderRadius(10.px)
                display(DisplayStyle.Block) // Make it behave like a Div
                backgroundColor(Color.beige) // Example color
                padding(10.px) // Add padding for visual appearance
                textDecoration("none") // Remove underline typically associated with links
                textAlign("center") // Center-align text
                maxWidth(100.percent) // Set a max width if desired
            }
            target(ATarget.Blank) // Open link in a new tab
            href(link.linkUrl) // Set the hyperlink URL
        }
    ) {
        Text("OPEN")
    }
}




    @Composable
    fun Card(
        title: String,
        links: List<LinkOnCard>,
        darkTheme: Boolean = true,
        wtExtraStyleClasses: List<String> = listOf(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12),
        content: @Composable () -> Unit
    ) {
        Div({
            style {
                borderRadius(20.px)
                property("z-index", "10")
            }
            classes(WtCards.wtCard, WtOffsets.wtTopOffset24, *wtExtraStyleClasses.toTypedArray())
            classes(if (darkTheme) WtCards.wtCardThemeDark else WtCards.wtCardThemeLight)
        }) {
            Div({
                classes(WtCards.wtCardSection, WtCards.wtVerticalFlex)
            }) {

                Div({ classes(WtCards.wtVerticalFlexGrow) }) {
                    CardTitle(title = title, darkTheme = darkTheme)
                    content()
                    links.forEach {
                        CardLink(it)
                    }
                }

            }
        }
    }

    @Composable
    fun CardDark(
        title: String,
        links: List<LinkOnCard>,
        wtExtraStyleClasses: List<String> = listOf(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12),
        content: @Composable () -> Unit
    ) {
        Card(
            title = title,
            links = links,
            darkTheme = true,
            wtExtraStyleClasses = wtExtraStyleClasses,
            content = content
        )
    }