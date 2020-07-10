package mx.edu.tesoem.isc.cvl.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Lanzar_registro(View v){
        Intent intent = new Intent(this, RegistraActivity.class);
        startActivity(intent);
    }

    public void lanzar_lista(View v){
        Intent intent = new Intent(this, ListarinformacionActivity.class);
        startActivity(intent);
    }
}