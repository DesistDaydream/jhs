package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.q2.o;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@d(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", i = {0, 0, 0, 1, 1}, l = {97, 99}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "child", "$this$sequence", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements p<o<? super View>, c<? super t1>, Object> {
    public final /* synthetic */ ViewGroup $this_descendants;
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroupKt$descendants$1(ViewGroup viewGroup, c<? super ViewGroupKt$descendants$1> cVar) {
        super(2, cVar);
        this.$this_descendants = viewGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, cVar);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@k.e.a.d o<? super View> oVar, @e c<? super t1> cVar) {
        return ((ViewGroupKt$descendants$1) create(oVar, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
        if (r4 >= r5) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008c -> B:23:0x008e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0094 -> B:25:0x0097). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$1
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            java.lang.Object r6 = r10.L$0
            h.q2.o r6 = (h.q2.o) r6
            h.r0.n(r11)
            r7 = r10
            goto L8e
        L20:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L28:
            int r1 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$2
            android.view.View r5 = (android.view.View) r5
            java.lang.Object r6 = r10.L$1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r7 = r10.L$0
            h.q2.o r7 = (h.q2.o) r7
            h.r0.n(r11)
            r11 = r7
            r7 = r10
            goto L6e
        L3e:
            h.r0.n(r11)
            java.lang.Object r11 = r10.L$0
            h.q2.o r11 = (h.q2.o) r11
            android.view.ViewGroup r1 = r10.$this_descendants
            r4 = 0
            int r5 = r1.getChildCount()
            if (r5 <= 0) goto L99
            r6 = r10
        L4f:
            int r7 = r4 + 1
            android.view.View r4 = r1.getChildAt(r4)
            r6.L$0 = r11
            r6.L$1 = r1
            r6.L$2 = r4
            r6.I$0 = r7
            r6.I$1 = r5
            r6.label = r3
            java.lang.Object r8 = r11.d(r4, r6)
            if (r8 != r0) goto L68
            return r0
        L68:
            r9 = r6
            r6 = r1
            r1 = r5
            r5 = r4
            r4 = r7
            r7 = r9
        L6e:
            boolean r8 = r5 instanceof android.view.ViewGroup
            if (r8 == 0) goto L94
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            h.q2.m r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r7.L$0 = r11
            r7.L$1 = r6
            r8 = 0
            r7.L$2 = r8
            r7.I$0 = r4
            r7.I$1 = r1
            r7.label = r2
            java.lang.Object r5 = r11.h(r5, r7)
            if (r5 != r0) goto L8c
            return r0
        L8c:
            r5 = r6
            r6 = r11
        L8e:
            r11 = r6
            r6 = r7
            r9 = r5
            r5 = r1
            r1 = r9
            goto L97
        L94:
            r5 = r1
            r1 = r6
            r6 = r7
        L97:
            if (r4 < r5) goto L4f
        L99:
            h.t1 r11 = h.t1.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewGroupKt$descendants$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
