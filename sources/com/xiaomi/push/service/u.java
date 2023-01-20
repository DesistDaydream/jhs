package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.dv;
import com.xiaomi.push.hn;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class u {
    public abstract void a(hn hnVar, Map<String, String> map, int i2, Notification notification);

    public abstract void a(String str);

    public abstract boolean a(Context context, int i2, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i2, Notification notification);

    public abstract dv b(Context context, int i2, String str, Map<String, String> map);
}
