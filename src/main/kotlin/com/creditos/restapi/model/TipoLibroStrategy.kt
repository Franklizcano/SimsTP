package com.creditos.restapi.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TipoLibroStrategy {

    @Autowired
    lateinit var libroVirtual: LibroVirtual
    @Autowired
    lateinit var libroTapaBlanda: LibroTapaBlanda
    @Autowired
    lateinit var libroTapaDura: LibroTapaDura

    fun mostrarMensajeLibro(tipoLibroEnum: TipoLibroEnum): String {
        return getStrategy(tipoLibroEnum).mostrarMensajeLibro()
    }

    private fun getStrategy(tipoLibroEnum: TipoLibroEnum): TipoLibro =
        when(tipoLibroEnum) {
            TipoLibroEnum.VIRTUAL -> libroVirtual
            TipoLibroEnum.TAPA_BLANDA -> libroTapaBlanda
            TipoLibroEnum.TAPA_DURA ->  libroTapaDura
        }
}

@Component
abstract class TipoLibro {
    abstract fun mostrarMensajeLibro(): String
}

@Component
class LibroVirtual: TipoLibro() {

    override fun mostrarMensajeLibro(): String {
            return "Es barato pero se lee desde la compu"
    }
}

@Component
class LibroTapaBlanda: TipoLibro() {

    override fun mostrarMensajeLibro(): String {
        return "Cuidalo para que no se rompa"
    }
}

@Component
class LibroTapaDura: TipoLibro() {

    override fun mostrarMensajeLibro(): String {
        return "Que libro tan resistente"
    }
}