package api

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import model.Hardware

@OptIn(InternalAPI::class)
object BackendClient {

    val client = HttpClient(CIO)
    val gson = Gson()

    suspend fun getAllHardware(): List<Hardware> {
        val body = client.get("http://localhost:8081/hardware").body<String>()
        return gson.fromJson(body, Array<Hardware>::class.java).toList()
    }

    suspend fun postNewHardware(hardware: Hardware): Hardware {
        val body = client.post("http://localhost:8081/hardware") {
            contentType(ContentType.Application.Json)
            body = gson.toJson(hardware)
        }.body<String>()
        println(body)
        return gson.fromJson(body, Hardware::class.java)
    }

    suspend fun putNewHardware(hardware: Hardware): Hardware {
        val body = client.put("http://localhost:8081/hardware") {
            contentType(ContentType.Application.Json)
            body = gson.toJson(hardware)
        }.body<String>()
        println(body)
        return gson.fromJson(body, Hardware::class.java)
    }
}

