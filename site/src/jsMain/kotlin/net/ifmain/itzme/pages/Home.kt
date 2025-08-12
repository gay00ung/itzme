package net.ifmain.itzme.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import net.ifmain.itzme.components.PageLayout
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

@Composable
fun HomePage() {
    PageLayout(currentSection = 0) {
        heroSection()
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