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
            .background(rgba(18, 18, 18, 0.9))
            .borderRadius(20.px)
            .padding(3.em)
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.08))
    }
}

val SkillItemStyle = CssStyle {
    base {
        Modifier
            .padding(1.5.em)
            .background(rgba(255, 255, 255, 0.03))
            .borderRadius(12.px)
            .textAlign(TextAlign.Center)
            .cursor(Cursor.Pointer)
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.1))
    }

    hover {
        Modifier
            .background(rgba(100, 255, 218, 0.08))
            .border(1.px, LineStyle.Solid, rgba(100, 255, 218, 0.4))
            .transform { translateY((-4).px) }
    }
}

val ContactItemStyle = CssStyle {
    base {
        Modifier
            .padding(1.em, 2.em)
            .background(rgba(255, 255, 255, 0.05))
            .borderRadius(50.px)
            .cursor(Cursor.Pointer)
            .border(1.px, LineStyle.Solid, rgba(100, 255, 218, 0.2))
    }

    hover {
        Modifier
            .background(rgba(100, 255, 218, 0.1))
            .border(1.px, LineStyle.Solid, rgba(100, 255, 218, 0.5))
            .transform { scale(1.05) }
    }
}

val ProfileImageStyle = CssStyle {
    base {
        Modifier
            .size(180.px)
            .borderRadius(50.percent)
            .background(Color("#1e293b"))
            .margin(2.em, 0.px, 2.em, 0.px)
            .border(3.px, LineStyle.Solid, rgba(100, 255, 218, 0.3))
    }

    hover {
        Modifier
            .transform { scale(1.05) }
            .border(3.px, LineStyle.Solid, rgba(100, 255, 218, 0.8))
    }
}

val ResponsiveGridStyle = CssStyle {
    base {
        Modifier.gap(1.5.em).margin(bottom = 3.em)
    }
}

val ProjectCardStyle = CssStyle {
    base {
        Modifier
            .padding(2.em)
            .background(rgba(255, 255, 255, 0.03))
            .borderRadius(16.px)
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.1))
            .cursor(Cursor.Pointer)
    }

    hover {
        Modifier
            .background(rgba(100, 255, 218, 0.05))
            .border(1.px, LineStyle.Solid, rgba(100, 255, 218, 0.3))
            .transform { translateY((-5).px) }
    }
}