package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import c.c.a.b.a;
import c.c.a.b.b;
import c.c.a.b.c;
import c.c.a.b.d;
import c.c.a.b.e;
import c.c.a.b.g;
import c.c.a.b.h;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Transition {
    public static final int ANTICIPATE = 6;
    public static final int BOUNCE = 4;
    public static final int EASE_IN = 1;
    public static final int EASE_IN_OUT = 0;
    public static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    public static final int LINEAR = 3;
    public static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    private HashMap<String, WidgetState> state = new HashMap<>();
    public HashMap<Integer, HashMap<String, KeyPosition>> keyPositions = new HashMap<>();
    private int pathMotionArc = -1;
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mAutoTransition = 0;
    private int mDuration = 400;
    private float mStagger = 0.0f;

    /* loaded from: classes.dex */
    public static class KeyPosition {
        public int frame;
        public String target;
        public int type;
        public float x;
        public float y;

        public KeyPosition(String str, int i2, int i3, float f2, float f3) {
            this.target = str;
            this.frame = i2;
            this.type = i3;
            this.x = f2;
            this.y = f3;
        }
    }

    /* loaded from: classes.dex */
    public static class WidgetState {
        public Motion motionControl;
        public KeyCache myKeyCache = new KeyCache();
        public int myParentHeight = -1;
        public int myParentWidth = -1;
        public WidgetFrame start = new WidgetFrame();
        public WidgetFrame end = new WidgetFrame();
        public WidgetFrame interpolated = new WidgetFrame();
        public MotionWidget motionWidgetStart = new MotionWidget(this.start);
        public MotionWidget motionWidgetEnd = new MotionWidget(this.end);
        public MotionWidget motionWidgetInterpolated = new MotionWidget(this.interpolated);

        public WidgetState() {
            Motion motion = new Motion(this.motionWidgetStart);
            this.motionControl = motion;
            motion.setStart(this.motionWidgetStart);
            this.motionControl.setEnd(this.motionWidgetEnd);
        }

        public WidgetFrame getFrame(int i2) {
            if (i2 == 0) {
                return this.start;
            }
            if (i2 == 1) {
                return this.end;
            }
            return this.interpolated;
        }

        public void interpolate(int i2, int i3, float f2, Transition transition) {
            this.myParentHeight = i3;
            this.myParentWidth = i2;
            this.motionControl.setup(i2, i3, 1.0f, System.nanoTime());
            WidgetFrame.interpolate(i2, i3, this.interpolated, this.start, this.end, transition, f2);
            this.interpolated.interpolatedPos = f2;
            this.motionControl.interpolate(this.motionWidgetInterpolated, f2, System.nanoTime(), this.myKeyCache);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            this.motionControl.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta(motionKeyCycle);
            this.motionControl.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta(motionKeyPosition);
            this.motionControl.addKey(motionKeyPosition);
        }

        public void update(ConstraintWidget constraintWidget, int i2) {
            if (i2 == 0) {
                this.start.update(constraintWidget);
                this.motionControl.setStart(this.motionWidgetStart);
            } else if (i2 == 1) {
                this.end.update(constraintWidget);
                this.motionControl.setEnd(this.motionWidgetEnd);
            }
            this.myParentWidth = -1;
        }
    }

    public static /* synthetic */ float a(String str, float f2) {
        return (float) Easing.getInterpolator(str).get(f2);
    }

    public static /* synthetic */ float b(float f2) {
        return (float) Easing.getInterpolator("standard").get(f2);
    }

    public static /* synthetic */ float c(float f2) {
        return (float) Easing.getInterpolator("accelerate").get(f2);
    }

    public static /* synthetic */ float d(float f2) {
        return (float) Easing.getInterpolator("decelerate").get(f2);
    }

    public static /* synthetic */ float e(float f2) {
        return (float) Easing.getInterpolator("linear").get(f2);
    }

    public static /* synthetic */ float f(float f2) {
        return (float) Easing.getInterpolator("anticipate").get(f2);
    }

    public static /* synthetic */ float g(float f2) {
        return (float) Easing.getInterpolator("overshoot").get(f2);
    }

    private WidgetState getWidgetState(String str) {
        return this.state.get(str);
    }

    public static /* synthetic */ float h(float f2) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(f2);
    }

    public void addCustomColor(int i2, String str, String str2, int i3) {
        getWidgetState(str, null, i2).getFrame(i2).addCustomColor(str2, i3);
    }

    public void addCustomFloat(int i2, String str, String str2, float f2) {
        getWidgetState(str, null, i2).getFrame(i2).addCustomFloat(str2, f2);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
    }

    public void clear() {
        this.state.clear();
    }

    public boolean contains(String str) {
        return this.state.containsKey(str);
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i2 = 0;
        for (int i3 = 0; i3 <= 100; i3++) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i3));
            if (hashMap != null && (keyPosition = hashMap.get(widgetFrame.widget.stringId)) != null) {
                fArr[i2] = keyPosition.x;
                fArr2[i2] = keyPosition.y;
                fArr3[i2] = keyPosition.frame;
                i2++;
            }
        }
    }

    public KeyPosition findNextPosition(String str, int i2) {
        KeyPosition keyPosition;
        while (i2 <= 100) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i2));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i2++;
        }
        return null;
    }

    public KeyPosition findPreviousPosition(String str, int i2) {
        KeyPosition keyPosition;
        while (i2 >= 0) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i2));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i2--;
        }
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.end;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.interpolated;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.state.get(str).motionControl.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return getWidgetState(str, null, 0).motionControl;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i2 = 0;
        for (int i3 = 0; i3 <= 100; i3++) {
            HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i3));
            if (hashMap != null && hashMap.get(widgetFrame.widget.stringId) != null) {
                i2++;
            }
        }
        return i2;
    }

    public float[] getPath(String str) {
        float[] fArr = new float[124];
        this.state.get(str).motionControl.buildPath(fArr, 62);
        return fArr;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.start;
    }

    public boolean hasPositionKeyframes() {
        return this.keyPositions.size() > 0;
    }

    public void interpolate(int i2, int i3, float f2) {
        for (String str : this.state.keySet()) {
            this.state.get(str).interpolate(i2, i3, f2, this);
        }
    }

    public boolean isEmpty() {
        return this.state.isEmpty();
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        this.pathMotionArc = typedBundle.getInteger(509);
        this.mAutoTransition = typedBundle.getInteger(TypedValues.Transition.TYPE_AUTO_TRANSITION);
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = children.get(i3);
            getWidgetState(constraintWidget.stringId, null, i2).update(constraintWidget, i2);
        }
    }

    public static Interpolator getInterpolator(int i2, final String str) {
        switch (i2) {
            case -1:
                return new Interpolator() { // from class: c.c.a.b.f
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f2) {
                        return Transition.a(str, f2);
                    }
                };
            case 0:
                return c.a;
            case 1:
                return d.a;
            case 2:
                return a.a;
            case 3:
                return b.a;
            case 4:
                return e.a;
            case 5:
                return h.a;
            case 6:
                return g.a;
            default:
                return null;
        }
    }

    private WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i2) {
        WidgetState widgetState = this.state.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            int i3 = this.pathMotionArc;
            if (i3 != -1) {
                widgetState.motionControl.setPathMotionArc(i3);
            }
            this.state.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i2);
            }
        }
        return widgetState;
    }

    public void addKeyPosition(String str, int i2, int i3, float f2, float f3) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add(TypedValues.Position.TYPE_POSITION_TYPE, 2);
        typedBundle.add(100, i2);
        typedBundle.add(TypedValues.Position.TYPE_PERCENT_X, f2);
        typedBundle.add(TypedValues.Position.TYPE_PERCENT_Y, f3);
        getWidgetState(str, null, 0).setKeyPosition(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i2, i3, f2, f3);
        HashMap<String, KeyPosition> hashMap = this.keyPositions.get(Integer.valueOf(i2));
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.keyPositions.put(Integer.valueOf(i2), hashMap);
        }
        hashMap.put(str, keyPosition);
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 1).end;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 2).interpolated;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, null, 0).start;
    }
}
