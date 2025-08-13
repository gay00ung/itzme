package net.ifmain.itzme.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*

@Composable
fun PageLayout(
    currentSection: Int,
    content: @Composable () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color("#000000"))
            .styleModifier {
                property("font-family", "'JetBrains Mono', 'Courier New', monospace")
            }
    ) {
        // 상단 네비게이션 바
        TopNavBar(currentSection)

        // 메인 콘텐츠
        Box(
            Modifier
                .fillMaxSize()
                .padding(top = 80.px)
                .styleModifier {
                    property("@media (max-width: 768px)", """
                        padding-top: 60px;
                    """)
                }
        ) {
            content()
        }
    }
}

@Composable
fun TopNavBar(currentSection: Int) {
    Row(
        Modifier
            .position(Position.Fixed)
            .top(0.px)
            .fillMaxWidth()
            .height(80.px)
            .background(Color("#000000"))
            .borderBottom(1.px, LineStyle.Solid, Color("#00ffff"))
            .padding(0.px, 60.px)
            .zIndex(1000)
            .styleModifier {
                property("@media (max-width: 768px)", """
                    padding: 0 20px;
                    height: 60px;
                """)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 로고
        Link(
            path = "/",
            Modifier.styleModifier {
                property("text-decoration", "none")
            }
        ) {
            SpanText(
                "Hello! I'm Gayoung!",
                Modifier
                    .fontSize(1.5.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .styleModifier {
                        property("color", "#00ffff")
                        property("letter-spacing", "4px")
                        property("@media (max-width: 768px)", """
                            font-size: 0.9rem;
                            letter-spacing: 1px;
                        """)
                        property("@media (max-width: 640px)", """
                            font-size: 0.8rem;
                            letter-spacing: 0px;
                        """)
                    }
            )
        }

        // 네비게이션 아이템
        Row(
            Modifier
                .styleModifier {
                    property("margin-left", "auto")
                    property("gap", "60px")
                    property("@media (max-width: 1024px)", """
                        gap: 30px;
                    """)
                    property("@media (max-width: 768px)", """
                        gap: 15px;
                    """)
                    property("@media (max-width: 640px)", """
                        gap: 10px;
                    """)
                }
        ) {
            NavItem("HOME", "/", currentSection == 0)
            NavItem("ABOUT", "/about", currentSection == 1)
            NavItem("WORK", "/work", currentSection == 2)
            NavItem("CONTACT", "/contact", currentSection == 3)
        }
    }
}

@Composable
fun NavItem(title: String, path: String, isActive: Boolean) {
    Link(
        path = path,
        Modifier
            .styleModifier {
                property("text-decoration", "none")
            }
    ) {
        Box(
            Modifier
                .cursor(Cursor.Pointer)
                .padding(10.px, 20.px)
                .styleModifier {
                    property("position", "relative")
                    property("transition", "all 0.3s ease")
                    property("font-weight", "500")
                    property("letter-spacing", "2px")
                    property("font-size", "0.9rem")
                    property("user-select", "none")
                    property("@media (max-width: 768px)", """
                        padding: 5px 8px;
                        font-size: 0.7rem;
                        letter-spacing: 0.5px;
                    """)
                    property("@media (max-width: 640px)", """
                        padding: 4px 6px;
                        font-size: 0.65rem;
                        letter-spacing: 0px;
                    """)
                    if (isActive) {
                        property("color", "#00ffff")
                    } else {
                        property("color", "#666666")
                    }
                    property("cursor", "pointer")
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
}