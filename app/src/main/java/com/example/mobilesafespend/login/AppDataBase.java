package com.example.mobilesafespend.login;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class AppDataBase extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final String DB_NAME = "MVC.sqlite";
    private static final int version = 1;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, version);
        db = getWritableDatabase();
        boolean retorno = false;

    }

    public boolean insert (String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            e.getMessage();
        }

        return retorno;
    }
    public boolean checkUserPassword (String username,String password){
        db = getWritableDatabase();
        boolean retorno = false;
        Cursor cursor = db.rawQuery("SELECT *FROM " + UsuarioDataModel.TABELA + " WHERE username = ? " +
                " AND password = ? ", new String[] {username, password});

        return cursor.getCount() > 0;
    }
    public boolean checkUser (String username){
        db =getWritableDatabase();
        boolean retorno = false;
        Cursor cursor = db.rawQuery(" SELECT * FROM " + UsuarioDataModel.TABELA + "  WHERE email = ? ",  new String[]{username} );
        return cursor.getCount() > 0;
    }

        @Override
        public void onCreate (SQLiteDatabase db){
            db.execSQL(UsuarioDataModel.criarTabela());
        }

        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + UsuarioDataModel.TABELA);
            onCreate(db);
        }


    public abstract Usuario buscar(int id);
}