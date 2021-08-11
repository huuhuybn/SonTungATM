package com.example.finaltest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaltest.R;
import com.example.finaltest.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {
    Context context;
    int layout;
    ArrayList<SinhVien> sinhViens;


    public SinhVienAdapter(Context context,int layout,ArrayList<SinhVien> sinhViens){
        this.context = context;
        this.layout=layout;
        this.sinhViens = sinhViens;
    }





    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragbot_item_view,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SinhVienAdapter.ViewHolder holder, int position) {
        holder.mamon.setText(sinhViens.get(position).getMaMon());
        holder.masv.setText(sinhViens.get(position).getMaSV());
        holder.diem.setText(sinhViens.get(position).getDiem());
    }






    @Override
    public int getItemCount() {
        return sinhViens.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
       public TextView mamon,masv,diem;

        public ViewHolder(View itemView) {
            super(itemView);
            mamon = itemView.findViewById(R.id.fragbot_mamon);
            masv = itemView.findViewById(R.id.fragbot_masv);
            diem = itemView.findViewById(R.id.fragbot_diem);
        }
    }
}
