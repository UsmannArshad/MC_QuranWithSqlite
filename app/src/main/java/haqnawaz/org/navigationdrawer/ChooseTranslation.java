package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChooseTranslation extends AppCompatActivity {
    RadioGroup radioGroup,radioGroup1;
    RadioButton urduradiobutton,englishradiobutton;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_translation);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup1=findViewById(R.id.radiogroup1);
        button=findViewById(R.id.proceedbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedIdUrdu=radioGroup1.getCheckedRadioButtonId();
                int selectedIdEnglish=radioGroup.getCheckedRadioButtonId();
                urduradiobutton=findViewById(selectedIdUrdu);
                englishradiobutton=findViewById(selectedIdEnglish);
                Intent intent=new Intent(ChooseTranslation.this,BookActivity.class);
                intent.putExtra("UrduTranslator",urduradiobutton.getText().toString());
                intent.putExtra("EnglishTranslator",englishradiobutton.getText().toString());
                startActivity(intent);
            }
        });
    }
}