package com.tencent.qcloud.tuikit.tuicontact.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.NewFriendPresenter;
import java.util.List;

/* loaded from: classes3.dex */
public class NewFriendListAdapter extends ArrayAdapter<FriendApplicationBean> {
    private static final String TAG = NewFriendListAdapter.class.getSimpleName();
    private int mResourceId;
    private View mView;
    private ViewHolder mViewHolder;
    private NewFriendPresenter presenter;

    /* loaded from: classes3.dex */
    public class ViewHolder {
        public TextView agree;
        public ImageView avatar;
        public TextView des;
        public TextView name;
        public TextView reject;
        public TextView result;

        public ViewHolder() {
        }
    }

    public NewFriendListAdapter(Context context, int i2, List<FriendApplicationBean> list) {
        super(context, i2, list);
        this.mResourceId = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResponse(final FriendApplicationBean friendApplicationBean, boolean z) {
        NewFriendPresenter newFriendPresenter = this.presenter;
        if (newFriendPresenter != null) {
            if (z) {
                newFriendPresenter.acceptFriendApplication(friendApplicationBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.NewFriendListAdapter.4
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        ToastUtil.toastShortMessage("Error code = " + i2 + ", desc = " + str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Void r2) {
                        friendApplicationBean.setAccept(true);
                        NewFriendListAdapter.this.refreshList();
                    }
                });
            } else {
                newFriendPresenter.refuseFriendApplication(friendApplicationBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.NewFriendListAdapter.5
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        ToastUtil.toastShortMessage("Error code = " + i2 + ", desc = " + str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Void r1) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshList() {
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        final FriendApplicationBean item = getItem(i2);
        if (view != null) {
            this.mView = view;
            this.mViewHolder = (ViewHolder) view.getTag();
        } else {
            View inflate = LayoutInflater.from(getContext()).inflate(this.mResourceId, (ViewGroup) null);
            this.mView = inflate;
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.NewFriendListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("content", item);
                    TUICore.startActivity("FriendProfileActivity", bundle);
                }
            });
            ViewHolder viewHolder = new ViewHolder();
            this.mViewHolder = viewHolder;
            viewHolder.avatar = (ImageView) this.mView.findViewById(R.id.avatar);
            this.mViewHolder.name = (TextView) this.mView.findViewById(R.id.name);
            this.mViewHolder.des = (TextView) this.mView.findViewById(R.id.description);
            this.mViewHolder.agree = (TextView) this.mView.findViewById(R.id.agree);
            this.mViewHolder.reject = (TextView) this.mView.findViewById(R.id.reject);
            this.mViewHolder.result = (TextView) this.mView.findViewById(R.id.result_tv);
            this.mView.setTag(this.mViewHolder);
        }
        Resources resources = getContext().getResources();
        GlideEngine.loadUserIcon(this.mViewHolder.avatar, item.getFaceUrl(), this.mView.getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius));
        this.mViewHolder.name.setText(TextUtils.isEmpty(item.getNickName()) ? item.getUserId() : item.getNickName());
        this.mViewHolder.des.setText(item.getAddWording());
        int addType = item.getAddType();
        if (addType == 1) {
            this.mViewHolder.agree.setText(resources.getString(R.string.request_agree));
            this.mViewHolder.agree.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.NewFriendListAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    NewFriendListAdapter.this.doResponse(item, true);
                }
            });
            this.mViewHolder.reject.setText(resources.getString(R.string.refuse));
            this.mViewHolder.reject.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.NewFriendListAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    NewFriendListAdapter.this.doResponse(item, false);
                }
            });
            if (item.isAccept()) {
                this.mViewHolder.agree.setVisibility(8);
                this.mViewHolder.reject.setVisibility(8);
                this.mViewHolder.result.setVisibility(0);
            }
        } else if (addType == 3) {
            this.mViewHolder.agree.setText(resources.getString(R.string.request_accepted));
        }
        return this.mView;
    }

    public void setPresenter(NewFriendPresenter newFriendPresenter) {
        this.presenter = newFriendPresenter;
    }
}
