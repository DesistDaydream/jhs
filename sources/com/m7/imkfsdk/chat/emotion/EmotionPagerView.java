package com.m7.imkfsdk.chat.emotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EmotionPagerView extends ViewPager {
    private int currentHeight;
    private int currentWidth;
    private Adapter mAdapter;

    /* loaded from: classes2.dex */
    public static class Adapter extends PagerAdapter {
        private List<EmotionView> mList;

        public Adapter(List<EmotionView> list) {
            this.mList = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.mList.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            viewGroup.addView(this.mList.get(i2));
            return this.mList.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return obj == view;
        }
    }

    public EmotionPagerView(@NonNull Context context) {
        this(context, null);
    }

    public void buildEmotionViews(EditText editText, List<Emotion> list, int i2, int i3) {
        if (list == null || list.isEmpty() || editText == null) {
            return;
        }
        if (this.currentWidth == i2 && this.currentHeight == i3) {
            return;
        }
        this.currentWidth = i2;
        this.currentHeight = i3;
        int calSizeForContainEmotion = EmotionView.calSizeForContainEmotion(getContext(), this.currentWidth, this.currentHeight);
        if (calSizeForContainEmotion == 0) {
            return;
        }
        int size = list.size() / calSizeForContainEmotion;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < 1) {
            EmotionView emotionView = new EmotionView(getContext(), editText);
            i4++;
            if (i4 * calSizeForContainEmotion > list.size()) {
                list.size();
            }
            emotionView.buildEmotions(list);
            arrayList.add(emotionView);
        }
        Adapter adapter = new Adapter(arrayList);
        this.mAdapter = adapter;
        setAdapter(adapter);
    }

    public EmotionPagerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentWidth = -1;
        this.currentHeight = -1;
    }
}
