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
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Code
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Pre

// 텍스트 글리치 애니메이션
val GlitchAnimation = Keyframes {
    from { 
        Modifier.styleModifier {
            property("text-shadow", "0 0 0 rgba(0, 255, 255, 0)")
        }
    }
    20.percent {
        Modifier.styleModifier {
            property("text-shadow", "2px 2px 0 rgba(255, 0, 255, 0.8), -2px -2px 0 rgba(0, 255, 255, 0.8)")
        }
    }
    40.percent {
        Modifier.styleModifier {
            property("text-shadow", "0 0 0 rgba(0, 255, 255, 0)")
        }
    }
    to {
        Modifier.styleModifier {
            property("text-shadow", "0 0 0 rgba(0, 255, 255, 0)")
        }
    }
}

// 스캔 라인 애니메이션
val ScanLineAnimation = Keyframes {
    from {
        Modifier.styleModifier {
            property("transform", "translateY(-100%)")
        }
    }
    to {
        Modifier.styleModifier {
            property("transform", "translateY(100vh)")
        }
    }
}

// 타이핑 커서 깜박임
val CursorBlink = Keyframes {
    from {
        Modifier.styleModifier {
            property("opacity", "1")
        }
    }
    50.percent {
        Modifier.styleModifier {
            property("opacity", "0")
        }
    }
    to {
        Modifier.styleModifier {
            property("opacity", "1")
        }
    }
}

// 점의 수평 이동
val MoveHorizontal = Keyframes {
    from {
        Modifier.styleModifier {
            property("left", "0")
        }
    }
    to {
        Modifier.styleModifier {
            property("left", "calc(100% - 8px)")
        }
    }
}

@Page
@Composable
fun homePage() {
    var currentSection by remember { mutableStateOf(0) }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color("#000000"))
            .styleModifier {
                property("font-family", "'JetBrains Mono', 'Courier New', monospace")
            }
    ) {
        // 상단 네비게이션 바
        topNavBar(currentSection) { section ->
            currentSection = section
        }

        // 메인 콘텐츠
        Box(
            Modifier
                .fillMaxSize()
                .padding(top = 80.px)
        ) {
            when(currentSection) {
                0 -> heroSection()
                1 -> aboutSection()
                2 -> workSection()
                3 -> contactSection()
            }
        }
    }
}

@Composable
fun topNavBar(currentSection: Int, onSectionChange: (Int) -> Unit) {
    Row(
        Modifier
            .position(Position.Fixed)
            .top(0.px)
            .fillMaxWidth()
            .height(80.px)
            .background(Color("#000000"))
            .borderBottom(1.px, LineStyle.Solid, Color("#00ffff"))
            .padding(0.px, 60.px)
            .zIndex(1000),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 로고
        SpanText(
            "Hello! I'm Gayoung!",
            Modifier
                .fontSize(1.5.cssRem)
                .fontWeight(FontWeight.Bold)
                .styleModifier {
                    property("color", "#00ffff")
                    property("letter-spacing", "4px")
                }
        )

        // 네비게이션 아이템
        Row(
            Modifier
                .styleModifier {
                    property("margin-left", "auto")
                }
                .gap(60.px)
        ) {
            val sections = listOf("HOME", "ABOUT", "WORK", "CONTACT")
            sections.forEachIndexed { index, title ->
                navItem(
                    title = title,
                    isActive = currentSection == index,
                    onClick = { onSectionChange(index) }
                )
            }
        }
    }
}

@Composable
fun navItem(title: String, isActive: Boolean, onClick: () -> Unit) {
    Box(
        Modifier
            .cursor(Cursor.Pointer)
            .onClick { onClick() }
            .padding(10.px, 20.px)
            .styleModifier {
                property("position", "relative")
                property("transition", "all 0.3s ease")
                property("font-weight", "500")
                property("letter-spacing", "2px")
                property("font-size", "0.9rem")
                if (isActive) {
                    property("color", "#00ffff")
                } else {
                    property("color", "#666666")
                }
            }
    ) {
        SpanText(title)

        // 애니메이션 언더라인
        Box(
            Modifier
                .position(Position.Absolute)
                .bottom(0.px)
                .left(0.px)
                .height(2.px)
                .styleModifier {
                    if (isActive) {
                        property("width", "100%")
                        property("background", "#00ffff")
                    } else {
                        property("width", "0%")
                        property("background", "#00ffff")
                    }
                    property("transition", "width 0.3s ease")
                }
        )
    }
}

