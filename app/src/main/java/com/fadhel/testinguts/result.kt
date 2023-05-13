package com.fadhel.testinguts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class result : AppCompatActivity() {
    lateinit var nobp : TextView
    lateinit var nama : TextView
    lateinit var jekel : TextView
    lateinit var tgllahir : TextView
    lateinit var hoby : TextView
    lateinit var prodi : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        nobp = findViewById(R.id.txtnobp)
        nama = findViewById(R.id.txtnama)
        jekel = findViewById(R.id.txtjekel)
        tgllahir=findViewById(R.id.txttgllahir)
        hoby=findViewById(R.id.txthoby)
        prodi=findViewById(R.id.txtprodi)

        val bundle = intent.extras
        if(bundle != null){
            nobp.text= "No BP  = ${bundle.getString("nobp")}"
            nama.text="Nama = ${bundle.getString("Nama")}"
            jekel.text="Jenis Kelamin = ${bundle.getString("jekel")}"
            tgllahir.text="Tanggal Lahir = ${bundle.getString("tgllahir")}"
            hoby.text="Hoby \n ${bundle.getString("hoby")}"
            prodi.text="Prodi = ${bundle.getString("prodi")}"
        }
    }
}