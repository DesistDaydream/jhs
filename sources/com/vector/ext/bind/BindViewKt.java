package com.vector.ext.bind;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.vector.design.ui.dialog.DialogEx;
import e.t.k.a.c.b;
import e.t.l.c0.a;
import h.k2.u.p;
import h.m2.e;
import h.p2.n;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001b\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0\u001a\"\u0004\b\u0000\u0010\u001b\"\b\b\u0001\u0010\u001c*\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00032\u001f\u0010\u001e\u001a\u001b\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0002\u001aS\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0\u001a\"\u0004\b\u0000\u0010\u001b\"\b\b\u0001\u0010\u001c*\u00020\u00042\u0006\u0010 \u001a\u00020!2\u001f\u0010\u001e\u001a\u001b\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0002\u001aM\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u001a\"\u0004\b\u0000\u0010\u001b\"\b\b\u0001\u0010\u001c*\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00032\u001f\u0010\u001e\u001a\u001b\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0002\u001aS\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0\u001a\"\u0004\b\u0000\u0010\u001b\"\b\b\u0001\u0010\u001c*\u00020\u00042\u0006\u0010 \u001a\u00020!2\u001f\u0010\u001e\u001a\u001b\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0002\u001a\u001c\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00032\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0002\u001a*\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0003\u001a*\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0003\u001a*\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0003\u001a*\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003\u001a*\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0003\u001a*\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0003\u001a2\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00022\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\b2\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00042\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\r2\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u000f2\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00112\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0003\u001a*\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0003\u001a(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002H\u001c0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0003\u001a2\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00022\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\b2\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00042\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\r2\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u000f2\n\u0010 \u001a\u00020!\"\u00020\u0003\u001a2\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u001f0(\"\b\b\u0000\u0010\u001c*\u00020\u0004*\u00020\u00112\n\u0010 \u001a\u00020!\"\u00020\u0003\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\f\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000e\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0012\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0014\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0016\"1\u0010\u0000\u001a\u001b\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0018¨\u0006,"}, d2 = {"viewFinder", "Lkotlin/Function2;", "Landroid/app/Activity;", "", "Landroid/view/View;", "Lkotlin/ExtensionFunctionType;", "getViewFinder", "(Landroid/app/Activity;)Lkotlin/jvm/functions/Function2;", "Landroid/app/Dialog;", "(Landroid/app/Dialog;)Lkotlin/jvm/functions/Function2;", "(Landroid/view/View;)Lkotlin/jvm/functions/Function2;", "Landroid/widget/PopupWindow;", "(Landroid/widget/PopupWindow;)Lkotlin/jvm/functions/Function2;", "Landroidx/fragment/app/DialogFragment;", "(Landroidx/fragment/app/DialogFragment;)Lkotlin/jvm/functions/Function2;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lkotlin/jvm/functions/Function2;", "Lcom/vector/design/ui/adapter/BaseViewHolder;", "(Lcom/vector/design/ui/adapter/BaseViewHolder;)Lkotlin/jvm/functions/Function2;", "Lcom/vector/design/ui/dialog/DialogEx;", "(Lcom/vector/design/ui/dialog/DialogEx;)Lkotlin/jvm/functions/Function2;", "Lcom/vector/design/ui/popupWindow/PopupWindowEx;", "(Lcom/vector/design/ui/popupWindow/PopupWindowEx;)Lkotlin/jvm/functions/Function2;", "optional", "Lcom/vector/ext/bind/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "id", "finder", "", "ids", "", "required", "viewNotFound", "", "desc", "Lkotlin/reflect/KProperty;", "bindOptionalView", "Lkotlin/properties/ReadOnlyProperty;", "bindOptionalViews", "bindView", "bindViews", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindViewKt {
    @d
    public static final <V extends View> e<DialogFragment, List<V>> A(@d DialogFragment dialogFragment, @d int... iArr) {
        return Q(iArr, H(dialogFragment));
    }

    @d
    public static final <V extends View> e<Fragment, List<V>> B(@d Fragment fragment, @d int... iArr) {
        return Q(iArr, I(fragment));
    }

    @d
    public static final <V extends View> e<RecyclerView.ViewHolder, List<V>> C(@d RecyclerView.ViewHolder viewHolder, @d int... iArr) {
        return Q(iArr, J(viewHolder));
    }

    private static final p<Activity, Integer, View> D(Activity activity) {
        return BindViewKt$viewFinder$2.INSTANCE;
    }

    private static final p<Dialog, Integer, View> E(Dialog dialog) {
        return BindViewKt$viewFinder$3.INSTANCE;
    }

    private static final p<View, Integer, View> F(View view) {
        return BindViewKt$viewFinder$1.INSTANCE;
    }

    private static final p<PopupWindow, Integer, View> G(PopupWindow popupWindow) {
        return BindViewKt$viewFinder$5.INSTANCE;
    }

    private static final p<DialogFragment, Integer, View> H(DialogFragment dialogFragment) {
        return BindViewKt$viewFinder$7.INSTANCE;
    }

    private static final p<Fragment, Integer, View> I(Fragment fragment) {
        return BindViewKt$viewFinder$8.INSTANCE;
    }

    private static final p<RecyclerView.ViewHolder, Integer, View> J(RecyclerView.ViewHolder viewHolder) {
        return BindViewKt$viewFinder$9.INSTANCE;
    }

    private static final p<b, Integer, View> K(b bVar) {
        return BindViewKt$viewFinder$10.INSTANCE;
    }

    private static final p<DialogEx, Integer, View> L(DialogEx dialogEx) {
        return BindViewKt$viewFinder$4.INSTANCE;
    }

    private static final p<e.t.k.a.i.b, Integer, View> M(e.t.k.a.i.b bVar) {
        return BindViewKt$viewFinder$6.INSTANCE;
    }

    private static final <T, V extends View> a<T, V> N(int i2, p<? super T, ? super Integer, ? extends View> pVar) {
        return new a<>(new BindViewKt$optional$1(pVar, i2));
    }

    private static final <T, V extends View> a<T, List<V>> O(int[] iArr, p<? super T, ? super Integer, ? extends View> pVar) {
        return new a<>(new BindViewKt$optional$2(iArr, pVar));
    }

    private static final <T, V extends View> a<T, V> P(int i2, p<? super T, ? super Integer, ? extends View> pVar) {
        return new a<>(new BindViewKt$required$1(pVar, i2));
    }

    private static final <T, V extends View> a<T, List<V>> Q(int[] iArr, p<? super T, ? super Integer, ? extends View> pVar) {
        return new a<>(new BindViewKt$required$2(iArr, pVar));
    }

    public static final Void R(int i2, n<?> nVar) {
        throw new IllegalStateException("View ID " + i2 + " for '" + nVar.getName() + "' not found.");
    }

    @d
    public static final <V extends View> e<Activity, V> b(@d Activity activity, int i2) {
        return N(i2, D(activity));
    }

    @d
    public static final <V extends View> e<Dialog, V> c(@d Dialog dialog, int i2) {
        return N(i2, E(dialog));
    }

    @d
    public static final <V extends View> e<View, V> d(@d View view, int i2) {
        return N(i2, F(view));
    }

    @d
    public static final <V extends View> e<DialogFragment, V> e(@d DialogFragment dialogFragment, int i2) {
        return N(i2, H(dialogFragment));
    }

    @d
    public static final <V extends View> e<Fragment, V> f(@d Fragment fragment, int i2) {
        return N(i2, I(fragment));
    }

    @d
    public static final <V extends View> e<RecyclerView.ViewHolder, V> g(@d RecyclerView.ViewHolder viewHolder, int i2) {
        return N(i2, J(viewHolder));
    }

    @d
    public static final <V extends View> e<Activity, List<V>> h(@d Activity activity, @d int... iArr) {
        return O(iArr, D(activity));
    }

    @d
    public static final <V extends View> e<Dialog, List<V>> i(@d Dialog dialog, @d int... iArr) {
        return O(iArr, E(dialog));
    }

    @d
    public static final <V extends View> e<View, List<V>> j(@d View view, @d int... iArr) {
        return O(iArr, F(view));
    }

    @d
    public static final <V extends View> e<DialogFragment, List<V>> k(@d DialogFragment dialogFragment, @d int... iArr) {
        return O(iArr, H(dialogFragment));
    }

    @d
    public static final <V extends View> e<Fragment, List<V>> l(@d Fragment fragment, @d int... iArr) {
        return O(iArr, I(fragment));
    }

    @d
    public static final <V extends View> e<RecyclerView.ViewHolder, List<V>> m(@d RecyclerView.ViewHolder viewHolder, @d int... iArr) {
        return O(iArr, J(viewHolder));
    }

    @d
    public static final <V extends View> e<Activity, V> n(@d Activity activity, int i2) {
        return P(i2, D(activity));
    }

    @d
    public static final <V extends View> e<Dialog, V> o(@d Dialog dialog, int i2) {
        return P(i2, E(dialog));
    }

    @d
    public static final <V extends View> e<View, V> p(@d View view, @IdRes int i2) {
        return P(i2, F(view));
    }

    @d
    public static final <V extends View> e<PopupWindow, V> q(@d PopupWindow popupWindow, int i2) {
        return P(i2, G(popupWindow));
    }

    @d
    public static final <V extends View> e<DialogFragment, V> r(@d DialogFragment dialogFragment, int i2) {
        return P(i2, H(dialogFragment));
    }

    @d
    public static final <V extends View> e<Fragment, V> s(@d Fragment fragment, int i2) {
        return P(i2, I(fragment));
    }

    @d
    public static final <V extends View> e<RecyclerView.ViewHolder, V> t(@d RecyclerView.ViewHolder viewHolder, int i2) {
        return P(i2, J(viewHolder));
    }

    @d
    public static final <V extends View> e<b, V> u(@d b bVar, int i2) {
        return P(i2, K(bVar));
    }

    @d
    public static final <V extends View> e<DialogEx, V> v(@d DialogEx dialogEx, int i2) {
        return P(i2, L(dialogEx));
    }

    @d
    public static final <V extends View> e<e.t.k.a.i.b, V> w(@d e.t.k.a.i.b bVar, int i2) {
        return P(i2, M(bVar));
    }

    @d
    public static final <V extends View> e<Activity, List<V>> x(@d Activity activity, @d int... iArr) {
        return Q(iArr, D(activity));
    }

    @d
    public static final <V extends View> e<Dialog, List<V>> y(@d Dialog dialog, @d int... iArr) {
        return Q(iArr, E(dialog));
    }

    @d
    public static final <V extends View> e<View, List<V>> z(@d View view, @d int... iArr) {
        return Q(iArr, F(view));
    }
}
