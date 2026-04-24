package dev.oluni.unideath

import net.md_5.bungee.api.ChatColor
import org.bukkit.command.CommandSender

fun CommandSender.sendColoredMessage(message: String) {
    val pattern = Regex("&#([a-fA-F0-9]{6})")
    val hexTranslated = pattern.replace(message) { match ->
        val hex = match.groupValues[1]
        "§x§${hex[0]}§${hex[1]}§${hex[2]}§${hex[3]}§${hex[4]}§${hex[5]}"
    }
    sendMessage(ChatColor.translateAlternateColorCodes('&', hexTranslated))
}