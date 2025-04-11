package cervantes.fedra.practica10

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class Bienvenida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val correo = intent.getStringExtra("correo")
        val proveedor = intent.getStringExtra("proveedor")

        val evCorreo: TextView = findViewById(R.id.evCorreo)
        val evProveedor: TextView = findViewById(R.id.evProveedor)

        evCorreo.text = "Correo: $correo"
        evProveedor.text = "Proveedor: $proveedor"

        val btnSalir: Button = findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        ).signOut().addOnCompleteListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
