package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public class br {
    private static SimpleDateFormat a;
    private static String b;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        a = simpleDateFormat;
        b = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gu a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gu guVar = new gu();
        guVar.d("category_push_stat");
        guVar.a("push_sdk_stat_channel");
        guVar.a(1L);
        guVar.b(str);
        guVar.c(true);
        guVar.b(System.currentTimeMillis());
        guVar.g(az.a(context).a());
        guVar.e("com.xiaomi.xmsf");
        guVar.f("");
        guVar.c("push_stat");
        return guVar;
    }
}
