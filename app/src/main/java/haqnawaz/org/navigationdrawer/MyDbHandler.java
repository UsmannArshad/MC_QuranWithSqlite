package haqnawaz.org.navigationdrawer;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

class DbHelper extends SQLiteOpenHelper {

    private final static String DB_PATH = "/data/data/[YOUR PACKAGE HERE]/databases/";

   public String dbName="QuranDb.db";
    public Context mycontext;

    public File dbFile;

    public DbHelper(Context context) {
        super(context, "QuranDb.db", null, 2);
        this.mycontext = context;

        dbFile= new File(DB_PATH + dbName);
    }

    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {

        if(!dbFile.exists()){
            SQLiteDatabase db = super.getWritableDatabase();
            copyDataBase(db.getPath());
        }
        return super.getWritableDatabase();
    }

    @Override
    public synchronized SQLiteDatabase getReadableDatabase() {
        if(!dbFile.exists()){
            SQLiteDatabase db = super.getReadableDatabase();
            copyDataBase(db.getPath());
        }
        return super.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    private void copyDataBase(String dbPath){
        try{
            InputStream assestDB = mycontext.getAssets().open(dbName);

            OutputStream appDB = new FileOutputStream(dbPath,false);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = assestDB.read(buffer)) > 0) {
                appDB.write(buffer, 0, length);
            }

            appDB.flush();
            appDB.close();
            assestDB.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }





//    public void checkDb() {
//        SQLiteDatabase checkDb = null;
//        String filepath = dbPath + dbName;
//        try {
//            checkDb = SQLiteDatabase.openDatabase(filepath, null, 0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (checkDb != null) {
//            Toast.makeText(mcontext, "Database already exists", Toast.LENGTH_SHORT).show();
//        } else {
//            copyDatabase();
//        }
//    }

//    public void copyDatabase() {
//        this.getReadableDatabase();
//        try {
//            //Open your local db as the input stream
//            InputStream myinput = mcontext.getAssets().open(dbName);
//
//            // Path to the just created empty db
//            String outfilename = dbPath + dbName;
//
//            //Open the empty db as the output stream
//            OutputStream myoutput = new FileOutputStream(outfilename);
//
//            // transfer byte to inputfile to outputfile
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = myinput.read(buffer))>0) {
//                myoutput.write(buffer,0,length);
//            }
//
//            //Close the streams
//            myoutput.flush();
//            myoutput.close();
//            myinput.close();
//
//
//            Log.d("CopyDb", "DataBase Copied");
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("exception","copy");
//        }
//
//    }

//    public void OpenDatabase() {
//        String filepath = dbPath + dbName;
//        SQLiteDatabase.openDatabase(filepath, null, 0);
//    }


    //get surah name
    public ArrayList<String> getAllSurah() {
        SQLiteDatabase db=this.getReadableDatabase();
        String select_query="SELECT * FROM "+ " tsurah" ;
        //cursor maybe acts as cursor to table row at start it is at first row
        Cursor cursor=db.rawQuery(select_query,null);
        ArrayList<String> surahList=new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                if(cursor.getString(2)!=null)
                {
                    surahList.add(cursor.getString(4));
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        return surahList;
    }

    public int getSurahIdBySurahName(String name){
        SQLiteDatabase db=this.getReadableDatabase();
        String select_query="SELECT * FROM "+ " tsurah where SurahNameU= '"+name+"'" ;
        //cursor maybe acts as cursor to table row at start it is at first row
        Cursor cursor=db.rawQuery(select_query,null);
        int id=-1;
        if(cursor.moveToFirst()){


             id = cursor.getInt(0);


        }
        cursor.close();
        return id;
    }
    public ArrayList<tayah> SearchByRukuNo(String input)
    {
        int id= Integer.parseInt(input);
        ArrayList<tayah> t= new ArrayList<tayah>();
        SQLiteDatabase db=this.getReadableDatabase();
        String select_query="SELECT * FROM "+ "tayah where RakuID="+id;

        Cursor cursor=db.rawQuery(select_query,null);

        if(cursor.moveToFirst()){
            do {
                if(cursor!=null)
                {
                    tayah e= new tayah(cursor.getInt(0),cursor.getInt(1),cursor.getString(3),cursor.getString(4),cursor.getString(6),cursor.getInt(10),cursor.getInt(8));
                    t.add(e);

                }


            } while (cursor.moveToNext());
        }
        return t;
    }

    public ArrayList<tayah> SearchByParaNo(String input)
    {
        int id= Integer.parseInt(input);
        ArrayList<tayah> t= new ArrayList<tayah>();
        SQLiteDatabase db=this.getReadableDatabase();
        String select_query="SELECT * FROM "+ "tayah where ParaID="+id;

        Cursor cursor=db.rawQuery(select_query,null);

        if(cursor.moveToFirst()){
            do {
                if(cursor!=null)
                {

                    tayah e= new tayah(cursor.getInt(0),cursor.getInt(1),cursor.getString(3),cursor.getString(4),cursor.getString(6),cursor.getInt(10),cursor.getInt(8));
                    t.add(e);

                }


            } while (cursor.moveToNext());
        }
        return t;
    }


    public ArrayList<tayah> getSurah(int id){

        ArrayList<tayah> t= new ArrayList<tayah>();
        SQLiteDatabase db=this.getReadableDatabase();
        String select_query="SELECT * FROM "+ "tayah where SuraID="+id;

        Cursor cursor=db.rawQuery(select_query,null);

        if(cursor.moveToFirst()){
            do {
                if(cursor!=null)
                {
                    tayah e= new tayah(cursor.getInt(0),cursor.getInt(1),cursor.getString(3),cursor.getString(4),cursor.getString(6),cursor.getInt(10),cursor.getInt(8));
                    t.add(e);

                }


            } while (cursor.moveToNext());
        }
        return t;
    }
    public ArrayList<tayah> Search(String input)
    {
        ArrayList<tayah> t= new ArrayList<tayah>();
        SQLiteDatabase db=this.getReadableDatabase();
        String select_query="SELECT * FROM "+ "tayah where FatehMuhammadJalandhrield Like '%"+input +"%' OR DrMohsinKhan LIKE '%"+input +"%' OR ArabicText LIKE '%"+input+"%'";
        Log.d("input", input);
//        ArabicNormalizer an= new ArabicNormalizer(input);
//        input=an.getOutput();
        Cursor cursor=db.rawQuery(select_query,null);
        int count=0;
        if(cursor.moveToFirst()){
            do {
                if(cursor!=null)
                {
                    tayah e= new tayah(cursor.getInt(0),cursor.getInt(1),cursor.getString(3),cursor.getString(4),cursor.getString(6),cursor.getInt(10),cursor.getInt(8));
                    t.add(e);

                }
                Log.d("count", String.valueOf(count));
                count++;

            } while (cursor.moveToNext());
        }
        return t;
    }

}
