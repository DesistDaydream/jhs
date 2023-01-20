package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Dimension {
    private final int WRAP_CONTENT;
    public Object mInitialValue;
    public boolean mIsSuggested;
    public int mMax;
    public int mMin;
    public float mPercent;
    public String mRatioString;
    public int mValue;
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object WRAP_DIMENSION = new Object();
    public static final Object SPREAD_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION = new Object();
    public static final Object PERCENT_DIMENSION = new Object();
    public static final Object RATIO_DIMENSION = new Object();

    /* loaded from: classes.dex */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    public static Dimension Fixed(int i2) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i2);
        return dimension;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object obj, float f2) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f2);
        return dimension;
    }

    public static Dimension Ratio(String str) {
        Dimension dimension = new Dimension(RATIO_DIMENSION);
        dimension.ratio(str);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int i2) {
        Dimension dimension = new Dimension();
        dimension.suggested(i2);
        return dimension;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i2) {
        String str = this.mRatioString;
        if (str != null) {
            constraintWidget.setDimensionRatio(str);
        }
        int i3 = 2;
        if (i2 == 0) {
            if (this.mIsSuggested) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.mInitialValue;
                if (obj == WRAP_DIMENSION) {
                    i3 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i3 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i3, this.mMin, this.mMax, this.mPercent);
                return;
            }
            int i4 = this.mMin;
            if (i4 > 0) {
                constraintWidget.setMinWidth(i4);
            }
            int i5 = this.mMax;
            if (i5 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i5);
            }
            Object obj2 = this.mInitialValue;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj2 == null) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setWidth(this.mValue);
            }
        } else if (this.mIsSuggested) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.mInitialValue;
            if (obj3 == WRAP_DIMENSION) {
                i3 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i3 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i3, this.mMin, this.mMax, this.mPercent);
        } else {
            int i6 = this.mMin;
            if (i6 > 0) {
                constraintWidget.setMinHeight(i6);
            }
            int i7 = this.mMax;
            if (i7 < Integer.MAX_VALUE) {
                constraintWidget.setMaxHeight(i7);
            }
            Object obj4 = this.mInitialValue;
            if (obj4 == WRAP_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj4 == PARENT_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj4 == null) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(this.mValue);
            }
        }
    }

    public boolean equalsFixedValue(int i2) {
        return this.mInitialValue == null && this.mValue == i2;
    }

    public Dimension fixed(Object obj) {
        this.mInitialValue = obj;
        if (obj instanceof Integer) {
            this.mValue = ((Integer) obj).intValue();
            this.mInitialValue = null;
        }
        return this;
    }

    public int getValue() {
        return this.mValue;
    }

    public Dimension max(int i2) {
        if (this.mMax >= 0) {
            this.mMax = i2;
        }
        return this;
    }

    public Dimension min(int i2) {
        if (i2 >= 0) {
            this.mMin = i2;
        }
        return this;
    }

    public Dimension percent(Object obj, float f2) {
        this.mPercent = f2;
        return this;
    }

    public Dimension ratio(String str) {
        this.mRatioString = str;
        return this;
    }

    public void setValue(int i2) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = i2;
    }

    public Dimension suggested(int i2) {
        this.mIsSuggested = true;
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.mMin = -2;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.mInitialValue = obj;
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension Suggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.mIsSuggested) {
            this.mInitialValue = obj2;
            this.mMax = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension fixed(int i2) {
        this.mInitialValue = null;
        this.mValue = i2;
        return this;
    }

    private Dimension(Object obj) {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatioString = null;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
        this.mInitialValue = obj;
    }
}
