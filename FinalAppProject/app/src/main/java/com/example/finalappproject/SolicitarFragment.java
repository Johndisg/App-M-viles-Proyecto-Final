package com.example.finalappproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalappproject.DetallesSuperheroeActivity;
import com.example.finalappproject.R;
import com.example.finalappproject.Superheroe;

import java.util.ArrayList;
import java.util.List;

public class SolicitarFragment extends Fragment {

    private RecyclerView recyclerView;
    private SuperheroesAdapter adapter;
    private List<Superheroe> superheroeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_solicitar, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        superheroeList = new ArrayList<>();
        adapter = new SuperheroesAdapter(superheroeList, new SuperheroesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Superheroe superheroe) {
                Intent intent = new Intent(getContext(), DetallesSuperheroeActivity.class);
                intent.putExtra("superheroe", superheroe);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}

