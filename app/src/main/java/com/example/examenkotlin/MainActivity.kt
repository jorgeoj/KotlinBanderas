package com.example.examenkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenkotlin.adapter.PaisAdapter
import com.example.examenkotlin.adapter.PaisProvider
import com.example.examenkotlin.databinding.ActivityMainBinding
import com.example.examenkotlin.domain.Pais
import com.example.examenkotlin.domain.PaisDAO

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PaisAdapter
    private lateinit var lista: MutableList<Pais>
    private var paisDAO: PaisDAO = PaisDAO()

    private lateinit var intentLaunch: ActivityResultLauncher<Intent>
    private var posicion = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lista = mutableListOf()
        lista = PaisProvider.lista

        // Copia los datos de la lista de PaisProvider a la lista original
        var originalList = PaisProvider.lista.toMutableList()

        // Suponiendo que `lista` es tu lista de objetos Pais y tienes una función `handleItemClick` como se definió anteriormente
        adapter = PaisAdapter(lista) { pais ->
            handleItemClick(pais, adapter)
        }

        setSupportActionBar(binding.toolbar)

        binding.rvPaises.layoutManager = LinearLayoutManager(this)
        binding.rvPaises.adapter = adapter

        intentLaunch = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val posicion = result.data?.extras?.getInt("posicion", 0)
                lista[posicion!!].pais = result.data?.extras?.getString("nuevoNombre").toString()
                adapter.notifyDataSetChanged()
            }
        }
    }

    fun handleItemClick(pais: Pais, adapter: PaisAdapter) {
        val intent = Intent(this, PaisActivity::class.java)
        intent.putExtra("posicion", lista.indexOf(pais))
        intent.putExtra("pais", pais.pais)
        intent.putExtra("bandera", pais.bandera)
        intent.putExtra("ue", pais.ue)
        intent.putExtra("miembro", pais.miembro)
        intent.putExtra("mapa", pais.mapa)
        intent.putExtra("habitantes", pais.habitantes)
        intent.putExtra("capital", pais.capital)
        intentLaunch.launch(intent)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.union_europea -> {
                val filteredList = lista.filter { it.miembro }.toMutableList()
                updateAdapter(filteredList)
                Toast.makeText(this, "Lista de países de la UE", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.resto_de_paises -> {
                val filteredListNoUE = lista.filter { !it.miembro }.toMutableList()
                updateAdapter(filteredListNoUE)
                Toast.makeText(this, "Lista de países que no pertenecen a la UE", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.todos_los_paises -> {
                updateAdapter(lista.toMutableList())
                Toast.makeText(this, "Lista de todos los países, pertenezcan o no a la UE", Toast.LENGTH_SHORT).show()
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun updateAdapter(filteredList: MutableList<Pais>) {
        adapter = PaisAdapter(filteredList) { pais ->
            handleItemClick(pais, adapter)
        }
        binding.rvPaises.adapter = adapter
    }
}