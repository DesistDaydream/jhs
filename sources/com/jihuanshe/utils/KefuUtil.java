package com.jihuanshe.utils;

import android.app.Application;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import com.m7.imkfsdk.KfStartHelper;
import com.moor.imkf.utils.YKFUtils;
import h.w;
import h.z;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class KefuUtil {
    @d
    public static final KefuUtil a = new KefuUtil();
    @d
    private static final String b = "15ba6d10-e246-11ec-95be-cb46b9795b48";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final w f4343c = z.c(KefuUtil$helper$2.INSTANCE);

    private KefuUtil() {
    }

    private final KfStartHelper a() {
        return (KfStartHelper) f4343c.getValue();
    }

    public final void b() {
        UserKV userKV = UserKV.f3913c;
        User w = userKV.w();
        KfStartHelper a2 = a();
        String str = b;
        StringBuilder sb = new StringBuilder();
        sb.append((Object) (w == null ? null : w.getName()));
        sb.append("(UID:");
        sb.append(w == null ? null : Integer.valueOf(w.getId()));
        sb.append(')');
        String sb2 = sb.toString();
        String valueOf = String.valueOf(w == null ? null : Integer.valueOf(w.getId()));
        User w2 = userKV.w();
        a2.initSdkChat(str, sb2, valueOf, w2 != null ? w2.getAvatar() : null);
        a().setChatActivityEmoji(false);
    }

    public final void c(@d Application application) {
        YKFUtils.init(application);
    }
}
