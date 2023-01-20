package com.vector.databinding.adapter;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.ReplacementTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.widget.TextViewCompat;
import androidx.databinding.BindingAdapter;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.vector.R;
import com.vector.util.Res;
import e.t.l.d0.g;
import e.t.l.w;
import h.k2.k;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007JE\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0001\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010 2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0007J\u001c\u0010)\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020 H\u0007J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020 H\u0007J\u0018\u0010/\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0007J\u0018\u00102\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u00103\u001a\u000204H\u0007J\u0018\u00105\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u00106\u001a\u00020 H\u0007J\u0018\u00107\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u0004H\u0007J\u001f\u00109\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010:\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\u0010;J\u001f\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u001a2\b\u0010>\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0002\u0010;J\u0018\u0010?\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020@H\u0007J\u0018\u0010A\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u0004H\u0007J\u001a\u0010C\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010D\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010E\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/vector/databinding/adapter/TextViewBinding;", "", "()V", "AFTER_TEXT_CHANGE", "", "BOLD", "DRAWABLE_BOTTOM_ID", "DRAWABLE_LEFT_ID", "DRAWABLE_RIGHT_ID", "DRAWABLE_TOP_ID", "FONT_TYPEFACE", "HTML_TEXT", "INPUT_FILTER", "INPUT_TYPE", "MAX_LINES", "MOVEMENT_METHOD", "TEXT_COLOR", "TEXT_IN_SBC", "TEXT_SIZE", "TINT", "TRANSFORMATION_METHOD", "TYPEFACE", "UNDER_LINE", "setBold", "", "textView", "Landroid/widget/TextView;", "isBold", "", "setDrawableId", "view", "drawableLeftId", "", "drawableTopId", "drawableRightId", "drawableBottomId", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setFilters", "editText", "inputFilter", "Landroid/text/InputFilter;", "setHtmlText", "textHtml", "setInputType", "type", "setMaxLines", "maxLines", "setMovementMethod", PushConstants.MZ_PUSH_MESSAGE_METHOD, "Landroid/text/method/MovementMethod;", "setTextChangeListener", "binding", "Lcom/vector/databinding/onBind/AfterTextChangedWithViewBinding;", "setTextColor", "color", "setTextInSBC", "text", "setTextSize", "size", "(Landroid/widget/TextView;Ljava/lang/Integer;)V", "setTint", "tv", "tint", "setTransformationMethod", "Lcom/vector/databinding/adapter/TransformationMethodType;", "setType", "familyName", "setTypeface", "path", "setUnderLine", "under", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TextViewBinding {
    @d
    public static final TextViewBinding a = new TextViewBinding();
    @d
    private static final String b = "android:textView_bold";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final String f7690c = "android:textView_textSize";
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f7691d = "android:textView_movementMethod";
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final String f7692e = "android:textView_transformationMethod";
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f7693f = "android:textView_drawableLeftId";
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final String f7694g = "android:textView_drawableTopId";
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final String f7695h = "android:textView_drawableRightId";
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final String f7696i = "android:textView_drawableBottomId";
    @d

    /* renamed from: j  reason: collision with root package name */
    private static final String f7697j = "android:textView_textInSBC";
    @d

    /* renamed from: k  reason: collision with root package name */
    private static final String f7698k = "android:textView_inputType";
    @d

    /* renamed from: l  reason: collision with root package name */
    private static final String f7699l = "android:textView_textColor";
    @d

    /* renamed from: m  reason: collision with root package name */
    private static final String f7700m = "android:textView_textHtml";
    @d
    private static final String n = "android:textView_maxLines";
    @d
    private static final String o = "android:textView_afterTextChange";
    @d
    private static final String p = "android:textView_inputFilter";
    @d
    private static final String q = "android:textView_typeface";
    @d
    private static final String r = "android:textView_fontTypeface";
    @d
    private static final String s = "android:textView_underLine";
    @d
    private static final String t = "android:textView_tint";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TransformationMethodType.values().length];
            iArr[TransformationMethodType.HIDE_RETURNS.ordinal()] = 1;
            iArr[TransformationMethodType.PASSWORD.ordinal()] = 2;
            iArr[TransformationMethodType.REPLACEMENT.ordinal()] = 3;
            iArr[TransformationMethodType.SINGLE_LINE.ordinal()] = 4;
            a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0014¨\u0006\u0005"}, d2 = {"com/vector/databinding/adapter/TextViewBinding$setTransformationMethod$method$1", "Landroid/text/method/ReplacementTransformationMethod;", "getOriginal", "", "getReplacement", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends ReplacementTransformationMethod {
        @Override // android.text.method.ReplacementTransformationMethod
        @d
        public char[] getOriginal() {
            return new char[0];
        }

        @Override // android.text.method.ReplacementTransformationMethod
        @d
        public char[] getReplacement() {
            return new char[0];
        }
    }

    private TextViewBinding() {
    }

    @BindingAdapter({b})
    @k
    public static final void a(@d TextView textView, boolean z) {
        Typeface defaultFromStyle;
        if (z) {
            defaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            defaultFromStyle = Typeface.defaultFromStyle(0);
        }
        textView.setTypeface(defaultFromStyle);
    }

    @BindingAdapter(requireAll = false, value = {f7693f, f7694g, f7695h, f7696i})
    @k
    public static final void b(@d TextView textView, @DrawableRes @e Integer num, @DrawableRes @e Integer num2, @DrawableRes @e Integer num3, @DrawableRes @e Integer num4) {
        g.c(textView, num, num2, num3, num4);
    }

    @BindingAdapter({p})
    @k
    public static final void c(@d TextView textView, @d InputFilter inputFilter) {
        textView.setFilters(new InputFilter[]{inputFilter});
    }

    @BindingAdapter({f7700m})
    @k
    public static final void d(@d TextView textView, @e String str) {
        Spanned fromHtml;
        if (str == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(str, 63);
        } else {
            fromHtml = Html.fromHtml(str);
        }
        textView.setText(fromHtml);
    }

    public static /* synthetic */ void e(TextView textView, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        d(textView, str);
    }

    @BindingAdapter({f7698k})
    @k
    public static final void f(@d TextView textView, int i2) {
        textView.setInputType(i2);
    }

    @BindingAdapter({n})
    @k
    public static final void g(@d TextView textView, int i2) {
        textView.setMaxLines(i2);
    }

    @BindingAdapter({f7691d})
    @k
    public static final void h(@d TextView textView, @d MovementMethod movementMethod) {
        textView.setMovementMethod(movementMethod);
    }

    @BindingAdapter({o})
    @k
    public static final void i(@d TextView textView, @d e.t.j.h.b bVar) {
        g.a(textView, new TextViewBinding$setTextChangeListener$1(bVar, textView));
    }

    @BindingAdapter({f7699l})
    @k
    public static final void j(@d TextView textView, int i2) {
        textView.setTextColor(i2);
    }

    @BindingAdapter({f7697j})
    @k
    public static final void k(@d TextView textView, @d String str) {
        textView.setText(w.y(str));
    }

    @BindingAdapter({f7690c})
    @k
    public static final void l(@d TextView textView, @e Integer num) {
        if (num == null) {
            return;
        }
        num.intValue();
        textView.setTextSize(num.intValue());
    }

    @BindingAdapter({t})
    @k
    public static final void m(@d TextView textView, @e Integer num) {
        TextViewCompat.setCompoundDrawableTintList(textView, num == null ? null : ColorStateList.valueOf(num.intValue()));
    }

    @BindingAdapter({f7692e})
    @k
    public static final void n(@d TextView textView, @d TransformationMethodType transformationMethodType) {
        TransformationMethod hideReturnsTransformationMethod;
        int i2 = a.a[transformationMethodType.ordinal()];
        if (i2 == 1) {
            hideReturnsTransformationMethod = HideReturnsTransformationMethod.getInstance();
        } else if (i2 == 2) {
            hideReturnsTransformationMethod = PasswordTransformationMethod.getInstance();
        } else if (i2 == 3) {
            hideReturnsTransformationMethod = new b();
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            hideReturnsTransformationMethod = SingleLineTransformationMethod.getInstance();
        }
        textView.setTransformationMethod(hideReturnsTransformationMethod);
    }

    @BindingAdapter({r})
    @k
    public static final void o(@d TextView textView, @d String str) {
        Typeface create;
        Res res = Res.a;
        if (f0.g(str, Res.w(res, R.string.font_medium, null, 2, null))) {
            create = Typeface.create(str, 0);
        } else {
            create = f0.g(str, Res.w(res, R.string.font_black, null, 2, null)) ? Typeface.create(str, 1) : Typeface.create(str, 0);
        }
        textView.setTypeface(create);
    }

    @BindingAdapter({q})
    @k
    public static final void p(@d TextView textView, @e String str) {
        if (str == null) {
            return;
        }
        textView.setTypeface(Typeface.createFromAsset(e.t.a.b().getAssets(), str));
    }

    @BindingAdapter({s})
    @k
    public static final void q(@d TextView textView, boolean z) {
        TextPaint paint = textView.getPaint();
        if (paint != null) {
            paint.setFlags(8);
        }
        textView.getPaint().setAntiAlias(true);
    }
}
