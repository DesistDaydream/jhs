package com.tencent.qcloud.tuikit.tuiconversation.ui.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ForwardConversationSelectorAdapter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ForwardSelectLayout;
import com.tencent.qcloud.tuikit.tuiconversation.util.TUIConversationLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TUIForwardSelectFragment extends BaseFragment {
    private static final String TAG = TUIForwardSelectFragment.class.getSimpleName();
    private ForwardConversationSelectorAdapter mAdapter;
    private View mBaseView;
    private ForwardSelectLayout mForwardLayout;
    private RecyclerView mForwardSelectlistView;
    private RelativeLayout mForwardSelectlistViewLayout;
    private TextView mSureView;
    private TitleBarLayout mTitleBarLayout;
    private ConversationPresenter presenter;
    private List<ConversationInfo> mDataSource = new ArrayList();
    private List<ConversationInfo> mContactDataSource = new ArrayList();
    private List<ConversationInfo> mAllSelectedConversations = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRepeat() {
        Iterator<ConversationInfo> it = this.mContactDataSource.iterator();
        while (it.hasNext()) {
            ConversationInfo next = it.next();
            List<ConversationInfo> list = this.mDataSource;
            if (list != null && list.size() != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mDataSource.size()) {
                        break;
                    } else if (next.getId().equals(this.mDataSource.get(i2).getId())) {
                        it.remove();
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    private void customizeConversation() {
        TitleBarLayout titleBar = this.mForwardLayout.getTitleBar();
        this.mTitleBarLayout = titleBar;
        titleBar.setTitle("", ITitleBarLayout.Position.MIDDLE);
        this.mTitleBarLayout.getLeftGroup().setVisibility(0);
        this.mTitleBarLayout.getRightGroup().setVisibility(0);
        this.mTitleBarLayout.setTitle(getString(R.string.titlebar_close), ITitleBarLayout.Position.LEFT);
        this.mTitleBarLayout.setTitle(getString(R.string.titlebar_mutiselect), ITitleBarLayout.Position.RIGHT);
        this.mTitleBarLayout.getLeftIcon().setVisibility(8);
        this.mTitleBarLayout.getRightIcon().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardMessages(final ConversationInfo conversationInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("");
        builder.setMessage(getString(R.string.forward_alert_title));
        builder.setCancelable(true);
        builder.setPositiveButton(getString(R.string.sure), new DialogInterface.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (TUIForwardSelectFragment.this.getActivity() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(conversationInfo.getId(), Boolean.valueOf(conversationInfo.isGroup()));
                    Intent intent = new Intent();
                    intent.putExtra("forward_select_conversation_key", hashMap);
                    TUIForwardSelectFragment.this.getActivity().setResult(101, intent);
                    TUIForwardSelectFragment.this.getActivity().finish();
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void initTitleAction() {
        this.mForwardLayout.getTitleBar().setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TUIForwardSelectFragment.this.mTitleBarLayout.getLeftTitle().getText().equals(TUIForwardSelectFragment.this.getString(R.string.titlebar_cancle))) {
                    TUIForwardSelectFragment.this.mTitleBarLayout.getRightGroup().setVisibility(0);
                    TUIForwardSelectFragment.this.mTitleBarLayout.setTitle(TUIForwardSelectFragment.this.getString(R.string.titlebar_close), ITitleBarLayout.Position.LEFT);
                    TUIForwardSelectFragment.this.mTitleBarLayout.setTitle(TUIForwardSelectFragment.this.getString(R.string.titlebar_mutiselect), ITitleBarLayout.Position.RIGHT);
                    ConversationListLayout conversationList = TUIForwardSelectFragment.this.mForwardLayout.getConversationList();
                    conversationList.getAdapter().setShowMultiSelectCheckBox(false);
                    conversationList.getAdapter().notifyDataSetChanged();
                    TUIForwardSelectFragment.this.mForwardSelectlistViewLayout.setVisibility(8);
                    TUIForwardSelectFragment.this.mAdapter.setDataSource(null);
                    TUIForwardSelectFragment.this.mAllSelectedConversations.clear();
                } else if (!TUIForwardSelectFragment.this.mTitleBarLayout.getLeftTitle().getText().equals(TUIForwardSelectFragment.this.getString(R.string.titlebar_close))) {
                    TUIConversationLog.d(TUIForwardSelectFragment.TAG, "Titlebar exception");
                } else {
                    TUIForwardSelectFragment.this.getActivity().finish();
                }
            }
        });
        this.mForwardLayout.getTitleBar().setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIForwardSelectFragment.this.mTitleBarLayout.getRightGroup().setVisibility(8);
                TUIForwardSelectFragment.this.mTitleBarLayout.setTitle(TUIForwardSelectFragment.this.getString(R.string.titlebar_cancle), ITitleBarLayout.Position.LEFT);
                ConversationListLayout conversationList = TUIForwardSelectFragment.this.mForwardLayout.getConversationList();
                conversationList.getAdapter().setShowMultiSelectCheckBox(true);
                conversationList.getAdapter().notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSelectConversations() {
        this.mAllSelectedConversations.clear();
        List<ConversationInfo> selectedItem = this.mForwardLayout.getConversationList().getAdapter().getSelectedItem();
        this.mDataSource = selectedItem;
        if (selectedItem != null && selectedItem.size() != 0) {
            this.mAllSelectedConversations.addAll(this.mDataSource);
        }
        List<ConversationInfo> list = this.mContactDataSource;
        if (list != null && list.size() != 0) {
            this.mAllSelectedConversations.addAll(this.mContactDataSource);
        }
        this.mAdapter.setDataSource(this.mAllSelectedConversations);
        List<ConversationInfo> list2 = this.mAllSelectedConversations;
        if (list2 != null && list2.size() != 0) {
            this.mForwardSelectlistViewLayout.setVisibility(0);
            this.mSureView.setVisibility(0);
            TextView textView = this.mSureView;
            textView.setText(getString(R.string.sure) + "(" + this.mAllSelectedConversations.size() + ")");
            return;
        }
        this.mSureView.setText(getString(R.string.sure));
        this.mSureView.setVisibility(8);
        this.mForwardSelectlistViewLayout.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 103 && i3 == 103) {
            if (getActivity() != null) {
                getActivity().setResult(101, intent);
                getActivity().finish();
            }
        } else if (i2 == 102 && i3 == 102) {
            HashMap hashMap = (HashMap) intent.getSerializableExtra("forward_select_conversation_key");
            if (hashMap != null && !hashMap.isEmpty()) {
                this.mContactDataSource.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    ConversationInfo conversationInfo = new ConversationInfo();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(entry.getValue());
                    conversationInfo.setIconUrlList(arrayList);
                    conversationInfo.setId((String) entry.getKey());
                    conversationInfo.setGroup(false);
                    this.mContactDataSource.add(conversationInfo);
                }
                checkRepeat();
                refreshSelectConversations();
                return;
            }
            this.mContactDataSource.clear();
            refreshSelectConversations();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.forward_fragment, viewGroup, false);
        this.mBaseView = inflate;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mForwardLayout = (ForwardSelectLayout) view.findViewById(R.id.forward_conversation_layout);
        ConversationPresenter conversationPresenter = new ConversationPresenter();
        this.presenter = conversationPresenter;
        this.mForwardLayout.setPresenter(conversationPresenter);
        this.mForwardLayout.initDefault();
        customizeConversation();
        this.mForwardLayout.getConversationList().setOnItemClickListener(new ConversationListLayout.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.1
            @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout.OnItemClickListener
            public void onItemClick(View view2, int i2, ConversationInfo conversationInfo) {
                if (i2 == 1) {
                    return;
                }
                if (i2 == 0) {
                    if (!TUIForwardSelectFragment.this.mTitleBarLayout.getLeftTitle().getText().equals(TUIForwardSelectFragment.this.getString(R.string.titlebar_cancle))) {
                        if (!TUIForwardSelectFragment.this.mTitleBarLayout.getLeftTitle().getText().equals(TUIForwardSelectFragment.this.getString(R.string.titlebar_close))) {
                            TUIConversationLog.d(TUIForwardSelectFragment.TAG, "Titlebar exception");
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("type", 1);
                        bundle2.putBoolean("forward_create_new_chat", true);
                        TUICore.startActivity(TUIForwardSelectFragment.this, "ForwardSelectGroupActivity", bundle2, 103);
                        return;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("type", 1);
                    bundle3.putBoolean("forward_create_new_chat", false);
                    TUICore.startActivity(TUIForwardSelectFragment.this, "ForwardSelectGroupActivity", bundle3, 102);
                } else if (!TUIForwardSelectFragment.this.mTitleBarLayout.getLeftTitle().getText().equals(TUIForwardSelectFragment.this.getString(R.string.titlebar_cancle))) {
                    if (TUIForwardSelectFragment.this.mTitleBarLayout.getLeftTitle().getText().equals(TUIForwardSelectFragment.this.getString(R.string.titlebar_close))) {
                        TUIForwardSelectFragment.this.forwardMessages(conversationInfo);
                    } else {
                        TUIForwardSelectFragment.this.forwardMessages(conversationInfo);
                    }
                } else {
                    TUIForwardSelectFragment tUIForwardSelectFragment = TUIForwardSelectFragment.this;
                    tUIForwardSelectFragment.mDataSource = tUIForwardSelectFragment.mForwardLayout.getConversationList().getAdapter().getSelectedItem();
                    TUIForwardSelectFragment.this.checkRepeat();
                    TUIForwardSelectFragment.this.refreshSelectConversations();
                }
            }
        });
        this.mForwardLayout.getConversationList().setOnItemLongClickListener(new ConversationListLayout.OnItemLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.2
            @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout.OnItemLongClickListener
            public void OnItemLongClick(View view2, int i2, ConversationInfo conversationInfo) {
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.forward_select_list_layout);
        this.mForwardSelectlistViewLayout = relativeLayout;
        relativeLayout.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.forward_select_list);
        this.mForwardSelectlistView = recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(getContext(), 0, false));
        ForwardConversationSelectorAdapter forwardConversationSelectorAdapter = new ForwardConversationSelectorAdapter(getContext());
        this.mAdapter = forwardConversationSelectorAdapter;
        this.mForwardSelectlistView.setAdapter(forwardConversationSelectorAdapter);
        this.mAdapter.setOnItemClickListener(new ForwardConversationSelectorAdapter.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.3
            /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ForwardConversationSelectorAdapter.OnItemClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r4, int r5) {
                /*
                    r3 = this;
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$200(r4)
                    r0 = 1
                    r1 = 0
                    if (r4 == 0) goto L44
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$200(r4)
                    int r4 = r4.size()
                    if (r4 == 0) goto L44
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$200(r4)
                    int r4 = r4.size()
                    if (r5 >= r4) goto L44
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$200(r4)
                    r4.remove(r5)
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    com.tencent.qcloud.tuikit.tuiconversation.ui.view.ForwardSelectLayout r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$300(r4)
                    com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout r4 = r4.getConversationList()
                    com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter r4 = r4.getAdapter()
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$200(r2)
                    r4.setSelectConversations(r2)
                    r4 = 1
                    goto L45
                L44:
                    r4 = 0
                L45:
                    if (r4 != 0) goto L85
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$700(r2)
                    if (r2 == 0) goto L85
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$700(r2)
                    int r2 = r2.size()
                    if (r2 == 0) goto L85
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r2 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$200(r2)
                    if (r2 != 0) goto L64
                    goto L6e
                L64:
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r1 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r1 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$200(r1)
                    int r1 = r1.size()
                L6e:
                    int r5 = r5 - r1
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r1 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r1 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$700(r1)
                    int r1 = r1.size()
                    if (r5 >= r1) goto L85
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    java.util.List r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$700(r4)
                    r4.remove(r5)
                    goto L86
                L85:
                    r0 = r4
                L86:
                    if (r0 == 0) goto L8d
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment r4 = com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.this
                    com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.access$500(r4)
                L8d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.AnonymousClass3.onClick(android.view.View, int):void");
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.btn_msg_ok);
        this.mSureView = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.page.TUIForwardSelectFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TUIForwardSelectFragment.this.getActivity() != null) {
                    HashMap hashMap = new HashMap();
                    if (TUIForwardSelectFragment.this.mDataSource != null && TUIForwardSelectFragment.this.mDataSource.size() != 0) {
                        for (int i2 = 0; i2 < TUIForwardSelectFragment.this.mDataSource.size(); i2++) {
                            hashMap.put(((ConversationInfo) TUIForwardSelectFragment.this.mDataSource.get(i2)).getId(), Boolean.valueOf(((ConversationInfo) TUIForwardSelectFragment.this.mDataSource.get(i2)).isGroup()));
                        }
                    }
                    if (TUIForwardSelectFragment.this.mContactDataSource != null && TUIForwardSelectFragment.this.mContactDataSource.size() != 0) {
                        for (int i3 = 0; i3 < TUIForwardSelectFragment.this.mContactDataSource.size(); i3++) {
                            hashMap.put(((ConversationInfo) TUIForwardSelectFragment.this.mContactDataSource.get(i3)).getId(), Boolean.valueOf(((ConversationInfo) TUIForwardSelectFragment.this.mContactDataSource.get(i3)).isGroup()));
                        }
                    }
                    Intent intent = new Intent();
                    intent.putExtra("forward_select_conversation_key", hashMap);
                    TUIForwardSelectFragment.this.getActivity().setResult(101, intent);
                    TUIForwardSelectFragment.this.getActivity().finish();
                }
            }
        });
        refreshSelectConversations();
        initTitleAction();
    }
}
