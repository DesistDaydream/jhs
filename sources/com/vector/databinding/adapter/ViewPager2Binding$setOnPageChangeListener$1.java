package com.vector.databinding.adapter;

import androidx.databinding.InverseBindingListener;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.view.pager.ViewPager2;
import e.t.j.h.w;
import e.t.j.h.x;
import e.t.j.h.y;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00060\u0002R\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/vector/view/pager/ViewPager2$OnPageChangeListenerBuilder;", "Lcom/vector/view/pager/ViewPager2;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewPager2Binding$setOnPageChangeListener$1 extends Lambda implements l<ViewPager2.c, t1> {
    public final /* synthetic */ InverseBindingListener $attrChanged;
    public final /* synthetic */ w $onPageScrollStateChangedBinding;
    public final /* synthetic */ x $onPageScrolledBinding;
    public final /* synthetic */ y $onPageSelectedBinding;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.vector.databinding.adapter.ViewPager2Binding$setOnPageChangeListener$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ w $onPageScrollStateChangedBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(w wVar) {
            super(1);
            this.$onPageScrollStateChangedBinding = wVar;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        public final void invoke(int i2) {
            l<Integer, t1> a;
            w wVar = this.$onPageScrollStateChangedBinding;
            if (wVar == null || (a = wVar.a()) == null) {
                return;
            }
            a.invoke(Integer.valueOf(i2));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "position", "", "positionOffset", "", "positionOffsetPixels"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.vector.databinding.adapter.ViewPager2Binding$setOnPageChangeListener$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends Lambda implements q<Integer, Float, Integer, t1> {
        public final /* synthetic */ x $onPageScrolledBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(x xVar) {
            super(3);
            this.$onPageScrolledBinding = xVar;
        }

        @Override // h.k2.u.q
        public /* bridge */ /* synthetic */ t1 invoke(Integer num, Float f2, Integer num2) {
            invoke(num.intValue(), f2.floatValue(), num2.intValue());
            return t1.a;
        }

        public final void invoke(int i2, float f2, int i3) {
            q<Integer, Float, Integer, t1> a;
            x xVar = this.$onPageScrolledBinding;
            if (xVar == null || (a = xVar.a()) == null) {
                return;
            }
            a.invoke(Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.vector.databinding.adapter.ViewPager2Binding$setOnPageChangeListener$1$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ InverseBindingListener $attrChanged;
        public final /* synthetic */ y $onPageSelectedBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(y yVar, InverseBindingListener inverseBindingListener) {
            super(1);
            this.$onPageSelectedBinding = yVar;
            this.$attrChanged = inverseBindingListener;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        public final void invoke(int i2) {
            l<Integer, t1> a;
            y yVar = this.$onPageSelectedBinding;
            if (yVar != null && (a = yVar.a()) != null) {
                a.invoke(Integer.valueOf(i2));
            }
            InverseBindingListener inverseBindingListener = this.$attrChanged;
            if (inverseBindingListener == null) {
                return;
            }
            inverseBindingListener.onChange();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Binding$setOnPageChangeListener$1(w wVar, x xVar, y yVar, InverseBindingListener inverseBindingListener) {
        super(1);
        this.$onPageScrollStateChangedBinding = wVar;
        this.$onPageScrolledBinding = xVar;
        this.$onPageSelectedBinding = yVar;
        this.$attrChanged = inverseBindingListener;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ViewPager2.c cVar) {
        invoke2(cVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ViewPager2.c cVar) {
        cVar.e(new AnonymousClass1(this.$onPageScrollStateChangedBinding));
        cVar.f(new AnonymousClass2(this.$onPageScrolledBinding));
        cVar.g(new AnonymousClass3(this.$onPageSelectedBinding, this.$attrChanged));
    }
}
