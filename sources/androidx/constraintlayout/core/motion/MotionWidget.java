package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import c.c.a.a.b.a;
import c.c.a.a.b.d;
import java.util.Set;

/* loaded from: classes.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    private float mProgress;
    public float mTransitionPathRotate;
    public Motion motion;
    public PropertySet propertySet;
    public WidgetFrame widgetFrame;

    /* loaded from: classes.dex */
    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;
    }

    /* loaded from: classes.dex */
    public static class PropertySet {
        public int visibility = 4;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
    }

    public MotionWidget() {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
    }

    public MotionWidget findViewById(int i2) {
        return null;
    }

    public float getAlpha() {
        return this.propertySet.alpha;
    }

    public int getBottom() {
        return this.widgetFrame.bottom;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.widgetFrame.getCustomAttribute(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.widgetFrame.getCustomAttributeNames();
    }

    public int getHeight() {
        WidgetFrame widgetFrame = this.widgetFrame;
        return widgetFrame.bottom - widgetFrame.top;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        int a = a.a(str);
        return a != -1 ? a : d.a(str);
    }

    public int getLeft() {
        return this.widgetFrame.left;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.widgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.widgetFrame.pivotY;
    }

    public int getRight() {
        return this.widgetFrame.right;
    }

    public float getRotationX() {
        return this.widgetFrame.rotationX;
    }

    public float getRotationY() {
        return this.widgetFrame.rotationY;
    }

    public float getRotationZ() {
        return this.widgetFrame.rotationZ;
    }

    public float getScaleX() {
        return this.widgetFrame.scaleX;
    }

    public float getScaleY() {
        return this.widgetFrame.scaleY;
    }

    public int getTop() {
        return this.widgetFrame.top;
    }

    public float getTranslationX() {
        return this.widgetFrame.translationX;
    }

    public float getTranslationY() {
        return this.widgetFrame.translationY;
    }

    public float getTranslationZ() {
        return this.widgetFrame.translationZ;
    }

    public float getValueAttributes(int i2) {
        switch (i2) {
            case 303:
                return this.widgetFrame.alpha;
            case 304:
                return this.widgetFrame.translationX;
            case 305:
                return this.widgetFrame.translationY;
            case 306:
                return this.widgetFrame.translationZ;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.widgetFrame.rotationX;
            case 309:
                return this.widgetFrame.rotationY;
            case 310:
                return this.widgetFrame.rotationZ;
            case 311:
                return this.widgetFrame.scaleX;
            case 312:
                return this.widgetFrame.scaleY;
            case 313:
                return this.widgetFrame.pivotX;
            case 314:
                return this.widgetFrame.pivotY;
            case 315:
                return this.mProgress;
            case TypedValues.Attributes.TYPE_PATH_ROTATE /* 316 */:
                return this.mTransitionPathRotate;
        }
    }

    public int getVisibility() {
        return this.propertySet.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.widgetFrame;
    }

    public int getWidth() {
        WidgetFrame widgetFrame = this.widgetFrame;
        return widgetFrame.right - widgetFrame.left;
    }

    public int getX() {
        return this.widgetFrame.left;
    }

    public int getY() {
        return this.widgetFrame.top;
    }

    public void layout(int i2, int i3, int i4, int i5) {
        setBounds(i2, i3, i4, i5);
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        if (this.widgetFrame == null) {
            this.widgetFrame = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.widgetFrame;
        widgetFrame.top = i3;
        widgetFrame.left = i2;
        widgetFrame.right = i4;
        widgetFrame.bottom = i5;
    }

    public void setCustomAttribute(String str, int i2, float f2) {
        this.widgetFrame.setCustomAttribute(str, i2, f2);
    }

    public void setPivotX(float f2) {
        this.widgetFrame.pivotX = f2;
    }

    public void setPivotY(float f2) {
        this.widgetFrame.pivotY = f2;
    }

    public void setRotationX(float f2) {
        this.widgetFrame.rotationX = f2;
    }

    public void setRotationY(float f2) {
        this.widgetFrame.rotationY = f2;
    }

    public void setRotationZ(float f2) {
        this.widgetFrame.rotationZ = f2;
    }

    public void setScaleX(float f2) {
        this.widgetFrame.scaleX = f2;
    }

    public void setScaleY(float f2) {
        this.widgetFrame.scaleY = f2;
    }

    public void setTranslationX(float f2) {
        this.widgetFrame.translationX = f2;
    }

    public void setTranslationY(float f2) {
        this.widgetFrame.translationY = f2;
    }

    public void setTranslationZ(float f2) {
        this.widgetFrame.translationZ = f2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i3) {
        return setValueAttributes(i2, i3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, boolean z) {
        return false;
    }

    public boolean setValueAttributes(int i2, float f2) {
        switch (i2) {
            case 303:
                this.widgetFrame.alpha = f2;
                return true;
            case 304:
                this.widgetFrame.translationX = f2;
                return true;
            case 305:
                this.widgetFrame.translationY = f2;
                return true;
            case 306:
                this.widgetFrame.translationZ = f2;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.widgetFrame.rotationX = f2;
                return true;
            case 309:
                this.widgetFrame.rotationY = f2;
                return true;
            case 310:
                this.widgetFrame.rotationZ = f2;
                return true;
            case 311:
                this.widgetFrame.scaleX = f2;
                return true;
            case 312:
                this.widgetFrame.scaleY = f2;
                return true;
            case 313:
                this.widgetFrame.pivotX = f2;
                return true;
            case 314:
                this.widgetFrame.pivotY = f2;
                return true;
            case 315:
                this.mProgress = f2;
                return true;
            case TypedValues.Attributes.TYPE_PATH_ROTATE /* 316 */:
                this.mTransitionPathRotate = f2;
                return true;
        }
    }

    public boolean setValueMotion(int i2, int i3) {
        switch (i2) {
            case TypedValues.Motion.TYPE_ANIMATE_RELATIVE_TO /* 605 */:
                this.motion.mAnimateRelativeTo = i3;
                return true;
            case TypedValues.Motion.TYPE_ANIMATE_CIRCLEANGLE_TO /* 606 */:
                this.motion.mAnimateCircleAngleTo = i3;
                return true;
            case TypedValues.Motion.TYPE_PATHMOTION_ARC /* 607 */:
                this.motion.mPathMotionArc = i3;
                return true;
            case TypedValues.Motion.TYPE_DRAW_PATH /* 608 */:
                this.motion.mDrawPath = i3;
                return true;
            case TypedValues.Motion.TYPE_POLAR_RELATIVETO /* 609 */:
                this.motion.mPolarRelativeTo = i3;
                return true;
            case TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS /* 610 */:
                this.motion.mQuantizeMotionSteps = i3;
                return true;
            case TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_TYPE /* 611 */:
                this.motion.mQuantizeInterpolatorType = i3;
                return true;
            case TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_ID /* 612 */:
                this.motion.mQuantizeInterpolatorID = i3;
                return true;
            default:
                return false;
        }
    }

    public void setVisibility(int i2) {
        this.propertySet.visibility = i2;
    }

    public String toString() {
        return this.widgetFrame.left + ", " + this.widgetFrame.top + ", " + this.widgetFrame.right + ", " + this.widgetFrame.bottom;
    }

    public void setCustomAttribute(String str, int i2, int i3) {
        this.widgetFrame.setCustomAttribute(str, i2, i3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f2) {
        if (setValueAttributes(i2, f2)) {
            return true;
        }
        return setValueMotion(i2, f2);
    }

    public void setCustomAttribute(String str, int i2, boolean z) {
        this.widgetFrame.setCustomAttribute(str, i2, z);
    }

    public void setCustomAttribute(String str, int i2, String str2) {
        this.widgetFrame.setCustomAttribute(str, i2, str2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        return setValueMotion(i2, str);
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
        this.widgetFrame = widgetFrame;
    }

    public boolean setValueMotion(int i2, String str) {
        if (i2 == 603) {
            this.motion.mTransitionEasing = str;
            return true;
        } else if (i2 != 604) {
            return false;
        } else {
            this.motion.mQuantizeInterpolatorString = str;
            return true;
        }
    }

    public boolean setValueMotion(int i2, float f2) {
        switch (i2) {
            case 600:
                this.motion.mMotionStagger = f2;
                return true;
            case 601:
                this.motion.mPathRotate = f2;
                return true;
            case TypedValues.Motion.TYPE_QUANTIZE_MOTION_PHASE /* 602 */:
                this.motion.mQuantizeMotionPhase = f2;
                return true;
            default:
                return false;
        }
    }
}
