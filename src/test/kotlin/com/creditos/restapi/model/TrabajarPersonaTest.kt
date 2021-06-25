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
                500,
                libros,
                TipoProfesionEnum.Policia,
                LocalDate.parse("25-06-1999", formatter))

            tipoProfesionStrategy.trabajar(persona, persona.profesion)
            println("-------")

            val persona2 = persona.copy(38333444,
            "Daniel",
            "Gutierrez",
            1000,
            libros,
            TipoProfesionEnum.Medico,
            LocalDate.parse("25-06-1999", formatter))
            tipoProfesionStrategy.trabajar(persona, persona2.profesion)
            println("-------")
            val persona3 = persona.copy(38333444,
                "Daniel",
                "Gutierrez",
                700,
                libros,
                TipoProfesionEnum.Ingeniero,
                LocalDate.parse("25-06-1999", formatter))
            tipoProfesionStrategy.trabajar(persona, persona3.profesion)
        }
    }

}