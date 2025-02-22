package me.lekseg.iplocation.listener

interface IpLocationListener {
    fun onLoad()
    fun onSuccess(latitude: Double?, longitude: Double?)
    fun onError(message: String? = null, errorCode: Int)
}