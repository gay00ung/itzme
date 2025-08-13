package net.ifmain.itzme

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

@InitSilk
fun initStyles(ctx: InitSilkContext) {
    // viewport 메타 태그 추가
    val viewport = document.createElement("meta")
    viewport.setAttribute("name", "viewport")
    viewport.setAttribute("content", "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")
    document.head?.appendChild(viewport)
    
    ctx.stylesheet.registerStyleBase("html, body") { 
        Modifier.fillMaxHeight()
            .background(Color("#0f0f23"))
            .margin(0.px)
            .padding(0.px)
            .styleModifier {
                property("overflow-x", "hidden")
                property("box-sizing", "border-box")
            }
    }
    
    ctx.stylesheet.registerStyleBase("*") {
        Modifier.styleModifier {
            property("box-sizing", "border-box")
        }
    }
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        content()
    }
}
