package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.NumberView;
import com.vector.util.Res;
import e.l.r.u0.a.c;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;
import h.r0;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

/* loaded from: classes2.dex */
public final class NumberView extends LinearLayout {
    private int a;
    private int b;

    /* renamed from: c */
    private ImageView f4161c;

    /* renamed from: d */
    private ImageView f4162d;

    /* renamed from: e */
    private EditText f4163e;
    @d

    /* renamed from: f */
    private c f4164f;
    @e

    /* renamed from: g */
    private a f4165g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i2);

        void b(int i2);
    }

    /* loaded from: classes2.dex */
    public static final class b implements TextWatcher {
        public b() {
            NumberView.this = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@e Editable editable) {
            int i2 = 0;
            try {
                Result.a aVar = Result.Companion;
                i2 = Integer.parseInt(String.valueOf(editable));
                Result.m106constructorimpl(t1.a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                Result.m106constructorimpl(r0.a(th));
            }
            if (NumberView.this.b != i2) {
                NumberView.this.b = i2;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @h
    public NumberView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ NumberView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final void c(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.svg_minus);
        imageView.setImageTintList(ColorStateList.valueOf(Res.k(R.color.black_99999a)));
        d.a aVar = e.t.o.d.a;
        imageView.setPadding(d.a.c(aVar, null, 1, null).d(5), d.a.c(aVar, null, 1, null).d(2), d.a.c(aVar, null, 1, null).d(10), d.a.c(aVar, null, 1, null).d(2));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumberView.f(NumberView.this, view);
            }
        });
        t1 t1Var = t1.a;
        this.f4161c = imageView;
        Objects.requireNonNull(imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(imageView, layoutParams);
        EditText editText = new EditText(context);
        editText.setTextSize(2, 12.0f);
        editText.setTextColor(Res.k(R.color.black_333333));
        editText.setBackground(new ColorDrawable());
        editText.setGravity(17);
        editText.setInputType(2);
        editText.setPadding(0, 0, 0, 0);
        editText.setMinimumWidth(d.a.c(aVar, null, 1, null).d(10));
        this.f4163e = editText;
        Objects.requireNonNull(editText);
        editText.setImeOptions(6);
        EditText editText2 = this.f4163e;
        Objects.requireNonNull(editText2);
        editText2.setFilters(new InputFilter[]{new e.l.r.u0.a.b(), this.f4164f});
        EditText editText3 = this.f4163e;
        Objects.requireNonNull(editText3);
        editText3.addTextChangedListener(new b());
        View view = this.f4163e;
        Objects.requireNonNull(view);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        addView(view, layoutParams2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(R.drawable.svg_plus);
        imageView2.setImageTintList(ColorStateList.valueOf(Res.k(R.color.black_99999a)));
        imageView2.setPadding(d.a.c(aVar, null, 1, null).d(10), d.a.c(aVar, null, 1, null).d(2), d.a.c(aVar, null, 1, null).d(5), d.a.c(aVar, null, 1, null).d(2));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NumberView.g(NumberView.this, view2);
            }
        });
        this.f4162d = imageView2;
        Objects.requireNonNull(imageView2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        addView(imageView2, layoutParams3);
        h();
    }

    public static final void d(NumberView numberView, View view) {
        int i2 = numberView.b;
        if (i2 > 1) {
            a aVar = numberView.f4165g;
            if (aVar != null) {
                aVar.b(numberView.b);
                return;
            }
            numberView.b = i2 - 1;
            numberView.h();
        }
    }

    public static final void e(NumberView numberView, View view) {
        int i2 = numberView.b;
        if (i2 < numberView.a) {
            a aVar = numberView.f4165g;
            if (aVar != null) {
                aVar.a(numberView.b);
                return;
            }
            numberView.b = i2 + 1;
            numberView.h();
        }
    }

    public static /* synthetic */ void f(NumberView numberView, View view) {
        d(numberView, view);
    }

    public static /* synthetic */ void g(NumberView numberView, View view) {
        e(numberView, view);
    }

    private final void h() {
        String valueOf = String.valueOf(this.b);
        EditText editText = this.f4163e;
        Objects.requireNonNull(editText);
        editText.setText(valueOf);
        try {
            Result.a aVar = Result.Companion;
            EditText editText2 = this.f4163e;
            if (editText2 == null) {
                throw null;
            }
            if (editText2 != null) {
                editText2.setSelection(editText2.getText().length());
                Result.m106constructorimpl(t1.a);
                return;
            }
            throw null;
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }

    public final int getValue() {
        return this.b;
    }

    public final void setCurrentNumber(int i2) {
        this.b = Math.min(Math.max(i2, 1), this.a);
        h();
    }

    public final void setInputAble(boolean z) {
        EditText editText = this.f4163e;
        Objects.requireNonNull(editText);
        editText.setEnabled(z);
    }

    public final void setMaxCount(int i2) {
        int max = Math.max(i2, 1);
        this.a = max;
        this.f4164f.c(max);
    }

    public final void setOnChangeListener(@e a aVar) {
        this.f4165g = aVar;
    }

    @h
    public NumberView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1;
        this.b = 1;
        this.f4164f = new c();
        setOrientation(0);
        setBackgroundResource(R.drawable.bg_back_input);
        c(context);
    }
}
