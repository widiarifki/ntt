# NTT Test

Goal: Create a functional login page

## activity_login.xml

```bash
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="20dp"
    android:orientation="vertical"
    tools:context=".LoginActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:layout_gravity="center"
        android:text="Silakan Login"
        android:textSize="18dp"
        android:fontFamily="sans-serif-medium"
        android:layout_marginBottom="8dp"/>
    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/etUsername"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Username"
            android:inputType="text|textCapWords"/>
    </com.google.android.material.textfield.TextInputLayout>
    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:passwordToggleEnabled="true">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/etPassword"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Password"
            android:inputType="textPassword"/>
    </com.google.android.material.textfield.TextInputLayout>
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/btnSubmit"
        android:text="Login"
        android:textAllCaps="true"
        android:onClick="onClickLogin"/>

</LinearLayout>
```

## LoginActivity.kt

```bash
package id.widiarifki.ntt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import id.widiarifki.ntt.databinding.ActivityLoginBinding
import id.widiarifki.ntt.model.User

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewUsername: EditText
    private lateinit var viewPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        viewUsername = binding.etUsername
        viewPassword = binding.etPassword
    }

    fun onClickLogin(view: View) {
        if (validateInput()) {
            gotoMainScreen()
        } else {
            showError("Maaf, kombinasi username & password salah")
        }
    }

    private fun validateInput() : Boolean {
        val usernameInput = viewUsername.text.toString()
        val passwordInput = viewPassword.text.toString()

        // Constant username & password stored on a model class called "User"
        return usernameInput == User.DEFAULT_USERNAME && passwordInput == User.DEFAULT_PASSWORD
    }

    private fun gotoMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
```
## Screenshot
![Screenshot 1](https://raw.githubusercontent.com/widiarifki/ntt/main/ss1.png)
![Screenshot 2](https://raw.githubusercontent.com/widiarifki/ntt/main/ss2.png)

