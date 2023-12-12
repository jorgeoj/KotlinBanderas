package com.example.examenkotlin.domain

import android.content.Context
import android.database.Cursor

class PaisDAO {
    fun cargarTodosLosPaises(context: Context?):MutableList<Pais>{
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM paises;"
            c = db.rawQuery(sql, null)
            res = mutableListOf()
            // Leo los resultados del cursor y los meto en la lista
            while (c.moveToNext()) {
                val nuevo = Pais(
                    c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4),
                    c.getString(5), c.getString(6), c.getInt(7) == 1
                    //TODO: Mirar la parte del miembro
                )
                res.add(nuevo)
            }
        } finally {
            c.close()
        }
        return res
    }

    fun cargarPaisesUE(context: Context?):MutableList<Pais>{
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM paises WHERE miembro IS TRUE;"
            c = db.rawQuery(sql, null)
            res = mutableListOf()
            // Leo los resultados del cursor y los meto en la lista
            while (c.moveToNext()) {
                val nuevo = Pais(
                    c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4),
                    c.getString(5), c.getString(6), c.getInt(7) == 1
                )
                res.add(nuevo)
            }
        } finally {
            c.close()
        }
        return res
    }

    fun cargarPaisesFueraUE(context: Context?):MutableList<Pais>{
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM paises WHERE miembro IS FALSE;"
            c = db.rawQuery(sql, null)
            res = mutableListOf()
            // Leo los resultados del cursor y los meto en la lista
            while (c.moveToNext()) {
                val nuevo = Pais(
                    c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getInt(4),
                    c.getString(5), c.getString(6), c.getInt(7) == 0
                )
                res.add(nuevo)
            }
        } finally {
            c.close()
        }
        return res
    }
}