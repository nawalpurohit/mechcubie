package com.example.mechcubie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment  extends Fragment {

    RecyclerView recyclerView;

    List<String> list=new ArrayList<>();
    String value="";
    int pos=0;
    public FirstFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        try {
            value = "Data added -"+getArguments().getString("data");
            pos = getArguments().getInt("pos");
        } catch (Exception e) {
            e.printStackTrace();
        }
               list.add("Suresh");
                list.add("Raman");
                list.add("Amardeep");
                list.add("Shukwinder");
                list.add("Naresh");
                list.add("Salman");
                list.add("Aamir");
                list.add(pos,value);


        recyclerView=view.findViewById(R.id.rec_first);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        FirstAdapter firstAdapter=new FirstAdapter(list);
        recyclerView.setAdapter(firstAdapter);
        return view;
    }
}
