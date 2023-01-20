package com.effective.android.panel.view.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.effective.android.panel.R;
import h.k2.h;
import h.k2.v.f0;
import h.k2.v.u;
import java.util.HashMap;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cB-\b\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001dJ)\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/effective/android/panel/view/panel/PanelView;", "Landroid/widget/FrameLayout;", "Lcom/effective/android/panel/view/panel/IPanelView;", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "Lh/t1;", "initView", "(Landroid/util/AttributeSet;II)V", "getBindingTriggerViewId", "()I", "", "isTriggerViewCanToggle", "()Z", "isShowing", "assertView", "()V", "onFinishInflate", "isToggle", "Z", "triggerViewId", ExpandableTextView.P, "panelLayoutId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PanelView extends FrameLayout implements IPanelView {
    private HashMap _$_findViewCache;
    private boolean isToggle;
    private int panelLayoutId;
    private int triggerViewId;

    @h
    public PanelView(@e Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public PanelView(@e Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @h
    public PanelView(@e Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (context == null) {
            f0.L();
        }
        this.isToggle = true;
        initView(attributeSet, i2, 0);
    }

    private final void initView(AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PanelView, i2, 0);
        this.panelLayoutId = obtainStyledAttributes.getResourceId(R.styleable.PanelView_panel_layout, -1);
        this.triggerViewId = obtainStyledAttributes.getResourceId(R.styleable.PanelView_panel_trigger, -1);
        this.isToggle = obtainStyledAttributes.getBoolean(R.styleable.PanelView_panel_toggle, this.isToggle);
        obtainStyledAttributes.recycle();
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
        if (this.panelLayoutId != -1 && this.triggerViewId != -1) {
            if (getChildCount() <= 0) {
                LayoutInflater.from(getContext()).inflate(this.panelLayoutId, (ViewGroup) this, true);
                return;
            }
            throw new RuntimeException("PanelView -- you can't have any child!");
        }
        throw new RuntimeException("PanelView -- you must set 'panel_layout' and panel_trigger by Integer id");
    }

    @Override // com.effective.android.panel.view.panel.IPanelView
    public int getBindingTriggerViewId() {
        return this.triggerViewId;
    }

    @Override // com.effective.android.panel.view.panel.IPanelView
    public boolean isShowing() {
        return isShown();
    }

    @Override // com.effective.android.panel.view.panel.IPanelView
    public boolean isTriggerViewCanToggle() {
        return this.isToggle;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        assertView();
    }

    public /* synthetic */ PanelView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public PanelView(@e Context context, @e AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        if (context == null) {
            f0.L();
        }
        this.isToggle = true;
        initView(attributeSet, i2, i3);
    }
}
