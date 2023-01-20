package e.l.h.f;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.tencent.android.tpush.common.MessageKey;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\u0010\u000bJP\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H\u0016J2\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006'"}, d2 = {"Lcom/jihuanshe/base/ext/RoundBackgroundColorSpan;", "Landroid/text/style/ReplacementSpan;", "bgColor", "", "textColor", "textSize", "radius", "leftMargin", "rightMargin", "padding", "", "(IIIIIILjava/util/List;)V", "getBgColor", "()I", "getLeftMargin", "getPadding", "()Ljava/util/List;", "getRadius", "getRightMargin", "getTextColor", "getTextSize", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END, "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class d extends ReplacementSpan {
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12100c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12101d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12102e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12103f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private final List<Integer> f12104g;

    public d(int i2, int i3, int i4, int i5, int i6, int i7, @k.e.a.d List<Integer> list) {
        this.a = i2;
        this.b = i3;
        this.f12100c = i4;
        this.f12101d = i5;
        this.f12102e = i6;
        this.f12103f = i7;
        this.f12104g = list;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.f12102e;
    }

    @k.e.a.d
    public final List<Integer> c() {
        return this.f12104g;
    }

    public final int d() {
        return this.f12101d;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@k.e.a.d Canvas canvas, @k.e.a.d CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @k.e.a.d Paint paint) {
        paint.setColor(this.a);
        Rect rect = new Rect();
        paint.setTextSize(this.f12100c);
        paint.getTextBounds(charSequence.toString(), i2, i3, rect);
        float f3 = (i6 - i4) / 2.0f;
        RectF rectF = new RectF(f2 + this.f12102e, (f3 - (rect.height() / 2.0f)) - this.f12104g.get(1).floatValue(), f2 + ((int) paint.measureText(charSequence, i2, i3)) + this.f12102e + this.f12104g.get(0).intValue() + this.f12104g.get(2).intValue(), f3 + (rect.height() / 2.0f) + this.f12104g.get(3).floatValue());
        int i7 = this.f12101d;
        canvas.drawRoundRect(rectF, i7, i7, paint);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i8 = ((((fontMetricsInt.ascent + i5) + i5) + fontMetricsInt.descent) / 2) - ((i4 + i6) / 2);
        paint.setColor(this.b);
        canvas.drawText(charSequence, i2, i3, this.f12104g.get(0).floatValue() + f2 + this.f12102e, i5 - i8, paint);
    }

    public final int e() {
        return this.f12103f;
    }

    public final int f() {
        return this.b;
    }

    public final int g() {
        return this.f12100c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@k.e.a.d Paint paint, @k.e.a.d CharSequence charSequence, int i2, int i3, @k.e.a.e Paint.FontMetricsInt fontMetricsInt) {
        paint.setTextSize(this.f12100c);
        return ((int) paint.measureText(charSequence, i2, i3)) + this.f12104g.get(0).intValue() + this.f12104g.get(2).intValue() + this.f12102e + this.f12103f;
    }
}
