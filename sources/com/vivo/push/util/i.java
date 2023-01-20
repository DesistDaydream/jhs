package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public final class i implements BaseNotifyLayoutAdapter {
    private Resources a;
    private String b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.a.getIdentifier("push_notify", "layout", this.b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (j.f8164c) {
            resources = this.a;
            str = this.b;
            str2 = "notify_icon_rom30";
        } else if (j.b) {
            resources = this.a;
            str = this.b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.a;
            str = this.b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i2;
        try {
            i2 = ((Integer) z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 > 0) {
            return this.a.getColor(i2);
        }
        boolean z = j.f8164c;
        if (z) {
            return -1;
        }
        if (j.b) {
            if (z) {
                return Color.parseColor("#ff999999");
            }
            return -1;
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.b = context.getPackageName();
        this.a = context.getResources();
    }
}
