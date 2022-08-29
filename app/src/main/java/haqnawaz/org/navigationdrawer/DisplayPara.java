package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayPara extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_para);
        lv= findViewById(R.id.ParaConsole);
        Intent intent=getIntent();
       String EnglishSurahName=(intent.getStringExtra("SurahUrduName"));
       DbHelper db=new DbHelper(this);
       int id=db.getSurahIdBySurahName(EnglishSurahName);
       ArrayList<tayah> ay =db.getSurah(id);
       CustomizedAdapter cA=new CustomizedAdapter(this,ay);
       lv.setAdapter(cA);


    }
}