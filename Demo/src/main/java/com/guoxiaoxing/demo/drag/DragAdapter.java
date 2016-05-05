package com.guoxiaoxing.demo.drag;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guoxiaoxing.demo.R;
import com.guoxiaoxing.recyclerview.decoration.ItemTouchListener;
import com.guoxiaoxing.recyclerview.decoration.OnStartDragListener;
import com.guoxiaoxing.recyclerview.decoration.ViewHolderListener;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author: guoxiaoxing
 * Email: guoxiaoxingv@163.com
 * Site:  https://github.com/guoxiaoxing
 * Date: 16/4/8 下午1:49
 */
public class DragAdapter extends RecyclerView.Adapter<DragAdapter.ViewHolder> implements ItemTouchListener{

    private ArrayList<String> mList = new ArrayList<>();
    private OnStartDragListener mOnStartDragListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drag, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTvText.setText(mList.get(position));

        holder.itemView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                mOnStartDragListener.onStartDrag(holder);
                return false;
            }
        });
//        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
//                    mOnStartDragListener.onStartDrag(holder);
//                }
//                return false;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public void setOnStartDragListener(OnStartDragListener onStartDragListener){
        mOnStartDragListener = onStartDragListener;
    }

    public ArrayList<String> getList() {
        return mList;
    }

    public void setmList(ArrayList<String> list) {
        this.mList = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements ViewHolderListener {

        @Bind(R.id.tv_text)
        TextView mTvText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}  