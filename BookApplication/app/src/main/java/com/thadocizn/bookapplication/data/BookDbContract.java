package com.thadocizn.bookapplication.data;

import android.provider.BaseColumns;

public class BookDbContract {
    public static class BookEntry implements BaseColumns{

        public static final String TABLE_NAME_BOOKSHELF = "bookshelf";

        public static final String COLUMN_NAME_BOOKSHELF = "shelf_name";
        public static final String COLUMN_NAME_BOOK_ID   = "book_id";
        public static final String COLUMN_NAME_TAG_ID    = "tag_id";

        public static final String SQL_CREATE_TABLE_BOOKSHELF = "CREATE TABLE " + TABLE_NAME_BOOKSHELF +
                " ( " +
                _ID + " TEXT PRIMARY KEY, " +
                COLUMN_NAME_BOOKSHELF + " TEXT, " +
                COLUMN_NAME_BOOK_ID + " INTEGER, " +
                COLUMN_NAME_TAG_ID + " INTEGER);";

        public static final String TABLE_NAME_TAG = "tags";

        public static final String COLUMN_NAME_TAG = "tag_name";

        public static final String SQL_CREATE_TABLE_TAG = "CREATE TABLE " + TABLE_NAME_TAG +
                " ( " +
                _ID + " TEXT PRIMARY KEY, " +
                COLUMN_NAME_TAG + " TEXT );";


        public static final String TABLE_NAME_BOOK = "books";

        public static final String COLUMN_NAME_BOOK_TITLE             = "title";
        public static final String COLUMN_NAME_BOOK_IMAGE_URL         = "image";
        public static final String COLUMN_NAME_BOOK_REVIEW       = "review";
        public static final String COLUMN_NAME_READ_BOOK         = "read_book";

        public static final String  SQL_CREATE_TABLE_BOOK = "CREATE TABLE " + TABLE_NAME_BOOK +
                " ( " +
                _ID + " TEXT PRIMARY KEY, " +
                COLUMN_NAME_BOOK_TITLE + " TEXT, " +
                COLUMN_NAME_BOOK_IMAGE_URL + " TEXT, " +
                COLUMN_NAME_BOOK_REVIEW + " TEXT, " +
                COLUMN_NAME_READ_BOOK + " INTEGER);";

        public static final String SQL_DELETE_TABLE_BOOK = "DROP TABLE IF EXISTS " + TABLE_NAME_BOOK + ";";
        public static final String SQL_DELETE_TABLE_TAG = "DROP TABLE IF EXISTS " + TABLE_NAME_TAG + ";";
        public static final String SQL_DELETE_TABLE_BOOKSHELF = "DROP TABLE IF EXISTS " + TABLE_NAME_BOOKSHELF + ";";
    }
}
