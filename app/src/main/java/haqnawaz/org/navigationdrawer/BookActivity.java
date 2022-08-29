package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BookActivity extends AppCompatActivity {
    ListView lv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        DbHelper db= new DbHelper(BookActivity.this);
        lv=findViewById(R.id.SurahNames);
        List<String> surahNames=  db.getAllSurah();
        ArrayAdapter<String> AA= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,surahNames);
        lv.setAdapter(AA);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(BookActivity.this,DisplayPara.class);
                intent.putExtra("SurahUrduName",surahNames.get(i));
                startActivity(intent);
            }
        });

    }
}