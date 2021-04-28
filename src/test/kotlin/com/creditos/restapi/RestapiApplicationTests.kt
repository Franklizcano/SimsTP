package com.creditos.restapi

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.creditos.restapi.model.Persona
import com.creditos.restapi.model.Libro
import com.creditos.restapi.dao.PersonaRepository
import com.creditos.restapi.dao.LibroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component

@SpringBootTest
class RestapiApplicationTests {

	@Autowired
	private lateinit var personaRepository: PersonaRepository

	fun save() {
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val persona1 = Persona(
				38333444, "Daniel", "Gutierrez", "La Plata",
				listOf(Libro("Mapamundi", "Creador")),
				LocalDate.parse("25-06-1999", formatter)
			)
		personaRepository.save(persona1)
	}
}
