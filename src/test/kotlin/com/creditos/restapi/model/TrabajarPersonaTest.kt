package com.creditos.restapi.model

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlinx.coroutines.runBlocking
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootTest
class TrabajarPersonaTest {

    @Autowired
    private lateinit var tipoProfesionStrategy: TipoProfesionStrategy

    @Test
    fun testProfesion() {

        runBlocking {
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val libros = listOf(Libro("Mapamundi",
                "Creador",
                "historia",
                4000,
                4,
                TipoLibroEnum.VIRTUAL))

            val persona = Persona(
                38333444,
                "Daniel",
                "Gutierrez",
                libros,
                TipoProfesionEnum.Policia,
                2000,
                LocalDate.parse("25-06-1999", formatter))

            tipoProfesionStrategy.trabajar(persona)
            println("${persona.nombre} está trabajando como ${persona.profesion}")

            val persona2 = persona.copy(profesion = TipoProfesionEnum.Medico)
            tipoProfesionStrategy.trabajar(persona2)
            println("${persona2.nombre} está trabajando como ${persona2.profesion}")

            val persona3 = persona.copy(profesion = TipoProfesionEnum.Ingeniero)
            tipoProfesionStrategy.trabajar(persona3)
            println("${persona3.nombre} está trabajando como ${persona3.profesion}")
        }
    }

}