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

class Login : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Cambiar de pantalla
        val crearCuenta = findViewById<TextView>(R.id.CrearCuenta)
        crearCuenta.setOnClickListener {
            val intent=Intent(this, Register::class.java)
            startActivity(intent)
        }

        emailEditText = findViewById(R.id.emailET)
        passwordEditText = findViewById(R.id.passwordET)


        //Mostrar contraseña
        val passwordEditText = findViewById<EditText>(R.id.passwordET)
        val passwordImageView = findViewById<ImageView>(R.id.PasswordIcon)
        passwordImageView.setTag(R.id.PasswordIcon, false)

        passwordImageView.setOnClickListener {
            togglePasswordVisibility1(passwordEditText, passwordImageView)
        }

        //Boton iniciar sesion
        val loginButton = findViewById<Button>(R.id.buttonL)
        loginButton.setOnClickListener {

            if (validateFields()) {

                register()

                val intent= Intent(this, EstadoLentes::class.java)


                startActivity(intent)
            }
        }
    }



    private fun validateFields(): Boolean {

        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString()



        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            return false
        }




        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Ingrese un correo electrónico válido.", Toast.LENGTH_SHORT).show()
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

    private fun register() {

        Toast.makeText(this, "¡Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show()

    }

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
