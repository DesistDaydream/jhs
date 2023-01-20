package com.m7.imkfsdk.view.bottomselectview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.moor.imkf.model.entity.AddressData;
import java.util.List;

/* loaded from: classes2.dex */
public class WebChatSelectAdapter extends BaseAdapter {
    public List<AddressData> list;
    public Context mContext;
    public int selected = -1;

    /* loaded from: classes2.dex */
    public class ViewHolder {
        public RelativeLayout lin;
        public TextView name;
        public TextView select;

        public ViewHolder() {
        }
    }

    public WebChatSelectAdapter(Context context, List<AddressData> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    public int getSelected() {
        return this.selected;
    }

    @Override // android.widget.Adapter
    public View getView(final int i2, View view, ViewGroup viewGroup) {
        View view2;
        final ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.mContext).inflate(R.layout.ykfsdk_kf_item_view_chatselect, (ViewGroup) null);
            viewHolder.lin = (RelativeLayout) view2.findViewById(R.id.item_view_address_lin);
            viewHolder.name = (TextView) view2.findViewById(R.id.item_view_address_name);
            viewHolder.select = (TextView) view2.findViewById(R.id.item_view_address_select);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.name.setText(getItem(i2).getCityName());
        viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.bottomselectview.WebChatSelectAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (WebChatSelectAdapter.this.selected == i2) {
                    viewHolder.select.setVisibility(8);
                    WebChatSelectAdapter.this.selected = -1;
                } else {
                    viewHolder.select.setVisibility(0);
                    WebChatSelectAdapter.this.selected = i2;
                }
                WebChatSelectAdapter.this.notifyDataSetChanged();
            }
        });
        if (this.selected == i2) {
            viewHolder.select.setVisibility(0);
        } else {
            viewHolder.select.setVisibility(8);
        }
        return view2;
    }

    @Override // android.widget.Adapter
    public AddressData getItem(int i2) {
        return this.list.get(i2);
    }
}
