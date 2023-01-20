package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class TabQuestionRxHolder extends BaseHolder {
    private ImageView iv_tab_question_logo;
    private TabLayout tab_layout;
    private TextView tv_seemore;
    private ViewPager viewPager;

    public TabQuestionRxHolder(int i2) {
        super(i2);
    }

    public ImageView getIv_tab_question_logo() {
        return this.iv_tab_question_logo;
    }

    public TabLayout getTab_layout() {
        return this.tab_layout;
    }

    public TextView getTv_seemore() {
        return this.tv_seemore;
    }

    public ViewPager getViewPager() {
        return this.viewPager;
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.tab_layout = (TabLayout) view.findViewById(R.id.tb_question);
        this.viewPager = (ViewPager) view.findViewById(R.id.vp_tabquestion);
        this.tv_seemore = (TextView) view.findViewById(R.id.tv_seemore);
        this.iv_tab_question_logo = (ImageView) view.findViewById(R.id.iv_tab_question_logo);
        return this;
    }

    public TabQuestionRxHolder(View view) {
        super(view);
    }
}
