package net.ifmain.itzme.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import net.ifmain.itzme.components.PageLayout
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Page("/contact")
@Composable
fun ContactPage() {
    PageLayout(currentSection = 3) {
        contactSection()
    }
}

@Composable
fun contactSection() {
    Box(
        Modifier
            .fillMaxSize()
            .styleModifier {
                property("display", "flex")
                property("align-items", "center")
                property("justify-content", "center")
            }
    ) {
        Column(
            Modifier.maxWidth(1000.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                "LET'S WORK",
                Modifier
                    .fontSize(6.cssRem)
                    .fontWeight(FontWeight.Black)
                    .color(Color("#ffffff"))
                    .styleModifier {
                        property("letter-spacing", "-2px")
                        property("line-height", "1")
                    }
            )
            SpanText(
                "TOGETHER",
                Modifier
                    .fontSize(6.cssRem)
                    .fontWeight(FontWeight.Black)
                    .styleModifier {
                        property("color", "#00ffff")
                        property("letter-spacing", "-2px")
                        property("line-height", "1")
                        property("text-shadow", "0 0 30px rgba(0, 255, 255, 0.5)")
                    }
            )

            Box(
                Modifier
                    .width(100.px)
                    .height(4.px)
                    .background(Color("#00ffff"))
                    .margin(top = 60.px, bottom = 60.px)
            )

            // 연락처 링크 - 가로
            Row(
                Modifier.gap(60.px)
            ) {
                contactItem("EMAIL", "gayoung990911@gmail.com", "mailto:gayoung990911@gmail.com")
                contactItem("GITHUB", "github.com/gay00ung", "https://github.com/gay00ung")
                contactItem("LINKEDIN", "linkedin.com/in/가영-신-5118552b2/", "https://linkedin.com/in/가영-신-5118552b2/")
            }
        }
    }
}

@Composable
fun contactItem(label: String, value: String, url: String) {
    Link(
        path = url,
        modifier = Modifier.styleModifier {
            property("text-decoration", "none")
            property("color", "inherit")
        },
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            Modifier
                .cursor(Cursor.Pointer)
                .styleModifier {
                    property("transition", "all 0.3s ease")
                }
        ) {
        SpanText(
            label,
            Modifier
                .fontSize(0.8.cssRem)
                .color(Color("#666666"))
                .margin(bottom = 10.px)
                .styleModifier {
                    property("letter-spacing", "2px")
                }
        )
        SpanText(
            value,
            Modifier
                .fontSize(1.1.cssRem)
                .color(Color("#00ffff"))
                .styleModifier {
                    property("text-decoration", "underline")
                    property("text-underline-offset", "5px")
                }
        )
        }
    }
}