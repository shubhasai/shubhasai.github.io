package com.portfolio.style

import org.jetbrains.compose.web.css.*

object WtSections : StyleSheet(AppStylesheet) {

    val wtSection by style {
        boxSizing("flex-box")
        paddingBottom(10.px)
        paddingTop(10.px)
        display(DisplayStyle.Flex)
        property(
            propertyName = "padding-bottom",
            value = "calc(4*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
        )
        backgroundColor(Color.transparent)
    }

    val wtSectionBgGrayLight by style {
        backgroundColor(Color("#f4f4f4"))
        backgroundColor(AppCSSVariables.wtColorGreyLight.value())
    }

    val wtSectionBgGrayDark2 by style {
        backgroundColor(Color("#323236"))
        backgroundColor(AppCSSVariables.wtColorGreyDark.value())
    }
    val wtSection2 by style {
        boxSizing("flex-box")
        paddingBottom(10.px)
        paddingTop(10.px)
        display(DisplayStyle.Flex)
        property(
            propertyName = "padding-bottom",
            value = "calc(4*${AppCSSVariables.wtOffsetTopUnit.value(24.px)})"
        )
        backgroundColor(Color("#fff"))
    }

    val wtSectionBgGrayLight2 by style {
        backgroundColor(Color("#f4f4f4"))
        backgroundColor(AppCSSVariables.wtColorGreyLight.value())
    }

    val wtSectionBgGrayDark by style {
        backgroundColor(Color.transparent)
        backgroundColor(Color.transparent)
    }
}
