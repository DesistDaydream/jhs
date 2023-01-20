package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class d0 {
    private static final String a = "TransformationUtils";
    public static final int b = 6;

    /* renamed from: d  reason: collision with root package name */
    private static final int f9744d = 7;

    /* renamed from: f  reason: collision with root package name */
    private static final Paint f9746f;

    /* renamed from: g  reason: collision with root package name */
    private static final Set<String> f9747g;

    /* renamed from: h  reason: collision with root package name */
    private static final Lock f9748h;

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f9743c = new Paint(6);

    /* renamed from: e  reason: collision with root package name */
    private static final Paint f9745e = new Paint(7);

    /* loaded from: classes.dex */
    public class a implements c {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        @Override // e.b.a.p.m.d.d0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            int i2 = this.a;
            canvas.drawRoundRect(rectF, i2, i2, paint);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f9749c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f9750d;

        public b(float f2, float f3, float f4, float f5) {
            this.a = f2;
            this.b = f3;
            this.f9749c = f4;
            this.f9750d = f5;
        }

        @Override // e.b.a.p.m.d.d0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f2 = this.a;
            float f3 = this.b;
            float f4 = this.f9749c;
            float f5 = this.f9750d;
            path.addRoundRect(rectF, new float[]{f2, f2, f3, f3, f4, f4, f5, f5}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    /* loaded from: classes.dex */
    public static final class d implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f9747g = hashSet;
        f9748h = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new d();
        Paint paint = new Paint(7);
        f9746f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private d0() {
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f9748h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f9743c);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f9748h.unlock();
            throw th;
        }
    }

    public static Bitmap b(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        float width;
        float height;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f2 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            width = i3 / bitmap.getHeight();
            f2 = (i2 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i2 / bitmap.getWidth();
            height = (i3 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f2 + 0.5f), (int) (height + 0.5f));
        Bitmap f3 = eVar.f(i2, i3, k(bitmap));
        t(bitmap, f3);
        a(bitmap, f3, matrix);
        return f3;
    }

    public static Bitmap c(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() <= i2 && bitmap.getHeight() <= i3) {
            if (Log.isLoggable(a, 2)) {
                Log.v(a, "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable(a, 2)) {
            Log.v(a, "requested target size too big for input, fit centering instead");
        }
        return f(eVar, bitmap, i2, i3);
    }

    public static Bitmap d(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        int min = Math.min(i2, i3);
        float f2 = min;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f2 / width, f2 / height);
        float f4 = width * max;
        float f5 = max * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap g2 = g(eVar, bitmap);
        Bitmap f8 = eVar.f(min, min, h(bitmap));
        f8.setHasAlpha(true);
        Lock lock = f9748h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f8);
            canvas.drawCircle(f3, f3, f3, f9745e);
            canvas.drawBitmap(g2, (Rect) null, rectF, f9746f);
            e(canvas);
            lock.unlock();
            if (!g2.equals(bitmap)) {
                eVar.d(g2);
            }
            return f8;
        } catch (Throwable th) {
            f9748h.unlock();
            throw th;
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable(a, 2)) {
                Log.v(a, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable(a, 2)) {
                Log.v(a, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap f2 = eVar.f((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), k(bitmap));
        t(bitmap, f2);
        if (Log.isLoggable(a, 2)) {
            Log.v(a, "request: " + i2 + "x" + i3);
            Log.v(a, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(a, "toReuse: " + f2.getWidth() + "x" + f2.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v(a, sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, f2, matrix);
        return f2;
    }

    private static Bitmap g(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap) {
        Bitmap.Config h2 = h(bitmap);
        if (h2.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap f2 = eVar.f(bitmap.getWidth(), bitmap.getHeight(), h2);
        new Canvas(f2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return f2;
    }

    @NonNull
    private static Bitmap.Config h(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return f9748h;
    }

    public static int j(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config k(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    public static void l(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean m(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(@NonNull Bitmap bitmap, int i2) {
        if (i2 != 0) {
            try {
                Matrix matrix = new Matrix();
                matrix.setRotate(i2);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e2) {
                if (Log.isLoggable(a, 6)) {
                    Log.e(a, "Exception when trying to orient image", e2);
                    return bitmap;
                }
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap o(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2) {
        if (m(i2)) {
            Matrix matrix = new Matrix();
            l(i2, matrix);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            matrix.mapRect(rectF);
            Bitmap f2 = eVar.f(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
            matrix.postTranslate(-rectF.left, -rectF.top);
            f2.setHasAlpha(bitmap.hasAlpha());
            a(bitmap, f2, matrix);
            return f2;
        }
        return bitmap;
    }

    public static Bitmap p(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, float f2, float f3, float f4, float f5) {
        return s(eVar, bitmap, new b(f2, f3, f4, f5));
    }

    public static Bitmap q(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2) {
        e.b.a.v.l.a(i2 > 0, "roundingRadius must be greater than 0.");
        return s(eVar, bitmap, new a(i2));
    }

    @Deprecated
    public static Bitmap r(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3, int i4) {
        return q(eVar, bitmap, i4);
    }

    private static Bitmap s(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, c cVar) {
        Bitmap.Config h2 = h(bitmap);
        Bitmap g2 = g(eVar, bitmap);
        Bitmap f2 = eVar.f(g2.getWidth(), g2.getHeight(), h2);
        f2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(g2, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, f2.getWidth(), f2.getHeight());
        Lock lock = f9748h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!g2.equals(bitmap)) {
                eVar.d(g2);
            }
            return f2;
        } catch (Throwable th) {
            f9748h.unlock();
            throw th;
        }
    }

    public static void t(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
