package dev.oluni.unideath

import net.md_5.bungee.api.ChatColor

fun String.colorize(): String {
    val pattern = Regex("&#([a-fA-F0-9]{6})")
    val hexTranslated = pattern.replace(this) { match ->
        val hex = match.groupValues[1]
        "§x§${hex[0]}§${hex[1]}§${hex[2]}§${hex[3]}§${hex[4]}§${hex[5]}"
    }
    return ChatColor.translateAlternateColorCodes('&', hexTranslated)
}