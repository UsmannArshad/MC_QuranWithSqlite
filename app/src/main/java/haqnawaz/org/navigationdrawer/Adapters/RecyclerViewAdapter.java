package haqnawaz.org.navigationdrawer.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haqnawaz.org.navigationdrawer.R;
import haqnawaz.org.navigationdrawer.tayah;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<tayah> ayahlist;

    public RecyclerViewAdapter(List<tayah> ayahlist) {
        this.ayahlist = ayahlist;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customizedview, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        tayah ayah=ayahlist.get(position);
        holder.UrduTextView.setText(ayah.getUrduTarajama());
        holder.EnglishTextView.setText(ayah.getEnlishTarjama());
        holder.ArabicTextView.setText(ayah.getArabicText());
    }

    @Override
    public int getItemCount() {
        return ayahlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView UrduTextView;
        TextView EnglishTextView;
        TextView ArabicTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UrduTextView = itemView.findViewById(R.id.urduTarjama);
            EnglishTextView = itemView.findViewById(R.id.englishTarjama);
            ArabicTextView = itemView.findViewById(R.id.ayah);
        }
    }
}
