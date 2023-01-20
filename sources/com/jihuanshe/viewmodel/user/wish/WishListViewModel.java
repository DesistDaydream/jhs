package com.jihuanshe.viewmodel.user.wish;

import android.content.Context;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.util.Res;
import e.g.d.a;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import h.e2.c;
import h.k2.v.f0;
import h.t1;
import java.util.HashMap;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public class WishListViewModel extends b {
    @e

    /* renamed from: c  reason: collision with root package name */
    private Game f4592c;
    @d
    private final f b = new f();
    @d

    /* renamed from: d  reason: collision with root package name */
    private e.n.f<List<Product>> f4593d = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<Integer, a<?>> f4594e = new HashMap<>();

    public static /* synthetic */ a u0(WishListViewModel wishListViewModel, String str, String str2, LoadMore.State state, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                state = null;
            }
            return wishListViewModel.t0(str, str2, state);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWishItem");
    }

    @e
    public final Game q0() {
        return this.f4592c;
    }

    @d
    public final e.n.f<List<Product>> r0() {
        return this.f4593d;
    }

    @d
    public final f s0() {
        return this.b;
    }

    @d
    public final a<e.l.h.i.e<Product>> t0(@e String str, @e String str2, @e LoadMore.State state) {
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        Game game = this.f4592c;
        String gameKey = game == null ? null : game.getGameKey();
        Game game2 = this.f4592c;
        final Flow<e.l.h.i.e<Product>> B = kVar.B(str, gameKey, game2 == null ? null : game2.getGameSubKey(), str2, this.b.a(state).d());
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e.l.h.i.e<Product>>() { // from class: com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e.l.h.i.e<Product>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ WishListViewModel$getWishItem$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, WishListViewModel$getWishItem$$inlined$map$1 wishListViewModel$getWishItem$$inlined$map$1) {
                    this.a = fVar;
                    this.b = wishListViewModel$getWishItem$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.e<com.jihuanshe.model.Product> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L6b
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        e.l.h.i.e r8 = (e.l.h.i.e) r8
                        java.util.List r2 = r8.b()
                        if (r2 != 0) goto L3f
                        goto L62
                    L3f:
                        java.util.Iterator r2 = r2.iterator()
                    L43:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L62
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.Product r4 = (com.jihuanshe.model.Product) r4
                        r4.setInWishList(r3)
                        java.lang.String r5 = r4.getGameKey()
                        java.lang.String r6 = r4.getGameSubKey()
                        com.jihuanshe.model.Game r5 = e.l.l.a.b(r5, r6)
                        r4.setGame(r5)
                        goto L43
                    L62:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L6b
                        return r1
                    L6b:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.wish.WishListViewModel$getWishItem$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.e<Product>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), this.f4593d, this.b.f()), null, new WishListViewModel$getWishItem$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void v0(@d Context context, @d Product product, @d h.k2.u.a<t1> aVar) {
        if (product.getInWishList()) {
            UseDialog useDialog = new UseDialog(context);
            useDialog.setContent(Res.w(Res.a, R.string.desire_confirm_remove_list, null, 2, null));
            useDialog.setOnClickRightButton(new WishListViewModel$handleWish$1$1(this, product, aVar));
            useDialog.y();
            return;
        }
        HashMap<Integer, a<?>> hashMap = this.f4594e;
        Integer id = product.getId();
        a<?> aVar2 = hashMap.get(Integer.valueOf(id == null ? -1 : id.intValue()));
        if (aVar2 == null) {
            aVar2 = null;
        }
        a<?> aVar3 = aVar2;
        if (aVar3 != null) {
            aVar3.b();
        }
        product.setInWishList(true);
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        String type = product.getType();
        String type2 = product.getType();
        Constants.Companion companion = Constants.Companion;
        a<?> h2 = a.h(a.o(a.j(FlowKt.c(kVar.W(type, f0.g(type2, companion.getTYPE_CARD()) ? product.getId() : null, f0.g(product.getType(), companion.getTYPE_PACK()) ? product.getId() : null, product.getGameKey(), product.getGameSubKey())), null, new WishListViewModel$handleWish$b$1(this, product), 1, null), null, new WishListViewModel$handleWish$b$2(this, product), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        Integer id2 = product.getId();
        if (id2 != null) {
            this.f4594e.put(Integer.valueOf(id2.intValue()), h2);
        }
        aVar.invoke();
    }

    public final void w0(@e Game game) {
        this.f4592c = game;
    }

    public final void x0(@d e.n.f<List<Product>> fVar) {
        this.f4593d = fVar;
    }
}
