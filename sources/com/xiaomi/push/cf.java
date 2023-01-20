package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class cf {
    public static int a(Context context, int i2) {
        int b = gi.b(context);
        if (-1 == b) {
            return -1;
        }
        return (i2 * (b == 0 ? 13 : 11)) / 10;
    }

    public static int a(gq gqVar) {
        return ds.b(gqVar.a());
    }

    public static int a(ic icVar, gq gqVar) {
        int b;
        switch (cg.a[gqVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return ds.b(gqVar.a());
            case 11:
                b = ds.b(gqVar.a());
                if (icVar != null) {
                    try {
                        if (icVar instanceof hi) {
                            String str = ((hi) icVar).f8818e;
                            if (!TextUtils.isEmpty(str) && ds.a(ds.b(str)) != -1) {
                                b = ds.a(ds.b(str));
                                break;
                            }
                        } else if (icVar instanceof hq) {
                            String str2 = ((hq) icVar).f8866e;
                            if (!TextUtils.isEmpty(str2)) {
                                if (ds.a(ds.b(str2)) != -1) {
                                    b = ds.a(ds.b(str2));
                                }
                                if (ha.UploadTinyData.equals(ds.b(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        com.xiaomi.a.a.a.c.d("PERF_ERROR : parse Notification type error");
                        return b;
                    }
                }
                break;
            case 12:
                b = ds.b(gqVar.a());
                if (icVar != null) {
                    try {
                        if (icVar instanceof hm) {
                            String e2 = ((hm) icVar).e();
                            if (!TextUtils.isEmpty(e2) && ec.a(e2) != -1) {
                                b = ec.a(e2);
                                break;
                            }
                        } else if (icVar instanceof hl) {
                            String d2 = ((hl) icVar).d();
                            if (!TextUtils.isEmpty(d2) && ec.a(d2) != -1) {
                                return ec.a(d2);
                            }
                        }
                    } catch (Exception unused2) {
                        com.xiaomi.a.a.a.c.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return b;
    }

    public static void a(String str, Context context, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        int a = a(context, i3);
        if (i2 != ds.a(ha.UploadTinyData)) {
            dt.a(context.getApplicationContext()).a(str, i2, 1L, a);
        }
    }

    public static void a(String str, Context context, hn hnVar, int i2) {
        gq a;
        if (context == null || hnVar == null || (a = hnVar.a()) == null) {
            return;
        }
        int a2 = a(a);
        if (i2 <= 0) {
            byte[] a3 = ib.a(hnVar);
            i2 = a3 != null ? a3.length : 0;
        }
        a(str, context, a2, i2);
    }

    public static void a(String str, Context context, ic icVar, gq gqVar, int i2) {
        a(str, context, a(icVar, gqVar), i2);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        hn hnVar = new hn();
        try {
            ib.a(hnVar, bArr);
            a(str, context, hnVar, bArr.length);
        } catch (ih unused) {
            com.xiaomi.a.a.a.c.a("fail to convert bytes to container");
        }
    }
}
