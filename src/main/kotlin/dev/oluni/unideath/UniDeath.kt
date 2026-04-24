package dev.oluni.unideath

import org.bukkit.plugin.java.JavaPlugin

class UniDeath : JavaPlugin() {

    override fun onEnable() {
        logger.info("UniDeath enabled.")
    }

    override fun onDisable() {
        logger.info("UniDeath disabled.")
    }
}