package net.ifmain.itzme.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.coroutines.delay
import net.ifmain.itzme.components.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Page
@Composable
fun HomePage() {
    Box(
        Modifier
            .fillMaxSize()
            .minHeight(100.vh)
            .background(Color("#0f0f23"))
            .padding(2.em, 1.em),
        contentAlignment = Alignment.TopCenter
    ) {
        // 배경 파티클들
        repeat(15) { index ->
            var animationOffset by remember { mutableStateOf(0f) }
            
            LaunchedEffect(index) {
                while (true) {
                    animationOffset = if (animationOffset == 0f) -20f else 0f
                    delay((2000 + index * 100).toLong())
                }
            }
            
            Box(
                Modifier
                    .position(Position.Absolute)
                    .top((index * 7 + 5).percent)
                    .left((index * 6 + 3).percent)
                    .size((2 + index % 4).px)
                    .borderRadius(50.percent)
                    .background(
                        when (index % 3) {
                            0 -> rgba(139, 69, 255, 0.6)
                            1 -> rgba(100, 255, 218, 0.4)
                            else -> rgba(255, 255, 255, 0.3)
                        }
                    )
                    .transform { translateY(animationOffset.px) }
            )
        }
        
        // 메인 컨텐츠
        Column(
            ProfileCardStyle.toModifier().margin(1.em),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 프로필 이미지 (원형)
            Box(
                ProfileImageStyle.toModifier(),
                contentAlignment = Alignment.Center
            ) {
                FaUser(
                    Modifier
                        .fontSize(60.px)
                        .color(Colors.White)
                )
            }

            // 이름과 직책
            H1 {
                SpanText(
                    "신가영",
                    Modifier
                        .fontSize(3.2.em)
                        .fontWeight(FontWeight.Bold)
                        .color(Colors.White)
                        .margin(bottom = 0.3.em)
                )
            }

            H2 {
                SpanText(
                    "Android Developer",
                    Modifier
                        .fontSize(1.4.em)
                        .color(Color("#64ffda"))
                        .fontWeight(FontWeight.Medium)
                        .margin(bottom = 2.em)
                )
            }

            // 소개글
            Column(
                Modifier
                    .fontSize(1.2.em)
                    .lineHeight(1.8)
                    .color(rgba(255, 255, 255, 0.85))
                    .textAlign(TextAlign.Center)
                    .margin(bottom = 3.em),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpanText("🌱 Currently diving deep into Jetpack Compose & Coroutines", Modifier.margin(bottom = 0.8.em))
                SpanText("💡 Passionate about Clean Code and User Experience", Modifier.margin(bottom = 0.8.em))
                SpanText("🎯 Focus on creating practical and user-friendly Android apps")
            }

            // 스킬 섹션
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                H3 {
                    SpanText(
                        "Skills",
                        Modifier
                            .fontSize(1.8.em)
                            .fontWeight(FontWeight.Bold)
                            .color(Color("#8b45ff"))
                            .margin(bottom = 1.5.em)
                    )
                }

                SimpleGrid(
                    numColumns = numColumns(base = 2, md = 2),
                    ResponsiveGridStyle.toModifier()
                ) {
                    SkillItem("Kotlin", { FaCode() })
                    SkillItem("Java", { FaJava() })
                }
            }

            // 연락처 섹션
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                H3 {
                    SpanText(
                        "Connect with me",
                        Modifier
                            .fontSize(1.8.em)
                            .fontWeight(FontWeight.Bold)
                            .color(Color("#64ffda"))
                            .margin(bottom = 1.5.em)
                    )
                }

                Column(
                    Modifier.gap(1.em).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ContactItem({ FaEnvelope() }, "gayoung990911@gmail.com")
                    ContactItem({ FaGithub() }, "https://github.com/gay00ung")
                }
            }
        }
    }
}

@Composable
fun SkillItem(name: String, icon: @Composable () -> Unit) {
    Column(
        SkillItemStyle.toModifier(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier.margin(bottom = 0.8.em).fontSize(2.em).color(Color("#8b45ff"))
        ) {
            icon()
        }
        SpanText(
            name,
            Modifier
                .fontSize(1.em)
                .fontWeight(FontWeight.Medium)
                .color(Colors.White)
        )
    }
}

@Composable
fun ContactItem(icon: @Composable () -> Unit, text: String) {
    Row(
        ContactItemStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .margin(right = 0.8.em)
                .fontSize(1.4.em)
                .color(Color("#64ffda"))
        ) {
            icon()
        }
        SpanText(
            text,
            Modifier
                .fontSize(1.em)
                .fontWeight(FontWeight.Medium)
                .color(Colors.White)
        )
    }
}
