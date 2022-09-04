package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import haqnawaz.org.navigationdrawer.Adapters.RecyclerViewAdapter;

public class DisplayPara extends AppCompatActivity {
/*    ListView lv;*/
    List<tayah> ayahList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_para);
/*        lv= findViewById(R.id.ParaConsole);
        Intent intent=getIntent();
       String EnglishSurahName=(intent.getStringExtra("SurahUrduName"));
       DbHelper db=new DbHelper(this);
       int id=db.getSurahIdBySurahName(EnglishSurahName);
       ArrayList<tayah> ay =db.getSurah(id);
       CustomizedAdapter cA=new CustomizedAdapter(this,ay);
       lv.setAdapter(cA);*/
        Intent intent=getIntent();
        String EnglishSurahName=(intent.getStringExtra("SurahUrduName"));
        int englishtranslatorid=Integer.parseInt(intent.getStringExtra("EnglishTranslatorId"));
        int urdutranslatorid=Integer.parseInt(intent.getStringExtra("UrduTranslatorId"));
        DbHelper db=new DbHelper(this);
        int id=db.getSurahIdBySurahName(EnglishSurahName);
        ayahList=db.getSurah(id,urdutranslatorid,englishtranslatorid);
        recyclerView=findViewById(R.id.recycleview1);

        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        // layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(DisplayPara.this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(ayahList) ;
        recyclerView.setAdapter(adapter);

    }
}