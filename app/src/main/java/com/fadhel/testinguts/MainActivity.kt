package com.fadhel.testinguts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() , AdapterView.OnItemClickListener,
    AdapterView.OnItemSelectedListener {
    var spinProdi = arrayOf<String>("Manajemen Informatika","Teknik Komputer","TRPL")
    lateinit var nobp : EditText
    lateinit var nama : EditText
    lateinit var jeniskelamin : RadioGroup
    lateinit var chkbulutangkis : CheckBox
    lateinit var chkcatur : CheckBox
    lateinit var chkwarnet : CheckBox
    lateinit var chkmembaca : CheckBox
    lateinit var chkberenang : CheckBox
    lateinit var tanggallahir : DatePicker
    lateinit var spinprodi : Spinner
    lateinit var submit : Button
    lateinit var output : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nobp = findViewById(R.id.editnobp)
        nama = findViewById(R.id.editnama)
        jeniskelamin = findViewById(R.id.rgjekel)
        chkbulutangkis = findViewById(R.id.chkbulutangkis)
        chkcatur = findViewById(R.id.chkcatur)
        chkwarnet = findViewById(R.id.chkwarnet)
        chkmembaca = findViewById(R.id.chkmembaca)
        chkberenang = findViewById(R.id.chkberenang)
        tanggallahir = findViewById(R.id.datetgllahir)
        spinprodi = findViewById(R.id.spinprodi)
        spinprodi.onItemSelectedListener=this
        submit = findViewById(R.id.btnsubmit)
        output = findViewById(R.id.txtoutput)
        val tanggal = Calendar.getInstance()
        val tgl = tanggallahir.init(
            tanggal.get(Calendar.YEAR),tanggal.get(Calendar.MONTH),tanggal.get(Calendar.DAY_OF_MONTH)){
            tanggallahir , year, month ,day ->

            val month = month + 1
            val tgldipilih = "$year - $month - $day"
            Toast.makeText(this@MainActivity,tgldipilih,Toast.LENGTH_SHORT).show()
            val arrayAdapter : ArrayAdapter<*> = ArrayAdapter<Any?>(this,R.layout.spinner_style,spinProdi)
            arrayAdapter.setDropDownViewResource(R.layout.spinner_style)
            spinprodi.adapter = arrayAdapter
            submit.setOnClickListener {
                val Nobp = nobp.text
                val Nama = nama.text
                val Jeniskelamin = jeniskelamin.checkedRadioButtonId
                val jekel = findViewById<RadioButton>(Jeniskelamin)
                val bulutangkis = chkbulutangkis.isChecked
                val catur = chkcatur.isChecked
                val warnet = chkwarnet.isChecked
                val membaca = chkmembaca.isChecked
                val berenang = chkberenang.isChecked
                val bundle = Bundle()
                bundle.putString("nobp",Nobp.toString())
                bundle.putString("Nama",Nama.toString())
                bundle.putString("jekel",jekel.text.toString())
                bundle.putString("prodi",spinprodi.selectedItem.toString())
                bundle.putString("hoby",
                        (if(bulutangkis)"Bulutangkis\n" else "")+
                        (if(catur)"Catur\n" else "")+
                        (if(warnet)"Warnet\n" else "")+
                        (if(membaca)"Membaca\n" else "")+
                        (if(berenang)"Berenang\n" else "").toString())
                bundle.putString("tgllahir",tgldipilih)

                val intent = Intent(this@MainActivity,result::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
//                val out = "Data\n"+
//                        "No BP : $Nobp \n"+
//                        "Nama : $Nama \n"+
//                        "Jenis Kelamin : ${jekel.text} \n"+
//                        "Tanggal Lahir : $tgldipilih\n"+
//                        "Hobby : \n"+
//                        (if(bulutangkis)"Bulutangkis\n" else "")+
//                        (if(catur)"Catur\n" else "")+
//                        (if(warnet)"Warnet\n" else "")+
//                        (if(membaca)"Membaca\n" else "")+
//                        (if(berenang)"Berenang\n" else "")+
//                        "Prodi : "+ spinprodi.selectedItem
//                output.text = out

            }
        }


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var toast : String = p0?.getItemAtPosition(p2).toString()
        Toast.makeText(this@MainActivity,"$toast",Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }
}