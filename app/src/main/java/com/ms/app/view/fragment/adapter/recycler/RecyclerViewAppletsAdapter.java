package com.ms.app.view.fragment.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.ms.app.R;

public class RecyclerViewAppletsAdapter extends RecyclerView.Adapter<RecyclerViewAppletsAdapter.Holder> {

    private Context context;


    public RecyclerViewAppletsAdapter(Context context) {
        this.context = context;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_applets_adapter,parent));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView textViewType;
        private GridView gridViewApplets;

        public Holder(View itemView) {
            super(itemView);
            textViewType = itemView.findViewById(R.id.textViewType);
            gridViewApplets = itemView.findViewById(R.id.gridViewApplets);
        }
    }
}
