package com.example.finaltest;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finaltest.adapter.SinhVienAdapter;
import com.example.finaltest.database.Database;
import com.example.finaltest.model.SinhVien;

import java.util.ArrayList;


public class Act2FragBot extends Fragment {

    RecyclerView recyclerView;
    ArrayList<SinhVien> list = new ArrayList<>();
    Database database;
    SinhVienAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_act2_frag_bot, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.fragbot_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SinhVienAdapter(getContext(), R.layout.fragbot_item_view, list);
        initView();
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void initView() {
        list = new ArrayList<>();
        database = new Database(getActivity());

        Cursor datasinhvien = database.GetData("SELECT * FROM SINHVIEN");
        list.clear();
//        while (datasinhvien.moveToNext()) {
//            String a = datasinhvien.getString(0);
//            String b = datasinhvien.getString(1);
//            String c = datasinhvien.getString(2);
//            list.add(new SinhVien(a, b, c));
//        }
        adapter.notifyDataSetChanged();
    }
}
