package com.example.mad_practical_5_21012011033

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Browser
import android.provider.CallLog
import android.provider.ContactsContract.DisplayPhoto
import android.provider.MediaStore
import android.telecom.Call
import android.widget.Button
import android.widget.EditText
import android.widget.Gallery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnBrowser:Button=findViewById(R.id.browse_btn)
        val editBrowser:EditText=findViewById(R.id.editTextUrl)
        btnBrowser.setOnClickListener {
            Browser(editBrowser.text.toString())
        }
        val btnCall:Button = findViewById(R.id.call_btn)
        val editCall:EditText=findViewById(R.id.editTextPhone)
        btnCall.setOnClickListener(){
            call(editCall.text.toString())
        }
        val btnCallLog:Button=findViewById(R.id.callLog_btn)
        btnCallLog.setOnClickListener(){
            call(editCall.text.toString())
        }
        val btnGallery:Button=findViewById(R.id.gallery_btn)
        btnGallery.setOnClickListener(){
            gallery()
        }
        val btnCamera:Button=findViewById(R.id.camera_btn)
        btnCamera.setOnClickListener(){
            camera()
        }
        val btnAlarm:Button=findViewById(R.id.alarm_btn)
        btnAlarm.setOnClickListener(){
            alarm()
        }
    }
    fun Browser(url:String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun call(number:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also{startActivity(it)}
    }
    fun calllog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun gallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    fun camera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun alarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }
}