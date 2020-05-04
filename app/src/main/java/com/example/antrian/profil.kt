package com.example.antrian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*

class profil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        getData()
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
}
