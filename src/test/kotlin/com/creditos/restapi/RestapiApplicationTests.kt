package com.creditos.restapi

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.creditos.restapi.model.Persona
import com.creditos.restapi.model.Libro
import com.creditos.restapi.dao.PersonaRepository
import com.creditos.restapi.dao.LibroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.stereotype.Component

@Component
class RestapiApplicationTests {

	@Autowired
	private lateinit var personaRepository: PersonaRepository

	@Autowired
	private lateinit var libroRepository: LibroRepository

	fun save(): String {
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val persona1 =
			Persona(38333444, "Daniel", "Gutierrez", LocalDate.parse("25-06-1999", formatter), "Buenos Aires")
		personaRepository.save(persona1)

		val libro = Libro("Principito", "El creador")
		libroRepository.save(libro)
		return "Se crearon perfectamente los datos"
	}
}
