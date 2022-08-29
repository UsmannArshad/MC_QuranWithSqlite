package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Searching extends AppCompatActivity {
EditText Input;
Button Search;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        Intent intent3= new Intent(Searching.this,SearchResult.class);
        Intent i=getIntent();
        String values=i.getStringExtra("Search");
        Input=findViewById(R.id.Input);
        Search=findViewById(R.id.Search);
        tv=findViewById(R.id.textView);
        switch (values){
            case "Search":

                break;
            case "ByParaNo":
                tv.setText("Enter Juzz number:");
                Input.setHint("Enter Para no(1-30)");

                    break;
            case "ByRukuNo":
                tv.setText("Enter Ruku Number:");
                Input.setHint("Enter Raku Number(1-558)");
                break;
            case "BySurahNo":
                tv.setText("Enter Surah No");
                Input.setHint("Number(1-114)");
                break;
        }
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=Input.getText().toString();


                intent3.putExtra("Input",input);
                intent3.putExtra("Search",values);
                startActivity(intent3);
            }
        });


    }
}