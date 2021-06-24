package com.creditos.restapi.model

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlinx.coroutines.runBlocking
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootTest
class trabajarPersonaTest {

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
                "La Plata",
                libros,
                TipoProfesionEnum.Policia,
                LocalDate.parse("25-06-1999", formatter))

            tipoProfesionStrategy.trabajar(persona.profesion)
            println("-------")

            val persona2 = persona.copy(38333444,
            "Daniel",
            "Gutierrez",
            "La Plata",
            libros,
            TipoProfesionEnum.Medico,
            LocalDate.parse("25-06-1999", formatter))
            tipoProfesionStrategy.trabajar(persona2.profesion)
            println("-------")
            val persona3 = persona.copy(38333444,
                "Daniel",
                "Gutierrez",
                "La Plata",
                libros,
                TipoProfesionEnum.Ingeniero,
                LocalDate.parse("25-06-1999", formatter))
            tipoProfesionStrategy.trabajar(persona3.profesion)
        }
    }

}