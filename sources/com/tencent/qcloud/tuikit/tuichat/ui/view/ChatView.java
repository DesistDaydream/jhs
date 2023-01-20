package com.tencent.qcloud.tuikit.tuichat.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.UnreadCountTextView;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.setting.ChatLayoutSetting;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import e.s.a.b.a.a.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ChatView extends LinearLayout implements IChatLayout {
    private static final int FORWARD_MSG_NUM_LIMIT = 30;
    private static final String TAG = ChatView.class.getSimpleName();
    private boolean isGroup;
    public MessageAdapter mAdapter;
    private ImageView mArrowImageView;
    private ChatInfo mChatInfo;
    private boolean mClickLastMessageShow;
    private TUIMessageBean mConversationLastMessage;
    private Button mDeleteButton;
    private Button mForwardButton;
    private LinearLayout mForwardLayout;
    private ForwardSelectActivityListener mForwardSelectActivityListener;
    public NoticeLayout mGroupApplyLayout;
    private InputView mInputView;
    private boolean mJumpGroupAtInfoShow;
    private LinearLayout mJumpMessageLayout;
    private TextView mJumpMessageTextView;
    private boolean mJumpNewMessageShow;
    private MessageRecyclerView mMessageRecyclerView;
    private NoticeLayout mNoticeLayout;
    public View mRecordingGroup;
    public ImageView mRecordingIcon;
    public TextView mRecordingTips;
    private TitleBarLayout mTitleBar;
    private ChatPresenter.TypingListener mTypingListener;
    private Runnable mTypingRunnable;
    private AnimationDrawable mVolumeAnim;
    private ChatPresenter presenter;
    private TotalUnreadCountListener unreadCountListener;

    /* loaded from: classes3.dex */
    public interface ForwardSelectActivityListener {
        void onStartForwardSelectActivity(int i2, List<TUIMessageBean> list);
    }

    public ChatView(Context context) {
        super(context);
        this.mTypingRunnable = null;
        this.mTypingListener = new ChatPresenter.TypingListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.TypingListener
            public void onTyping() {
                final String charSequence = ChatView.this.getTitleBar().getMiddleTitle().getText().toString();
                ChatView.this.getTitleBar().getMiddleTitle().setText(R.string.typing);
                if (ChatView.this.mTypingRunnable == null) {
                    ChatView.this.mTypingRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChatView.this.getTitleBar().getMiddleTitle().setText(charSequence);
                        }
                    };
                }
                ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                ChatView.this.getTitleBar().getMiddleTitle().postDelayed(ChatView.this.mTypingRunnable, 3000L);
            }
        };
        this.isGroup = false;
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGroupAtInfoLayout() {
        ChatInfo chatInfo = this.mChatInfo;
        if (chatInfo != null) {
            List<V2TIMGroupAtInfo> atInfoList = chatInfo.getAtInfoList();
            if (atInfoList != null && atInfoList.size() > 0) {
                V2TIMGroupAtInfo v2TIMGroupAtInfo = atInfoList.get(0);
                if (v2TIMGroupAtInfo != null) {
                    displayBackToAtMessages(v2TIMGroupAtInfo);
                    return;
                }
                this.mJumpGroupAtInfoShow = false;
                hideJumpMessageLayouts();
                return;
            }
            TUIChatLog.d(TAG, "initGroupAtInfoLayout groupAtInfos == null");
            this.mJumpGroupAtInfoShow = false;
            hideJumpMessageLayouts();
            return;
        }
        TUIChatLog.d(TAG, "initGroupAtInfoLayout mChatInfo == null");
        this.mJumpGroupAtInfoShow = false;
        hideJumpMessageLayouts();
    }

    private void initListener() {
        getMessageLayout().setPopActionClickListener(new MessageRecyclerView.OnPopActionClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.14
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnPopActionClickListener
            public void onCopyClick(TUIMessageBean tUIMessageBean) {
                TUIMessageBean contentMessageBean;
                ClipboardManager clipboardManager = (ClipboardManager) ChatView.this.getContext().getSystemService("clipboard");
                if (clipboardManager == null || tUIMessageBean == null) {
                    return;
                }
                if (tUIMessageBean instanceof TextMessageBean) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("message", ((TextMessageBean) tUIMessageBean).getSelectText()));
                } else if ((tUIMessageBean instanceof ReplyMessageBean) && (contentMessageBean = ((ReplyMessageBean) tUIMessageBean).getContentMessageBean()) != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("message", contentMessageBean.getExtra()));
                }
                ToastUtil.toastShortMessage(ChatView.this.getResources().getString(R.string.copy_success_tip));
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnPopActionClickListener
            public void onDeleteMessageClick(final TUIMessageBean tUIMessageBean) {
                new TUIKitDialog(ChatView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(ChatView.this.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f).setPositiveButton(ChatView.this.getContext().getString(R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.14.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ChatView.this.deleteMessage(tUIMessageBean);
                    }
                }).setNegativeButton(ChatView.this.getContext().getString(R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.14.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                }).show();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnPopActionClickListener
            public void onForwardMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.forwardMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnPopActionClickListener
            public void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.multiSelectMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnPopActionClickListener
            public void onReplyMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.replyMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnPopActionClickListener
            public void onRevokeMessageClick(TUIMessageBean tUIMessageBean) {
                ChatView.this.revokeMessage(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnPopActionClickListener
            public void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z) {
                ChatView.this.sendMessage(tUIMessageBean, z);
            }
        });
        getMessageLayout().setLoadMoreMessageHandler(new MessageRecyclerView.OnLoadMoreHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.15
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToLastMessage(boolean z) {
                if (ChatView.this.mJumpNewMessageShow) {
                    return;
                }
                if (z) {
                    MessageAdapter messageAdapter = ChatView.this.mAdapter;
                    if (messageAdapter == null) {
                        TUIChatLog.e(ChatView.TAG, "displayJumpLayout mAdapter is null");
                        return;
                    }
                    TUIMessageBean tUIMessageBean = null;
                    int itemCount = messageAdapter.getItemCount() - 1;
                    while (true) {
                        if (itemCount >= 0) {
                            TUIMessageBean item = ChatView.this.mAdapter.getItem(itemCount);
                            if (item != null && item.getStatus() != 275) {
                                tUIMessageBean = ChatView.this.mAdapter.getItem(itemCount);
                                break;
                            }
                            itemCount--;
                        } else {
                            break;
                        }
                    }
                    if (tUIMessageBean == null) {
                        TUIChatLog.e(ChatView.TAG, "displayJumpLayout messageBean is null");
                        return;
                    } else {
                        ChatView.this.displayBackToLastMessages(tUIMessageBean.getId());
                        return;
                    }
                }
                ChatView.this.hideJumpMessageLayouts();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnLoadMoreHandler
            public void displayBackToNewMessage(boolean z, String str, int i2) {
                if (z) {
                    ChatView.this.displayBackToNewMessages(str, i2);
                    return;
                }
                ChatView.this.mJumpNewMessageShow = false;
                ChatView.this.hideJumpMessageLayouts();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnLoadMoreHandler
            public void hideBackToAtMessage() {
                ChatView.this.hideBackToAtMessages();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnLoadMoreHandler
            public boolean isListEnd(int i2) {
                return ChatView.this.getMessageLayout().isLastItemVisibleCompleted();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMessageFinish() {
                ChatView.this.initGroupAtInfoLayout();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnLoadMoreHandler
            public void loadMore(int i2) {
                ChatView.this.loadMessages(i2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnLoadMoreHandler
            public void scrollMessageFinish() {
                if (!ChatView.this.mClickLastMessageShow || ChatView.this.mMessageRecyclerView == null) {
                    return;
                }
                ChatView.this.mClickLastMessageShow = false;
                ChatView.this.mMessageRecyclerView.setHighShowPosition(-1);
            }
        });
        getMessageLayout().setEmptySpaceClickListener(new MessageRecyclerView.OnEmptySpaceClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.16
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnEmptySpaceClickListener
            public void onClick() {
                ChatView.this.getInputLayout().onEmptyClick();
            }
        });
        getInputLayout().setChatInputHandler(new InputView.ChatInputHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.17
            private void cancelRecording() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.17.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.ic_volume_dialog_cancel);
                        ChatView.this.mRecordingTips.setText(TUIChatService.getAppContext().getString(R.string.up_cancle_send));
                    }
                });
            }

            private void startRecording() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.17.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioPlayer.getInstance().stopPlay();
                        ChatView.this.mRecordingGroup.setVisibility(0);
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.recording_volume);
                        ChatView chatView = ChatView.this;
                        chatView.mVolumeAnim = (AnimationDrawable) chatView.mRecordingIcon.getDrawable();
                        ChatView.this.mVolumeAnim.start();
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        ChatView.this.mRecordingTips.setText(TUIChatService.getAppContext().getString(R.string.down_cancle_send));
                    }
                });
            }

            private void stopAbnormally(final int i2) {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.17.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mVolumeAnim.stop();
                        ChatView.this.mRecordingIcon.setImageResource(R.drawable.ic_volume_dialog_length_short);
                        ChatView.this.mRecordingTips.setTextColor(-1);
                        if (i2 == 4) {
                            ChatView.this.mRecordingTips.setText(TUIChatService.getAppContext().getString(R.string.say_time_short));
                        } else {
                            ChatView.this.mRecordingTips.setText(TUIChatService.getAppContext().getString(R.string.record_fail));
                        }
                    }
                });
                ChatView.this.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.17.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                }, 1000L);
            }

            private void stopRecording() {
                ChatView.this.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.17.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ChatView.this.mVolumeAnim != null) {
                            ChatView.this.mVolumeAnim.stop();
                        }
                        ChatView.this.mRecordingGroup.setVisibility(8);
                    }
                }, 500L);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.ChatInputHandler
            public void onInputAreaClick() {
                ChatView.this.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.ChatInputHandler
            public void onRecordStatusChanged(int i2) {
                if (i2 == 1) {
                    startRecording();
                } else if (i2 == 2) {
                    stopRecording();
                } else if (i2 == 3) {
                    cancelRecording();
                } else if (i2 == 4 || i2 == 5) {
                    stopAbnormally(i2);
                }
            }
        });
    }

    private void initViews() {
        LinearLayout.inflate(getContext(), R.layout.chat_layout, this);
        this.mTitleBar = (TitleBarLayout) findViewById(R.id.chat_title_bar);
        this.mMessageRecyclerView = (MessageRecyclerView) findViewById(R.id.chat_message_layout);
        InputView inputView = (InputView) findViewById(R.id.chat_input_layout);
        this.mInputView = inputView;
        inputView.setChatLayout(this);
        this.mRecordingGroup = findViewById(R.id.voice_recording_view);
        this.mRecordingIcon = (ImageView) findViewById(R.id.recording_icon);
        this.mRecordingTips = (TextView) findViewById(R.id.recording_tips);
        this.mGroupApplyLayout = (NoticeLayout) findViewById(R.id.chat_group_apply_layout);
        this.mNoticeLayout = (NoticeLayout) findViewById(R.id.chat_notice_layout);
        this.mForwardLayout = (LinearLayout) findViewById(R.id.forward_layout);
        this.mForwardButton = (Button) findViewById(R.id.forward_button);
        this.mDeleteButton = (Button) findViewById(R.id.delete_button);
        this.mJumpMessageLayout = (LinearLayout) findViewById(R.id.jump_message_layout);
        this.mJumpMessageTextView = (TextView) findViewById(R.id.jump_message_content);
        this.mArrowImageView = (ImageView) findViewById(R.id.arrow_icon);
        this.mJumpNewMessageShow = false;
        hideJumpMessageLayouts();
        this.mTitleBar.getMiddleTitle().setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleBar.setBackgroundColor(getResources().getColor(R.color.chat_title_bar_bg));
    }

    private void loadApplyList() {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter == null) {
            return;
        }
        chatPresenter.loadApplyList(new IUIKitCallback<List<GroupApplyInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.13
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastLongMessage("loadApplyList onError: " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<GroupApplyInfo> list) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                ChatView.this.mGroupApplyLayout.getContent().setText(ChatView.this.getContext().getString(R.string.group_apply_tips, Integer.valueOf(list.size())));
                ChatView.this.mGroupApplyLayout.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void locateOriginMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getContext().getString(R.string.locate_origin_msg_failed_tip));
            return;
        }
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter == null) {
            return;
        }
        chatPresenter.locateMessage(str, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.6
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                ChatView.this.hideJumpMessageLayouts();
                ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
                ChatView.this.hideJumpMessageLayouts();
            }
        });
        hideJumpMessageLayouts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void locateOriginMessageBySeq(long j2) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter == null) {
            return;
        }
        chatPresenter.locateMessageBySeq(this.mChatInfo.getId(), j2, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.5
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ChatView.this.hideJumpMessageLayouts();
                ToastUtil.toastShortMessage(ChatView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
                ChatView.this.hideJumpMessageLayouts();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebUrl(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetForwardState(String str) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setShowMultiSelectCheckBox(false);
            this.mAdapter.notifyDataSetChanged();
        }
        resetTitleBar(str);
    }

    private void resetTitleBar(String str) {
        getTitleBar().getRightGroup().setVisibility(0);
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().getLeftIcon().setVisibility(0);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChatView.this.getContext() instanceof Activity) {
                    ((Activity) ChatView.this.getContext()).finish();
                }
            }
        });
        getForwardLayout().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGroupMsgReadReceipt(int i2, int i3) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter == null || this.presenter == null) {
            return;
        }
        this.presenter.sendGroupMessageReadReceipt(messageAdapter.getItemList(i2, i3), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.10
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i4, String str2) {
                if (i4 == 7013) {
                    ChatView.this.showNotSupportDialog();
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
            }
        });
    }

    private void setChatHandler() {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter instanceof GroupChatPresenter) {
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.11
                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onApplied(int i2) {
                    ChatView.this.onApplied(i2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onExitChat(String str) {
                    ChatView.this.onExitChat();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onFriendNameChanged(String str) {
                    a.$default$onFriendNameChanged(this, str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onGroupForceExit() {
                    ChatView.this.onExitChat();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onGroupNameChanged(String str) {
                    ChatView.this.onGroupNameChanged(str);
                }
            });
        } else if (chatPresenter instanceof C2CChatPresenter) {
            chatPresenter.setChatNotifyHandler(new ChatPresenter.ChatNotifyHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.12
                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onApplied(int i2) {
                    a.$default$onApplied(this, i2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onExitChat(String str) {
                    ChatView.this.onExitChat();
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public void onFriendNameChanged(String str) {
                    ChatView.this.onFriendNameChanged(str);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onGroupForceExit() {
                    a.$default$onGroupForceExit(this);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.ChatNotifyHandler
                public /* synthetic */ void onGroupNameChanged(String str) {
                    a.$default$onGroupNameChanged(this, str);
                }
            });
        }
    }

    private void setTitleBarWhenMultiSelectMessage() {
        getTitleBar().getRightGroup().setVisibility(8);
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().getLeftIcon().setVisibility(8);
        final CharSequence text = getTitleBar().getLeftTitle().getText();
        getTitleBar().setTitle(getContext().getString(R.string.cancel), ITitleBarLayout.Position.LEFT);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.resetForwardState(text.toString());
            }
        });
        getForwardLayout().setVisibility(0);
        getForwardButton().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.showForwardDialog(true);
            }
        });
        getDeleteButton().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ArrayList<TUIMessageBean> selectedItem = ChatView.this.mAdapter.getSelectedItem();
                if (selectedItem != null && !selectedItem.isEmpty()) {
                    ChatView.this.deleteMessageInfos(selectedItem);
                    ChatView.this.resetForwardState(text.toString());
                    return;
                }
                ToastUtil.toastShortMessage("please select message!");
            }
        });
    }

    private void setTotalUnread() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showForwardDialog(boolean z) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter == null) {
            return;
        }
        final ArrayList<TUIMessageBean> selectedItem = messageAdapter.getSelectedItem();
        if (selectedItem != null && !selectedItem.isEmpty()) {
            if (checkFailedMessageInfos(selectedItem)) {
                ToastUtil.toastShortMessage(getContext().getString(R.string.forward_failed_tip));
                return;
            }
            if (!z) {
                this.mAdapter.setShowMultiSelectCheckBox(false);
            }
            final Dialog dialog = new Dialog(getContext(), R.style.BottomDialog);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.forward_dialog_layout, (ViewGroup) null);
            dialog.setContentView(inflate);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) inflate.getLayoutParams();
            marginLayoutParams.width = getResources().getDisplayMetrics().widthPixels - 8;
            inflate.setLayoutParams(marginLayoutParams);
            dialog.getWindow().setGravity(80);
            dialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
            dialog.show();
            inflate.findViewById(R.id.forward_one_by_one).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (selectedItem.size() > 30) {
                        ChatView.this.showForwardLimitDialog(dialog, selectedItem);
                        return;
                    }
                    dialog.dismiss();
                    ChatView.this.startSelectForwardActivity(0, selectedItem);
                    ChatView.this.resetForwardState("");
                }
            });
            inflate.findViewById(R.id.forward_merge).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                    ChatView.this.startSelectForwardActivity(1, selectedItem);
                    ChatView.this.resetForwardState("");
                }
            });
            inflate.findViewById(R.id.cancel_action).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.27
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            return;
        }
        ToastUtil.toastShortMessage(getContext().getString(R.string.forward_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showForwardLimitDialog(final Dialog dialog, final List<TUIMessageBean> list) {
        new TUIKitDialog(getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(getContext().getString(R.string.forward_oneByOne_limit_number_tip)).setDialogWidth(0.75f).setPositiveButton(getContext().getString(R.string.forward_mode_merge), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dialog.dismiss();
                ChatView.this.startSelectForwardActivity(1, list);
                ChatView.this.resetForwardState("");
            }
        }).setNegativeButton(getContext().getString(R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotSupportDialog() {
        String string = getResources().getString(R.string.chat_im_flagship_edition_update_tip, getResources().getString(R.string.chat_message_read_receipt));
        String string2 = getResources().getString(R.string.chat_buying_guidelines);
        int lastIndexOf = string.lastIndexOf(string2);
        int color = getResources().getColor(TUIThemeManager.getAttrResId(getContext(), R.attr.core_primary_color));
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(color), lastIndexOf, string2.length() + lastIndexOf, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.31
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (TextUtils.equals(TUIThemeManager.getInstance().getCurrentLanguage(), "zh")) {
                    ChatView.this.openWebUrl("https://cloud.tencent.com/document/product/269/32458");
                } else {
                    ChatView.this.openWebUrl("https://intl.cloud.tencent.com/document/product/1047/36021?lang=en&pg=#changing-configuration");
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, lastIndexOf, string2.length() + lastIndexOf, 34);
        TUIKitDialog.TUIIMUpdateDialog.getInstance().createDialog(getContext()).setShowOnlyDebug(true).setMovementMethod(LinkMovementMethod.getInstance()).setCancelable(true).setCancelOutside(true).setTitle(spannableString).setDialogWidth(0.75f).setPositiveButton(getResources().getString(R.string.chat_no_more_reminders), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
                TUIKitDialog.TUIIMUpdateDialog.getInstance().setNeverShow(true);
            }
        }).setNegativeButton(getResources().getString(R.string.chat_i_know), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIKitDialog.TUIIMUpdateDialog.getInstance().dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSelectForwardActivity(int i2, List<TUIMessageBean> list) {
        ForwardSelectActivityListener forwardSelectActivityListener = this.mForwardSelectActivityListener;
        if (forwardSelectActivityListener != null) {
            forwardSelectActivityListener.onStartForwardSelectActivity(i2, list);
        }
    }

    private void updateUnreadCount(UnreadCountTextView unreadCountTextView, long j2) {
        if (j2 <= 0) {
            unreadCountTextView.setVisibility(8);
            return;
        }
        unreadCountTextView.setVisibility(0);
        String str = j2 + "";
        if (j2 > 99) {
            str = "99+";
        }
        unreadCountTextView.setText(str);
    }

    public boolean checkFailedMessage(List<Integer> list) {
        return this.presenter.checkFailedMessages(list);
    }

    public boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            return chatPresenter.checkFailedMessageInfos(list);
        }
        return false;
    }

    public void deleteMessage(TUIMessageBean tUIMessageBean) {
        this.presenter.deleteMessage(tUIMessageBean);
    }

    public void deleteMessageInfos(List<TUIMessageBean> list) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.deleteMessageInfos(list);
        }
    }

    public void deleteMessages(List<Integer> list) {
        this.presenter.deleteMessages(list);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MessageAdapter messageAdapter;
        if (motionEvent.getAction() == 0 && (messageAdapter = this.mAdapter) != null) {
            messageAdapter.resetSelectableText();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void displayBackToAtMessages(final V2TIMGroupAtInfo v2TIMGroupAtInfo) {
        this.mJumpGroupAtInfoShow = true;
        this.mJumpMessageLayout.setVisibility(8);
        this.mArrowImageView.setImageResource(R.drawable.ic_arrow_up);
        if (v2TIMGroupAtInfo.getAtType() == 2) {
            this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_atmessage_all));
        } else {
            this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_atmessage_me));
        }
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessageBySeq(v2TIMGroupAtInfo.getSeq());
                ChatView.this.hideJumpMessageLayouts();
                ChatView.this.mJumpGroupAtInfoShow = false;
            }
        });
    }

    public void displayBackToLastMessages(final String str) {
        this.mJumpMessageLayout.setVisibility(8);
        this.mArrowImageView.setImageResource(R.drawable.ic_arrow_down);
        this.mJumpMessageTextView.setText(getContext().getString(R.string.back_to_lastmessage));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                ChatView.this.mClickLastMessageShow = true;
            }
        });
    }

    public void displayBackToNewMessages(final String str, int i2) {
        this.mJumpNewMessageShow = true;
        this.mJumpMessageLayout.setVisibility(8);
        this.mArrowImageView.setImageResource(R.drawable.ic_arrow_down);
        TextView textView = this.mJumpMessageTextView;
        textView.setText(String.valueOf(i2) + getContext().getString(R.string.back_to_newmessage));
        this.mJumpMessageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatView.this.locateOriginMessage(str);
                ChatView.this.presenter.markMessageAsRead(ChatView.this.mChatInfo);
                ChatView.this.mJumpNewMessageShow = false;
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public void exitChat() {
        getTitleBar().getMiddleTitle().removeCallbacks(this.mTypingRunnable);
        AudioPlayer.getInstance().stopRecord();
        AudioPlayer.getInstance().stopPlay();
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.markMessageAsRead(this.mChatInfo);
        }
    }

    public void forwardMessage(TUIMessageBean tUIMessageBean) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            showForwardDialog(false);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public ChatInfo getChatInfo() {
        return this.mChatInfo;
    }

    public void getConversationLastMessage(String str) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter == null) {
            return;
        }
        chatPresenter.getConversationLastMessage(str, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.20
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean == null) {
                    Log.d(ChatView.TAG, "getConversationLastMessage failed");
                } else {
                    ChatView.this.mConversationLastMessage = tUIMessageBean;
                }
            }
        });
    }

    public Button getDeleteButton() {
        return this.mDeleteButton;
    }

    public Button getForwardButton() {
        return this.mForwardButton;
    }

    public LinearLayout getForwardLayout() {
        return this.mForwardLayout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public InputView getInputLayout() {
        return this.mInputView;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public MessageRecyclerView getMessageLayout() {
        return this.mMessageRecyclerView;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public NoticeLayout getNoticeLayout() {
        return this.mNoticeLayout;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public TitleBarLayout getTitleBar() {
        return this.mTitleBar;
    }

    public void hideBackToAtMessages() {
        if (this.mJumpGroupAtInfoShow) {
            this.mJumpGroupAtInfoShow = false;
            hideJumpMessageLayouts();
        }
    }

    public void hideJumpMessageLayouts() {
        this.mJumpMessageLayout.setVisibility(8);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public void initDefault() {
        getTitleBar().getLeftGroup().setVisibility(0);
        getTitleBar().setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ChatView.this.getContext() instanceof Activity) {
                    ((Activity) ChatView.this.getContext()).finish();
                }
            }
        });
        getInputLayout().setMessageHandler(new InputView.MessageHandler() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.19
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.MessageHandler
            public void scrollToEnd() {
                ChatView.this.scrollToEnd();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView.MessageHandler
            public void sendMessage(TUIMessageBean tUIMessageBean) {
                ChatView.this.sendMessage(tUIMessageBean, false);
            }
        });
        getInputLayout().clearCustomActionList();
        if (getMessageLayout().getAdapter() == null) {
            MessageAdapter messageAdapter = new MessageAdapter();
            this.mAdapter = messageAdapter;
            this.mMessageRecyclerView.setAdapter(messageAdapter);
        }
        new ChatLayoutSetting(getContext()).customizeChatLayout(this);
        initListener();
        resetForwardState("");
    }

    public void loadMessages(TUIMessageBean tUIMessageBean, int i2) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.loadMessage(i2, tUIMessageBean);
        }
    }

    public void multiSelectMessage(TUIMessageBean tUIMessageBean) {
        if (this.mAdapter != null) {
            this.mInputView.hideSoftInput();
            this.mAdapter.setShowMultiSelectCheckBox(true);
            this.mAdapter.setItemChecked(tUIMessageBean.getId(), true);
            this.mAdapter.notifyDataSetChanged();
            setTitleBarWhenMultiSelectMessage();
        }
    }

    public void onApplied(int i2) {
        if (i2 == 0) {
            this.mGroupApplyLayout.setVisibility(8);
            return;
        }
        this.mGroupApplyLayout.getContent().setText(getContext().getString(R.string.group_apply_tips, Integer.valueOf(i2)));
        this.mGroupApplyLayout.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        exitChat();
    }

    public void onExitChat() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).finish();
        }
    }

    public void onFriendNameChanged(String str) {
        getTitleBar().setTitle(str, ITitleBarLayout.Position.MIDDLE);
    }

    public void onGroupNameChanged(String str) {
        getTitleBar().setTitle(str, ITitleBarLayout.Position.MIDDLE);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        LinearLayoutManager linearLayoutManager;
        if (i2 != 0 || getMessageLayout() == null || (linearLayoutManager = (LinearLayoutManager) getMessageLayout().getLayoutManager()) == null) {
            return;
        }
        sendGroupMsgReadReceipt(linearLayoutManager.findFirstCompletelyVisibleItemPosition(), linearLayoutManager.findLastCompletelyVisibleItemPosition());
    }

    public void replyMessage(TUIMessageBean tUIMessageBean) {
        this.mInputView.showReplyPreview(ChatMessageBuilder.buildReplyPreviewBean(tUIMessageBean));
    }

    public void revokeMessage(TUIMessageBean tUIMessageBean) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter != null) {
            chatPresenter.revokeMessage(tUIMessageBean);
        }
    }

    public void scrollToEnd() {
        getMessageLayout().scrollToEnd();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public void sendMessage(final TUIMessageBean tUIMessageBean, boolean z) {
        ChatPresenter chatPresenter = this.presenter;
        if (chatPresenter == null) {
            return;
        }
        chatPresenter.sendMessage(tUIMessageBean, z, new IUIKitCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.30
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                if (i2 == 7013) {
                    ChatView.this.showNotSupportDialog();
                }
                if (i2 != 80001) {
                    ToastUtil.toastLongMessage(str2);
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onProgress(Object obj) {
                ProgressPresenter.getInstance().updateProgress(tUIMessageBean.getId(), ((Integer) obj).intValue());
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Object obj) {
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.30.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatView.this.scrollToEnd();
                    }
                });
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public void setChatInfo(final ChatInfo chatInfo) {
        this.mChatInfo = chatInfo;
        if (chatInfo == null) {
            return;
        }
        this.mInputView.setChatInfo(chatInfo);
        getTitleBar().setTitle(chatInfo.getChatName(), ITitleBarLayout.Position.MIDDLE);
        if (TUIChatUtils.isC2CChat(chatInfo.getType())) {
            this.isGroup = false;
        } else {
            this.isGroup = true;
        }
        setChatHandler();
        if (this.isGroup) {
            loadApplyList();
            getTitleBar().setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("group_id", chatInfo.getId());
                    TUICore.startActivity(ChatView.this.getContext(), "GroupInfoActivity", bundle);
                }
            });
            this.mGroupApplyLayout.setOnNoticeClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("group_id", chatInfo.getId());
                    TUICore.startActivity(ChatView.this.getContext(), "GroupApplyManagerActivity", bundle);
                }
            });
            this.mMessageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.9
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ChatView.this.getMessageLayout().getLayoutManager();
                    ChatView.this.sendGroupMsgReadReceipt(linearLayoutManager.findFirstCompletelyVisibleItemPosition(), linearLayoutManager.findLastCompletelyVisibleItemPosition());
                }
            });
        }
        getTitleBar().getRightIcon().setImageResource(R.drawable.tui_svg_more);
        getTitleBar().getRightIcon().setBackgroundResource(R.drawable.bg_back_icon_msg);
        getConversationLastMessage(TUIChatUtils.getConversationIdByUserId(chatInfo.getId(), this.isGroup));
        loadMessages(chatInfo.getLocateMessage(), chatInfo.getLocateMessage() != null ? 2 : 0);
        setTotalUnread();
    }

    public void setForwardSelectActivityListener(ForwardSelectActivityListener forwardSelectActivityListener) {
        this.mForwardSelectActivityListener = forwardSelectActivityListener;
    }

    @Override // com.tencent.qcloud.tuicore.component.interfaces.ILayout
    public void setParentLayout(Object obj) {
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
        this.mMessageRecyclerView.setPresenter(chatPresenter);
        this.mInputView.setPresenter(chatPresenter);
        chatPresenter.setMessageListAdapter(this.mAdapter);
        this.mAdapter.setPresenter(chatPresenter);
        chatPresenter.setMessageRecycleView(this.mMessageRecyclerView);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout
    public void loadMessages(int i2) {
        if (i2 == 0) {
            loadMessages(this.mAdapter.getItemCount() > 0 ? this.mAdapter.getItem(1) : null, i2);
        } else if (i2 == 1) {
            if (this.mAdapter.getItemCount() > 0) {
                MessageAdapter messageAdapter = this.mAdapter;
                r0 = messageAdapter.getItem(messageAdapter.getItemCount() - 1);
            }
            loadMessages(r0, i2);
        }
    }

    public ChatView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTypingRunnable = null;
        this.mTypingListener = new ChatPresenter.TypingListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.TypingListener
            public void onTyping() {
                final String charSequence = ChatView.this.getTitleBar().getMiddleTitle().getText().toString();
                ChatView.this.getTitleBar().getMiddleTitle().setText(R.string.typing);
                if (ChatView.this.mTypingRunnable == null) {
                    ChatView.this.mTypingRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChatView.this.getTitleBar().getMiddleTitle().setText(charSequence);
                        }
                    };
                }
                ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                ChatView.this.getTitleBar().getMiddleTitle().postDelayed(ChatView.this.mTypingRunnable, 3000L);
            }
        };
        this.isGroup = false;
        initViews();
    }

    public ChatView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTypingRunnable = null;
        this.mTypingListener = new ChatPresenter.TypingListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.TypingListener
            public void onTyping() {
                final String charSequence = ChatView.this.getTitleBar().getMiddleTitle().getText().toString();
                ChatView.this.getTitleBar().getMiddleTitle().setText(R.string.typing);
                if (ChatView.this.mTypingRunnable == null) {
                    ChatView.this.mTypingRunnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChatView.this.getTitleBar().getMiddleTitle().setText(charSequence);
                        }
                    };
                }
                ChatView.this.getTitleBar().getMiddleTitle().removeCallbacks(ChatView.this.mTypingRunnable);
                ChatView.this.getTitleBar().getMiddleTitle().postDelayed(ChatView.this.mTypingRunnable, 3000L);
            }
        };
        this.isGroup = false;
        initViews();
    }
}
