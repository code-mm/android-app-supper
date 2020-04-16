package com.ms.app.view.fragment.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.bdlbsc.common.applets.AppletsItem;
import com.bdlbsc.common.applets.AppletsType;
import com.bdlbsc.common.applets.AppletssRequest;
import com.bdlbsc.common.applets.AppletssResponse;
import com.ms.app.R;
import com.ms.app.view.fragment.adapter.gridview.GridViewAppletsAdapter;

import java.util.List;

public class RecyclerViewAppletsAdapter extends RecyclerView.Adapter<RecyclerViewAppletsAdapter.ViewHolder> {


    public interface OnItemClickListener {
        void onClick(int position1, int position2);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private Context context;

    private AppletssResponse appletssResponse;

    public RecyclerViewAppletsAdapter(Context context) {
        this.context = context;
    }

    public RecyclerViewAppletsAdapter(Context context, AppletssResponse response) {
        this.context = context;
        appletssResponse = response;
    }

    public void setAppletssResponse(AppletssResponse appletssResponse) {
        this.appletssResponse = appletssResponse;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_applets_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppletsType appletsType = appletssResponse.getAppletss().get(position);
        String type = appletsType.getType();
        holder.textViewType.setText(type);

        List<AppletsItem> item = appletsType.getItem();
        GridViewAppletsAdapter appletsAdapter = new GridViewAppletsAdapter(context, item, onItemClickListener, position);
        holder.gridViewApplets.setAdapter(appletsAdapter);
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {

        if (appletssResponse == null) {
            return 0;
        }

        if (appletssResponse.getAppletss() == null) {
            return 0;
        }
        return appletssResponse.getAppletss().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewType;
        private GridView gridViewApplets;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewType = itemView.findViewById(R.id.textViewType);
            gridViewApplets = itemView.findViewById(R.id.gridViewApplets);
        }
    }
}