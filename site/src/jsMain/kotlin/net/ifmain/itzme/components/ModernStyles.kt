package net.ifmain.itzme.components

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.*

// Modern gradient background
val GradientBackgroundStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .minHeight(100.vh)
            .styleModifier {
                property("background", "linear-gradient(135deg, #667eea 0%, #764ba2 100%)")
                property("position", "relative")
            }
    }
}

// Glassmorphism card
val GlassCardStyle = CssStyle {
    base {
        Modifier
            .width(90.vw)
            .maxWidth(1000.px)
            .styleModifier {
                property("background", "rgba(255, 255, 255, 0.1)")
                property("backdrop-filter", "blur(10px)")
                property("-webkit-backdrop-filter", "blur(10px)")
                property("box-shadow", "0 8px 32px 0 rgba(31, 38, 135, 0.37)")
            }
            .borderRadius(20.px)
            .padding(3.em)
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.18))
    }
}

// Neon glow text
val NeonTextStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                property("background", "linear-gradient(45deg, #00ffff, #ff00ff)")
                property("-webkit-background-clip", "text")
                property("-webkit-text-fill-color", "transparent")
                property("background-clip", "text")
                property("filter", "drop-shadow(0 0 20px rgba(0, 255, 255, 0.5))")
            }
    }
}

// Modern skill card with gradient border
val ModernSkillStyle = CssStyle {
    base {
        Modifier
            .padding(2.em)
            .styleModifier {
                property("background", "linear-gradient(135deg, rgba(255,255,255,0.1) 0%, rgba(255,255,255,0.05) 100%)")
                property("backdrop-filter", "blur(10px)")
                property("box-shadow", "0 8px 32px 0 rgba(31, 38, 135, 0.2)")
                property("position", "relative")
                property("overflow", "hidden")
            }
            .borderRadius(20.px)
            .cursor(Cursor.Pointer)
    }
    
    hover {
        Modifier
            .styleModifier {
                property("transform", "translateY(-10px) scale(1.02)")
                property("box-shadow", "0 15px 40px 0 rgba(31, 38, 135, 0.4)")
            }
    }
}

// Floating animation
val FloatAnimation = Keyframes {
    from { 
        Modifier.transform { translateY(0.px) }
    }
    50.percent { 
        Modifier.transform { translateY((-30).px) }
    }
    to { 
        Modifier.transform { translateY(0.px) }
    }
}

// Pulse animation for buttons
val PulseAnimation = Keyframes {
    from {
        Modifier.styleModifier {
            property("box-shadow", "0 0 0 0 rgba(0, 255, 255, 0.7)")
        }
    }
    70.percent {
        Modifier.styleModifier {
            property("box-shadow", "0 0 0 10px rgba(0, 255, 255, 0)")
        }
    }
    to {
        Modifier.styleModifier {
            property("box-shadow", "0 0 0 0 rgba(0, 255, 255, 0)")
        }
    }
}

// Modern button style
val ModernButtonStyle = CssStyle {
    base {
        Modifier
            .padding(1.2.em, 2.5.em)
            .styleModifier {
                property("background", "linear-gradient(45deg, #667eea 0%, #764ba2 100%)")
                property("box-shadow", "0 4px 15px 0 rgba(118, 75, 162, 0.4)")
                property("position", "relative")
                property("overflow", "hidden")
                property("transition", "all 0.3s ease")
            }
            .borderRadius(50.px)
            .color(Colors.White)
            .fontWeight(FontWeight.Bold)
            .fontSize(1.1.em)
            .cursor(Cursor.Pointer)
            .border(0.px, LineStyle.None, Colors.Transparent)
    }
    
    hover {
        Modifier
            .styleModifier {
                property("transform", "translateY(-2px)")
                property("box-shadow", "0 6px 20px 0 rgba(118, 75, 162, 0.6)")
            }
    }
}

// Project card with modern design
val ModernProjectCard = CssStyle {
    base {
        Modifier
            .styleModifier {
                property("background", "linear-gradient(135deg, rgba(255,255,255,0.1) 0%, rgba(255,255,255,0.05) 100%)")
                property("backdrop-filter", "blur(10px)")
                property("box-shadow", "0 8px 32px 0 rgba(31, 38, 135, 0.15)")
                property("transition", "all 0.3s cubic-bezier(0.4, 0, 0.2, 1)")
                property("position", "relative")
                property("overflow", "hidden")
            }
            .padding(2.5.em)
            .borderRadius(24.px)
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.1))
            .cursor(Cursor.Pointer)
    }
    
    hover {
        Modifier
            .styleModifier {
                property("transform", "translateY(-8px) scale(1.01)")
                property("box-shadow", "0 20px 50px 0 rgba(31, 38, 135, 0.3)")
                property("border-color", "rgba(255, 255, 255, 0.2)")
            }
    }
}

// Profile image with gradient border
val ModernProfileImage = CssStyle {
    base {
        Modifier
            .size(200.px)
            .borderRadius(50.percent)
            .styleModifier {
                property("background", "linear-gradient(45deg, #667eea, #764ba2)")
                property("padding", "4px")
                property("position", "relative")
                property("box-shadow", "0 10px 40px rgba(118, 75, 162, 0.4)")
            }
    }
    
    hover {
        Modifier
            .styleModifier {
                property("transform", "scale(1.05) rotate(5deg)")
                property("box-shadow", "0 15px 50px rgba(118, 75, 162, 0.6)")
            }
    }
}

// Contact button with glow effect
val GlowButtonStyle = CssStyle {
    base {
        Modifier
            .padding(1.em, 2.em)
            .styleModifier {
                property("background", "transparent")
                property("border", "2px solid transparent")
                property("background-image", "linear-gradient(#0a0a0a, #0a0a0a), linear-gradient(45deg, #00ffff, #ff00ff)")
                property("background-origin", "border-box")
                property("background-clip", "content-box, border-box")
                property("transition", "all 0.3s ease")
            }
            .borderRadius(50.px)
            .color(Colors.White)
            .fontWeight(FontWeight.Medium)
            .cursor(Cursor.Pointer)
    }
    
    hover {
        Modifier
            .styleModifier {
                property("transform", "scale(1.05)")
                property("filter", "drop-shadow(0 0 20px rgba(0, 255, 255, 0.5))")
            }
    }
}