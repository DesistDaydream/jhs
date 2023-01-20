package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
public class MotionKeyTrigger extends MotionKey {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    private static final String TAG = "KeyTrigger";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final int TYPE_CROSS = 312;
    public static final int TYPE_NEGATIVE_CROSS = 310;
    public static final int TYPE_POSITIVE_CROSS = 309;
    public static final int TYPE_POST_LAYOUT = 304;
    public static final int TYPE_TRIGGER_COLLISION_ID = 307;
    public static final int TYPE_TRIGGER_COLLISION_VIEW = 306;
    public static final int TYPE_TRIGGER_ID = 308;
    public static final int TYPE_TRIGGER_RECEIVER = 311;
    public static final int TYPE_TRIGGER_SLACK = 305;
    public static final int TYPE_VIEW_TRANSITION_ON_CROSS = 301;
    public static final int TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS = 303;
    public static final int TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS = 302;
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    public FloatRect mCollisionRect;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private boolean mFireNegativeReset;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    public HashMap<String, Method> mMethodHashMap;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    public FloatRect mTargetRect;
    private int mTriggerCollisionId;
    private int mTriggerID;
    private int mTriggerReceiver;
    public float mTriggerSlack;
    public int mViewTransitionOnCross;
    public int mViewTransitionOnNegativeCross;
    public int mViewTransitionOnPositiveCross;
    private int mCurveFit = -1;
    private String mCross = null;

    public MotionKeyTrigger() {
        int i2 = MotionKey.UNSET;
        this.mTriggerReceiver = i2;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i2;
        this.mTriggerCollisionId = i2;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mViewTransitionOnNegativeCross = i2;
        this.mViewTransitionOnPositiveCross = i2;
        this.mViewTransitionOnCross = i2;
        this.mCollisionRect = new FloatRect();
        this.mTargetRect = new FloatRect();
        this.mMethodHashMap = new HashMap<>();
        this.mType = 5;
        this.mCustom = new HashMap<>();
    }

    private void fireCustom(String str, MotionWidget motionWidget) {
        boolean z = str.length() == 1;
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.mCustom.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z || lowerCase.matches(str)) {
                CustomVariable customVariable = this.mCustom.get(str2);
                if (customVariable != null) {
                    customVariable.applyToWidget(motionWidget);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public void conditionallyFire(float f2, MotionWidget motionWidget) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case -1594793529:
                if (str.equals("positiveCross")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -966421266:
                if (str.equals("viewTransitionOnPositiveCross")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -786670827:
                if (str.equals("triggerCollisionId")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -648752941:
                if (str.equals("triggerID")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -638126837:
                if (str.equals("negativeCross")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -76025313:
                if (str.equals("triggerCollisionView")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -9754574:
                if (str.equals("viewTransitionOnNegativeCross")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 364489912:
                if (str.equals("triggerSlack")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1301930599:
                if (str.equals("viewTransitionOnCross")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1401391082:
                if (str.equals("postLayout")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1535404999:
                if (str.equals("triggerReceiver")) {
                    c2 = '\n';
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
                return 309;
            case 1:
                return 302;
            case 2:
                return 307;
            case 3:
                return 308;
            case 4:
                return 310;
            case 5:
                return 306;
            case 6:
                return 303;
            case 7:
                return 305;
            case '\b':
                return 301;
            case '\t':
                return 304;
            case '\n':
                return 311;
            default:
                return -1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i3) {
        if (i2 == 307) {
            this.mTriggerCollisionId = i3;
            return true;
        } else if (i2 == 308) {
            this.mTriggerID = toInt(Integer.valueOf(i3));
            return true;
        } else if (i2 != 311) {
            switch (i2) {
                case 301:
                    this.mViewTransitionOnCross = i3;
                    return true;
                case 302:
                    this.mViewTransitionOnPositiveCross = i3;
                    return true;
                case 303:
                    this.mViewTransitionOnNegativeCross = i3;
                    return true;
                default:
                    return super.setValue(i2, i3);
            }
        } else {
            this.mTriggerReceiver = i3;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey clone() {
        return new MotionKeyTrigger().copy((MotionKey) this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTrigger copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.mCurveFit = motionKeyTrigger.mCurveFit;
        this.mCross = motionKeyTrigger.mCross;
        this.mTriggerReceiver = motionKeyTrigger.mTriggerReceiver;
        this.mNegativeCross = motionKeyTrigger.mNegativeCross;
        this.mPositiveCross = motionKeyTrigger.mPositiveCross;
        this.mTriggerID = motionKeyTrigger.mTriggerID;
        this.mTriggerCollisionId = motionKeyTrigger.mTriggerCollisionId;
        this.mTriggerSlack = motionKeyTrigger.mTriggerSlack;
        this.mFireCrossReset = motionKeyTrigger.mFireCrossReset;
        this.mFireNegativeReset = motionKeyTrigger.mFireNegativeReset;
        this.mFirePositiveReset = motionKeyTrigger.mFirePositiveReset;
        this.mFireThreshold = motionKeyTrigger.mFireThreshold;
        this.mFireLastPos = motionKeyTrigger.mFireLastPos;
        this.mPostLayout = motionKeyTrigger.mPostLayout;
        this.mCollisionRect = motionKeyTrigger.mCollisionRect;
        this.mTargetRect = motionKeyTrigger.mTargetRect;
        this.mMethodHashMap = motionKeyTrigger.mMethodHashMap;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f2) {
        if (i2 != 305) {
            return super.setValue(i2, f2);
        }
        this.mTriggerSlack = f2;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        if (i2 == 309) {
            this.mPositiveCross = str;
            return true;
        } else if (i2 == 310) {
            this.mNegativeCross = str;
            return true;
        } else if (i2 != 312) {
            return super.setValue(i2, str);
        } else {
            this.mCross = str;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, boolean z) {
        if (i2 != 304) {
            return super.setValue(i2, z);
        }
        this.mPostLayout = z;
        return true;
    }
}
