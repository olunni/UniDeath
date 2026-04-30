package dev.oluni.unideath

import org.bukkit.GameMode
import org.bukkit.Sound
import org.bukkit.configuration.ConfigurationSection

class ConfigManager(val plugin: UniDeath) {
    val config
        get() = plugin.config

    val instantRespawnEnabled: Boolean
        get() = config.getBoolean("instant-respawn", true)
    val keepLevel: Boolean
        get() = config.getBoolean("keep-level", false)
    val disableDeathMessage: Boolean
        get() = config.getBoolean("disable-death-message", false)
    val title: String
        get() = config.getString("title.title") ?: "&aRespawn!"
    val subTitle: String
        get() = config.getString("title.subtitle") ?: ""
    val titleFadeIn: Int
        get() = config.getInt("title.fadeIn")
    val titleStay: Int
        get() = config.getInt("title.stay")
    val titleFadeOut: Int
        get() = config.getInt("title.fadeOut")
    val gamemodeAfterRespawn: GameMode
        get() = GameMode.valueOf(config.getString("gamemode-after-respawn")?.uppercase() ?: "SURVIVAL")
    val actionBar: String
        get() = config.getString("actionbar") ?: ""
    val chatMessages: List<String>
        get() = config.getStringList("chat")
    val soundEnabled: Boolean
        get() = config.getBoolean("sound.enabled", false)
    val soundType: Sound?
        get() = config.getString("sound.type")?.let {
            runCatching { Sound.valueOf(it) }.getOrNull()
        }
    val soundVolume: Float
        get() = config.getDouble("sound.volume").toFloat()
    val soundPitch: Float
        get() = config.getDouble("sound.pitch").toFloat()
    val effectList: ConfigurationSection?
        get() = config.getConfigurationSection("effect")
    val commandsEnabled: Boolean
        get() = config.getBoolean("commands.enabled", true)
    val commandsList: List<String>
        get() = config.getStringList("commands.list")

    val usageMessage: String
        get() = config.getString("messages.usage") ?: "&#FFA7D9UniDeath &7-> &cUsage: /unideath reload"
    val reloadSuccessfulMessage: String
        get() = config.getString("messages.successful-reload") ?: "&#FFA7D9UniDeath &7-> &aConfig reload successful!"
    val noPermissionMessage: String
        get() = config.getString("messages.no-permission")
            ?: "&#FFA7D9UniDeath &7-> &cYou don't have permission to do this!"

    fun reloadConfig() {
        plugin.reloadConfig()
    }
}