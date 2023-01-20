package com.tencent.qcloud.tuicore.component.action;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PopDialogAdapter extends BaseAdapter {
    private List<PopMenuAction> dataSource = new ArrayList();

    /* loaded from: classes3.dex */
    public static class ViewHolder {
        public TextView text;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataSource.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.dataSource.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(TUIConfig.getAppContext()).inflate(R.layout.pop_dialog_adapter, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.pop_dialog_text);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.text.setText(((PopMenuAction) getItem(i2)).getActionName());
        return view;
    }

    public void setDataSource(List list) {
        this.dataSource = list;
        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.action.PopDialogAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                PopDialogAdapter.this.notifyDataSetChanged();
            }
        });
    }
}
