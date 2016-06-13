package com.guoxiaoxing.demo.screenshot;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

import com.guoxiaoxing.demo.R;
import com.guoxiaoxing.recyclerview.utils.RecyclerViewUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScreenshotActivity extends AppCompatActivity {

    @Bind(R.id.tb_title)
    Toolbar mTbTitle;
    @Bind(R.id.rv_screenshot)
    RecyclerView mRvScreenshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_screenshot);
        ButterKnife.bind(this);

        setupView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


    private void setupView() {

        mTbTitle.inflateMenu(R.menu.toolbar);

        mTbTitle.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.item_save:
                        saveBitmap();
                        break;
                }
                return true;
            }
        });

        ScreenshotAdapter adapter = new ScreenshotAdapter();
        mRvScreenshot.setHasFixedSize(true);
        mRvScreenshot.setLayoutManager(new LinearLayoutManager(ScreenshotActivity.this));
        mRvScreenshot.setAdapter(adapter);
    }

    private void saveBitmap() {
        Bitmap bitmap = RecyclerViewUtils.getScreenshotFromRecyclerView(mRvScreenshot);
    }

}
