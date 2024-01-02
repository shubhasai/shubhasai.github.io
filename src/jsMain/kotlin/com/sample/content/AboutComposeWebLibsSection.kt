package com.portfolio.content

import androidx.compose.runtime.*
import com.portfolio.components.Card
import org.jetbrains.compose.web.dom.*
import com.portfolio.components.ContainerInSection
import com.portfolio.components.ContainerInSectionFill
import com.portfolio.components.LinkOnCard
import com.portfolio.style.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import io.ktor.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json.Default.decodeFromString
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import org.jetbrains.compose.web.css.*
import org.w3c.dom.HTMLElement

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

@Serializable
data class skill(
    val _id: String,
    val skill: String,
    val rating: Double
)
@Serializable
data class allskill(
    val skills:ArrayList<skill>
)
suspend fun getSkill():List<skill> {
    val client = HttpClient(Js) {
        install(ContentNegotiation) { json(Json) }
    }
    val response: HttpResponse = client.get("https://app.shubhasaimohapatra.in/skills")
    val responseBody: String = response.bodyAsText()
    println("Raw JSON response: $responseBody")
    val body = response.body<List<skill>>()
    println("Body"+body[0].skill)
    client.close()
    return body
}
@Composable
fun SkillSection() {
    val data: MutableState<List<skill>> = remember { mutableStateOf(emptyList()) }
    LaunchedEffect(key1 = Unit) {
          // Assuming getSkill() is a suspend function that returns a List<Skill>
        try {
            data.value = getSkill()
        }catch (e:Exception){
            println(e.message.toString())
        }
    }
    val skills = listOf(
        Skill("Kotlin",
            4.5f),
        Skill("Java", 4.0f),
        Skill("Android", 4.5f),
        Skill("Kotlin",
            4.5f),
        Skill("Java", 4.0f),
        Skill("Android", 4.5f),
        Skill("Kotlin",
            4.5f),
        Skill("Java", 4.0f),
        Skill("Android", 4.5f),
        Skill("Android", 4.5f)
    )
    ContainerInSection(WtSections.wtSectionBgGrayDark) {
        Div(attrs = {
            id("skill_section")
            classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)  // Center content horizontally
            }
        }) {
            H1(attrs = { classes(WtTexts.wtHero2) }) {
                Text("Wanna Know Me More? ")
            }
        }
        Div(attrs = {
            //classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column) // Arrange items vertically
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
                width(100.percent)  // Adjust width as needed (e.g., 50% of the screen)
                marginTop(10.px)  // Center content horizontally
            }
        }) {
            Div({
                classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
                style {
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.SpaceBetween)
                    width(100.percent)
                    marginTop(50.px)
                }
            }) {
                // First Div for Lottie animation (40% width)
                Div(attrs = {
                    classes(WtCols.wtCol5, WtCols.wtColMd5)
                    style {
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Column) // Arrange items vertically
                        alignItems(AlignItems.Center) // Center align items horizontally
                        width(50.percent)
                        justifyContent(JustifyContent.Center) // Center align items vertically
                    }
                }) {
                    // Embed Lottie animation, centered
                    Div(attrs = {
                        classes(WtCols.wtCol2)
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Column) // Arrange items vertically
                            alignItems(AlignItems.Center) // Center align items horizontally
                            width(40.percent)
                            justifyContent(JustifyContent.Center) // Center align items vertically
                        }
                    }) {
                        DotLottiePlayer()
                    }

                    // Paragraph text below the Lottie player
                    P(attrs = {
                        // Apply additional styles if necessary
                        style {
                            textAlign("center") // Center-align the text
                            marginTop(20.px) // Add space between the Lottie player and the paragraph
                            color(Color.white)
                        }
                    }) {
                        Text("Hey, I'm Shubhasai Mohapatra, weaving the future in the digital tapestry at IIIT Bhubaneswar. As an Electronics and Telecommunication Engineering maverick, I'm not just studying code; I'm crafting it. Android development is my realms of creation. Currently in my fourth year, I'm not just a student; I'm a Software Development Intern at Nudge, shaping tomorrow's tech today.")
                    }
                }


                // Second Div for text content (60% width)
                Div({
                    classes(WtCols.wtCol5, WtCols.wtColMd5, WtCols.wtColSm12, WtOffsets.wtTopOffsetSm12)
                    style {
                        width(50.percent)
                        marginLeft(20.px)
                    }
                }) {
                    SkillsList(data.value)
                }
            }
        }
    }
}

@Composable
private fun DotLottiePlayer() {
    TagElement<HTMLElement>("dotlottie-player", {
        attr("src", "https://lottie.host/cea79556-019b-4585-9252-331bb8e61b65/HqRQVKTHju.json")
        attr("background", "transparent")
        attr("speed", "1")
        style {
            property("width", "50.percent")
            property("height", "50.percent")
        }
        attr("loop", "")
        attr("autoplay", "")
    }, content = null)
}
@Serializable
data class Skill(
    val name: String,
    val rating: Float  // Assuming rating is a value from 0 to 5
)


@Composable
fun SkillsList(skills: List<skill>) {
    Div(attrs = {
        // This is the parent container for all skill items
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)  // Arrange items vertically
            width(100.percent)  // Take up full width of the parent
        }
    }) {
        skills.forEach { skill ->
            SkillItem(skill)
        }
    }
}

@Composable
fun SkillItem(skill: skill) {
    Div(attrs = {
        // Style for each skill item
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Start)
            width(100.percent)  // Each skill item takes up full width
            marginBottom(16.px)  // Space between items
        }
    }) {
        H4({
            style {
                color(Color.white)
            }
        }) {
            Text(skill.skill)
        }

        // Progress bar (adapt this part to your progress bar implementation)
        Div(attrs = {
            style {
                width(100.percent)  // Full width for the container
                backgroundColor(Color.gray)  // Background of the progress bar
            }
        }) {
            Div(attrs = {
                style {
                    width((skill.rating / 5 * 100).percent)  // Width based on rating
                    height(15.px)  // Height of the progress bar
                    backgroundColor(Color.beige )  // Foreground color
                }
            }) {
                // Empty content for visual bar
            }
        }
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
