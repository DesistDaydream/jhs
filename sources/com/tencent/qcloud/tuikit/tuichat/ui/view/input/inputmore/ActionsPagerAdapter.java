package com.tencent.qcloud.tuikit.tuichat.ui.view.input.inputmore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ActionsPagerAdapter extends PagerAdapter {
    private int actionHeight;
    private int actionWidth;
    private final Context mContext;
    private final int mGridViewCount;
    private final List<InputMoreActionUnit> mInputMoreList;
    private final ViewPager mViewPager;
    private final int ITEM_COUNT_PER_GRID_VIEW = 8;
    private final int COLUMN_COUNT = 4;

    public ActionsPagerAdapter(ViewPager viewPager, List<InputMoreActionUnit> list) {
        this.mContext = viewPager.getContext();
        this.mInputMoreList = new ArrayList(list);
        this.mViewPager = viewPager;
        this.mGridViewCount = ((list.size() + 8) - 1) / 8;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mGridViewCount;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        int i3 = (i2 + 1) * 8;
        if (i3 > this.mInputMoreList.size()) {
            i3 = this.mInputMoreList.size();
        }
        List<InputMoreActionUnit> subList = this.mInputMoreList.subList(i2 * 8, i3);
        GridView gridView = new GridView(this.mContext);
        gridView.setAdapter((ListAdapter) new ActionsGridViewAdapter(this.mContext, subList));
        if (this.mInputMoreList.size() >= 4) {
            gridView.setNumColumns(4);
            viewGroup.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.inputmore.ActionsPagerAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams = ActionsPagerAdapter.this.mViewPager.getLayoutParams();
                    layoutParams.height = ActionsPagerAdapter.this.actionHeight;
                    ActionsPagerAdapter.this.mViewPager.setLayoutParams(layoutParams);
                }
            });
        } else {
            gridView.setNumColumns(this.mInputMoreList.size());
            viewGroup.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.inputmore.ActionsPagerAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams = ActionsPagerAdapter.this.mViewPager.getLayoutParams();
                    layoutParams.height = ActionsPagerAdapter.this.actionHeight;
                    ActionsPagerAdapter.this.mViewPager.setLayoutParams(layoutParams);
                }
            });
        }
        gridView.setSelector(R.color.transparent);
        gridView.setHorizontalSpacing(60);
        gridView.setVerticalSpacing(60);
        gridView.setGravity(17);
        gridView.setTag(Integer.valueOf(i2));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.input.inputmore.ActionsPagerAdapter.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j2) {
                ((InputMoreActionUnit) ActionsPagerAdapter.this.mInputMoreList.get((((Integer) adapterView.getTag()).intValue() * 8) + i4)).getOnClickListener().onClick();
            }
        });
        viewGroup.addView(gridView);
        return gridView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
