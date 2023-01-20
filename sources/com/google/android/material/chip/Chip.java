package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import e.j.a.c.a.h;
import e.j.a.c.j.a;
import e.j.a.c.s.m;
import e.j.a.c.s.t;
import e.j.a.c.w.d;
import e.j.a.c.w.f;
import e.j.a.c.z.k;
import e.j.a.c.z.o;
import e.j.a.c.z.s;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0364a, s {
    private static final String A = "android.widget.CompoundButton";
    private static final String B = "android.view.View";
    private static final String q = "Chip";
    private static final int s = 0;
    private static final int t = 1;
    private static final String x = "http://schemas.android.com/apk/res/android";
    private static final int y = 48;
    private static final String z = "android.widget.Button";
    @Nullable
    private e.j.a.c.j.a a;
    @Nullable
    private InsetDrawable b;
    @Nullable

    /* renamed from: c */
    private RippleDrawable f2839c;
    @Nullable

    /* renamed from: d */
    private View.OnClickListener f2840d;
    @Nullable

    /* renamed from: e */
    private CompoundButton.OnCheckedChangeListener f2841e;

    /* renamed from: f */
    private boolean f2842f;

    /* renamed from: g */
    private boolean f2843g;

    /* renamed from: h */
    private boolean f2844h;

    /* renamed from: i */
    private boolean f2845i;

    /* renamed from: j */
    private boolean f2846j;

    /* renamed from: k */
    private int f2847k;
    @Dimension(unit = 1)

    /* renamed from: l */
    private int f2848l;
    @NonNull

    /* renamed from: m */
    private final c f2849m;
    private final Rect n;
    private final RectF o;
    private final f p;
    private static final int r = R.style.Widget_MaterialComponents_Chip_Action;
    private static final Rect u = new Rect();
    private static final int[] v = {16842913};
    private static final int[] w = {16842911};

    /* loaded from: classes2.dex */
    public class a extends f {
        public a() {
            Chip.this = r1;
        }

        @Override // e.j.a.c.w.f
        public void a(int i2) {
        }

        @Override // e.j.a.c.w.f
        public void b(@NonNull Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(chip.a.H3() ? Chip.this.a.O1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ViewOutlineProvider {
        public b() {
            Chip.this = r1;
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @NonNull Outline outline) {
            if (Chip.this.a != null) {
                Chip.this.a.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends ExploreByTouchHelper {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Chip chip) {
            super(chip);
            Chip.this = r1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f2, float f3) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.x() && Chip.this.f2840d != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (i3 == 16) {
                if (i2 == 0) {
                    return Chip.this.performClick();
                }
                if (i2 == 1) {
                    return Chip.this.y();
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.r());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            if (!Chip.this.r() && !Chip.this.isClickable()) {
                accessibilityNodeInfoCompat.setClassName(Chip.B);
            } else {
                accessibilityNodeInfoCompat.setClassName(Chip.this.r() ? Chip.A : Chip.z);
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i2 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                    accessibilityNodeInfoCompat.setContentDescription(context.getString(i3, objArr).trim());
                }
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.u);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onVirtualViewKeyboardFocusChanged(int i2, boolean z) {
            if (i2 == 1) {
                Chip.this.f2845i = z;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void B(@Nullable e.j.a.c.j.a aVar) {
        if (aVar != null) {
            aVar.j3(null);
        }
    }

    private void C() {
        if (n() && x() && this.f2840d != null) {
            ViewCompat.setAccessibilityDelegate(this, this.f2849m);
        } else {
            ViewCompat.setAccessibilityDelegate(this, null);
        }
    }

    private void D() {
        if (e.j.a.c.x.b.a) {
            E();
            return;
        }
        this.a.G3(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        F();
        l();
    }

    private void E() {
        this.f2839c = new RippleDrawable(e.j.a.c.x.b.d(this.a.M1()), getBackgroundDrawable(), null);
        this.a.G3(false);
        ViewCompat.setBackground(this, this.f2839c);
        F();
    }

    private void F() {
        e.j.a.c.j.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.a) == null) {
            return;
        }
        int o1 = (int) (aVar.o1() + this.a.Q1() + this.a.U0());
        int t1 = (int) (this.a.t1() + this.a.R1() + this.a.Q0());
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            t1 += rect.left;
            o1 += rect.right;
        }
        ViewCompat.setPaddingRelative(this, t1, getPaddingTop(), o1, getPaddingBottom());
    }

    private void G() {
        TextPaint paint = getPaint();
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.j(getContext(), paint, this.p);
        }
    }

    private void H(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(x, "background") != null) {
            Log.w(q, "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue(x, "drawableLeft") == null) {
            if (attributeSet.getAttributeValue(x, "drawableStart") == null) {
                if (attributeSet.getAttributeValue(x, "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue(x, "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue(x, "singleLine", true) && attributeSet.getAttributeIntValue(x, "lines", 1) == 1 && attributeSet.getAttributeIntValue(x, "minLines", 1) == 1 && attributeSet.getAttributeIntValue(x, "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue(x, "gravity", 8388627) != 8388627) {
                                Log.w(q, "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.o.setEmpty();
        if (n() && this.f2840d != null) {
            this.a.E1(this.o);
        }
        return this.o;
    }

    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.n.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.n;
    }

    @Nullable
    private d getTextAppearance() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.P1();
        }
        return null;
    }

    private void i(@NonNull e.j.a.c.j.a aVar) {
        aVar.j3(this);
    }

    @NonNull
    private int[] j() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.f2845i) {
            i3++;
        }
        if (this.f2844h) {
            i3++;
        }
        if (this.f2843g) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.f2845i) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.f2844h) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.f2843g) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (getBackgroundDrawable() == this.b && this.a.getCallback() == null) {
            this.a.setCallback(this.b);
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean m(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f2849m)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f2849m, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e(q, "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e(q, "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e4) {
                Log.e(q, "Unable to send Accessibility Exit event", e4);
            } catch (InvocationTargetException e5) {
                Log.e(q, "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    public boolean n() {
        e.j.a.c.j.a aVar = this.a;
        return (aVar == null || aVar.x1() == null) ? false : true;
    }

    private void o(Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray j2 = m.j(context, attributeSet, R.styleable.Chip, i2, r, new int[0]);
        this.f2846j = j2.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.f2848l = (int) Math.ceil(j2.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(t.e(getContext(), 48))));
        j2.recycle();
    }

    private void p() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void q(int i2, int i3, int i4, int i5) {
        this.b = new InsetDrawable((Drawable) this.a, i2, i3, i4, i5);
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f2844h != z2) {
            this.f2844h = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f2843g != z2) {
            this.f2843g = z2;
            refreshDrawableState();
        }
    }

    private void z() {
        if (this.b != null) {
            this.b = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            D();
        }
    }

    public boolean A() {
        return this.f2846j;
    }

    @Override // e.j.a.c.j.a.InterfaceC0364a
    public void a() {
        k(this.f2848l);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return m(motionEvent) || this.f2849m.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f2849m.dispatchKeyEvent(keyEvent) || this.f2849m.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e.j.a.c.j.a aVar = this.a;
        if ((aVar == null || !aVar.b2()) ? false : this.a.e3(j())) {
            invalidate();
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.b;
        return insetDrawable == null ? this.a : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.k1();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.l1();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.m1();
        }
        return null;
    }

    public float getChipCornerRadius() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return Math.max(0.0f, aVar.n1());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.a;
    }

    public float getChipEndPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.o1();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.p1();
        }
        return null;
    }

    public float getChipIconSize() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.q1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.r1();
        }
        return null;
    }

    public float getChipMinHeight() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.s1();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.t1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.u1();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.v1();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.x1();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.y1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.z1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.A1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.B1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.D1();
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.H1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.f2849m.getKeyboardFocusedVirtualViewId() != 1 && this.f2849m.getAccessibilityFocusedVirtualViewId() != 1) {
            super.getFocusedRect(rect);
        } else {
            rect.set(getCloseIconTouchBoundsInt());
        }
    }

    @Nullable
    public h getHideMotionSpec() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.I1();
        }
        return null;
    }

    public float getIconEndPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.J1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.K1();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.M1();
        }
        return null;
    }

    @Override // e.j.a.c.z.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.a.getShapeAppearanceModel();
    }

    @Nullable
    public h getShowMotionSpec() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.N1();
        }
        return null;
    }

    public float getTextEndPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.Q1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            return aVar.R1();
        }
        return 0.0f;
    }

    public boolean k(@Dimension int i2) {
        this.f2848l = i2;
        if (!A()) {
            if (this.b != null) {
                z();
            } else {
                D();
            }
            return false;
        }
        int max = Math.max(0, i2 - this.a.getIntrinsicHeight());
        int max2 = Math.max(0, i2 - this.a.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.b != null) {
                z();
            } else {
                D();
            }
            return false;
        }
        int i3 = max2 > 0 ? max2 / 2 : 0;
        int i4 = max > 0 ? max / 2 : 0;
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                D();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
        } else {
            setMinHeight(i2);
            setMinWidth(i2);
        }
        q(i3, i4, i3, i4);
        D();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.f(this, this.a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, v);
        }
        if (r()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, w);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        this.f2849m.onFocusChanged(z2, i2, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!r() && !isClickable()) {
            accessibilityNodeInfo.setClassName(B);
        } else {
            accessibilityNodeInfo.setClassName(r() ? A : z);
        }
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.o(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i2) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.f2847k != i2) {
            this.f2847k = i2;
            F();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x001e, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f2843g
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.f2843g
            if (r0 == 0) goto L34
            r5.y()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean r() {
        e.j.a.c.j.a aVar = this.a;
        return aVar != null && aVar.V1();
    }

    @Deprecated
    public boolean s() {
        return t();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f2839c) {
            Log.w(q, "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.w(q, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != getBackgroundDrawable() && drawable != this.f2839c) {
            Log.w(q, "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i2) {
        Log.w(q, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w(q, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w(q, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.k2(z2);
        }
    }

    public void setCheckableResource(@BoolRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.l2(i2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        e.j.a.c.j.a aVar = this.a;
        if (aVar == null) {
            this.f2842f = z2;
        } else if (aVar.V1()) {
            boolean isChecked = isChecked();
            super.setChecked(z2);
            if (isChecked == z2 || (onCheckedChangeListener = this.f2841e) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z2);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.m2(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.p2(i2);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.q2(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.r2(i2);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.s2(i2);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.u2(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.v2(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.w2(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.x2(i2);
        }
    }

    public void setChipDrawable(@NonNull e.j.a.c.j.a aVar) {
        e.j.a.c.j.a aVar2 = this.a;
        if (aVar2 != aVar) {
            B(aVar2);
            this.a = aVar;
            aVar.u3(false);
            i(this.a);
            k(this.f2848l);
        }
    }

    public void setChipEndPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.y2(f2);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.z2(i2);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.A2(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@DrawableRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.D2(i2);
        }
    }

    public void setChipIconSize(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.E2(f2);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.F2(i2);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.G2(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.H2(i2);
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.I2(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.K2(f2);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.L2(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.M2(f2);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.N2(i2);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.O2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.P2(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.Q2(f2);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.R2(i2);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.T2(drawable);
        }
        C();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.U2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.X2(f2);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.Y2(i2);
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.Z2(i2);
        }
        C();
    }

    public void setCloseIconSize(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.a3(f2);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.b3(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.c3(f2);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.d3(i2);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.f3(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.g3(i2);
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.m0(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.a == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            e.j.a.c.j.a aVar = this.a;
            if (aVar != null) {
                aVar.k3(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.f2846j = z2;
        k(this.f2848l);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w(q, "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.l3(hVar);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.m3(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.n3(f2);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.o3(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.p3(f2);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.q3(i2);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.a != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i2) {
        super.setMaxWidth(i2);
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.r3(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2841e = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f2840d = onClickListener;
        C();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.s3(colorStateList);
        }
        if (this.a.T1()) {
            return;
        }
        E();
    }

    public void setRippleColorResource(@ColorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.t3(i2);
            if (this.a.T1()) {
                return;
            }
            E();
        }
    }

    @Override // e.j.a.c.z.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        this.a.setShapeAppearanceModel(oVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.v3(hVar);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.w3(i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (z2) {
            super.setSingleLine(z2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.H3() ? null : charSequence, bufferType);
        e.j.a.c.j.a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.x3(charSequence);
        }
    }

    public void setTextAppearance(@Nullable d dVar) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.y3(dVar);
        }
        G();
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.A3(f2);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.B3(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.E3(f2);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.F3(i2);
        }
    }

    public boolean t() {
        e.j.a.c.j.a aVar = this.a;
        return aVar != null && aVar.X1();
    }

    @Deprecated
    public boolean u() {
        return v();
    }

    public boolean v() {
        e.j.a.c.j.a aVar = this.a;
        return aVar != null && aVar.Z1();
    }

    @Deprecated
    public boolean w() {
        return x();
    }

    public boolean x() {
        e.j.a.c.j.a aVar = this.a;
        return aVar != null && aVar.c2();
    }

    @CallSuper
    public boolean y() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f2840d;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        this.f2849m.sendEventForVirtualView(1, 1);
        return z2;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.i3(z2);
        }
        C();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.Chip.r
            android.content.Context r8 = e.j.a.c.e0.a.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.n = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.o = r8
            com.google.android.material.chip.Chip$a r8 = new com.google.android.material.chip.Chip$a
            r8.<init>()
            r7.p = r8
            android.content.Context r8 = r7.getContext()
            r7.H(r9)
            e.j.a.c.j.a r6 = e.j.a.c.j.a.Z0(r8, r9, r10, r4)
            r7.o(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = androidx.core.view.ViewCompat.getElevation(r7)
            r6.m0(r0)
            int[] r2 = com.google.android.material.R.styleable.Chip
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 >= r0) goto L51
            int r10 = com.google.android.material.R.styleable.Chip_android_textColor
            android.content.res.ColorStateList r8 = e.j.a.c.w.c.a(r8, r9, r10)
            r7.setTextColor(r8)
        L51:
            int r8 = com.google.android.material.R.styleable.Chip_shapeAppearance
            boolean r8 = r9.hasValue(r8)
            r9.recycle()
            com.google.android.material.chip.Chip$c r9 = new com.google.android.material.chip.Chip$c
            r9.<init>(r7)
            r7.f2849m = r9
            r7.C()
            if (r8 != 0) goto L69
            r7.p()
        L69:
            boolean r8 = r7.f2842f
            r7.setChecked(r8)
            java.lang.CharSequence r8 = r6.O1()
            r7.setText(r8)
            android.text.TextUtils$TruncateAt r8 = r6.H1()
            r7.setEllipsize(r8)
            r7.G()
            e.j.a.c.j.a r8 = r7.a
            boolean r8 = r8.H3()
            if (r8 != 0) goto L8e
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L8e:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.F()
            boolean r8 = r7.A()
            if (r8 == 0) goto La2
            int r8 = r7.f2848l
            r7.setMinHeight(r8)
        La2:
            int r8 = androidx.core.view.ViewCompat.getLayoutDirection(r7)
            r7.f2847k = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedIconVisible(boolean z2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.t2(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.J2(z2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.z3(i2);
        }
        G();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        e.j.a.c.j.a aVar = this.a;
        if (aVar != null) {
            aVar.z3(i2);
        }
        G();
    }
}
