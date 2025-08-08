package net.ifmain.itzme.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.*

val FloatingParticleStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .size(4.px)
            .borderRadius(50.percent)
            .background(rgba(139, 69, 255, 0.6))
    }
}

@Composable
fun AnimatedBackground() {
    Box(
        Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .top(0.px)
            .left(0.px)
            .zIndex(-1)
    ) {
        // 여러 개의 떠다니는 파티클들
        repeat(20) { index ->
            Box(
                Modifier
                    .position(Position.Absolute)
                    .top((index * 5 + 10).percent)
                    .left((index * 3 + 5).percent)
                    .size((2 + index % 3).px)
                    .borderRadius(50.percent)
                    .background(
                        when (index % 3) {
                            0 -> rgba(139, 69, 255, 0.4)
                            1 -> rgba(100, 255, 218, 0.3)
                            else -> rgba(255, 255, 255, 0.2)
                        }
                    )
            )
        }
    }
}