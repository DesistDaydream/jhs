package com.tencent.qcloud.tuikit.tuicontact.ui.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactService;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;
import java.util.List;

/* loaded from: classes3.dex */
public class ContactAdapter extends RecyclerView.Adapter<ViewHolder> {
    private boolean isGroupList = false;
    private boolean isSingleSelectMode;
    public List<ContactItemBean> mData;
    private ContactListView.OnItemClickListener mOnClickListener;
    private ContactListView.OnSelectChangedListener mOnSelectChangedListener;
    private int mPreSelectedPosition;
    private ContactPresenter presenter;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avatar;
        public CheckBox ccSelect;
        public View content;
        public View line;
        public TextView tvName;
        public TextView unreadText;

        public ViewHolder(View view) {
            super(view);
            this.tvName = (TextView) view.findViewById(R.id.tvCity);
            TextView textView = (TextView) view.findViewById(R.id.conversation_unread);
            this.unreadText = textView;
            textView.setVisibility(8);
            this.avatar = (ImageView) view.findViewById(R.id.ivAvatar);
            this.ccSelect = (CheckBox) view.findViewById(R.id.contact_check_box);
            this.content = view.findViewById(R.id.selectable_contact_item);
            this.line = view.findViewById(R.id.view_line);
        }
    }

    public ContactAdapter(List<ContactItemBean> list) {
        this.mData = list;
    }

    public ContactItemBean getItem(int i2) {
        if (i2 < this.mData.size()) {
            return this.mData.get(i2);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ContactItemBean> list = this.mData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setDataSource(List<ContactItemBean> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public void setIsGroupList(boolean z) {
        this.isGroupList = z;
    }

    public void setOnItemClickListener(ContactListView.OnItemClickListener onItemClickListener) {
        this.mOnClickListener = onItemClickListener;
    }

    public void setOnSelectChangedListener(ContactListView.OnSelectChangedListener onSelectChangedListener) {
        this.mOnSelectChangedListener = onSelectChangedListener;
    }

    public void setPresenter(ContactPresenter contactPresenter) {
        this.presenter = contactPresenter;
    }

    public void setSingleSelectMode(boolean z) {
        this.isSingleSelectMode = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i2) {
        final ContactItemBean contactItemBean = this.mData.get(i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewHolder.line.getLayoutParams();
        if (i2 < this.mData.size() - 1) {
            if (TextUtils.equals(contactItemBean.getSuspensionTag(), this.mData.get(i2 + 1).getSuspensionTag())) {
                layoutParams.leftMargin = viewHolder.tvName.getLeft();
            } else {
                layoutParams.leftMargin = 0;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        viewHolder.line.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(contactItemBean.getRemark())) {
            viewHolder.tvName.setText(contactItemBean.getRemark());
        } else if (!TextUtils.isEmpty(contactItemBean.getNickName())) {
            viewHolder.tvName.setText(contactItemBean.getNickName());
        } else {
            viewHolder.tvName.setText(contactItemBean.getId());
        }
        if (this.mOnSelectChangedListener != null) {
            viewHolder.ccSelect.setVisibility(0);
            viewHolder.ccSelect.setChecked(contactItemBean.isSelected());
        }
        viewHolder.content.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactAdapter.1
            {
                ContactAdapter.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (contactItemBean.isEnable()) {
                    CheckBox checkBox = viewHolder.ccSelect;
                    checkBox.setChecked(!checkBox.isChecked());
                    if (ContactAdapter.this.mOnSelectChangedListener != null) {
                        ContactAdapter.this.mOnSelectChangedListener.onSelectChanged(ContactAdapter.this.getItem(i2), viewHolder.ccSelect.isChecked());
                    }
                    contactItemBean.setSelected(viewHolder.ccSelect.isChecked());
                    if (ContactAdapter.this.mOnClickListener != null) {
                        ContactAdapter.this.mOnClickListener.onItemClick(i2, contactItemBean);
                    }
                    if (ContactAdapter.this.isSingleSelectMode && i2 != ContactAdapter.this.mPreSelectedPosition && contactItemBean.isSelected()) {
                        ContactAdapter contactAdapter = ContactAdapter.this;
                        contactAdapter.mData.get(contactAdapter.mPreSelectedPosition).setSelected(false);
                        ContactAdapter contactAdapter2 = ContactAdapter.this;
                        contactAdapter2.notifyItemChanged(contactAdapter2.mPreSelectedPosition);
                    }
                    ContactAdapter.this.mPreSelectedPosition = i2;
                }
            }
        });
        viewHolder.unreadText.setVisibility(8);
        if (TextUtils.equals(TUIContactService.getAppContext().getResources().getString(R.string.new_friend), contactItemBean.getId())) {
            viewHolder.avatar.setImageResource(TUIThemeManager.getAttrResId(viewHolder.itemView.getContext(), R.attr.contact_new_friend_icon));
            this.presenter.getFriendApplicationUnreadCount(new IUIKitCallback<Integer>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactAdapter.2
                {
                    ContactAdapter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i3, String str2) {
                    ToastUtil.toastShortMessage("Error code = " + i3 + ", desc = " + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Integer num) {
                    if (num.intValue() == 0) {
                        viewHolder.unreadText.setVisibility(8);
                        return;
                    }
                    viewHolder.unreadText.setVisibility(0);
                    TextView textView = viewHolder.unreadText;
                    textView.setText("" + num);
                }
            });
        } else if (TextUtils.equals(TUIContactService.getAppContext().getResources().getString(R.string.group), contactItemBean.getId())) {
            viewHolder.avatar.setImageResource(TUIThemeManager.getAttrResId(viewHolder.itemView.getContext(), R.attr.contact_group_list_icon));
        } else if (TextUtils.equals(TUIContactService.getAppContext().getResources().getString(R.string.blacklist), contactItemBean.getId())) {
            viewHolder.avatar.setImageResource(TUIThemeManager.getAttrResId(viewHolder.itemView.getContext(), R.attr.contact_black_list_icon));
        } else {
            int dimensionPixelSize = viewHolder.itemView.getResources().getDimensionPixelSize(R.dimen.contact_profile_face_radius);
            if (this.isGroupList) {
                GlideEngine.loadUserIcon(viewHolder.avatar, contactItemBean.getAvatarUrl(), TUIThemeManager.getAttrResId(viewHolder.avatar.getContext(), R.attr.core_default_group_icon), dimensionPixelSize);
            } else {
                GlideEngine.loadUserIcon(viewHolder.avatar, contactItemBean.getAvatarUrl(), dimensionPixelSize);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_selecable_adapter_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ViewHolder viewHolder) {
        if (viewHolder != null) {
            GlideEngine.clear(viewHolder.avatar);
            viewHolder.avatar.setImageResource(0);
        }
        super.onViewRecycled((ContactAdapter) viewHolder);
    }
}
