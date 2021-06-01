package com.creditos.restapi.model

import org.springframework.stereotype.Component

@Component
class TipoLibroStrategy {

    val strategies = mapOf(
        TipoLibroEnum.VIRTUAL to LibroVirtual(),
        TipoLibroEnum.TAPA_BLANDA to LibroTapaBlanda(),
        TipoLibroEnum.TAPA_DURA to LibroTapaDura(),
    )

    fun mostrarMensajeLibro(tipoLibroEnum: TipoLibroEnum): String {
        return strategies[tipoLibroEnum]!!.mostrarMensajeLibro()
    }

/*    fun mostrarMensajeLibro(tipoLibroEnum: TipoLibroEnum): String {
        return getStrategy(tipoLibroEnum).mostrarMensajeLibro()
    }

    private fun getStrategy(tipoLibroEnum: TipoLibroEnum): TipoLibro =
        when(tipoLibroEnum) {
            TipoLibroEnum.VIRTUAL -> LibroVirtual()
            TipoLibroEnum.TAPA_BLANDA -> LibroTapaBlanda()
            TipoLibroEnum.TAPA_DURA ->  LibroTapaDura()
        }*/
}

abstract class TipoLibro {
    abstract fun mostrarMensajeLibro(): String
}

class LibroVirtual: TipoLibro() {

    override fun mostrarMensajeLibro(): String {
            return "Es barato pero se lee desde la compu"
    }
}

class LibroTapaBlanda: TipoLibro() {

    override fun mostrarMensajeLibro(): String {
        return "Cuidalo para que no se rompa"
    }
}

class LibroTapaDura: TipoLibro() {

    override fun mostrarMensajeLibro(): String {
        return "Que libro tan resistente";
    }
}