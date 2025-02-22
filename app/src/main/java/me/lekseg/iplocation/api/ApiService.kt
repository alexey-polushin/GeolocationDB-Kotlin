package me.lekseg.iplocation.api

import me.lekseg.iplocation.model.IpInfoResponse

interface ApiService {
    suspend fun getIpInfo(): ResultWrapper<IpInfoResponse>
}