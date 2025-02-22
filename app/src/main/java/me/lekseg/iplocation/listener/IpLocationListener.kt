package me.lekseg.iplocation.listener

import me.lekseg.iplocation.model.IpInfoResponse

interface IpLocationListener {
    fun onLoad()
    fun onSuccess(ipInfoResponse: IpInfoResponse)
    fun onError(message: String? = null)
}