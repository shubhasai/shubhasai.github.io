package com.portfolio.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.portfolio.style.*
import kotlinx.browser.window
import org.w3c.dom.Window
import org.w3c.dom.events.Event

@Composable
fun Header() {
    Section(attrs = {
        classes(WtSections.wtSectionBgGrayDark)
        style {
            position(Position.Fixed)
            top(0.px)
            left(0.px)
            width(100.percent)
            property("z-index", "20")
            // Add other CSS properties as needed
        }
    }) {
        Div(attrs = {
            classes(WtContainer.wtContainer)
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween) // Aligns children with space between
            }
        }) {
            Div(attrs = {
                classes(WtCols.wtCol2, WtCols.wtCol2)
                style {
                    height(50.percent)
                    width(50.percent)
                }
                // Additional styles if necessary
            }) {
                Logo() // Logo on the left
            }

            Div(attrs = {
                classes(WtCols.wtCol1, WtCols.wtCol1)
                style {
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                }
            }) {
                ResponsiveNavBar() // Menu on the right
            }
        }
    }
}
@Composable
fun LargeScreenMenu() {
    Div({ classes(WtContainer.wtContainer) }) {
        // Your menu items
        getSocialLinks().forEach { HomeIconLink(it) }
    }
}
@Composable
fun SmallScreenMenu(isMenuExpanded: Boolean, onToggleMenu: () -> Unit) {
    Div {
        // Hamburger icon
        Div({
            onClick { onToggleMenu() }
            style {
                // Styles for the hamburger icon
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)
                // Add more styles if needed
            }
        }) {
            H3(attrs = {
                style {
                    color(Color.beige)
                }
            }) {
                Text("☰")  // Placeholder for the hamburger icon
            }
        }

        // Menu items (visible when isMenuExpanded is true)
        if (isMenuExpanded) {
            Div({
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    // Additional styles for spacing, background, etc.
                }
            }) {
                getSocialLinks().forEach { HomeIconLink(it) }
            }
        }
    }
}


@Composable
fun ResponsiveNavBar() {
    val windowWidth = remember { mutableStateOf(window.innerWidth) }
    val isMenuExpanded = remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        val onResize: (Event) -> Unit = { windowWidth.value = window.innerWidth }
        window.addEventListener("resize", onResize)
        onDispose { window.removeEventListener("resize", onResize) }
    }

    if (windowWidth.value > 1000) {
        // Large screen layout
        LargeScreenMenu()
    } else {
        // Small screen layout
        SmallScreenMenu(isMenuExpanded.value) { isMenuExpanded.value = !isMenuExpanded.value }
    }
}


@Composable
private fun Logo() {
    Div(attrs = {
        classes(WtCols.wtColInline)
        style {
            alignSelf(AlignSelf.SelfStart)
            width(50.percent)
            height(50.percent)
        }
    }) {
        A(attrs = {
            target(ATarget.Blank)
        }, href = "https://shubhasaimohapatra.in") {
            Div(attrs = {
                classes("jetbrains-logo", "_logo-jetbrains-square", "_size-4")
            }) {}
        }
    }
}

@Composable
private fun Menu(){
    Div({ classes(WtContainer.wtContainer) }) {
        Div({
            style {
                justifyContent(JustifyContent.Right)
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
            }
        }) {
            Div({classes(WtCols.wtColInline)
                    style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)}
            }) {
                getSocialLinks().forEach { HomeIconLink(it) }
            }
        }
    }
}
@Composable
private fun HomeIconLink(link: NavigationLink) {
    A(attrs = {
        classes(WtTexts.wtSocialButtonItem)
    }, href = link.url) {
        Img(src = link.iconSvg) {}
    }
}

data class NavigationLink(
    val iconSvg: String,
    val url:String
)


private fun getSocialLinks(): List<NavigationLink> {
    return listOf(
        NavigationLink ("home.png","#home_section"),
        NavigationLink ("skill.png","#skill_section"),
        NavigationLink ("work.png","#work_section"),
        NavigationLink ("blog.png","#project_section"),
        NavigationLink ("chat.png","#social_section"),
    )
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