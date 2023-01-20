package com.vector.design.ui.activity;

import android.content.Intent;
import com.vector.design.ui.decor.DecorView;
import e.t.k.b.a;
import e.t.l.a0;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0004J\u000f\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R \u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000@BX\u0086.¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/vector/design/ui/activity/ActivityEx;", "VM", "Lcom/vector/design/viewModel/ViewModelEx;", "Lcom/vector/design/ui/activity/SimpleActivityEx;", "()V", "<set-?>", "viewModel", "getViewModel", "()Lcom/vector/design/viewModel/ViewModelEx;", "Lcom/vector/design/viewModel/ViewModelEx;", "createDecorView", "Lcom/vector/design/ui/decor/DecorView;", "createViewModel", "initializeFlow", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ActivityEx<VM extends a> extends SimpleActivityEx {

    /* renamed from: k  reason: collision with root package name */
    private VM f7724k;

    @e
    public VM K() {
        return null;
    }

    @d
    public final VM L() {
        VM vm = this.f7724k;
        Objects.requireNonNull(vm);
        return vm;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void g() {
        f();
        j();
        L().l0();
        d();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        L().k0(i2, i3, intent);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public final DecorView r() {
        VM K = K();
        if (K == null) {
            K = (VM) a0.b(this);
        }
        this.f7724k = K;
        return super.r();
    }
}
