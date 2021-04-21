package com.creditos.restapi

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.creditos.restapi.model.Persona
import com.creditos.restapi.dao.PersonaRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RestapiApplicationTests {

	@Autowired
	private lateinit var personaRepository: PersonaRepository

	fun run(vararg args: String?) {

		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val persona1 = Persona(38333444,"Daniel", "Gutierrez", LocalDate.parse("25-06-1999", formatter), "Buenos Aires")

		personaRepository.save(persona1)
	}

}
