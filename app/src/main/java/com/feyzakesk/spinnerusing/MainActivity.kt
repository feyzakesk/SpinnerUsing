package com.feyzakesk.spinnerusing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.feyzakesk.spinnerusing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val ulkeler = ArrayList<String>()

    private lateinit var veriAdaptoru:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Almanya")
        ulkeler.add("Japonya")
        ulkeler.add("Çin")
        ulkeler.add("Portekiz")
        ulkeler.add("İspanya")

        veriAdaptoru = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler)

        binding.spinner.adapter = veriAdaptoru

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, indeks: Int, id: Long) {
                Toast.makeText(applicationContext,"Seçilen Ülke : ${ulkeler[indeks]}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        binding.buttonGoster.setOnClickListener {
            Toast.makeText(applicationContext,"Ülke : ${ulkeler[binding.spinner.selectedItemPosition]}",Toast.LENGTH_SHORT).show()
        }


    }
}