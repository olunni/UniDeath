package dev.oluni.unideath

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class DeathListener(val plugin: UniDeath, val config: ConfigManager) : Listener {

    @EventHandler
    fun onDeath(event: PlayerDeathEvent) {
        when {
            config.instantRespawnEnabled -> {
                plugin.server.scheduler.runTaskLater(plugin, Runnable {
                    event.entity.spigot().respawn()
                }, 1L)
            }
        }
    }
}