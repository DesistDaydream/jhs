package e.l.r.u0.b;

import android.text.Editable;
import android.text.TextWatcher;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class a implements TextWatcher {
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14318c;

    public a(int i2, int i3, boolean z) {
        this.a = i2;
        this.b = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(android.text.Editable r26) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.r.u0.b.a.a(android.text.Editable):void");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@d Editable editable) {
        a(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@e CharSequence charSequence, int i2, int i3, int i4) {
        this.f14318c = i2;
    }

    public /* synthetic */ a(int i2, int i3, boolean z, int i4, u uVar) {
        this(i2, i3, (i4 & 4) != 0 ? false : z);
    }
}
