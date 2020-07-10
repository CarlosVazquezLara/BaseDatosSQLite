package mx.edu.tesoem.isc.cvl.basedatossqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mx.edu.tesoem.isc.cvl.basedatossqlite.DTO.DatosDTO;

public class AdaptadorBase extends BaseAdapter {
    List<DatosDTO> listadatos = new ArrayList<>();
    Context context;

    public AdaptadorBase(List<DatosDTO> listadatos, Context context) {
        this.listadatos = listadatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listadatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listadatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_elemento, null);
        }

        TextView txtnombre = convertView.findViewById(R.id.txtnombree);
        DatosDTO dato = listadatos.get(position);
        txtnombre.setText(dato.getNombre());
        return convertView;
    }
}
