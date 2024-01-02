package com.portfolio.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.dom.Section
import com.portfolio.style.WtContainer
import com.portfolio.style.WtOffsets
import com.portfolio.style.WtSections

@Composable
fun Layout(content: @Composable () -> Unit) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            height(100.percent)
            margin(0.px)
            boxSizing("border-box")
        }
    }) {
        content()
    }
}

@Composable
fun MainContentLayout(content: @Composable () -> Unit) {
    Main({
        style {
            flex("1 0 auto")
            boxSizing("border-box")
            paddingTop(80.px)
            position(Position.Relative)
            property("zIndex","1")
            width(100.vw)
            minHeight(100.vh)  // At least as tall as the viewport
            overflowY("auto")  // Make it scrollable
        }
    }) {
        content()
    }
}

@Composable
fun ContainerInSection(sectionThemeStyleClass: String? = null, content: @Composable () -> Unit) {
    Section({
        if (sectionThemeStyleClass != null) {
            classes(WtSections.wtSection, sectionThemeStyleClass)
            style {
                display(DisplayStyle.Flex)
            }
        } else {
            classes(WtSections.wtSection)
            style {
                display(DisplayStyle.Flex)
            }
        }
    }) {
        Div({
            classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
            style {
                width(100.percent)  // Ensure this div takes the full width
            }
        }) {
            content()
        }
    }
}

@Composable
fun ContainerInSectionFill(sectionThemeStyleClass: String? = null, content: @Composable () -> Unit) {
    Section({
        if (sectionThemeStyleClass != null) {
            classes(WtSections.wtSection, sectionThemeStyleClass)
            style {
                display(DisplayStyle.Flex)
                width(100.percent)
            }
        } else {
            classes(WtSections.wtSection)
            style {
                display(DisplayStyle.Flex)
            }
        }
    }) {
        Div({
            classes(WtSections.wtSection, WtOffsets.wtTopOffset96)
        }) {
            content()
        }
    }
}