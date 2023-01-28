package com.example.testlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var vServerIPAddress: EditText
    private lateinit var vDatabaseName: EditText
    private lateinit var vPassword: EditText
    private lateinit var vLogin: Button
    private lateinit var vClear: Button
    private lateinit var vExit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vServerIPAddress = findViewById(R.id.etServerIPAddress)
        vDatabaseName = findViewById(R.id.etDatabaseName)
        vPassword = findViewById(R.id.etPassword)
        vLogin = findViewById(R.id.bLogin)
        vClear = findViewById(R.id.bClear)
        vExit = findViewById(R.id.bExit)

        vServerIPAddress.requestFocus()

        vServerIPAddress.setOnClickListener{
            vServerIPAddress.setText("")
        }

        vLogin.setOnClickListener{

            Toast.makeText(this@MainActivity, "Login Button Clicked!", Toast.LENGTH_SHORT).show()
        }

        vClear.setOnClickListener{

            // Clean up
            var server:String = "Server IP Address"
            var database:String = "Database Name"
            var password:String = "Password"

            vServerIPAddress.setText(server)
            vDatabaseName.setText(database)
            vPassword.setText(password)

            Toast.makeText(this@MainActivity, "Clear Button Clicked!", Toast.LENGTH_SHORT).show()
        }

        vExit.setOnClickListener{

            // Since exitProcess will call right after this Toast, toast will not displayed, should be comment out
            // Toast.makeText(this@MainActivity, "Exit Button Clicked!", Toast.LENGTH_SHORT).show()

            // From StackOverflow
            // Even if you finish all of the Activity s in your application, the OS process hosting your app does
            // not automatically go away (as it does when you call System.exit()). Android will eventually kill
            // your process when it gets around to it. You have no control over this (and that is intentional).
            exitProcess(0)
        }

    }
}