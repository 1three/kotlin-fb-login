# kotlin-fb-login
[Kotlin] `Firebase`를 통한 익명/Email 로그인

![fb_login](https://github.com/1three/kotlin-fb-login/assets/94810322/757321e9-ce26-4b20-8859-33ecddd6dfda)

<br>

실제 `Firebase`의 `Authentication`에 들어가면,<br>
익명 로그인과 Email + Password를 통한 로그인 모두 uid가 잘 저장되어 있는 것을 확인할 수 있습니다.

<img width="500" src="https://github.com/1three/kotlin-fb-login/assets/94810322/d8dba0f9-51a0-4961-a63e-273c5f5e9cb9"><br>

<br>

## 🧐 배운점

#### 🧪 EditText 값 초기화

`회원가입 이후` 혹은 `로그아웃 이후`, 입력받는 상자의 입력된 값이 초기화되길 바랐습니다.

구글에 _안드로이드 코틀린 EditText 초기화_ 라고 검색한 결과,<br>
`setText(null)`만으로 입력된 값을 초기화할 수 있다는 것을 알게 되었습니다.


```Kotlin
findViewById<EditText>(R.id.emailArea).setText(null) // 이메일 입력 박스 초기화
findViewById<EditText>(R.id.passwordArea).setText(null) // 비밀번호 입력 박스 초기화
```

<br>

#### 🧪 Firebase와 안드로이드의 호환성

Firebase와 안드로이드 모두 Google에서 제공하는 플랫폼이라서 그런가요?<br>
Firebase의 문서를 따라 안드로이드 앱을 개발하니, 로그인을 매우 쉽게 구현할 수 있었습니다.

`다음 문서를 참고하였습니다` → [Android에서 비밀번호 기반 계정으로 Firebase에 인증](https://firebase.google.com/docs/auth/android/password-auth?hl=ko#sign_in_a_user_with_an_email_address_and_password)
