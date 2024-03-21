package world.avionik.location.manager.config

import kotlinx.serialization.Serializable
import org.bukkit.Bukkit
import org.bukkit.Location
import world.avionik.configkit.Nameable

/**
 * @author Niklas Nieberler
 */

@Serializable
class LocationConfig(
    private val name: String,
    private val x: Double,
    private val y: Double,
    private val z: Double,
    private val yaw: Float,
    private val pitch: Float,
    private val worldName: String
) : Nameable {

    override fun getName(): String = this.name

    /**
     * Converts the config location to a minecraft location
     * @return new location instance
     */
    fun toLocation(): Location {
        return Location(
            Bukkit.getWorld(this.worldName)!!,
            this.x,
            this.y,
            this.z,
            this.yaw,
            this.pitch
        )
    }

    companion object {
        fun fromLocation(name: String, location: Location): LocationConfig {
            return LocationConfig(
                name,
                location.x,
                location.y,
                location.z,
                location.yaw,
                location.pitch,
                location.world.name
            )
        }
    }

}