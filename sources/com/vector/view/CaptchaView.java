package com.vector.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import i.b.b1;
import i.b.g2;
import i.b.i;
import i.b.n0;
import i.b.o0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001#B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001d\u001a\u00020\u00192\b\b\u0001\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000bJ\u0010\u0010 \u001a\u00020\u00192\b\b\u0001\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0019R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/vector/view/CaptchaView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxCount", "resendText", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "second", "secondText", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "getSecondText", "()Lkotlin/jvm/functions/Function1;", "setSecondText", "(Lkotlin/jvm/functions/Function1;)V", "dispose", "", "onDetachedFromWindow", "setMaxCount", "count", "setResendText", "resId", "text", "setSymbol", "id", MessageKey.MSG_ACCEPT_TIME_START, "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CaptchaView extends AppCompatTextView {
    @d

    /* renamed from: f  reason: collision with root package name */
    public static final a f7920f = new a(null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final String f7921g = "Resend";
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final String f7922h = "s";

    /* renamed from: i  reason: collision with root package name */
    private static final int f7923i = 60;
    @d
    private String a;
    @d
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f7924c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private n0 f7925d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private l<? super Long, String> f7926e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vector/view/CaptchaView$Companion;", "", "()V", "MAX_COUNT", "", "RESEND_TEXT", "", "SECOND", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @h
    public CaptchaView(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public CaptchaView(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CaptchaView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void h() {
        CoroutineContext coroutineContext;
        n0 n0Var = this.f7925d;
        if (n0Var != null && (coroutineContext = n0Var.getCoroutineContext()) != null) {
            g2.j(coroutineContext, null, 1, null);
        }
        this.f7925d = null;
    }

    @d
    public final l<Long, String> getSecondText() {
        return this.f7926e;
    }

    public final void i() {
        h();
        n0 a2 = o0.a(b1.e());
        this.f7925d = a2;
        if (a2 == null) {
            return;
        }
        i.f(a2, null, null, new CaptchaView$start$1(this, null), 3, null);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public final void setMaxCount(int i2) {
        this.f7924c = i2;
    }

    public final void setResendText(@d String str) {
        this.a = str;
    }

    public final void setSecondText(@d l<? super Long, String> lVar) {
        this.f7926e = lVar;
    }

    public final void setSymbol(@StringRes int i2) {
        this.b = getContext().getString(i2);
    }

    @h
    public CaptchaView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = f7921g;
        this.b = "s";
        this.f7924c = 60;
        this.f7926e = new CaptchaView$secondText$1(this);
    }

    public final void setResendText(@StringRes int i2) {
        this.a = getContext().getString(i2);
    }
}
