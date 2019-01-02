package com.example.jacob.android_projectweek1_googlebooks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FirebaseDao {

    public static void MonitorBooks() {
        ArrayList<Bookshelf> bookshelves = new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_BOOKS);
        ValueEventListener dbListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Bookshelf bookshelf = dataSnapshot.getValue(Bookshelf.class);
                BookshelfDbDao.updateBookshelf(bookshelf);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        reference.addValueEventListener(dbListener);
    }

    public static void createBook(Book book) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(Constants.FIREBASE_BOOKS);
        reference.child(book.getId()).setValue(book);
    }

    public static void deleteBook(Book book) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(Constants.FIREBASE_BOOKS);
        reference.child(book.getId()).removeValue();
    }

    public static void deleteBook(String id) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(Constants.FIREBASE_BOOKS);
        reference.child(id).removeValue();
    }

    public static void createBookshelf(Bookshelf bookshelf) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(Constants.FIREBASE_BOOKSHELVES);
        reference.child(String.valueOf(bookshelf.getId())).setValue(bookshelf);
    }

    public static void deleteBookshelf(Bookshelf bookshelf) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(Constants.FIREBASE_BOOKSHELVES);
        reference.child(String.valueOf(bookshelf.getId())).removeValue();
    }

    public static void deleteBookshelf(int bookshelfId) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(Constants.FIREBASE_BOOKSHELVES);
        reference.child(String.valueOf(bookshelfId)).removeValue();
    }

    public static void updateBookshelf(Bookshelf bookshelf) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference(Constants.FIREBASE_BOOKSHELVES).child(String.valueOf(bookshelf.getId()));
        reference.child("books").setValue(bookshelf.getBooks());
    }
}
