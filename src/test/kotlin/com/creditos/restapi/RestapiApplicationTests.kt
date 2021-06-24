package com.creditos.restapi

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.creditos.restapi.model.Persona
import com.creditos.restapi.model.Libro
import com.creditos.restapi.dao.PersonaRepository
import com.creditos.restapi.model.TipoLibroEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RestapiApplicationTests {

	@Autowired
	private lateinit var personaRepository: PersonaRepository


	//@Test
	fun save() {
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val libros = listOf(Libro("Mapamundi",
				"Creador",
				"historia",
				4000,
				4,
				TipoLibroEnum.VIRTUAL))
		val persona1 = Persona(
				38333444,
				"Daniel",
				"Gutierrez",
				"La Plata",
				libros,
				LocalDate.parse("25-06-1999", formatter),

			)
		personaRepository.save(persona1)
	}
}
