package me.royz.commonlibrary.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */

/**
 * 通用的RecyclerView的adapter
 *
 * @param <T> 列表的数据类型
 */
public abstract class CommonRecyclerViewAdapter<T> extends RecyclerView.Adapter<CommonRecyclerViewAdapter.ViewHolder> {
    protected Context context;
    protected List<T> list;
    protected int itemResId;

    /**
     *
     * @param context
     * @param list 数据源
     * @param itemResId item布局
     */
    protected CommonRecyclerViewAdapter(Context context, List<T> list, int itemResId) {
        this.context = context;
        this.list = list;
        this.itemResId = itemResId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(itemResId, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        setValueForItem(holder, position);
    }

    public abstract void setValueForItem(ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        SparseArray<View> array;

        ViewHolder(View itemView) {
            super(itemView);
            array = new SparseArray<>();
        }

        public <T extends View> T getViewById(int resId,Class<T> tClass) {
            View view = array.get(resId);
            if (view == null) {
                view = itemView.findViewById(resId);
                array.put(resId, view);
            }
            return (T) view;
        }

    }
}
