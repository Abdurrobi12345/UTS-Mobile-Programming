package com.abdurrobi.loginactivity

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menampilkan pesan welcome
        Toast.makeText(this, "Selamat datang di Aplikasi Saya", Toast.LENGTH_SHORT).show()

        // Menghubungkan tombol-tombol dengan elemen dalam layout
        val bukaProfilButton = findViewById<Button>(R.id.bukaProfilButton)
        val bukaKameraButton = findViewById<Button>(R.id.bukaKameraButton)
        val tampilkanListViewButton = findViewById<Button>(R.id.tampilkanListViewButton)
        val keluarButton = findViewById<Button>(R.id.keluarButton)

        // Mengatur aksi ketika tombol "Buka Profil" ditekan
        bukaProfilButton.setOnClickListener {
            startActivity(Intent(this, ProfilActivity::class.java))
        }

        // Mengatur aksi ketika tombol "Buka Kamera" ditekan
        bukaKameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // Mengatur aksi ketika tombol "Tampilkan ListView" ditekan
        tampilkanListViewButton.setOnClickListener {
            val listViewItems = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

            val listView = ListView(this)
            listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewItems)

            val alertDialog = AlertDialog.Builder(this)
                .setTitle("List View")
                .setView(listView)
                .setNegativeButton("Batal", null)
                .create()

            listView.setOnItemClickListener { parent, view, position, id ->
                val selectedItem = listViewItems[position]
                Toast.makeText(this, "Anda memilih: $selectedItem", Toast.LENGTH_SHORT).show()
                alertDialog.dismiss()
            }

            alertDialog.show()
        }

        // Mengatur aksi ketika tombol "Keluar" ditekan
        keluarButton.setOnClickListener {
            finishAffinity()
        }
    }
}
