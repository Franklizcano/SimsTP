package com.creditos.restapi

import com.creditos.restapi.dao.PersonaRepository
import com.creditos.restapi.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class RestapiApplication:CommandLineRunner{

	@Autowired
	val personaRepository: PersonaRepository? = null

	override fun run(vararg args: String?) {

		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val persona1 = Persona(38333444,"Daniel", "Gutierrez", LocalDate.parse("25-06-1999", formatter), "Buenos Aires")

		personaRepository!!.save(persona1)
	}
}

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)
}
