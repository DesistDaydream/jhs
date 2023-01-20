package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    public static final String DRAWPATH = "drawPath";
    public static final int KEY_TYPE = 2;
    public static final String NAME = "KeyPosition";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    private static final String TAG = "KeyPosition";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public String mTransitionEasing = null;
    public int mPathMotionArc = Key.UNSET;
    public int mDrawPath = 0;
    public float mPercentWidth = Float.NaN;
    public float mPercentHeight = Float.NaN;
    public float mPercentX = Float.NaN;
    public float mPercentY = Float.NaN;
    public float mAltPercentX = Float.NaN;
    public float mAltPercentY = Float.NaN;
    public int mPositionType = 0;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    /* loaded from: classes.dex */
    public static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyPosition c2, TypedArray a) {
            int indexCount = a.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = a.getIndex(i2);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = a.getResourceId(index, c2.mTargetId);
                            c2.mTargetId = resourceId;
                            if (resourceId == -1) {
                                c2.mTargetString = a.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (a.peekValue(index).type == 3) {
                            c2.mTargetString = a.getString(index);
                            break;
                        } else {
                            c2.mTargetId = a.getResourceId(index, c2.mTargetId);
                            break;
                        }
                    case 2:
                        c2.mFramePosition = a.getInt(index, c2.mFramePosition);
                        break;
                    case 3:
                        if (a.peekValue(index).type == 3) {
                            c2.mTransitionEasing = a.getString(index);
                            break;
                        } else {
                            c2.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        c2.mCurveFit = a.getInteger(index, c2.mCurveFit);
                        break;
                    case 5:
                        c2.mDrawPath = a.getInt(index, c2.mDrawPath);
                        break;
                    case 6:
                        c2.mPercentX = a.getFloat(index, c2.mPercentX);
                        break;
                    case 7:
                        c2.mPercentY = a.getFloat(index, c2.mPercentY);
                        break;
                    case 8:
                        float f2 = a.getFloat(index, c2.mPercentHeight);
                        c2.mPercentWidth = f2;
                        c2.mPercentHeight = f2;
                        break;
                    case 9:
                        c2.mPositionType = a.getInt(index, c2.mPositionType);
                        break;
                    case 10:
                        c2.mPathMotionArc = a.getInt(index, c2.mPathMotionArc);
                        break;
                    case 11:
                        c2.mPercentWidth = a.getFloat(index, c2.mPercentWidth);
                        break;
                    case 12:
                        c2.mPercentHeight = a.getFloat(index, c2.mPercentHeight);
                        break;
                    default:
                        String hexString = Integer.toHexString(index);
                        int i3 = mAttrMap.get(index);
                        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 33);
                        sb.append("unused attribute 0x");
                        sb.append(hexString);
                        sb.append("   ");
                        sb.append(i3);
                        Log.e("KeyPosition", sb.toString());
                        break;
                }
            }
            if (c2.mFramePosition == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float start_x, float start_y, float end_x, float end_y) {
        float f2 = end_x - start_x;
        float f3 = end_y - start_y;
        float f4 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f5 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f6 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (start_x + (f4 * f2) + ((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f3));
        this.mCalculatedPositionY = (int) (start_y + (f2 * f5) + (f3 * f6));
    }

    private void calcPathPosition(float start_x, float start_y, float end_x, float end_y) {
        float f2 = end_x - start_x;
        float f3 = end_y - start_y;
        float f4 = this.mPercentX;
        float f5 = this.mPercentY;
        this.mCalculatedPositionX = start_x + (f2 * f4) + ((-f3) * f5);
        this.mCalculatedPositionY = start_y + (f3 * f4) + (f2 * f5);
    }

    private void calcScreenPosition(int layoutWidth, int layoutHeight) {
        float f2 = this.mPercentX;
        float f3 = 0;
        this.mCalculatedPositionX = ((layoutWidth - 0) * f2) + f3;
        this.mCalculatedPositionY = ((layoutHeight - 0) * f2) + f3;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void calcPosition(int layoutWidth, int layoutHeight, float start_x, float start_y, float end_x, float end_y) {
        int i2 = this.mPositionType;
        if (i2 == 1) {
            calcPathPosition(start_x, start_y, end_x, end_y);
        } else if (i2 != 2) {
            calcCartesianPosition(start_x, start_y, end_x, end_y);
        } else {
            calcScreenPosition(layoutWidth, layoutHeight);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyPosition keyPosition = (KeyPosition) src;
        this.mTransitionEasing = keyPosition.mTransitionEasing;
        this.mPathMotionArc = keyPosition.mPathMotionArc;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mPercentWidth = keyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = keyPosition.mPercentX;
        this.mPercentY = keyPosition.mPercentY;
        this.mAltPercentX = keyPosition.mAltPercentX;
        this.mAltPercentY = keyPosition.mAltPercentY;
        this.mCalculatedPositionX = keyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = keyPosition.mCalculatedPositionY;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int layoutWidth, int layoutHeight, RectF start, RectF end, float x, float y) {
        calcPosition(layoutWidth, layoutHeight, start.centerX(), start.centerY(), end.centerX(), end.centerY());
        return Math.abs(x - this.mCalculatedPositionX) < 20.0f && Math.abs(y - this.mCalculatedPositionY) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        int i2 = this.mPositionType;
        if (i2 == 1) {
            positionPathAttributes(start, end, x, y, attribute, value);
        } else if (i2 != 2) {
            positionCartAttributes(start, end, x, y, attribute, value);
        } else {
            positionScreenAttributes(view, start, end, x, y, attribute, value);
        }
    }

    public void positionCartAttributes(RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        float centerX = start.centerX();
        float centerY = start.centerY();
        float centerX2 = end.centerX() - centerX;
        float centerY2 = end.centerY() - centerY;
        if (attribute[0] != null) {
            if ("percentX".equals(attribute[0])) {
                value[0] = (x - centerX) / centerX2;
                value[1] = (y - centerY) / centerY2;
                return;
            }
            value[1] = (x - centerX) / centerX2;
            value[0] = (y - centerY) / centerY2;
            return;
        }
        attribute[0] = "percentX";
        value[0] = (x - centerX) / centerX2;
        attribute[1] = "percentY";
        value[1] = (y - centerY) / centerY2;
    }

    public void positionPathAttributes(RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        float centerX = start.centerX();
        float centerY = start.centerY();
        float centerX2 = end.centerX() - centerX;
        float centerY2 = end.centerY() - centerY;
        float hypot = (float) Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            value[0] = 0.0f;
            value[1] = 0.0f;
            return;
        }
        float f2 = centerX2 / hypot;
        float f3 = centerY2 / hypot;
        float f4 = y - centerY;
        float f5 = x - centerX;
        float f6 = ((f2 * f4) - (f5 * f3)) / hypot;
        float f7 = ((f2 * f5) + (f3 * f4)) / hypot;
        if (attribute[0] != null) {
            if ("percentX".equals(attribute[0])) {
                value[0] = f7;
                value[1] = f6;
                return;
            }
            return;
        }
        attribute[0] = "percentX";
        attribute[1] = "percentY";
        value[0] = f7;
        value[1] = f6;
    }

    public void positionScreenAttributes(View view, RectF start, RectF end, float x, float y, String[] attribute, float[] value) {
        start.centerX();
        start.centerY();
        end.centerX();
        end.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (attribute[0] != null) {
            if ("percentX".equals(attribute[0])) {
                value[0] = x / width;
                value[1] = y / height;
                return;
            }
            value[1] = x / width;
            value[0] = y / height;
            return;
        }
        attribute[0] = "percentX";
        value[0] = x / width;
        attribute[1] = "percentY";
        value[1] = y / height;
    }

    public void setType(int type) {
        this.mPositionType = type;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.hashCode();
        char c2 = 65535;
        switch (tag.hashCode()) {
            case -1812823328:
                if (tag.equals("transitionEasing")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (tag.equals("percentWidth")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (tag.equals("percentHeight")) {
                    c2 = 2;
                    break;
                }
                break;
            case -827014263:
                if (tag.equals("drawPath")) {
                    c2 = 3;
                    break;
                }
                break;
            case -200259324:
                if (tag.equals("sizePercent")) {
                    c2 = 4;
                    break;
                }
                break;
            case 428090547:
                if (tag.equals("percentX")) {
                    c2 = 5;
                    break;
                }
                break;
            case 428090548:
                if (tag.equals("percentY")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.mTransitionEasing = value.toString();
                return;
            case 1:
                this.mPercentWidth = toFloat(value);
                return;
            case 2:
                this.mPercentHeight = toFloat(value);
                return;
            case 3:
                this.mDrawPath = toInt(value);
                return;
            case 4:
                float f2 = toFloat(value);
                this.mPercentWidth = f2;
                this.mPercentHeight = f2;
                return;
            case 5:
                this.mPercentX = toFloat(value);
                return;
            case 6:
                this.mPercentY = toFloat(value);
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyPosition().copy(this);
    }
}
