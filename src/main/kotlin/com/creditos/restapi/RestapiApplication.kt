package com.creditos.restapi

import com.creditos.restapi.dao.LibroRepository
import com.creditos.restapi.dao.PersonaRepository
import com.creditos.restapi.model.Libro
import com.creditos.restapi.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class RestapiApplication:CommandLineRunner {

	@Autowired
	private lateinit var personaRepository: PersonaRepository

	@Autowired
	private lateinit var libroRepository: LibroRepository


	override fun run(vararg args: String?) {

		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val defaultpersona = Persona(38333444,"Daniel", "Gutierrez", LocalDate.parse("25-06-1999", formatter), "Buenos Aires")

		personaRepository.save(defaultpersona)

		val defaultLibro = Libro(
			nombre = "Principito",
			autor = "El autor"
		)

		libroRepository.save(defaultLibro)
	}
}

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)
}
