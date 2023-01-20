package e.l.h.f;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J4\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/jihuanshe/base/ext/ExpandImageSpan;", "Lcom/jihuanshe/base/ext/AlignImageSpan;", "context", "Landroid/content/Context;", "drawableRes", "", "blank", "(Landroid/content/Context;ILjava/lang/Integer;)V", "getBlank", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "transX", "getTransX", "()I", "setTransX", "(I)V", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END, "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class c extends e.l.h.f.a {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final a f12097d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final int f12098e = 2;
    @k.e.a.e
    private final Integer b;

    /* renamed from: c  reason: collision with root package name */
    private int f12099c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/jihuanshe/base/ext/ExpandImageSpan$Companion;", "", "()V", "DRAW_RIGHT_PADDING", "", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public /* synthetic */ c(Context context, int i2, Integer num, int i3, u uVar) {
        this(context, i2, (i3 & 4) != 0 ? null : num);
    }

    @Override // e.l.h.f.a
    public int a() {
        return this.f12099c;
    }

    @Override // e.l.h.f.a
    public void b(int i2) {
        this.f12099c = i2;
    }

    @k.e.a.e
    public final Integer c() {
        return this.b;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@k.e.a.d Paint paint, @k.e.a.e CharSequence charSequence, int i2, int i3, @k.e.a.e Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        Integer num = this.b;
        return bounds.width() + ((num == null ? 2 : num.intValue()) * 2);
    }

    public c(@k.e.a.d Context context, int i2, @k.e.a.e Integer num) {
        super(context, i2);
        this.b = num;
        this.f12099c = num == null ? 2 : num.intValue();
    }
}
