package net.ifmain.itzme.pages

import androidx.compose.runtime.*
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
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.browser.window
import net.ifmain.itzme.components.PageLayout
import org.jetbrains.compose.web.css.*

@Page("/work")
@Composable
fun WorkPage() {
    PageLayout(currentSection = 2) {
        workSection()
    }
}

@Composable
fun workSection() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(100.px)
    ) {
        Column {
            // 섹션 제목
            Row(
                Modifier.margin(bottom = 80.px)
            ) {
                SpanText(
                    "02",
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
                    "WORK",
                    Modifier
                        .fontSize(1.5.cssRem)
                        .color(Color("#ffffff"))
                        .styleModifier {
                            property("letter-spacing", "4px")
                            property("font-weight", "300")
                        }
                )
            }

            // 프로젝트 목록 - 가로 레이아웃
            Column(
                Modifier.gap(30.px)
            ) {
                projectRow("01", "POIT", "AI 기반 음식 영양 정보 분석 앱", "KOTLIN / GPT API / Firebase Auth / Hilt", "https://play.google.com/store/apps/details?id=net.ifmain.poit.aos&pcampaignid=web_share")
                projectRow("02", "환율톡톡", "매일 오늘의 환율을 알려주는 환율 알리미 앱", "KMP / Koin / Admob / Clean Architecture", "https://play.google.com/store/apps/details?id=net.ifmain.hwanultoktok.kmp")
                projectRow("03", "모노로그", "하루 한 줄 감정과 함께 기록하는 개인 일기장 앱", "Compose / Ktor / Firebase Auth", "https://play.google.com/store/apps/details?id=net.ifmain.monologue")
                projectRow("04", "WorgleWorgle", "매일 새로운 단어를 추측하는 한국형 단어 게임 앱", "Kotlin / Compose", "https://play.google.com/store/apps/details?id=com.worgle.worgle")
                projectRow("05", "QR MINE", "QR 코드 생성 앱", "Kotlin / ZXING", "https://play.google.com/store/apps/details?id=net.ifmain.qr_mine")
            }
        }
    }
}

@Composable
fun projectRow(number: String, title: String, description: String, tech: String, url: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .styleModifier {
                property("position", "relative")
                property("overflow", "hidden")
            }
            .onClick {
                window.open(url, "_blank")
            }
    ) {
        // 호버 효과 배경
        Box(
            Modifier
                .position(Position.Absolute)
                .fillMaxSize()
                .styleModifier {
                    property("background", "linear-gradient(90deg, transparent, rgba(0, 255, 255, 0.05), transparent)")
                    property("transform", "translateX(-100%)")
                    property("transition", "transform 0.5s ease")
                }
                .classNames("project-hover-bg")
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(30.px, 40.px)
                .border(1.px, LineStyle.Solid, Color("#1a1a1a"))
                .cursor(Cursor.Pointer)
                .styleModifier {
                    property("transition", "all 0.3s ease")
                    property("position", "relative")
                    property(
                        "background",
                        "linear-gradient(90deg, transparent 0%, rgba(0, 255, 255, 0.01) 50%, transparent 100%)"
                    )
                }
                .classNames("project-row"),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 프로젝트 번호
            SpanText(
                number,
                Modifier
                    .fontSize(1.2.cssRem)
                    .color(Color("#00ffff"))
                    .margin(right = 50.px)
                    .styleModifier {
                        property("font-weight", "300")
                    }
            )

            // 프로젝트 제목
            Column(
                Modifier.flex(1)
            ) {
                SpanText(
                    title,
                    Modifier
                        .fontSize(2.cssRem)
                        .color(Color("#ffffff"))
                        .fontWeight(FontWeight.Bold)
                        .styleModifier {
                            property("letter-spacing", "1px")
                        }
                )
                SpanText(
                    description,
                    Modifier
                        .fontSize(1.cssRem)
                        .color(Color("#666666"))
                        .margin(top = 5.px)
                )
            }

            // 기술 스택
            SpanText(
                tech,
                Modifier
                    .fontSize(0.9.cssRem)
                    .color(Color("#00ffff"))
                    .styleModifier {
                        property("letter-spacing", "2px")
                        property("font-weight", "300")
                    }
            )

            // 애니메이션 화살표
            Box(
                Modifier
                    .margin(left = 50.px)
                    .styleModifier {
                        property("color", "#00ffff")
                        property("font-size", "1.5rem")
                        property("transition", "transform 0.3s ease")
                    }
                    .classNames("project-arrow")
            ) {
                SpanText("→")
            }
        }
    }
}