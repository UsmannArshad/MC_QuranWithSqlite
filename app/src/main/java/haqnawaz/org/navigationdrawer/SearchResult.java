package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchResult extends AppCompatActivity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        Intent i=getIntent();
        String values=i.getStringExtra("Search");
        String Input=i.getStringExtra("Input");
        DbHelper db= new DbHelper(this);
        ArrayList<tayah> Results=new ArrayList<tayah>();
        switch (values){
            case "Search":
              Results=db.Search(Input);
                break;
            case "ByParaNo":
                Results=db.SearchByParaNo(Input);

                break;
            case "ByRukuNo":
                Results=db.SearchByRukuNo(Input);
                break;
            case "BySurahNo":
                Results=db.getSurah(Integer.parseInt(Input));
                break;
        }


        CustomizedAdapter cA= new CustomizedAdapter(this,Results);

        lv= findViewById(R.id.SearchingPannel);
        lv.setAdapter(cA);

    }
}