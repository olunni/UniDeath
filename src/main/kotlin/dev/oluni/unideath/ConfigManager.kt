package dev.oluni.unideath

class ConfigManager(val plugin: UniDeath) {
    val config
        get() = plugin.config

    val instantRespawnEnabled: Boolean
        get() = config.getBoolean("instant-respawn", true)
}