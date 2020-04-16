package com.ms.app.view.fragment.adapter.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bdlbsc.common.applets.AppletsItem;
import com.bumptech.glide.Glide;
import com.ms.app.R;
import com.ms.app.view.fragment.adapter.recycler.RecyclerViewAppletsAdapter.OnItemClickListener;

import org.ms.module.supper.client.Modules;

import java.util.List;

public class GridViewAppletsAdapter extends BaseAdapter {
    private Context context;

    List<AppletsItem> appletsItems;

    OnItemClickListener onItemClickListener;


    private int recyclerViewPosition;


    public GridViewAppletsAdapter(Context context, List<AppletsItem> appletsItems, OnItemClickListener onItemClickListener,int position) {
        this.context = context;
        this.appletsItems = appletsItems;
        this.onItemClickListener = onItemClickListener;
        recyclerViewPosition=position;
    }

    @Override
    public int getCount() {
        return appletsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;


        if (holder == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gridview_applets_adapter, null);

            holder.imageViewIcon = convertView.findViewById(R.id.imageViewIcon);
            holder.textViewName = convertView.findViewById(R.id.textViewName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AppletsItem appletsItem = appletsItems.get(position);

        holder.textViewName.setText(appletsItem.getName());
        Glide.with(context).load(appletsItem.getIcon_url()).into(holder.imageViewIcon);

        holder.imageViewIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Modules.getUtilsModule().getToastUtils().show(appletsItem.getName());

            }
        });


        return convertView;
    }

    static class ViewHolder {
        ImageView imageViewIcon;
        TextView textViewName;
    }
}
