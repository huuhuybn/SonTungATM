package com.example.finaltest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finaltest.R;
import com.example.finaltest.model.Lop;

import java.util.ArrayList;
import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.ViewHolder> {
    Context context;
    int layout;
    List<Lop> lopList;

    public LopAdapter (Context context, int layout, ArrayList<Lop> lopList){
        this.context = context;
        this.layout = layout;
        this.lopList = lopList;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragtop_item_view,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LopAdapter.ViewHolder holder, int position) {
        holder.MaLop.setText(lopList.get(position).getMaLop());
    }

    @Override
    public int getItemCount() {
        return lopList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView MaLop;
        public ImageView MaLopXoa;

        public ViewHolder(View itemView) {
            super(itemView);
            MaLop = itemView.findViewById(R.id.fragtop_tv);
            MaLopXoa = itemView.findViewById(R.id.fragtop_img);
        }
    }
}
