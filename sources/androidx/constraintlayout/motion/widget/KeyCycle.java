package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    public static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    private String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private String mCustomWaveShape = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePhase = 0.0f;
    private float mProgress = Float.NaN;
    private int mWaveVariesBy = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    /* loaded from: classes.dex */
    public static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_PHASE = 21;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
            mAttrMap.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyCycle c2, TypedArray a) {
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
                        c2.mTransitionEasing = a.getString(index);
                        break;
                    case 4:
                        c2.mCurveFit = a.getInteger(index, c2.mCurveFit);
                        break;
                    case 5:
                        if (a.peekValue(index).type == 3) {
                            c2.mCustomWaveShape = a.getString(index);
                            c2.mWaveShape = 7;
                            break;
                        } else {
                            c2.mWaveShape = a.getInt(index, c2.mWaveShape);
                            break;
                        }
                    case 6:
                        c2.mWavePeriod = a.getFloat(index, c2.mWavePeriod);
                        break;
                    case 7:
                        if (a.peekValue(index).type == 5) {
                            c2.mWaveOffset = a.getDimension(index, c2.mWaveOffset);
                            break;
                        } else {
                            c2.mWaveOffset = a.getFloat(index, c2.mWaveOffset);
                            break;
                        }
                    case 8:
                        c2.mWaveVariesBy = a.getInt(index, c2.mWaveVariesBy);
                        break;
                    case 9:
                        c2.mAlpha = a.getFloat(index, c2.mAlpha);
                        break;
                    case 10:
                        c2.mElevation = a.getDimension(index, c2.mElevation);
                        break;
                    case 11:
                        c2.mRotation = a.getFloat(index, c2.mRotation);
                        break;
                    case 12:
                        c2.mRotationX = a.getFloat(index, c2.mRotationX);
                        break;
                    case 13:
                        c2.mRotationY = a.getFloat(index, c2.mRotationY);
                        break;
                    case 14:
                        c2.mTransitionPathRotate = a.getFloat(index, c2.mTransitionPathRotate);
                        break;
                    case 15:
                        c2.mScaleX = a.getFloat(index, c2.mScaleX);
                        break;
                    case 16:
                        c2.mScaleY = a.getFloat(index, c2.mScaleY);
                        break;
                    case 17:
                        c2.mTranslationX = a.getDimension(index, c2.mTranslationX);
                        break;
                    case 18:
                        c2.mTranslationY = a.getDimension(index, c2.mTranslationY);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT >= 21) {
                            c2.mTranslationZ = a.getDimension(index, c2.mTranslationZ);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        c2.mProgress = a.getFloat(index, c2.mProgress);
                        break;
                    case 21:
                        c2.mWavePhase = a.getFloat(index, c2.mWavePhase) / 360.0f;
                        break;
                    default:
                        String hexString = Integer.toHexString(index);
                        int i3 = mAttrMap.get(index);
                        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 33);
                        sb.append("unused attribute 0x");
                        sb.append(hexString);
                        sb.append("   ");
                        sb.append(i3);
                        Log.e("KeyCycle", sb.toString());
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, ViewOscillator> oscSet) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        for (String str : oscSet.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (viewOscillator = oscSet.get(str)) != null) {
                    viewOscillator.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (viewOscillator2 = oscSet.get(str)) != null) {
                    viewOscillator2.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
        int size = splines.size();
        StringBuilder sb = new StringBuilder(22);
        sb.append("add ");
        sb.append(size);
        sb.append(" values");
        Debug.logStack("KeyCycle", sb.toString(), 2);
        for (String str : splines.keySet()) {
            ViewSpline viewSpline = splines.get(str);
            if (viewSpline != null) {
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
                    case -40300674:
                        if (str.equals(Key.ROTATION)) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c2 = '\r';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        viewSpline.setPoint(this.mFramePosition, this.mRotationX);
                        continue;
                    case 1:
                        viewSpline.setPoint(this.mFramePosition, this.mRotationY);
                        continue;
                    case 2:
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationX);
                        continue;
                    case 3:
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationY);
                        continue;
                    case 4:
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationZ);
                        continue;
                    case 5:
                        viewSpline.setPoint(this.mFramePosition, this.mProgress);
                        continue;
                    case 6:
                        viewSpline.setPoint(this.mFramePosition, this.mScaleX);
                        continue;
                    case 7:
                        viewSpline.setPoint(this.mFramePosition, this.mScaleY);
                        continue;
                    case '\b':
                        viewSpline.setPoint(this.mFramePosition, this.mRotation);
                        continue;
                    case '\t':
                        viewSpline.setPoint(this.mFramePosition, this.mElevation);
                        continue;
                    case '\n':
                        viewSpline.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                        continue;
                    case 11:
                        viewSpline.setPoint(this.mFramePosition, this.mAlpha);
                        continue;
                    case '\f':
                        viewSpline.setPoint(this.mFramePosition, this.mWaveOffset);
                        continue;
                    case '\r':
                        viewSpline.setPoint(this.mFramePosition, this.mWavePhase);
                        continue;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            String valueOf = String.valueOf(str);
                            Log.v("WARNING KeyCycle", valueOf.length() != 0 ? "  UNKNOWN  ".concat(valueOf) : new String("  UNKNOWN  "));
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyCycle keyCycle = (KeyCycle) src;
        this.mTransitionEasing = keyCycle.mTransitionEasing;
        this.mCurveFit = keyCycle.mCurveFit;
        this.mWaveShape = keyCycle.mWaveShape;
        this.mCustomWaveShape = keyCycle.mCustomWaveShape;
        this.mWavePeriod = keyCycle.mWavePeriod;
        this.mWaveOffset = keyCycle.mWaveOffset;
        this.mWavePhase = keyCycle.mWavePhase;
        this.mProgress = keyCycle.mProgress;
        this.mWaveVariesBy = keyCycle.mWaveVariesBy;
        this.mAlpha = keyCycle.mAlpha;
        this.mElevation = keyCycle.mElevation;
        this.mRotation = keyCycle.mRotation;
        this.mTransitionPathRotate = keyCycle.mTransitionPathRotate;
        this.mRotationX = keyCycle.mRotationX;
        this.mRotationY = keyCycle.mRotationY;
        this.mScaleX = keyCycle.mScaleX;
        this.mScaleY = keyCycle.mScaleY;
        this.mTranslationX = keyCycle.mTranslationX;
        this.mTranslationY = keyCycle.mTranslationY;
        this.mTranslationZ = keyCycle.mTranslationZ;
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
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            attributes.add("transitionPathRotate");
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
        if (this.mCustomConstraints.size() > 0) {
            for (String str : this.mCustomConstraints.keySet()) {
                String valueOf = String.valueOf(str);
                attributes.add(valueOf.length() != 0 ? "CUSTOM,".concat(valueOf) : new String("CUSTOM,"));
            }
        }
    }

    public float getValue(String key) {
        key.hashCode();
        char c2 = 65535;
        switch (key.hashCode()) {
            case -1249320806:
                if (key.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (key.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (key.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (key.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (key.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (key.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (key.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (key.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (key.equals(Key.ROTATION)) {
                    c2 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (key.equals("elevation")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (key.equals("transitionPathRotate")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (key.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
            case 156108012:
                if (key.equals("waveOffset")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1530034690:
                if (key.equals("wavePhase")) {
                    c2 = '\r';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return this.mRotationX;
            case 1:
                return this.mRotationY;
            case 2:
                return this.mTranslationX;
            case 3:
                return this.mTranslationY;
            case 4:
                return this.mTranslationZ;
            case 5:
                return this.mProgress;
            case 6:
                return this.mScaleX;
            case 7:
                return this.mScaleY;
            case '\b':
                return this.mRotation;
            case '\t':
                return this.mElevation;
            case '\n':
                return this.mTransitionPathRotate;
            case 11:
                return this.mAlpha;
            case '\f':
                return this.mWaveOffset;
            case '\r':
                return this.mWavePhase;
            default:
                if (key.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                String valueOf = String.valueOf(key);
                Log.v("WARNING! KeyCycle", valueOf.length() != 0 ? "  UNKNOWN  ".concat(valueOf) : new String("  UNKNOWN  "));
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyCycle));
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
            case 1530034690:
                if (tag.equals("wavePhase")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1532805160:
                if (tag.equals("waveShape")) {
                    c2 = 17;
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
                this.mWavePhase = toFloat(value);
                return;
            case 17:
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
        return new KeyCycle().copy(this);
    }
}
