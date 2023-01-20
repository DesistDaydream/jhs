package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class MotionKey implements TypedValues {
    public static final String ALPHA = "alpha";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String ROTATION = "rotationZ";
    public static final String ROTATION_X = "rotationX";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public HashMap<String, CustomVariable> mCustom;
    public int mFramePosition;
    public int mTargetId;
    public String mTargetString;
    public int mType;

    public MotionKey() {
        int i2 = UNSET;
        this.mFramePosition = i2;
        this.mTargetId = i2;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap<String, SplineSet> hashMap);

    /* renamed from: clone */
    public abstract MotionKey m3clone();

    public MotionKey copy(MotionKey motionKey) {
        this.mFramePosition = motionKey.mFramePosition;
        this.mTargetId = motionKey.mTargetId;
        this.mTargetString = motionKey.mTargetString;
        this.mType = motionKey.mType;
        return this;
    }

    public abstract void getAttributeNames(HashSet<String> hashSet);

    public int getFramePosition() {
        return this.mFramePosition;
    }

    public boolean matches(String str) {
        String str2 = this.mTargetString;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void setCustomAttribute(String str, int i2, float f2) {
        this.mCustom.put(str, new CustomVariable(str, i2, f2));
    }

    public void setFramePosition(int i2) {
        this.mFramePosition = i2;
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, float f2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, int i3) {
        if (i2 != 100) {
            return false;
        }
        this.mFramePosition = i3;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, boolean z) {
        return false;
    }

    public MotionKey setViewId(int i2) {
        this.mTargetId = i2;
        return this;
    }

    public boolean toBoolean(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public float toFloat(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public int toInt(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }

    public void setCustomAttribute(String str, int i2, int i3) {
        this.mCustom.put(str, new CustomVariable(str, i2, i3));
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i2, String str) {
        if (i2 != 101) {
            return false;
        }
        this.mTargetString = str;
        return true;
    }

    public void setCustomAttribute(String str, int i2, boolean z) {
        this.mCustom.put(str, new CustomVariable(str, i2, z));
    }

    public void setCustomAttribute(String str, int i2, String str2) {
        this.mCustom.put(str, new CustomVariable(str, i2, str2));
    }
}
