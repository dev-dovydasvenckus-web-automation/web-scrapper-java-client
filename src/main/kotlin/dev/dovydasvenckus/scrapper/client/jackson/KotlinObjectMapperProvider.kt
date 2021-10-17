package dev.dovydasvenckus.scrapper.client.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider
import com.fasterxml.jackson.module.kotlin.KotlinModule
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider


@Provider
@Produces(MediaType.APPLICATION_JSON)
class KotlinObjectMapperProvider : JacksonJaxbJsonProvider() {
    private val mapper = ObjectMapper()

    init {
        mapper.registerModule(KotlinModule())
        setMapper(mapper)
    }

}