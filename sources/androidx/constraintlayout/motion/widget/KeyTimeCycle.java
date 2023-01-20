package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    public static final String NAME = "KeyTimeCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyTimeCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_SHAPE = "waveShape";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;
    private int mWaveShape = 0;
    private String mCustomWaveShape = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;

    /* loaded from: classes.dex */
    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static final int WAVE_OFFSET = 21;
        private static final int WAVE_PERIOD = 20;
        private static final int WAVE_SHAPE = 19;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyTimeCycle_framePosition, 12);
            mAttrMap.append(R.styleable.KeyTimeCycle_curveFit, 13);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            mAttrMap.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            mAttrMap.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            mAttrMap.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        private Loader() {
        }

        public static void read(KeyTimeCycle c2, TypedArray a) {
            int indexCount = a.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = a.getIndex(i2);
                switch (mAttrMap.get(index)) {
                    case 1:
                        c2.mAlpha = a.getFloat(index, c2.mAlpha);
                        break;
                    case 2:
                        c2.mElevation = a.getDimension(index, c2.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        String hexString = Integer.toHexString(index);
                        int i3 = mAttrMap.get(index);
                        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 33);
                        sb.append("unused attribute 0x");
                        sb.append(hexString);
                        sb.append("   ");
                        sb.append(i3);
                        Log.e("KeyTimeCycle", sb.toString());
                        break;
                    case 4:
                        c2.mRotation = a.getFloat(index, c2.mRotation);
                        break;
                    case 5:
                        c2.mRotationX = a.getFloat(index, c2.mRotationX);
                        break;
                    case 6:
                        c2.mRotationY = a.getFloat(index, c2.mRotationY);
                        break;
                    case 7:
                        c2.mScaleX = a.getFloat(index, c2.mScaleX);
                        break;
                    case 8:
                        c2.mTransitionPathRotate = a.getFloat(index, c2.mTransitionPathRotate);
                        break;
                    case 9:
                        c2.mTransitionEasing = a.getString(index);
                        break;
                    case 10:
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
                    case 12:
                        c2.mFramePosition = a.getInt(index, c2.mFramePosition);
                        break;
                    case 13:
                        c2.mCurveFit = a.getInteger(index, c2.mCurveFit);
                        break;
                    case 14:
                        c2.mScaleY = a.getFloat(index, c2.mScaleY);
                        break;
                    case 15:
                        c2.mTranslationX = a.getDimension(index, c2.mTranslationX);
                        break;
                    case 16:
                        c2.mTranslationY = a.getDimension(index, c2.mTranslationY);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            c2.mTranslationZ = a.getDimension(index, c2.mTranslationZ);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        c2.mProgress = a.getFloat(index, c2.mProgress);
                        break;
                    case 19:
                        if (a.peekValue(index).type == 3) {
                            c2.mCustomWaveShape = a.getString(index);
                            c2.mWaveShape = 7;
                            break;
                        } else {
                            c2.mWaveShape = a.getInt(index, c2.mWaveShape);
                            break;
                        }
                    case 20:
                        c2.mWavePeriod = a.getFloat(index, c2.mWavePeriod);
                        break;
                    case 21:
                        if (a.peekValue(index).type == 5) {
                            c2.mWaveOffset = a.getDimension(index, c2.mWaveOffset);
                            break;
                        } else {
                            c2.mWaveOffset = a.getFloat(index, c2.mWaveOffset);
                            break;
                        }
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.mType = 3;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        if (r1.equals("scaleY") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addTimeValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r11) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTimeCycle.addTimeValues(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) src;
        this.mTransitionEasing = keyTimeCycle.mTransitionEasing;
        this.mCurveFit = keyTimeCycle.mCurveFit;
        this.mWaveShape = keyTimeCycle.mWaveShape;
        this.mWavePeriod = keyTimeCycle.mWavePeriod;
        this.mWaveOffset = keyTimeCycle.mWaveOffset;
        this.mProgress = keyTimeCycle.mProgress;
        this.mAlpha = keyTimeCycle.mAlpha;
        this.mElevation = keyTimeCycle.mElevation;
        this.mRotation = keyTimeCycle.mRotation;
        this.mTransitionPathRotate = keyTimeCycle.mTransitionPathRotate;
        this.mRotationX = keyTimeCycle.mRotationX;
        this.mRotationY = keyTimeCycle.mRotationY;
        this.mScaleX = keyTimeCycle.mScaleX;
        this.mScaleY = keyTimeCycle.mScaleY;
        this.mTranslationX = keyTimeCycle.mTranslationX;
        this.mTranslationY = keyTimeCycle.mTranslationY;
        this.mTranslationZ = keyTimeCycle.mTranslationZ;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> attributes) {
        if (!Float.isNaN(this.mAlpha)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            attributes.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            attributes.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            for (String str : this.mCustomConstraints.keySet()) {
                String valueOf = String.valueOf(str);
                attributes.add(valueOf.length() != 0 ? "CUSTOM,".concat(valueOf) : new String("CUSTOM,"));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> interpolation) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            interpolation.put("alpha", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            interpolation.put("elevation", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            interpolation.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            interpolation.put("rotationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            interpolation.put("rotationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            interpolation.put("translationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            interpolation.put("translationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            interpolation.put("translationZ", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            interpolation.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            interpolation.put("scaleX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            interpolation.put("scaleY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            interpolation.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            for (String str : this.mCustomConstraints.keySet()) {
                String valueOf = String.valueOf(str);
                interpolation.put(valueOf.length() != 0 ? "CUSTOM,".concat(valueOf) : new String("CUSTOM,"), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.hashCode();
        char c2 = 65535;
        switch (tag.hashCode()) {
            case -1913008125:
                if (tag.equals(Key.MOTIONPROGRESS)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (tag.equals("transitionEasing")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (tag.equals("rotationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (tag.equals("rotationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (tag.equals("translationX")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (tag.equals("translationY")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (tag.equals("translationZ")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189618:
                if (tag.equals("scaleX")) {
                    c2 = 7;
                    break;
                }
                break;
            case -908189617:
                if (tag.equals("scaleY")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -40300674:
                if (tag.equals(Key.ROTATION)) {
                    c2 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (tag.equals("elevation")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 37232917:
                if (tag.equals("transitionPathRotate")) {
                    c2 = 11;
                    break;
                }
                break;
            case 92909918:
                if (tag.equals("alpha")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 156108012:
                if (tag.equals("waveOffset")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 184161818:
                if (tag.equals("wavePeriod")) {
                    c2 = 14;
                    break;
                }
                break;
            case 579057826:
                if (tag.equals("curveFit")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1532805160:
                if (tag.equals("waveShape")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.mProgress = toFloat(value);
                return;
            case 1:
                this.mTransitionEasing = value.toString();
                return;
            case 2:
                this.mRotationX = toFloat(value);
                return;
            case 3:
                this.mRotationY = toFloat(value);
                return;
            case 4:
                this.mTranslationX = toFloat(value);
                return;
            case 5:
                this.mTranslationY = toFloat(value);
                return;
            case 6:
                this.mTranslationZ = toFloat(value);
                return;
            case 7:
                this.mScaleX = toFloat(value);
                return;
            case '\b':
                this.mScaleY = toFloat(value);
                return;
            case '\t':
                this.mRotation = toFloat(value);
                return;
            case '\n':
                this.mElevation = toFloat(value);
                return;
            case 11:
                this.mTransitionPathRotate = toFloat(value);
                return;
            case '\f':
                this.mAlpha = toFloat(value);
                return;
            case '\r':
                this.mWaveOffset = toFloat(value);
                return;
            case 14:
                this.mWavePeriod = toFloat(value);
                return;
            case 15:
                this.mCurveFit = toInt(value);
                return;
            case 16:
                if (value instanceof Integer) {
                    this.mWaveShape = toInt(value);
                    return;
                }
                this.mWaveShape = 7;
                this.mCustomWaveShape = value.toString();
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key clone() {
        return new KeyTimeCycle().copy(this);
    }
}
