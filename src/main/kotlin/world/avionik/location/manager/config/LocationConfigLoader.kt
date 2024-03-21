package world.avionik.location.manager.config

import world.avionik.configkit.MultipleConfigLoader
import world.avionik.configkit.format.YamlFileFormatter
import java.io.File

/**
 * @author Niklas Nieberler
 */

class LocationConfigLoader(
    path: String,
) : MultipleConfigLoader<LocationConfig>(
    File(path),
    YamlFileFormatter(
        LocationConfig.serializer()
    )
)