package com.rezaie.effortlessengapp.Utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.lifecycle.ProcessLifecycleOwner;

public class DbHelper extends SQLiteOpenHelper {


    private static final String DB_NAME="effortless_app.db";

    private static final String LESSON_TABLE = "LESSON_TABLE";
    private static final String LESSON_ID = "ID";
    private static final String TITLE = "TITLE";
    private static final String LEVEL = "LEVEL";
    private static final String TEXT = "TEXT";
    private static final String AUDIO_FILE = "AUDIO";
    private static final String VOCAB_FILE = "VOCAB";
    private static final String M_S_FILE = "MS";
    private static final String COMMENTARY_FILE = "COMMENTARY";
    private static final String POV_FILE = "POV";


    private static final String WORD_TABLE = "WORD_TABLE";
    private static final String WORD_ID = "ID";
    private static final String WORD_WORD = "WORD";
    private static final String WORD_TRANSLATE = "WORD_TRANS";
    private static final String WORD_LESSON_ID = "LESSON_ID";
    private static final String WORD_ENGLISH_MEANING = "ENG_MEANING";
    private static final String WORD_ENG_MEANING_TRANSLATE = "ENG_MEANING_TRANS";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, DB_NAME, null, 1, errorHandler);
}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_lesson_table= "CREATE TABLE " +
                LESSON_TABLE + " ( " +
                LESSON_ID + " INT PRIMARY KEY AUTOINCREMENT, " +
                TITLE + " VARCHAR(30) ," +
                LEVEL + " VARCHAR(15) , " +
                TEXT + " TEXT , " +
                AUDIO_FILE + " TEXT , " +
                VOCAB_FILE + " TEXT , " +
                COMMENTARY_FILE + " TEXT , " +
                M_S_FILE + " TEXT , " +
                POV_FILE + " TEXT )";
        db.execSQL(create_lesson_table);

        String create_word_table="CREATE TABLE " +
                WORD_TABLE +"(" +
                WORD_ID +"INT PRIMARY KEY AUTOINCREMENT, "+
                WORD_WORD + " VARCHAR , " +
                WORD_TRANSLATE + " VARCHAR , " +
                WORD_ENGLISH_MEANING + " TEXT , " +
                WORD_ENG_MEANING_TRANSLATE + " TEXT ," +
                WORD_LESSON_ID + " INT , " +
                " FOREIGN KEY ("+ WORD_LESSON_ID +") REFERENCES " + LESSON_TABLE +"("+ LESSON_ID +"))";
        db.execSQL(create_word_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + LESSON_TABLE);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + WORD_TABLE);
        onCreate(db);

    }
    public void addAll(){

    }

}
