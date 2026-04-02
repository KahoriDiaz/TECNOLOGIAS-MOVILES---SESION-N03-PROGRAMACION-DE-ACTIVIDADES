package com.example.seguimiento

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.widget.ProgressBar

class DrawerActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar


    private lateinit var progressBar: ProgressBar
    private var activo = false
    private val TIEMPO = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)
        progressBar = findViewById(R.id.progressBar)

        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_config -> {
                    Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_info -> {
                    Toast.makeText(this, "Información", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawers()
            true
        }


        Thread {
            activo = true
            var tiempo = 0

            while (activo && tiempo < TIEMPO) {
                Thread.sleep(200)
                tiempo += 200

                runOnUiThread {
                    progressBar.progress = (tiempo * 100) / TIEMPO
                }
            }

            runOnUiThread {
                Toast.makeText(this, "Carga completa", Toast.LENGTH_SHORT).show()
            }

        }.start()
    }
}
