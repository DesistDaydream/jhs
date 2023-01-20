package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    /* loaded from: classes.dex */
    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f2, float f3) {
            return f3 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f2, float f3) {
            return Math.abs(f3) < this.mVelocityThreshold;
        }

        public void setFrictionScalar(float f2) {
            this.mFriction = f2 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float f2) {
            this.mVelocityThreshold = f2 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float f2, float f3, long j2) {
            float f4 = (float) j2;
            this.mMassState.mVelocity = (float) (f3 * Math.exp((f4 / 1000.0f) * this.mFriction));
            DynamicAnimation.MassState massState = this.mMassState;
            float f5 = this.mFriction;
            massState.mValue = (float) ((f2 - (f3 / f5)) + ((f3 / f5) * Math.exp((f5 * f4) / 1000.0f)));
            DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.mValue, massState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f2, float f3) {
        return this.mFlingForce.getAcceleration(f2, f3);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f2, float f3) {
        return f2 >= this.mMaxValue || f2 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f2, f3);
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f) {
            this.mFlingForce.setFrictionScalar(f2);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f2) {
        this.mFlingForce.setValueThreshold(f2);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j2) {
        DynamicAnimation.MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j2);
        float f2 = updateValueAndVelocity.mValue;
        this.mValue = f2;
        float f3 = updateValueAndVelocity.mVelocity;
        this.mVelocity = f3;
        float f4 = this.mMinValue;
        if (f2 < f4) {
            this.mValue = f4;
            return true;
        }
        float f5 = this.mMaxValue;
        if (f2 <= f5) {
            return isAtEquilibrium(f2, f3);
        }
        this.mValue = f5;
        return true;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f2) {
        super.setMaxValue(f2);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f2) {
        super.setMinValue(f2);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f2) {
        super.setStartVelocity(f2);
        return this;
    }

    public <K> FlingAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k2, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
