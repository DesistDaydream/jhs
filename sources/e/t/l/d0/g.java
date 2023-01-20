package e.t.l.d0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.vector.ext.DrawableKt;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a!\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000b\u001a:\u0010\u0010\u001a\u00020\b*\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u001a?\u0010\u0010\u001a\u00020\b*\u00020\t2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u00020\b*\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0005\u001a/\u0010\u0018\u001a\u00020\b*\u0004\u0018\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000b\u001a\n\u0010\u0019\u001a\u00020\b*\u00020\t\u001a\n\u0010\u001a\u001a\u00020\b*\u00020\t¨\u0006\u001b"}, d2 = {"getDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "id", "", "(Landroid/content/Context;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "afterTextChanged", "", "Landroid/widget/TextView;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "s", "drawable", "left", "top", "right", "bottom", "(Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "limitInputCount", "max", "onTextChanged", "resetFlag", "setUnderLine", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class g {

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/vector/ext/view/TextViewKt$afterTextChanged$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", MessageKey.MSG_ACCEPT_TIME_START, "", "count", "after", "onTextChanged", "before", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements TextWatcher {
        public final /* synthetic */ l<CharSequence, t1> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super CharSequence, t1> lVar) {
            this.a = lVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
            r2 = r2;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void afterTextChanged(@k.e.a.e android.text.Editable r2) {
            /*
                r1 = this;
                if (r2 != 0) goto L4
                java.lang.String r2 = ""
            L4:
                h.k2.u.l<java.lang.CharSequence, h.t1> r0 = r1.a
                r0.invoke(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.t.l.d0.g.a.afterTextChanged(android.text.Editable):void");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@k.e.a.e CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@k.e.a.e CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/vector/ext/view/TextViewKt$onTextChanged$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", MessageKey.MSG_ACCEPT_TIME_START, "", "count", "after", "onTextChanged", "before", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements TextWatcher {
        public final /* synthetic */ l<CharSequence, t1> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l<? super CharSequence, t1> lVar) {
            this.a = lVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@k.e.a.e Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@k.e.a.e CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@k.e.a.e CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence == null) {
                charSequence = "";
            }
            this.a.invoke(charSequence);
        }
    }

    public static final void a(@k.e.a.e TextView textView, @k.e.a.d l<? super CharSequence, t1> lVar) {
        if (textView == null) {
            return;
        }
        textView.addTextChangedListener(new a(lVar));
    }

    public static final void b(@k.e.a.d TextView textView, @k.e.a.e Drawable drawable, @k.e.a.e Drawable drawable2, @k.e.a.e Drawable drawable3, @k.e.a.e Drawable drawable4) {
        if (drawable != null) {
            DrawableKt.a(drawable);
        }
        if (drawable2 != null) {
            DrawableKt.a(drawable2);
        }
        if (drawable3 != null) {
            DrawableKt.a(drawable3);
        }
        if (drawable4 != null) {
            DrawableKt.a(drawable4);
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public static final void c(@k.e.a.d TextView textView, @DrawableRes @k.e.a.e Integer num, @DrawableRes @k.e.a.e Integer num2, @DrawableRes @k.e.a.e Integer num3, @DrawableRes @k.e.a.e Integer num4) {
        b(textView, f(textView.getContext(), num), f(textView.getContext(), num2), f(textView.getContext(), num3), f(textView.getContext(), num4));
    }

    public static /* synthetic */ void d(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            drawable = null;
        }
        if ((i2 & 2) != 0) {
            drawable2 = null;
        }
        if ((i2 & 4) != 0) {
            drawable3 = null;
        }
        if ((i2 & 8) != 0) {
            drawable4 = null;
        }
        b(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static /* synthetic */ void e(TextView textView, Integer num, Integer num2, Integer num3, Integer num4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = 0;
        }
        if ((i2 & 2) != 0) {
            num2 = 0;
        }
        if ((i2 & 4) != 0) {
            num3 = 0;
        }
        if ((i2 & 8) != 0) {
            num4 = 0;
        }
        c(textView, num, num2, num3, num4);
    }

    private static final Drawable f(Context context, Integer num) {
        if (num == null || num.intValue() == 0) {
            return null;
        }
        return Res.a.p(context, num.intValue());
    }

    public static final void g(@k.e.a.d TextView textView, int i2) {
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public static final void h(@k.e.a.e TextView textView, @k.e.a.d l<? super CharSequence, t1> lVar) {
        if (textView == null) {
            return;
        }
        textView.addTextChangedListener(new b(lVar));
    }

    public static final void i(@k.e.a.d TextView textView) {
        textView.getPaint().setFlags(256);
    }

    public static final void j(@k.e.a.d TextView textView) {
        textView.getPaint().setFlags(9);
    }
}
