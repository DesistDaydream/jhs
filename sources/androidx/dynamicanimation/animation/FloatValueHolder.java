package androidx.dynamicanimation.animation;

/* loaded from: classes.dex */
public final class FloatValueHolder {
    private float mValue = 0.0f;

    public FloatValueHolder() {
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f2) {
        this.mValue = f2;
    }

    public FloatValueHolder(float f2) {
        setValue(f2);
    }
}
