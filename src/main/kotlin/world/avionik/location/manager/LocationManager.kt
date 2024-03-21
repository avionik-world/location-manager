package world.avionik.location.manager

import org.bukkit.Location
import world.avionik.configkit.MultipleConfigLoader
import world.avionik.location.manager.config.LocationConfig

/**
 * @author Niklas Nieberler
 */

class LocationManager(
    private val configLoader: MultipleConfigLoader<LocationConfig>
) {

    private val cachedLocations = configLoader.loadAll().toMutableList()

    /**
     * Sets the location in a file
     * @param name of the location
     * @param location to set in the file
     */
    fun setLocation(name: String, location: Location) {
        val locationConfig = LocationConfig.fromLocation(name, location)
        this.configLoader.save(locationConfig)
        this.cachedLocations.add(locationConfig)
    }

    /**
     * Gets the location by name
     * @param name of the location
     * @return [Location] by this name
     */
    fun getLocation(name: String): Location? {
        return this.cachedLocations.firstOrNull { it.getName() == name }?.toLocation()
    }

    /**
     * Gets list of all locations
     * @return list of [LocationNameable]
     */
    fun getLocations(): List<LocationNameable> {
        return this.cachedLocations.map { LocationNameable(it.getName(), it.toLocation()) }
    }

}