package com.example.administrator.tagcloudviewtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagsAdapter;

import java.util.List;

public class TagCloudViewAdapter extends TagsAdapter {

	private List<String> stringList;

	public TagCloudViewAdapter(List<String> mList){
		this.stringList = mList;
	}

	@Override
	public int getCount() {
		//返回Tag数量
		return stringList.size();
		//return 0;
	}

	@Override
	public View getView(Context context, int position, ViewGroup parent) {
		//返回每个Tag实例
		TextView tvTag = (TextView) View.inflate(context,R.layout.item_tag,null);
		tvTag.setText(getItem(position).toString());
		return tvTag;
		//return null;
	}

	@Override
	public Object getItem(int position) {
		//返回Tag数据
		return stringList.get(position);
		//return null;
	}

	@Override
	public int getPopularity(int position) {
		//针对每个Tag返回一个权重值，该值与ThemeColor和Tag初始大小有关；
		// 一个简单的权重值生成方式是对一个数N取余或使用随机数
		return 1;
		//return 0;
	}

	@Override
	public void onThemeColorChanged(View view, int themeColor) {
		//Tag主题色发生变化时会回调该方法

	}
}
