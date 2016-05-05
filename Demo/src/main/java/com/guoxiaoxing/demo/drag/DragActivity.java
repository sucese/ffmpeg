package com.guoxiaoxing.demo.drag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.guoxiaoxing.demo.R;
import com.guoxiaoxing.recyclerview.decoration.ItemTouchCallBack;
import com.guoxiaoxing.recyclerview.decoration.OnStartDragListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DragActivity extends AppCompatActivity implements OnStartDragListener {

    @Bind(R.id.rv_list)
    RecyclerView mRvList;

    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        ButterKnife.bind(this);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("拖动排序和删除" + i);
        }

        DragAdapter adapter = new DragAdapter();
        adapter.setmList(list);
        adapter.setOnStartDragListener(this);
        mRvList.setLayoutManager(new LinearLayoutManager(DragActivity.this));
        mRvList.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new ItemTouchCallBack(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRvList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
