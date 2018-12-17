package com.example.administrator.tagcloudviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moxun.tagcloudlib.view.TagCloudView;

import java.util.ArrayList;
import java.util.List;

/**
 * 3D球形旋转动画效果
 * 可点击，可全方位旋转，可自动旋转
 * */
public class MainActivity extends AppCompatActivity implements TagCloudView.OnTagClickListener{

    TagCloudView tagCloud;
    List<String> list = new ArrayList<>();//标签云数据的集合
    List<String> listClick = new ArrayList<>();//点击过的标签云的数据的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tagCloud  = (TagCloudView)findViewById(R.id.tag_cloud);

        //给集合添加数据
        for (int i = 0; i < 25; i++) {
            list.add("label" + i);
        }

        //设置标签云的点击事件
        tagCloud.setOnTagClickListener(this);
        //给标签云设置适配器
        TagCloudViewAdapter adapter = new TagCloudViewAdapter(list);
        tagCloud.setAdapter(adapter);
    }

    // 点击标签的回调方法
    @Override
    public void onItemClick(ViewGroup parent, View view, int position) {
        view.setSelected(!view.isSelected());//设置标签的选择状态
        if (view.isSelected()) {
            //加入集合
            listClick.add(list.get(position));
        } else {
            //移除集合
            listClick.remove(list.get(position));
        }
        Toast.makeText(this, "点击过的标签：" + listClick.toString(), Toast.LENGTH_SHORT).show();
    }
}
