package com.vector.ext.bind;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import e.t.l.c0.b;
import h.k2.u.p;
import h.m2.e;
import h.p2.n;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u001aM\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u000f\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010\u0011*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u001f\u0010\u0012\u001a\u001b\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0002\b\u0004H\u0002\u001a(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00110\u0014\"\b\b\u0000\u0010\u0011*\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003\u001a(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00110\u0014\"\b\b\u0000\u0010\u0011*\u00020\u0002*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0002\b\u0004*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0002\b\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006\u0015"}, d2 = {"fragFinder", "Lkotlin/Function2;", "Landroidx/fragment/app/Fragment;", "", "Lkotlin/ExtensionFunctionType;", "getFragFinder", "(Landroidx/fragment/app/Fragment;)Lkotlin/jvm/functions/Function2;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Lkotlin/jvm/functions/Function2;", "fragNotFound", "", "id", "desc", "Lkotlin/reflect/KProperty;", "required", "Lcom/vector/ext/bind/LazyFrag;", ExifInterface.GPS_DIRECTION_TRUE, "F", "finder", "bindFrag", "Lkotlin/properties/ReadOnlyProperty;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindFragmentKt {
    @d
    public static final <F extends Fragment> e<Fragment, F> b(@d Fragment fragment, int i2) {
        return g(i2, e(fragment));
    }

    @d
    public static final <F extends Fragment> e<FragmentActivity, F> c(@d FragmentActivity fragmentActivity, int i2) {
        return g(i2, f(fragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void d(int i2, n<?> nVar) {
        throw new IllegalStateException("Frag ID " + i2 + " for '" + nVar.getName() + "' not found.");
    }

    private static final p<Fragment, Integer, Fragment> e(Fragment fragment) {
        return BindFragmentKt$fragFinder$2.INSTANCE;
    }

    private static final p<FragmentActivity, Integer, Fragment> f(FragmentActivity fragmentActivity) {
        return BindFragmentKt$fragFinder$1.INSTANCE;
    }

    private static final <T, F extends Fragment> b<T, F> g(int i2, p<? super T, ? super Integer, ? extends Fragment> pVar) {
        return new b<>(new BindFragmentKt$required$1(pVar, i2));
    }
}
