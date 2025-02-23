# Geolocation From IP Kotlin Library

[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://opensource.org/licenses/MIT)  

**A lightweight Kotlin Library for [Geolocation DB API](https://geolocation-db.com/documentation) Integration in Android**

---

## Overview

A Kotlin library for Android that provides a simple and convenient way to retrieve user geolocation data using the [geolocation-db.com](https://geolocation-db.com/) API.

---

## Features

- Free to use, you only need a api key
- Fetches geolocation data (country, region, city, coordinates) via IP.
- Asynchronous requests with [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html).
- Easy Gradle-based integration in Android Studio.
- Minimal dependencies for a small size.

---

## API Key
To use this library, you need to obtain an **API key** from the [geolocation-db.com](https://geolocation-db.com/) website. Follow these steps:

1. Visit [geolocation-db.com](https://geolocation-db.com/).
2. Sign up for an account (if you don’t have one).
3. Generate an API key from your account dashboard.
4. Use the API key in your application to authenticate requests.

---

## Installation
Add the dependency to your `build.gradle` file:

    dependencies {
        implementation 'io.github.alexey-polushin:geolocation-db-kotlin:1.0.3'
    }

---

## Usage

### Initialization
Create an instance of the `LocationByIp` class and provide your API key:

    val locationByIp = LocationByIp(apiKey = "YOUR_API_KEY_HERE")

### Fetching Location Data
Use the `getIpInfo()` method to retrieve location data:

    locationByIp.getIpInfo(object : IpLocationListener {

        override fun onLoad() { }

        override fun onSuccess(ipInfoResponse: IpInfoResponse) { }

        override fun onError(message: String?) { }
                        
    })

### Response Example
The response is returned as a `IpInfoResponse` object:

    data class IpInfoResponse(
        val countryCode: String,
        val countryName: String,
        val city: String,
        val postal: String,
        val latitude: Double,
        val longitude: Double,
        val IPv4: String,
        val state: String
    )

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.