package com.effective.android.panel.view.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.IdRes;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.effective.android.panel.R;
import com.effective.android.panel.interfaces.ContentScrollMeasurer;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import h.k2.h;
import h.k2.v.u;
import java.util.HashMap;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0017\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b7\u00108B-\b\u0017\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b7\u00109J)\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJU\u0010\u0018\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b&\u0010$J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104¨\u0006:"}, d2 = {"Lcom/effective/android/panel/view/content/RelativeContentContainer;", "Landroid/widget/RelativeLayout;", "Lcom/effective/android/panel/view/content/IContentContainer;", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "Lh/t1;", "initView", "(Landroid/util/AttributeSet;II)V", "onFinishInflate", "()V", NotifyType.LIGHTS, am.aI, "r", "b", "", "Lcom/effective/android/panel/interfaces/ContentScrollMeasurer;", "contentScrollMeasurers", "defaultScrollHeight", "", "canScrollOutsize", "reset", "layoutContainer", "(IIIILjava/util/List;IZZ)V", "id", "Landroid/view/View;", "findTriggerView", "(I)Landroid/view/View;", "targetHeight", "changeContainerHeight", "(I)V", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "event", "onTouchEvent", "Lcom/effective/android/panel/view/content/IInputAction;", "getInputActionImpl", "()Lcom/effective/android/panel/view/content/IInputAction;", "Lcom/effective/android/panel/view/content/IResetAction;", "getResetActionImpl", "()Lcom/effective/android/panel/view/content/IResetAction;", "autoResetId", ExpandableTextView.P, "editTextId", "autoResetByOnTouch", "Z", "Lcom/effective/android/panel/view/content/ContentContainerImpl;", "contentContainer", "Lcom/effective/android/panel/view/content/ContentContainerImpl;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "panel_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class RelativeContentContainer extends RelativeLayout implements IContentContainer {
    private HashMap _$_findViewCache;
    private boolean autoResetByOnTouch;
    @IdRes
    private int autoResetId;
    private ContentContainerImpl contentContainer;
    @IdRes
    private int editTextId;

    @h
    public RelativeContentContainer(@e Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public RelativeContentContainer(@e Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @h
    public RelativeContentContainer(@e Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.autoResetByOnTouch = true;
        initView(attributeSet, i2, 0);
    }

    private final void initView(AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RelativeContentContainer, i2, 0);
        this.editTextId = obtainStyledAttributes.getResourceId(R.styleable.RelativeContentContainer_edit_view, -1);
        this.autoResetId = obtainStyledAttributes.getResourceId(R.styleable.RelativeContentContainer_auto_reset_area, -1);
        this.autoResetByOnTouch = obtainStyledAttributes.getBoolean(R.styleable.RelativeContentContainer_auto_reset_enable, this.autoResetByOnTouch);
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

    @Override // com.effective.android.panel.view.content.IContentContainer
    public void changeContainerHeight(int i2) {
        this.contentContainer.changeContainerHeight(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@e MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        return getResetActionImpl().hookDispatchTouchEvent(motionEvent, dispatchTouchEvent) | dispatchTouchEvent;
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    @e
    public View findTriggerView(int i2) {
        return this.contentContainer.findTriggerView(i2);
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    @d
    public IInputAction getInputActionImpl() {
        return this.contentContainer.getInputActionImpl();
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    @d
    public IResetAction getResetActionImpl() {
        return this.contentContainer.getResetActionImpl();
    }

    @Override // com.effective.android.panel.view.content.IContentContainer
    public void layoutContainer(int i2, int i3, int i4, int i5, @d List<ContentScrollMeasurer> list, int i6, boolean z, boolean z2) {
        this.contentContainer.layoutContainer(i2, i3, i4, i5, list, i6, z, z2);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.contentContainer = new ContentContainerImpl(this, this.autoResetByOnTouch, this.editTextId, this.autoResetId);
        addView(getInputActionImpl().getFullScreenPixelInputView(), 0, new RelativeLayout.LayoutParams(1, 1));
    }

    @Override // android.view.View
    public boolean onTouchEvent(@e MotionEvent motionEvent) {
        return getResetActionImpl().hookOnTouchEvent(motionEvent) | super.onTouchEvent(motionEvent);
    }

    public /* synthetic */ RelativeContentContainer(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @TargetApi(21)
    public RelativeContentContainer(@e Context context, @e AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.autoResetByOnTouch = true;
        initView(attributeSet, i2, i3);
    }
}
