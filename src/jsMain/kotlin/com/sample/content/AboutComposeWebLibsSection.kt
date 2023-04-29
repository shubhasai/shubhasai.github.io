package com.portfolio.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*
import com.portfolio.components.Card
import com.portfolio.components.ContainerInSection
import com.portfolio.components.LinkOnCard
import com.portfolio.style.*
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*

data class CardWithListPresentation(
    val title: String,
    val list: List<String>,
    val links: List<LinkOnCard> = emptyList()
)

private fun createAboutComposeWebCards(): List<CardWithListPresentation> {
    return listOf(
        CardWithListPresentation(
            title = "Composable DOM API",
            list = listOf(
                "Express your design and layout in terms of DOM elements and HTML tags",
                "Use a type-safe HTML DSL to build your UI representation",
                "Get full control over the look and feel of your application by creating stylesheets with a typesafe CSS DSL",
                "Integrate with other JavaScript libraries via DOM subtrees"
            )
        ),
        CardWithListPresentation(
            title = "Multiplatform Widgets With Web Support",
            list = listOf(
                "Use and build Compose widgets that work on Android, Desktop, and Web by utilizing Kotlin's expect-actual mechanisms to provide platform-specific implementations",
                "Experiment with a set of layout primitives and APIs that mimic the features you already know from Compose for Desktop and Android"
            )
        )
    )
}
data class skills(val text:String = "",val iconURL:String = "")
private fun createFeaturesList(): ArrayList<skills> {
    val skill:ArrayList<skills> = ArrayList()
    skill.add(skills("I know various programming languages like C, C++, Kotlin, Python","skill_icon0.svg"))
    skill.add(skills("Worked with various libraries like OkHTTP, Volley, Retrofit, Google MAP Api, Jetpack, Camerax, Firebase, RoomDB","skill_icon1.svg"))
    skill.add(skills("I worked with various tools like Android Studio, VS Code, Intellij Idea, Matlab, Github","skill_icon2.svg"))
    skill.add(skills("My other skills include Management, UI designing, Public Speaking, Technical Sessions","skill_icon3.svg"))
    return skill
}


@Composable
private fun FeatureDescriptionBlock(description: String , icon:String) {
    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
        }
        classes(WtCols.wtCol3, WtCols.wtColMd6, WtCols.wtColSm12, WtOffsets.wtTopOffset48)
    }) {

        Img(src = icon,attrs = { classes(AppStylesheet.skillsLogo)
        style {  alignItems(AlignItems.Center)
            paddingRight(10.px)
        }})
        P(attrs = {
            style  {
                display(DisplayStyle.Flex)
                color(Color("#fff"))
                alignItems(AlignItems.Center)
            }
            classes(WtTexts.wtText1, WtTexts.wtText1HardnessHard, WtOffsets.wtTopOffset12)
        }) {
            Text(description)
        }
    }
}

@Composable
fun ComposeWebLibraries() {
    ContainerInSection(WtSections.wtSectionBgGrayDark) {
        H2(attrs = { classes(WtTexts.wtH2,WtTexts.wtH2ThemeDark) }) {
            Text("Wanna know my skills?")
        }
        Div(attrs = {
            classes(WtRows.wtRow, WtRows.wtRowSizeM)
        }) {
            Div(attrs = {
                classes(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12, WtOffsets.wtTopOffset24)
            }) {
                P(attrs = {
                    classes(WtTexts.wtText1)
                }) {
                    Text("")
                }
            }
        }
        Div(attrs = {
        }) {
//            Img(src = "https://github-readme-streak-stats.herokuapp.com/?user=shubhasai&theme=dark&hide_border=false", attrs = { style {
//                alignSelf(AlignSelf.Center)
//            } })
        }
        Div(attrs = {
            classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffsets.wtTopOffset24)
        }) {
            createFeaturesList().forEach {
                FeatureDescriptionBlock(it.text,it.iconURL)
            }
        }

//        A(attrs = {
//            classes(WtTexts.wtButton, WtTexts.wtButtonThemeLight, WtOffsets.wtTopOffset48, WtOffsets.wtTopOffsetSm24)
//            target(ATarget.Blank)
//        }, href = "https://github.com/jetbrains/compose-jb#compose-for-web") {
//            Text("See all features")
//        }
    }
}

@Composable
private fun CardWithList(card: CardWithListPresentation) {
    Card(
        title = card.title,
        links = card.links
    ) {
        Ul(attrs = {
            classes(WtTexts.wtText2)
        }) {
            card.list.forEachIndexed { _, it ->
                Li({
                    style {
                        paddingTop(24.px)
                    }
                }) { Text(it) }
            }
        }
    }
}
