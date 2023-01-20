package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.qiniu.android.collect.ReportItem;
import h.k2.u.l;
import h.k2.v.c0;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"record", "Landroid/graphics/Picture;", "width", "", "height", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PictureKt {
    @d
    public static final Picture record(@d Picture picture, int i2, int i3, @d l<? super Canvas, t1> lVar) {
        Canvas beginRecording = picture.beginRecording(i2, i3);
        try {
            lVar.invoke(beginRecording);
            return picture;
        } finally {
            c0.d(1);
            picture.endRecording();
            c0.c(1);
        }
    }
}
