package dev.oluni.unideath

class ConfigManager(val plugin: UniDeath) {
    val config
        get() = plugin.config

    val instantRespawnEnabled: Boolean
        get() = config.getBoolean("instant-respawn", true)

    val usageMessage: String
        get() = config.getString("messages.usage") ?: "&#FFA7D9UniDeath &7-> &cUsage: /unideath reload"
    val reloadSuccessfulMessage: String
        get() = config.getString("messages.successful-reload") ?: "&#FFA7D9UniDeath &7-> &aConfig reload successful!"
    val noPermissionMessage: String
        get() = config.getString("messages.no-permission") ?: "&#FFA7D9UniDeath &7-> &cYou don't have permission to do this!"

    fun reloadConfig() {
        plugin.reloadConfig()
    }
}