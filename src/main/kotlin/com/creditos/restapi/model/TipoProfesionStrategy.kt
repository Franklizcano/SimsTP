package com.creditos.restapi.model

import org.springframework.stereotype.Component

@Component
class TipoProfesionStrategy {

    val profesiones = mapOf(TipoProfesionEnum.Ingeniero to ProfesionIngeniero(),
        TipoProfesionEnum.Medico to ProfesionMedico(),
        TipoProfesionEnum.Policia to ProfesionPolicia()
    )
    fun trabajar(TipoProfesionEnum: TipoProfesionEnum): String {
        return profesiones[TipoProfesionEnum]!!.trabajar()
    }
}

interface TipoProfesion {
    fun trabajar(): String
}

class ProfesionPolicia: TipoProfesion {
    override fun trabajar(): String {
        println("Estás trabajando como policía")
        return "Estás atrapando a los malandros"
    }
}
class ProfesionMedico: TipoProfesion {
    override fun trabajar(): String {
        println("Estás trabajando como médico")
        return "Estas curando a los heridos"
    }
}
class ProfesionIngeniero: TipoProfesion {
    override fun trabajar(): String {
        println("Estás trabajando como ingeniero")
        return "Estás solucionando problemas"
    }
}