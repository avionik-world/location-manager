package world.avionik.location.manager

import world.avionik.location.manager.config.LocationConfigLoader

/**
 * @author Niklas Nieberler
 */

object LocationFactory {

    /**
     * Creates a new [LocationManager] instance.
     * @param path of the directory
     * @return new [LocationManager] instance.
     */
    fun create(path: String): LocationManager {
        val configLoader = LocationConfigLoader(path)
        return LocationManager(configLoader)
    }

}