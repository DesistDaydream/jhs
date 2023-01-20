package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import c.c.a.a.b.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MotionKeyCycle extends MotionKey {
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

    public MotionKeyCycle() {
        this.mType = 4;
        this.mCustom = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                CustomVariable customVariable = this.mCustom.get(str.substring(7));
                if (customVariable != null && customVariable.getType() == 901 && (keyCycleOscillator = hashMap.get(str)) != null) {
                    keyCycleOscillator.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, customVariable.getValueToInterpolate(), customVariable);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (keyCycleOscillator2 = hashMap.get(str)) != null) {
                    keyCycleOscillator2.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, -1, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return null;
    }

    public void dump() {
        PrintStream printStream = System.out;
        printStream.println("MotionKeyCycle{mWaveShape=" + this.mWaveShape + ", mWavePeriod=" + this.mWavePeriod + ", mWaveOffset=" + this.mWaveOffset + ", mWavePhase=" + this.mWavePhase + ", mRotation=" + this.mRotation + '}');
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            Iterator<String> it = this.mCustom.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1581616630:
                if (str.equals(TypedValues.Cycle.S_CUSTOM_WAVE_SHAPE)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1310311125:
                if (str.equals("easing")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -1019779949:
                if (str.equals("offset")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -991726143:
                if (str.equals("period")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 106629499:
                if (str.equals(TypedValues.Cycle.S_WAVE_PHASE)) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return TypedValues.Cycle.TYPE_CUSTOM_WAVE_SHAPE;
            case 1:
                return TypedValues.Cycle.TYPE_EASING;
            case 2:
                return 308;
            case 3:
                return 309;
            case 4:
                return 310;
            case 5:
                return 304;
            case 6:
                return 305;
            case 7:
                return 306;
            case '\b':
                return TypedValues.Cycle.TYPE_WAVE_OFFSET;
            case '\t':
                return 315;
            case '\n':
                return TypedValues.Cycle.TYPE_WAVE_PERIOD;
            case 11:
                return 313;
            case '\f':
                return 314;
            case '\r':
                return 311;
            case 14:
                return 312;
            case 15:
                return 403;
            case 16:
                return TypedValues.Cycle.TYPE_WAVE_PHASE;
            case 17:
                return 401;
            case 18:
                return 416;
            case 19:
                return 421;
            case 20:
                return 402;
            default:
                return -1;
        }
    }

    public float getValue(String str) {
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
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1019779949:
                if (str.equals("offset")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 7;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
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
            case 106629499:
                if (str.equals(TypedValues.Cycle.S_WAVE_PHASE)) {
                    c2 = '\f';
                    break;
                }
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
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
                return this.mRotation;
            case 3:
                return this.mTranslationX;
            case 4:
                return this.mTranslationY;
            case 5:
                return this.mTranslationZ;
            case 6:
                return this.mWaveOffset;
            case 7:
                return this.mProgress;
            case '\b':
                return this.mScaleX;
            case '\t':
                return this.mScaleY;
            case '\n':
                return this.mElevation;
            case 11:
                return this.mAlpha;
            case '\f':
                return this.mWavePhase;
            case '\r':
                return this.mTransitionPathRotate;
            default:
                return Float.NaN;
        }
    }

    public void printAttributes() {
        HashSet<String> hashSet = new HashSet<>();
        getAttributeNames(hashSet);
        Utils.log(" ------------- " + this.mFramePosition + " -------------");
        Utils.log("MotionKeyCycle{Shape=" + this.mWaveShape + ", Period=" + this.mWavePeriod + ", Offset=" + this.mWaveOffset + ", Phase=" + this.mWavePhase + '}');
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            a.a(strArr[i2]);
            Utils.log(strArr[i2] + Constants.COLON_SEPARATOR + getValue(strArr[i2]));
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i3) {
        if (i2 == 401) {
            this.mCurveFit = i3;
            return true;
        } else if (i2 != 421) {
            if (setValue(i2, i3)) {
                return true;
            }
            return super.setValue(i2, i3);
        } else {
            this.mWaveShape = i3;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        if (i2 == 420) {
            this.mTransitionEasing = str;
            return true;
        } else if (i2 != 422) {
            return super.setValue(i2, str);
        } else {
            this.mCustomWaveShape = str;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f2) {
        if (i2 == 315) {
            this.mProgress = f2;
            return true;
        } else if (i2 == 403) {
            this.mAlpha = f2;
            return true;
        } else if (i2 != 416) {
            switch (i2) {
                case 304:
                    this.mTranslationX = f2;
                    return true;
                case 305:
                    this.mTranslationY = f2;
                    return true;
                case 306:
                    this.mTranslationZ = f2;
                    return true;
                case 307:
                    this.mElevation = f2;
                    return true;
                case 308:
                    this.mRotationX = f2;
                    return true;
                case 309:
                    this.mRotationY = f2;
                    return true;
                case 310:
                    this.mRotation = f2;
                    return true;
                case 311:
                    this.mScaleX = f2;
                    return true;
                case 312:
                    this.mScaleY = f2;
                    return true;
                default:
                    switch (i2) {
                        case TypedValues.Cycle.TYPE_WAVE_PERIOD /* 423 */:
                            this.mWavePeriod = f2;
                            return true;
                        case TypedValues.Cycle.TYPE_WAVE_OFFSET /* 424 */:
                            this.mWaveOffset = f2;
                            return true;
                        case TypedValues.Cycle.TYPE_WAVE_PHASE /* 425 */:
                            this.mWavePhase = f2;
                            return true;
                        default:
                            return super.setValue(i2, f2);
                    }
            }
        } else {
            this.mTransitionPathRotate = f2;
            return true;
        }
    }
}
