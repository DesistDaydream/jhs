package com.tencent.qcloud.tuikit.tuichat.ui.view.message;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageHeaderHolder;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageViewHolderFactory;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.TextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import e.s.a.b.a.b.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class MessageAdapter extends RecyclerView.Adapter implements IMessageAdapter, ICommonMessageAdapter {
    private static final String TAG = "MessageAdapter";
    private int mHighShowPosition;
    private OnItemClickListener mOnItemClickListener;
    private MessageRecyclerView mRecycleView;
    private ChatPresenter presenter;
    private boolean mLoading = true;
    private List<TUIMessageBean> mDataSource = new ArrayList();
    private HashMap<String, Boolean> mSelectedPositions = new HashMap<>();
    public boolean isShowMultiSelectCheckBox = false;
    private boolean isForwardMode = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void changeCheckedStatus(String str, int i2) {
        if (isItemChecked(str)) {
            setItemChecked(str, false);
        } else {
            setItemChecked(str, true);
        }
        notifyItemChanged(i2);
    }

    private boolean isItemChecked(String str) {
        if (this.mSelectedPositions.size() > 0 && this.mSelectedPositions.containsKey(str)) {
            return this.mSelectedPositions.get(str).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLoadView() {
        notifyItemChanged(0);
    }

    private void setCheckBoxStatus(final int i2, final String str, MessageBaseHolder messageBaseHolder) {
        CheckBox checkBox = messageBaseHolder.mMutiSelectCheckBox;
        if (checkBox == null) {
            return;
        }
        if (!this.isShowMultiSelectCheckBox) {
            checkBox.setVisibility(8);
            messageBaseHolder.setOnItemClickListener(this.mOnItemClickListener);
            FrameLayout frameLayout = messageBaseHolder.msgContentFrame;
            if (frameLayout != null) {
                frameLayout.setOnClickListener(null);
                return;
            }
            return;
        }
        checkBox.setVisibility(0);
        messageBaseHolder.mMutiSelectCheckBox.setChecked(isItemChecked(str));
        messageBaseHolder.mMutiSelectCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }
        });
        messageBaseHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageAdapter.this.changeCheckedStatus(str, i2);
            }
        });
        messageBaseHolder.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter.3
            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onMessageClick(View view, int i3, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i3);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onMessageLongClick(View view, int i3, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onReEditRevokeMessage(View view, int i3, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onRecallClick(View view, int i3, TUIMessageBean tUIMessageBean) {
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onReplyMessageClick(View view, int i3, String str2) {
                MessageAdapter.this.changeCheckedStatus(str, i3);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onSendFailBtnClick(View view, int i3, TUIMessageBean tUIMessageBean) {
                a.$default$onSendFailBtnClick(this, view, i3, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public /* synthetic */ void onTextSelected(View view, int i3, TUIMessageBean tUIMessageBean) {
                a.$default$onTextSelected(this, view, i3, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconClick(View view, int i3, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i3);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener
            public void onUserIconLongClick(View view, int i3, TUIMessageBean tUIMessageBean) {
                MessageAdapter.this.changeCheckedStatus(str, i3);
            }
        });
        FrameLayout frameLayout2 = messageBaseHolder.msgContentFrame;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageAdapter.this.changeCheckedStatus(str, i2);
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.ICommonMessageAdapter
    public TUIMessageBean getItem(int i2) {
        List<TUIMessageBean> list;
        if (i2 == 0 || (list = this.mDataSource) == null || list.size() == 0 || i2 >= this.mDataSource.size() + 1) {
            return null;
        }
        return this.mDataSource.get(i2 - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataSource.size() + 1;
    }

    public List<TUIMessageBean> getItemList(int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            if (i2 == 0) {
                i2 = 1;
            }
            if (i3 == 0) {
                i3 = 1;
            }
            List<TUIMessageBean> list = this.mDataSource;
            if (list != null && list.size() != 0 && i2 <= i3) {
                if (i2 < this.mDataSource.size() + 1 && i3 < this.mDataSource.size() + 1) {
                    return this.mDataSource.subList(i2 - 1, i3);
                }
                return new ArrayList(0);
            }
            return new ArrayList(0);
        }
        return new ArrayList(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (i2 == 0) {
            return -99;
        }
        TUIMessageBean item = getItem(i2);
        if (item.getStatus() == 275) {
            return TUIChatService.getInstance().getViewType(TipsMessageBean.class);
        }
        return TUIChatService.getInstance().getViewType(item.getClass());
    }

    public int getMessagePosition(TUIMessageBean tUIMessageBean) {
        List<TUIMessageBean> list = this.mDataSource;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.mDataSource.size(); i3++) {
            if (TextUtils.equals(this.mDataSource.get(i3).getId(), tUIMessageBean.getId())) {
                i2 = i3;
            }
        }
        return i2 + 1;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public ArrayList<TUIMessageBean> getSelectedItem() {
        HashMap<String, Boolean> hashMap = this.mSelectedPositions;
        if (hashMap == null || hashMap.size() == 0) {
            return null;
        }
        ArrayList<TUIMessageBean> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < getItemCount() - 1; i2++) {
            if (isItemChecked(this.mDataSource.get(i2).getId())) {
                arrayList.add(this.mDataSource.get(i2));
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        MessageRecyclerView messageRecyclerView = (MessageRecyclerView) recyclerView;
        this.mRecycleView = messageRecyclerView;
        messageRecyclerView.setItemViewCacheSize(5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        TUIMessageBean item = getItem(i2);
        if (viewHolder instanceof MessageBaseHolder) {
            if (viewHolder instanceof MessageContentHolder) {
                ((MessageContentHolder) viewHolder).isMultiSelectMode = this.isShowMultiSelectCheckBox;
            }
            MessageBaseHolder messageBaseHolder = (MessageBaseHolder) viewHolder;
            messageBaseHolder.setOnItemClickListener(this.mOnItemClickListener);
            String id = item != null ? item.getId() : "";
            if (getItemViewType(i2) != -99) {
                if (i2 == this.mHighShowPosition && messageBaseHolder.mContentLayout != null) {
                    messageBaseHolder.startHighLight();
                    this.mHighShowPosition = -1;
                }
            } else if (this.isForwardMode) {
                ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(false);
            } else {
                ((MessageHeaderHolder) messageBaseHolder).setLoadingStatus(this.mLoading);
            }
            setCheckBoxStatus(i2, id, messageBaseHolder);
            messageBaseHolder.layoutViews(item, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        RecyclerView.ViewHolder messageViewHolderFactory = MessageViewHolderFactory.getInstance(viewGroup, this, i2);
        if (messageViewHolderFactory instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) messageViewHolderFactory;
            messageContentHolder.isForwardMode = this.isForwardMode;
            messageContentHolder.setPresenter(this.presenter);
            if (this.isForwardMode) {
                messageContentHolder.setDataSource(this.mDataSource);
            }
        }
        return messageViewHolderFactory;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageAdapter
    public void onDataSourceChanged(List<TUIMessageBean> list) {
        this.mDataSource = list;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageAdapter
    public void onScrollToEnd() {
        MessageRecyclerView messageRecyclerView = this.mRecycleView;
        if (messageRecyclerView != null) {
            messageRecyclerView.scrollToEnd();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageAdapter
    public void onViewNeedRefresh(final int i2, final TUIMessageBean tUIMessageBean) {
        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                MessageAdapter.this.mLoading = false;
                int i3 = i2;
                if (i3 == 7) {
                    MessageAdapter.this.notifyDataSetChanged();
                    int messagePosition = MessageAdapter.this.getMessagePosition(tUIMessageBean);
                    MessageAdapter.this.mRecycleView.scrollToPosition(messagePosition);
                    MessageAdapter.this.mRecycleView.setHighShowPosition(messagePosition);
                } else if (i3 == 9) {
                    int messagePosition2 = MessageAdapter.this.getMessagePosition(tUIMessageBean);
                    MessageAdapter.this.mRecycleView.setHighShowPosition(messagePosition2);
                    MessageAdapter.this.mRecycleView.scrollToPosition(messagePosition2);
                    MessageAdapter.this.notifyItemChanged(messagePosition2);
                    MessageAdapter.this.mRecycleView.scrollMessageFinish();
                } else if (i3 == 10) {
                    MessageAdapter.this.notifyDataSetChanged();
                    int messagePosition3 = MessageAdapter.this.getMessagePosition(tUIMessageBean);
                    MessageAdapter.this.mRecycleView.setHighShowPosition(messagePosition3);
                    MessageAdapter.this.mRecycleView.scrollToEnd();
                    MessageAdapter.this.mRecycleView.smoothScrollToPosition(messagePosition3);
                    MessageAdapter.this.notifyItemChanged(messagePosition3);
                    MessageAdapter.this.mRecycleView.scrollMessageFinish();
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MessageContentHolder) {
            MessageContentHolder messageContentHolder = (MessageContentHolder) viewHolder;
            messageContentHolder.msgContentFrame.setBackground(null);
            messageContentHolder.stopHighLight();
            messageContentHolder.onRecycled();
        }
    }

    public void resetSelectableText() {
        int selectedPosition = this.mRecycleView.getSelectedPosition();
        if (selectedPosition < 0) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.mRecycleView.findViewHolderForAdapterPosition(selectedPosition);
        if (findViewHolderForAdapterPosition != null) {
            if (findViewHolderForAdapterPosition instanceof TextMessageHolder) {
                ((TextMessageHolder) findViewHolderForAdapterPosition).resetSelectableText();
                return;
            }
            return;
        }
        TUIChatLog.d(TAG, "holder == null");
    }

    public void setForwardMode(boolean z) {
        this.isForwardMode = z;
    }

    public void setHighShowPosition(int i2) {
        this.mHighShowPosition = i2;
    }

    public void setItemChecked(String str, boolean z) {
        HashMap<String, Boolean> hashMap = this.mSelectedPositions;
        if (hashMap == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setPresenter(ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public void setShowMultiSelectCheckBox(boolean z) {
        HashMap<String, Boolean> hashMap;
        this.isShowMultiSelectCheckBox = z;
        if (z || (hashMap = this.mSelectedPositions) == null) {
            return;
        }
        hashMap.clear();
    }

    public void showLoading() {
        if (this.isForwardMode || this.mLoading) {
            return;
        }
        this.mLoading = true;
        notifyItemChanged(0);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageAdapter
    public void onViewNeedRefresh(final int i2, final int i3) {
        BackgroundTasks.getInstance().postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter.6
            @Override // java.lang.Runnable
            public void run() {
                MessageAdapter.this.mLoading = false;
                int i4 = i2;
                if (i4 == 0) {
                    MessageAdapter.this.notifyDataSetChanged();
                    MessageAdapter.this.mRecycleView.scrollToEnd();
                } else if (i4 == 3) {
                    MessageAdapter messageAdapter = MessageAdapter.this;
                    messageAdapter.notifyItemRangeInserted(messageAdapter.mDataSource.size() + 1, i3);
                } else if (i4 == 8) {
                    MessageAdapter messageAdapter2 = MessageAdapter.this;
                    messageAdapter2.notifyItemRangeInserted(messageAdapter2.mDataSource.size() + 1, i3);
                    MessageAdapter.this.mRecycleView.onMsgAddBack();
                } else if (i4 == 4) {
                    MessageAdapter.this.notifyDataSetChanged();
                } else if (i4 == 2) {
                    if (i3 != 0) {
                        int itemCount = MessageAdapter.this.getItemCount();
                        int i5 = i3;
                        if (itemCount > i5) {
                            MessageAdapter.this.notifyItemRangeInserted(0, i5);
                        } else {
                            MessageAdapter.this.notifyItemRangeInserted(0, i5);
                        }
                    }
                } else if (i4 == 5) {
                    MessageAdapter.this.notifyItemRemoved(i3);
                    MessageAdapter.this.notifyDataSetChanged();
                } else if (i4 == 1) {
                    MessageAdapter.this.notifyDataSetChanged();
                    MessageAdapter.this.mRecycleView.scrollToEnd();
                    MessageAdapter.this.mRecycleView.loadMessageFinish();
                }
                MessageAdapter.this.refreshLoadView();
            }
        }, 100L);
    }
}
