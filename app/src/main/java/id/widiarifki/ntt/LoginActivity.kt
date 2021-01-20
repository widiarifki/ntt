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