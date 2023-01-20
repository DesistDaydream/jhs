package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.l;
import h.k2.v.c0;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a3\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001aG\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a)\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001aQ\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a=\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a=\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"withClip", "", "Landroid/graphics/Canvas;", "clipPath", "Landroid/graphics/Path;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(@d Canvas canvas, @d Rect rect, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withMatrix(@d Canvas canvas, @d Matrix matrix, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withRotation(@d Canvas canvas, float f2, float f3, float f4, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f2, float f3, float f4, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f2, f3, f4);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withSave(@d Canvas canvas, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withScale(@d Canvas canvas, float f2, float f3, float f4, float f5, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f2, float f3, float f4, float f5, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f5 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f2, f3, f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withSkew(@d Canvas canvas, float f2, float f3, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f2, float f3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withTranslation(@d Canvas canvas, float f2, float f3, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f2, float f3, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@d Canvas canvas, @d RectF rectF, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@d Canvas canvas, int i2, int i3, int i4, int i5, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.clipRect(i2, i3, i4, i5);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@d Canvas canvas, float f2, float f3, float f4, float f5, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.clipRect(f2, f3, f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }

    public static final void withClip(@d Canvas canvas, @d Path path, @d l<? super Canvas, t1> lVar) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            c0.d(1);
            canvas.restoreToCount(save);
            c0.c(1);
        }
    }
}
