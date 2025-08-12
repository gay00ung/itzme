package net.ifmain.itzme.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import net.ifmain.itzme.components.PageLayout
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P

@Page("/about")
@Composable
fun AboutPage() {
    PageLayout(currentSection = 1) {
        aboutSection()
    }
}

@Composable
fun aboutSection() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(100.px)
    ) {
        Column(
            Modifier.fillMaxWidth()
        ) {
            // 섹션 제목
            Row(
                Modifier.margin(bottom = 80.px)
            ) {
                SpanText(
                    "01",
                    Modifier
                        .fontSize(1.5.cssRem)
                        .color(Color("#00ffff"))
                        .margin(right = 30.px)
                        .styleModifier {
                            property("font-weight", "300")
                        }
                )
                Box(
                    Modifier
                        .width(200.px)
                        .height(1.px)
                        .background(Color("#333333"))
                        .margin(top = 15.px, right = 30.px)
                )
                SpanText(
                    "ABOUT",
                    Modifier
                        .fontSize(1.5.cssRem)
                        .color(Color("#ffffff"))
                        .styleModifier {
                            property("letter-spacing", "4px")
                            property("font-weight", "300")
                        }
                )
            }
            
            // 콘텐츠 그리드
            Row(
                Modifier.gap(100.px)
            ) {
                // 통계
                Column(
                    Modifier.flex(1)
                ) {
                    statItem("EXPERIENCE", "2+ YEARS")
                    statItem("PROJECTS", "5+ APPS")
                    statItem("TECH STACK", "5+ TOOLS")
                }
                
                // 설명
                Column(
                    Modifier.flex(2).gap(30.px)
                ) {
                    P {
                        SpanText(
                            "I'm a passionate Android developer focused on creating seamless mobile experiences. " +
                            "My expertise lies in Kotlin, Jetpack Compose, and modern Android architecture patterns.",
                            Modifier
                                .fontSize(1.3.cssRem)
                                .color(Color("#cccccc"))
                                .lineHeight(1.8)
                        )
                    }
                    
                    // 기술 그리드
                    Row(
                        Modifier
                            .margin(top = 50.px)
                            .gap(20.px)
                            .flexWrap(FlexWrap.Wrap)
                    ) {
                        techTag("KOTLIN")
                        techTag("COMPOSE")
                        techTag("ANDROID")
                        techTag("GIT")
                        techTag("CLEAN ARCH")
                        techTag("COROUTINES")
                    }
                }
            }
        }
    }
}

@Composable
fun statItem(label: String, value: String) {
    Column(
        Modifier.margin(bottom = 40.px)
    ) {
        SpanText(
            value,
            Modifier
                .fontSize(3.cssRem)
                .fontWeight(FontWeight.Bold)
                .styleModifier {
                    property("color", "#00ffff")
                    property("text-shadow", "0 0 20px rgba(0, 255, 255, 0.3)")
                    property("letter-spacing", "-1px")
                }
        )
        SpanText(
            label,
            Modifier
                .fontSize(0.9.cssRem)
                .color(Color("#666666"))
                .styleModifier {
                    property("letter-spacing", "2px")
                    property("margin-top", "10px")
                }
        )
    }
}

@Composable
fun techTag(text: String) {
    Box(
        Modifier
            .padding(12.px, 24.px)
            .styleModifier {
                property("position", "relative")
                property("background", "#0a0a0a")
                property("border", "1px solid #00ffff")
                property("transition", "all 0.3s ease")
                property("overflow", "hidden")
            }
    ) {
        // 그라데이션 테두리 효과
        Box(
            Modifier
                .position(Position.Absolute)
                .fillMaxSize()
                .styleModifier {
                    property("background", "linear-gradient(45deg, transparent, rgba(0, 255, 255, 0.1), transparent)")
                    property("transform", "translateX(-100%)")
                    property("transition", "transform 0.6s ease")
                }
                .classNames("tech-hover")
        )
        
        SpanText(
            text,
            Modifier
                .fontSize(0.8.cssRem)
                .color(Color("#00ffff"))
                .styleModifier {
                    property("letter-spacing", "2px")
                    property("font-weight", "500")
                    property("position", "relative")
                    property("z-index", "1")
                }
        )
    }
}