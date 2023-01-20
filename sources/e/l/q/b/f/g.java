package e.l.q.b.f;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.jihuanshe.ui.page.im.ImChatActivity;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.t1;

/* loaded from: classes2.dex */
public final class g {
    public static final void a(@k.e.a.d Context context, @k.e.a.d String str, @k.e.a.e String str2) {
        Intent intent = new Intent(context, ImChatActivity.class);
        intent.putExtra(TUIConstants.TUIChat.CHAT_TYPE, 1);
        intent.putExtra("chatId", str);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        intent.putExtra(TUIConstants.TUIChat.CHAT_NAME, str);
        t1 t1Var = t1.a;
        context.startActivity(intent);
    }
}
