package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import haqnawaz.org.navigationdrawer.Adapters.RecyclerViewAdapter;
import haqnawaz.org.navigationdrawer.Adapters.RecyclerViewAdapter1;

public class BookActivity extends AppCompatActivity implements ItemClickListener {
    List<String> surahlistenglish = new ArrayList<>();
    List<String> surahlistarabic=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    int urdutranslatorid;
    int englishtranslatorid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Intent intent=getIntent();
        String urdutranslator=intent.getStringExtra("UrduTranslator").toString();
        String englishtranslator=intent.getStringExtra("EnglishTranslator");
        if(urdutranslator.contains("FatehMuhammadJalandhrield"))
        {
            urdutranslatorid=4;
        }
        else
        {
            urdutranslatorid=5;
        }
        if(englishtranslator.contains("DrMohsinKhan"))
        {
            englishtranslatorid=6;
        }
        else
        {
            englishtranslatorid=7;
        }
        DbHelper db = new DbHelper(BookActivity.this);
        surahlistarabic = db.getAllSurahArabic();
        surahlistenglish = db.getAllSurahEnglish();
        recyclerView = findViewById(R.id.recycleview);

        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        // layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(BookActivity.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new RecyclerViewAdapter1(BookActivity.this,surahlistarabic, surahlistenglish,this);
        recyclerView.setAdapter(adapter);
/*        ArrayAdapter<String> AA= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,surahNames);
        lv.setAdapter(AA);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(BookActivity.this,DisplayPara.class);
                intent.putExtra("SurahUrduName",surahNames.get(i));
                startActivity(intent);
            }
        });*/
    }
    @Override
    public void OnClick(View view, int position)
    {
        String arabicname=surahlistarabic.get(position);
        Intent i=new Intent(BookActivity.this,DisplayPara.class);
        i.putExtra("SurahUrduName",arabicname);
        i.putExtra("EnglishTranslatorId",String.valueOf(englishtranslatorid));
        i.putExtra("UrduTranslatorId",String.valueOf(urdutranslatorid));
        startActivity(i);
    }
}