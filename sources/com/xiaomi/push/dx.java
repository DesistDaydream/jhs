package com.xiaomi.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class dx extends dv {
    public Bitmap a;
    public CharSequence b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f8467c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f8468d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f8469e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8470f;

    /* renamed from: g  reason: collision with root package name */
    private int f8471g;

    /* renamed from: h  reason: collision with root package name */
    private String f8472h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8473i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Notification.Action> f8474j;

    /* renamed from: k  reason: collision with root package name */
    private int f8475k;

    public dx(Context context, int i2, String str) {
        super(context);
        this.f8474j = new ArrayList<>();
        this.f8475k = 0;
        this.f8472h = str;
        this.f8471g = i2;
        j();
    }

    public dx(Context context, String str) {
        this(context, 0, str);
    }

    private boolean i() {
        Map<String, String> map = this.f8468d;
        return map != null && Boolean.parseBoolean(map.get("custom_builder_set_title"));
    }

    private void j() {
        int a = a(e().getResources(), l(), "layout", e().getPackageName());
        if (a == 0) {
            com.xiaomi.a.a.a.c.a("create RemoteViews failed, no such layout resource was found");
            return;
        }
        this.f8469e = new RemoteViews(e().getPackageName(), a);
        this.f8470f = c();
    }

    private void k() {
        super.setContentTitle(this.b);
        super.setContentText(this.f8467c);
    }

    private String l() {
        boolean o = o();
        this.f8473i = o;
        return o ? b() : a();
    }

    private Bitmap m() {
        return com.xiaomi.push.service.n.a(gg.h(e(), this.f8472h));
    }

    private boolean n() {
        return (TextUtils.isEmpty(b()) || TextUtils.isEmpty(this.f8472h)) ? false : true;
    }

    private boolean o() {
        return n() && p();
    }

    private boolean p() {
        List<StatusBarNotification> e2;
        if (Build.VERSION.SDK_INT >= 20 && (e2 = com.xiaomi.push.service.z.a(e(), this.f8472h).e()) != null && !e2.isEmpty()) {
            for (StatusBarNotification statusBarNotification : e2) {
                if (statusBarNotification.getId() == this.f8471g) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification == null) {
                        return false;
                    }
                    return !notification.extras.getBoolean("mipush.customCopyLayout", true);
                }
            }
        }
        return false;
    }

    public int a(float f2) {
        return (int) ((f2 * e().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public Bitmap a(Bitmap bitmap, float f2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new RectF(rect), f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    @Override // com.xiaomi.push.dv
    public dv a(Map<String, String> map) {
        this.f8468d = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public dx addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
        addAction(new Notification.Action(i2, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public dx addAction(Notification.Action action) {
        if (action != null) {
            this.f8474j.add(action);
        }
        int i2 = this.f8475k;
        this.f8475k = i2 + 1;
        a(i2, action);
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public dx setContentTitle(CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    public abstract String a();

    public void a(int i2) {
        Bitmap m2 = m();
        if (m2 != null) {
            g().setImageViewBitmap(i2, m2);
            return;
        }
        int g2 = gg.g(e(), this.f8472h);
        if (g2 != 0) {
            g().setImageViewResource(i2, g2);
        }
    }

    public void a(int i2, Notification.Action action) {
    }

    @Override // android.app.Notification.Builder
    /* renamed from: b */
    public dx setContentText(CharSequence charSequence) {
        this.f8467c = charSequence;
        return this;
    }

    public abstract String b();

    public final boolean b(int i2) {
        return ((((double) Color.red(i2)) * 0.299d) + (((double) Color.green(i2)) * 0.587d)) + (((double) Color.blue(i2)) * 0.114d) < 192.0d;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: c */
    public dx setLargeIcon(Bitmap bitmap) {
        this.a = bitmap;
        return this;
    }

    public abstract boolean c();

    @Override // com.xiaomi.push.dv
    public void d() {
        super.d();
        Bundle bundle = new Bundle();
        if (n()) {
            bundle.putBoolean("mipush.customCopyLayout", this.f8473i);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", b("large_icon"));
        if (this.f8474j.size() > 0) {
            Notification.Action[] actionArr = new Notification.Action[this.f8474j.size()];
            this.f8474j.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        if (i() || !com.xiaomi.push.service.aa.b(e().getContentResolver())) {
            k();
        } else {
            bundle.putCharSequence("mipush.customTitle", this.b);
            bundle.putCharSequence("mipush.customContent", this.f8467c);
        }
        addExtras(bundle);
    }

    public final void f() {
        super.setContentTitle(this.b);
        super.setContentText(this.f8467c);
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    public final RemoteViews g() {
        return this.f8469e;
    }

    public final boolean h() {
        return this.f8470f;
    }
}
