package e.j.a.b.c.r;

import androidx.annotation.NonNull;
import com.tencent.android.tpush.stat.ServiceStat;

/* loaded from: classes2.dex */
public final class f1 {
    @NonNull
    private final String a;
    @NonNull
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10415c = ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10416d;

    public f1(@NonNull String str, @NonNull String str2, boolean z, int i2) {
        this.b = str;
        this.a = str2;
        this.f10416d = z;
    }

    @NonNull
    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.f10415c;
    }

    @NonNull
    public final String c() {
        return this.a;
    }
}
