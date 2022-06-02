package com.example.mugfinal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog

val dosyaYolu="com.example.mugfinal"
val anahtarloginname="loginname"
val anahtarloginnumber="loginnumber"
val anahtarbenihatırla="benihatirla"

class GirisEkrani : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris_ekrani)



        var preferences=getSharedPreferences(dosyaYolu, Context.MODE_PRIVATE)
        var editor=preferences.edit()
        var loginname = findViewById<EditText>(R.id.loginname)
        var loginnumber = findViewById<EditText>(R.id.loginnumber)
        var benihatirla = findViewById<Switch>(R.id.benihatirla)
        var girisyap = findViewById<Button>(R.id.girisyap)

        val isim=intent.getStringExtra("adi").toString()
        val numara=intent.getStringExtra("numarasi")

        loginname.setText(preferences.getString(anahtarloginname,""));
        loginnumber.setText(preferences.getString(anahtarloginnumber,""));

        val alert=AlertDialog.Builder(this);

        var switchBeniHatirla=preferences.getBoolean(anahtarbenihatırla,false);
        benihatirla.isChecked=switchBeniHatirla
        benihatirla.setOnClickListener{
            switchBeniHatirla = benihatirla.isChecked
        }

        girisyap.setOnClickListener {
            if (loginname.text.toString().trim().isEmpty() || loginnumber.text.toString().trim().isEmpty()) {
                alert.setTitle("Hata")
                alert.setMessage("Alanlar Boş Bırakılamaz!")
                alert.create().show()

            } else if (loginname.text.toString() != isim.toString() || loginnumber.text.toString() != numara.toString()) {
                alert.setTitle("Hata")
                alert.setMessage("İsim veya Numara Bilgisi Yanlış!")

                alert.setPositiveButton("Çık") { dialogInteface, i ->
                    finish()

                }
                alert.setNeutralButton("Yeniden Dene") { dialogInteface, i ->
                    loginname.setText("")
                    loginnumber.setText("")
                    dialogInteface.dismiss()
                    dialogInteface.cancel()
                }
                alert.create().show()
            } else {


                if (switchBeniHatirla) {
                    editor.putString(anahtarloginname, loginname.text.toString())
                    editor.putString(anahtarloginnumber, loginnumber.text.toString())
                    editor.putBoolean(anahtarbenihatırla, switchBeniHatirla)
                    editor.apply()
                } else {
                    editor.putString(anahtarloginname, "")
                    editor.putString(anahtarloginnumber, "")
                    editor.putBoolean(anahtarbenihatırla, false)
                    editor.apply()
                }

                val tasarim = layoutInflater.inflate(R.layout.activity_girisbasarili, null)
                val ad = AlertDialog.Builder(this@GirisEkrani)
                ad.setView(tasarim)

                ad.create().show()

                var sayac = tasarim.findViewById<TextView>(R.id.sayac)

                var gerisay = object : CountDownTimer(3000,1000){
                    override fun onTick(p0: Long) {
                        sayac.text = (p0/1000).toString()
                    }
                    override fun onFinish() {
                    }
                }
                gerisay.start()
                Handler().postDelayed({
                    val gecis = Intent(this, menu::class.java)
                    startActivity(gecis)
                    finish()

                },3000)
            }
        }
    }
}
