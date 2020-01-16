package com.usho.testrecycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by chensuilun on 2016/11/15.
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {
    private static final String TAG = "DemoAdapter";
    private List<String> mItems;


    public DemoAdapter(List<String> items) {
        this.mItems = items;
    }

    public void addData() {
        if (mItems != null) {
            for (int i = 0; i < 10; i++) {
                mItems.add("Extra:" + i);
            }
            notifyDataSetChanged();
        }
    }

    private static final Random RANDOM = new Random();

    public int dataChange() {
        int result = 0;
        if (mItems != null) {
            if (RANDOM.nextBoolean()) {
                for (int i = 0; i < 10; i++) {
                    mItems.add("Extra:" + i);
                }
                result = 1;
            } else {
                int size = mItems.size();
                int cut = size / 2;
                for (int i = size - 1; i > cut; i--) {
                    mItems.remove(i);
                }
                result = -1;
            }
            notifyDataSetChanged();
        }
        return result;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "onCreateViewHolder: type:" + viewType);
        }
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_demo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onBindViewHolder: position:" + position);
        }
        String item = mItems.get(position);
        holder.text.setText("HelloWorld：" + item);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    /**
     * @author chensuilun
     */
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.item_tv_title);
        }
    }

    /**
     * @author chensuilun
     */
    public interface OnItemClickListener {

        void onItemClick(View view, int position);

    }
}
