package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.ic;

/* loaded from: classes3.dex */
public class t {
    public static <T extends ic<T, ?>> void a(Context context, com.xiaomi.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", aVar.c());
        intent.putExtra("action_cr_event_frequency", aVar.f());
        intent.putExtra("action_cr_perf_switch", aVar.d());
        intent.putExtra("action_cr_perf_frequency", aVar.g());
        intent.putExtra("action_cr_event_en", aVar.b());
        intent.putExtra("action_cr_max_file_size", aVar.e());
        ao.a(context).m66a(intent);
    }
}
