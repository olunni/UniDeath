package dev.oluni.unideath

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class DeathListener(val plugin: UniDeath, val config: ConfigManager) : Listener {

    @EventHandler
    fun onDeath(event: PlayerDeathEvent) {
        if (config.instantRespawnEnabled) {
            plugin.server.scheduler.runTaskLater(plugin, Runnable { event.entity.spigot().respawn() }, 1L)
        }
        if (config.keepLevel) {
            event.keepLevel = true
        }
        if (config.disableDeathMessage) {
            event.deathMessage(Component.empty())
        }
    }

    @EventHandler
    fun onRespawn(event: PlayerRespawnEvent) {
        val player = event.player
        with(player) {
            sendTitle(
                config.title.colorize(),
                config.subTitle.colorize(),
                config.titleFadeIn,
                config.titleStay,
                config.titleFadeOut
            )
            gameMode = config.gamemodeAfterRespawn
            sendActionBar(Component.text(config.actionBar.colorize()))
            config.chatMessages.forEach { message ->
                sendMessage(
                    message.colorize()
                        .replace("%player%", player.name)
                )
            }
            if (config.soundEnabled && config.soundType != null) {
                player.playSound(
                    player.location,
                    config.soundType!!,
                    config.soundVolume,
                    config.soundPitch
                )
            }
            val effects = config.effectList?.let { section ->
                section.getKeys(false).mapNotNull { key ->
                    val type =
                        PotionEffectType.getByName(section.getString("$key.type") ?: "") ?: return@mapNotNull null
                    val duration = section.getInt("$key.duration") * 20
                    val level = section.getInt("$key.level") - 1
                    PotionEffect(type, duration, level)
                }
            } ?: emptyList()
            player.addPotionEffects(effects)
            if (config.commandsEnabled) {
                config.commandsList.forEach { command ->
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.name))
                }
            }
        }
    }
}