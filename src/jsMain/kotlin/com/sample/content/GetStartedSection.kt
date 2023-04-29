package com.portfolio.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.portfolio.components.CardDark
import com.portfolio.components.ContainerInSection
import com.portfolio.components.LinkOnCard
import com.portfolio.style.*

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
private fun getexpCards(): List<GetStartedCardPresentation> {
    return listOf(
        GetStartedCardPresentation(
            title = "Interview Duniya (June 2022 - Dec 2022)",
            content = "App Developer Intern. Wireframe the App and Designed the UI of the App’.\n" +
                    "Integrated Authentication Using Firebase Auth for Email and Google.\n" +
                    "Sign In.  For Database used ROOM DB and Firebase Realtime Database and Firestore with MVVM Architecture.\n" +
                    "Integrated 3rd Party APIs using Retrofit and Google Speech to Text API for Voice recognition.",
            links = listOf(
                LinkOnCard(
                    linkText = "Interview Duniya",
                    linkUrl = "https://www.linkedin.com/company/interviewduniya/"
                )
            ),
            tags = "Services, Broadcast Receivers, Intents, Locations (GPS Module), Custom App Widgets, OkHTTP, Google Map API"
        ),
        GetStartedCardPresentation(
            title = "Google Developer Student Club (Aug 2022 - Apr 2023)",
            content = "Volunteering in Android App Dev in Google Developer Student Club IIIT Bhubaneswar. As an App Dev Lead and Android Facilitator organized Google Developers Backed Composed Camp on Our Campus. Took various sessions on Jetpack Compose and Libraries during this Camp.\n",
            links = listOf(
                LinkOnCard(
                    linkText = "GDSC IIIT Bh",
                    linkUrl = "https://www.linkedin.com/company/gdsciiitbh"
                )
            ),
            tags = "Jetpack Navigation, Better UI designing, Firebase Integration, Room Database, Uses of Coroutine, Firebase Storage"
        ),
        GetStartedCardPresentation(
            title = "Tech Society IIIT BH Secretary",
            content = "As a Tech Society secretary organized a Techno-Management fest in IIIT For the First Time\n",
            links = listOf(
                LinkOnCard(
                    linkText = "Tech Society IIIT Bh",
                    linkUrl = "https://www.linkedin.com/company/tech-society-iiitbh"
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

        Div(
            attrs = {
                classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffsets.wtTopOffset24)
            }
        ) {
            getCards().forEach {
                CardDark(
                    title = it.title,
                    links = it.links,
                    wtExtraStyleClasses = listOf(WtCols.wtCol4, WtCols.wtColMd6, WtCols.wtColSm12)
                ) {
                    CardContent(it.content,it.tags)
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

        Div(
            attrs = {
                classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffsets.wtTopOffset24)
            }
        ) {
            getexpCards().forEach {
                CardDark(
                    title = it.title,
                    links = it.links,
                    wtExtraStyleClasses = listOf(WtCols.wtCol4, WtCols.wtColMd6, WtCols.wtColSm12)
                ) {
                    ExpCardContent(it.content,it.tags)
                }
            }
        }
    }
}
