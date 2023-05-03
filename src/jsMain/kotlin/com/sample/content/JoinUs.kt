package com.portfolio.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*
import com.portfolio.components.ContainerInSection
import com.portfolio.style.*
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.color

@Composable
fun JoinUs() {
    ContainerInSection(WtSections.wtSectionBgGrayLight) {
        Div(attrs = {
            classes(WtRows.wtRow, WtRows.wtRowSizeM)
        }) {
            Div(attrs = {
                classes(WtCols.wtCol9, WtCols.wtColMd11, WtCols.wtColSm12)
            }) {

                P(attrs = {
                    classes(WtTexts.wtSubtitle2)
                }) {
                    Text("Interested in Hiring me ?")
                    P {
                        Text("Have a look at my ")
                        A(href = "https://docs.google.com/document/d/1ikzk_HxjLzVG3AqOVU0u5436AWHhTc52/edit?usp=sharing&ouid=117304446647628663497&rtpof=true&sd=true", attrs = {
                            classes(WtTexts.wtLink)
                            target(ATarget.Blank)
                        }) {
                            Text("Resume.")
                        }
                        Text("\nFeel free to contact me ")
                        LinkToSlack(
                            url = "mailto:mshubhasai2002@gmail.com",
                            text = "Here"
                        )
                    }
                }
                A(attrs = {
                    classes(WtTexts.wtButton, WtTexts.wtButtonContrast, WtOffsets.wtTopOffset24)
                    target(ATarget.Blank)
                }, href = "https://www.linkedin.com/in/shubhasai-mohapatra/") {
                    Text("Connect with me")
                }
            }
        }

    }
}

@Composable
private fun LinkToSlack(url: String, text: String) {
    A(href = url, attrs = {
        target(ATarget.Blank)
        classes(WtTexts.wtLink)
    }) {
        Text(text)
    }
}
