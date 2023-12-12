package com.example.examenkotlin.domain

import android.provider.BaseColumns

class PaisContract {
    companion object{
        const val NOMBRE_DB = "paises_del_mundo"
        const val VERSION = 1
        class Entrada : BaseColumns {
            companion object{
                const val NOMBRE_TABLA = "paises"
                const val COLUMNA_ID = "id"
                const val COLUMNA_PAIS = "pais"
                const val COLUMNA_BANDERA = "bandera"
                const val COLUMNA_UE = "ue"
                const val COLUMNA_MAPA = "mapa"
                const val COLUMNA_HABITANTES = "habitantes"
                const val COLUMNA_CAPITAL = "capital"
                const val COLUMNA_MIEMBRO = "miembro"
            }
        }
    }
}