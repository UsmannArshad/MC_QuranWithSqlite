package haqnawaz.org.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomizedAdapter extends ArrayAdapter<tayah> {
    public ArrayList<tayah> ayah;
    public CustomizedAdapter(@NonNull Context context, ArrayList<tayah> a) {
        super(context, 0,a);
        this.ayah=a;
    }

    @Nullable
    @Override
    public tayah getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       tayah cur=getItem(position);
       convertView= LayoutInflater.from(getContext()).inflate(R.layout.customizedview,parent,false);
        TextView ayahh=convertView.findViewById(R.id.ayah);
        TextView Etarjama=convertView.findViewById(R.id.englishTarjama);
        TextView UTarjama=convertView.findViewById(R.id.urduTarjama);

        ayahh.setText(String.valueOf(cur.ArabicText));
        Etarjama.setText(String.valueOf(cur.EnlishTarjama));
        UTarjama.setText(String.valueOf(cur.UrduTarajama));

        return  convertView;
    }
}
