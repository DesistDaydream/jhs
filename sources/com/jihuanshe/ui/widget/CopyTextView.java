package com.jihuanshe.ui.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatTextView;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.CopyTextView;
import com.vector.util.Res;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CopyTextView extends AppCompatTextView {
    @e
    private CharSequence a;

    @h
    public CopyTextView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ CopyTextView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static final boolean e(CopyTextView copyTextView, View view) {
        CharSequence text = copyTextView.getText();
        if (text == null || text.length() == 0) {
            return true;
        }
        copyTextView.setCacheText(copyTextView.getText());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(copyTextView.getText());
        spannableStringBuilder.setSpan(new BackgroundColorSpan(Res.k(R.color.common_color)), 0, copyTextView.getText().length(), 17);
        t1 t1Var = t1.a;
        copyTextView.setText(spannableStringBuilder);
        CopyPopupWindow copyPopupWindow = new CopyPopupWindow(view.getContext(), new CopyTextView$1$2(copyTextView));
        copyPopupWindow.setOutsideTouchable(true);
        copyPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: e.l.q.c.g
            {
                CopyTextView.this = copyTextView;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                CopyTextView.h(CopyTextView.this);
            }
        });
        int measuredWidth = copyTextView.getMeasuredWidth();
        d.a aVar = e.t.o.d.a;
        copyPopupWindow.showAsDropDown(view, Math.max((measuredWidth - d.a.c(aVar, null, 1, null).d(63)) / 2, 0), -(copyTextView.getMeasuredHeight() + d.a.c(aVar, null, 1, null).d(52)));
        return true;
    }

    public static final void h(CopyTextView copyTextView) {
        copyTextView.setText(copyTextView.getCacheText());
    }

    @e
    public final CharSequence getCacheText() {
        return this.a;
    }

    public final void setCacheText(@e CharSequence charSequence) {
        this.a = charSequence;
    }

    @h
    public CopyTextView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: e.l.q.c.f
            {
                CopyTextView.this = this;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean e2;
                e2 = CopyTextView.e(CopyTextView.this, view);
                return e2;
            }
        });
    }
}
