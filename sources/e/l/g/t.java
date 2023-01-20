package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ExpressData;

/* loaded from: classes2.dex */
public final class t extends e<ExpressData> {

    /* renamed from: c  reason: collision with root package name */
    private boolean f12053c = true;

    @Override // e.l.g.e
    public int b() {
        return R.layout.item_express;
    }

    @Override // e.l.g.e, android.widget.Adapter
    public int getCount() {
        if (this.f12053c) {
            return 2;
        }
        return super.getCount();
    }

    public final boolean h() {
        return this.f12053c;
    }

    @Override // e.l.g.e
    /* renamed from: i */
    public void d(@k.e.a.e ExpressData expressData, @k.e.a.e ViewDataBinding viewDataBinding) {
        if (viewDataBinding == null || expressData == null) {
            return;
        }
        viewDataBinding.setVariable(8, expressData);
    }

    public final void j(boolean z) {
        this.f12053c = z;
    }
}
