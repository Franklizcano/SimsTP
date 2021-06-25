package com.creditos.restapi.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TipoProfesionStrategy {

    @Autowired
    lateinit var profesionPolicia: ProfesionPolicia

    @Autowired
    lateinit var profesionMedico: ProfesionMedico

    @Autowired
    lateinit var profesionIngeniero: ProfesionIngeniero

    private fun getStrategy(tipoProfesionEnum: TipoProfesionEnum): TipoProfesion =
        when(tipoProfesionEnum) {
            TipoProfesionEnum.Ingeniero -> profesionIngeniero
            TipoProfesionEnum.Medico -> profesionMedico
            TipoProfesionEnum.Policia -> profesionPolicia
        }

    fun trabajar(persona: Persona, tipoProfesionEnum: TipoProfesionEnum): String {
        return getStrategy(tipoProfesionEnum).trabajar(persona)
    }
}

@Component
interface TipoProfesion {
    fun trabajar(persona: Persona): String
}

@Component
class ProfesionPolicia: TipoProfesion {
    override fun trabajar(persona: Persona): String {
        persona.dinero += 500
        println("Trabajaste como policía y has cobrado: 500\nTu dinero actual es ${persona.dinero}")
        return "Estás atrapando a los malandros"
    }
}

@Component
class ProfesionMedico: TipoProfesion {
    override fun trabajar(persona: Persona): String {
        persona.dinero += 1000
        println("Trabajaste como médico y has cobrado: 1000\nTu dinero actual es ${persona.dinero}")
        return "Estas curando a los heridos"
    }
}

@Component
class ProfesionIngeniero: TipoProfesion {
    override fun trabajar(persona: Persona): String {
        persona.dinero += 1500
        println("Trabajaste como ingeniero y has cobrado: 1500\nTu dinero actual es ${persona.dinero}")
        return "Estás solucionando problemas"
    }
}