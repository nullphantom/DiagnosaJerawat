package io.github.nullphantom.diagnosajerawat.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.nullphantom.diagnosajerawat.R;
import io.github.nullphantom.diagnosajerawat.about.Data;
import io.github.nullphantom.diagnosajerawat.about.DataAdapter;

public class About extends AppCompatActivity {

    private ListView listView;
    private View parentView;

    private ArrayList<Data> contactList;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        contactList = new ArrayList<>();

        contactList.add(tambah("Aldian Wahyu Septiadi", "F1D015005", "aldianwahyu78@gmail.com", "bintang"));
        contactList.add(tambah("Ilham Bintang", "F1D015035", "ilhambintanginformatika@gmail.com", "aldian"));
        contactList.add(tambah("Nurhalimah", "F1D015063", "nurh5h@gmail.com", "halimah"));
        contactList.add(tambah("Ririn Perwitasari", "F1D015075", "ririnperwita@gmail.com", "g01"));
        contactList.add(tambah("Rosida Apriani", "F1D015079", "ocioci@gmail.com", "g01"));

        parentView = findViewById(R.id.parentLayout);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String teks = "NIM   : " + contactList.get(i).getNim() + "\nEmail : " + contactList.get(i).getEmail();
                Snackbar mySnackbar = Snackbar.make(view, teks, Snackbar.LENGTH_SHORT);
                mySnackbar.show();

            }
        });
        adapter = new DataAdapter(this, contactList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent i =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
    public Data tambah(String nama, String nim, String email, String gambar) {
        Data x = new Data();
        x.setNama(nama);
        x.setNim(nim);
        x.setEmail(email);
        x.setGambar(gambar);
        return x;
    }
}
