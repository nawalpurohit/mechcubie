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

public class SecondFragment extends Fragment implements senddata {

    List<String > myData=new ArrayList<>();
    RecyclerView recyclerView;
    String value="";
    int pos=0;
    public SecondFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_two,container,false);

        try {
            value = "Data added - "+getArguments().getString("data");
            pos= getArguments().getInt("pos");
        } catch (Exception e) {
            e.printStackTrace();
        }

        myData.add("Kamlesh");
        myData.add("Akshay");
        myData.add("Manpreet");
        myData.add("Saurav");
        myData.add("Baharat");
        myData.add("Nivesh");
        myData.add("Bipin");
        myData.add(pos,value);


        recyclerView=view.findViewById(R.id.rec_second);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        SecondAdapter secondAdapter=new SecondAdapter(myData);
        recyclerView.setAdapter(secondAdapter);
        return view;
    }

    @Override
    public void sendData(String data) {

    }
}
