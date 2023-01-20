package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.TabQuestionRxHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.chat.model.TabQuestionBean;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.model.entity.FromToMessage;
import e.b.a.c;
import e.b.a.i;
import e.j.e.t.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class TabQuestionRxRow extends BaseChatRow {
    private ViewHolderTag holderTag;

    /* loaded from: classes2.dex */
    public class LabelsAdapter extends RecyclerView.Adapter<TagViewHolder> {
        public Context context;
        public ArrayList<String> datas;

        /* loaded from: classes2.dex */
        public class TagViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_textView;

            public TagViewHolder(View view) {
                super(view);
                this.tv_textView = (TextView) view.findViewById(R.id.tv_question);
            }
        }

        public LabelsAdapter(ArrayList<String> arrayList, Context context) {
            this.context = context;
            this.datas = arrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<String> arrayList = this.datas;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(TagViewHolder tagViewHolder, final int i2) {
            tagViewHolder.tv_textView.setText(this.datas.get(i2));
            tagViewHolder.tv_textView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TabQuestionRxRow.LabelsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LabelsAdapter labelsAdapter = LabelsAdapter.this;
                    ((ChatActivity) labelsAdapter.context).sendTextMsg(labelsAdapter.datas.get(i2));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public TagViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new TagViewHolder(View.inflate(viewGroup.getContext(), R.layout.ykfsdk_kf_question_item, null));
        }
    }

    /* loaded from: classes2.dex */
    public class TagAdapter extends PagerAdapter {
        private Context context;
        private List<View> pages;
        private List<String> tittles;

        public TagAdapter(Context context, List<View> list, List<String> list2) {
            this.context = context;
            this.pages = list;
            this.tittles = list2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.pages.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.pages.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return this.tittles.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            if (i2 < this.pages.size()) {
                View view = this.pages.get(i2);
                viewGroup.addView(view);
                return view;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public TabQuestionRxRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_tabquestion_rx, (ViewGroup) null);
            inflate.setTag(new TabQuestionRxHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        final TabQuestionRxHolder tabQuestionRxHolder = (TabQuestionRxHolder) baseHolder;
        if (fromToMessage == null || TextUtils.isEmpty(fromToMessage.common_questions_group) || tabQuestionRxHolder.getViewPager().getAdapter() != null) {
            return;
        }
        if (!TextUtils.isEmpty(fromToMessage.common_questions_img)) {
            i<Drawable> k2 = c.D(context).k(fromToMessage.common_questions_img);
            int i3 = R.drawable.ykfsdk_ic_kf_tabquestion;
            k2.y0(i3).z(i3).m1(tabQuestionRxHolder.getIv_tab_question_logo());
        } else {
            tabQuestionRxHolder.getIv_tab_question_logo().setImageDrawable(context.getResources().getDrawable(R.drawable.ykfsdk_ic_kf_tabquestion));
        }
        View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
        ArrayList arrayList = (ArrayList) new Gson().o(fromToMessage.common_questions_group, new a<ArrayList<TabQuestionBean>>() { // from class: com.m7.imkfsdk.chat.chatrow.TabQuestionRxRow.1
        }.getType());
        if (arrayList != null && arrayList.size() > 0) {
            final HashMap hashMap = new HashMap();
            final ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                hashMap.put(((TabQuestionBean) arrayList.get(i4)).name, ((TabQuestionBean) arrayList.get(i4)).list);
                arrayList2.add(((TabQuestionBean) arrayList.get(i4)).name);
            }
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                tabQuestionRxHolder.getTab_layout().e(tabQuestionRxHolder.getTab_layout().D());
                View inflate = View.inflate(context, R.layout.ykfsdk_kf_tabquestionfragment, null);
                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.reclcle_question);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.setAdapter(new LabelsAdapter((ArrayList) hashMap.get(arrayList2.get(i5)), context));
                arrayList3.add(inflate);
            }
            tabQuestionRxHolder.getViewPager().setAdapter(new TagAdapter(context, arrayList3, arrayList2));
            tabQuestionRxHolder.getTab_layout().setupWithViewPager(tabQuestionRxHolder.getViewPager());
            tabQuestionRxHolder.getViewPager().setCurrentItem(0);
            if (hashMap.get(arrayList2.get(0)) != null) {
                if (((ArrayList) hashMap.get(arrayList2.get(0))).size() > 5) {
                    this.holderTag = ViewHolderTag.createTag((String) arrayList2.get(0), (ArrayList) hashMap.get(arrayList2.get(0)), 16);
                    tabQuestionRxHolder.getTv_seemore().setTag(this.holderTag);
                    tabQuestionRxHolder.getTv_seemore().setVisibility(0);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tabQuestionRxHolder.getViewPager().getLayoutParams();
                    layoutParams.height = MoorDensityUtil.dp2px(225.0f);
                    tabQuestionRxHolder.getViewPager().setLayoutParams(layoutParams);
                } else {
                    tabQuestionRxHolder.getTv_seemore().setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tabQuestionRxHolder.getViewPager().getLayoutParams();
                    layoutParams2.height = MoorDensityUtil.dp2px(((ArrayList) hashMap.get(arrayList2.get(0))).size() * 45);
                    tabQuestionRxHolder.getViewPager().setLayoutParams(layoutParams2);
                }
            } else {
                tabQuestionRxHolder.getTv_seemore().setVisibility(8);
            }
            tabQuestionRxHolder.getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.m7.imkfsdk.chat.chatrow.TabQuestionRxRow.2
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i6) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i6, float f2, int i7) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i6) {
                    if (i6 >= arrayList2.size() || hashMap.get(arrayList2.get(i6)) == null) {
                        return;
                    }
                    int size = ((ArrayList) hashMap.get(arrayList2.get(i6))).size();
                    if (size > 5) {
                        if (((ChatActivity) context).isListBottom()) {
                            ((ChatActivity) context).scrollToBottom();
                        }
                        TabQuestionRxRow.this.holderTag = ViewHolderTag.createTag((String) arrayList2.get(i6), (ArrayList) hashMap.get(arrayList2.get(i6)), 16);
                        tabQuestionRxHolder.getTv_seemore().setTag(TabQuestionRxRow.this.holderTag);
                        tabQuestionRxHolder.getTv_seemore().setVisibility(0);
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) tabQuestionRxHolder.getViewPager().getLayoutParams();
                        layoutParams3.height = MoorDensityUtil.dp2px(225.0f);
                        tabQuestionRxHolder.getViewPager().setLayoutParams(layoutParams3);
                        return;
                    }
                    if (((ChatActivity) context).isListBottom()) {
                        ((ChatActivity) context).scrollToBottom();
                    }
                    tabQuestionRxHolder.getTv_seemore().setVisibility(8);
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) tabQuestionRxHolder.getViewPager().getLayoutParams();
                    layoutParams4.height = MoorDensityUtil.dp2px(size * 45);
                    tabQuestionRxHolder.getViewPager().setLayoutParams(layoutParams4);
                }
            });
        }
        tabQuestionRxHolder.getTv_seemore().setOnClickListener(onClickListener);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.TAB_QUESTION_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
