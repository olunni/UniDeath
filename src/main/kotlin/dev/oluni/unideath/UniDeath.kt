package dev.oluni.unideath

import org.bukkit.plugin.java.JavaPlugin

class UniDeath : JavaPlugin() {

    override fun onEnable() {
        saveDefaultConfig()
        logger.info("UniDeath enabled.")
        val configManager = ConfigManager(this)
        val deathCommand = DeathCommand(configManager)
        server.pluginManager.registerEvents(DeathListener(this, configManager), this)
        getCommand("unideath")?.setExecutor(deathCommand)
        getCommand("unideath")?.tabCompleter = deathCommand
    }

    override fun onDisable() {
        logger.info("UniDeath disabled.")
    }
}