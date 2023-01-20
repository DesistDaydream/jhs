package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.adapter.MoorFastBtnHorizontalAdapter;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.QuickMenuViewHolder;
import com.m7.imkfsdk.view.SpaceItemDecoration;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.MoorFastBtnBean;
import e.j.e.t.a;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class QuickMenuListRxRow extends BaseChatRow {
    public QuickMenuListRxRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_row_fastbtn_recevied, (ViewGroup) null);
            inflate.setTag(new QuickMenuViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        ArrayList arrayList;
        QuickMenuViewHolder quickMenuViewHolder = (QuickMenuViewHolder) baseHolder;
        if (TextUtils.isEmpty(fromToMessage.message) || (arrayList = (ArrayList) new Gson().o(fromToMessage.message, new a<ArrayList<MoorFastBtnBean>>() { // from class: com.m7.imkfsdk.chat.chatrow.QuickMenuListRxRow.1
        }.getType())) == null || arrayList.size() <= 0) {
            return;
        }
        MoorFastBtnHorizontalAdapter moorFastBtnHorizontalAdapter = new MoorFastBtnHorizontalAdapter(context, arrayList);
        moorFastBtnHorizontalAdapter.setOnItemClickListener(new MoorFastBtnHorizontalAdapter.OnItemClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.QuickMenuListRxRow.2
            @Override // com.m7.imkfsdk.chat.adapter.MoorFastBtnHorizontalAdapter.OnItemClickListener
            public void OnItemClick(View view, MoorFastBtnBean moorFastBtnBean) {
                if (moorFastBtnBean != null) {
                    ((ChatActivity) context).handle_QuickItemClick(moorFastBtnBean);
                }
            }
        });
        RecyclerView recyclerView = new RecyclerView(quickMenuViewHolder.getLl_fast().getContext());
        recyclerView.setPadding(0, 0, MoorDensityUtil.dp2px(5.0f), 0);
        recyclerView.setLayoutManager(new LinearLayoutManager(quickMenuViewHolder.getLl_fast().getContext(), 0, false));
        recyclerView.addItemDecoration(new SpaceItemDecoration(MoorDensityUtil.dp2px(12.0f), 0));
        recyclerView.setAdapter(moorFastBtnHorizontalAdapter);
        quickMenuViewHolder.getLl_fast().removeAllViews();
        quickMenuViewHolder.getLl_fast().addView(recyclerView);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.QUICK_MENU_LIST.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