@Composable
fun heroSection() {
    Box(
        Modifier
            .fillMaxSize()
            .styleModifier {
                property("display", "flex")
                property("align-items", "center")
                property("position", "relative")
                property("overflow", "hidden")
            }
    ) {
        // 그리드 배경 패턴
        Box(
            Modifier
                .position(Position.Absolute)
                .fillMaxSize()
                .styleModifier {
                    property("background-image", """
                        linear-gradient(rgba(0, 255, 255, 0.01) 1px, transparent 1px),
                        linear-gradient(90deg, rgba(0, 255, 255, 0.01) 1px, transparent 1px)
                    """)
                    property("background-size", "50px 50px")
                    property("background-position", "0 0, 0 0")
                }
        )
        
        // 스캔 라인 효과
        Box(
            Modifier
                .position(Position.Absolute)
                .fillMaxWidth()
                .height(2.px)
                .styleModifier {
                    property("background", "linear-gradient(90deg, transparent, rgba(0, 255, 255, 0.5), transparent)")
                    property("pointer-events", "none")
                }
                .animation(ScanLineAnimation.toAnimation(8.s))
        )
        
        // 메인 콘텐츠 - 분할 화면
        Row(
            Modifier
                .fillMaxSize()
                .padding(0.px, 100.px)
        ) {
            // 왼쪽 - 텍스트
            Column(
                Modifier
                    .flex(1)
                    .styleModifier {
                        property("display", "flex")
                        property("flex-direction", "column")
                        property("justify-content", "center")
                    }
            ) {
                Box(
                    Modifier.styleModifier {
                        property("position", "relative")
                    }
                ) {
                    SpanText(
                        "ANDROID",
                        Modifier
                            .fontSize(7.cssRem)
                            .fontWeight(FontWeight.Black)
                            .styleModifier {
                                property("color", "#ffffff")
                                property("line-height", "0.9")
                                property("letter-spacing", "-2px")
                            }
                            .animation(GlitchAnimation.toAnimation(3.s))
                    )
                }
                Box(
                    Modifier.styleModifier {
                        property("position", "relative")
                    }
                ) {
                    SpanText(
                        "DEVELOPER",
                        Modifier
                            .fontSize(7.cssRem)
                            .fontWeight(FontWeight.Black)
                            .styleModifier {
                                property("background", "linear-gradient(90deg, #00ffff 0%, #00ccff 50%, #00ffff 100%)")
                                property("-webkit-background-clip", "text")
                                property("-webkit-text-fill-color", "transparent")
                                property("background-clip", "text")
                                property("line-height", "0.9")
                                property("letter-spacing", "-2px")
                                property("filter", "drop-shadow(0 0 30px rgba(0, 255, 255, 0.5))")
                            }
                    )
                    // 타이핑 커서
                    Box(
                        Modifier
                            .position(Position.Absolute)
                            .right((-20).px)
                            .top(50.percent)
                            .width(4.px)
                            .height(60.px)
                            .background(Color("#00ffff"))
                            .styleModifier {
                                property("transform", "translateY(-50%)")
                            }
                            .animation(CursorBlink.toAnimation(1.s))
                    )
                }
                
                Box(
                    Modifier
                        .width(100.px)
                        .height(2.px)
                        .margin(top = 40.px, bottom = 40.px)
                        .styleModifier {
                            property("background", "linear-gradient(90deg, transparent, #00ffff, transparent)")
                            property("position", "relative")
                        }
                ) {
                    // 움직이는 점
                    Box(
                        Modifier
                            .position(Position.Absolute)
                            .size(8.px)
                            .borderRadius(50.percent)
                            .background(Color("#00ffff"))
                            .styleModifier {
                                property("top", "-3px")
                                property("box-shadow", "0 0 10px rgba(0, 255, 255, 0.8)")
                            }
                            .animation(MoveHorizontal.toAnimation(2.s))
                    )
                }
                
                P {
                    SpanText(
                        "Building high-performance Android applications with Kotlin and Jetpack Compose",
                        Modifier
                            .fontSize(1.2.cssRem)
                            .color(Color("#999999"))
                            .maxWidth(500.px)
                            .lineHeight(1.6)
                    )
                }
            }
            
            // 오른쪽 - 코드 시각화
            Box(
                Modifier
                    .flex(1)
                    .styleModifier {
                        property("display", "flex")
                        property("align-items", "center")
                        property("justify-content", "center")
                    }
            ) {
                codeBlock()
            }
        }
    }
}

