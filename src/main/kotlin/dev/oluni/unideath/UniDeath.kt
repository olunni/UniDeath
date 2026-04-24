package dev.oluni.unideath

import org.bukkit.plugin.java.JavaPlugin

class UniDeath : JavaPlugin() {

    override fun onEnable() {
        saveDefaultConfig()
        logger.info("UniDeath enabled.")
        val configManager = ConfigManager(this)
        server.pluginManager.registerEvents(DeathListener(this, configManager), this)
    }

    override fun onDisable() {
        logger.info("UniDeath disabled.")
    }
}