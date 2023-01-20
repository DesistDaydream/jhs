package e.j.a.b.c.n;

import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.bp;
import com.moor.imkf.YKFConstants;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class f {
    public static final int a = -1;
    public static final int b = 0;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f10163c = 2;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final int f10164d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f10165e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f10166f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10167g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f10168h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static final int f10169i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f10170j = 10;

    /* renamed from: k  reason: collision with root package name */
    public static final int f10171k = 13;

    /* renamed from: l  reason: collision with root package name */
    public static final int f10172l = 14;

    /* renamed from: m  reason: collision with root package name */
    public static final int f10173m = 15;
    public static final int n = 16;
    public static final int o = 17;

    @NonNull
    public static String a(int i2) {
        switch (i2) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                StringBuilder sb = new StringBuilder(32);
                sb.append("unknown status code: ");
                sb.append(i2);
                return sb.toString();
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return bp.f1533l;
            case 14:
                return "INTERRUPTED";
            case 15:
                return YKFConstants.TIMEOUT;
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
        }
    }
}
