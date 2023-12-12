package com.example.examenkotlin.adapter

import com.example.examenkotlin.R
import com.example.examenkotlin.domain.Pais

class PaisProvider {
    companion object{
        val lista = mutableListOf<Pais>(
            Pais(1,"Albania", R.drawable.b_albania,R.drawable.c_vacia, R.drawable.m_albania,"3.038.594","Tirana",false),
            Pais(2,"Alemania",R.drawable.b_alemania,R.drawable.c_europa,R.drawable.m_alemania,"81.305.856","Berlín",true),
            Pais(3,"Austria",R.drawable.b_austria,R.drawable.c_europa,R.drawable.m_austria,"8.219.743","Viena",true),
            Pais(4,"Bélgica",R.drawable.b_belgica,R.drawable.c_europa,R.drawable.m_belgica,"10.438.353","Bruselas",true),
            Pais(5,"Bulgaria",R.drawable.b_bulgaria,R.drawable.c_vacia,R.drawable.m_bulgaria,"7.037.935","Sofía",false),
            Pais(6,"Rep.Checa",R.drawable.b_chequia,R.drawable.c_europa,R.drawable.m_chequia,"10.177.300","Praga",true),
            Pais(7,"Dinamarca",R.drawable.b_dinamarca,R.drawable.c_europa,R.drawable.m_dinamarca,"5.543.453","Copenague",true),
            Pais(8,"España",R.drawable.b_espana,R.drawable.c_europa,R.drawable.m_espana,"47.042.984","Madrid",true),
            Pais(9,"Estonia",R.drawable.b_estonia,R.drawable.c_europa,R.drawable.m_estonia,"1.274.709","Tallin",true),
            Pais(10,"Finlandia",R.drawable.b_finlandia,R.drawable.c_europa,R.drawable.m_finlandia,"5.262.930","Helsinki",true),
            Pais(11,"Francia",R.drawable.b_francia,R.drawable.c_europa,R.drawable.m_francia,"65.630.692","París",true),
            Pais(12,"Grecia",R.drawable.b_grecia,R.drawable.c_europa,R.drawable.m_grecia,"10.767.827","Atenas",true),
            Pais(13,"Holanda",R.drawable.b_holanda,R.drawable.c_europa,R.drawable.m_holanda,"16.730.632","Amsterdam",true),
            Pais(14,"Irlanda",R.drawable.b_irlanda,R.drawable.c_europa,R.drawable.m_irlanda,"4.722.028","Dublín",true),
            Pais(15,"Islandia",R.drawable.b_islandia,R.drawable.c_europa,R.drawable.m_islandia,"338.349","Reikiavik",true),
            Pais(16,"Italia",R.drawable.b_italia,R.drawable.c_europa,R.drawable.m_italia,"61.261.254","Roma",true),
            Pais(17,"Noruega",R.drawable.b_noruega,R.drawable.c_vacia,R.drawable.m_noruega,"5.214.890","Oslo",false),
            Pais(18,"Portugal",R.drawable.b_portugal,R.drawable.c_europa,R.drawable.m_portugal,"10.781.459","Lisboa",true),
            Pais(19,"Rumanía",R.drawable.b_rumania,R.drawable.c_europa,R.drawable.m_rumania,"21.848.504","Bucarest",true),
            Pais(20,"Rusia",R.drawable.b_rusia,R.drawable.c_vacia,R.drawable.m_rusia,"142.905.200","Moscú",false),
            Pais(21,"Suecia",R.drawable.b_suecia,R.drawable.c_europa,R.drawable.m_suecia,"9.103.788","Estocolmo",true),
            Pais(22,"Suiza",R.drawable.b_suiza,R.drawable.c_vacia,R.drawable.m_suiza,"8.140.000","Berna",false),
            Pais(23,"Reino Unido",R.drawable.b_uk,R.drawable.c_vacia,R.drawable.m_uk,"65.217.975","Londres",false),
            Pais(24,"Ucrania",R.drawable.b_ucrania,R.drawable.c_vacia,R.drawable.m_ucrania,"36.744.636","Kiev",false) )
    }
}