package me.lekseg.iplocation.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import me.lekseg.iplocation.model.IpInfoResponse

class ApiServiceImpl(
    private val client: HttpClient,
    private val apiKey: String,
) : ApiService {
    @Suppress("JSON_FORMAT_REDUNDANT")
    override suspend fun getIpInfo(): ResultWrapper<IpInfoResponse> {
        return try {
            val response = client.get("${Routes.BY_IP}/${apiKey}")
            val body = Json {
                ignoreUnknownKeys = true
            }.decodeFromString<IpInfoResponse>(response.body<String>())
            ResultWrapper.Success(body)
        } catch (e: Exception) {
            ResultWrapper.Error("${e.message}")
        }
    }
}