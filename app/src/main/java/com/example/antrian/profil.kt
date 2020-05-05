package com.example.antrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class profil : AppCompatActivity() {
//    private var getNama = ""
//    private var getJK = ""
//    private var getUmur = ""
//    private var getEmail = ""
//    private var getTelp = ""
//    private var getAlamat = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        getData()
        aboutButton.setOnClickListener { toAbout() }
    }

    private fun getData(){
        val bundle = intent.extras

        var getnama = bundle.getString("nama")
        val getjk = bundle.getString("jk")
        val getumur = bundle.getInt("umur")
        val getemail = bundle.getString("email")
        val gettelp = bundle.getString("telp")
        val getalamat = bundle.getString("alamat")

        nama.text = getnama
        umur.text = getumur.toString()
        jeniskelamin.text = getjk
        email.text = getemail
        telp.text = gettelp
        alamat.text = getalamat
    }

    private fun toAbout(){
        val intent = Intent(this, About::class.java)
//
//        intent.putExtras(intent.extras)
//
        startActivity(intent)
        Toast.makeText(this, "About dipitet", Toast.LENGTH_SHORT).show()

    }
}
