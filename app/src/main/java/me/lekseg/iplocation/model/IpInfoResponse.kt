package me.lekseg.iplocation.model

import kotlinx.serialization.SerialName

data class IpInfoResponse(
    @SerialName("latitude")
    val latitude: Double?,
    @SerialName("longitude")
    val longitude: Double?,
)