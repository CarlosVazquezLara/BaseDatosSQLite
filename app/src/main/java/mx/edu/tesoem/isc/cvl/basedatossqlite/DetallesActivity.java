package mx.edu.tesoem.isc.cvl.basedatossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.edu.tesoem.isc.cvl.basedatossqlite.BaseDatos.DatosConexion;
import mx.edu.tesoem.isc.cvl.basedatossqlite.DTO.DatosParcelable;
import mx.edu.tesoem.isc.cvl.basedatossqlite.BaseDatos.DatosHelper.tabladatos;

public class DetallesActivity extends AppCompatActivity {

    EditText txtid, txtnombre, txtedad, txtsexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        txtid = findViewById(R.id.txtidd);
        txtnombre = findViewById(R.id.txtnombred);
        txtedad = findViewById(R.id.txtedadd);
        txtsexo = findViewById(R.id.txtsexod);

        DatosParcelable datosParcelable = getIntent().getParcelableExtra("datosParcelable");

        txtid.setText(String.valueOf(datosParcelable.getId()));
        txtnombre.setText(datosParcelable.getNombre());
        txtedad.setText(datosParcelable.getEdad());
        txtsexo.setText(datosParcelable.getSexo());

        getSupportActionBar().setTitle(datosParcelable.getNombre());
    }

    public void actualiza(View v){
        ContentValues contentValues = new ContentValues();
        DatosConexion conexion = new DatosConexion(this);

        contentValues.put(tabladatos.COLUMNA_NOMBRE, txtnombre.getText().toString());
        contentValues.put(tabladatos.COLUMNA_EDAD, txtedad.getText().toString());
        contentValues.put(tabladatos.COLUMNA_SEXO, txtsexo.getText().toString());

        String[] condicion = new String[]{txtid.getText().toString()};

        conexion.open();
        if(conexion.actualizar(contentValues,condicion)){
            Toast.makeText(this, "Actualizacion realizada", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        }else{
            Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
        }
        conexion.close();
    }

    public void elimina(View v){

        DatosConexion conexion = new DatosConexion(this);
        String[] condicion = new String[]{txtid.getText().toString()};
        conexion.open();
        if(conexion.eliminar(condicion)){
            Toast.makeText(this, "Se elimino correctamente", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        }else{
            Toast.makeText(this, "Error al eliminar", Toast.LENGTH_SHORT).show();
        }
        conexion.close();

    }
}