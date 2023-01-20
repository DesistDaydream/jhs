package com.tencent.android.tpush.b;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class a {
    private static String a = "InMsgManagerInstance";
    private static String b = "com.tencent.android.tpush.inapp.InMsgManager";

    /* renamed from: c  reason: collision with root package name */
    private static String f6054c = "show";

    /* renamed from: d  reason: collision with root package name */
    private static String f6055d = "dismiss";

    /* renamed from: e  reason: collision with root package name */
    private static Class<?> f6056e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f6057f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f6058g;

    public static void a() {
        try {
            if (f6058g) {
                return;
            }
            if (f6056e == null) {
                f6056e = Class.forName(b);
            }
            if (f6057f == null) {
                f6057f = f6056e.getDeclaredMethod(f6054c, Context.class, PushMessageManager.class);
            }
            f6058g = true;
        } catch (Throwable th) {
            String str = a;
            TLogger.w(str, "invoke method show() error: " + th.toString());
        }
    }

    public static void a(Context context, PushMessageManager pushMessageManager) {
        try {
            a();
            f6057f.invoke(f6056e, context, pushMessageManager);
        } catch (Throwable th) {
            String str = a;
            TLogger.w(str, "invoke method show() error: " + th.toString());
        }
    }
}
