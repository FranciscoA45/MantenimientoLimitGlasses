package com.example.limitglasses

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        nameEditText = findViewById(R.id.nameET)
        emailEditText = findViewById(R.id.emailET)
        passwordEditText = findViewById(R.id.passwordET)
        confirmPasswordEditText = findViewById(R.id.PasswordET2)

        val tengoCuenta = findViewById<TextView>(R.id.Tengocuenta)
        tengoCuenta.setOnClickListener {
            val intent=Intent(this, Login::class.java)
            startActivity(intent)
        }


        val registerButton = findViewById<Button>(R.id.registerButton)
        registerButton.setOnClickListener {
            if (validateFields()) {
                register()
                val intent=Intent(this, Login::class.java)
                startActivity(intent)
            }
        }

        val passwordEditText = findViewById<EditText>(R.id.passwordET)
        val passwordImageView = findViewById<ImageView>(R.id.PasswordIcon)
        passwordImageView.setTag(R.id.PasswordIcon, false)

        passwordImageView.setOnClickListener {
            togglePasswordVisibility1(passwordEditText, passwordImageView)
        }

        val passwordEditText2 = findViewById<EditText>(R.id.PasswordET2)
        val passwordImageView2 = findViewById<ImageView>(R.id.PasswordIcon2)
        passwordImageView2.setTag(R.id.PasswordIcon2, false)

        passwordImageView2.setOnClickListener {
            togglePasswordVisibility2(passwordEditText2, passwordImageView2)
        }

    }


    private fun validateFields(): Boolean {
        val name = nameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()


        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!validateName(name)) {
            Toast.makeText(this, "El nombre solo puede contener letras.", Toast.LENGTH_SHORT).show()
            return false
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Ingrese un correo electrónico válido.", Toast.LENGTH_SHORT).show()
            return false
        }


        if (password != confirmPassword) {
            Toast.makeText(this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!validatePassword(password)) {
            Toast.makeText(this, "La contraseña debe tener al menos 8 caracteres y contener al menos una letra y un dígito.", Toast.LENGTH_SHORT).show()
            return false
        }


        return true
        }

        private fun validatePassword(password: String): Boolean {
            val PASSWORD_PATTERN: Regex = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$")
            return password.matches(PASSWORD_PATTERN)
        }

    private fun validateName(name: String): Boolean {
        return name.matches(Regex("^[a-zA-Z ]+$"))
    }


    private fun register() {

            Toast.makeText(this, "¡Registro exitoso!", Toast.LENGTH_SHORT).show()

        }

    private fun togglePasswordVisibility1(editText: EditText, imageView: ImageView) {
        val isPasswordVisible = imageView.getTag(R.id.PasswordIcon) as? Boolean ?: false
        if (isPasswordVisible) {

            editText.transformationMethod = PasswordTransformationMethod.getInstance()
            imageView.setImageResource(R.drawable.hide_password)
        } else {

            editText.transformationMethod = null
            imageView.setImageResource(R.drawable.hide_password)
        }

        imageView.setTag(R.id.PasswordIcon, !isPasswordVisible)

        editText.setSelection(editText.text.length)
    }

    private fun togglePasswordVisibility2(editText: EditText, imageView: ImageView) {
        val isPasswordVisible = imageView.getTag(R.id.PasswordIcon2) as? Boolean ?: false
        if (isPasswordVisible) {

            editText.transformationMethod = PasswordTransformationMethod.getInstance()
            imageView.setImageResource(R.drawable.hide_password)
        } else {

            editText.transformationMethod = null
            imageView.setImageResource(R.drawable.hide_password)
        }

        imageView.setTag(R.id.PasswordIcon2, !isPasswordVisible)

        editText.setSelection(editText.text.length)
    }

}
