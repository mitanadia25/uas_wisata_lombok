package com.mitanadia.wisatalombok;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mitanadia.wisatalombok.model.WisataLombok;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnTambahWisata;
    TextView txNoData;
    ListView lvDaftarWisata;
    DaftarWisataAdapter adapter;
    List<WisataLombok> daftarWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inisialisasiView();
        loadDataWisata();
        setupListview();
    }

    private void inisialisasiView() {
        btnTambahWisata = findViewById(R.id.fabAddDestination);
        btnTambahWisata.setOnClickListener(view -> bukaFormTambahWisata());
        lvDaftarWisata = findViewById(R.id.lv_wisata_lombok);
        txNoData = findViewById(R.id.tx_nodata);
    }

    private void setupListview() {
        adapter = new DaftarWisataAdapter(this, daftarWisata);
        lvDaftarWisata.setAdapter(adapter);
    }

    private void loadDataWisata() {
        daftarWisata = SharedPreferenceUtility.getAllWisata(this);
        if (daftarWisata.size() > 0) {
            txNoData.setVisibility(View.GONE);
        } else {
            txNoData.setVisibility(View.VISIBLE);
        }

    }

    private void refreshListView() {
        adapter.clear();
        loadDataWisata();
        adapter.addAll(daftarWisata);
    }

    private void bukaFormTambahWisata() {
        Intent intent = new Intent(this, FormWisataActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}