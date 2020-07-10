package mx.edu.tesoem.isc.cvl.basedatossqlite.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mx.edu.tesoem.isc.cvl.basedatossqlite.BaseDatos.DatosHelper.tabladatos;
import mx.edu.tesoem.isc.cvl.basedatossqlite.DTO.DatosDTO;

public class DatosConexion {

    private SQLiteDatabase basedatos;
    private DatosHelper datosHelper;
    private Context context;

    List<DatosDTO> listadatos = new ArrayList<>();

    public DatosConexion(Context context) {
        this.context = context;
    }

    public DatosConexion open(){
        datosHelper = new DatosHelper(context);
        basedatos = datosHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        datosHelper.close();
    }

    public boolean insertar(ContentValues contentValues){
        boolean estado = true;
        int restadoconsulta = (int) basedatos.insert(tabladatos.TABLA, null, contentValues);
        if (restadoconsulta < 0) estado = false;
        return estado;
    }

    public boolean ListarTodos(){
        boolean estado =true;
        DatosDTO datos;
        Cursor curso = basedatos.rawQuery("select * from " + tabladatos.TABLA, null);
        if(curso.getCount() > 0){
            curso.moveToFirst();
            while(!curso.isAfterLast()){
                datos = new DatosDTO();
                datos.setId(curso.getInt(0));
                datos.setNombre(curso.getString(1));
                datos.setEdad(curso.getString(2));
                datos.setSexo(curso.getString(3));
                listadatos.add(datos);
                curso.moveToNext();
            }
        }else{
            estado = false;
        }
        return estado;
    }

    public List<DatosDTO> getListadatos(){
        return listadatos;
    }

    public boolean actualizar(ContentValues contentValues, String[] condiciones){
        boolean estado = true;
        int resultado = basedatos.update(tabladatos.TABLA, contentValues,
                tabladatos.COLUMNA_ID + "=?", condiciones);
        if(!(resultado == 1)) estado = false;
        return estado;
    }

    public boolean eliminar(String[] condiciones){
        boolean estado = true;
        int resultado = basedatos.delete(tabladatos.TABLA, tabladatos.COLUMNA_ID + "=?", condiciones);
        if(!(resultado == 1)) estado = false;
        return estado;
    }
}

