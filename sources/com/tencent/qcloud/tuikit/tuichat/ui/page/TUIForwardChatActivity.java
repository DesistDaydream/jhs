package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import e.s.a.b.a.b.a.a;

/* loaded from: classes3.dex */
public class TUIForwardChatActivity extends BaseLightActivity {
    private static final String TAG = TUIForwardChatActivity.class.getSimpleName();
    private MessageAdapter mForwardChatAdapter;
    private MessageRecyclerView mFowardChatMessageRecyclerView;
    private MergeMessageBean mMessageInfo;
    private String mTitle;
    private TitleBarLayout mTitleBar;
    private ForwardPresenter presenter;

    private void init() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mTitleBar.setTitle(this.mTitle, ITitleBarLayout.Position.MIDDLE);
            this.mTitleBar.getRightGroup().setVisibility(8);
            MergeMessageBean mergeMessageBean = (MergeMessageBean) intent.getSerializableExtra(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY);
            this.mMessageInfo = mergeMessageBean;
            if (mergeMessageBean == null) {
                TUIChatLog.e(TAG, "mMessageInfo is null");
            } else {
                this.presenter.downloadMergerMessage(mergeMessageBean);
            }
        }
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forward_chat_layout);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        this.mFowardChatMessageRecyclerView = messageRecyclerView;
        messageRecyclerView.setLayoutManager(new CustomLinearLayoutManager(this, 1, false));
        MessageAdapter messageAdapter = new MessageAdapter();
        this.mForwardChatAdapter = messageAdapter;
        messageAdapter.setForwardMode(true);
        ForwardPresenter forwardPresenter = new ForwardPresenter();
        this.presenter = forwardPresenter;
        forwardPresenter.setMessageListAdapter(this.mForwardChatAdapter);
        this.mForwardChatAdapter.setPresenter(this.presenter);
        this.mFowardChatMessageRecyclerView.setAdapter(this.mForwardChatAdapter);
        this.mFowardChatMessageRecyclerView.setPresenter(this.presenter);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.chat_title_bar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIForwardChatActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIForwardChatActivity.this.finish();
            }
        });
        this.mFowardChatMessageRecyclerView.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.TUIForwardChatActivity.2
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onMessageClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                a.$default$onMessageClick(this, view, i2, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onReplyMessageClick(View view, int i2, String str) {
                a.$default$onReplyMessageClick(this, view, i2, str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onSendFailBtnClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                a.$default$onSendFailBtnClick(this, view, i2, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onTextSelected(View view, int i2, TUIMessageBean tUIMessageBean) {
                a.$default$onTextSelected(this, view, i2, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean instanceof MergeMessageBean) {
                    Intent intent = new Intent(TUIForwardChatActivity.this.getBaseContext(), TUIForwardChatActivity.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                    intent.putExtras(bundle2);
                    TUIForwardChatActivity.this.startActivity(intent);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
            }
        });
        init();
    }
}
