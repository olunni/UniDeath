package dev.oluni.unideath

class ConfigManager(val plugin: UniDeath) {
    val config
        get() = plugin.config

    val instantRespawnEnabled: Boolean
        get() = config.getBoolean("instant-respawn", true)

    val usageMessage: String
        get() = config.getString("messages.usage") ?: "<gradient:#FFA7D9:#FFA7D9>UniDeath</gradient> <gray>-> <red>Usage: /unideath reload"
    val reloadSuccessfulMessage: String
        get() = config.getString("messages.successful-reload") ?: "<gradient:#FFA7D9:#FFA7D9>UniDeath</gradient> <gray>-> <green>Config reload successful!</green>"
    val noPermissionMessage: String
        get() = config.getString("messages.successful-reload") ?: "<gradient:#FFA7D9:#FFA7D9>UniDeath</gradient> <gray>-> <red>You don't have permission to do this!"

    fun reloadConfig() {
        plugin.reloadConfig()
    }
}