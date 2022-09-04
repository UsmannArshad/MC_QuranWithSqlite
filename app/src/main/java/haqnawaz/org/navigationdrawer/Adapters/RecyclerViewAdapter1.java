package haqnawaz.org.navigationdrawer.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import haqnawaz.org.navigationdrawer.BookActivity;
import haqnawaz.org.navigationdrawer.DisplayPara;
import haqnawaz.org.navigationdrawer.ItemClickListener;
import haqnawaz.org.navigationdrawer.R;
import haqnawaz.org.navigationdrawer.tayah;
import haqnawaz.org.navigationdrawer.tsurah;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {
    private Context context;
    List<String> surahlistarabic;
    List<String> surahlistenglish;
    private ItemClickListener clickListener;

    public RecyclerViewAdapter1(Context context,List<String> surahlistarabic,List<String> surahlistenglish,ItemClickListener itemClickListener) {
        this.surahlistarabic = surahlistarabic;
        this.surahlistenglish=surahlistenglish;
        this.context=context;
        this.clickListener=itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customizedsurahlist, parent, false);
        return new RecyclerViewAdapter1.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter1.ViewHolder holder, int position) {
        String arabicname=surahlistarabic.get(position);
        String englishname=surahlistenglish.get(position);
        holder.ArabicName.setText(arabicname);
        holder.EnglishName.setText(englishname);
    }
    @Override
    public int getItemCount() {
        return surahlistarabic.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ArabicName;
        TextView EnglishName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ArabicName = itemView.findViewById(R.id.arabicsurahname);
            EnglishName = itemView.findViewById(R.id.englishsurahname);
        }
        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.OnClick(view, getAdapterPosition());
        }
    }
}
