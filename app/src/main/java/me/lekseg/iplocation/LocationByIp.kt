package me.lekseg.iplocation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import me.lekseg.iplocation.api.ApiServiceImpl
import me.lekseg.iplocation.api.HttpClient
import me.lekseg.iplocation.api.ResultWrapper
import me.lekseg.iplocation.listener.IpLocationListener

class LocationByIp(apiKey: String) {

    private val apiService = ApiServiceImpl(
        client = HttpClient.client, apiKey = apiKey
    )

    fun getIpInfo(ipLocationListener: IpLocationListener) {
        MainScope().launch(Dispatchers.Main) {
            when (val result = apiService.getIpInfo()) {
                is ResultWrapper.Loading -> {
                    ipLocationListener.onLoad()
                }

                is ResultWrapper.Error -> {
                    ipLocationListener.onError(errorCode = 0)
                }

                is ResultWrapper.Success -> {
                    ipLocationListener.onSuccess(
                        latitude = result.data?.latitude, longitude = result.data?.longitude
                    )
                }
            }
        }
    }

}