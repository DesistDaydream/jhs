package com.m7.imkfsdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.model.Option;
import com.m7.imkfsdk.utils.FIleResourceUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class TagView extends LinearLayout {
    public static final int SINGLE = 0;
    public int SelectedPosition;
    private TagSelectAdapter adapter;
    private Context context;
    private OnSelectedChangeListener onSelectedChangeListener;
    private List<Option> optionLists;
    private RecyclerView rvTagName;
    private TagSingleSelectAdapter tagSingleSelectAdapter;

    /* loaded from: classes2.dex */
    public interface OnSelectedChangeListener {
        void getTagList(List<Option> list);
    }

    /* loaded from: classes2.dex */
    public class TagSelectAdapter extends RecyclerView.Adapter<MineContactViewHolder> {
        private Set<Option> broadcas = new LinkedHashSet();
        private final LayoutInflater layoutInflater;
        private List<Option> list;
        private final Context mContext;

        /* loaded from: classes2.dex */
        public class MineContactViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_title;

            public MineContactViewHolder(View view) {
                super(view);
                this.tv_title = (TextView) view.findViewById(R.id.tv_title);
            }
        }

        public TagSelectAdapter(Context context, List<Option> list) {
            this.mContext = context;
            this.list = list;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Option> list = this.list;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @RequiresApi(api = 16)
        public void onBindViewHolder(MineContactViewHolder mineContactViewHolder, final int i2) {
            final Option option = this.list.get(i2);
            if (option.isSelected) {
                this.broadcas.add(option);
                mineContactViewHolder.tv_title.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.ykfsdk_kf_bg_my_label_selected));
                mineContactViewHolder.tv_title.setTextColor(FIleResourceUtil.getCurrentColor(this.mContext, R.attr.ykfsdk_ykf_theme_color_default));
            } else {
                mineContactViewHolder.tv_title.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.ykfsdk_kf_bg_my_label_unselected));
                mineContactViewHolder.tv_title.setTextColor(ContextCompat.getColor(this.mContext, R.color.ykfsdk_kf_tag_unselect));
            }
            mineContactViewHolder.tv_title.setText(option.name);
            mineContactViewHolder.tv_title.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.TagView.TagSelectAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!option.isSelected()) {
                        TagSelectAdapter.this.broadcas.add(option);
                    } else {
                        Iterator it = TagSelectAdapter.this.broadcas.iterator();
                        while (it.hasNext()) {
                            if (((Option) it.next()).name.equals(option.name)) {
                                it.remove();
                            }
                        }
                        TagSelectAdapter.this.broadcas.remove(option);
                    }
                    Option option2 = option;
                    option2.setSelected(!option2.isSelected());
                    TagSelectAdapter.this.notifyItemChanged(i2);
                    if (TagSelectAdapter.this.broadcas.size() > 0) {
                        TagView.this.optionLists.clear();
                        TagView.this.optionLists.addAll(TagSelectAdapter.this.broadcas);
                        TagView.this.onSelectedChangeListener.getTagList(TagView.this.optionLists);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MineContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new MineContactViewHolder(this.layoutInflater.inflate(R.layout.ykfsdk_kf_textview_flowlayout, viewGroup, false));
        }
    }

    /* loaded from: classes2.dex */
    public class TagSingleSelectAdapter extends RecyclerView.Adapter<SingleTagViewHolder> {
        private Set<Option> broadcas = new LinkedHashSet();
        private SingleTagViewHolder holder1;
        private final LayoutInflater layoutInflater;
        private List<Option> list;
        private final Context mContext;

        /* loaded from: classes2.dex */
        public class SingleTagViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_title;

            public SingleTagViewHolder(View view) {
                super(view);
                this.tv_title = (TextView) view.findViewById(R.id.tv_title);
            }
        }

        public TagSingleSelectAdapter(Context context, List<Option> list) {
            this.mContext = context;
            this.list = list;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<Option> list = this.list;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SingleTagViewHolder singleTagViewHolder, int i2) {
        }

        @RequiresApi(api = 16)
        public void setTagView(SingleTagViewHolder singleTagViewHolder, int i2, Option option) {
            singleTagViewHolder.tv_title.setTag(Integer.valueOf(i2));
            if (option.isSelected) {
                this.broadcas.clear();
                this.broadcas.add(option);
                singleTagViewHolder.tv_title.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.ykfsdk_kf_bg_my_label_selected));
                singleTagViewHolder.tv_title.setTextColor(FIleResourceUtil.getCurrentColor(this.mContext, R.attr.ykfsdk_ykf_theme_color_default));
                return;
            }
            singleTagViewHolder.tv_title.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.ykfsdk_kf_bg_my_label_unselected));
            singleTagViewHolder.tv_title.setTextColor(ContextCompat.getColor(this.mContext, R.color.ykfsdk_kf_tag_unselect));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SingleTagViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new SingleTagViewHolder(this.layoutInflater.inflate(R.layout.ykfsdk_kf_textview_flowlayout, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @RequiresApi(api = 16)
        public void onBindViewHolder(final SingleTagViewHolder singleTagViewHolder, int i2, List list) {
            this.holder1 = singleTagViewHolder;
            Option option = this.list.get(i2);
            if (list.isEmpty()) {
                setTagView(this.holder1, i2, option);
                singleTagViewHolder.tv_title.setText(option.name);
                singleTagViewHolder.tv_title.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.TagView.TagSingleSelectAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int intValue = ((Integer) singleTagViewHolder.tv_title.getTag()).intValue();
                        Option option2 = (Option) TagSingleSelectAdapter.this.list.get(intValue);
                        if (option2.isSelected) {
                            option2.isSelected = false;
                            TagSingleSelectAdapter.this.notifyItemChanged(intValue, option2);
                            TagView tagView = TagView.this;
                            tagView.SelectedPosition = -1;
                            tagView.onSelectedChangeListener.getTagList(TagView.this.optionLists);
                            return;
                        }
                        TagSingleSelectAdapter tagSingleSelectAdapter = TagSingleSelectAdapter.this;
                        if (TagView.this.SelectedPosition != -1) {
                            Option option3 = (Option) tagSingleSelectAdapter.list.get(TagView.this.SelectedPosition);
                            option3.isSelected = false;
                            TagSingleSelectAdapter tagSingleSelectAdapter2 = TagSingleSelectAdapter.this;
                            tagSingleSelectAdapter2.notifyItemChanged(TagView.this.SelectedPosition, option3);
                            TagView.this.onSelectedChangeListener.getTagList(TagView.this.optionLists);
                        }
                        TagSingleSelectAdapter tagSingleSelectAdapter3 = TagSingleSelectAdapter.this;
                        TagView.this.SelectedPosition = intValue;
                        option2.isSelected = true;
                        tagSingleSelectAdapter3.broadcas.clear();
                        TagSingleSelectAdapter.this.broadcas.add(option2);
                        TagSingleSelectAdapter.this.notifyItemChanged(intValue, option2);
                        TagView.this.optionLists.clear();
                        TagView.this.optionLists.addAll(TagSingleSelectAdapter.this.broadcas);
                        TagView.this.onSelectedChangeListener.getTagList(TagView.this.optionLists);
                    }
                });
            } else if (list.get(0) instanceof Option) {
                setTagView(this.holder1, i2, (Option) list.get(0));
            }
        }
    }

    public TagView(Context context) {
        super(context);
        this.optionLists = new ArrayList();
        this.SelectedPosition = -1;
    }

    public void clearSelcted() {
        for (Option option : this.optionLists) {
            option.isSelected = false;
        }
        TagSingleSelectAdapter tagSingleSelectAdapter = this.tagSingleSelectAdapter;
        if (tagSingleSelectAdapter != null) {
            tagSingleSelectAdapter.notifyDataSetChanged();
        }
        TagSelectAdapter tagSelectAdapter = this.adapter;
        if (tagSelectAdapter != null) {
            tagSelectAdapter.notifyDataSetChanged();
        }
    }

    public void initTagView(List<Option> list, int i2) {
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this.context);
        flexboxLayoutManager.setJustifyContent(0);
        this.rvTagName.setLayoutManager(flexboxLayoutManager);
        if (i2 == 0) {
            TagSingleSelectAdapter tagSingleSelectAdapter = new TagSingleSelectAdapter(this.context, list);
            this.tagSingleSelectAdapter = tagSingleSelectAdapter;
            this.rvTagName.setAdapter(tagSingleSelectAdapter);
        } else if (i2 != 1) {
        } else {
            TagSelectAdapter tagSelectAdapter = new TagSelectAdapter(this.context, list);
            this.adapter = tagSelectAdapter;
            this.rvTagName.setAdapter(tagSelectAdapter);
        }
    }

    public void setOnSelectedChangeListener(OnSelectedChangeListener onSelectedChangeListener) {
        this.onSelectedChangeListener = onSelectedChangeListener;
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.optionLists = new ArrayList();
        this.SelectedPosition = -1;
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.ykfsdk_kf_tag_view, this);
        this.rvTagName = (RecyclerView) findViewById(R.id.rv_tagName);
    }
}
