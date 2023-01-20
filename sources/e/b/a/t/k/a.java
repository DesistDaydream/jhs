package e.b.a.t.k;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class a extends e<Bitmap> {
    private final int[] a;
    private final ComponentName b;

    /* renamed from: c  reason: collision with root package name */
    private final RemoteViews f9898c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f9899d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9900e;

    public a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, int... iArr) {
        super(i2, i3);
        if (iArr.length != 0) {
            this.f9899d = (Context) e.b.a.v.l.e(context, "Context can not be null!");
            this.f9898c = (RemoteViews) e.b.a.v.l.e(remoteViews, "RemoteViews object can not be null!");
            this.a = (int[]) e.b.a.v.l.e(iArr, "WidgetIds can not be null!");
            this.f9900e = i4;
            this.b = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void a(@Nullable Bitmap bitmap) {
        this.f9898c.setImageViewBitmap(this.f9900e, bitmap);
        update();
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f9899d);
        ComponentName componentName = this.b;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f9898c);
        } else {
            appWidgetManager.updateAppWidget(this.a, this.f9898c);
        }
    }

    @Override // e.b.a.t.k.p
    public void onLoadCleared(@Nullable Drawable drawable) {
        a(null);
    }

    @Override // e.b.a.t.k.p
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable e.b.a.t.l.f fVar) {
        onResourceReady((Bitmap) obj, (e.b.a.t.l.f<? super Bitmap>) fVar);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable e.b.a.t.l.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    public a(Context context, int i2, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, iArr);
    }

    public a(Context context, int i2, int i3, int i4, RemoteViews remoteViews, ComponentName componentName) {
        super(i2, i3);
        this.f9899d = (Context) e.b.a.v.l.e(context, "Context can not be null!");
        this.f9898c = (RemoteViews) e.b.a.v.l.e(remoteViews, "RemoteViews object can not be null!");
        this.b = (ComponentName) e.b.a.v.l.e(componentName, "ComponentName can not be null!");
        this.f9900e = i4;
        this.a = null;
    }

    public a(Context context, int i2, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, componentName);
    }
}
