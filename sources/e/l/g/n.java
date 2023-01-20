package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ChooseItem;
import com.jihuanshe.ui.dialog.ChooseDialogNew;

/* loaded from: classes2.dex */
public final class n extends e.t.k.a.c.a<ChooseItem> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final ChooseDialogNew f12038d;

    public n(@k.e.a.d ChooseDialogNew chooseDialogNew) {
        super(null, 1, null);
        this.f12038d = chooseDialogNew;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_choose_new;
    }

    @k.e.a.d
    public final ChooseDialogNew v() {
        return this.f12038d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d ChooseItem chooseItem, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, chooseItem);
    }
}
