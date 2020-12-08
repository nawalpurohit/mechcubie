package com.example.mechcubie;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.Viewholder> {


    private List<String> myData;

    Context context;
    public SecondAdapter( List<String> myData) {
        this.myData = myData;
    }

    @NonNull
    @Override
    public SecondAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item1,parent,false);
        SecondAdapter.Viewholder viewHolder=new SecondAdapter.Viewholder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SecondAdapter.Viewholder holder, final int position) {

        holder.tv_name.setText(myData.get(position));

        holder.setIsRecyclable(false);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment secondFragment = new FirstFragment();
                Bundle args = new Bundle();
                args.putString("data", myData.get(position));
                args.putInt("pos", position);
                secondFragment.setArguments(args);

                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame, secondFragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        public TextView tv_id,tv_name;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.name);
        }
    }

}
