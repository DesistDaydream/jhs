package com.tencent.qcloud.tuikit.tuiconversation.setting;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationLayout;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ConversationLayoutSetting {
    public static void customizeConversation(ConversationLayout conversationLayout) {
        final ConversationListLayout conversationList = conversationLayout.getConversationList();
        Handler handler = new Handler(Looper.getMainLooper());
        Objects.requireNonNull(conversationList);
        handler.postDelayed(new Runnable() { // from class: e.s.a.b.c.a.a
            @Override // java.lang.Runnable
            public final void run() {
                ConversationListLayout.this.scrollToStart();
            }
        }, 600L);
        conversationList.setItemAvatarRadius(ScreenUtil.getPxByDp(50.0f));
    }
}
