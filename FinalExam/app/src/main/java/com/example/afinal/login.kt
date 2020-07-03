package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance();

        loginButtonId.setOnClickListener {
            singInUpHandler(it)
        }

        if (auth.currentUser != null) {
            proceedToApp()
        }

    }

    private fun singInUpHandler(view: View) {
        auth.signInWithEmailAndPassword(loginEmailE.text.toString(), loginPasswordEt.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    proceedToApp()
                } else {
                    auth.createUserWithEmailAndPassword(loginEmailE.text.toString(),
                        loginPasswordEt.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                proceedToApp()
                            } else {
                                Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }

    }

    private fun proceedToApp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
