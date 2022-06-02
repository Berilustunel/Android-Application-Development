package com.example.mugfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import androidx.fragment.app.Fragment

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var menu = findViewById<Button>(R.id.menu)

        menu.setOnClickListener{
            val acilirMenu = PopupMenu(this, menu)
            acilirMenu.menuInflater.inflate(R.menu.popupmenu, acilirMenu.menu)
            acilirMenu.setOnMenuItemClickListener { i ->
                when(i.itemId){
                    R.id.anasayfa -> {
                        fragmentGecis(anasayfaFragment())
                        true
                    }
                    R.id.renk -> {
                        fragmentGecis(renkfragment())
                        true
                    }
                    R.id.birazhareket -> {
                        fragmentGecis(birazhareketFragment())
                        true
                    }
                    R.id.görünürgörünmez -> {
                        fragmentGecis(gorunur_gorunmezFragment())
                        true
                    }
                    R.id.toastmesajıoluşturma -> {
                        fragmentGecis(toast_mesajiFragment())
                        true
                    }
                    else -> false
                }
            }
            acilirMenu.show()
        }

    }
    fun fragmentGecis(fragment: Fragment) {
        var gecis = supportFragmentManager.beginTransaction()
        gecis.replace(R.id.fragmentContainerView, fragment)
        gecis.commit()
    }
}


