package com.jihuanshe.ui.page.im;

import android.os.Bundle;
import com.jihuanshe.R;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatActivity;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import h.k2.v.f0;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ImChatActivity extends TUIBaseChatActivity {
    private final String a = ImChatActivity.class.getSimpleName();
    @e
    private ImChatFragment b;

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.page.TUIBaseChatActivity
    public void initChat(@e ChatInfo chatInfo) {
        TUIChatLog.i(this.a, f0.C("inti chat ", chatInfo));
        if (!TUIChatUtils.isC2CChat(chatInfo.getType())) {
            TUIChatLog.e(this.a, f0.C("init C2C chat failed , chatInfo = ", chatInfo));
            ToastUtil.toastShortMessage("im初始化失败");
        }
        if (this.b == null) {
            this.b = new ImChatFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(TUIChatConstants.CHAT_INFO, chatInfo);
            this.b.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, this.b).commitAllowingStateLoss();
        }
        getWindow().setNavigationBarColor(-1);
    }
}
