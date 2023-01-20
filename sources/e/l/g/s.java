package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ExpressData;

/* loaded from: classes2.dex */
public final class s extends e.t.k.a.c.a<ExpressData> {

    /* renamed from: d  reason: collision with root package name */
    private boolean f12050d;

    /* renamed from: e  reason: collision with root package name */
    private int f12051e;

    public s() {
        super(null, 1, null);
        this.f12050d = true;
        this.f12051e = 2;
    }

    @Override // e.t.k.a.c.f, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f12050d) {
            return this.f12051e;
        }
        return super.getItemCount();
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_express;
    }

    public final boolean v() {
        return this.f12050d;
    }

    public final int w() {
        return this.f12051e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@k.e.a.d ExpressData expressData, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, expressData);
    }

    public final void y(boolean z) {
        this.f12050d = z;
    }

    public final void z(int i2) {
        this.f12051e = i2;
    }
}
