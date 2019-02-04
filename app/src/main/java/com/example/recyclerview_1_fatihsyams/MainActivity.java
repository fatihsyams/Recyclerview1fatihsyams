package com.example.recyclerview_1_fatihsyams;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    RecyclerView rv_horizontal;
    BuahAdapter adapter;

    RecyclerView rv_horizontalA;
    BuahAdapter adapterA;



    String[] NamaBuah = {"Apel", "Jeruk", "Mangga", "Pisang"};
    int[] GambarBuah = {R.drawable.apel, R.drawable.jeruk, R.drawable.mangga, R.drawable.pisang};

    String[] NamaBuahS = {"Apel", "Jeruk", "Mangga", "Pisang"};
    int[] GambarBuahS = {R.drawable.apel, R.drawable.jeruk, R.drawable.mangga, R.drawable.pisang};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new BuahAdapter();
        adapterA = new BuahAdapter();

        rv_horizontal = findViewById(R.id.rv_horizontal);
        rv_horizontal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, true));
        rv_horizontal.setAdapter(adapter);

        rv_horizontalA = findViewById(R.id.rv_vertikal);
        rv_horizontalA.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, true));
        rv_horizontalA.setAdapter(adapterA);
    }

    class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MyViewHolder> {
        @NonNull
        @Override
        public BuahAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jenis_buah_horizontal, viewGroup , false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull BuahAdapter.MyViewHolder myViewHolder, int i) {
            myViewHolder.txt_nama.setText( NamaBuah[i]);
            myViewHolder.img_horizontal.setImageResource( GambarBuah[i]);
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Kamu Memilih "+ NamaBuah , Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount()  {
            return NamaBuah.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView img_horizontal;
            TextView txt_nama;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                img_horizontal = itemView.findViewById(R.id.img_horizontal);
                txt_nama = itemView.findViewById(R.id.txt_nama);

            }
        }
    }
}
