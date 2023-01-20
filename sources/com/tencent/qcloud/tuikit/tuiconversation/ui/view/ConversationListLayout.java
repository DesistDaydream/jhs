package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout;

/* loaded from: classes3.dex */
public class ConversationListLayout extends RecyclerView implements IConversationListLayout {
    private ConversationListAdapter mAdapter;
    private ConversationPresenter presenter;

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i2, ConversationInfo conversationInfo);
    }

    /* loaded from: classes3.dex */
    public interface OnItemLongClickListener {
        void OnItemLongClick(View view, int i2, ConversationInfo conversationInfo);
    }

    public ConversationListLayout(Context context) {
        super(context);
        init();
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void disableItemUnreadDot(boolean z) {
        this.mAdapter.disableItemUnreadDot(z);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public ConversationListLayout getListLayout() {
        return this;
    }

    public void init() {
        addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                super.getItemOffsets(rect, view, recyclerView, state);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                super.onDraw(canvas, recyclerView, state);
            }
        });
        setLayoutFrozen(false);
        setItemViewCacheSize(0);
        setHasFixedSize(true);
        setFocusableInTouchMode(false);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext());
        customLinearLayoutManager.setOrientation(1);
        setLayoutManager(customLinearLayoutManager);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
    }

    public boolean isLoadCompleted() {
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter != null) {
            return conversationPresenter.isLoadFinished();
        }
        return false;
    }

    public void loadConversation(long j2) {
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter != null) {
            conversationPresenter.loadConversation(j2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i2) {
        LinearLayoutManager linearLayoutManager;
        super.onScrollStateChanged(i2);
        if (i2 != 0 || (linearLayoutManager = (LinearLayoutManager) getLayoutManager()) == null) {
            return;
        }
        int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        ConversationListAdapter conversationListAdapter = this.mAdapter;
        if (conversationListAdapter == null || findLastCompletelyVisibleItemPosition != conversationListAdapter.getItemCount() - 1 || isLoadCompleted()) {
            return;
        }
        this.mAdapter.onLoadingStateChanged(true);
        ConversationPresenter conversationPresenter = this.presenter;
        if (conversationPresenter != null) {
            conversationPresenter.loadMoreConversation();
        }
    }

    public void scrollToStart() {
        smoothScrollToPosition(0);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setAdapter(IConversationListAdapter iConversationListAdapter) {
        if (iConversationListAdapter instanceof ConversationListAdapter) {
            ConversationListAdapter conversationListAdapter = (ConversationListAdapter) iConversationListAdapter;
            super.setAdapter((RecyclerView.Adapter) conversationListAdapter);
            this.mAdapter = conversationListAdapter;
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setBackground(int i2) {
        setBackgroundColor(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setItemAvatarRadius(int i2) {
        this.mAdapter.setItemAvatarRadius(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setItemBottomTextSize(int i2) {
        this.mAdapter.setItemBottomTextSize(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setItemDateTextSize(int i2) {
        this.mAdapter.setItemDateTextSize(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setItemTopTextSize(int i2) {
        this.mAdapter.setItemTopTextSize(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mAdapter.setOnItemClickListener(onItemClickListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mAdapter.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void setPresenter(ConversationPresenter conversationPresenter) {
        this.presenter = conversationPresenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListLayout
    public ConversationListAdapter getAdapter() {
        return this.mAdapter;
    }

    public ConversationListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ConversationListLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
