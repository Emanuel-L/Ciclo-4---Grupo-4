package com.example.todoparks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var ListPlaces : ArrayList<PlaceItem>
    private lateinit var adapterplaces : PlacesAdapter
    private lateinit var PlacesRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Prueba", "entró")
        setContentView(R.layout.activity_main)

        PlacesRecyclerView = findViewById(R.id.ListView)
        ListPlaces = CreateListPlaces()
        adapterplaces = PlacesAdapter(ListPlaces)

        PlacesRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter = adapterplaces
            setHasFixedSize(false)
        }
    }

    private fun CreateListPlaces(): ArrayList<PlaceItem> {
        var PlacesString: String = applicationContext.assets.open("docPlaces.json").bufferedReader().use { it.readText() }
        var json = Gson()
        val datos = json.fromJson(PlacesString, Place::class.java)
        return datos

    }
}