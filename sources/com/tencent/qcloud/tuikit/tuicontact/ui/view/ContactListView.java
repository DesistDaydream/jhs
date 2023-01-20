package com.tencent.qcloud.tuikit.tuicontact.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.widget.IndexBar;
import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.suspension.SuspensionDecoration;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IContactListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ContactListView extends LinearLayout implements IContactListView {
    private static final String INDEX_STRING_TOP = "↑";
    private static final String TAG = ContactListView.class.getSimpleName();
    private int dataSourceType;
    private String groupId;
    private boolean isGroupList;
    private ContactAdapter mAdapter;
    private ProgressBar mContactLoadingBar;
    private List<ContactItemBean> mData;
    private SuspensionDecoration mDecoration;
    private IndexBar mIndexBar;
    private CustomLinearLayoutManager mManager;
    private RecyclerView mRv;
    private TextView mTvSideBarHint;
    private ContactPresenter presenter;

    /* loaded from: classes3.dex */
    public static class DataSource {
        public static final int BLACK_LIST = 2;
        public static final int CONTACT_LIST = 4;
        public static final int FRIEND_LIST = 1;
        public static final int GROUP_LIST = 3;
        public static final int GROUP_MEMBER_LIST = 5;
        public static final int UNKNOWN = -1;
    }

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onItemClick(int i2, ContactItemBean contactItemBean);
    }

    /* loaded from: classes3.dex */
    public interface OnSelectChangedListener {
        void onSelectChanged(ContactItemBean contactItemBean, boolean z);
    }

    public ContactListView(Context context) {
        super(context);
        this.mData = new ArrayList();
        this.isGroupList = false;
        this.dataSourceType = -1;
        init();
    }

    private void init() {
        LinearLayout.inflate(getContext(), R.layout.contact_list, this);
        this.mRv = (RecyclerView) findViewById(R.id.contact_member_list);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getContext());
        this.mManager = customLinearLayoutManager;
        this.mRv.setLayoutManager(customLinearLayoutManager);
        ContactAdapter contactAdapter = new ContactAdapter(this.mData);
        this.mAdapter = contactAdapter;
        this.mRv.setAdapter(contactAdapter);
        RecyclerView recyclerView = this.mRv;
        SuspensionDecoration suspensionDecoration = new SuspensionDecoration(getContext(), this.mData);
        this.mDecoration = suspensionDecoration;
        recyclerView.addItemDecoration(suspensionDecoration);
        this.mRv.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i2, int i3) {
                super.onScrolled(recyclerView2, i2, i3);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView2.getLayoutManager();
                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() != linearLayoutManager.getItemCount() - 1 || ContactListView.this.presenter.getNextSeq() <= 0) {
                    return;
                }
                ContactListView.this.presenter.loadGroupMemberList(ContactListView.this.groupId);
            }
        });
        this.mTvSideBarHint = (TextView) findViewById(R.id.contact_tvSideBarHint);
        IndexBar indexBar = (IndexBar) findViewById(R.id.contact_indexBar);
        this.mIndexBar = indexBar;
        indexBar.setPressedShowTextView(this.mTvSideBarHint).setNeedRealIndex(false).setLayoutManager(this.mManager);
        this.mContactLoadingBar = (ProgressBar) findViewById(R.id.contact_loading_bar);
    }

    public ContactAdapter getAdapter() {
        return this.mAdapter;
    }

    public void loadDataSource(int i2) {
        this.dataSourceType = i2;
        if (this.presenter == null) {
            return;
        }
        this.mContactLoadingBar.setVisibility(0);
        if (i2 == 5) {
            this.presenter.loadGroupMemberList(this.groupId);
        } else {
            this.presenter.loadDataSource(i2);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IContactListView
    public void onDataSourceChanged(List<ContactItemBean> list) {
        this.mContactLoadingBar.setVisibility(8);
        this.mData = list;
        this.mAdapter.setDataSource(list);
        this.mIndexBar.setSourceDatas(this.mData).invalidate();
        this.mDecoration.setDatas(this.mData);
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IContactListView
    public void onFriendApplicationChanged() {
        if (this.dataSourceType == 4) {
            this.mAdapter.notifyItemChanged(0);
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setIsGroupList(boolean z) {
        this.isGroupList = z;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mAdapter.setOnItemClickListener(onItemClickListener);
    }

    public void setOnSelectChangeListener(OnSelectChangedListener onSelectChangedListener) {
        this.mAdapter.setOnSelectChangedListener(onSelectChangedListener);
    }

    public void setPresenter(ContactPresenter contactPresenter) {
        this.presenter = contactPresenter;
        ContactAdapter contactAdapter = this.mAdapter;
        if (contactAdapter != null) {
            contactAdapter.setPresenter(contactPresenter);
            this.mAdapter.setIsGroupList(this.isGroupList);
        }
    }

    public void setSingleSelectMode(boolean z) {
        this.mAdapter.setSingleSelectMode(z);
    }

    public ContactListView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mData = new ArrayList();
        this.isGroupList = false;
        this.dataSourceType = -1;
        init();
    }

    public ContactListView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mData = new ArrayList();
        this.isGroupList = false;
        this.dataSourceType = -1;
        init();
    }
}
