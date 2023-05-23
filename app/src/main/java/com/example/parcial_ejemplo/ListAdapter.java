package com.example.parcial_ejemplo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements View.OnClickListener{
    private List<Item> lData;
    private LayoutInflater layoutInflater;
    private Context context;

    private View.OnClickListener listener;
    public ListAdapter(List<Item> listItem, Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.lData = listItem;
    }

    @Override
    public int getItemCount(){
        return lData.size();
    }
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = layoutInflater.inflate(R.layout.fragment_list,null);
        view.findViewById(R.id.buttonNext).setOnClickListener(this);
        return new ListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(lData.get(position));
    }
    public void setItems(List<Item> items){
        lData = items;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, sale,status;
        ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            sale = itemView.findViewById(R.id.sale);
            status = itemView.findViewById(R.id.state);
        }
        void bindData(final Item item){
            name.setText(item.getName());
            sale.setText(item.getSale().toString());
            status.setText(item.getStatus());
        }
    }
}
