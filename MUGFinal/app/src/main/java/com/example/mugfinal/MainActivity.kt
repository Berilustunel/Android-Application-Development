package com.example.mugfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.view.animation.Animation

import android.view.animation.AlphaAnimation

import android.R.string.no
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isim = findViewById<TextView>(R.id.name)
        var number = findViewById<TextView>(R.id.number)
        var sayac = findViewById<TextView>(R.id.sayac)

        val name = findViewById<TextView>(R.id.name)
        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 150
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        name.startAnimation(anim)

        var gerisay = object : CountDownTimer(5000, 1000){
            override fun onTick(p0: Long) {
                sayac.text = (p0/1000).toString()
            }
            override fun onFinish() {
                val gecis = Intent(applicationContext, GirisEkrani::class.java)
                gecis.putExtra("adi",name.text.toString())
                gecis.putExtra("numarasi",number.text.toString())
                startActivity(gecis)
                finish()
            }
        }
        gerisay.start()
    }

}
