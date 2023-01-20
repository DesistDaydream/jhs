package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;
    public boolean resolved = false;

    public Barrier() {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        Object[] objArr;
        boolean z2;
        int i2;
        int i3;
        int i4;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        constraintAnchorArr[0] = this.mLeft;
        constraintAnchorArr[2] = this.mTop;
        constraintAnchorArr[1] = this.mRight;
        constraintAnchorArr[3] = this.mBottom;
        int i5 = 0;
        while (true) {
            objArr = this.mListAnchors;
            if (i5 >= objArr.length) {
                break;
            }
            objArr[i5].mSolverVariable = linearSystem.createObjectVariable(objArr[i5]);
            i5++;
        }
        int i6 = this.mBarrierType;
        if (i6 < 0 || i6 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = objArr[i6];
        if (!this.resolved) {
            allSolved();
        }
        if (this.resolved) {
            this.resolved = false;
            int i7 = this.mBarrierType;
            if (i7 == 0 || i7 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                return;
            } else if (i7 == 2 || i7 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                return;
            } else {
                return;
            }
        }
        for (int i8 = 0; i8 < this.mWidgetsCount; i8++) {
            ConstraintWidget constraintWidget = this.mWidgets[i8];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i3 = this.mBarrierType) == 0 || i3 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i4 = this.mBarrierType) == 2 || i4 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z4 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        int i9 = !z2 && (((i2 = this.mBarrierType) == 0 && z3) || ((i2 == 2 && z4) || ((i2 == 1 && z3) || (i2 == 3 && z4)))) ? 5 : 4;
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i10];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
                int i11 = this.mBarrierType;
                constraintAnchorArr2[i11].mSolverVariable = createObjectVariable;
                int i12 = (constraintAnchorArr2[i11].mTarget == null || constraintAnchorArr2[i11].mTarget.mOwner != this) ? 0 : constraintAnchorArr2[i11].mMargin + 0;
                if (i11 != 0 && i11 != 2) {
                    linearSystem.addGreaterBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i12, z2);
                } else {
                    linearSystem.addLowerBarrier(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin - i12, z2);
                }
                linearSystem.addEquality(constraintAnchor.mSolverVariable, createObjectVariable, this.mMargin + i12, i9);
            }
        }
        int i13 = this.mBarrierType;
        if (i13 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
        } else if (i13 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i13 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i13 == 3) {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public boolean allSolved() {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        boolean z = true;
        while (true) {
            i2 = this.mWidgetsCount;
            if (i5 >= i2) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i5];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i3 = this.mBarrierType) == 0 || i3 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i4 = this.mBarrierType) == 2 || i4 == 3) && !constraintWidget.isResolvedVertically()))) {
                z = false;
            }
            i5++;
        }
        if (!z || i2 <= 0) {
            return false;
        }
        int i6 = 0;
        boolean z2 = false;
        for (int i7 = 0; i7 < this.mWidgetsCount; i7++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i7];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z2) {
                    int i8 = this.mBarrierType;
                    if (i8 == 0) {
                        i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i8 == 1) {
                        i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i8 == 2) {
                        i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i8 == 3) {
                        i6 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z2 = true;
                }
                int i9 = this.mBarrierType;
                if (i9 == 0) {
                    i6 = Math.min(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i9 == 1) {
                    i6 = Math.max(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i9 == 2) {
                    i6 = Math.min(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i9 == 3) {
                    i6 = Math.max(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i10 = i6 + this.mMargin;
        int i11 = this.mBarrierType;
        if (i11 != 0 && i11 != 1) {
            setFinalVertical(i10, i10);
        } else {
            setFinalHorizontal(i10, i10);
        }
        this.resolved = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i2 = this.mBarrierType;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void markWidgets() {
        for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i3 = this.mBarrierType;
                if (i3 == 0 || i3 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i3 == 2 || i3 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public void setBarrierType(int i2) {
        this.mBarrierType = i2;
    }

    public void setMargin(int i2) {
        this.mMargin = i2;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (i2 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    public Barrier(String str) {
        setDebugName(str);
    }
}
