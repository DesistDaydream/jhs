package com.m7.imkfsdk.view.dropdownmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.utils.FIleResourceUtil;

/* loaded from: classes2.dex */
public class MenuListAdapter extends BaseAdapter {
    private int CheckIcon;
    private int SelectIndex;
    private int TextColor = ViewCompat.MEASURED_STATE_MASK;
    private int TextSize = 15;
    private Context context;
    private int mTextColorSelected;
    private boolean showCheck;
    private String[] strs;

    public MenuListAdapter(Context context, String[] strArr) {
        this.context = context;
        this.strs = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.strs.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.strs[i2];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.ykfsdk_kf_menu_list_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_menu_item);
        textView.setTextSize(this.TextSize);
        textView.setTextColor(this.TextColor);
        textView.setText(this.strs[i2]);
        if (this.showCheck && this.SelectIndex == i2) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_menu_select);
            imageView.setVisibility(0);
            int i3 = this.mTextColorSelected;
            if (i3 != 0 && i3 != FIleResourceUtil.getCurrentColor(this.context, R.attr.ykfsdk_ykf_theme_color_default)) {
                textView.setTextColor(this.mTextColorSelected);
            } else {
                textView.setTextColor(FIleResourceUtil.getCurrentColor(this.context, R.attr.ykfsdk_ykf_theme_color_default));
            }
            int i4 = this.CheckIcon;
            if (i4 != 0) {
                imageView.setImageResource(i4);
            }
        }
        return inflate;
    }

    public void setCheckIcon(int i2) {
        this.CheckIcon = i2;
    }

    public void setSelectIndex(int i2) {
        this.SelectIndex = i2;
    }

    public void setShowCheck(boolean z) {
        this.showCheck = z;
    }

    public void setTextColor(int i2) {
        this.TextColor = i2;
    }

    public void setTextColorSelected(int i2) {
        this.mTextColorSelected = i2;
    }

    public void setTextSize(int i2) {
        this.TextSize = i2;
    }
}
