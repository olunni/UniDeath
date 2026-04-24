package dev.oluni.unideath

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class DeathCommand(val config: ConfigManager) : CommandExecutor, TabCompleter {

    val mm = MiniMessage.miniMessage()

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?)
    : Boolean {
        if (args.isNullOrEmpty()) {
            sender.sendMessage(mm.deserialize(config.usageMessage))
            return true
        }
        if (args[0].equals("reload", true)) {
            if (sender.hasPermission("unideath.reload")) {
                config.reloadConfig()
                sender.sendMessage(mm.deserialize(config.reloadSuccessfulMessage))
            } else {
                sender.sendMessage(mm.deserialize(config.noPermissionMessage))
                return true
            }
        }
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String> {
        if (args.size == 1) {
            return listOf("reload")
        }
        return emptyList()
    }
}