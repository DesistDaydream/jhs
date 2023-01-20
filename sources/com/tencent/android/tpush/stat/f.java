package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f {
    private static volatile f a;
    private static com.tencent.android.tpush.stat.b.c b = com.tencent.android.tpush.stat.b.b.b();

    /* renamed from: c  reason: collision with root package name */
    private static Context f6470c = null;

    /* renamed from: d  reason: collision with root package name */
    private StringBuilder f6471d = new StringBuilder(4096);

    /* renamed from: e  reason: collision with root package name */
    private long f6472e;

    private f(Context context) {
        this.f6472e = 0L;
        try {
            f6470c = context.getApplicationContext();
            this.f6472e = System.currentTimeMillis() / 1000;
        } catch (Throwable th) {
            b.b(th);
        }
    }

    public static void a(Context context) {
        f6470c = context.getApplicationContext();
    }

    public static f b(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    public static Context a() {
        return f6470c;
    }

    private void a(JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull("cfg")) {
                d.a(f6470c, jSONObject.getJSONObject("cfg"));
            }
            if (jSONObject.isNull("ncts")) {
                return;
            }
            int i2 = jSONObject.getInt("ncts");
            int currentTimeMillis = (int) (i2 - (System.currentTimeMillis() / 1000));
            if (d.b()) {
                com.tencent.android.tpush.stat.b.c cVar = b;
                cVar.b("server time:" + i2 + ", diff time:" + currentTimeMillis);
            }
            com.tencent.android.tpush.stat.b.b.f(f6470c);
            com.tencent.android.tpush.stat.b.b.a(f6470c, currentTimeMillis);
        } catch (Throwable th) {
            b.d(th);
        }
    }

    public void b(List<?> list, e eVar) {
        try {
            if (!i.b(GuidInfoManager.getToken(f6470c))) {
                a(list, eVar);
            } else if (eVar != null) {
                eVar.a();
            }
        } catch (Throwable unused) {
            b.c("unexpected for sendList");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x03ab A[Catch: all -> 0x03d6, TryCatch #3 {all -> 0x03d6, blocks: (B:12:0x002f, B:16:0x0043, B:24:0x0097, B:25:0x009a, B:43:0x0115, B:45:0x011b, B:46:0x013f, B:48:0x0154, B:50:0x0165, B:52:0x0178, B:54:0x019f, B:56:0x01a5, B:58:0x01ac, B:60:0x01b2, B:61:0x01b7, B:63:0x01d8, B:64:0x01fc, B:75:0x025c, B:77:0x0281, B:80:0x02b3, B:83:0x02cf, B:96:0x0336, B:98:0x0352, B:100:0x035c, B:102:0x0365, B:103:0x0386, B:108:0x03ce, B:104:0x03a0, B:84:0x02d9, B:86:0x02e1, B:87:0x02f3, B:89:0x02fb, B:90:0x030d, B:92:0x0313, B:93:0x0321, B:95:0x0329, B:105:0x03ab, B:107:0x03cb, B:51:0x0172, B:42:0x00fb, B:17:0x004b, B:19:0x005c, B:21:0x0075), top: B:132:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011b A[Catch: all -> 0x03d6, TryCatch #3 {all -> 0x03d6, blocks: (B:12:0x002f, B:16:0x0043, B:24:0x0097, B:25:0x009a, B:43:0x0115, B:45:0x011b, B:46:0x013f, B:48:0x0154, B:50:0x0165, B:52:0x0178, B:54:0x019f, B:56:0x01a5, B:58:0x01ac, B:60:0x01b2, B:61:0x01b7, B:63:0x01d8, B:64:0x01fc, B:75:0x025c, B:77:0x0281, B:80:0x02b3, B:83:0x02cf, B:96:0x0336, B:98:0x0352, B:100:0x035c, B:102:0x0365, B:103:0x0386, B:108:0x03ce, B:104:0x03a0, B:84:0x02d9, B:86:0x02e1, B:87:0x02f3, B:89:0x02fb, B:90:0x030d, B:92:0x0313, B:93:0x0321, B:95:0x0329, B:105:0x03ab, B:107:0x03cb, B:51:0x0172, B:42:0x00fb, B:17:0x004b, B:19:0x005c, B:21:0x0075), top: B:132:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0154 A[Catch: all -> 0x03d6, TryCatch #3 {all -> 0x03d6, blocks: (B:12:0x002f, B:16:0x0043, B:24:0x0097, B:25:0x009a, B:43:0x0115, B:45:0x011b, B:46:0x013f, B:48:0x0154, B:50:0x0165, B:52:0x0178, B:54:0x019f, B:56:0x01a5, B:58:0x01ac, B:60:0x01b2, B:61:0x01b7, B:63:0x01d8, B:64:0x01fc, B:75:0x025c, B:77:0x0281, B:80:0x02b3, B:83:0x02cf, B:96:0x0336, B:98:0x0352, B:100:0x035c, B:102:0x0365, B:103:0x0386, B:108:0x03ce, B:104:0x03a0, B:84:0x02d9, B:86:0x02e1, B:87:0x02f3, B:89:0x02fb, B:90:0x030d, B:92:0x0313, B:93:0x0321, B:95:0x0329, B:105:0x03ab, B:107:0x03cb, B:51:0x0172, B:42:0x00fb, B:17:0x004b, B:19:0x005c, B:21:0x0075), top: B:132:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172 A[Catch: all -> 0x03d6, TryCatch #3 {all -> 0x03d6, blocks: (B:12:0x002f, B:16:0x0043, B:24:0x0097, B:25:0x009a, B:43:0x0115, B:45:0x011b, B:46:0x013f, B:48:0x0154, B:50:0x0165, B:52:0x0178, B:54:0x019f, B:56:0x01a5, B:58:0x01ac, B:60:0x01b2, B:61:0x01b7, B:63:0x01d8, B:64:0x01fc, B:75:0x025c, B:77:0x0281, B:80:0x02b3, B:83:0x02cf, B:96:0x0336, B:98:0x0352, B:100:0x035c, B:102:0x0365, B:103:0x0386, B:108:0x03ce, B:104:0x03a0, B:84:0x02d9, B:86:0x02e1, B:87:0x02f3, B:89:0x02fb, B:90:0x030d, B:92:0x0313, B:93:0x0321, B:95:0x0329, B:105:0x03ab, B:107:0x03cb, B:51:0x0172, B:42:0x00fb, B:17:0x004b, B:19:0x005c, B:21:0x0075), top: B:132:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d8 A[Catch: all -> 0x03d6, TryCatch #3 {all -> 0x03d6, blocks: (B:12:0x002f, B:16:0x0043, B:24:0x0097, B:25:0x009a, B:43:0x0115, B:45:0x011b, B:46:0x013f, B:48:0x0154, B:50:0x0165, B:52:0x0178, B:54:0x019f, B:56:0x01a5, B:58:0x01ac, B:60:0x01b2, B:61:0x01b7, B:63:0x01d8, B:64:0x01fc, B:75:0x025c, B:77:0x0281, B:80:0x02b3, B:83:0x02cf, B:96:0x0336, B:98:0x0352, B:100:0x035c, B:102:0x0365, B:103:0x0386, B:108:0x03ce, B:104:0x03a0, B:84:0x02d9, B:86:0x02e1, B:87:0x02f3, B:89:0x02fb, B:90:0x030d, B:92:0x0313, B:93:0x0321, B:95:0x0329, B:105:0x03ab, B:107:0x03cb, B:51:0x0172, B:42:0x00fb, B:17:0x004b, B:19:0x005c, B:21:0x0075), top: B:132:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x022c A[Catch: all -> 0x025c, TryCatch #5 {all -> 0x025c, blocks: (B:65:0x0211, B:67:0x022c, B:68:0x0234, B:70:0x023a, B:73:0x0254), top: B:136:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0281 A[Catch: all -> 0x03d6, TryCatch #3 {all -> 0x03d6, blocks: (B:12:0x002f, B:16:0x0043, B:24:0x0097, B:25:0x009a, B:43:0x0115, B:45:0x011b, B:46:0x013f, B:48:0x0154, B:50:0x0165, B:52:0x0178, B:54:0x019f, B:56:0x01a5, B:58:0x01ac, B:60:0x01b2, B:61:0x01b7, B:63:0x01d8, B:64:0x01fc, B:75:0x025c, B:77:0x0281, B:80:0x02b3, B:83:0x02cf, B:96:0x0336, B:98:0x0352, B:100:0x035c, B:102:0x0365, B:103:0x0386, B:108:0x03ce, B:104:0x03a0, B:84:0x02d9, B:86:0x02e1, B:87:0x02f3, B:89:0x02fb, B:90:0x030d, B:92:0x0313, B:93:0x0321, B:95:0x0329, B:105:0x03ab, B:107:0x03cb, B:51:0x0172, B:42:0x00fb, B:17:0x004b, B:19:0x005c, B:21:0x0075), top: B:132:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02b3 A[Catch: all -> 0x03d6, TRY_LEAVE, TryCatch #3 {all -> 0x03d6, blocks: (B:12:0x002f, B:16:0x0043, B:24:0x0097, B:25:0x009a, B:43:0x0115, B:45:0x011b, B:46:0x013f, B:48:0x0154, B:50:0x0165, B:52:0x0178, B:54:0x019f, B:56:0x01a5, B:58:0x01ac, B:60:0x01b2, B:61:0x01b7, B:63:0x01d8, B:64:0x01fc, B:75:0x025c, B:77:0x0281, B:80:0x02b3, B:83:0x02cf, B:96:0x0336, B:98:0x0352, B:100:0x035c, B:102:0x0365, B:103:0x0386, B:108:0x03ce, B:104:0x03a0, B:84:0x02d9, B:86:0x02e1, B:87:0x02f3, B:89:0x02fb, B:90:0x030d, B:92:0x0313, B:93:0x0321, B:95:0x0329, B:105:0x03ab, B:107:0x03cb, B:51:0x0172, B:42:0x00fb, B:17:0x004b, B:19:0x005c, B:21:0x0075), top: B:132:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<?> r18, com.tencent.android.tpush.stat.e r19) {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.f.a(java.util.List, com.tencent.android.tpush.stat.e):void");
    }

    public void a(Event event, e eVar) {
        b(Arrays.asList(event.toJsonString()), eVar);
    }
}
