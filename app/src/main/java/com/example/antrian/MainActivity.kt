package com.example.antrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var namaInput : String = ""
    private var jkInput : String = ""
    private var telpInput : String = ""
    private var emailInput : String = ""
    private var alamatInput : String = ""
    private var umurInput : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDataJK()
        simpanButton.setOnClickListener { validateInput() }
    }

    private fun validateInput(){
        namaInput = nama.text.toString()
        telpInput = telp.text.toString()
        emailInput = email.text.toString()
        alamatInput = alamat.text.toString()
        jkInput = jk.selectedItem.toString()
        umurInput = umur.text.toString().toInt()

        when {
            namaInput.isEmpty() ->
                nama.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() ->
                email.error = "Email tidak boleh kosong"
            jkInput.equals("Pilih jenis kelamin", ignoreCase = true) ->
                Toast.makeText(this, "Pilih jenis kelamin anda", Toast.LENGTH_SHORT).show()
            telpInput.isEmpty() ->
                telp.error = "Nomor telepon tidak boleh kosong"
            alamatInput.isEmpty() ->
                alamat.error = "Alamat tidak boleh kosong"
//            umurInput.equals(0) -> umur.error = "Isi umur bro"
            else -> {
                Toast.makeText(this, "Mantapp bro", Toast.LENGTH_SHORT).show()
                goToProfile()
            }
        }
    }

    private fun setDataJK(){
        val adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        jk.adapter = adapter
    }

    private fun goToProfile(){
        val intent = Intent(this, profil::class.java)

        val bundle = Bundle()
        bundle.putString("nama",namaInput)
        bundle.putInt("umur", umurInput)
        bundle.putString("jk",jkInput)
        bundle.putString("telp",telpInput)
        bundle.putString("email",emailInput)
        bundle.putString("alamat",alamatInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }
}
