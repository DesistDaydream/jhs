package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class dv extends Notification.Builder {
    private Context a;

    public dv(Context context) {
        super(context);
        this.a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public dv addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public dv setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
        } else {
            super.setContent(remoteViews);
        }
        return this;
    }

    public dv a(Map<String, String> map) {
        return this;
    }

    public final int b(String str) {
        return a(e().getResources(), str, "id", e().getPackageName());
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        d();
        return super.build();
    }

    public dv c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                am.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.d("fail to set color. " + e2);
            }
        }
        return this;
    }

    public void d() {
    }

    public Context e() {
        return this.a;
    }
}
