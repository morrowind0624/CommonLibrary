package me.royz.commonlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.royz.commonlibrary.ui.adapter.CommonRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<>();
        CommonRecyclerViewAdapter adapter = new CommonRecyclerViewAdapter<String>(MainActivity.this, list, R.layout.activity_main) {
            @Override
            public void setValueForItem(CommonRecyclerViewAdapter.ViewHolder holder, int position) {
                holder.getViewById(R.id.test, TextView.class).setText("test");
            }

        };
    }
}
