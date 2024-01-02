package com.portfolio.content

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.portfolio.components.CardDark
import com.portfolio.components.ContainerInSection
import com.portfolio.components.LinkOnCard
import com.portfolio.style.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

private data class GetStartedCardPresentation(
    val title: String,
    val content: String,
    val links: List<LinkOnCard>,
    val tags:String
)

private fun getCards(): List<GetStartedCardPresentation> {
    return listOf(
        GetStartedCardPresentation(
            title = "Well Nation Android App",
            content = "An health-based Android app written in kotlin in which users can find hospitals book appointments, and trigger an emergency alert when they are in an emergency. nearby ambulance, blogs, etc.",
            links = listOf(
                LinkOnCard(
                    linkText = "Github Link",
                    linkUrl = "https://github.com/Wellnation/WellnationAndroidApp"
                )
            ),
            tags = "Services, Broadcast Receivers, Intents, Locations (GPS Module), Custom App Widgets, OkHTTP, Google Map API"
        ),
        GetStartedCardPresentation(
            title = "Tacos",
            content = "App that helps developers to connect with other developers having an interest in different tech fields. It also has features like Group Formation and Group Chat",
            links = listOf(
                LinkOnCard(
                    linkText = "Github Link",
                    linkUrl = "https://github.com/shubhasai/Tacos"
                )
            ),
            tags = "Jetpack Navigation, Better UI designing, Firebase Integration, Room Database, Uses of Coroutine, Firebase Storage"
        ),
        GetStartedCardPresentation(
            title = "Finger Tip",
            content = "An Android app that has all recent headlines. Along with this, it has popular shopping sites implemented as webview",
            links = listOf(
                LinkOnCard(
                    linkText = "Github Link",
                    linkUrl = "https://github.com/shubhasai/fingertip"
                )
            ),
            tags = "Fragments, WebView Implementation, Layout Designing"
        )
    )
}
@Composable
private fun CardContent(text: String,tags:String) {
    P(attrs = {
        classes(WtTexts.wtText2, WtTexts.wtText2ThemeDark, WtOffsets.wtTopOffset24)
    }) {
        Text(text)
    }
    P(attrs = {
        classes(WtTexts.wtText2, WtTexts.wtText2ThemeDark, WtOffsets.wtTopOffset24)
    }) {
        Text("Tech Used: $tags")
    }

}
@Composable
private fun ExpCardContent(text: String,tags:String) {
    P(attrs = {
        classes(WtTexts.wtText2, WtTexts.wtText2ThemeDark, WtOffsets.wtTopOffset24)
    }) {
        Text(text)
    }

}
@Composable
private fun WorkExpCardContent(
    job:Job
) {
    Div(attrs = {
        style {
            marginBottom(20.px)
        }
    }) {
        // Company Name
        P(attrs = { classes(WtTexts.wtText1, WtTexts.wtText1)
        style {
            color(Color.beige)
        }
        }) {
            Text(job.companyName)
        }
        P(attrs = { classes(WtTexts.wtText2, WtTexts.wtText2ThemeDark) }) {
            Text("${job.startDate} - ${job.endDate}")
        }

        // Job Description
        P(attrs = { classes(WtTexts.wtText2, WtTexts.wtText2ThemeDark, WtOffsets.wtTopOffset24) }) {
            Text(job.jobDescription)
        }

        // Dates

        // Skills as Chips
        Div(attrs = {
            classes(WtContainer.wtContainer)
            style {
                marginTop(10.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                flexWrap(FlexWrap.Wrap)
            }
        }) {
            job.skills.forEach { skill ->
                Chip(skill = skill)
            }
        }
    }
}
@Composable
private fun ProjectExpCardContent(
    job:Project
) {
    Div(attrs = {
        style {
            marginBottom(20.px)
        }
    }) {
        // Company Name
        P(attrs = { classes(WtTexts.wtText2, WtTexts.wtText2)
            style {
                color(Color.beige)
            }
        }) {
            Div(attrs = {
                // Add your styling for the chips here
                style {
                    padding(4.px)
                    margin(4.px)
                    display(DisplayStyle.Flex)
                    flexWrap(FlexWrap.Wrap)
                    backgroundColor(Color.beige)
                    borderRadius(8.px)
                }
            }) {
                P(attrs = {
                    // Add your styling for the chips here
                    style {
                        color(Color.black)
                        padding(5.px)
                        fontSize(15.px)
                    }
                }){
                    Text(job.projectTag)
                }
            }
        }

        // Job Description
        P(attrs = { classes(WtTexts.wtText2, WtTexts.wtText2ThemeDark, WtOffsets.wtTopOffset24) }) {
            Text(job.projectDescription)
        }
        Div(attrs = {
            classes(WtContainer.wtContainer)
            style {
                marginTop(10.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row)
                flexWrap(FlexWrap.Wrap)
            }
        }) {
            job.skills.forEach { skill ->
                Chip(skill = skill)
            }
        }
    }
}

@Composable
private fun Chip(skill: String) {
    Div(attrs = {
        // Add your styling for the chips here
        style {
            padding(4.px)
            margin(4.px)
            backgroundColor(Color.beige)
            borderRadius(8.px)
        }
    }) {
        H5(attrs = {
            // Add your styling for the chips here
            style {
                color(Color.black)
                padding(5.px)
            }
        }){
            Text(skill)
        }
    }
}

@Composable
fun GetStarted() {
    ContainerInSection(WtSections.wtSectionBgGrayDark) {
        H1(attrs = {
            classes(WtTexts.wtH2, WtTexts.wtH2ThemeDark)
        }) {
            Text("My Works")
        }

        Div(attrs = {
            classes(WtRows.wtRowSizeM, WtRows.wtRow, WtOffsets.wtTopOffset24)
        }) {
            Div(attrs = {
                classes(WtCols.wtCol6, WtCols.wtColMd10, WtCols.wtColSm12, WtOffsets.wtTopOffset24)
            }) {
                P(attrs = {
                    classes(WtTexts.wtText1)
                    style  {
                        color(Color("#fff"))
                    }
                }) {
                    Text("Learn more about my project from here")
                }
            }
        }


        Div(attrs = {
            classes(WtRows.wtRowSizeM, WtRows.wtRow, WtOffsets.wtTopOffset24)
        }) {
            Div(attrs = {
                classes(WtCols.wtCol6, WtCols.wtColMd10, WtCols.wtColSm12, WtOffsets.wtTopOffset24)
            }) {
                P(attrs = {
                    classes(WtTexts.wtText1)
                    style  {
                        color(Color("#fff"))
                    }
                }) {
                    Text("My Experience")
                }
            }
        }
    }
}
@Serializable
data class Job(
    val _id: String,
    val jobTitle: String,
    val companyName: String,
    val jobDescription: String,
    val startDate: String, // Consider using a more appropriate type for dates
    val endDate: String,   // such as java.time.LocalDate in a non-serializable context
    val skills: List<String>,
    val companyLink: String
)
suspend fun getJob():List<Job> {
    val client = HttpClient(Js) {
        install(ContentNegotiation) { json(Json) }
    }
    val response: HttpResponse = client.get("https://app.shubhasaimohapatra.in/workexps")
    val responseBody: String = response.bodyAsText()
    println("Raw JSON response: $responseBody")
    val body = response.body<List<Job>>()
    println("Body"+body[0].companyName)
    client.close()
    return body
}
@Composable
fun Works() {
    ContainerInSection(WtSections.wtSectionBgGrayDark) {
        val data: MutableState<List<Job>> = remember { mutableStateOf(emptyList()) }
        LaunchedEffect(key1 = Unit) {
              // Assuming getSkill() is a suspend function that returns a List<Skill>
            try {
                data.value = getJob()
            }catch (e:Exception){
                println(e.message.toString())
            }
        }
        Div(attrs = {
            id("work_section")
            classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)  // Center content horizontally
            }
        }) {
            H1(attrs = { classes(WtTexts.wtHero2) }) {
                Text("Experience")
            }
        }
        Div(attrs = {
            //classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row) // Arrange items vertically
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
                width(100.percent)  // Adjust width as needed (e.g., 50% of the screen)
                marginTop(10.px)  // Center content horizontally
            }
        }) {
            Div(
                attrs = {
                    classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffsets.wtTopOffset24)
                }
            ) {
                data.value.forEach {
                    val links:ArrayList<LinkOnCard> = ArrayList()
                    links.add(LinkOnCard(it.companyName,it.companyLink))
                    CardDark(
                        title = it.jobTitle,
                        links = links,
                        wtExtraStyleClasses = listOf(WtCols.wtCol4, WtCols.wtColMd6, WtCols.wtColSm12)
                    ) {
                        WorkExpCardContent(it)
                    }
                }
            }
        }

    }
}
@Serializable
data class Project(
    val _id: String,
    val projectTitle: String,
    val projectDescription: String,
    val thumbnailUrl: String,
    val projectTag: String,
    val skills: List<String>,
    val projectLink: String,
    val videoLink: String,
    val screenshotsLink: List<String>
)
suspend fun getProject():List<Project> {
    val client = HttpClient(Js) {
        install(ContentNegotiation) { json(Json) }
    }
    val response: HttpResponse = client.get("https://app.shubhasaimohapatra.in/projects")
    val responseBody: String = response.bodyAsText()
    println("Raw JSON response: $responseBody")
    val body = response.body<List<Project>>()
    println("Body"+body[0].projectTitle)
    client.close()
    return body
}
@Composable
fun Projects() {
    val data: MutableState<List<Project>> = remember { mutableStateOf(emptyList()) }
    LaunchedEffect(key1 = Unit) {
        // Assuming getSkill() is a suspend function that returns a List<Skill>
        try {
            data.value = getProject()
        }catch (e:Exception){
            println(e.message.toString())
        }
    }
    ContainerInSection(WtSections.wtSectionBgGrayDark) {
        Div(attrs = {
            id("project_section")
            classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)  // Center content horizontally
            }
        }) {
            H1(attrs = { classes(WtTexts.wtHero2) }) {
                Text("Projects ")
            }
        }
        Div(attrs = {
            //classes(WtContainer.wtContainer, WtOffsets.wtTopOffset96)
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Row) // Arrange items vertically
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
                width(100.percent)  // Adjust width as needed (e.g., 50% of the screen)
                marginTop(10.px)  // Center content horizontally
            }
        }) {
            Div(
                attrs = {
                    classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffsets.wtTopOffset24)
                }
            ) {
                data.value.forEach {
                    val links:ArrayList<LinkOnCard> = ArrayList()
                    links.add(LinkOnCard(it.projectTitle,it.projectLink))
                    CardDark(
                        title = it.projectTitle,
                        links = links,
                        wtExtraStyleClasses = listOf(WtCols.wtCol4, WtCols.wtColMd6, WtCols.wtColSm12)
                    ) {
                        ProjectExpCardContent(it)
                    }
                }
            }
        }

    }
}
