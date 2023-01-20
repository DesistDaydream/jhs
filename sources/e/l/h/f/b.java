package e.l.h.f;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.qiniu.android.collect.ReportItem;
import com.vector.util.Res;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/jihuanshe/base/ext/ExpandClickableSpan;", "Landroid/text/style/ClickableSpan;", "color", "", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getColor", "()I", "onClick", "view", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class b extends ClickableSpan {
    private final int a;
    @k.e.a.d
    private final h.k2.u.a<t1> b;

    public b(@ColorInt int i2, @k.e.a.d h.k2.u.a<t1> aVar) {
        this.a = i2;
        this.b = aVar;
    }

    @k.e.a.d
    public final h.k2.u.a<t1> a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@k.e.a.d View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(Res.k(17170445));
        }
        this.b.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@k.e.a.d TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.a);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
