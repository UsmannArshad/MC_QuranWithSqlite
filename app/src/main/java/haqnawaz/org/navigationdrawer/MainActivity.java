package haqnawaz.org.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else
        {
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper d= new DbHelper(MainActivity.this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_Quran:
                        Intent intent = new Intent(MainActivity.this, BookActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_return :
                        Intent intent2 = new Intent(MainActivity.this, Searching.class);
                        intent2.putExtra("Search","Search");
                        startActivity(intent2);
                        break;
                    case R.id.nav_SearchByParaNo:
                        Intent intent3 = new Intent(MainActivity.this, Searching.class);
                        intent3.putExtra("Search","ByParaNo");
                        startActivity(intent3);
                        break;
                    case R.id.nav_SearchBySurahNo:
                        Intent intent5 = new Intent(MainActivity.this, Searching.class);
                        intent5.putExtra("Search","BySurahNo");
                        startActivity(intent5);
                        break;

                }

                return true;
            }
        });




    }
}