package com.dani.missionhewan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ListHewanAdapter extends RecyclerView.Adapter<ListHewanAdapter.ListViewHolder> {
    private Context context;
    private List<DataHewan> data;
    RequestOptions option;

    public ListHewanAdapter(Context context, List<DataHewan> data) {
        this.context = context;
        this.data = data;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        final LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_row_hewan, viewGroup, false);
        final ListViewHolder vh = new ListViewHolder(view);
        vh.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsHewan.class);
                intent.putExtra("DataHewan_nama", data.get(vh.getAdapterPosition()).getName());
                intent.putExtra("DataHewan_pengertian", data.get(vh.getAdapterPosition()).getPenjelasan());
                intent.putExtra("DataHewan_sumber", data.get(vh.getAdapterPosition()).getSumber_dari());
                intent.putExtra("DataHewan_img", data.get(vh.getAdapterPosition()).getImages());

                context.startActivity(intent);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int pos) {
        holder.tv_nama.setText(data.get(pos).getName());
        holder.tv_pengertian.setText(data.get(pos).getPenjelasan());
        holder.tv_sumber.setText(data.get(pos).getSumber_dari());

        Glide.with(context).load(data.get(pos).getImages()).apply(option).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nama;
        TextView tv_pengertian;
        TextView tv_sumber;
        ImageView img;
        LinearLayout view_container;

        public ListViewHolder(View view) {
            super(view);

            view_container = view.findViewById(R.id.container);
            tv_nama = view.findViewById(R.id.tv_item_name);
            tv_pengertian = view.findViewById(R.id.tv_item_pengertian);
            tv_sumber = view.findViewById(R.id.tv_item_sumber);
            img = view.findViewById(R.id.img);
        }
    }
}
