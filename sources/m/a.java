package m;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageContainerBean;

/* loaded from: classes4.dex */
public class a {
    private static final String a = "a";
    private static final String b = "ext";

    /* renamed from: c  reason: collision with root package name */
    private static final String f17112c = "customContent";

    private static OfflineMessageBean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c((OfflineMessageBean) new Gson().n(str, OfflineMessageBean.class));
    }

    private static OfflineMessageBean b(String str) {
        OfflineMessageContainerBean offlineMessageContainerBean;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            offlineMessageContainerBean = (OfflineMessageContainerBean) new Gson().n(str, OfflineMessageContainerBean.class);
        } catch (Exception e2) {
            e.l.h.k.b bVar = e.l.h.k.b.a;
            String str2 = a;
            bVar.g(str2, "getOfflineMessageBeanFromContainer: " + e2.getMessage());
            offlineMessageContainerBean = null;
        }
        if (offlineMessageContainerBean == null) {
            return null;
        }
        return c(offlineMessageContainerBean.entity);
    }

    private static OfflineMessageBean c(OfflineMessageBean offlineMessageBean) {
        int i2;
        if (offlineMessageBean == null) {
            return null;
        }
        if (offlineMessageBean.version == 1 && ((i2 = offlineMessageBean.action) == 1 || i2 == 2)) {
            return offlineMessageBean;
        }
        String.valueOf(TUIConfig.getAppContext().getPackageManager().getApplicationLabel(TUIConfig.getAppContext().getApplicationInfo()));
        e.l.h.k.b bVar = e.l.h.k.b.a;
        String str = a;
        bVar.b(str, "unknown version: " + offlineMessageBean.version + " or action: " + offlineMessageBean.action);
        return null;
    }

    public static OfflineMessageBean d(Intent intent) {
        e.l.h.k.b bVar = e.l.h.k.b.a;
        String str = a;
        bVar.d(str, "intent: " + intent);
        if (intent == null) {
            return null;
        }
        bVar.d(str, "parse OEM push");
        Bundle extras = intent.getExtras();
        bVar.d(str, "bundle: " + extras);
        if (extras == null) {
            if (intent.getData() == null) {
                bVar.d(str, "intent.getData() uri is null");
                return null;
            }
            return e(intent);
        } else if (extras.getBoolean("localNotification", false)) {
            bVar.d(str, "localNotification");
            OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
            offlineMessageBean.sender = extras.getString("chatId");
            offlineMessageBean.nickname = extras.getString(TUIConstants.TUIChat.CHAT_NAME);
            offlineMessageBean.action = 1;
            return offlineMessageBean;
        } else {
            String string = extras.getString(b);
            bVar.d(str, "push custom data ext: " + string);
            if (TextUtils.isEmpty(string)) {
                bVar.d(str, "ext is null");
                return null;
            }
            return b(string);
        }
    }

    private static OfflineMessageBean e(Intent intent) {
        e.l.h.k.b bVar = e.l.h.k.b.a;
        String str = a;
        bVar.d(str, "parse TPNS push");
        Uri data = intent.getData();
        if (data == null) {
            bVar.d(str, "intent.getData() uri is null");
            return null;
        }
        bVar.d(str, "parseOfflineMessageTPNS get data uri: " + data);
        String queryParameter = data.getQueryParameter("customContent");
        bVar.d(str, "push custom data ext: " + queryParameter);
        if (!TextUtils.isEmpty(queryParameter)) {
            return b(queryParameter);
        }
        bVar.d(str, "TextUtils.isEmpty(ext)");
        return null;
    }
}
