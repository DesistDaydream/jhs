package e.s.a.a.a;

import com.tencent.qcloud.tuicore.interfaces.TUICallback;

/* compiled from: TUICallback.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static void a(TUICallback tUICallback, int i2, String str) {
        if (tUICallback != null) {
            tUICallback.onError(i2, str);
        }
    }

    public static void b(TUICallback tUICallback) {
        if (tUICallback != null) {
            tUICallback.onSuccess();
        }
    }
}
