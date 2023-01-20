package com.tencent.qcloud.tuikit.tuichat.ui.page;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.presenter.GroupMessageReceiptPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupMessageReceiptActivity extends BaseLightActivity {
    private static final String TAG = GroupMessageReceiptActivity.class.getSimpleName();
    private TUIMessageBean messageBean;
    private TextView msgAbstract;
    private ImageView msgAbstractImg;
    private TextView nameTv;
    private GroupMessageReceiptPresenter presenter;
    private MemberAdapter readAdapter;
    private RecyclerView readList;
    private long readNextSeq;
    private View readTitle;
    private View readTitleLine;
    private TextView readTitleTv;
    private TextView timeTv;
    private TitleBarLayout titleBarLayout;
    private MemberAdapter unreadAdapter;
    private RecyclerView unreadList;
    private long unreadNextSeq;
    private View unreadTitle;
    private View unreadTitleLine;
    private TextView unreadTitleTv;
    private List<GroupMemberInfo> readMemberList = new ArrayList();
    private List<GroupMemberInfo> unreadMemberList = new ArrayList();
    private boolean readFinished = false;
    private boolean unreadFinished = false;
    private boolean readLoading = false;
    private boolean unreadLoading = false;

    /* loaded from: classes3.dex */
    public static class MemberAdapter extends RecyclerView.Adapter<MemberViewHolder> {
        private List<GroupMemberInfo> data;

        /* loaded from: classes3.dex */
        public static class MemberViewHolder extends RecyclerView.ViewHolder {
            private final ImageView face;
            private final TextView name;

            public MemberViewHolder(@NonNull View view) {
                super(view);
                this.face = (ImageView) view.findViewById(R.id.avatar_img);
                this.name = (TextView) view.findViewById(R.id.name_tv);
            }
        }

        private String getDisplayName(GroupMemberInfo groupMemberInfo) {
            if (!TextUtils.isEmpty(groupMemberInfo.getNameCard())) {
                return groupMemberInfo.getNameCard();
            }
            if (!TextUtils.isEmpty(groupMemberInfo.getFriendRemark())) {
                return groupMemberInfo.getFriendRemark();
            }
            if (!TextUtils.isEmpty(groupMemberInfo.getNickName())) {
                return groupMemberInfo.getNickName();
            }
            return groupMemberInfo.getAccount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<GroupMemberInfo> list = this.data;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return this.data.size();
        }

        public void setData(List<GroupMemberInfo> list) {
            this.data = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull MemberViewHolder memberViewHolder, int i2) {
            final GroupMemberInfo groupMemberInfo = this.data.get(i2);
            GlideEngine.loadUserIcon(memberViewHolder.face, groupMemberInfo.getIconUrl());
            memberViewHolder.name.setText(getDisplayName(groupMemberInfo));
            memberViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.MemberAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("chatId", groupMemberInfo.getAccount());
                    TUICore.startActivity("FriendProfileActivity", bundle);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new MemberViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_receipt_member_item, viewGroup, false));
        }
    }

    private ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams layoutParams, TUIMessageBean tUIMessageBean) {
        int imgWidth;
        int imgHeight;
        if (tUIMessageBean instanceof ImageMessageBean) {
            ImageMessageBean imageMessageBean = (ImageMessageBean) tUIMessageBean;
            imgWidth = imageMessageBean.getImgWidth();
            imgHeight = imageMessageBean.getImgHeight();
        } else {
            VideoMessageBean videoMessageBean = (VideoMessageBean) tUIMessageBean;
            imgWidth = videoMessageBean.getImgWidth();
            imgHeight = videoMessageBean.getImgHeight();
        }
        if (imgWidth != 0 && imgHeight != 0) {
            int dip2px = ScreenUtil.dip2px(40.32f);
            if (imgWidth > imgHeight) {
                layoutParams.width = dip2px;
                layoutParams.height = (dip2px * imgHeight) / imgWidth;
            } else {
                layoutParams.width = (imgWidth * dip2px) / imgHeight;
                layoutParams.height = dip2px;
            }
        }
        return layoutParams;
    }

    private void initData() {
        this.messageBean = (TUIMessageBean) getIntent().getSerializableExtra(TUIChatConstants.MESSAGE_BEAN);
        this.presenter = new GroupMessageReceiptPresenter();
        setMsgAbstract();
        this.nameTv.setText(this.messageBean.getUserDisplayName());
        this.timeTv.setText(DateTimeUtil.getTimeFormatText(new Date(this.messageBean.getMessageTime() * 1000), Boolean.TRUE));
        this.readAdapter = new MemberAdapter();
        this.unreadAdapter = new MemberAdapter();
        this.readList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.unreadList.setLayoutManager(new CustomLinearLayoutManager(this));
        this.readList.setAdapter(this.readAdapter);
        this.unreadList.setAdapter(this.unreadAdapter);
        this.presenter.getGroupMessageReadReceipt(this.messageBean, new IUIKitCallback<List<GroupMessageReceiptInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.4
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<GroupMessageReceiptInfo> list) {
                GroupMessageReceiptInfo groupMessageReceiptInfo = list.get(0);
                GroupMessageReceiptActivity.this.readTitleTv.setText(GroupMessageReceiptActivity.this.getString(R.string.someone_have_read, new Object[]{Long.valueOf(groupMessageReceiptInfo.getReadCount())}));
                GroupMessageReceiptActivity.this.unreadTitleTv.setText(GroupMessageReceiptActivity.this.getString(R.string.someone_unread, new Object[]{Long.valueOf(groupMessageReceiptInfo.getUnreadCount())}));
            }
        });
        this.readList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                if (i2 == 0) {
                    GroupMessageReceiptActivity groupMessageReceiptActivity = GroupMessageReceiptActivity.this;
                    if (!groupMessageReceiptActivity.isLastItemVisibleCompleted(groupMessageReceiptActivity.readList) || GroupMessageReceiptActivity.this.readFinished) {
                        return;
                    }
                    GroupMessageReceiptActivity groupMessageReceiptActivity2 = GroupMessageReceiptActivity.this;
                    groupMessageReceiptActivity2.loadGroupMessageReadMembers(groupMessageReceiptActivity2.readNextSeq);
                }
            }
        });
        this.unreadList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                if (i2 == 0) {
                    GroupMessageReceiptActivity groupMessageReceiptActivity = GroupMessageReceiptActivity.this;
                    if (!groupMessageReceiptActivity.isLastItemVisibleCompleted(groupMessageReceiptActivity.unreadList) || GroupMessageReceiptActivity.this.unreadFinished) {
                        return;
                    }
                    GroupMessageReceiptActivity groupMessageReceiptActivity2 = GroupMessageReceiptActivity.this;
                    groupMessageReceiptActivity2.loadGroupMessageUnreadMembers(groupMessageReceiptActivity2.unreadNextSeq);
                }
            }
        });
        loadGroupMessageReadMembers(0L);
        loadGroupMessageUnreadMembers(0L);
    }

    private void initView() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.group_receipt_title);
        this.titleBarLayout = titleBarLayout;
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupMessageReceiptActivity.this.finish();
            }
        });
        this.titleBarLayout.setTitle(getString(R.string.chat_message_detail), ITitleBarLayout.Position.MIDDLE);
        this.msgAbstract = (TextView) findViewById(R.id.msg_abstract);
        this.msgAbstractImg = (ImageView) findViewById(R.id.msg_abstract_iv);
        this.nameTv = (TextView) findViewById(R.id.name_tv);
        this.timeTv = (TextView) findViewById(R.id.time_tv);
        this.readTitleTv = (TextView) findViewById(R.id.read_title_tv);
        this.unreadTitleTv = (TextView) findViewById(R.id.unread_title_tv);
        this.readTitleLine = findViewById(R.id.read_title_line);
        this.unreadTitleLine = findViewById(R.id.unread_title_line);
        this.readList = (RecyclerView) findViewById(R.id.read_list);
        this.unreadList = (RecyclerView) findViewById(R.id.unread_list);
        this.readTitle = findViewById(R.id.read_title);
        this.unreadTitle = findViewById(R.id.unread_title);
        this.readTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupMessageReceiptActivity.this.readTitleLine.setVisibility(0);
                GroupMessageReceiptActivity.this.readTitleTv.setTextColor(GroupMessageReceiptActivity.this.getResources().getColor(TUIThemeManager.getAttrResId(GroupMessageReceiptActivity.this, R.attr.core_primary_color)));
                GroupMessageReceiptActivity.this.readList.setVisibility(0);
                GroupMessageReceiptActivity.this.unreadList.setVisibility(8);
                GroupMessageReceiptActivity.this.unreadTitleLine.setVisibility(4);
                GroupMessageReceiptActivity.this.unreadTitleTv.setTextColor(-12303292);
            }
        });
        this.unreadTitle.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupMessageReceiptActivity.this.unreadTitleLine.setVisibility(0);
                GroupMessageReceiptActivity.this.unreadTitleTv.setTextColor(GroupMessageReceiptActivity.this.getResources().getColor(TUIThemeManager.getAttrResId(GroupMessageReceiptActivity.this, R.attr.core_primary_color)));
                GroupMessageReceiptActivity.this.unreadList.setVisibility(0);
                GroupMessageReceiptActivity.this.readList.setVisibility(8);
                GroupMessageReceiptActivity.this.readTitleLine.setVisibility(4);
                GroupMessageReceiptActivity.this.readTitleTv.setTextColor(-12303292);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadGroupMessageReadMembers(long j2) {
        if (this.readLoading) {
            return;
        }
        this.readLoading = true;
        this.presenter.getGroupMessageReadMembers(this.messageBean, true, j2, new IUIKitCallback<GroupMessageReadMembersInfo>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.7
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                GroupMessageReceiptActivity.this.readLoading = false;
                Log.e("GroupMessageReceiptActivity", "errCode " + i2 + " errMsg " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                GroupMessageReceiptActivity.this.readNextSeq = groupMessageReadMembersInfo.getNextSeq();
                GroupMessageReceiptActivity.this.readFinished = groupMessageReadMembersInfo.isFinished();
                GroupMessageReceiptActivity.this.readMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                GroupMessageReceiptActivity.this.readAdapter.setData(GroupMessageReceiptActivity.this.readMemberList);
                GroupMessageReceiptActivity.this.readAdapter.notifyDataSetChanged();
                GroupMessageReceiptActivity.this.readLoading = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadGroupMessageUnreadMembers(long j2) {
        if (this.unreadLoading) {
            return;
        }
        this.unreadLoading = true;
        this.presenter.getGroupMessageReadMembers(this.messageBean, false, j2, new IUIKitCallback<GroupMessageReadMembersInfo>() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.page.GroupMessageReceiptActivity.8
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                GroupMessageReceiptActivity.this.unreadLoading = false;
                Log.e("GroupMessageReceiptActivity", "errCode " + i2 + " errMsg " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(GroupMessageReadMembersInfo groupMessageReadMembersInfo) {
                GroupMessageReceiptActivity.this.unreadNextSeq = groupMessageReadMembersInfo.getNextSeq();
                GroupMessageReceiptActivity.this.unreadFinished = groupMessageReadMembersInfo.isFinished();
                GroupMessageReceiptActivity.this.unreadMemberList.addAll(groupMessageReadMembersInfo.getGroupMemberInfoList());
                GroupMessageReceiptActivity.this.unreadAdapter.setData(GroupMessageReceiptActivity.this.unreadMemberList);
                GroupMessageReceiptActivity.this.unreadAdapter.notifyDataSetChanged();
                GroupMessageReceiptActivity.this.unreadLoading = false;
            }
        });
    }

    private void setMsgAbstract() {
        TUIMessageBean tUIMessageBean = this.messageBean;
        if (!(tUIMessageBean instanceof ImageMessageBean) && !(tUIMessageBean instanceof VideoMessageBean)) {
            this.msgAbstractImg.setVisibility(8);
            TUIMessageBean tUIMessageBean2 = this.messageBean;
            if (tUIMessageBean2 instanceof FileMessageBean) {
                TextView textView = this.msgAbstract;
                textView.setText(this.messageBean.getExtra() + ((FileMessageBean) this.messageBean).getFileName());
                return;
            }
            this.msgAbstract.setText(tUIMessageBean2.getExtra());
            return;
        }
        ImageView imageView = this.msgAbstractImg;
        imageView.setLayoutParams(getImageParams(imageView.getLayoutParams(), this.messageBean));
        this.msgAbstractImg.setVisibility(0);
        TUIMessageBean tUIMessageBean3 = this.messageBean;
        if (tUIMessageBean3 instanceof ImageMessageBean) {
            GlideEngine.loadImage(this.msgAbstractImg, ((ImageMessageBean) tUIMessageBean3).getDataPath());
        } else if (tUIMessageBean3 instanceof VideoMessageBean) {
            GlideEngine.loadImage(this.msgAbstractImg, ((VideoMessageBean) tUIMessageBean3).getDataPath());
        }
        this.msgAbstract.setText("");
    }

    public boolean isLastItemVisibleCompleted(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager == null) {
            return false;
        }
        return linearLayoutManager.findLastCompletelyVisibleItemPosition() >= (linearLayoutManager.findFirstVisibleItemPosition() + linearLayoutManager.getChildCount()) - 1;
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String str = TAG;
        TUIChatLog.i(str, "onCreate " + this);
        setContentView(R.layout.group_msg_receipt_layout);
        initView();
        initData();
    }
}
