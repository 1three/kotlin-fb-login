package com.three.fb_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    // Firebase 이메일 로그인 사용 (1)
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        // Firebase 이메일 로그인 사용 (2)
        auth = Firebase.auth

        val joinBtn = findViewById<Button>(R.id.joinBtn)

        // 텍스트에 밑줄 추가
        val content = SpannableString("이메일로 가입하기")
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        joinBtn.text = content

        joinBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailArea).text.toString()
            val password = findViewById<EditText>(R.id.passwordArea).text.toString()

            // Firebase 이메일 회원가입
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // 회원가입 성공 시
                        Toast.makeText(this, "환영합니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        // 회원가입 실패 시
                        Toast.makeText(this, "회원가입을 실패하였습니다. 다시 시도해 주세요.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        }

        // Firebase 로그인
        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailArea).text.toString()
            val password = findViewById<EditText>(R.id.passwordArea).text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // 로그인 성공 시
                        val userName = email.split("@")[0];
                        Toast.makeText(this, " ${userName}님, 안녕하세요.", Toast.LENGTH_SHORT).show()
                    } else {
                        // 로그인 실패 시
                        Toast.makeText(this, "로그인을 실패하였습니다. 다시 시도해 주세요.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        // Firebase 로그아웃
        val logoutBtn: Button = findViewById(R.id.logoutBtn)

        logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}