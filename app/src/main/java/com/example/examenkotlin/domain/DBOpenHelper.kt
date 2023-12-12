package com.example.examenkotlin.domain

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.examenkotlin.adapter.PaisProvider

class DBOpenHelper private constructor(context: Context?):
    SQLiteOpenHelper(context, PaisContract.NOMBRE_DB, null, PaisContract.VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.execSQL(
                "CREATE TABLE ${PaisContract.Companion.Entrada.NOMBRE_TABLA}" +
                        "(${PaisContract.Companion.Entrada.COLUMNA_ID} int NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_PAIS} NVARCHAR(30) NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_BANDERA} int NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_UE} int NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_MAPA} int NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_HABITANTES} NVARCHAR(50) NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_CAPITAL} int NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_MIEMBRO} boolean NOT NULL);"
            )

            //Inserto los datos en la tabla
            inicializarBBDD(db)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun inicializarBBDD(db: SQLiteDatabase?) {
        val lista = PaisProvider.lista
        for (pais in lista) {
            db?.execSQL(
                ("INSERT INTO ${PaisContract.Companion.Entrada.NOMBRE_TABLA}(" +
                        "${PaisContract.Companion.Entrada.COLUMNA_ID}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_PAIS}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_BANDERA}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_UE}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_MAPA}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_HABITANTES}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_CAPITAL}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_MIEMBRO})" +
                        " VALUES (${pais.id},'${pais.pais}', ${pais.bandera},${pais.ue}, " +
                        "${pais.mapa},${pais.habitantes}, '${pais.capital}, ${pais.miembro}');")
            )
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${PaisContract.Companion.Entrada.NOMBRE_TABLA};")
        onCreate(db)
    }

    companion object {
        private var dbOpen: DBOpenHelper? = null
        fun getInstance(context: Context?): DBOpenHelper? {
            if (dbOpen == null) dbOpen = DBOpenHelper(context)
            return dbOpen
        }
    }
}