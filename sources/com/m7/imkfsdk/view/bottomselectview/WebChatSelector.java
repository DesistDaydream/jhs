package com.m7.imkfsdk.view.bottomselectview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.moor.imkf.model.entity.WebChatInterface;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class WebChatSelector extends LinearLayout implements View.OnClickListener {
    private int TextEmptyColor;
    private int TextSelectedColor;
    private AddressAdapter addressAdapter;
    private ArrayList<WebChatInterface> cities;
    private View grayLine;
    private Line line;
    private RecyclerView list;
    private int listItemIcon;
    private int listTextNormalColor;
    private int listTextSelectedColor;
    private int listTextSize;
    private Context mContext;
    private OnTabSelectedListener onTabSelectedListener;
    private int tabAmount;
    private int tabIndex;
    private ArrayList<Tab> tabs;
    private LinearLayout tabs_layout;
    private WebChatOnItemClickListener webChatOnItemClickListener;

    /* loaded from: classes2.dex */
    public class AddressAdapter extends RecyclerView.Adapter<MyViewHolder> {

        /* loaded from: classes2.dex */
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView img;
            public View itemView;
            public TextView tv;

            public MyViewHolder(View view) {
                super(view);
                this.itemView = view;
                this.tv = (TextView) view.findViewById(R.id.item_address_tv);
                this.img = (ImageView) view.findViewById(R.id.item_address_img);
            }
        }

        private AddressAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return WebChatSelector.this.cities.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder myViewHolder, int i2) {
            if (WebChatSelector.this.listItemIcon != -1) {
                myViewHolder.img.setImageResource(WebChatSelector.this.listItemIcon);
            }
            if (WebChatSelector.this.listTextSize != -1) {
                myViewHolder.tv.setTextSize(WebChatSelector.this.listTextSize);
            }
            if (TextUtils.equals(((Tab) WebChatSelector.this.tabs.get(WebChatSelector.this.tabIndex)).getText(), ((WebChatInterface) WebChatSelector.this.cities.get(i2)).getCityName())) {
                myViewHolder.img.setVisibility(0);
                myViewHolder.tv.setTextColor(WebChatSelector.this.listTextSelectedColor);
            } else {
                myViewHolder.img.setVisibility(4);
                myViewHolder.tv.setTextColor(WebChatSelector.this.listTextNormalColor);
            }
            myViewHolder.tv.setText(((WebChatInterface) WebChatSelector.this.cities.get(i2)).getCityName());
            myViewHolder.itemView.setTag(WebChatSelector.this.cities.get(i2));
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.bottomselectview.WebChatSelector.AddressAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WebChatSelector.this.webChatOnItemClickListener != null) {
                        WebChatSelector.this.webChatOnItemClickListener.itemClick(WebChatSelector.this, (WebChatInterface) view.getTag(), WebChatSelector.this.tabIndex);
                        if (((WebChatInterface) view.getTag()).getOption().size() > 0) {
                            ((Tab) WebChatSelector.this.tabs.get(WebChatSelector.this.tabIndex)).setText(((WebChatInterface) view.getTag()).getCityName());
                            ((Tab) WebChatSelector.this.tabs.get(WebChatSelector.this.tabIndex)).setTag(view.getTag());
                            if (WebChatSelector.this.tabIndex + 1 < WebChatSelector.this.tabs.size()) {
                                WebChatSelector.access$708(WebChatSelector.this);
                                WebChatSelector webChatSelector = WebChatSelector.this;
                                webChatSelector.resetAllTabs(webChatSelector.tabIndex);
                                WebChatSelector.this.line.setIndex(WebChatSelector.this.tabIndex);
                                ((Tab) WebChatSelector.this.tabs.get(WebChatSelector.this.tabIndex)).setText("请选择");
                                ((Tab) WebChatSelector.this.tabs.get(WebChatSelector.this.tabIndex)).setSelected(true);
                                return;
                            }
                            return;
                        }
                        ((Tab) WebChatSelector.this.tabs.get(WebChatSelector.this.tabIndex)).setText(((WebChatInterface) view.getTag()).getCityName());
                        ((Tab) WebChatSelector.this.tabs.get(WebChatSelector.this.tabIndex)).setTag(view.getTag());
                        if (WebChatSelector.this.tabIndex + 1 < WebChatSelector.this.tabs.size()) {
                            WebChatSelector webChatSelector2 = WebChatSelector.this;
                            webChatSelector2.resetAllTabs(webChatSelector2.tabIndex);
                            AddressAdapter.this.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new MyViewHolder(LayoutInflater.from(WebChatSelector.this.mContext).inflate(R.layout.ykfsdk_kf_item_chataddress, viewGroup, false));
        }
    }

    /* loaded from: classes2.dex */
    public interface OnTabSelectedListener {
        void onTabReselected(WebChatSelector webChatSelector, Tab tab);

        void onTabSelected(WebChatSelector webChatSelector, Tab tab);
    }

    public WebChatSelector(Context context) {
        super(context);
        this.tabAmount = 3;
        this.tabIndex = 0;
        this.listTextSize = -1;
        this.listItemIcon = -1;
        init(context);
    }

    public static /* synthetic */ int access$708(WebChatSelector webChatSelector) {
        int i2 = webChatSelector.tabIndex;
        webChatSelector.tabIndex = i2 + 1;
        return i2;
    }

    private void init(Context context) {
        removeAllViews();
        this.mContext = context;
        Resources resources = context.getResources();
        int i2 = R.color.ykfsdk_selected_color;
        this.TextSelectedColor = resources.getColor(i2);
        Resources resources2 = this.mContext.getResources();
        int i3 = R.color.ykfsdk_color_333333;
        this.TextEmptyColor = resources2.getColor(i3);
        this.listTextNormalColor = this.mContext.getResources().getColor(i3);
        this.listTextSelectedColor = this.mContext.getResources().getColor(i2);
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.tabs_layout = linearLayout;
        linearLayout.setWeightSum(this.tabAmount);
        this.tabs_layout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.tabs_layout.setOrientation(0);
        addView(this.tabs_layout);
        this.tabs = new ArrayList<>();
        Tab newTab = newTab("请选择", true);
        this.tabs_layout.addView(newTab);
        this.tabs.add(newTab);
        for (int i4 = 1; i4 < this.tabAmount; i4++) {
            Tab newTab2 = newTab("", false);
            newTab2.setIndex(i4);
            this.tabs_layout.addView(newTab2);
            this.tabs.add(newTab2);
        }
        Line line = new Line(this.mContext);
        this.line = line;
        line.setLayoutParams(new LinearLayout.LayoutParams(-1, 6));
        this.line.setSum(this.tabAmount);
        addView(this.line);
        View view = new View(this.mContext);
        this.grayLine = view;
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
        this.grayLine.setBackgroundColor(this.mContext.getResources().getColor(R.color.ykfsdk_ykf_line_DDDDDD));
        addView(this.grayLine);
        RecyclerView recyclerView = new RecyclerView(this.mContext);
        this.list = recyclerView;
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.list.setLayoutManager(new LinearLayoutManager(this.mContext));
        addView(this.list);
    }

    private Tab newTab(CharSequence charSequence, boolean z) {
        Tab tab = new Tab(this.mContext);
        tab.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        tab.setGravity(17);
        tab.setPadding(0, 20, 0, 20);
        tab.setSelected(z);
        tab.setText(charSequence);
        tab.setTextEmptyColor(this.TextEmptyColor);
        tab.setTextSelectedColor(this.TextSelectedColor);
        tab.setOnClickListener(this);
        tab.setSingleLine(true);
        tab.setEllipsize(TextUtils.TruncateAt.END);
        return tab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAllTabs(int i2) {
        if (this.tabs != null) {
            for (int i3 = 0; i3 < this.tabs.size(); i3++) {
                this.tabs.get(i3).resetState();
                if (i3 > i2) {
                    this.tabs.get(i3).setText("");
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tab tab = (Tab) view;
        if (tab.index > this.tabIndex) {
            return;
        }
        this.tabIndex = tab.index;
        if (this.onTabSelectedListener != null) {
            if (tab.isSelected) {
                this.onTabSelectedListener.onTabReselected(this, tab);
            } else {
                this.onTabSelectedListener.onTabSelected(this, tab);
            }
        }
        resetAllTabs(this.tabIndex);
        this.line.setIndex(this.tabIndex);
        tab.setSelected(true);
    }

    public void setCities(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (arrayList.get(0) instanceof WebChatInterface) {
            this.cities = arrayList;
            if (this.addressAdapter == null) {
                AddressAdapter addressAdapter = new AddressAdapter();
                this.addressAdapter = addressAdapter;
                this.list.setAdapter(addressAdapter);
            }
            this.addressAdapter.notifyDataSetChanged();
            return;
        }
        throw new RuntimeException("AddressSelector cities must implements CityInterface");
    }

    public void setGrayLineColor(int i2) {
        this.grayLine.setBackgroundColor(i2);
    }

    public void setLineColor(int i2) {
        this.line.setSelectedColor(i2);
    }

    public void setListItemIcon(int i2) {
        this.listItemIcon = i2;
    }

    public void setListTextNormalColor(int i2) {
        this.listTextNormalColor = i2;
    }

    public void setListTextSelectedColor(int i2) {
        this.listTextSelectedColor = i2;
    }

    public void setListTextSize(int i2) {
        this.listTextSize = i2;
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.onTabSelectedListener = onTabSelectedListener;
    }

    public void setTabAmount(int i2) {
        if (i2 >= 1) {
            this.tabAmount = i2;
            init(this.mContext);
            return;
        }
        throw new RuntimeException("AddressSelector tabAmount can not less-than 1 !");
    }

    public void setTextEmptyColor(int i2) {
        this.TextEmptyColor = i2;
    }

    public void setTextSelectedColor(int i2) {
        this.TextSelectedColor = i2;
    }

    public void setWebChatOnItemClickListener(WebChatOnItemClickListener webChatOnItemClickListener) {
        this.webChatOnItemClickListener = webChatOnItemClickListener;
    }

    /* loaded from: classes2.dex */
    public class Tab extends TextView {
        private int TextEmptyColor;
        private int TextSelectedColor;
        private int index;
        private boolean isSelected;

        public Tab(Context context) {
            super(context);
            this.index = 0;
            this.isSelected = false;
            init();
        }

        private void init() {
            this.TextSelectedColor = WebChatSelector.this.mContext.getResources().getColor(R.color.ykfsdk_selected_color);
            this.TextEmptyColor = WebChatSelector.this.mContext.getResources().getColor(R.color.ykfsdk_color_333333);
            setTextSize(15.0f);
        }

        public int getIndex() {
            return this.index;
        }

        public void resetState() {
            this.isSelected = false;
            setText(getText());
        }

        public void setIndex(int i2) {
            this.index = i2;
        }

        @Override // android.widget.TextView, android.view.View
        public void setSelected(boolean z) {
            this.isSelected = z;
            setText(getText());
        }

        @Override // android.widget.TextView
        public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
            if (this.isSelected) {
                setTextColor(this.TextSelectedColor);
            } else {
                setTextColor(this.TextEmptyColor);
            }
            super.setText(charSequence, bufferType);
        }

        public void setTextEmptyColor(int i2) {
            this.TextEmptyColor = i2;
        }

        public void setTextSelectedColor(int i2) {
            this.TextSelectedColor = i2;
        }

        public Tab(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.index = 0;
            this.isSelected = false;
            init();
        }

        public Tab(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.index = 0;
            this.isSelected = false;
            init();
        }
    }

    /* loaded from: classes2.dex */
    public class Line extends LinearLayout {
        private int SelectedColor;
        private View indicator;
        private int nowIndex;
        private int oldIndex;
        private int sum;

        public Line(Context context) {
            super(context);
            this.sum = 3;
            this.oldIndex = 0;
            this.nowIndex = 0;
            init(context);
        }

        private void init(Context context) {
            this.SelectedColor = WebChatSelector.this.mContext.getResources().getColor(R.color.ykfsdk_selected_color);
            setOrientation(0);
            setLayoutParams(new LinearLayout.LayoutParams(-1, 6));
            setWeightSum(WebChatSelector.this.tabAmount);
            View view = new View(context);
            this.indicator = view;
            view.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            this.indicator.setBackgroundColor(this.SelectedColor);
            addView(this.indicator);
        }

        public void setIndex(int i2) {
            int width = getWidth() / this.sum;
            this.nowIndex = i2;
            View view = this.indicator;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), (this.nowIndex - this.oldIndex) * width);
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        public void setSelectedColor(int i2) {
            this.SelectedColor = i2;
        }

        public void setSum(int i2) {
            this.sum = i2;
        }

        public Line(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.sum = 3;
            this.oldIndex = 0;
            this.nowIndex = 0;
            init(context);
        }

        public Line(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.sum = 3;
            this.oldIndex = 0;
            this.nowIndex = 0;
            init(context);
        }
    }

    public WebChatSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tabAmount = 3;
        this.tabIndex = 0;
        this.listTextSize = -1;
        this.listItemIcon = -1;
        init(context);
    }

    public WebChatSelector(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.tabAmount = 3;
        this.tabIndex = 0;
        this.listTextSize = -1;
        this.listItemIcon = -1;
        init(context);
    }
}
