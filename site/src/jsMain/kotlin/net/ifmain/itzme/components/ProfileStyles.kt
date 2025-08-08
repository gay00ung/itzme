package net.ifmain.itzme.components

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.*

val ProfileCardStyle = CssStyle {
    base {
        Modifier
            .width(90.vw)
            .maxWidth(900.px)
            .background(rgba(15, 15, 35, 0.9))
            .borderRadius(24.px)
            .padding(2.5.em)
            .border(2.px, LineStyle.Solid, rgba(139, 69, 255, 0.3))
    }
}

val SkillItemStyle = CssStyle {
    base {
        Modifier
            .padding(1.2.em)
            .background(rgba(255, 255, 255, 0.05))
            .borderRadius(16.px)
            .textAlign(TextAlign.Center)
            .cursor(Cursor.Pointer)
            .border(1.px, LineStyle.Solid, rgba(139, 69, 255, 0.3))
    }

    hover {
        Modifier
            .background(rgba(139, 69, 255, 0.2))
            .border(1.px, LineStyle.Solid, rgba(139, 69, 255, 0.8))
            .transform { translateY((-4).px) }
    }
}

val ContactItemStyle = CssStyle {
    base {
        Modifier
            .padding(0.8.em, 1.6.em)
            .background(rgba(255, 255, 255, 0.08))
            .borderRadius(30.px)
            .cursor(Cursor.Pointer)
            .border(1.px, LineStyle.Solid, rgba(100, 255, 218, 0.3))
    }

    hover {
        Modifier
            .background(rgba(100, 255, 218, 0.15))
            .border(1.px, LineStyle.Solid, rgba(100, 255, 218, 0.8))
            .transform { translateY((-3).px) }
    }
}

val ProfileImageStyle = CssStyle {
    base {
        Modifier
            .size(180.px)
            .borderRadius(50.percent)
            .background(Color("#8b45ff"))
            .margin(2.em, 0.px, 2.em, 0.px)
            .border(3.px, LineStyle.Solid, rgba(139, 69, 255, 0.5))
    }

    hover {
        Modifier
            .transform { scale(1.08) }
            .border(3.px, LineStyle.Solid, rgba(139, 69, 255, 1.0))
    }
}

val ResponsiveGridStyle = CssStyle {
    base {
        Modifier.gap(1.5.em).margin(bottom = 3.em)
    }
}