# Location Manager
With the NettyKit it is easy to create a NettyServer and a NettyClient. It is important to note that this project requires the client server API.

## Using the Location Manager in your plugin

### Maven
```xml
<dependencies>
 <dependency>
    <groupId>world.avionik</groupId>
    <artifactId>location-manager</artifactId>
    <version>1.0.1</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

### Gradle
```groovy
dependencies {
    compileOnly 'world.avionik:location-manager:1.0.1'
}
```

## How to use the Location Manager
To use the [LocationManager](https://github.com/avionik-world/location-manager/blob/master/src/main/kotlin/world/avionik/location/manager/LocationManager.kt). You simply need to use the [LocationFactory](https://github.com/avionik-world/location-manager/blob/master/src/main/kotlin/world/avionik/location/manager/LocationFactory.kt). Here is a small example of how this works:

``` kotlin
val locationManager = LocationFactory.create("plugins/locations/") // "plugins/locations/" is the path for the folder where the files are stored

// And this is how you can add a new location to a file
locationManager.setLocation("location-name", location) // location-name" is the name of a location

// This allows you to get the location of a file. 
val location = locationManager.getLocation("location-name") // "location-name" is the name of a location

// And this is how you get all saved locations
locationManager.getLocations().forEach {
    println("name: ${it.name}")
    println("locations: ${it.location}")
}
```
