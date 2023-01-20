package com.xiaomi.push;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* loaded from: classes3.dex */
public class du extends dx {

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f8458e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f8459f;

    /* renamed from: g  reason: collision with root package name */
    private int f8460g;

    public du(Context context, String str) {
        super(context, str);
        this.f8460g = 16777216;
    }

    public du a(Bitmap bitmap) {
        if (h() && bitmap != null) {
            if (bitmap.getWidth() != 984 || 184 > bitmap.getHeight() || bitmap.getHeight() > 1678) {
                com.xiaomi.a.a.a.c.a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
            } else {
                this.f8458e = bitmap;
            }
        }
        return this;
    }

    public du a(String str) {
        if (h() && !TextUtils.isEmpty(str)) {
            try {
                this.f8460g = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.a.a.a.c.a("parse banner notification image text color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    public String a() {
        return "notification_banner";
    }

    public du b(Bitmap bitmap) {
        if (h() && bitmap != null) {
            this.f8459f = bitmap;
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.dx, android.app.Notification.Builder
    /* renamed from: c */
    public dx setLargeIcon(Bitmap bitmap) {
        return this;
    }

    @Override // com.xiaomi.push.dx
    public boolean c() {
        if (jc.a()) {
            Resources resources = e().getResources();
            String packageName = e().getPackageName();
            return (a(e().getResources(), "bg", "id", e().getPackageName()) == 0 || a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || jc.b(e()) < 9) ? false : true;
        }
        return false;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    public void d() {
        RemoteViews g2;
        Bitmap bitmap;
        if (!h() || this.f8458e == null) {
            f();
            return;
        }
        super.d();
        Resources resources = e().getResources();
        String packageName = e().getPackageName();
        int a = a(resources, "bg", "id", packageName);
        if (jc.b(e()) >= 10) {
            g2 = g();
            bitmap = a(this.f8458e, 30.0f);
        } else {
            g2 = g();
            bitmap = this.f8458e;
        }
        g2.setImageViewBitmap(a, bitmap);
        int a2 = a(resources, "icon", "id", packageName);
        if (this.f8459f != null) {
            g().setImageViewBitmap(a2, this.f8459f);
        } else {
            a(a2);
        }
        int a3 = a(resources, "title", "id", packageName);
        g().setTextViewText(a3, this.b);
        Map<String, String> map = this.f8468d;
        if (map != null && this.f8460g == 16777216) {
            a(map.get("notification_image_text_color"));
        }
        RemoteViews g3 = g();
        int i2 = this.f8460g;
        g3.setTextColor(a3, (i2 == 16777216 || !b(i2)) ? -1 : ViewCompat.MEASURED_STATE_MASK);
        setCustomContentView(g());
        Bundle bundle = new Bundle();
        bundle.putBoolean("miui.customHeight", true);
        addExtras(bundle);
    }
}
