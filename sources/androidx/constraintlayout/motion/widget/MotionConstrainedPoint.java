package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    public static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    public static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    private float height;
    private Easing mKeyFrameEasing;
    private float position;
    public int visibility;
    private float width;
    private float x;
    private float y;
    private float alpha = 1.0f;
    public int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    private int mAnimateRelativeTo = -1;
    public LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    public int mMode = 0;
    public double[] mTempValue = new double[18];
    public double[] mTempDelta = new double[18];

    private boolean diff(float a, float b) {
        return (Float.isNaN(a) || Float.isNaN(b)) ? Float.isNaN(a) != Float.isNaN(b) : Math.abs(a - b) > 1.0E-6f;
    }

    public void addValues(HashMap<String, ViewSpline> splines, int mFramePosition) {
        for (String str : splines.keySet()) {
            ViewSpline viewSpline = splines.get(str);
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals(Key.PIVOT_X)) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals(Key.PIVOT_Y)) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c2 = '\r';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.rotationX) ? 0.0f : this.rotationX);
                    break;
                case 1:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case 2:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.translationX) ? 0.0f : this.translationX);
                    break;
                case 3:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.translationY) ? 0.0f : this.translationY);
                    break;
                case 4:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.translationZ) ? 0.0f : this.translationZ);
                    break;
                case 5:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                    break;
                case 6:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                    break;
                case 7:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                    break;
                case '\b':
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                    break;
                case '\t':
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                    break;
                case '\n':
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.rotation) ? 0.0f : this.rotation);
                    break;
                case 11:
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.elevation) ? 0.0f : this.elevation);
                    break;
                case '\f':
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                    break;
                case '\r':
                    viewSpline.setPoint(mFramePosition, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
                        if (this.attributes.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.attributes.get(str2);
                            if (viewSpline instanceof ViewSpline.CustomSet) {
                                ((ViewSpline.CustomSet) viewSpline).setPoint(mFramePosition, constraintAttribute);
                                break;
                            } else {
                                float valueToInterpolate = constraintAttribute.getValueToInterpolate();
                                String valueOf = String.valueOf(viewSpline);
                                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(valueOf).length());
                                sb.append(str);
                                sb.append(" ViewSpline not a CustomSet frame = ");
                                sb.append(mFramePosition);
                                sb.append(", value");
                                sb.append(valueToInterpolate);
                                sb.append(valueOf);
                                Log.e("MotionPaths", sb.toString());
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        String valueOf2 = String.valueOf(str);
                        Log.e("MotionPaths", valueOf2.length() != 0 ? "UNKNOWN spline ".concat(valueOf2) : new String("UNKNOWN spline "));
                        break;
                    }
            }
        }
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.elevation = view.getElevation();
        }
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        if (i2 >= 21) {
            this.translationZ = view.getTranslationZ();
        }
    }

    public void different(MotionConstrainedPoint points, HashSet<String> keySet) {
        if (diff(this.alpha, points.alpha)) {
            keySet.add("alpha");
        }
        if (diff(this.elevation, points.elevation)) {
            keySet.add("elevation");
        }
        int i2 = this.visibility;
        int i3 = points.visibility;
        if (i2 != i3 && this.mVisibilityMode == 0 && (i2 == 0 || i3 == 0)) {
            keySet.add("alpha");
        }
        if (diff(this.rotation, points.rotation)) {
            keySet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(points.mPathRotate)) {
            keySet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(points.mProgress)) {
            keySet.add("progress");
        }
        if (diff(this.rotationX, points.rotationX)) {
            keySet.add("rotationX");
        }
        if (diff(this.rotationY, points.rotationY)) {
            keySet.add("rotationY");
        }
        if (diff(this.mPivotX, points.mPivotX)) {
            keySet.add(Key.PIVOT_X);
        }
        if (diff(this.mPivotY, points.mPivotY)) {
            keySet.add(Key.PIVOT_Y);
        }
        if (diff(this.scaleX, points.scaleX)) {
            keySet.add("scaleX");
        }
        if (diff(this.scaleY, points.scaleY)) {
            keySet.add("scaleY");
        }
        if (diff(this.translationX, points.translationX)) {
            keySet.add("translationX");
        }
        if (diff(this.translationY, points.translationY)) {
            keySet.add("translationY");
        }
        if (diff(this.translationZ, points.translationZ)) {
            keySet.add("translationZ");
        }
    }

    public void fillStandard(double[] data, int[] toUse) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int i2 = 0;
        for (int i3 = 0; i3 < toUse.length; i3++) {
            if (toUse[i3] < 18) {
                data[i2] = fArr[toUse[i3]];
                i2++;
            }
        }
    }

    public int getCustomData(String name, double[] value, int offset) {
        ConstraintAttribute constraintAttribute = this.attributes.get(name);
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            value[offset] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i2 = 0;
        while (i2 < numberOfInterpolatedValues) {
            value[offset] = fArr[i2];
            i2++;
            offset++;
        }
        return numberOfInterpolatedValues;
    }

    public int getCustomDataCount(String name) {
        return this.attributes.get(name).numberOfInterpolatedValues();
    }

    public boolean hasCustomData(String name) {
        return this.attributes.containsKey(name);
    }

    public void setBounds(float x, float y, float w, float h2) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h2;
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint o) {
        return Float.compare(this.position, o.position);
    }

    public void setState(Rect rect, View view, int rotation, float prevous) {
        setBounds(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(view);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (rotation == 1) {
            this.rotation = prevous - 90.0f;
        } else if (rotation != 2) {
        } else {
            this.rotation = prevous + 90.0f;
        }
    }

    public void setState(Rect cw, ConstraintSet constraintSet, int rotation, int viewId) {
        setBounds(cw.left, cw.top, cw.width(), cw.height());
        applyParameters(constraintSet.getParameters(viewId));
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    if (rotation != 4) {
                        return;
                    }
                }
            }
            float f2 = this.rotation + 90.0f;
            this.rotation = f2;
            if (f2 > 180.0f) {
                this.rotation = f2 - 360.0f;
                return;
            }
            return;
        }
        this.rotation -= 90.0f;
    }

    public void applyParameters(ConstraintSet.Constraint c2) {
        ConstraintSet.PropertySet propertySet = c2.propertySet;
        int i2 = propertySet.mVisibilityMode;
        this.mVisibilityMode = i2;
        int i3 = propertySet.visibility;
        this.visibility = i3;
        this.alpha = (i3 == 0 || i2 != 0) ? propertySet.alpha : 0.0f;
        ConstraintSet.Transform transform = c2.transform;
        this.applyElevation = transform.applyElevation;
        this.elevation = transform.elevation;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(c2.motion.mTransitionEasing);
        ConstraintSet.Motion motion = c2.motion;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mProgress = c2.propertySet.mProgress;
        for (String str : c2.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = c2.mCustomConstraints.get(str);
            if (constraintAttribute.isContinuous()) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void different(MotionConstrainedPoint points, boolean[] mask, String[] custom) {
        mask[0] = mask[0] | diff(this.position, points.position);
        mask[1] = mask[1] | diff(this.x, points.x);
        mask[2] = mask[2] | diff(this.y, points.y);
        mask[3] = mask[3] | diff(this.width, points.width);
        mask[4] = diff(this.height, points.height) | mask[4];
    }
}
