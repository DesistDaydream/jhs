package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import h.k2.u.a;
import h.p2.d;
import h.w;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B1\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00028\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lh/w;", "", "isInitialized", "()Z", "getValue", "()Landroidx/lifecycle/ViewModel;", "value", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "Lh/k2/u/a;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "cached", "Landroidx/lifecycle/ViewModel;", "Lh/p2/d;", "viewModelClass", "Lh/p2/d;", "<init>", "(Lh/p2/d;Lh/k2/u/a;Lh/k2/u/a;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements w<VM> {
    private VM cached;
    private final a<ViewModelProvider.Factory> factoryProducer;
    private final a<ViewModelStore> storeProducer;
    private final d<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@k.e.a.d d<VM> dVar, @k.e.a.d a<? extends ViewModelStore> aVar, @k.e.a.d a<? extends ViewModelProvider.Factory> aVar2) {
        this.viewModelClass = dVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
    }

    @Override // h.w
    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // h.w
    @k.e.a.d
    public VM getValue() {
        VM vm = this.cached;
        if (vm == null) {
            VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(h.k2.a.c(this.viewModelClass));
            this.cached = vm2;
            return vm2;
        }
        return vm;
    }
}
