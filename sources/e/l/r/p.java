package e.l.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;

/* loaded from: classes2.dex */
public final class p implements TextWatcher {
    @k.e.a.d
    private final String a = "SpaceText";
    @k.e.a.d
    private final EditText b;

    /* renamed from: c  reason: collision with root package name */
    private int f14294c;

    /* renamed from: d  reason: collision with root package name */
    private int f14295d;

    public p(@k.e.a.d EditText editText) {
        this.b = editText;
    }

    public final int a() {
        return this.f14294c;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@k.e.a.e Editable editable) {
        String obj = this.b.getText().toString();
        e.l.h.k.b bVar = e.l.h.k.b.a;
        String str = this.a;
        bVar.a(str, "mEditText = " + c(obj) + '.');
        this.f14295d = obj.length();
        String str2 = this.a;
        bVar.a(str2, "beforeLen = " + this.f14294c + "afterLen = " + this.f14295d);
        if (this.f14295d > this.f14294c) {
            if (obj.length() == 5 || obj.length() == 10 || obj.length() == 15 || obj.length() == 20) {
                this.b.setText(new StringBuffer(obj).insert(obj.length() - 1, ExpandableTextView.N).toString());
                EditText editText = this.b;
                editText.setSelection(editText.getText().length());
                bVar.a(this.a, h.k2.v.f0.C("selection = ", Integer.valueOf(this.b.getText().length())));
            }
        } else if (h.t2.u.u2(obj, ExpandableTextView.N, false, 2, null)) {
            EditText editText2 = this.b;
            StringBuffer stringBuffer = new StringBuffer(obj);
            int i2 = this.f14295d;
            editText2.setText(stringBuffer.delete(i2 - 1, i2).toString());
            EditText editText3 = this.b;
            editText3.setSelection(editText3.getText().length());
            bVar.a(this.a, "else start space");
        }
    }

    public final int b() {
        return this.f14295d;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@k.e.a.d CharSequence charSequence, int i2, int i3, int i4) {
        this.f14294c = charSequence.length();
    }

    @k.e.a.d
    public final String c(@k.e.a.d String str) {
        return h.t2.u.k2(str, ExpandableTextView.N, "", false, 4, null);
    }

    public final void d(int i2) {
        this.f14294c = i2;
    }

    public final void e(int i2) {
        this.f14295d = i2;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@k.e.a.e CharSequence charSequence, int i2, int i3, int i4) {
    }
}
