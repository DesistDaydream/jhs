package com.xiaomi.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* loaded from: classes3.dex */
public class dw extends dx {

    /* renamed from: e  reason: collision with root package name */
    private int f8461e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f8462f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f8463g;

    /* renamed from: h  reason: collision with root package name */
    private PendingIntent f8464h;

    /* renamed from: i  reason: collision with root package name */
    private int f8465i;

    /* renamed from: j  reason: collision with root package name */
    private int f8466j;

    public dw(Context context, int i2, String str) {
        super(context, i2, str);
        this.f8461e = 16777216;
        this.f8465i = 16777216;
        this.f8466j = 16777216;
    }

    private Drawable a(int i2, int i3, int i4, float f2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.setIntrinsicWidth(i3);
        shapeDrawable.setIntrinsicHeight(i4);
        return shapeDrawable;
    }

    private void a(RemoteViews remoteViews, int i2, int i3, int i4, boolean z) {
        int a = a(6.0f);
        remoteViews.setViewPadding(i2, a, 0, a, 0);
        int i5 = z ? -1 : ViewCompat.MEASURED_STATE_MASK;
        remoteViews.setTextColor(i3, i5);
        remoteViews.setTextColor(i4, i5);
    }

    public dw a(Bitmap bitmap) {
        if (h() && bitmap != null) {
            if (bitmap.getWidth() != 984 || bitmap.getHeight() < 177 || bitmap.getHeight() > 207) {
                com.xiaomi.a.a.a.c.a("colorful notification bg image resolution error, must [984*177, 984*207]");
            } else {
                this.f8462f = bitmap;
            }
        }
        return this;
    }

    public dw a(CharSequence charSequence, PendingIntent pendingIntent) {
        if (h()) {
            super.addAction(0, charSequence, pendingIntent);
            this.f8463g = charSequence;
            this.f8464h = pendingIntent;
        }
        return this;
    }

    public dw a(String str) {
        if (h() && !TextUtils.isEmpty(str)) {
            try {
                this.f8465i = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.a.a.a.c.a("parse colorful notification button bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx
    public String a() {
        return "notification_colorful";
    }

    @Override // com.xiaomi.push.dx
    public String b() {
        return "notification_colorful_copy";
    }

    @Override // com.xiaomi.push.dx
    public boolean c() {
        if (jc.a()) {
            Resources resources = e().getResources();
            String packageName = e().getPackageName();
            return (a(resources, "icon", "id", packageName) == 0 || a(resources, "title", "id", packageName) == 0 || a(resources, "content", "id", packageName) == 0) ? false : true;
        }
        return false;
    }

    public dw d(String str) {
        if (h() && !TextUtils.isEmpty(str)) {
            try {
                this.f8461e = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.a.a.a.c.a("parse colorful notification bg color error");
            }
        }
        return this;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.dv
    public void d() {
        RemoteViews g2;
        Bitmap bitmap;
        boolean z;
        RemoteViews g3;
        RemoteViews g4;
        Drawable a;
        if (!h()) {
            f();
            return;
        }
        super.d();
        Resources resources = e().getResources();
        String packageName = e().getPackageName();
        int a2 = a(resources, "icon", "id", packageName);
        if (((dx) this).a == null) {
            a(a2);
        } else {
            g().setImageViewBitmap(a2, ((dx) this).a);
        }
        int a3 = a(resources, "title", "id", packageName);
        int a4 = a(resources, "content", "id", packageName);
        g().setTextViewText(a3, this.b);
        g().setTextViewText(a4, this.f8467c);
        if (!TextUtils.isEmpty(this.f8463g)) {
            int a5 = a(resources, "buttonContainer", "id", packageName);
            int a6 = a(resources, "button", "id", packageName);
            int a7 = a(resources, "buttonBg", "id", packageName);
            g().setViewVisibility(a5, 0);
            g().setTextViewText(a6, this.f8463g);
            g().setOnClickPendingIntent(a5, this.f8464h);
            if (this.f8465i != 16777216) {
                int a8 = a(70.0f);
                int a9 = a(29.0f);
                g().setImageViewBitmap(a7, com.xiaomi.push.service.n.a(a(this.f8465i, a8, a9, a9 / 2.0f)));
                g().setTextColor(a6, b(this.f8465i) ? -1 : ViewCompat.MEASURED_STATE_MASK);
            }
        }
        int a10 = a(resources, "bg", "id", packageName);
        int a11 = a(resources, "container", "id", packageName);
        if (this.f8461e != 16777216) {
            if (jc.b(e()) >= 10) {
                g4 = g();
                a = a(this.f8461e, 984, 192, 30.0f);
            } else {
                g4 = g();
                a = a(this.f8461e, 984, 192, 0.0f);
            }
            g4.setImageViewBitmap(a10, com.xiaomi.push.service.n.a(a));
            g3 = g();
            z = b(this.f8461e);
        } else if (this.f8462f == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                g().setViewVisibility(a2, 8);
                g().setViewVisibility(a10, 8);
                try {
                    am.a((Object) this, "setStyle", jl.a(e(), "android.app.Notification$DecoratedCustomViewStyle").getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                    com.xiaomi.a.a.a.c.a("load class DecoratedCustomViewStyle failed");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("miui.customHeight", true);
            addExtras(bundle);
            setCustomContentView(g());
        } else {
            if (jc.b(e()) >= 10) {
                g2 = g();
                bitmap = a(this.f8462f, 30.0f);
            } else {
                g2 = g();
                bitmap = this.f8462f;
            }
            g2.setImageViewBitmap(a10, bitmap);
            Map<String, String> map = this.f8468d;
            if (map != null && this.f8466j == 16777216) {
                e(map.get("notification_image_text_color"));
            }
            int i2 = this.f8466j;
            z = i2 == 16777216 || !b(i2);
            g3 = g();
        }
        a(g3, a11, a3, a4, z);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("miui.customHeight", true);
        addExtras(bundle2);
        setCustomContentView(g());
    }

    public dw e(String str) {
        if (h() && !TextUtils.isEmpty(str)) {
            try {
                this.f8466j = Color.parseColor(str);
            } catch (Exception unused) {
                com.xiaomi.a.a.a.c.a("parse colorful notification image text color error");
            }
        }
        return this;
    }
}
