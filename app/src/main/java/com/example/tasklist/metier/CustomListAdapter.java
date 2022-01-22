package com.example.tasklist.metier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Task> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Task> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return  listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.titleView = (TextView) convertView.findViewById(R.id.textView_title);
            holder.dateView = (TextView) convertView.findViewById(R.id.textView_Date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Task t = this.listData.get(position);
        holder.titleView.setText("task : " + t.getTitle());
        holder.dateView.setText(" doit etre fait avant le : " + t.getDate());

        return convertView;
    }
    static class ViewHolder {
        TextView titleView;
        TextView dateView;
    }
}
