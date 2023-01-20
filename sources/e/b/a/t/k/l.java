package e.b.a.t.k;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* loaded from: classes.dex */
public class l extends e<Bitmap> {
    private final RemoteViews a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9916c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9917d;

    /* renamed from: e  reason: collision with root package name */
    private final Notification f9918e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9919f;

    public l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3) {
        this(context, i2, remoteViews, notification, i3, null);
    }

    private void a(@Nullable Bitmap bitmap) {
        this.a.setImageViewBitmap(this.f9919f, bitmap);
        update();
    }

    private void update() {
        ((NotificationManager) e.b.a.v.l.d((NotificationManager) this.b.getSystemService(RemoteMessageConst.NOTIFICATION))).notify(this.f9917d, this.f9916c, this.f9918e);
    }

    @Override // e.b.a.t.k.p
    public void onLoadCleared(@Nullable Drawable drawable) {
        a(null);
    }

    @Override // e.b.a.t.k.p
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable e.b.a.t.l.f fVar) {
        onResourceReady((Bitmap) obj, (e.b.a.t.l.f<? super Bitmap>) fVar);
    }

    public l(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, notification, i3, str);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable e.b.a.t.l.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    public l(Context context, int i2, int i3, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        super(i2, i3);
        this.b = (Context) e.b.a.v.l.e(context, "Context must not be null!");
        this.f9918e = (Notification) e.b.a.v.l.e(notification, "Notification object can not be null!");
        this.a = (RemoteViews) e.b.a.v.l.e(remoteViews, "RemoteViews object can not be null!");
        this.f9919f = i4;
        this.f9916c = i5;
        this.f9917d = str;
    }
}
