package com.example.recycler_search_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference ref;
    SearchView searchView;
    MyAdapter adapter;
    RecyclerView recyclerView;
    EditText nameEditTxt,propTxt,descTxt;
ArrayList<Deal> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref = FirebaseDatabase.getInstance().getReference("Stock").child("User");
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView = findViewById(R.id.search_view);
}

    @Override
    protected void onStart() {
        super.onStart();
    if(ref != null){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    list = new ArrayList<Deal>();
                    //Deal pp = dataSnapshot.getValue(Deal.class);
                    //list.add(pp);
                   for(DataSnapshot ds : dataSnapshot.getChildren() ){
                       Deal dl =dataSnapshot.getValue(Deal.class);
              list.add(dl);}
                    MyAdapter Adaptor= new MyAdapter(list);
                   recyclerView.setAdapter(Adaptor);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Error to fatch", Toast.LENGTH_SHORT).show();
            }
        });
    }
    if(searchView != null){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search(newText);
                return true;
            }
        });
    }

    }

    private void search(String sr) {
        ArrayList<Deal> mylist = new ArrayList<>();
        for(Deal object : list){
if(object.getPro_name().toLowerCase().contains(sr.toLowerCase())){
    mylist.add(object);
}
        }
        MyAdapter adapter = new MyAdapter(mylist);
        recyclerView.setAdapter(adapter);
    }
}
