package me.lekseg.iplocation.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IpInfoResponse(
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("city")
    val city: String,
    @SerialName("state")
    val state: String,
    @SerialName("postal")
    val postal: String,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("IPv4")
    val ipv4: String,
)