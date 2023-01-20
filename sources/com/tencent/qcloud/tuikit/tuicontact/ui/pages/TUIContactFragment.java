package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactService;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactLayout;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView;
import com.tencent.qcloud.tuikit.tuicontact.util.TUIContactLog;

/* loaded from: classes3.dex */
public class TUIContactFragment extends BaseFragment {
    private static final String TAG = TUIContactFragment.class.getSimpleName();
    private ContactLayout mContactLayout;
    private ContactPresenter presenter;

    private void initViews(View view) {
        this.mContactLayout = (ContactLayout) view.findViewById(R.id.contact_layout);
        ContactPresenter contactPresenter = new ContactPresenter();
        this.presenter = contactPresenter;
        contactPresenter.setFriendListListener();
        this.mContactLayout.setPresenter(this.presenter);
        this.mContactLayout.initDefault();
        this.mContactLayout.getContactListView().setOnItemClickListener(new ContactListView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.TUIContactFragment.1
            @Override // com.tencent.qcloud.tuikit.tuicontact.ui.view.ContactListView.OnItemClickListener
            public void onItemClick(int i2, ContactItemBean contactItemBean) {
                if (i2 == 0) {
                    Intent intent = new Intent(TUIContactService.getAppContext(), NewFriendActivity.class);
                    intent.addFlags(268435456);
                    TUIContactService.getAppContext().startActivity(intent);
                } else if (i2 == 1) {
                    Intent intent2 = new Intent(TUIContactService.getAppContext(), GroupListActivity.class);
                    intent2.addFlags(268435456);
                    TUIContactService.getAppContext().startActivity(intent2);
                } else if (i2 == 2) {
                    Intent intent3 = new Intent(TUIContactService.getAppContext(), BlackListActivity.class);
                    intent3.addFlags(268435456);
                    TUIContactService.getAppContext().startActivity(intent3);
                } else {
                    Intent intent4 = new Intent(TUIContactService.getAppContext(), FriendProfileActivity.class);
                    intent4.addFlags(268435456);
                    intent4.putExtra("content", contactItemBean);
                    TUIContactService.getAppContext().startActivity(intent4);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.contact_fragment, viewGroup, false);
        initViews(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TUIContactLog.i(TAG, "onResume");
    }
}
