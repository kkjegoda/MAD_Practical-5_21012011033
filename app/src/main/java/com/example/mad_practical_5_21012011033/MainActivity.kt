package com.example.mad_practical_5_21012011033

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Browser
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browseBtn:Button = findViewById(R.id.btn_browse)
        val editTextBrowser:EditText = findViewById(R.id.editTextText)
        browseBtn.setOnClickListener{
            clickBrowes(editTextBrowser.text.toString())
        }
        val callBtn:Button=findViewById(R.id.btn_call)
        val call_input:EditText=findViewById(R.id.editTextPhone)
        callBtn.setOnClickListener {
            clickCall(call_input.text.toString())
        }

    }
    fun clickBrowes(url:String){
        Intent(Intent.ACTION_VIEW, Uri.parse(url))
            .also { startActivity(it) }
    }
    fun clickCall(pno:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$pno"))
            .also { startActivity(it) }
    }
    fun clickCalllog(){

    }
    fun clickGallery(){

    }
    fun clickCamera(){

    }
    fun clickAlarm(){

    }

}