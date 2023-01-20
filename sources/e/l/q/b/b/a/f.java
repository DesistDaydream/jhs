package e.l.q.b.b.a;

import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.NumberView;
import h.r0;
import kotlin.Result;

/* loaded from: classes2.dex */
public final class f implements d {
    @k.e.a.e
    private View a;
    @k.e.a.d
    private NumberView b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private EditText f14146c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private EditText f14147d;

    /* renamed from: e  reason: collision with root package name */
    private int f14148e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private String f14149f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private final e.l.r.u0.b.a f14150g = new e.l.r.u0.b.a(-1, 2, false, 4, null);

    public f(@k.e.a.d View view, int i2, @k.e.a.d String str) {
        this.a = view;
        this.b = (NumberView) view.findViewById(R.id.numberView);
        EditText editText = (EditText) view.findViewById(R.id.priceInputEt);
        this.f14146c = editText;
        editText.setFilters(new e.l.r.u0.a.a[]{new e.l.r.u0.a.a()});
        this.f14147d = (EditText) view.findViewById(R.id.descEt);
        this.f14148e = i2;
        this.f14149f = str;
    }

    @Override // e.l.q.b.b.a.d
    public int a(boolean z) {
        if (z) {
            return Math.max(this.f14148e, 1);
        }
        return this.b.getValue();
    }

    @Override // e.l.q.b.b.a.d
    @k.e.a.d
    public TextWatcher b() {
        return this.f14150g;
    }

    @Override // e.l.q.b.b.a.d
    @k.e.a.e
    public Float c(boolean z) {
        try {
            Result.a aVar = Result.Companion;
            return Float.valueOf(Float.parseFloat(this.f14146c.getText().toString()));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return null;
        }
    }

    @Override // e.l.q.b.b.a.d
    @k.e.a.d
    public String d(boolean z) {
        if (z) {
            return this.f14149f;
        }
        return this.f14147d.getText().toString();
    }

    @Override // e.l.q.b.b.a.d
    public int e() {
        return Integer.MAX_VALUE;
    }
}
