package com.portfolio.style

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Col

object WtCards : StyleSheet(AppStylesheet) {
    val wtCard by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        border(1.px, LineStyle.Solid)
        minHeight(0.px)
        boxSizing("border-box")
    }

    val wtCardThemeLight by style {
        border(color = rgba(39,40,44,.2))
        color(Color("#27282c"))
        backgroundColor(Color("white"))
    }

    val wtCardThemeDark by style {
        backgroundColor(Color.burlywood)
        color(Color.gray)
        border(0.px)
    }

    val wtCardSection by style {
        position(Position.Relative)
        overflow("auto")
        flex( "1 1 auto")
        minHeight( 0.px)
        boxSizing("border-box")
        padding(24.px, 32.px)

        media(mediaMaxWidth(640.px)) {
            self style { padding(16.px) }
        }
    }

    val wtVerticalFlex by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.FlexStart)
    }

    val wtVerticalFlexGrow by style {
        flexGrow(1)
        maxWidth(100.percent)
    }
}
