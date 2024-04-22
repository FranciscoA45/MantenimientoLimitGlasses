import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.limitglasses.SelectAccountActivity
import com.example.limitglasses.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra los botones por sus ID
        val btnGoogle = findViewById<AppCompatButton>(R.id.btnGogle)
        val btnGoogleR = findViewById<AppCompatButton>(R.id.btnGogleR)

        // Agrega un OnClickListener al botón btnGoogle
        btnGoogle.setOnClickListener {
            // Crea un Intent para abrir la nueva actividad
            val intent = Intent(this, SelectAccountActivity::class.java)
            startActivity(intent)
        }

        // Agrega un OnClickListener al botón btnGoogleR
        btnGoogleR.setOnClickListener {
            // Crea un Intent para abrir la nueva actividad
            val intent = Intent(this, btnGoogle::class.java)
            startActivity(intent)
        }
    }
}
