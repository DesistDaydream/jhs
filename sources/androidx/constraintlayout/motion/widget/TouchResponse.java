package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class TouchResponse {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-7f;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int FLAG_SUPPORT_SCROLL_UP = 4;
    private static final int SEC_TO_MILLISECONDS = 1000;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float[] mAnchorDpDt;
    private int mAutoCompleteMode;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    public boolean mIsRotateMode;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp;
    public float mRotateCenterX;
    public float mRotateCenterY;
    private int mRotationCenterId;
    private int mSpringBoundary;
    private float mSpringDamping;
    private float mSpringMass;
    private float mSpringStiffness;
    private float mSpringStopThreshold;
    private int[] mTempLoc;
    private int mTouchAnchorId;
    private int mTouchAnchorSide;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    public TouchResponse(Context context, MotionLayout layout, XmlPullParser parser) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = layout;
        fillFromAttributeList(context, Xml.asAttributeSet(parser));
    }

    private void fill(TypedArray a) {
        int indexCount = a.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = a.getIndex(i2);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = a.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i3 = a.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i3;
                float[][] fArr = TOUCH_SIDES;
                this.mTouchAnchorX = fArr[i3][0];
                this.mTouchAnchorY = fArr[i3][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i4 = a.getInt(index, this.mTouchSide);
                this.mTouchSide = i4;
                float[][] fArr2 = TOUCH_DIRECTION;
                if (i4 < fArr2.length) {
                    this.mTouchDirectionX = fArr2[i4][0];
                    this.mTouchDirectionY = fArr2[i4][1];
                } else {
                    this.mTouchDirectionY = Float.NaN;
                    this.mTouchDirectionX = Float.NaN;
                    this.mIsRotateMode = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = a.getFloat(index, this.mMaxVelocity);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = a.getFloat(index, this.mMaxAcceleration);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = a.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = a.getFloat(index, this.mDragScale);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = a.getFloat(index, this.mDragThreshold);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = a.getResourceId(index, this.mTouchRegionId);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = a.getInt(index, this.mOnTouchUp);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = a.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = a.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.mRotationCenterId = a.getResourceId(index, this.mRotationCenterId);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.mSpringDamping = a.getFloat(index, this.mSpringDamping);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.mSpringMass = a.getFloat(index, this.mSpringMass);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.mSpringStiffness = a.getFloat(index, this.mSpringStiffness);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.mSpringStopThreshold = a.getFloat(index, this.mSpringStopThreshold);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.mSpringBoundary = a.getInt(index, this.mSpringBoundary);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.mAutoCompleteMode = a.getInt(index, this.mAutoCompleteMode);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public float dot(float dx, float dy) {
        return (dx * this.mTouchDirectionX) + (dy * this.mTouchDirectionY);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getAutoCompleteMode() {
        return this.mAutoCompleteMode;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public RectF getLimitBoundsTo(ViewGroup layout, RectF rect) {
        View findViewById;
        int i2 = this.mLimitBoundsTo;
        if (i2 == -1 || (findViewById = layout.findViewById(i2)) == null) {
            return null;
        }
        rect.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rect;
    }

    public int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public float getProgressDirection(float dx, float dy) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f2 = this.mTouchDirectionX;
        if (f2 != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (dx * f2) / fArr[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (dy * this.mTouchDirectionY) / fArr2[1];
    }

    public int getSpringBoundary() {
        return this.mSpringBoundary;
    }

    public float getSpringDamping() {
        return this.mSpringDamping;
    }

    public float getSpringMass() {
        return this.mSpringMass;
    }

    public float getSpringStiffness() {
        return this.mSpringStiffness;
    }

    public float getSpringStopThreshold() {
        return this.mSpringStopThreshold;
    }

    public RectF getTouchRegion(ViewGroup layout, RectF rect) {
        View findViewById;
        int i2 = this.mTouchRegionId;
        if (i2 == -1 || (findViewById = layout.findViewById(i2)) == null) {
            return null;
        }
        rect.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rect;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    public boolean isDragStarted() {
        return this.mDragStarted;
    }

    public void processTouchEvent(MotionEvent event, MotionLayout.MotionTracker velocityTracker, int currentState, MotionScene motionScene) {
        float f2;
        int i2;
        float f3;
        if (this.mIsRotateMode) {
            processTouchRotateEvent(event, velocityTracker, currentState, motionScene);
            return;
        }
        velocityTracker.addMovement(event);
        int action = event.getAction();
        if (action == 0) {
            this.mLastTouchX = event.getRawX();
            this.mLastTouchY = event.getRawY();
            this.mDragStarted = false;
        } else if (action == 1) {
            this.mDragStarted = false;
            velocityTracker.computeCurrentVelocity(1000);
            float xVelocity = velocityTracker.getXVelocity();
            float yVelocity = velocityTracker.getYVelocity();
            float progress = this.mMotionLayout.getProgress();
            int i3 = this.mTouchAnchorId;
            if (i3 != -1) {
                this.mMotionLayout.getAnchorDpDt(i3, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr = this.mAnchorDpDt;
                fArr[1] = this.mTouchDirectionY * min;
                fArr[0] = min * this.mTouchDirectionX;
            }
            float f4 = this.mTouchDirectionX;
            float[] fArr2 = this.mAnchorDpDt;
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            if (f4 != 0.0f) {
                f2 = xVelocity / fArr2[0];
            } else {
                f2 = yVelocity / fArr2[1];
            }
            float f7 = !Float.isNaN(f2) ? (f2 / 3.0f) + progress : progress;
            if (f7 == 0.0f || f7 == 1.0f || (i2 = this.mOnTouchUp) == 3) {
                if (0.0f >= f7 || 1.0f <= f7) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            float f8 = ((double) f7) < 0.5d ? 0.0f : 1.0f;
            if (i2 == 6) {
                if (progress + f2 < 0.0f) {
                    f2 = Math.abs(f2);
                }
                f8 = 1.0f;
            }
            if (this.mOnTouchUp == 7) {
                if (progress + f2 > 1.0f) {
                    f2 = -Math.abs(f2);
                }
                f8 = 0.0f;
            }
            this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, f8, f2);
            if (0.0f >= progress || 1.0f <= progress) {
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
            }
        } else if (action != 2) {
        } else {
            float rawY = event.getRawY() - this.mLastTouchY;
            float rawX = event.getRawX() - this.mLastTouchX;
            if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
                float progress2 = this.mMotionLayout.getProgress();
                if (!this.mDragStarted) {
                    this.mDragStarted = true;
                    this.mMotionLayout.setProgress(progress2);
                }
                int i4 = this.mTouchAnchorId;
                if (i4 != -1) {
                    this.mMotionLayout.getAnchorDpDt(i4, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                } else {
                    float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    float[] fArr3 = this.mAnchorDpDt;
                    fArr3[1] = this.mTouchDirectionY * min2;
                    fArr3[0] = min2 * this.mTouchDirectionX;
                }
                float f9 = this.mTouchDirectionX;
                float[] fArr4 = this.mAnchorDpDt;
                if (Math.abs(((f9 * fArr4[0]) + (this.mTouchDirectionY * fArr4[1])) * this.mDragScale) < 0.01d) {
                    float[] fArr5 = this.mAnchorDpDt;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                if (this.mTouchDirectionX != 0.0f) {
                    f3 = rawX / this.mAnchorDpDt[0];
                } else {
                    f3 = rawY / this.mAnchorDpDt[1];
                }
                float max = Math.max(Math.min(progress2 + f3, 1.0f), 0.0f);
                if (this.mOnTouchUp == 6) {
                    max = Math.max(max, 0.01f);
                }
                if (this.mOnTouchUp == 7) {
                    max = Math.min(max, 0.99f);
                }
                float progress3 = this.mMotionLayout.getProgress();
                if (max != progress3) {
                    int i5 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                    if (i5 == 0 || progress3 == 1.0f) {
                        this.mMotionLayout.endTrigger(i5 == 0);
                    }
                    this.mMotionLayout.setProgress(max);
                    velocityTracker.computeCurrentVelocity(1000);
                    this.mMotionLayout.mLastVelocity = this.mTouchDirectionX != 0.0f ? velocityTracker.getXVelocity() / this.mAnchorDpDt[0] : velocityTracker.getYVelocity() / this.mAnchorDpDt[1];
                } else {
                    this.mMotionLayout.mLastVelocity = 0.0f;
                }
                this.mLastTouchX = event.getRawX();
                this.mLastTouchY = event.getRawY();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void processTouchRotateEvent(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker r25, int r26, androidx.constraintlayout.motion.widget.MotionScene r27) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TouchResponse.processTouchRotateEvent(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker, int, androidx.constraintlayout.motion.widget.MotionScene):void");
    }

    public void scrollMove(float dx, float dy) {
        float f2;
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f3 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (Math.abs((f3 * fArr[0]) + (this.mTouchDirectionY * fArr[1])) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f4 = this.mTouchDirectionX;
        if (f4 != 0.0f) {
            f2 = (dx * f4) / this.mAnchorDpDt[0];
        } else {
            f2 = (dy * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        }
        float max = Math.max(Math.min(progress + f2, 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    public void scrollUp(float dx, float dy) {
        float f2;
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f3 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f4 = fArr[0];
        float f5 = this.mTouchDirectionY;
        float f6 = fArr[1];
        if (f3 != 0.0f) {
            f2 = (dx * f3) / fArr[0];
        } else {
            f2 = (dy * f5) / fArr[1];
        }
        if (!Float.isNaN(f2)) {
            progress += f2 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z = progress != 1.0f;
            int i2 = this.mOnTouchUp;
            if ((i2 != 3) && z) {
                this.mMotionLayout.touchAnimateTo(i2, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f2);
            }
        }
    }

    public void setAnchorId(int id) {
        this.mTouchAnchorId = id;
    }

    public void setAutoCompleteMode(int autoCompleteMode) {
        this.mAutoCompleteMode = autoCompleteMode;
    }

    public void setDown(float lastTouchX, float lastTouchY) {
        this.mLastTouchX = lastTouchX;
        this.mLastTouchY = lastTouchY;
    }

    public void setMaxAcceleration(float acceleration) {
        this.mMaxAcceleration = acceleration;
    }

    public void setMaxVelocity(float velocity) {
        this.mMaxVelocity = velocity;
    }

    public void setRTL(boolean rtl) {
        if (rtl) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = TOUCH_SIDES;
        int i2 = this.mTouchAnchorSide;
        this.mTouchAnchorX = fArr5[i2][0];
        this.mTouchAnchorY = fArr5[i2][1];
        int i3 = this.mTouchSide;
        float[][] fArr6 = TOUCH_DIRECTION;
        if (i3 >= fArr6.length) {
            return;
        }
        this.mTouchDirectionX = fArr6[i3][0];
        this.mTouchDirectionY = fArr6[i3][1];
    }

    public void setTouchAnchorLocation(float x, float y) {
        this.mTouchAnchorX = x;
        this.mTouchAnchorY = y;
    }

    public void setTouchUpMode(int touchUpMode) {
        this.mOnTouchUp = touchUpMode;
    }

    public void setUpTouchEvent(float lastTouchX, float lastTouchY) {
        this.mLastTouchX = lastTouchX;
        this.mLastTouchY = lastTouchY;
        this.mDragStarted = false;
    }

    public void setupTouch() {
        View view;
        int i2 = this.mTouchAnchorId;
        if (i2 != -1) {
            view = this.mMotionLayout.findViewById(i2);
            if (view == null) {
                String valueOf = String.valueOf(Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
                Log.e(TAG, valueOf.length() != 0 ? "cannot find TouchAnchorId @id/".concat(valueOf) : new String("cannot find TouchAnchorId @id/"));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener(this) { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this) { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                }
            });
        }
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX)) {
            return Key.ROTATION;
        }
        float f2 = this.mTouchDirectionX;
        float f3 = this.mTouchDirectionY;
        StringBuilder sb = new StringBuilder(33);
        sb.append(f2);
        sb.append(" , ");
        sb.append(f3);
        return sb.toString();
    }

    public TouchResponse(MotionLayout layout, OnSwipe onSwipe) {
        this.mTouchAnchorSide = 0;
        this.mTouchSide = 0;
        this.mOnTouchUp = 0;
        this.mTouchAnchorId = -1;
        this.mTouchRegionId = -1;
        this.mLimitBoundsTo = -1;
        this.mTouchAnchorY = 0.5f;
        this.mTouchAnchorX = 0.5f;
        this.mRotateCenterX = 0.5f;
        this.mRotateCenterY = 0.5f;
        this.mRotationCenterId = -1;
        this.mIsRotateMode = false;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = 1.0f;
        this.mDragStarted = false;
        this.mAnchorDpDt = new float[2];
        this.mTempLoc = new int[2];
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = 1.0f;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mSpringDamping = 10.0f;
        this.mSpringMass = 1.0f;
        this.mSpringStiffness = Float.NaN;
        this.mSpringStopThreshold = Float.NaN;
        this.mSpringBoundary = 0;
        this.mAutoCompleteMode = 0;
        this.mMotionLayout = layout;
        this.mTouchAnchorId = onSwipe.getTouchAnchorId();
        int touchAnchorSide = onSwipe.getTouchAnchorSide();
        this.mTouchAnchorSide = touchAnchorSide;
        if (touchAnchorSide != -1) {
            float[][] fArr = TOUCH_SIDES;
            this.mTouchAnchorX = fArr[touchAnchorSide][0];
            this.mTouchAnchorY = fArr[touchAnchorSide][1];
        }
        int dragDirection = onSwipe.getDragDirection();
        this.mTouchSide = dragDirection;
        float[][] fArr2 = TOUCH_DIRECTION;
        if (dragDirection < fArr2.length) {
            this.mTouchDirectionX = fArr2[dragDirection][0];
            this.mTouchDirectionY = fArr2[dragDirection][1];
        } else {
            this.mTouchDirectionY = Float.NaN;
            this.mTouchDirectionX = Float.NaN;
            this.mIsRotateMode = true;
        }
        this.mMaxVelocity = onSwipe.getMaxVelocity();
        this.mMaxAcceleration = onSwipe.getMaxAcceleration();
        this.mMoveWhenScrollAtTop = onSwipe.getMoveWhenScrollAtTop();
        this.mDragScale = onSwipe.getDragScale();
        this.mDragThreshold = onSwipe.getDragThreshold();
        this.mTouchRegionId = onSwipe.getTouchRegionId();
        this.mOnTouchUp = onSwipe.getOnTouchUp();
        this.mFlags = onSwipe.getNestedScrollFlags();
        this.mLimitBoundsTo = onSwipe.getLimitBoundsTo();
        this.mRotationCenterId = onSwipe.getRotationCenterId();
        this.mSpringBoundary = onSwipe.getSpringBoundary();
        this.mSpringDamping = onSwipe.getSpringDamping();
        this.mSpringMass = onSwipe.getSpringMass();
        this.mSpringStiffness = onSwipe.getSpringStiffness();
        this.mSpringStopThreshold = onSwipe.getSpringStopThreshold();
        this.mAutoCompleteMode = onSwipe.getAutoCompleteMode();
    }
}