@Composable
fun codeBlock() {
    Box(
        Modifier
            .width(600.px)
            .styleModifier {
                property("position", "relative")
            }
    ) {
        // 터미널 창
        Column {
            // 터미널 헤더
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.px)
                    .background(Color("#1a1a1a"))
                    .borderRadius(topLeft = 8.px, topRight = 8.px)
                    .padding(leftRight = 15.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 터미널 버튼
                Row(
                    Modifier.gap(8.px)
                ) {
                    Box(
                        Modifier
                            .size(12.px)
                            .borderRadius(50.percent)
                            .background(Color("#ff5f56"))
                    )
                    Box(
                        Modifier
                            .size(12.px)
                            .borderRadius(50.percent)
                            .background(Color("#ffbd2e"))
                    )
                    Box(
                        Modifier
                            .size(12.px)
                            .borderRadius(50.percent)
                            .background(Color("#27c93f"))
                    )
                }
                SpanText(
                    "MainActivity.kt",
                    Modifier
                        .styleModifier {
                    property("margin-left", "auto")
                }
                        .fontSize(0.9.cssRem)
                        .color(Color("#666666"))
                )
            }
            
            // 코드 내용
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(30.px)
                    .background(Color("#0a0a0a"))
                    .borderRadius(bottomLeft = 8.px, bottomRight = 8.px)
                    .styleModifier {
                        property("font-family", "'JetBrains Mono', monospace")
                        property("box-shadow", "0 20px 60px rgba(0, 0, 0, 0.8), 0 0 100px rgba(0, 255, 255, 0.1)")
                        property("border", "1px solid #1a1a1a")
                        property("border-top", "none")
                    }
            ) {
                Pre {
                    Code {
                        Div {
                            // 구문 강조 코드
                            SpanText("class ", Modifier.color(Color("#ff79c6")))
                            SpanText("MainActivity", Modifier.color(Color("#50fa7b")))
                            SpanText(" : ", Modifier.color(Color("#ffffff")))
                            SpanText("ComponentActivity", Modifier.color(Color("#8be9fd")))
                            SpanText("() {\n", Modifier.color(Color("#ffffff")))
                            SpanText("    override fun ", Modifier.color(Color("#ff79c6")))
                            SpanText("onCreate", Modifier.color(Color("#50fa7b")))
                            SpanText("() {\n", Modifier.color(Color("#ffffff")))
                            SpanText("        setContent {\n", Modifier.color(Color("#ffffff")))
                            SpanText("            ", Modifier.color(Color("#ffffff")))
                            SpanText("MyApp", Modifier.color(Color("#8be9fd")))
                            SpanText(" {\n", Modifier.color(Color("#ffffff")))
                            SpanText("                ", Modifier.color(Color("#ffffff")))
                            SpanText("NavigationHost", Modifier.color(Color("#50fa7b")))
                            SpanText("()\n", Modifier.color(Color("#ffffff")))
                            SpanText("            }\n", Modifier.color(Color("#ffffff")))
                            SpanText("        }\n", Modifier.color(Color("#ffffff")))
                            SpanText("    }\n", Modifier.color(Color("#ffffff")))
                            SpanText("}", Modifier.color(Color("#ffffff")))
                        }
                    }
                }
            }
        }
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
                projectRow("01", "POIT", "AI 기반 음식 영양 정보 분석 앱", "KOTLIN / GPT API / Firebase Auth / Hilt")
                projectRow("02", "환율톡톡", "매일 오늘의 환율을 알려주는 환율 알리미 앱", "KMP / Koin / Admob / Clean Architecture")
                projectRow("03", "모노로그", "하루 한 줄 감정과 함께 기록하는 개인 일기장 앱", "Compose / Ktor / Firebase Auth")
                projectRow("04", "WorgleWorgle", "매일 새로운 단어를 추측하는 한국형 단어 게임 앱", "Kotlin / Compose")
                projectRow("05", "QR MINE", "QR 코드 생성 앱", "Kotlin / ZXING")
            }
        }
    }
}

@Composable
fun projectRow(number: String, title: String, description: String, tech: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .styleModifier {
                property("position", "relative")
                property("overflow", "hidden")
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
                    property("background", "linear-gradient(90deg, transparent 0%, rgba(0, 255, 255, 0.01) 50%, transparent 100%)")
                }
                .classNames("project-row")
,
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
                contactItem("EMAIL", "gayoung990911@gmail.com")
                contactItem("GITHUB", "github.com/gay00ung")
                contactItem("LINKEDIN", "linkedin.com/in/가영-신-5118552b2/")
            }
        }
    }
}

@Composable
fun contactItem(label: String, value: String) {
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