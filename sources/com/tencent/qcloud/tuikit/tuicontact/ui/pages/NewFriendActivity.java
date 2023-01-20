package com.tencent.qcloud.tuikit.tuicontact.ui.pages;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.presenter.NewFriendPresenter;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.INewFriendActivity;
import com.tencent.qcloud.tuikit.tuicontact.ui.view.NewFriendListAdapter;
import com.tencent.qcloud.tuikit.tuicontact.util.TUIContactLog;
import java.util.List;

/* loaded from: classes3.dex */
public class NewFriendActivity extends BaseLightActivity implements INewFriendActivity {
    private static final String TAG = NewFriendActivity.class.getSimpleName();
    private NewFriendListAdapter mAdapter;
    private TextView mEmptyView;
    private ListView mNewFriendLv;
    private TitleBarLayout mTitleBar;
    private NewFriendPresenter presenter;

    private void init() {
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.new_friend_titlebar);
        this.mTitleBar = titleBarLayout;
        titleBarLayout.setTitle(getResources().getString(R.string.new_friend), ITitleBarLayout.Position.MIDDLE);
        this.mTitleBar.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.NewFriendActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewFriendActivity.this.finish();
            }
        });
        this.mTitleBar.getRightIcon().setVisibility(8);
        NewFriendPresenter newFriendPresenter = new NewFriendPresenter();
        this.presenter = newFriendPresenter;
        newFriendPresenter.setFriendActivity(this);
        this.presenter.setFriendApplicationListAllRead(new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.ui.pages.NewFriendActivity.2
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
            }
        });
        this.mNewFriendLv = (ListView) findViewById(R.id.new_friend_list);
        this.mEmptyView = (TextView) findViewById(R.id.empty_text);
    }

    private void initPendency() {
        this.presenter.loadFriendApplicationList();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.contact_new_friend_activity);
        init();
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.INewFriendActivity
    public void onDataSourceChanged(List<FriendApplicationBean> list) {
        TUIContactLog.i(TAG, "getFriendApplicationList success");
        this.mNewFriendLv.setVisibility(0);
        NewFriendListAdapter newFriendListAdapter = new NewFriendListAdapter(this, R.layout.contact_new_friend_item, list);
        this.mAdapter = newFriendListAdapter;
        newFriendListAdapter.setPresenter(this.presenter);
        this.mNewFriendLv.setAdapter((ListAdapter) this.mAdapter);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initPendency();
    }
}
