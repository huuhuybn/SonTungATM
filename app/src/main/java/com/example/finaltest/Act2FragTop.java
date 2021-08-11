package com.example.finaltest;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finaltest.adapter.LopAdapter;
import com.example.finaltest.database.Database;
import com.example.finaltest.model.Lop;

import java.util.ArrayList;
import java.util.List;

public class Act2FragTop extends Fragment {
    private View rootview;
    RecyclerView recyclerView;
    ArrayList<Lop> lopList;
    LopAdapter lopAdapter;
    Database database;

    public Act2FragTop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        View view =inflater.inflate(R.layout.fragment_act2_frag_top, container, false);
        recyclerView =(RecyclerView) view.findViewById(R.id.fragtop_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        lopAdapter = new LopAdapter(getContext(),R.layout.fragtop_item_view,lopList);
        initView();
        recyclerView.setAdapter(lopAdapter);
        return rootview;
    }

    private void initView(){

        lopList = new ArrayList<>();
        database = new Database(getActivity());
        Cursor datalop = database.GetData("SELECT * FROM LOP");
        lopList.clear();
//        while (datalop.moveToNext()){
//            String a = datalop.getString(0);
//            lopList.add(new Lop(a));
//        }
        lopAdapter.notifyDataSetChanged();
    }
}
