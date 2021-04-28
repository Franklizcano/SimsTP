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

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)
}

@SpringBootApplication
class RestapiApplication:CommandLineRunner {

	@Autowired
	private lateinit var personaRepository: PersonaRepository
	@Autowired
	private lateinit var libroRepository: LibroRepository

	override fun run(vararg args: String?) {

		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val libros1 = listOf(
			Libro("Principito", "El autor"),
			Libro("Divina Comedia", "Dante Alighieri")
		)
		val defaultpersona = Persona(
			38333444,
			"Daniel",
			"Gutierrez",
			"Buenos Aires",
			libros1,
			LocalDate.parse("25-06-1999", formatter)
		)
		for (libro in libros1) {
			libroRepository.save(libro)
		}
		personaRepository.save(defaultpersona)
	}
}
