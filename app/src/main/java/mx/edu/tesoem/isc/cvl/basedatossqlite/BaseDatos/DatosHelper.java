package mx.edu.tesoem.isc.cvl.basedatossqlite.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatosHelper extends SQLiteOpenHelper {

    private static DatosHelper datosHelper = null;
    private static String NOMBREBD = "bdAgenda";
    private static  int VERSION_BD = 1;

    public DatosHelper(@Nullable Context context) {
        super(context, NOMBREBD, null, VERSION_BD);
    }

    public static class tabladatos{
        public static String TABLA = "tbDatos";
        public static String COLUMNA_ID = "Id";
        public static String COLUMNA_NOMBRE = "nombre";
        public static String COLUMNA_EDAD = "edad";
        public static String COLUMNA_SEXO = "sexo";
    }

    public static final String CONSULTA_CREAR_TABLA = "create table " +
            tabladatos.TABLA + " ( " + tabladatos.COLUMNA_ID + " integer not null primary key autoincrement, " +
            tabladatos.COLUMNA_NOMBRE + " varchar, " + tabladatos.COLUMNA_EDAD + " varchar, " + tabladatos.COLUMNA_SEXO + " varchar);";

    public static final String CONSULTA_ELIMINAR_TABLA = "drop table if exists " + tabladatos.TABLA;



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONSULTA_CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CONSULTA_ELIMINAR_TABLA);
        onCreate(db);
    }
}
