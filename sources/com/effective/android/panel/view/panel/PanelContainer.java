package com.effective.android.panel.view.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.effective.android.panel.interfaces.ViewAssertion;
import h.k2.h;
import h.k2.v.f0;
import h.k2.v.u;
import java.util.HashMap;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0017\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b,\u0010-B-\b\u0017\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b,\u0010.J)\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u0016\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#R0\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00170$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170$8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/effective/android/panel/view/panel/PanelContainer;", "Landroid/widget/FrameLayout;", "Lcom/effective/android/panel/interfaces/ViewAssertion;", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "Lh/t1;", "initView", "(Landroid/util/AttributeSet;II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onFinishInflate", "()V", "assertView", "panelId", "Lcom/effective/android/panel/view/panel/IPanelView;", "getPanelView", "(I)Lcom/effective/android/panel/view/panel/IPanelView;", "panel", "getPanelId", "(Lcom/effective/android/panel/view/panel/IPanelView;)I", "Landroid/util/Pair;", "size", "showPanel", "(ILandroid/util/Pair;)Landroid/util/Pair;", "targetHeight", "changeContainerHeight", "(I)V", "Landroid/util/SparseArray;", "<set-?>", "panelSparseArray", "Landroid/util/SparseArray;", "getPanelSparseArray", "()Landroid/util/SparseArray;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PanelContainer extends FrameLayout implements ViewAssertion {
    private HashMap _$_findViewCache;
    @d
    private SparseArray<IPanelView> panelSparseArray;

    @h
    public PanelContainer(@e Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public PanelContainer(@e Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @h
    public PanelContainer(@e Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (context == null) {
            f0.L();
        }
        this.panelSparseArray = new SparseArray<>();
        initView(attributeSet, i2, 0);
    }

    private final void initView(AttributeSet attributeSet, int i2, int i3) {
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.effective.android.panel.interfaces.ViewAssertion
    public void assertView() {
        this.panelSparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof IPanelView)) {
                childAt = null;
            }
            IPanelView iPanelView = (IPanelView) childAt;
            if (iPanelView != null) {
                this.panelSparseArray.put(iPanelView.getBindingTriggerViewId(), iPanelView);
                if (iPanelView == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                }
                ((View) iPanelView).setVisibility(8);
            } else {
                throw new RuntimeException("PanelContainer -- PanelContainer's child should be IPanelView");
            }
        }
    }

    public final void changeContainerHeight(int i2) {
        if (getLayoutParams() == null || getLayoutParams().height == i2) {
            return;
        }
        getLayoutParams().height = i2;
    }

    public final int getPanelId(@e IPanelView iPanelView) {
        if (iPanelView != null) {
            return iPanelView.getBindingTriggerViewId();
        }
        return 0;
    }

    @d
    public final SparseArray<IPanelView> getPanelSparseArray() {
        return this.panelSparseArray;
    }

    @e
    public final IPanelView getPanelView(int i2) {
        return this.panelSparseArray.get(i2);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        assertView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @d
    public final Pair<Integer, Integer> showPanel(int i2, @d Pair<Integer, Integer> pair) {
        IPanelView iPanelView = this.panelSparseArray.get(i2);
        int size = this.panelSparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            SparseArray<IPanelView> sparseArray = this.panelSparseArray;
            IPanelView iPanelView2 = sparseArray.get(sparseArray.keyAt(i3));
            if (iPanelView2 instanceof View) {
                ((View) iPanelView2).setVisibility(f0.g(iPanelView2, iPanelView) ^ true ? 8 : 0);
            }
        }
        if (iPanelView != null) {
            View view = (View) iPanelView;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
            if ((!f0.g((Integer) pair2.first, (Integer) pair.first)) || (!f0.g((Integer) pair2.second, (Integer) pair.second))) {
                layoutParams.width = ((Number) pair.first).intValue();
                layoutParams.height = ((Number) pair.second).intValue();
                view.setLayoutParams(layoutParams);
            }
            return pair2;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    public /* synthetic */ PanelContainer(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public PanelContainer(@e Context context, @e AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        if (context == null) {
            f0.L();
        }
        this.panelSparseArray = new SparseArray<>();
        initView(attributeSet, i2, i3);
    }
}
