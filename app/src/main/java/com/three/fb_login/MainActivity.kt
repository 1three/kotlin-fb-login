package com.three.fb_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    // Firebase 익명 로그인 사용 (1)
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Firebase 익명 로그인 사용 (2)
        auth = Firebase.auth

        val btn = findViewById<Button>(R.id.startAnonymous)
        btn.setOnClickListener {
            // Firebase 익명 로그인 사용 (3)
            auth.signInAnonymously().addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 로그인 성공 시, 로그인한 사용자 uid 출력
                    val user = auth.currentUser
                    Log.d("로그인 성공 (uid)", user!!.uid)
                } else {
                    // 로그인 실패 시, 사용자에게 메시지 표시
                    Toast.makeText(baseContext, "로그인 권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}