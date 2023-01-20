package com.tencent.qcloud.tuikit.tuichat.ui.view.input.inputmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import java.util.List;

/* loaded from: classes3.dex */
public class ActionsGridViewAdapter extends BaseAdapter {
    private List<InputMoreActionUnit> baseActions;
    private Context context;

    public ActionsGridViewAdapter(Context context, List<InputMoreActionUnit> list) {
        this.context = context;
        this.baseActions = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.baseActions.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.baseActions.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InputMoreActionUnit inputMoreActionUnit = this.baseActions.get(i2);
        View unitView = inputMoreActionUnit.getUnitView();
        if (unitView != null) {
            return unitView;
        }
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.chat_input_layout_actoin, viewGroup, false);
        }
        if (inputMoreActionUnit.getIconResId() > 0) {
            ((ImageView) view.findViewById(R.id.imageView)).setImageResource(inputMoreActionUnit.getIconResId());
        }
        if (inputMoreActionUnit.getTitleId() > 0) {
            ((TextView) view.findViewById(R.id.textView)).setText(this.context.getString(inputMoreActionUnit.getTitleId()));
        }
        return view;
    }
}
