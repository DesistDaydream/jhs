package com.tencent.qcloud.tuikit.tuiconversation.ui.page;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.util.TUIConversationLog;

/* loaded from: classes3.dex */
public class TUIForwardSelectActivity extends BaseLightActivity {
    private static final String TAG = TUIForwardSelectActivity.class.getSimpleName();
    private TUIForwardSelectFragment mTUIForwardSelectFragment;

    private void init() {
        this.mTUIForwardSelectFragment = new TUIForwardSelectFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, this.mTUIForwardSelectFragment).commitAllowingStateLoss();
    }

    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forward_activity);
        init();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        TUIConversationLog.i(TAG, "onNewIntent");
        super.onNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        TUIConversationLog.i(TAG, "onResume");
        super.onResume();
    }
}
