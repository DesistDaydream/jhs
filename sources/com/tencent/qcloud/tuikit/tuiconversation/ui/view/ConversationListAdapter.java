package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.UnreadCountTextView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.TUIConversationService;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class ConversationListAdapter extends RecyclerView.Adapter implements IConversationListAdapter {
    public static final int FOOTER_COUNT = 1;
    public static final int HEADER_COUNT = 1;
    public static final int INTERACTIVE_COUNT = 1;
    public static final int ITEM_TYPE_FOOTER_LOADING = -99;
    public static final int ITEM_TYPE_HEADER_SEARCH = 101;
    public static final int SELECT_COUNT = 1;
    public static final int SELECT_LABEL_COUNT = 1;
    public String last;
    private int mBottomTextSize;
    private int mDateTextSize;
    private ConversationListLayout.OnItemClickListener mOnItemClickListener;
    private ConversationListLayout.OnItemLongClickListener mOnItemLongClickListener;
    private int mTopTextSize;
    private View searchView;
    public String unread;
    private boolean mHasShowUnreadDot = true;
    private int mItemAvatarRadius = ScreenUtil.getPxByDp(5.0f);
    public List<ConversationInfo> mDataSource = new ArrayList();
    private final HashMap<String, Boolean> mSelectedPositions = new HashMap<>();
    private boolean isShowMultiSelectCheckBox = false;
    private boolean isForwardFragment = false;
    private boolean isShowSearch = false;
    private boolean mIsLoading = false;
    private boolean mIsShowInteractive = true;
    private boolean isClick = false;
    private int currentPosition = -1;

    /* loaded from: classes3.dex */
    public static class CHolder extends ConversationBaseHolder {
        public TextView tv;
        private int type;
        public UnreadCountTextView unreadText;

        public CHolder(View view, int i2) {
            super(view);
            this.type = i2;
            this.tv = (TextView) view.findViewById(R.id.conversation_last_msg);
            UnreadCountTextView unreadCountTextView = (UnreadCountTextView) view.findViewById(R.id.conversation_unread);
            this.unreadText = unreadCountTextView;
            unreadCountTextView.setVisibility(8);
        }

        @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationBaseHolder
        public void layoutViews(ConversationInfo conversationInfo, int i2) {
        }

        public void refresh(String str, String str2) {
            if (str2 != null && !str2.isEmpty()) {
                this.unreadText.setVisibility(0);
            } else {
                this.unreadText.setVisibility(8);
            }
            this.unreadText.setText(str2);
            this.tv.setText(str);
        }
    }

    /* loaded from: classes3.dex */
    public class FooterViewHolder extends ConversationBaseHolder {
        public FooterViewHolder(@NonNull View view) {
            super(view);
        }

        @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationBaseHolder
        public void layoutViews(ConversationInfo conversationInfo, int i2) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.rootView.getLayoutParams();
            if (ConversationListAdapter.this.mIsLoading) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                this.rootView.setVisibility(0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                this.rootView.setVisibility(8);
            }
            this.rootView.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public static class ForwardLabelHolder extends ConversationBaseHolder {
        public ForwardLabelHolder(View view) {
            super(view);
        }

        @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationBaseHolder
        public void layoutViews(ConversationInfo conversationInfo, int i2) {
        }
    }

    /* loaded from: classes3.dex */
    public static class ForwardSelectHolder extends ConversationBaseHolder {
        private final TextView titleView;

        public ForwardSelectHolder(View view) {
            super(view);
            this.titleView = (TextView) view.findViewById(R.id.forward_title);
        }

        @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationBaseHolder
        public void layoutViews(ConversationInfo conversationInfo, int i2) {
        }

        public void refreshTitle(boolean z) {
            TextView textView = this.titleView;
            if (textView == null) {
                return;
            }
            if (z) {
                textView.setText(TUIConversationService.getAppContext().getString(R.string.forward_select_new_chat));
            } else {
                textView.setText(TUIConversationService.getAppContext().getString(R.string.forward_select_from_contact));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(@NonNull View view) {
            super(view);
        }
    }

    private int getItemIndexInAdapter(int i2) {
        if (this.isForwardFragment) {
            i2++;
        } else if (!this.isShowSearch && !this.mIsShowInteractive) {
            return i2;
        }
        return i2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isItemChecked(String str) {
        if (this.mSelectedPositions.size() > 0 && this.mSelectedPositions.containsKey(str)) {
            return this.mSelectedPositions.get(str).booleanValue();
        }
        return false;
    }

    private void setCheckBoxStatus(final int i2, final ConversationInfo conversationInfo, ConversationBaseHolder conversationBaseHolder) {
        if (conversationBaseHolder instanceof ConversationCommonHolder) {
            ConversationCommonHolder conversationCommonHolder = (ConversationCommonHolder) conversationBaseHolder;
            if (conversationCommonHolder.multiSelectCheckBox == null) {
                return;
            }
            final String conversationId = conversationInfo.getConversationId();
            if (!this.isShowMultiSelectCheckBox) {
                conversationCommonHolder.multiSelectCheckBox.setVisibility(8);
                return;
            }
            conversationCommonHolder.multiSelectCheckBox.setVisibility(0);
            conversationCommonHolder.multiSelectCheckBox.setChecked(isItemChecked(conversationId));
            conversationCommonHolder.multiSelectCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ConversationListAdapter conversationListAdapter = ConversationListAdapter.this;
                    String str = conversationId;
                    conversationListAdapter.setItemChecked(str, !conversationListAdapter.isItemChecked(str));
                    if (ConversationListAdapter.this.mOnItemClickListener != null) {
                        ConversationListAdapter.this.mOnItemClickListener.onItemClick(view, i2, conversationInfo);
                    }
                }
            });
            conversationBaseHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ConversationListAdapter conversationListAdapter = ConversationListAdapter.this;
                    String str = conversationId;
                    conversationListAdapter.setItemChecked(str, !conversationListAdapter.isItemChecked(str));
                    ConversationListAdapter.this.notifyItemChanged(i2);
                    if (ConversationListAdapter.this.mOnItemClickListener != null) {
                        ConversationListAdapter.this.mOnItemClickListener.onItemClick(view, i2, conversationInfo);
                    }
                }
            });
        }
    }

    private void setOnClickListener(RecyclerView.ViewHolder viewHolder, final int i2, final ConversationInfo conversationInfo) {
        if (getItemViewType(i2) == 101) {
            return;
        }
        if (this.mOnItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ConversationListAdapter.this.mOnItemClickListener.onItemClick(view, i2, conversationInfo);
                }
            });
        }
        if (this.mOnItemLongClickListener != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    ConversationListAdapter.this.mOnItemLongClickListener.OnItemLongClick(view, i2, conversationInfo);
                    ConversationListAdapter.this.setCurrentPosition(i2, true);
                    ConversationListAdapter.this.notifyItemChanged(i2);
                    return true;
                }
            });
        }
    }

    public void disableItemUnreadDot(boolean z) {
        this.mHasShowUnreadDot = !z;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
        if (r2.mIsShowInteractive != false) goto L8;
     */
    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo getItem(int r3) {
        /*
            r2 = this;
            java.util.List<com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo> r0 = r2.mDataSource
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L38
            int r0 = r2.getItemCount()
            int r0 = r0 + (-1)
            if (r3 != r0) goto L12
            goto L38
        L12:
            boolean r0 = r2.isForwardFragment
            if (r0 == 0) goto L1b
            int r3 = r3 + (-1)
        L18:
            int r3 = r3 + (-1)
            goto L25
        L1b:
            boolean r0 = r2.isShowSearch
            if (r0 == 0) goto L20
        L1f:
            goto L18
        L20:
            boolean r0 = r2.mIsShowInteractive
            if (r0 == 0) goto L25
            goto L1f
        L25:
            java.util.List<com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo> r0 = r2.mDataSource
            int r0 = r0.size()
            if (r3 >= r0) goto L38
            if (r3 < 0) goto L38
            java.util.List<com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo> r0 = r2.mDataSource
            java.lang.Object r3 = r0.get(r3)
            com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo r3 = (com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo) r3
            return r3
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter.getItem(int):com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo");
    }

    public int getItemAvatarRadius() {
        return this.mItemAvatarRadius;
    }

    public int getItemBottomTextSize() {
        return this.mBottomTextSize;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.mDataSource.size();
        if (this.isForwardFragment) {
            size++;
        } else if (!this.isShowSearch && !this.mIsShowInteractive) {
            return size + 1;
        }
        return size + 1 + 1;
    }

    public int getItemDateTextSize() {
        return this.mDateTextSize;
    }

    public int getItemTopTextSize() {
        return this.mTopTextSize;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        ConversationInfo item;
        if (this.isForwardFragment) {
            if (i2 == 0) {
                return 3;
            }
            if (i2 == 1) {
                return 4;
            }
        } else if (this.isShowSearch) {
            if (i2 == 0) {
                return 101;
            }
        } else if (this.mIsShowInteractive && i2 == 0) {
            return 6;
        }
        if (i2 == getItemCount() - 1) {
            return -99;
        }
        if (this.mDataSource == null || (item = getItem(i2)) == null) {
            return 1;
        }
        return item.getType();
    }

    public List<ConversationInfo> getSelectedItem() {
        if (this.mSelectedPositions.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getItemCount() - 1; i2++) {
            ConversationInfo item = getItem(i2);
            if (item != null && isItemChecked(item.getConversationId())) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    public boolean hasItemUnreadDot() {
        return this.mHasShowUnreadDot;
    }

    public boolean isClick() {
        return this.isClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ConversationInfo item = getItem(i2);
        ConversationBaseHolder conversationBaseHolder = item != null ? (ConversationBaseHolder) viewHolder : null;
        int itemViewType = getItemViewType(i2);
        if (itemViewType != -99) {
            switch (itemViewType) {
                case 2:
                case 4:
                case 5:
                case 7:
                    break;
                case 3:
                    ((ForwardSelectHolder) viewHolder).refreshTitle(!this.isShowMultiSelectCheckBox);
                    setOnClickListener(viewHolder, i2, item);
                    break;
                case 6:
                    ((CHolder) viewHolder).refresh(this.last, this.unread);
                    ConversationInfo conversationInfo = new ConversationInfo();
                    conversationInfo.setType(6);
                    setOnClickListener(viewHolder, i2, conversationInfo);
                    break;
                default:
                    setOnClickListener(viewHolder, i2, item);
                    break;
            }
        } else if (viewHolder instanceof FooterViewHolder) {
            ((ConversationBaseHolder) viewHolder).layoutViews(null, i2);
        }
        if (conversationBaseHolder != null) {
            conversationBaseHolder.layoutViews(item, i2);
            setCheckBoxStatus(i2, item, conversationBaseHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        ConversationBaseHolder conversationBaseHolder;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == 101) {
            if (this.searchView == null) {
                this.searchView = new View(viewGroup.getContext());
            }
            return new HeaderViewHolder(this.searchView);
        }
        if (i2 == 2) {
            conversationBaseHolder = new ConversationCustomHolder(from.inflate(R.layout.conversation_custom_adapter, viewGroup, false));
        } else if (i2 == -99) {
            return new FooterViewHolder(from.inflate(R.layout.loading_progress_bar, viewGroup, false));
        } else {
            if (i2 == 3) {
                return new ForwardSelectHolder(from.inflate(R.layout.conversation_forward_select_adapter, viewGroup, false));
            }
            if (i2 == 4) {
                return new ForwardLabelHolder(from.inflate(R.layout.conversation_forward_label_adapter, viewGroup, false));
            }
            if (i2 == 5) {
                return new CHolder(from.inflate(R.layout.conversation_list_system_msg_layout, viewGroup, false), 0);
            }
            if (i2 == 6) {
                return new CHolder(from.inflate(R.layout.conversation_list_interactive_msg_layout, viewGroup, false), 1);
            }
            if (i2 == 7) {
                return new CHolder(from.inflate(R.layout.conversation_list_order_msg_layout, viewGroup, false), 2);
            }
            ConversationCommonHolder conversationCommonHolder = new ConversationCommonHolder(from.inflate(R.layout.conversation_list_item_layout, viewGroup, false));
            conversationCommonHolder.setForwardMode(this.isForwardFragment);
            conversationBaseHolder = conversationCommonHolder;
        }
        conversationBaseHolder.setAdapter(this);
        return conversationBaseHolder;
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    public void onDataSourceChanged(List<ConversationInfo> list) {
        this.mDataSource = list;
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    public void onItemChanged(int i2) {
        notifyItemChanged(getItemIndexInAdapter(i2));
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    public void onItemInserted(int i2) {
        notifyItemInserted(getItemIndexInAdapter(i2));
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    public void onItemRangeChanged(int i2, int i3) {
        notifyItemRangeChanged(getItemIndexInAdapter(i2), i3);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    public void onItemRemoved(int i2) {
        notifyItemRemoved(getItemIndexInAdapter(i2));
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    public void onLoadingStateChanged(boolean z) {
        this.mIsLoading = z;
        notifyItemChanged(getItemCount() - 1);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter
    public void onViewNeedRefresh() {
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof ConversationCommonHolder) {
            ((ConversationCommonHolder) viewHolder).conversationIconView.clearImage();
        }
    }

    public void setClick(boolean z) {
        this.isClick = z;
    }

    public void setCurrentPosition(int i2, boolean z) {
        this.currentPosition = i2;
        this.isClick = z;
    }

    public void setForwardFragment(boolean z) {
        this.isForwardFragment = z;
    }

    public void setItemAvatarRadius(int i2) {
        this.mItemAvatarRadius = i2;
    }

    public void setItemBottomTextSize(int i2) {
        this.mBottomTextSize = i2;
    }

    public void setItemChecked(String str, boolean z) {
        this.mSelectedPositions.put(str, Boolean.valueOf(z));
    }

    public void setItemDateTextSize(int i2) {
        this.mDateTextSize = i2;
    }

    public void setItemTopTextSize(int i2) {
        this.mTopTextSize = i2;
    }

    public void setOnItemClickListener(ConversationListLayout.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(ConversationListLayout.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setSearchView(View view) {
        this.searchView = view;
    }

    public void setSelectConversations(List<ConversationInfo> list) {
        if (list != null && list.size() != 0) {
            this.mSelectedPositions.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.mDataSource.size()) {
                        break;
                    } else if (TextUtils.equals(list.get(i2).getConversationId(), this.mDataSource.get(i3).getConversationId())) {
                        setItemChecked(this.mDataSource.get(i3).getConversationId(), true);
                        notifyDataSetChanged();
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            return;
        }
        this.mSelectedPositions.clear();
        notifyDataSetChanged();
    }

    public void setShowMultiSelectCheckBox(boolean z) {
        this.isShowMultiSelectCheckBox = z;
        if (z) {
            return;
        }
        this.mSelectedPositions.clear();
    }

    public void setShowSearch(boolean z) {
        this.isShowSearch = z;
    }
}
