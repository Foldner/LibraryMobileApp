package me.foldner.libapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.foldner.libapp.adapter.BookAdapter;
import me.foldner.libapp.model.Book;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    RecyclerView bookRecycler;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
//        db.addBook("Гарри Поттер 1", "Джоан Роулинг");

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "cover_harry_potter_1", "Гарри Поттер 1", "Джоан Роулинг"));
        bookList.add(new Book(2, "cover_harry_potter_2", "Гарри Поттер 2", "Джоан Роулинг"));
        bookList.add(new Book(3, "cover_harry_potter_3", "Гарри Поттер 3", "Джоан Роулинг"));
        bookList.add(new Book(4, "cover_harry_potter_4", "Гарри Поттер 4", "Джоан Роулинг"));
        bookList.add(new Book(5, "cover_harry_potter_5", "Гарри Поттер 5", "Джоан Роулинг"));
        bookList.add(new Book(6, "cover_harry_potter_6", "Гарри Поттер 6", "Джоан Роулинг"));
        bookList.add(new Book(6, "cover_harry_potter_7", "Гарри Поттер 7", "Джоан Роулинг"));

        setBookRecycler(bookList);
    }

    private void setBookRecycler(List<Book> bookList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        bookRecycler = findViewById(R.id.noveltiesRecycler);
        bookRecycler.setLayoutManager(layoutManager);

        bookAdapter = new BookAdapter(this, bookList);
        bookRecycler.setAdapter(bookAdapter);
    }
}