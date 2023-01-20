package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class VirtualLayout extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public VirtualLayout(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void applyLayoutFeaturesInConstraintSet(ConstraintLayout container) {
        applyLayoutFeatures(container);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attrs) {
        super.init(attrs);
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.mApplyVisibilityOnAttach = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.mApplyElevationOnAttach = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        int i2 = Build.VERSION.SDK_INT;
        super.onAttachedToWindow();
        if (this.mApplyVisibilityOnAttach || this.mApplyElevationOnAttach) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = i2 >= 21 ? getElevation() : 0.0f;
                for (int i3 = 0; i3 < this.mCount; i3++) {
                    View viewById = constraintLayout.getViewById(this.mIds[i3]);
                    if (viewById != null) {
                        if (this.mApplyVisibilityOnAttach) {
                            viewById.setVisibility(visibility);
                        }
                        if (this.mApplyElevationOnAttach && elevation > 0.0f && i2 >= 21) {
                            viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout layout, int widthMeasureSpec, int heightMeasureSpec) {
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        applyLayoutFeatures();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        applyLayoutFeatures();
    }

    public VirtualLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VirtualLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
