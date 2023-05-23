package com.example.parcial_ejemplo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class ViewItemFragment extends Fragment {

    List<Item> elements;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_item, container, false);

        Bundle bundle = getArguments();
        elements = new ArrayList<>();
        if (bundle != null) {
            String data = bundle.getString("data");
            Gson gson = new Gson();
            Item item = gson.fromJson(data, Item.class);
            elements.add(item);

            ListAdapter listAdapter = new ListAdapter(elements,view.getContext());
            RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(listAdapter);

            listAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),DetailItem.class);
                    intent.putExtra("code",item.getCode());
                    intent.putExtra("name",item.getName());
                    intent.putExtra("stock",item.getStock());
                    intent.putExtra("sale",item.getSale());
                    intent.putExtra("size",item.getSize());
                    intent.putExtra("description",item.getDescription());
                    startActivity(intent);
                }
            });
        }

        return view;
    }
}