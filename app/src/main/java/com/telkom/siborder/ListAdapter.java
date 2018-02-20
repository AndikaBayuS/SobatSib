package com.telkom.siborder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andika Bayu Santoso on 15/02/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListAdapterHolder> {
    private  ArrayList<ListItem> mListItem;
    private OnItemClickListener mListener;
    private Context context;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    
    public static class ListAdapterHolder extends RecyclerView.ViewHolder {
        private final Context context;
        public TextView mTextView1;
        public TextView mTextView2;

        public ListAdapterHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            context = itemView.getContext();
            mTextView1 = itemView.findViewById(R.id.title);
            mTextView2 = itemView.findViewById(R.id.info);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Intent intent;
                    switch (getAdapterPosition()){
                        case 0:
                            intent =  new Intent(context, MainActivity.class);
                            break;
                        case 1:
                            intent = new Intent(context, MainActivity.class);
                            break;
                        default:
                            intent =  new Intent(context, OngoingActivity.class);
                            break;
                    }
                    context.startActivity(intent);
                }
            });
        }
    }

    public ListAdapter(ArrayList<ListItem> itemlist) {
        mListItem = itemlist;
    }

    @Override
    public ListAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ListAdapterHolder evh = new ListAdapterHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ListAdapterHolder holder, int position) {
        ListItem currentItem = mListItem.get(position);

        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }
}
