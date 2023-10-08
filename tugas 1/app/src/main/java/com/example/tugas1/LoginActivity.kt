package com.example.tugas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.edt_username)
        etPassword = findViewById(R.id.edt_password)

        val bundle = intent.extras
        if(bundle != null){
            etUsername.setText(bundle.getString("username"))
            etPassword.setText(bundle.getString("password"))
        }


        val btnlogin: Button = findViewById(R.id.btn_login)
        btnlogin.setOnClickListener(this)

        val btnimp: Button = findViewById(R.id.lupa_pw)
        btnimp.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("User", User(etUsername.text.toString(), etPassword.text.toString()))
                startActivity(intent)
            }
        }

        when(v.id){
            R.id.lupa_pw -> {
                val pesan = "SAYA LUPA PASSWORD SAYA DAN SAYA INGIN MERUBAH PASSWORD!!!!!"
                val implicit = Intent()
                implicit.action = Intent.ACTION_SEND
                implicit.putExtra(Intent.EXTRA_TEXT, pesan)
                implicit.type = "text/plan"
                startActivity(implicit)
            }
        }

    }
}