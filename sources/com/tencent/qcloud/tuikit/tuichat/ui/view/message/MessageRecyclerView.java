package com.tencent.qcloud.tuikit.tuichat.ui.view.message;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageProperties;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageLayout;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import e.s.a.b.a.b.a.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MessageRecyclerView extends RecyclerView implements IMessageLayout {
    public static final int DATA_CHANGE_LOCATE_TO_POSITION = 7;
    public static final int DATA_CHANGE_NEW_MESSAGE = 8;
    public static final int DATA_CHANGE_SCROLL_TO_POSITION = 10;
    public static final int DATA_CHANGE_TYPE_ADD_BACK = 3;
    public static final int DATA_CHANGE_TYPE_ADD_FRONT = 2;
    public static final int DATA_CHANGE_TYPE_CLEAR = 6;
    public static final int DATA_CHANGE_TYPE_DELETE = 5;
    public static final int DATA_CHANGE_TYPE_LOAD = 1;
    public static final int DATA_CHANGE_TYPE_REFRESH = 0;
    public static final int DATA_CHANGE_TYPE_UPDATE = 4;
    private static final int SCROLL_TO_END_OFFSET = -999999;
    public static final int SCROLL_TO_POSITION = 9;
    private static final String TAG = MessageRecyclerView.class.getSimpleName();
    private Handler handler;
    public MessageAdapter mAdapter;
    private ChatPopMenu mChatPopMenu;
    public OnEmptySpaceClickListener mEmptySpaceClickListener;
    public OnLoadMoreHandler mHandler;
    public List<ChatPopMenu.ChatPopMenuAction> mMorePopActions;
    public OnItemClickListener mOnItemClickListener;
    public OnPopActionClickListener mOnPopActionClickListener;
    public List<ChatPopMenu.ChatPopMenuAction> mPopActions;
    private int mSelectedPosition;
    private ChatPresenter presenter;
    private final MessageProperties properties;
    public Runnable runnable;

    /* loaded from: classes3.dex */
    public interface OnEmptySpaceClickListener {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface OnLoadMoreHandler {
        void displayBackToLastMessage(boolean z);

        void displayBackToNewMessage(boolean z, String str, int i2);

        void hideBackToAtMessage();

        boolean isListEnd(int i2);

        void loadMessageFinish();

        void loadMore(int i2);

        void scrollMessageFinish();
    }

    /* loaded from: classes3.dex */
    public interface OnPopActionClickListener {
        void onCopyClick(TUIMessageBean tUIMessageBean);

        void onDeleteMessageClick(TUIMessageBean tUIMessageBean);

        void onForwardMessageClick(TUIMessageBean tUIMessageBean);

        void onMultiSelectMessageClick(TUIMessageBean tUIMessageBean);

        void onReplyMessageClick(TUIMessageBean tUIMessageBean);

        void onRevokeMessageClick(TUIMessageBean tUIMessageBean);

        void onSendMessageClick(TUIMessageBean tUIMessageBean, boolean z);
    }

    public MessageRecyclerView(Context context) {
        super(context);
        this.mPopActions = new ArrayList();
        this.mMorePopActions = new ArrayList();
        this.properties = MessageProperties.getInstance();
        this.mSelectedPosition = -1;
        this.handler = new Handler();
        this.runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.1
            {
                MessageRecyclerView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MessageRecyclerView.this.mChatPopMenu != null) {
                    MessageRecyclerView.this.mChatPopMenu.hide();
                }
                MessageAdapter messageAdapter = MessageRecyclerView.this.mAdapter;
                if (messageAdapter != null) {
                    messageAdapter.resetSelectableText();
                }
            }
        };
        init();
    }

    /* renamed from: a */
    public /* synthetic */ void b(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onCopyClick(tUIMessageBean);
    }

    /* renamed from: c */
    public /* synthetic */ void d(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onDeleteMessageClick(tUIMessageBean);
    }

    /* renamed from: e */
    public /* synthetic */ void f(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onRevokeMessageClick(tUIMessageBean);
    }

    /* renamed from: g */
    public /* synthetic */ void h(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onMultiSelectMessageClick(tUIMessageBean);
    }

    /* renamed from: i */
    public /* synthetic */ void j(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onForwardMessageClick(tUIMessageBean);
    }

    private void init() {
        TUIChatLog.d(TAG, "init()");
        setLayoutFrozen(false);
        setItemViewCacheSize(0);
        setHasFixedSize(true);
        setFocusableInTouchMode(false);
        setFocusable(true);
        setClickable(true);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext());
        customLinearLayoutManager.setOrientation(1);
        setLayoutManager(customLinearLayoutManager);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        setClickEmptySpaceEvent();
    }

    private void initPopActions(final TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean == null) {
            return;
        }
        boolean z = true;
        boolean z2 = tUIMessageBean instanceof TextMessageBean;
        if (z2) {
            TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
            if (!textMessageBean.getText().equals(textMessageBean.getSelectText())) {
                z = false;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        ChatPopMenu.ChatPopMenuAction chatPopMenuAction = new ChatPopMenu.ChatPopMenuAction();
        if (z2 || (tUIMessageBean instanceof ReplyMessageBean)) {
            chatPopMenuAction.setActionName(getContext().getString(R.string.copy_action));
            chatPopMenuAction.setActionIcon(R.drawable.pop_menu_copy);
            chatPopMenuAction.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: e.s.a.b.a.b.b.b.a
                {
                    MessageRecyclerView.this = this;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
                public final void onClick() {
                    MessageRecyclerView.this.b(tUIMessageBean);
                }
            });
            arrayList.add(chatPopMenuAction);
        }
        if (z) {
            ChatPopMenu.ChatPopMenuAction chatPopMenuAction2 = new ChatPopMenu.ChatPopMenuAction();
            chatPopMenuAction2.setActionName(getContext().getString(R.string.delete_action));
            chatPopMenuAction2.setActionIcon(R.drawable.pop_menu_delete);
            chatPopMenuAction2.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: e.s.a.b.a.b.b.b.b
                {
                    MessageRecyclerView.this = this;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
                public final void onClick() {
                    MessageRecyclerView.this.d(tUIMessageBean);
                }
            });
            arrayList.add(chatPopMenuAction2);
            if (tUIMessageBean.isSelf()) {
                ChatPopMenu.ChatPopMenuAction chatPopMenuAction3 = new ChatPopMenu.ChatPopMenuAction();
                if (tUIMessageBean.getStatus() != 3) {
                    chatPopMenuAction3.setActionName(getContext().getString(R.string.revoke_action));
                    chatPopMenuAction3.setActionIcon(R.drawable.pop_menu_revoke);
                    chatPopMenuAction3.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: e.s.a.b.a.b.b.b.d
                        {
                            MessageRecyclerView.this = this;
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
                        public final void onClick() {
                            MessageRecyclerView.this.f(tUIMessageBean);
                        }
                    });
                    arrayList.add(chatPopMenuAction3);
                }
            }
            ChatPopMenu.ChatPopMenuAction chatPopMenuAction4 = new ChatPopMenu.ChatPopMenuAction();
            chatPopMenuAction4.setActionName(getContext().getString(R.string.titlebar_mutiselect));
            chatPopMenuAction4.setActionIcon(R.drawable.pop_menu_multi_select);
            chatPopMenuAction4.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: e.s.a.b.a.b.b.b.c
                {
                    MessageRecyclerView.this = this;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
                public final void onClick() {
                    MessageRecyclerView.this.h(tUIMessageBean);
                }
            });
            arrayList.add(chatPopMenuAction4);
        }
        if (tUIMessageBean.getStatus() != 3) {
            ChatPopMenu.ChatPopMenuAction chatPopMenuAction5 = new ChatPopMenu.ChatPopMenuAction();
            chatPopMenuAction5.setActionName(getContext().getString(R.string.forward_button));
            chatPopMenuAction5.setActionIcon(R.drawable.pop_menu_forward);
            chatPopMenuAction5.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: e.s.a.b.a.b.b.b.f
                {
                    MessageRecyclerView.this = this;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
                public final void onClick() {
                    MessageRecyclerView.this.j(tUIMessageBean);
                }
            });
            arrayList.add(chatPopMenuAction5);
        }
        if (z && tUIMessageBean.getStatus() != 3) {
            ChatPopMenu.ChatPopMenuAction chatPopMenuAction6 = new ChatPopMenu.ChatPopMenuAction();
            chatPopMenuAction6.setActionName(getContext().getString(R.string.reply_button));
            chatPopMenuAction6.setActionIcon(R.drawable.pop_menu_reply);
            chatPopMenuAction6.setActionClickListener(new ChatPopMenu.ChatPopMenuAction.OnClickListener() { // from class: e.s.a.b.a.b.b.b.e
                {
                    MessageRecyclerView.this = this;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu.ChatPopMenuAction.OnClickListener
                public final void onClick() {
                    MessageRecyclerView.this.l(tUIMessageBean);
                }
            });
            arrayList.add(chatPopMenuAction6);
        }
        this.mPopActions.clear();
        this.mPopActions.addAll(arrayList);
        this.mPopActions.addAll(this.mMorePopActions);
    }

    private boolean isListEnd(int i2) {
        return this.mHandler.isListEnd(i2);
    }

    /* renamed from: k */
    public /* synthetic */ void l(TUIMessageBean tUIMessageBean) {
        this.mOnPopActionClickListener.onReplyMessageClick(tUIMessageBean);
    }

    public void locateOriginMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.toastShortMessage(getContext().getString(R.string.locate_origin_msg_failed_tip));
        } else {
            this.presenter.locateMessage(str, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.6
                {
                    MessageRecyclerView.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i2, String str3) {
                    ToastUtil.toastShortMessage(MessageRecyclerView.this.getContext().getString(R.string.locate_origin_msg_failed_tip));
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r1) {
                }
            });
        }
    }

    private void setClickEmptySpaceEvent() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.2
            {
                MessageRecyclerView.this = this;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                OnEmptySpaceClickListener onEmptySpaceClickListener = MessageRecyclerView.this.mEmptySpaceClickListener;
                if (onEmptySpaceClickListener != null) {
                    onEmptySpaceClickListener.onClick();
                    return true;
                }
                return false;
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.3
            {
                MessageRecyclerView.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view instanceof RecyclerView) {
                    gestureDetector.onTouchEvent(motionEvent);
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageLayout
    public void addPopAction(ChatPopMenu.ChatPopMenuAction chatPopMenuAction) {
        this.mMorePopActions.add(chatPopMenuAction);
    }

    public void displayBackToNewMessage(boolean z, String str, int i2) {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.displayBackToNewMessage(z, str, i2);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getAvatar() {
        return this.properties.getAvatar();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getAvatarRadius() {
        return this.properties.getAvatarRadius();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int[] getAvatarSize() {
        return this.properties.getAvatarSize();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getChatContextFontSize() {
        return this.properties.getChatContextFontSize();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getChatTimeBubble() {
        return this.properties.getChatTimeBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getChatTimeFontColor() {
        return this.properties.getChatTimeFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getChatTimeFontSize() {
        return this.properties.getChatTimeFontSize();
    }

    public OnEmptySpaceClickListener getEmptySpaceClickListener() {
        return this.mEmptySpaceClickListener;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getLeftBubble() {
        return this.properties.getLeftBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getLeftChatContentFontColor() {
        return this.properties.getLeftChatContentFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getLeftNameVisibility() {
        return this.properties.getLeftNameVisibility();
    }

    public OnLoadMoreHandler getLoadMoreHandler() {
        return this.mHandler;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getNameFontColor() {
        return this.properties.getNameFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getNameFontSize() {
        return this.properties.getNameFontSize();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageLayout
    public OnItemClickListener getOnItemClickListener() {
        return this.mAdapter.getOnItemClickListener();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageLayout
    public List<ChatPopMenu.ChatPopMenuAction> getPopActions() {
        return this.mPopActions;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getRightBubble() {
        return this.properties.getRightBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getRightChatContentFontColor() {
        return this.properties.getRightChatContentFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getRightNameVisibility() {
        return this.properties.getRightNameVisibility();
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public Drawable getTipsMessageBubble() {
        return this.properties.getTipsMessageBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getTipsMessageFontColor() {
        return this.properties.getTipsMessageFontColor();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public int getTipsMessageFontSize() {
        return this.properties.getTipsMessageFontSize();
    }

    public boolean isDisplayJumpMessageLayout() {
        String str = TAG;
        TUIChatLog.d(str, "computeVerticalScrollRange() = " + computeVerticalScrollRange() + ", computeVerticalScrollExtent() = " + computeVerticalScrollExtent() + ", computeVerticalScrollOffset() = " + computeVerticalScrollOffset());
        int computeVerticalScrollRange = (computeVerticalScrollRange() - computeVerticalScrollExtent()) - computeVerticalScrollOffset();
        StringBuilder sb = new StringBuilder();
        sb.append("toBottom = ");
        sb.append(computeVerticalScrollRange);
        TUIChatLog.d(str, sb.toString());
        return computeVerticalScrollRange > 0 && computeVerticalScrollRange >= computeVerticalScrollExtent() * 2;
    }

    public boolean isLastItemVisibleCompleted() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        if (linearLayoutManager == null) {
            return false;
        }
        return linearLayoutManager.findLastCompletelyVisibleItemPosition() >= (linearLayoutManager.findFirstVisibleItemPosition() + linearLayoutManager.getChildCount()) - 1;
    }

    public void loadMessageFinish() {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.loadMessageFinish();
        }
    }

    public void onMsgAddBack() {
        if (this.mAdapter == null || !isLastItemVisibleCompleted()) {
            return;
        }
        scrollToEnd();
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i2) {
        OnLoadMoreHandler onLoadMoreHandler;
        super.onScrollStateChanged(i2);
        if (i2 != 0) {
            if (i2 != 1 || (onLoadMoreHandler = this.mHandler) == null) {
                return;
            }
            onLoadMoreHandler.hideBackToAtMessage();
        } else if (this.mHandler != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == 0 && (findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition) + 1 < getAdapter().getItemCount()) {
                if (getAdapter() instanceof MessageAdapter) {
                    ((MessageAdapter) getAdapter()).showLoading();
                }
                this.mHandler.loadMore(0);
            } else if (isListEnd(findLastCompletelyVisibleItemPosition)) {
                if (getAdapter() instanceof MessageAdapter) {
                    ((MessageAdapter) getAdapter()).showLoading();
                }
                this.mHandler.loadMore(1);
                this.mHandler.displayBackToLastMessage(false);
                this.mHandler.displayBackToNewMessage(false, "", 0);
                this.presenter.resetCurrentChatUnreadCount();
            }
            if (isDisplayJumpMessageLayout()) {
                this.mHandler.displayBackToLastMessage(true);
            } else {
                this.mHandler.displayBackToLastMessage(false);
            }
        }
    }

    public void scrollMessageFinish() {
        OnLoadMoreHandler onLoadMoreHandler = this.mHandler;
        if (onLoadMoreHandler != null) {
            onLoadMoreHandler.scrollMessageFinish();
        }
    }

    public void scrollToEnd() {
        if (getAdapter() != null) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            int itemCount = getAdapter().getItemCount();
            if (!(layoutManager instanceof LinearLayoutManager) || itemCount <= 0) {
                return;
            }
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(itemCount - 1, SCROLL_TO_END_OFFSET);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        if (getAdapter() == null || i2 >= getAdapter().getItemCount()) {
            return;
        }
        super.scrollToPosition(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageLayout
    public void setAdapter(MessageAdapter messageAdapter) {
        super.setAdapter((RecyclerView.Adapter) messageAdapter);
        this.mAdapter = messageAdapter;
    }

    public void setAdapterListener() {
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.5
            {
                MessageRecyclerView.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onMessageClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                a.$default$onMessageClick(this, view, i2, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onMessageLongClick(view, i2, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i2, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onReEditRevokeMessage(view, i2, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onRecallClick(view, i2, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onReplyMessageClick(View view, int i2, String str) {
                MessageRecyclerView.this.locateOriginMessage(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onSendFailBtnClick(View view, int i2, final TUIMessageBean tUIMessageBean) {
                new TUIKitDialog(MessageRecyclerView.this.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(MessageRecyclerView.this.getContext().getString(R.string.resend_tips)).setDialogWidth(0.75f).setPositiveButton(MessageRecyclerView.this.getContext().getString(R.string.sure), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.5.2
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageRecyclerView.this.mOnPopActionClickListener.onSendMessageClick(tUIMessageBean, true);
                    }
                }).setNegativeButton(MessageRecyclerView.this.getContext().getString(R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.5.1
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                    }
                }).show();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onTextSelected(View view, int i2, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onTextSelected(view, i2, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onUserIconClick(view, i2, tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i2, TUIMessageBean tUIMessageBean) {
                OnItemClickListener onItemClickListener = MessageRecyclerView.this.mOnItemClickListener;
                if (onItemClickListener != null) {
                    onItemClickListener.onUserIconLongClick(view, i2, tUIMessageBean);
                }
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setAvatar(int i2) {
        this.properties.setAvatar(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setAvatarRadius(int i2) {
        this.properties.setAvatarRadius(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setAvatarSize(int[] iArr) {
        this.properties.setAvatarSize(iArr);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatContextFontSize(int i2) {
        this.properties.setChatContextFontSize(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatTimeBubble(Drawable drawable) {
        this.properties.setChatTimeBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatTimeFontColor(int i2) {
        this.properties.setChatTimeFontColor(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setChatTimeFontSize(int i2) {
        this.properties.setChatTimeFontSize(i2);
    }

    public void setEmptySpaceClickListener(OnEmptySpaceClickListener onEmptySpaceClickListener) {
        this.mEmptySpaceClickListener = onEmptySpaceClickListener;
    }

    public void setHighShowPosition(int i2) {
        MessageAdapter messageAdapter = this.mAdapter;
        if (messageAdapter != null) {
            messageAdapter.setHighShowPosition(i2);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setLeftBubble(Drawable drawable) {
        this.properties.setLeftBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setLeftChatContentFontColor(int i2) {
        this.properties.setLeftChatContentFontColor(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setLeftNameVisibility(int i2) {
        this.properties.setLeftNameVisibility(i2);
    }

    public void setLoadMoreMessageHandler(OnLoadMoreHandler onLoadMoreHandler) {
        this.mHandler = onLoadMoreHandler;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setNameFontColor(int i2) {
        this.properties.setNameFontColor(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setNameFontSize(int i2) {
        this.properties.setNameFontSize(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageLayout
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        setAdapterListener();
    }

    public void setPopActionClickListener(OnPopActionClickListener onPopActionClickListener) {
        this.mOnPopActionClickListener = onPopActionClickListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setRightBubble(Drawable drawable) {
        this.properties.setRightBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setRightChatContentFontColor(int i2) {
        this.properties.setRightChatContentFontColor(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setRightNameVisibility(int i2) {
        this.properties.setRightNameVisibility(i2);
    }

    public void setSelectedPosition(int i2) {
        this.mSelectedPosition = i2;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setTipsMessageBubble(Drawable drawable) {
        this.properties.setTipsMessageBubble(drawable);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setTipsMessageFontColor(int i2) {
        this.properties.setTipsMessageFontColor(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageProperties
    public void setTipsMessageFontSize(int i2) {
        this.properties.setTipsMessageFontSize(i2);
    }

    public void showItemPopMenu(int i2, TUIMessageBean tUIMessageBean, View view) {
        initPopActions(tUIMessageBean);
        if (this.mPopActions.size() == 0) {
            return;
        }
        ChatPopMenu chatPopMenu = this.mChatPopMenu;
        if (chatPopMenu != null) {
            chatPopMenu.hide();
            this.mChatPopMenu = null;
            this.handler.removeCallbacks(this.runnable);
        }
        ChatPopMenu chatPopMenu2 = new ChatPopMenu(getContext());
        this.mChatPopMenu = chatPopMenu2;
        chatPopMenu2.setChatPopMenuActionList(this.mPopActions);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.mChatPopMenu.show(view, iArr[1]);
        this.mChatPopMenu.setEmptySpaceClickListener(new OnEmptySpaceClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.4
            {
                MessageRecyclerView.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.OnEmptySpaceClickListener
            public void onClick() {
                MessageAdapter messageAdapter = MessageRecyclerView.this.mAdapter;
                if (messageAdapter != null) {
                    messageAdapter.resetSelectableText();
                }
            }
        });
        this.handler.postDelayed(this.runnable, com.heytap.mcssdk.constant.a.q);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i2) {
        if (getAdapter() == null || i2 >= getAdapter().getItemCount()) {
            return;
        }
        super.smoothScrollToPosition(i2);
    }

    public MessageRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPopActions = new ArrayList();
        this.mMorePopActions = new ArrayList();
        this.properties = MessageProperties.getInstance();
        this.mSelectedPosition = -1;
        this.handler = new Handler();
        this.runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.1
            {
                MessageRecyclerView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MessageRecyclerView.this.mChatPopMenu != null) {
                    MessageRecyclerView.this.mChatPopMenu.hide();
                }
                MessageAdapter messageAdapter = MessageRecyclerView.this.mAdapter;
                if (messageAdapter != null) {
                    messageAdapter.resetSelectableText();
                }
            }
        };
        init();
    }

    public MessageRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPopActions = new ArrayList();
        this.mMorePopActions = new ArrayList();
        this.properties = MessageProperties.getInstance();
        this.mSelectedPosition = -1;
        this.handler = new Handler();
        this.runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView.1
            {
                MessageRecyclerView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MessageRecyclerView.this.mChatPopMenu != null) {
                    MessageRecyclerView.this.mChatPopMenu.hide();
                }
                MessageAdapter messageAdapter = MessageRecyclerView.this.mAdapter;
                if (messageAdapter != null) {
                    messageAdapter.resetSelectableText();
                }
            }
        };
        init();
    }
}
