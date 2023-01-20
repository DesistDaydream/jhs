package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_CIRCLE_ANGLE_TO = 82;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_MARGIN = 93;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BASELINE_TO_BOTTOM = 92;
    private static final int BASELINE_TO_TOP = 91;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    public static final int CIRCLE_REFERENCE = 8;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BASELINE_MARGIN = 94;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 4;
    private static final String KEY_PERCENT_PARENT = "parent";
    private static final String KEY_RATIO = "ratio";
    private static final String KEY_WEIGHT = "weight";
    private static final int LAYOUT_CONSTRAINT_HEIGHT = 96;
    private static final int LAYOUT_CONSTRAINT_WIDTH = 95;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    private static final int LAYOUT_WRAP_BEHAVIOR = 97;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int MOTION_TARGET = 98;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    private static final int QUANTIZE_MOTION_INTERPOLATOR = 86;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_ID = 89;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_STR = 90;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_TYPE = 88;
    private static final int QUANTIZE_MOTION_PHASE = 85;
    private static final int QUANTIZE_MOTION_STEPS = 84;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_TARGET = 83;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 87;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    public String mIdString;
    private boolean mValidate;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static SparseIntArray mapToConstant = new SparseIntArray();
    private static SparseIntArray overrideMapToConstant = new SparseIntArray();
    public String derivedState = "";
    public int mRotate = 0;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mForceId = true;
    private HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    /* loaded from: classes.dex */
    public static class Constraint {
        public Delta mDelta;
        public String mTargetString;
        public int mViewId;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int viewId, ConstraintLayout.LayoutParams param) {
            this.mViewId = viewId;
            Layout layout = this.layout;
            layout.leftToLeft = param.leftToLeft;
            layout.leftToRight = param.leftToRight;
            layout.rightToLeft = param.rightToLeft;
            layout.rightToRight = param.rightToRight;
            layout.topToTop = param.topToTop;
            layout.topToBottom = param.topToBottom;
            layout.bottomToTop = param.bottomToTop;
            layout.bottomToBottom = param.bottomToBottom;
            layout.baselineToBaseline = param.baselineToBaseline;
            layout.baselineToTop = param.baselineToTop;
            layout.baselineToBottom = param.baselineToBottom;
            layout.startToEnd = param.startToEnd;
            layout.startToStart = param.startToStart;
            layout.endToStart = param.endToStart;
            layout.endToEnd = param.endToEnd;
            layout.horizontalBias = param.horizontalBias;
            layout.verticalBias = param.verticalBias;
            layout.dimensionRatio = param.dimensionRatio;
            layout.circleConstraint = param.circleConstraint;
            layout.circleRadius = param.circleRadius;
            layout.circleAngle = param.circleAngle;
            layout.editorAbsoluteX = param.editorAbsoluteX;
            layout.editorAbsoluteY = param.editorAbsoluteY;
            layout.orientation = param.orientation;
            layout.guidePercent = param.guidePercent;
            Layout layout2 = this.layout;
            layout2.guideBegin = param.guideBegin;
            layout2.guideEnd = param.guideEnd;
            layout2.mWidth = ((ViewGroup.MarginLayoutParams) param).width;
            layout2.mHeight = ((ViewGroup.MarginLayoutParams) param).height;
            layout2.leftMargin = ((ViewGroup.MarginLayoutParams) param).leftMargin;
            layout2.rightMargin = ((ViewGroup.MarginLayoutParams) param).rightMargin;
            layout2.topMargin = ((ViewGroup.MarginLayoutParams) param).topMargin;
            layout2.bottomMargin = ((ViewGroup.MarginLayoutParams) param).bottomMargin;
            layout2.baselineMargin = param.baselineMargin;
            layout2.verticalWeight = param.verticalWeight;
            layout2.horizontalWeight = param.horizontalWeight;
            layout2.verticalChainStyle = param.verticalChainStyle;
            layout2.horizontalChainStyle = param.horizontalChainStyle;
            layout2.constrainedWidth = param.constrainedWidth;
            layout2.constrainedHeight = param.constrainedHeight;
            layout2.widthDefault = param.matchConstraintDefaultWidth;
            layout2.heightDefault = param.matchConstraintDefaultHeight;
            layout2.widthMax = param.matchConstraintMaxWidth;
            layout2.heightMax = param.matchConstraintMaxHeight;
            layout2.widthMin = param.matchConstraintMinWidth;
            layout2.heightMin = param.matchConstraintMinHeight;
            layout2.widthPercent = param.matchConstraintPercentWidth;
            layout2.heightPercent = param.matchConstraintPercentHeight;
            layout2.mConstraintTag = param.constraintTag;
            layout2.goneTopMargin = param.goneTopMargin;
            Layout layout3 = this.layout;
            layout3.goneBottomMargin = param.goneBottomMargin;
            layout3.goneLeftMargin = param.goneLeftMargin;
            layout3.goneRightMargin = param.goneRightMargin;
            layout3.goneStartMargin = param.goneStartMargin;
            layout3.goneEndMargin = param.goneEndMargin;
            layout3.goneBaselineMargin = param.goneBaselineMargin;
            layout3.mWrapBehavior = param.wrapBehaviorInParent;
            if (Build.VERSION.SDK_INT >= 17) {
                layout3.endMargin = param.getMarginEnd();
                this.layout.startMargin = param.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper helper, int viewId, Constraints.LayoutParams param) {
            fillFromConstraints(viewId, param);
            if (helper instanceof Barrier) {
                Layout layout = this.layout;
                layout.mHelperType = 1;
                Barrier barrier = (Barrier) helper;
                layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private ConstraintAttribute get(String attributeName, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(attributeName)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(attributeName);
                if (constraintAttribute.getType() != attributeType) {
                    String valueOf = String.valueOf(constraintAttribute.getType().name());
                    throw new IllegalArgumentException(valueOf.length() != 0 ? "ConstraintAttribute is already a ".concat(valueOf) : new String("ConstraintAttribute is already a "));
                }
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(attributeName, attributeType);
            this.mCustomConstraints.put(attributeName, constraintAttribute2);
            return constraintAttribute2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorValue(String attributeName, int value) {
            get(attributeName, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(String attributeName, float value) {
            get(attributeName, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(String attributeName, int value) {
            get(attributeName, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String attributeName, String value) {
            get(attributeName, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(value);
        }

        public void applyDelta(Constraint c2) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.applyDelta(c2);
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams param) {
            Layout layout = this.layout;
            param.leftToLeft = layout.leftToLeft;
            param.leftToRight = layout.leftToRight;
            param.rightToLeft = layout.rightToLeft;
            param.rightToRight = layout.rightToRight;
            param.topToTop = layout.topToTop;
            param.topToBottom = layout.topToBottom;
            param.bottomToTop = layout.bottomToTop;
            param.bottomToBottom = layout.bottomToBottom;
            param.baselineToBaseline = layout.baselineToBaseline;
            param.baselineToTop = layout.baselineToTop;
            param.baselineToBottom = layout.baselineToBottom;
            param.startToEnd = layout.startToEnd;
            param.startToStart = layout.startToStart;
            param.endToStart = layout.endToStart;
            param.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) param).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) param).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) param).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) param).bottomMargin = layout.bottomMargin;
            param.goneStartMargin = layout.goneStartMargin;
            param.goneEndMargin = layout.goneEndMargin;
            param.goneTopMargin = layout.goneTopMargin;
            param.goneBottomMargin = layout.goneBottomMargin;
            param.horizontalBias = layout.horizontalBias;
            param.verticalBias = layout.verticalBias;
            Layout layout2 = this.layout;
            param.circleConstraint = layout2.circleConstraint;
            param.circleRadius = layout2.circleRadius;
            param.circleAngle = layout2.circleAngle;
            param.dimensionRatio = layout2.dimensionRatio;
            param.editorAbsoluteX = layout2.editorAbsoluteX;
            param.editorAbsoluteY = layout2.editorAbsoluteY;
            param.verticalWeight = layout2.verticalWeight;
            param.horizontalWeight = layout2.horizontalWeight;
            param.verticalChainStyle = layout2.verticalChainStyle;
            param.horizontalChainStyle = layout2.horizontalChainStyle;
            param.constrainedWidth = layout2.constrainedWidth;
            param.constrainedHeight = layout2.constrainedHeight;
            param.matchConstraintDefaultWidth = layout2.widthDefault;
            param.matchConstraintDefaultHeight = layout2.heightDefault;
            param.matchConstraintMaxWidth = layout2.widthMax;
            param.matchConstraintMaxHeight = layout2.heightMax;
            param.matchConstraintMinWidth = layout2.widthMin;
            param.matchConstraintMinHeight = layout2.heightMin;
            param.matchConstraintPercentWidth = layout2.widthPercent;
            param.matchConstraintPercentHeight = layout2.heightPercent;
            param.orientation = layout2.orientation;
            param.guidePercent = layout2.guidePercent;
            param.guideBegin = layout2.guideBegin;
            param.guideEnd = layout2.guideEnd;
            ((ViewGroup.MarginLayoutParams) param).width = layout2.mWidth;
            Layout layout3 = this.layout;
            ((ViewGroup.MarginLayoutParams) param).height = layout3.mHeight;
            String str = layout3.mConstraintTag;
            if (str != null) {
                param.constraintTag = str;
            }
            param.wrapBehaviorInParent = layout3.mWrapBehavior;
            if (Build.VERSION.SDK_INT >= 17) {
                param.setMarginStart(layout3.startMargin);
                param.setMarginEnd(this.layout.endMargin);
            }
            param.validate();
        }

        public void printDelta(String tag) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.printDelta(tag);
            } else {
                Log.v(tag, "DELTA IS NULL");
            }
        }

        /* renamed from: clone */
        public Constraint m5clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            constraint.mDelta = this.mDelta;
            return constraint;
        }

        /* loaded from: classes.dex */
        public static class Delta {
            private static final int INITIAL_BOOLEAN = 4;
            private static final int INITIAL_FLOAT = 10;
            private static final int INITIAL_INT = 10;
            private static final int INITIAL_STRING = 5;
            public int[] mTypeInt = new int[10];
            public int[] mValueInt = new int[10];
            public int mCountInt = 0;
            public int[] mTypeFloat = new int[10];
            public float[] mValueFloat = new float[10];
            public int mCountFloat = 0;
            public int[] mTypeString = new int[5];
            public String[] mValueString = new String[5];
            public int mCountString = 0;
            public int[] mTypeBoolean = new int[4];
            public boolean[] mValueBoolean = new boolean[4];
            public int mCountBoolean = 0;

            public void add(int type, int value) {
                int i2 = this.mCountInt;
                int[] iArr = this.mTypeInt;
                if (i2 >= iArr.length) {
                    this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.mValueInt;
                    this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.mTypeInt;
                int i3 = this.mCountInt;
                iArr3[i3] = type;
                int[] iArr4 = this.mValueInt;
                this.mCountInt = i3 + 1;
                iArr4[i3] = value;
            }

            public void applyDelta(Constraint c2) {
                for (int i2 = 0; i2 < this.mCountInt; i2++) {
                    ConstraintSet.setDeltaValue(c2, this.mTypeInt[i2], this.mValueInt[i2]);
                }
                for (int i3 = 0; i3 < this.mCountFloat; i3++) {
                    ConstraintSet.setDeltaValue(c2, this.mTypeFloat[i3], this.mValueFloat[i3]);
                }
                for (int i4 = 0; i4 < this.mCountString; i4++) {
                    ConstraintSet.setDeltaValue(c2, this.mTypeString[i4], this.mValueString[i4]);
                }
                for (int i5 = 0; i5 < this.mCountBoolean; i5++) {
                    ConstraintSet.setDeltaValue(c2, this.mTypeBoolean[i5], this.mValueBoolean[i5]);
                }
            }

            @SuppressLint({"LogConditional"})
            public void printDelta(String tag) {
                Log.v(tag, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                for (int i2 = 0; i2 < this.mCountInt; i2++) {
                    int i3 = this.mTypeInt[i2];
                    int i4 = this.mValueInt[i2];
                    StringBuilder sb = new StringBuilder(25);
                    sb.append(i3);
                    sb.append(" = ");
                    sb.append(i4);
                    Log.v(tag, sb.toString());
                }
                Log.v(tag, "float");
                for (int i5 = 0; i5 < this.mCountFloat; i5++) {
                    int i6 = this.mTypeFloat[i5];
                    float f2 = this.mValueFloat[i5];
                    StringBuilder sb2 = new StringBuilder(29);
                    sb2.append(i6);
                    sb2.append(" = ");
                    sb2.append(f2);
                    Log.v(tag, sb2.toString());
                }
                Log.v(tag, "strings");
                for (int i7 = 0; i7 < this.mCountString; i7++) {
                    int i8 = this.mTypeString[i7];
                    String str = this.mValueString[i7];
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 14);
                    sb3.append(i8);
                    sb3.append(" = ");
                    sb3.append(str);
                    Log.v(tag, sb3.toString());
                }
                Log.v(tag, "boolean");
                for (int i9 = 0; i9 < this.mCountBoolean; i9++) {
                    int i10 = this.mTypeBoolean[i9];
                    boolean z = this.mValueBoolean[i9];
                    StringBuilder sb4 = new StringBuilder(19);
                    sb4.append(i10);
                    sb4.append(" = ");
                    sb4.append(z);
                    Log.v(tag, sb4.toString());
                }
            }

            public void add(int type, float value) {
                int i2 = this.mCountFloat;
                int[] iArr = this.mTypeFloat;
                if (i2 >= iArr.length) {
                    this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.mValueFloat;
                    this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.mTypeFloat;
                int i3 = this.mCountFloat;
                iArr2[i3] = type;
                float[] fArr2 = this.mValueFloat;
                this.mCountFloat = i3 + 1;
                fArr2[i3] = value;
            }

            public void add(int type, String value) {
                int i2 = this.mCountString;
                int[] iArr = this.mTypeString;
                if (i2 >= iArr.length) {
                    this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.mValueString;
                    this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.mTypeString;
                int i3 = this.mCountString;
                iArr2[i3] = type;
                String[] strArr2 = this.mValueString;
                this.mCountString = i3 + 1;
                strArr2[i3] = value;
            }

            public void add(int type, boolean value) {
                int i2 = this.mCountBoolean;
                int[] iArr = this.mTypeBoolean;
                if (i2 >= iArr.length) {
                    this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.mValueBoolean;
                    this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.mTypeBoolean;
                int i3 = this.mCountBoolean;
                iArr2[i3] = type;
                boolean[] zArr2 = this.mValueBoolean;
                this.mCountBoolean = i3 + 1;
                zArr2[i3] = value;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int viewId, Constraints.LayoutParams param) {
            fillFrom(viewId, param);
            this.propertySet.alpha = param.alpha;
            Transform transform = this.transform;
            transform.rotation = param.rotation;
            transform.rotationX = param.rotationX;
            transform.rotationY = param.rotationY;
            transform.scaleX = param.scaleX;
            transform.scaleY = param.scaleY;
            transform.transformPivotX = param.transformPivotX;
            transform.transformPivotY = param.transformPivotY;
            transform.translationX = param.translationX;
            transform.translationY = param.translationY;
            transform.translationZ = param.translationZ;
            transform.elevation = param.elevation;
            transform.applyElevation = param.applyElevation;
        }
    }

    /* loaded from: classes.dex */
    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_CONSTRAINT_HEIGHT = 42;
        private static final int LAYOUT_CONSTRAINT_WIDTH = 41;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
        private static final int UNUSED = 76;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public boolean mOverride = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int baselineToTop = -1;
        public int baselineToBottom = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = 0;
        public int rightMargin = 0;
        public int topMargin = 0;
        public int bottomMargin = 0;
        public int endMargin = 0;
        public int startMargin = 0;
        public int baselineMargin = 0;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = 0;
        public int heightMax = 0;
        public int widthMin = 0;
        public int heightMin = 0;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mWrapBehavior = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_constrainedWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constrainedHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, 97);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void copyFrom(Layout src) {
            this.mIsGuideline = src.mIsGuideline;
            this.mWidth = src.mWidth;
            this.mApply = src.mApply;
            this.mHeight = src.mHeight;
            this.guideBegin = src.guideBegin;
            this.guideEnd = src.guideEnd;
            this.guidePercent = src.guidePercent;
            this.leftToLeft = src.leftToLeft;
            this.leftToRight = src.leftToRight;
            this.rightToLeft = src.rightToLeft;
            this.rightToRight = src.rightToRight;
            this.topToTop = src.topToTop;
            this.topToBottom = src.topToBottom;
            this.bottomToTop = src.bottomToTop;
            this.bottomToBottom = src.bottomToBottom;
            this.baselineToBaseline = src.baselineToBaseline;
            this.baselineToTop = src.baselineToTop;
            this.baselineToBottom = src.baselineToBottom;
            this.startToEnd = src.startToEnd;
            this.startToStart = src.startToStart;
            this.endToStart = src.endToStart;
            this.endToEnd = src.endToEnd;
            this.horizontalBias = src.horizontalBias;
            this.verticalBias = src.verticalBias;
            this.dimensionRatio = src.dimensionRatio;
            this.circleConstraint = src.circleConstraint;
            this.circleRadius = src.circleRadius;
            this.circleAngle = src.circleAngle;
            this.editorAbsoluteX = src.editorAbsoluteX;
            this.editorAbsoluteY = src.editorAbsoluteY;
            this.orientation = src.orientation;
            this.leftMargin = src.leftMargin;
            this.rightMargin = src.rightMargin;
            this.topMargin = src.topMargin;
            this.bottomMargin = src.bottomMargin;
            this.endMargin = src.endMargin;
            this.startMargin = src.startMargin;
            this.baselineMargin = src.baselineMargin;
            this.goneLeftMargin = src.goneLeftMargin;
            this.goneTopMargin = src.goneTopMargin;
            this.goneRightMargin = src.goneRightMargin;
            this.goneBottomMargin = src.goneBottomMargin;
            this.goneEndMargin = src.goneEndMargin;
            this.goneStartMargin = src.goneStartMargin;
            this.goneBaselineMargin = src.goneBaselineMargin;
            this.verticalWeight = src.verticalWeight;
            this.horizontalWeight = src.horizontalWeight;
            this.horizontalChainStyle = src.horizontalChainStyle;
            this.verticalChainStyle = src.verticalChainStyle;
            this.widthDefault = src.widthDefault;
            this.heightDefault = src.heightDefault;
            this.widthMax = src.widthMax;
            this.heightMax = src.heightMax;
            this.widthMin = src.widthMin;
            this.heightMin = src.heightMin;
            this.widthPercent = src.widthPercent;
            this.heightPercent = src.heightPercent;
            this.mBarrierDirection = src.mBarrierDirection;
            this.mBarrierMargin = src.mBarrierMargin;
            this.mHelperType = src.mHelperType;
            this.mConstraintTag = src.mConstraintTag;
            int[] iArr = src.mReferenceIds;
            if (iArr != null && src.mReferenceIdString == null) {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = src.mReferenceIdString;
            this.constrainedWidth = src.constrainedWidth;
            this.constrainedHeight = src.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = src.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = src.mWrapBehavior;
        }

        public void dump(MotionScene scene, StringBuilder stringBuilder) {
            Field[] declaredFields = getClass().getDeclaredFields();
            stringBuilder.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object lookUpConstraintName = scene.lookUpConstraintName(num.intValue());
                                stringBuilder.append("    ");
                                stringBuilder.append(name);
                                stringBuilder.append(" = \"");
                                stringBuilder.append(lookUpConstraintName == null ? num : lookUpConstraintName);
                                stringBuilder.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f2 = (Float) obj;
                            if (f2.floatValue() != -1.0f) {
                                stringBuilder.append("    ");
                                stringBuilder.append(name);
                                stringBuilder.append(" = \"");
                                stringBuilder.append(f2);
                                stringBuilder.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            int i2 = Build.VERSION.SDK_INT;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = mapToConstant.get(index);
                if (i4 == 80) {
                    this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                } else if (i4 == 81) {
                    this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                } else if (i4 != 97) {
                    switch (i4) {
                        case 1:
                            this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                            continue;
                        case 2:
                            this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                            continue;
                        case 3:
                            this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                            continue;
                        case 4:
                            this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                            continue;
                        case 5:
                            this.dimensionRatio = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                            continue;
                        case 7:
                            this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                            continue;
                        case 8:
                            if (i2 >= 17) {
                                this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                            continue;
                        case 10:
                            this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                            continue;
                        case 11:
                            this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                            continue;
                        case 12:
                            this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                            continue;
                        case 13:
                            this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                            continue;
                        case 14:
                            this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                            continue;
                        case 15:
                            this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                            continue;
                        case 16:
                            this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                            continue;
                        case 17:
                            this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                            continue;
                        case 18:
                            this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                            continue;
                        case 19:
                            this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                            continue;
                        case 20:
                            this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                            continue;
                        case 21:
                            this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                            continue;
                        case 22:
                            this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                            continue;
                        case 23:
                            this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                            continue;
                        case 24:
                            this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                            continue;
                        case 25:
                            this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                            continue;
                        case 26:
                            this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                            continue;
                        case 27:
                            this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                            continue;
                        case 28:
                            this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                            continue;
                        case 29:
                            this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                            continue;
                        case 30:
                            if (i2 >= 17) {
                                this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                                break;
                            } else {
                                continue;
                            }
                        case 31:
                            this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                            continue;
                        case 32:
                            this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                            continue;
                        case 33:
                            this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                            continue;
                        case 34:
                            this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                            continue;
                        case 35:
                            this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                            continue;
                        case 36:
                            this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                            continue;
                        case 37:
                            this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                            continue;
                        case 38:
                            this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                            continue;
                        case 39:
                            this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                            continue;
                        case 40:
                            this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                            continue;
                        case 41:
                            ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 0);
                            continue;
                        case 42:
                            ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 1);
                            continue;
                        default:
                            switch (i4) {
                                case 54:
                                    this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                    continue;
                                case 55:
                                    this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                    continue;
                                case 56:
                                    this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                    continue;
                                case 57:
                                    this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                    continue;
                                case 58:
                                    this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                    continue;
                                case 59:
                                    this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                    continue;
                                default:
                                    switch (i4) {
                                        case 61:
                                            this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                            continue;
                                        case 62:
                                            this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                            continue;
                                        case 63:
                                            this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                            continue;
                                        default:
                                            switch (i4) {
                                                case 69:
                                                    this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                    continue;
                                                case 73:
                                                    this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                    continue;
                                                case 74:
                                                    this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                    continue;
                                                case 76:
                                                    String hexString = Integer.toHexString(index);
                                                    int i5 = mapToConstant.get(index);
                                                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 33);
                                                    sb.append("unused attribute 0x");
                                                    sb.append(hexString);
                                                    sb.append("   ");
                                                    sb.append(i5);
                                                    Log.w(ConstraintSet.TAG, sb.toString());
                                                    continue;
                                                case 77:
                                                    this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    switch (i4) {
                                                        case 91:
                                                            this.baselineToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToTop);
                                                            continue;
                                                        case 92:
                                                            this.baselineToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBottom);
                                                            continue;
                                                        case 93:
                                                            this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                                            continue;
                                                        case 94:
                                                            this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                                            continue;
                                                        default:
                                                            String hexString2 = Integer.toHexString(index);
                                                            int i6 = mapToConstant.get(index);
                                                            StringBuilder sb2 = new StringBuilder(String.valueOf(hexString2).length() + 34);
                                                            sb2.append("Unknown attribute 0x");
                                                            sb2.append(hexString2);
                                                            sb2.append("   ");
                                                            sb2.append(i6);
                                                            Log.w(ConstraintSet.TAG, sb2.toString());
                                                            continue;
                                                            continue;
                                                            continue;
                                                            continue;
                                                            continue;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    this.mWrapBehavior = obtainStyledAttributes.getInt(index, this.mWrapBehavior);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class Motion {
        private static final int ANIMATE_CIRCLE_ANGLE_TO = 6;
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 7;
        private static final int PATH_MOTION_ARC = 2;
        private static final int QUANTIZE_MOTION_INTERPOLATOR = 10;
        private static final int QUANTIZE_MOTION_PHASE = 9;
        private static final int QUANTIZE_MOTION_STEPS = 8;
        private static final int SPLINE_STRING = -1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R.styleable.Motion_motionStagger, 7);
            mapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void copyFrom(Motion src) {
            this.mApply = src.mApply;
            this.mAnimateRelativeTo = src.mAnimateRelativeTo;
            this.mTransitionEasing = src.mTransitionEasing;
            this.mPathMotionArc = src.mPathMotionArc;
            this.mDrawPath = src.mDrawPath;
            this.mPathRotate = src.mPathRotate;
            this.mMotionStagger = src.mMotionStagger;
            this.mPolarRelativeTo = src.mPolarRelativeTo;
        }

        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i3 = obtainStyledAttributes.peekValue(index).type;
                        if (i3 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId != -1) {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i3 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.mQuantizeInterpolatorString = string;
                            if (string.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) > 0) {
                                this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -1;
                                break;
                            }
                        } else {
                            this.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public void copyFrom(PropertySet src) {
            this.mApply = src.mApply;
            this.visibility = src.visibility;
            this.alpha = src.alpha;
            this.mProgress = src.mProgress;
            this.mVisibilityMode = src.mVisibilityMode;
        }

        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_TARGET = 12;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public int transformPivotTarget = -1;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
            mapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void copyFrom(Transform src) {
            this.mApply = src.mApply;
            this.rotation = src.rotation;
            this.rotationX = src.rotationX;
            this.rotationY = src.rotationY;
            this.scaleX = src.scaleX;
            this.scaleY = src.scaleY;
            this.transformPivotX = src.transformPivotX;
            this.transformPivotY = src.transformPivotY;
            this.transformPivotTarget = src.transformPivotTarget;
            this.translationX = src.translationX;
            this.translationY = src.translationY;
            this.translationZ = src.translationZ;
            this.applyElevation = src.applyElevation;
            this.elevation = src.elevation;
        }

        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            int i2 = Build.VERSION.SDK_INT;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        if (i2 >= 21) {
                            this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (i2 >= 21) {
                            this.applyElevation = true;
                            this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.transformPivotTarget = ConstraintSet.lookupID(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public class WriteXmlEngine {
        private static final String SPACE = "\n       ";
        public Context context;
        public int flags;
        public ConstraintLayout layout;
        public Writer writer;
        public int unknownCount = 0;
        public final String LEFT = "'left'";
        public final String RIGHT = "'right'";
        public final String BASELINE = "'baseline'";
        public final String BOTTOM = "'bottom'";
        public final String TOP = "'top'";
        public final String START = "'start'";
        public final String END = "'end'";
        public HashMap<Integer, String> idMap = new HashMap<>();

        public WriteXmlEngine(Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.writer = writer;
            this.layout = layout;
            this.context = layout.getContext();
            this.flags = flags;
        }

        private void writeBaseDimension(String dimString, int dim, int def) throws IOException {
            if (dim != def) {
                if (dim == -2) {
                    Writer writer = this.writer;
                    StringBuilder sb = new StringBuilder(String.valueOf(dimString).length() + 23);
                    sb.append(SPACE);
                    sb.append(dimString);
                    sb.append("=\"wrap_content\"");
                    writer.write(sb.toString());
                } else if (dim == -1) {
                    Writer writer2 = this.writer;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(dimString).length() + 23);
                    sb2.append(SPACE);
                    sb2.append(dimString);
                    sb2.append("=\"match_parent\"");
                    writer2.write(sb2.toString());
                } else {
                    Writer writer3 = this.writer;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(dimString).length() + 24);
                    sb3.append(SPACE);
                    sb3.append(dimString);
                    sb3.append("=\"");
                    sb3.append(dim);
                    sb3.append("dp\"");
                    writer3.write(sb3.toString());
                }
            }
        }

        private void writeBoolen(String dimString, boolean val, boolean def) throws IOException {
            if (val != def) {
                Writer writer = this.writer;
                StringBuilder sb = new StringBuilder(String.valueOf(dimString).length() + 18);
                sb.append(SPACE);
                sb.append(dimString);
                sb.append("=\"");
                sb.append(val);
                sb.append("dp\"");
                writer.write(sb.toString());
            }
        }

        private void writeDimension(String dimString, int dim, int def) throws IOException {
            if (dim != def) {
                Writer writer = this.writer;
                StringBuilder sb = new StringBuilder(String.valueOf(dimString).length() + 24);
                sb.append(SPACE);
                sb.append(dimString);
                sb.append("=\"");
                sb.append(dim);
                sb.append("dp\"");
                writer.write(sb.toString());
            }
        }

        private void writeEnum(String dimString, int val, String[] types, int def) throws IOException {
            if (val != def) {
                Writer writer = this.writer;
                String str = types[val];
                StringBuilder sb = new StringBuilder(String.valueOf(dimString).length() + 11 + String.valueOf(str).length());
                sb.append(SPACE);
                sb.append(dimString);
                sb.append("=\"");
                sb.append(str);
                sb.append("\"");
                writer.write(sb.toString());
            }
        }

        public String getName(int id) {
            if (this.idMap.containsKey(Integer.valueOf(id))) {
                String str = this.idMap.get(Integer.valueOf(id));
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5);
                sb.append("@+id/");
                sb.append(str);
                return sb.toString();
            } else if (id == 0) {
                return ConstraintSet.KEY_PERCENT_PARENT;
            } else {
                String lookup = lookup(id);
                this.idMap.put(Integer.valueOf(id), lookup);
                StringBuilder sb2 = new StringBuilder(String.valueOf(lookup).length() + 5);
                sb2.append("@+id/");
                sb2.append(lookup);
                return sb2.toString();
            }
        }

        public String lookup(int id) {
            try {
                if (id != -1) {
                    return this.context.getResources().getResourceEntryName(id);
                }
                int i2 = this.unknownCount + 1;
                this.unknownCount = i2;
                StringBuilder sb = new StringBuilder(18);
                sb.append("unknown");
                sb.append(i2);
                return sb.toString();
            } catch (Exception unused) {
                int i3 = this.unknownCount + 1;
                this.unknownCount = i3;
                StringBuilder sb2 = new StringBuilder(18);
                sb2.append("unknown");
                sb2.append(i3);
                return sb2.toString();
            }
        }

        public void writeCircle(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint == -1) {
                return;
            }
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(circleConstraint));
            Writer writer = this.writer;
            StringBuilder sb = new StringBuilder(17);
            sb.append(", ");
            sb.append(circleAngle);
            writer.write(sb.toString());
            Writer writer2 = this.writer;
            StringBuilder sb2 = new StringBuilder(12);
            sb2.append(circleRadius);
            sb2.append("]");
            writer2.write(sb2.toString());
        }

        public void writeConstraint(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(my);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            this.writer.write(":[");
            this.writer.write(getName(leftToLeft));
            this.writer.write(" , ");
            this.writer.write(other);
            if (margin != 0) {
                Writer writer2 = this.writer;
                StringBuilder sb = new StringBuilder(14);
                sb.append(" , ");
                sb.append(margin);
                writer2.write(sb.toString());
            }
            this.writer.write("],\n");
        }

        public void writeLayout() throws IOException {
            this.writer.write("\n<ConstraintSet>\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                String name = getName(num.intValue());
                this.writer.write("  <Constraint");
                Writer writer = this.writer;
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
                sb.append("\n       android:id=\"");
                sb.append(name);
                sb.append("\"");
                writer.write(sb.toString());
                Layout layout = ((Constraint) ConstraintSet.this.mConstraints.get(num)).layout;
                writeBaseDimension("android:layout_width", layout.mWidth, -5);
                writeBaseDimension("android:layout_height", layout.mHeight, -5);
                writeVariable("app:layout_constraintGuide_begin", layout.guideBegin, -1.0f);
                writeVariable("app:layout_constraintGuide_end", layout.guideEnd, -1.0f);
                writeVariable("app:layout_constraintGuide_percent", layout.guidePercent, -1.0f);
                writeVariable("app:layout_constraintHorizontal_bias", layout.horizontalBias, 0.5f);
                writeVariable("app:layout_constraintVertical_bias", layout.verticalBias, 0.5f);
                writeVariable("app:layout_constraintDimensionRatio", layout.dimensionRatio, (String) null);
                writeXmlConstraint("app:layout_constraintCircle", layout.circleConstraint);
                writeVariable("app:layout_constraintCircleRadius", layout.circleRadius, 0.0f);
                writeVariable("app:layout_constraintCircleAngle", layout.circleAngle, 0.0f);
                writeVariable("android:orientation", layout.orientation, -1.0f);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle, 0.0f);
                writeVariable("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle, 0.0f);
                writeVariable("app:barrierDirection", layout.mBarrierDirection, -1.0f);
                writeVariable("app:barrierMargin", layout.mBarrierMargin, 0.0f);
                writeDimension("app:layout_marginLeft", layout.leftMargin, 0);
                writeDimension("app:layout_goneMarginLeft", layout.goneLeftMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginRight", layout.rightMargin, 0);
                writeDimension("app:layout_goneMarginRight", layout.goneRightMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginStart", layout.startMargin, 0);
                writeDimension("app:layout_goneMarginStart", layout.goneStartMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginEnd", layout.endMargin, 0);
                writeDimension("app:layout_goneMarginEnd", layout.goneEndMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginTop", layout.topMargin, 0);
                writeDimension("app:layout_goneMarginTop", layout.goneTopMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginBottom", layout.bottomMargin, 0);
                writeDimension("app:layout_goneMarginBottom", layout.goneBottomMargin, Integer.MIN_VALUE);
                writeDimension("app:goneBaselineMargin", layout.goneBaselineMargin, Integer.MIN_VALUE);
                writeDimension("app:baselineMargin", layout.baselineMargin, 0);
                writeBoolen("app:layout_constrainedWidth", layout.constrainedWidth, false);
                writeBoolen("app:layout_constrainedHeight", layout.constrainedHeight, false);
                writeBoolen("app:barrierAllowsGoneWidgets", layout.mBarrierAllowsGoneWidgets, true);
                writeVariable("app:layout_wrapBehaviorInParent", layout.mWrapBehavior, 0.0f);
                writeXmlConstraint("app:baselineToBaseline", layout.baselineToBaseline);
                writeXmlConstraint("app:baselineToBottom", layout.baselineToBottom);
                writeXmlConstraint("app:baselineToTop", layout.baselineToTop);
                writeXmlConstraint("app:layout_constraintBottom_toBottomOf", layout.bottomToBottom);
                writeXmlConstraint("app:layout_constraintBottom_toTopOf", layout.bottomToTop);
                writeXmlConstraint("app:layout_constraintEnd_toEndOf", layout.endToEnd);
                writeXmlConstraint("app:layout_constraintEnd_toStartOf", layout.endToStart);
                writeXmlConstraint("app:layout_constraintLeft_toLeftOf", layout.leftToLeft);
                writeXmlConstraint("app:layout_constraintLeft_toRightOf", layout.leftToRight);
                writeXmlConstraint("app:layout_constraintRight_toLeftOf", layout.rightToLeft);
                writeXmlConstraint("app:layout_constraintRight_toRightOf", layout.rightToRight);
                writeXmlConstraint("app:layout_constraintStart_toEndOf", layout.startToEnd);
                writeXmlConstraint("app:layout_constraintStart_toStartOf", layout.startToStart);
                writeXmlConstraint("app:layout_constraintTop_toBottomOf", layout.topToBottom);
                writeXmlConstraint("app:layout_constraintTop_toTopOf", layout.topToTop);
                String[] strArr = {"spread", "wrap", "percent"};
                writeEnum("app:layout_constraintHeight_default", layout.heightDefault, strArr, 0);
                writeVariable("app:layout_constraintHeight_percent", layout.heightPercent, 1.0f);
                writeDimension("app:layout_constraintHeight_min", layout.heightMin, 0);
                writeDimension("app:layout_constraintHeight_max", layout.heightMax, 0);
                writeBoolen("android:layout_constrainedHeight", layout.constrainedHeight, false);
                writeEnum("app:layout_constraintWidth_default", layout.widthDefault, strArr, 0);
                writeVariable("app:layout_constraintWidth_percent", layout.widthPercent, 1.0f);
                writeDimension("app:layout_constraintWidth_min", layout.widthMin, 0);
                writeDimension("app:layout_constraintWidth_max", layout.widthMax, 0);
                writeBoolen("android:layout_constrainedWidth", layout.constrainedWidth, false);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle);
                writeVariable("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle);
                writeEnum("app:barrierDirection", layout.mBarrierDirection, new String[]{"left", "right", "top", "bottom", MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END}, -1);
                writeVariable("app:layout_constraintTag", layout.mConstraintTag, (String) null);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writeVariable("'ReferenceIds'", iArr);
                }
                this.writer.write(" />\n");
            }
            this.writer.write("</ConstraintSet>\n");
        }

        public void writeVariable(String name, int value) throws IOException {
            if (value == 0 || value == -1) {
                return;
            }
            Writer writer = this.writer;
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 23);
            sb.append(SPACE);
            sb.append(name);
            sb.append("=\"");
            sb.append(value);
            sb.append("\"\n");
            writer.write(sb.toString());
        }

        public void writeXmlConstraint(String str, int leftToLeft) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(str);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            Writer writer2 = this.writer;
            String name = getName(leftToLeft);
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 3);
            sb.append("=\"");
            sb.append(name);
            sb.append("\"");
            writer2.write(sb.toString());
        }

        public void writeVariable(String name, float value, float def) throws IOException {
            if (value == def) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            Writer writer2 = this.writer;
            StringBuilder sb = new StringBuilder(18);
            sb.append("=\"");
            sb.append(value);
            sb.append("\"");
            writer2.write(sb.toString());
        }

        public void writeVariable(String name, String value, String def) throws IOException {
            if (value == null || value.equals(def)) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            Writer writer2 = this.writer;
            StringBuilder sb = new StringBuilder(String.valueOf(value).length() + 3);
            sb.append("=\"");
            sb.append(value);
            sb.append("\"");
            writer2.write(sb.toString());
        }

        public void writeVariable(String name, int[] value) throws IOException {
            if (value == null) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            this.writer.write(Constants.COLON_SEPARATOR);
            int i2 = 0;
            while (i2 < value.length) {
                Writer writer2 = this.writer;
                String str = i2 == 0 ? "[" : ", ";
                String valueOf2 = String.valueOf(getName(value[i2]));
                writer2.write(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                i2++;
            }
            this.writer.write("],\n");
        }

        public void writeVariable(String name, String value) throws IOException {
            if (value == null) {
                return;
            }
            this.writer.write(name);
            this.writer.write(Constants.COLON_SEPARATOR);
            Writer writer = this.writer;
            String valueOf = String.valueOf(value);
            writer.write(valueOf.length() != 0 ? ", ".concat(valueOf) : new String(", "));
            this.writer.write("\n");
        }
    }

    static {
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth, 95);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight, 96);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        mapToConstant.append(R.styleable.Constraint_polarRelativeTo, 82);
        mapToConstant.append(R.styleable.Constraint_transformPivotTarget, 83);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = overrideMapToConstant;
        int i2 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i2, 6);
        overrideMapToConstant.append(i2, 7);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, 60);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, 79);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, 98);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, 68);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... attributeName) {
        for (int i2 = 0; i2 < attributeName.length; i2++) {
            if (this.mSavedAttributes.containsKey(attributeName[i2])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(attributeName[i2]);
                if (constraintAttribute != null && constraintAttribute.getType() != attributeType) {
                    String valueOf = String.valueOf(constraintAttribute.getType().name());
                    throw new IllegalArgumentException(valueOf.length() != 0 ? "ConstraintAttribute is already a ".concat(valueOf) : new String("ConstraintAttribute is already a "));
                }
            } else {
                this.mSavedAttributes.put(attributeName[i2], new ConstraintAttribute(attributeName[i2], attributeType));
            }
        }
    }

    public static Constraint buildDelta(Context context, XmlPullParser parser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(parser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        populateOverride(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private int[] convertReferenceString(View view, String referenceIdString) {
        int i2;
        Object designInformation;
        String[] split = referenceIdString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i2 = ((Integer) designInformation).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attrs, boolean override) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, override ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        populateConstraint(context, constraint, obtainStyledAttributes, override);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint get(int id) {
        if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
            this.mConstraints.put(Integer.valueOf(id), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(id));
    }

    public static String getDebugName(int v) {
        Field[] declaredFields;
        for (Field field : ConstraintSet.class.getDeclaredFields()) {
            if (field.getName().contains("_") && field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    if (field.getInt(null) == v) {
                        return field.getName();
                    }
                    continue;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public static String getLine(Context context, int resourceId, XmlPullParser pullParser) {
        String name = Debug.getName(context, resourceId);
        int lineNumber = pullParser.getLineNumber();
        String name2 = pullParser.getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 22 + String.valueOf(name2).length());
        sb.append(".(");
        sb.append(name);
        sb.append(".xml:");
        sb.append(lineNumber);
        sb.append(") \"");
        sb.append(name2);
        sb.append("\"");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lookupID(TypedArray a, int index, int def) {
        int resourceId = a.getResourceId(index, def);
        return resourceId == -1 ? a.getInt(index, -1) : resourceId;
    }

    public static void parseDimensionConstraints(Object data, TypedArray a, int attr, int orientation) {
        if (data == null) {
            return;
        }
        int i2 = a.peekValue(attr).type;
        if (i2 != 3) {
            int i3 = -2;
            boolean z = false;
            if (i2 != 5) {
                int i4 = a.getInt(attr, 0);
                if (i4 != -4) {
                    i3 = (i4 == -3 || !(i4 == -2 || i4 == -1)) ? 0 : i4;
                } else {
                    z = true;
                }
            } else {
                i3 = a.getDimensionPixelSize(attr, 0);
            }
            if (data instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) data;
                if (orientation == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i3;
                    layoutParams.constrainedWidth = z;
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).height = i3;
                layoutParams.constrainedHeight = z;
                return;
            } else if (data instanceof Layout) {
                Layout layout = (Layout) data;
                if (orientation == 0) {
                    layout.mWidth = i3;
                    layout.constrainedWidth = z;
                    return;
                }
                layout.mHeight = i3;
                layout.constrainedHeight = z;
                return;
            } else if (data instanceof Constraint.Delta) {
                Constraint.Delta delta = (Constraint.Delta) data;
                if (orientation == 0) {
                    delta.add(23, i3);
                    delta.add(80, z);
                    return;
                }
                delta.add(21, i3);
                delta.add(81, z);
                return;
            } else {
                return;
            }
        }
        parseDimensionConstraintsString(data, a.getString(attr), orientation);
    }

    public static void parseDimensionConstraintsString(Object data, String value, int orientation) {
        if (value == null) {
            return;
        }
        int indexOf = value.indexOf(61);
        int length = value.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = value.substring(0, indexOf);
        String substring2 = value.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if (KEY_RATIO.equalsIgnoreCase(trim)) {
                if (data instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) data;
                    if (orientation == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                    }
                    parseDimensionRatioString(layoutParams, trim2);
                    return;
                } else if (data instanceof Layout) {
                    ((Layout) data).dimensionRatio = trim2;
                    return;
                } else if (data instanceof Constraint.Delta) {
                    ((Constraint.Delta) data).add(5, trim2);
                    return;
                } else {
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (data instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                            layoutParams2.horizontalWeight = parseFloat;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                            layoutParams2.verticalWeight = parseFloat;
                        }
                    } else if (data instanceof Layout) {
                        Layout layout = (Layout) data;
                        if (orientation == 0) {
                            layout.mWidth = 0;
                            layout.horizontalWeight = parseFloat;
                        } else {
                            layout.mHeight = 0;
                            layout.verticalWeight = parseFloat;
                        }
                    } else if (data instanceof Constraint.Delta) {
                        Constraint.Delta delta = (Constraint.Delta) data;
                        if (orientation == 0) {
                            delta.add(23, 0);
                            delta.add(39, parseFloat);
                        } else {
                            delta.add(21, 0);
                            delta.add(40, parseFloat);
                        }
                    }
                } else if (!KEY_PERCENT_PARENT.equalsIgnoreCase(trim)) {
                } else {
                    float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (data instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                            layoutParams3.matchConstraintPercentWidth = max;
                            layoutParams3.matchConstraintDefaultWidth = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                            layoutParams3.matchConstraintPercentHeight = max;
                            layoutParams3.matchConstraintDefaultHeight = 2;
                        }
                    } else if (data instanceof Layout) {
                        Layout layout2 = (Layout) data;
                        if (orientation == 0) {
                            layout2.mWidth = 0;
                            layout2.widthPercent = max;
                            layout2.widthDefault = 2;
                        } else {
                            layout2.mHeight = 0;
                            layout2.heightPercent = max;
                            layout2.heightDefault = 2;
                        }
                    } else if (data instanceof Constraint.Delta) {
                        Constraint.Delta delta2 = (Constraint.Delta) data;
                        if (orientation == 0) {
                            delta2.add(23, 0);
                            delta2.add(54, 2);
                        } else {
                            delta2.add(21, 0);
                            delta2.add(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void parseDimensionRatioString(ConstraintLayout.LayoutParams params, String value) {
        float f2 = Float.NaN;
        int i2 = -1;
        if (value != null) {
            int length = value.length();
            int indexOf = value.indexOf(44);
            int i3 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = value.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i2 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i2 = 1;
                }
                i3 = indexOf + 1;
            }
            int indexOf2 = value.indexOf(58);
            try {
                if (indexOf2 >= 0 && indexOf2 < length - 1) {
                    String substring2 = value.substring(i3, indexOf2);
                    String substring3 = value.substring(indexOf2 + 1);
                    if (substring2.length() > 0 && substring3.length() > 0) {
                        float parseFloat = Float.parseFloat(substring2);
                        float parseFloat2 = Float.parseFloat(substring3);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i2 == 1) {
                                f2 = Math.abs(parseFloat2 / parseFloat);
                            } else {
                                f2 = Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                } else {
                    String substring4 = value.substring(i3);
                    if (substring4.length() > 0) {
                        f2 = Float.parseFloat(substring4);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        params.dimensionRatio = value;
        params.dimensionRatioValue = f2;
        params.dimensionRatioSide = i2;
    }

    private void populateConstraint(Context ctx, Constraint c2, TypedArray a, boolean override) {
        int i2 = Build.VERSION.SDK_INT;
        if (override) {
            populateOverride(ctx, c2, a);
            return;
        }
        int indexCount = a.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = a.getIndex(i3);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                c2.motion.mApply = true;
                c2.layout.mApply = true;
                c2.propertySet.mApply = true;
                c2.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    Layout layout = c2.layout;
                    layout.baselineToBaseline = lookupID(a, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = c2.layout;
                    layout2.bottomMargin = a.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = c2.layout;
                    layout3.bottomToBottom = lookupID(a, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = c2.layout;
                    layout4.bottomToTop = lookupID(a, index, layout4.bottomToTop);
                    break;
                case 5:
                    c2.layout.dimensionRatio = a.getString(index);
                    break;
                case 6:
                    Layout layout5 = c2.layout;
                    layout5.editorAbsoluteX = a.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = c2.layout;
                    layout6.editorAbsoluteY = a.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    if (i2 >= 17) {
                        Layout layout7 = c2.layout;
                        layout7.endMargin = a.getDimensionPixelSize(index, layout7.endMargin);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    Layout layout8 = c2.layout;
                    layout8.endToEnd = lookupID(a, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = c2.layout;
                    layout9.endToStart = lookupID(a, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = c2.layout;
                    layout10.goneBottomMargin = a.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = c2.layout;
                    layout11.goneEndMargin = a.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = c2.layout;
                    layout12.goneLeftMargin = a.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = c2.layout;
                    layout13.goneRightMargin = a.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = c2.layout;
                    layout14.goneStartMargin = a.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = c2.layout;
                    layout15.goneTopMargin = a.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = c2.layout;
                    layout16.guideBegin = a.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = c2.layout;
                    layout17.guideEnd = a.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = c2.layout;
                    layout18.guidePercent = a.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = c2.layout;
                    layout19.horizontalBias = a.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = c2.layout;
                    layout20.mHeight = a.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = c2.propertySet;
                    propertySet.visibility = a.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = c2.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = c2.layout;
                    layout21.mWidth = a.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = c2.layout;
                    layout22.leftMargin = a.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = c2.layout;
                    layout23.leftToLeft = lookupID(a, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = c2.layout;
                    layout24.leftToRight = lookupID(a, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = c2.layout;
                    layout25.orientation = a.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = c2.layout;
                    layout26.rightMargin = a.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = c2.layout;
                    layout27.rightToLeft = lookupID(a, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = c2.layout;
                    layout28.rightToRight = lookupID(a, index, layout28.rightToRight);
                    break;
                case 31:
                    if (i2 >= 17) {
                        Layout layout29 = c2.layout;
                        layout29.startMargin = a.getDimensionPixelSize(index, layout29.startMargin);
                        break;
                    } else {
                        break;
                    }
                case 32:
                    Layout layout30 = c2.layout;
                    layout30.startToEnd = lookupID(a, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = c2.layout;
                    layout31.startToStart = lookupID(a, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = c2.layout;
                    layout32.topMargin = a.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = c2.layout;
                    layout33.topToBottom = lookupID(a, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = c2.layout;
                    layout34.topToTop = lookupID(a, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = c2.layout;
                    layout35.verticalBias = a.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    c2.mViewId = a.getResourceId(index, c2.mViewId);
                    break;
                case 39:
                    Layout layout36 = c2.layout;
                    layout36.horizontalWeight = a.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = c2.layout;
                    layout37.verticalWeight = a.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = c2.layout;
                    layout38.horizontalChainStyle = a.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = c2.layout;
                    layout39.verticalChainStyle = a.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = c2.propertySet;
                    propertySet3.alpha = a.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    if (i2 >= 21) {
                        Transform transform = c2.transform;
                        transform.applyElevation = true;
                        transform.elevation = a.getDimension(index, transform.elevation);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    Transform transform2 = c2.transform;
                    transform2.rotationX = a.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = c2.transform;
                    transform3.rotationY = a.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = c2.transform;
                    transform4.scaleX = a.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = c2.transform;
                    transform5.scaleY = a.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = c2.transform;
                    transform6.transformPivotX = a.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = c2.transform;
                    transform7.transformPivotY = a.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = c2.transform;
                    transform8.translationX = a.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = c2.transform;
                    transform9.translationY = a.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    if (i2 >= 21) {
                        Transform transform10 = c2.transform;
                        transform10.translationZ = a.getDimension(index, transform10.translationZ);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    Layout layout40 = c2.layout;
                    layout40.widthDefault = a.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = c2.layout;
                    layout41.heightDefault = a.getInt(index, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = c2.layout;
                    layout42.widthMax = a.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = c2.layout;
                    layout43.heightMax = a.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = c2.layout;
                    layout44.widthMin = a.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = c2.layout;
                    layout45.heightMin = a.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = c2.transform;
                    transform11.rotation = a.getFloat(index, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = c2.layout;
                    layout46.circleConstraint = lookupID(a, index, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = c2.layout;
                    layout47.circleRadius = a.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = c2.layout;
                    layout48.circleAngle = a.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = c2.motion;
                    motion.mAnimateRelativeTo = lookupID(a, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (a.peekValue(index).type == 3) {
                        c2.motion.mTransitionEasing = a.getString(index);
                        break;
                    } else {
                        c2.motion.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    c2.motion.mDrawPath = a.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = c2.motion;
                    motion2.mPathRotate = a.getFloat(index, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = c2.propertySet;
                    propertySet4.mProgress = a.getFloat(index, propertySet4.mProgress);
                    break;
                case 69:
                    c2.layout.widthPercent = a.getFloat(index, 1.0f);
                    break;
                case 70:
                    c2.layout.heightPercent = a.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = c2.layout;
                    layout49.mBarrierDirection = a.getInt(index, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = c2.layout;
                    layout50.mBarrierMargin = a.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case 74:
                    c2.layout.mReferenceIdString = a.getString(index);
                    break;
                case 75:
                    Layout layout51 = c2.layout;
                    layout51.mBarrierAllowsGoneWidgets = a.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = c2.motion;
                    motion3.mPathMotionArc = a.getInt(index, motion3.mPathMotionArc);
                    break;
                case 77:
                    c2.layout.mConstraintTag = a.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = c2.propertySet;
                    propertySet5.mVisibilityMode = a.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = c2.motion;
                    motion4.mMotionStagger = a.getFloat(index, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = c2.layout;
                    layout52.constrainedWidth = a.getBoolean(index, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = c2.layout;
                    layout53.constrainedHeight = a.getBoolean(index, layout53.constrainedHeight);
                    break;
                case 82:
                    Motion motion5 = c2.motion;
                    motion5.mAnimateCircleAngleTo = a.getInteger(index, motion5.mAnimateCircleAngleTo);
                    break;
                case 83:
                    Transform transform12 = c2.transform;
                    transform12.transformPivotTarget = lookupID(a, index, transform12.transformPivotTarget);
                    break;
                case 84:
                    Motion motion6 = c2.motion;
                    motion6.mQuantizeMotionSteps = a.getInteger(index, motion6.mQuantizeMotionSteps);
                    break;
                case 85:
                    Motion motion7 = c2.motion;
                    motion7.mQuantizeMotionPhase = a.getFloat(index, motion7.mQuantizeMotionPhase);
                    break;
                case 86:
                    int i4 = a.peekValue(index).type;
                    if (i4 == 1) {
                        c2.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                        Motion motion8 = c2.motion;
                        if (motion8.mQuantizeInterpolatorID != -1) {
                            motion8.mQuantizeInterpolatorType = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i4 == 3) {
                        c2.motion.mQuantizeInterpolatorString = a.getString(index);
                        if (c2.motion.mQuantizeInterpolatorString.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) > 0) {
                            c2.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                            c2.motion.mQuantizeInterpolatorType = -2;
                            break;
                        } else {
                            c2.motion.mQuantizeInterpolatorType = -1;
                            break;
                        }
                    } else {
                        Motion motion9 = c2.motion;
                        motion9.mQuantizeInterpolatorType = a.getInteger(index, motion9.mQuantizeInterpolatorID);
                        break;
                    }
                case 87:
                    String hexString = Integer.toHexString(index);
                    int i5 = mapToConstant.get(index);
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 33);
                    sb.append("unused attribute 0x");
                    sb.append(hexString);
                    sb.append("   ");
                    sb.append(i5);
                    Log.w(TAG, sb.toString());
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    String hexString2 = Integer.toHexString(index);
                    int i6 = mapToConstant.get(index);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString2).length() + 34);
                    sb2.append("Unknown attribute 0x");
                    sb2.append(hexString2);
                    sb2.append("   ");
                    sb2.append(i6);
                    Log.w(TAG, sb2.toString());
                    break;
                case 91:
                    Layout layout54 = c2.layout;
                    layout54.baselineToTop = lookupID(a, index, layout54.baselineToTop);
                    break;
                case 92:
                    Layout layout55 = c2.layout;
                    layout55.baselineToBottom = lookupID(a, index, layout55.baselineToBottom);
                    break;
                case 93:
                    Layout layout56 = c2.layout;
                    layout56.baselineMargin = a.getDimensionPixelSize(index, layout56.baselineMargin);
                    break;
                case 94:
                    Layout layout57 = c2.layout;
                    layout57.goneBaselineMargin = a.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                    break;
                case 95:
                    parseDimensionConstraints(c2.layout, a, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(c2.layout, a, index, 1);
                    break;
                case 97:
                    Layout layout58 = c2.layout;
                    layout58.mWrapBehavior = a.getInt(index, layout58.mWrapBehavior);
                    break;
            }
        }
        Layout layout59 = c2.layout;
        if (layout59.mReferenceIdString != null) {
            layout59.mReferenceIds = null;
        }
    }

    private static void populateOverride(Context ctx, Constraint c2, TypedArray a) {
        int i2 = Build.VERSION.SDK_INT;
        int indexCount = a.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        c2.mDelta = delta;
        c2.motion.mApply = false;
        c2.layout.mApply = false;
        c2.propertySet.mApply = false;
        c2.transform.mApply = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = a.getIndex(i3);
            switch (overrideMapToConstant.get(index)) {
                case 2:
                    delta.add(2, a.getDimensionPixelSize(index, c2.layout.bottomMargin));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    String hexString = Integer.toHexString(index);
                    int i4 = mapToConstant.get(index);
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 34);
                    sb.append("Unknown attribute 0x");
                    sb.append(hexString);
                    sb.append("   ");
                    sb.append(i4);
                    Log.w(TAG, sb.toString());
                    break;
                case 5:
                    delta.add(5, a.getString(index));
                    break;
                case 6:
                    delta.add(6, a.getDimensionPixelOffset(index, c2.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.add(7, a.getDimensionPixelOffset(index, c2.layout.editorAbsoluteY));
                    break;
                case 8:
                    if (i2 >= 17) {
                        delta.add(8, a.getDimensionPixelSize(index, c2.layout.endMargin));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    delta.add(11, a.getDimensionPixelSize(index, c2.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.add(12, a.getDimensionPixelSize(index, c2.layout.goneEndMargin));
                    break;
                case 13:
                    delta.add(13, a.getDimensionPixelSize(index, c2.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.add(14, a.getDimensionPixelSize(index, c2.layout.goneRightMargin));
                    break;
                case 15:
                    delta.add(15, a.getDimensionPixelSize(index, c2.layout.goneStartMargin));
                    break;
                case 16:
                    delta.add(16, a.getDimensionPixelSize(index, c2.layout.goneTopMargin));
                    break;
                case 17:
                    delta.add(17, a.getDimensionPixelOffset(index, c2.layout.guideBegin));
                    break;
                case 18:
                    delta.add(18, a.getDimensionPixelOffset(index, c2.layout.guideEnd));
                    break;
                case 19:
                    delta.add(19, a.getFloat(index, c2.layout.guidePercent));
                    break;
                case 20:
                    delta.add(20, a.getFloat(index, c2.layout.horizontalBias));
                    break;
                case 21:
                    delta.add(21, a.getLayoutDimension(index, c2.layout.mHeight));
                    break;
                case 22:
                    delta.add(22, VISIBILITY_FLAGS[a.getInt(index, c2.propertySet.visibility)]);
                    break;
                case 23:
                    delta.add(23, a.getLayoutDimension(index, c2.layout.mWidth));
                    break;
                case 24:
                    delta.add(24, a.getDimensionPixelSize(index, c2.layout.leftMargin));
                    break;
                case 27:
                    delta.add(27, a.getInt(index, c2.layout.orientation));
                    break;
                case 28:
                    delta.add(28, a.getDimensionPixelSize(index, c2.layout.rightMargin));
                    break;
                case 31:
                    if (i2 >= 17) {
                        delta.add(31, a.getDimensionPixelSize(index, c2.layout.startMargin));
                        break;
                    } else {
                        break;
                    }
                case 34:
                    delta.add(34, a.getDimensionPixelSize(index, c2.layout.topMargin));
                    break;
                case 37:
                    delta.add(37, a.getFloat(index, c2.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = a.getResourceId(index, c2.mViewId);
                    c2.mViewId = resourceId;
                    delta.add(38, resourceId);
                    break;
                case 39:
                    delta.add(39, a.getFloat(index, c2.layout.horizontalWeight));
                    break;
                case 40:
                    delta.add(40, a.getFloat(index, c2.layout.verticalWeight));
                    break;
                case 41:
                    delta.add(41, a.getInt(index, c2.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.add(42, a.getInt(index, c2.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.add(43, a.getFloat(index, c2.propertySet.alpha));
                    break;
                case 44:
                    if (i2 >= 21) {
                        delta.add(44, true);
                        delta.add(44, a.getDimension(index, c2.transform.elevation));
                        break;
                    } else {
                        break;
                    }
                case 45:
                    delta.add(45, a.getFloat(index, c2.transform.rotationX));
                    break;
                case 46:
                    delta.add(46, a.getFloat(index, c2.transform.rotationY));
                    break;
                case 47:
                    delta.add(47, a.getFloat(index, c2.transform.scaleX));
                    break;
                case 48:
                    delta.add(48, a.getFloat(index, c2.transform.scaleY));
                    break;
                case 49:
                    delta.add(49, a.getDimension(index, c2.transform.transformPivotX));
                    break;
                case 50:
                    delta.add(50, a.getDimension(index, c2.transform.transformPivotY));
                    break;
                case 51:
                    delta.add(51, a.getDimension(index, c2.transform.translationX));
                    break;
                case 52:
                    delta.add(52, a.getDimension(index, c2.transform.translationY));
                    break;
                case 53:
                    if (i2 >= 21) {
                        delta.add(53, a.getDimension(index, c2.transform.translationZ));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    delta.add(54, a.getInt(index, c2.layout.widthDefault));
                    break;
                case 55:
                    delta.add(55, a.getInt(index, c2.layout.heightDefault));
                    break;
                case 56:
                    delta.add(56, a.getDimensionPixelSize(index, c2.layout.widthMax));
                    break;
                case 57:
                    delta.add(57, a.getDimensionPixelSize(index, c2.layout.heightMax));
                    break;
                case 58:
                    delta.add(58, a.getDimensionPixelSize(index, c2.layout.widthMin));
                    break;
                case 59:
                    delta.add(59, a.getDimensionPixelSize(index, c2.layout.heightMin));
                    break;
                case 60:
                    delta.add(60, a.getFloat(index, c2.transform.rotation));
                    break;
                case 62:
                    delta.add(62, a.getDimensionPixelSize(index, c2.layout.circleRadius));
                    break;
                case 63:
                    delta.add(63, a.getFloat(index, c2.layout.circleAngle));
                    break;
                case 64:
                    delta.add(64, lookupID(a, index, c2.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (a.peekValue(index).type == 3) {
                        delta.add(65, a.getString(index));
                        break;
                    } else {
                        delta.add(65, Easing.NAMED_EASING[a.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    delta.add(66, a.getInt(index, 0));
                    break;
                case 67:
                    delta.add(67, a.getFloat(index, c2.motion.mPathRotate));
                    break;
                case 68:
                    delta.add(68, a.getFloat(index, c2.propertySet.mProgress));
                    break;
                case 69:
                    delta.add(69, a.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.add(70, a.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.add(72, a.getInt(index, c2.layout.mBarrierDirection));
                    break;
                case 73:
                    delta.add(73, a.getDimensionPixelSize(index, c2.layout.mBarrierMargin));
                    break;
                case 74:
                    delta.add(74, a.getString(index));
                    break;
                case 75:
                    delta.add(75, a.getBoolean(index, c2.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.add(76, a.getInt(index, c2.motion.mPathMotionArc));
                    break;
                case 77:
                    delta.add(77, a.getString(index));
                    break;
                case 78:
                    delta.add(78, a.getInt(index, c2.propertySet.mVisibilityMode));
                    break;
                case 79:
                    delta.add(79, a.getFloat(index, c2.motion.mMotionStagger));
                    break;
                case 80:
                    delta.add(80, a.getBoolean(index, c2.layout.constrainedWidth));
                    break;
                case 81:
                    delta.add(81, a.getBoolean(index, c2.layout.constrainedHeight));
                    break;
                case 82:
                    delta.add(82, a.getInteger(index, c2.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    delta.add(83, lookupID(a, index, c2.transform.transformPivotTarget));
                    break;
                case 84:
                    delta.add(84, a.getInteger(index, c2.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    delta.add(85, a.getFloat(index, c2.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    int i5 = a.peekValue(index).type;
                    if (i5 == 1) {
                        c2.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                        delta.add(89, c2.motion.mQuantizeInterpolatorID);
                        Motion motion = c2.motion;
                        if (motion.mQuantizeInterpolatorID != -1) {
                            motion.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i5 == 3) {
                        c2.motion.mQuantizeInterpolatorString = a.getString(index);
                        delta.add(90, c2.motion.mQuantizeInterpolatorString);
                        if (c2.motion.mQuantizeInterpolatorString.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) > 0) {
                            c2.motion.mQuantizeInterpolatorID = a.getResourceId(index, -1);
                            delta.add(89, c2.motion.mQuantizeInterpolatorID);
                            c2.motion.mQuantizeInterpolatorType = -2;
                            delta.add(88, -2);
                            break;
                        } else {
                            c2.motion.mQuantizeInterpolatorType = -1;
                            delta.add(88, -1);
                            break;
                        }
                    } else {
                        Motion motion2 = c2.motion;
                        motion2.mQuantizeInterpolatorType = a.getInteger(index, motion2.mQuantizeInterpolatorID);
                        delta.add(88, c2.motion.mQuantizeInterpolatorType);
                        break;
                    }
                case 87:
                    String hexString2 = Integer.toHexString(index);
                    int i6 = mapToConstant.get(index);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString2).length() + 33);
                    sb2.append("unused attribute 0x");
                    sb2.append(hexString2);
                    sb2.append("   ");
                    sb2.append(i6);
                    Log.w(TAG, sb2.toString());
                    break;
                case 93:
                    delta.add(93, a.getDimensionPixelSize(index, c2.layout.baselineMargin));
                    break;
                case 94:
                    delta.add(94, a.getDimensionPixelSize(index, c2.layout.goneBaselineMargin));
                    break;
                case 95:
                    parseDimensionConstraints(delta, a, index, 0);
                    break;
                case 96:
                    parseDimensionConstraints(delta, a, index, 1);
                    break;
                case 97:
                    delta.add(97, a.getInt(index, c2.layout.mWrapBehavior));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = a.getResourceId(index, c2.mViewId);
                        c2.mViewId = resourceId2;
                        if (resourceId2 == -1) {
                            c2.mTargetString = a.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (a.peekValue(index).type == 3) {
                        c2.mTargetString = a.getString(index);
                        break;
                    } else {
                        c2.mViewId = a.getResourceId(index, c2.mViewId);
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c2, int type, float value) {
        if (type == 19) {
            c2.layout.guidePercent = value;
        } else if (type == 20) {
            c2.layout.horizontalBias = value;
        } else if (type == 37) {
            c2.layout.verticalBias = value;
        } else if (type == 60) {
            c2.transform.rotation = value;
        } else if (type == 63) {
            c2.layout.circleAngle = value;
        } else if (type == 79) {
            c2.motion.mMotionStagger = value;
        } else if (type == 85) {
            c2.motion.mQuantizeMotionPhase = value;
        } else if (type != 87) {
            if (type == 39) {
                c2.layout.horizontalWeight = value;
            } else if (type != 40) {
                switch (type) {
                    case 43:
                        c2.propertySet.alpha = value;
                        return;
                    case 44:
                        Transform transform = c2.transform;
                        transform.elevation = value;
                        transform.applyElevation = true;
                        return;
                    case 45:
                        c2.transform.rotationX = value;
                        return;
                    case 46:
                        c2.transform.rotationY = value;
                        return;
                    case 47:
                        c2.transform.scaleX = value;
                        return;
                    case 48:
                        c2.transform.scaleY = value;
                        return;
                    case 49:
                        c2.transform.transformPivotX = value;
                        return;
                    case 50:
                        c2.transform.transformPivotY = value;
                        return;
                    case 51:
                        c2.transform.translationX = value;
                        return;
                    case 52:
                        c2.transform.translationY = value;
                        return;
                    case 53:
                        c2.transform.translationZ = value;
                        return;
                    default:
                        switch (type) {
                            case 67:
                                c2.motion.mPathRotate = value;
                                return;
                            case 68:
                                c2.propertySet.mProgress = value;
                                return;
                            case 69:
                                c2.layout.widthPercent = value;
                                return;
                            case 70:
                                c2.layout.heightPercent = value;
                                return;
                            default:
                                Log.w(TAG, "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                c2.layout.verticalWeight = value;
            }
        }
    }

    private String sideToString(int side) {
        switch (side) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return MessageKey.MSG_ACCEPT_TIME_START;
            case 7:
                return MessageKey.MSG_ACCEPT_TIME_END;
            default:
                return "undefined";
        }
    }

    private static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (charArray[i3] == ',' && !z) {
                arrayList.add(new String(charArray, i2, i3 - i2));
                i2 = i3 + 1;
            } else if (charArray[i3] == '\"') {
                z = !z;
            }
        }
        arrayList.add(new String(charArray, i2, charArray.length - i2));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, attributeName);
    }

    public void addFloatAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, attributeName);
    }

    public void addIntAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, attributeName);
    }

    public void addStringAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, attributeName);
    }

    public void addToHorizontalChain(int viewId, int leftId, int rightId) {
        connect(viewId, 1, leftId, leftId == 0 ? 1 : 2, 0);
        connect(viewId, 2, rightId, rightId == 0 ? 2 : 1, 0);
        if (leftId != 0) {
            connect(leftId, 2, viewId, 1, 0);
        }
        if (rightId != 0) {
            connect(rightId, 1, viewId, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int viewId, int leftId, int rightId) {
        connect(viewId, 6, leftId, leftId == 0 ? 6 : 7, 0);
        connect(viewId, 7, rightId, rightId == 0 ? 7 : 6, 0);
        if (leftId != 0) {
            connect(leftId, 7, viewId, 6, 0);
        }
        if (rightId != 0) {
            connect(rightId, 6, viewId, 7, 0);
        }
    }

    public void addToVerticalChain(int viewId, int topId, int bottomId) {
        connect(viewId, 3, topId, topId == 0 ? 3 : 4, 0);
        connect(viewId, 4, bottomId, bottomId == 0 ? 4 : 3, 0);
        if (topId != 0) {
            connect(topId, 4, viewId, 3, 0);
        }
        if (bottomId != 0) {
            connect(bottomId, 3, viewId, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                String valueOf = String.valueOf(Debug.getName(childAt));
                Log.w(TAG, valueOf.length() != 0 ? "id unknown ".concat(valueOf) : new String("id unknown "));
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (this.mConstraints.containsKey(Integer.valueOf(id)) && (constraint = this.mConstraints.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
            }
        }
    }

    public void applyDeltaFrom(ConstraintSet cs) {
        for (Constraint constraint : cs.mConstraints.values()) {
            if (constraint.mDelta != null) {
                if (constraint.mTargetString != null) {
                    for (Integer num : this.mConstraints.keySet()) {
                        Constraint constraint2 = getConstraint(num.intValue());
                        String str = constraint2.layout.mConstraintTag;
                        if (str != null && constraint.mTargetString.matches(str)) {
                            constraint.mDelta.applyDelta(constraint2);
                            constraint2.mCustomConstraints.putAll((HashMap) constraint.mCustomConstraints.clone());
                        }
                    }
                } else {
                    constraint.mDelta.applyDelta(getConstraint(constraint.mViewId));
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper helper, ConstraintWidget child, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        Constraint constraint;
        int id = helper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id)) && (constraint = this.mConstraints.get(Integer.valueOf(id))) != null && (child instanceof HelperWidget)) {
            helper.loadParameters(constraint, (HelperWidget) child, layoutParams, mapIdToWidget);
        }
    }

    public void applyToInternal(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                String valueOf = String.valueOf(Debug.getName(childAt));
                Log.w(TAG, valueOf.length() != 0 ? "id unknown ".concat(valueOf) : new String("id unknown "));
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.layout.mHelperType = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(constraint.layout.mBarrierDirection);
                                barrier.setMargin(constraint.layout.mBarrierMargin);
                                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                                Layout layout = constraint.layout;
                                int[] iArr = layout.mReferenceIds;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.mReferenceIdString;
                                    if (str != null) {
                                        layout.mReferenceIds = convertReferenceString(barrier, str);
                                        barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.validate();
                            constraint.applyTo(layoutParams);
                            if (applyPostLayout) {
                                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                            }
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.propertySet;
                            if (propertySet.mVisibilityMode == 0) {
                                childAt.setVisibility(propertySet.visibility);
                            }
                            int i3 = Build.VERSION.SDK_INT;
                            if (i3 >= 17) {
                                childAt.setAlpha(constraint.propertySet.alpha);
                                childAt.setRotation(constraint.transform.rotation);
                                childAt.setRotationX(constraint.transform.rotationX);
                                childAt.setRotationY(constraint.transform.rotationY);
                                childAt.setScaleX(constraint.transform.scaleX);
                                childAt.setScaleY(constraint.transform.scaleY);
                                Transform transform = constraint.transform;
                                if (transform.transformPivotTarget != -1) {
                                    View findViewById = ((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget);
                                    if (findViewById != null) {
                                        float top = (findViewById.getTop() + findViewById.getBottom()) / 2.0f;
                                        float left = (findViewById.getLeft() + findViewById.getRight()) / 2.0f;
                                        if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                            childAt.setPivotX(left - childAt.getLeft());
                                            childAt.setPivotY(top - childAt.getTop());
                                        }
                                    }
                                } else {
                                    if (!Float.isNaN(transform.transformPivotX)) {
                                        childAt.setPivotX(constraint.transform.transformPivotX);
                                    }
                                    if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                        childAt.setPivotY(constraint.transform.transformPivotY);
                                    }
                                }
                                childAt.setTranslationX(constraint.transform.translationX);
                                childAt.setTranslationY(constraint.transform.translationY);
                                if (i3 >= 21) {
                                    childAt.setTranslationZ(constraint.transform.translationZ);
                                    Transform transform2 = constraint.transform;
                                    if (transform2.applyElevation) {
                                        childAt.setElevation(transform2.elevation);
                                    }
                                }
                            }
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(43);
                        sb.append("WARNING NO CONSTRAINTS for view ");
                        sb.append(id);
                        Log.v(TAG, sb.toString());
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = constraintLayout.getChildAt(i4);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void applyToLayoutParams(int id, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(id)) || (constraint = this.mConstraints.get(Integer.valueOf(id))) == null) {
            return;
        }
        constraint.applyTo(layoutParams);
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int centerID, int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        if (firstMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (secondMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (bias <= 0.0f || bias > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (firstSide == 1 || firstSide == 2) {
            connect(centerID, 1, firstID, firstSide, firstMargin);
            connect(centerID, 2, secondId, secondSide, secondMargin);
            Constraint constraint = this.mConstraints.get(Integer.valueOf(centerID));
            if (constraint != null) {
                constraint.layout.horizontalBias = bias;
            }
        } else if (firstSide != 6 && firstSide != 7) {
            connect(centerID, 3, firstID, firstSide, firstMargin);
            connect(centerID, 4, secondId, secondSide, secondMargin);
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(centerID));
            if (constraint2 != null) {
                constraint2.layout.verticalBias = bias;
            }
        } else {
            connect(centerID, 6, firstID, firstSide, firstMargin);
            connect(centerID, 7, secondId, secondSide, secondMargin);
            Constraint constraint3 = this.mConstraints.get(Integer.valueOf(centerID));
            if (constraint3 != null) {
                constraint3.layout.horizontalBias = bias;
            }
        }
    }

    public void centerHorizontally(int centerID, int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        connect(centerID, 1, leftId, leftSide, leftMargin);
        connect(centerID, 2, rightId, rightSide, rightMargin);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(centerID));
        if (constraint != null) {
            constraint.layout.horizontalBias = bias;
        }
    }

    public void centerHorizontallyRtl(int centerID, int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        connect(centerID, 6, startId, startSide, startMargin);
        connect(centerID, 7, endId, endSide, endMargin);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(centerID));
        if (constraint != null) {
            constraint.layout.horizontalBias = bias;
        }
    }

    public void centerVertically(int centerID, int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        connect(centerID, 3, topId, topSide, topMargin);
        connect(centerID, 4, bottomId, bottomSide, bottomMargin);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(centerID));
        if (constraint != null) {
            constraint.layout.verticalBias = bias;
        }
    }

    public void clear(int viewId) {
        this.mConstraints.remove(Integer.valueOf(viewId));
    }

    public void clone(Context context, int constraintLayoutId) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null));
    }

    public void connect(int startID, int startSide, int endID, int endSide, int margin) {
        if (!this.mConstraints.containsKey(Integer.valueOf(startID))) {
            this.mConstraints.put(Integer.valueOf(startID), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(startID));
        if (constraint == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = endID;
                    layout.leftToRight = -1;
                } else if (endSide == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = endID;
                    layout2.leftToLeft = -1;
                } else {
                    String sideToString = sideToString(endSide);
                    StringBuilder sb = new StringBuilder(String.valueOf(sideToString).length() + 18);
                    sb.append("Left to ");
                    sb.append(sideToString);
                    sb.append(" undefined");
                    throw new IllegalArgumentException(sb.toString());
                }
                constraint.layout.leftMargin = margin;
                return;
            case 2:
                if (endSide == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = endID;
                    layout3.rightToRight = -1;
                } else if (endSide == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = endID;
                    layout4.rightToLeft = -1;
                } else {
                    String sideToString2 = sideToString(endSide);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(sideToString2).length() + 19);
                    sb2.append("right to ");
                    sb2.append(sideToString2);
                    sb2.append(" undefined");
                    throw new IllegalArgumentException(sb2.toString());
                }
                constraint.layout.rightMargin = margin;
                return;
            case 3:
                if (endSide == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = endID;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                } else if (endSide == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = endID;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                } else {
                    String sideToString3 = sideToString(endSide);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(sideToString3).length() + 19);
                    sb3.append("right to ");
                    sb3.append(sideToString3);
                    sb3.append(" undefined");
                    throw new IllegalArgumentException(sb3.toString());
                }
                constraint.layout.topMargin = margin;
                return;
            case 4:
                if (endSide == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = endID;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                } else if (endSide == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = endID;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                } else {
                    String sideToString4 = sideToString(endSide);
                    StringBuilder sb4 = new StringBuilder(String.valueOf(sideToString4).length() + 19);
                    sb4.append("right to ");
                    sb4.append(sideToString4);
                    sb4.append(" undefined");
                    throw new IllegalArgumentException(sb4.toString());
                }
                constraint.layout.bottomMargin = margin;
                return;
            case 5:
                if (endSide == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = endID;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                } else if (endSide == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = endID;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                } else if (endSide == 4) {
                    Layout layout11 = constraint.layout;
                    layout11.baselineToBottom = endID;
                    layout11.bottomToBottom = -1;
                    layout11.bottomToTop = -1;
                    layout11.topToTop = -1;
                    layout11.topToBottom = -1;
                    return;
                } else {
                    String sideToString5 = sideToString(endSide);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(sideToString5).length() + 19);
                    sb5.append("right to ");
                    sb5.append(sideToString5);
                    sb5.append(" undefined");
                    throw new IllegalArgumentException(sb5.toString());
                }
            case 6:
                if (endSide == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = endID;
                    layout12.startToEnd = -1;
                } else if (endSide == 7) {
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = endID;
                    layout13.startToStart = -1;
                } else {
                    String sideToString6 = sideToString(endSide);
                    StringBuilder sb6 = new StringBuilder(String.valueOf(sideToString6).length() + 19);
                    sb6.append("right to ");
                    sb6.append(sideToString6);
                    sb6.append(" undefined");
                    throw new IllegalArgumentException(sb6.toString());
                }
                constraint.layout.startMargin = margin;
                return;
            case 7:
                if (endSide == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = endID;
                    layout14.endToStart = -1;
                } else if (endSide == 6) {
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = endID;
                    layout15.endToEnd = -1;
                } else {
                    String sideToString7 = sideToString(endSide);
                    StringBuilder sb7 = new StringBuilder(String.valueOf(sideToString7).length() + 19);
                    sb7.append("right to ");
                    sb7.append(sideToString7);
                    sb7.append(" undefined");
                    throw new IllegalArgumentException(sb7.toString());
                }
                constraint.layout.endMargin = margin;
                return;
            default:
                String sideToString8 = sideToString(startSide);
                String sideToString9 = sideToString(endSide);
                StringBuilder sb8 = new StringBuilder(String.valueOf(sideToString8).length() + 12 + String.valueOf(sideToString9).length());
                sb8.append(sideToString8);
                sb8.append(" to ");
                sb8.append(sideToString9);
                sb8.append(" unknown");
                throw new IllegalArgumentException(sb8.toString());
        }
    }

    public void constrainCircle(int viewId, int id, int radius, float angle) {
        Layout layout = get(viewId).layout;
        layout.circleConstraint = id;
        layout.circleRadius = radius;
        layout.circleAngle = angle;
    }

    public void constrainDefaultHeight(int viewId, int height) {
        get(viewId).layout.heightDefault = height;
    }

    public void constrainDefaultWidth(int viewId, int width) {
        get(viewId).layout.widthDefault = width;
    }

    public void constrainHeight(int viewId, int height) {
        get(viewId).layout.mHeight = height;
    }

    public void constrainMaxHeight(int viewId, int height) {
        get(viewId).layout.heightMax = height;
    }

    public void constrainMaxWidth(int viewId, int width) {
        get(viewId).layout.widthMax = width;
    }

    public void constrainMinHeight(int viewId, int height) {
        get(viewId).layout.heightMin = height;
    }

    public void constrainMinWidth(int viewId, int width) {
        get(viewId).layout.widthMin = width;
    }

    public void constrainPercentHeight(int viewId, float percent) {
        get(viewId).layout.heightPercent = percent;
    }

    public void constrainPercentWidth(int viewId, float percent) {
        get(viewId).layout.widthPercent = percent;
    }

    public void constrainWidth(int viewId, int width) {
        get(viewId).layout.mWidth = width;
    }

    public void constrainedHeight(int viewId, boolean constrained) {
        get(viewId).layout.constrainedHeight = constrained;
    }

    public void constrainedWidth(int viewId, boolean constrained) {
        get(viewId).layout.constrainedWidth = constrained;
    }

    public void create(int guidelineID, int orientation) {
        Layout layout = get(guidelineID).layout;
        layout.mIsGuideline = true;
        layout.orientation = orientation;
    }

    public void createBarrier(int id, int direction, int margin, int... referenced) {
        Layout layout = get(id).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = direction;
        layout.mBarrierMargin = margin;
        layout.mIsGuideline = false;
        layout.mReferenceIds = referenced;
    }

    public void createHorizontalChain(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style) {
        createHorizontalChain(leftId, leftSide, rightId, rightSide, chainIds, weights, style, 1, 2);
    }

    public void createHorizontalChainRtl(int startId, int startSide, int endId, int endSide, int[] chainIds, float[] weights, int style) {
        createHorizontalChain(startId, startSide, endId, endSide, chainIds, weights, style, 6, 7);
    }

    public void createVerticalChain(int topId, int topSide, int bottomId, int bottomSide, int[] chainIds, float[] weights, int style) {
        if (chainIds.length >= 2) {
            if (weights != null && weights.length != chainIds.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (weights != null) {
                get(chainIds[0]).layout.verticalWeight = weights[0];
            }
            get(chainIds[0]).layout.verticalChainStyle = style;
            connect(chainIds[0], 3, topId, topSide, 0);
            for (int i2 = 1; i2 < chainIds.length; i2++) {
                int i3 = chainIds[i2];
                int i4 = i2 - 1;
                connect(chainIds[i2], 3, chainIds[i4], 4, 0);
                connect(chainIds[i4], 4, chainIds[i2], 3, 0);
                if (weights != null) {
                    get(chainIds[i2]).layout.verticalWeight = weights[i2];
                }
            }
            connect(chainIds[chainIds.length - 1], 4, bottomId, bottomSide, 0);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void dump(MotionScene scene, int... ids) {
        HashSet hashSet;
        Integer[] numArr;
        Set<Integer> keySet = this.mConstraints.keySet();
        if (ids.length != 0) {
            hashSet = new HashSet();
            for (int i2 : ids) {
                hashSet.add(Integer.valueOf(i2));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        PrintStream printStream = System.out;
        int size = hashSet.size();
        StringBuilder sb = new StringBuilder(23);
        sb.append(size);
        sb.append(" constraints");
        printStream.println(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = this.mConstraints.get(num);
            if (constraint != null) {
                sb2.append("<Constraint id=");
                sb2.append(num);
                sb2.append(" \n");
                constraint.layout.dump(scene, sb2);
                sb2.append("/>\n");
            }
        }
        System.out.println(sb2.toString());
    }

    public boolean getApplyElevation(int viewId) {
        return get(viewId).transform.applyElevation;
    }

    public Constraint getConstraint(int id) {
        if (this.mConstraints.containsKey(Integer.valueOf(id))) {
            return this.mConstraints.get(Integer.valueOf(id));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int viewId) {
        return get(viewId).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int mId) {
        return get(mId);
    }

    public int[] getReferencedIds(int id) {
        int[] iArr = get(id).layout.mReferenceIds;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int viewId) {
        return get(viewId).propertySet.visibility;
    }

    public int getVisibilityMode(int viewId) {
        return get(viewId).propertySet.mVisibilityMode;
    }

    public int getWidth(int viewId) {
        return get(viewId).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                    continue;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint set, String attributes) {
        String[] split = attributes.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].split("=");
            if (split2.length == 2) {
                set.setColorValue(split2[0], Color.parseColor(split2[1]));
            } else {
                String valueOf = String.valueOf(split[i2]);
                Log.w(TAG, valueOf.length() != 0 ? " Unable to parse ".concat(valueOf) : new String(" Unable to parse "));
            }
        }
    }

    public void parseFloatAttributes(Constraint set, String attributes) {
        String[] split = attributes.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].split("=");
            if (split2.length == 2) {
                set.setFloatValue(split2[0], Float.parseFloat(split2[1]));
            } else {
                String valueOf = String.valueOf(split[i2]);
                Log.w(TAG, valueOf.length() != 0 ? " Unable to parse ".concat(valueOf) : new String(" Unable to parse "));
            }
        }
    }

    public void parseIntAttributes(Constraint set, String attributes) {
        String[] split = attributes.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].split("=");
            if (split2.length == 2) {
                set.setFloatValue(split2[0], Integer.decode(split2[1]).intValue());
            } else {
                String valueOf = String.valueOf(split[i2]);
                Log.w(TAG, valueOf.length() != 0 ? " Unable to parse ".concat(valueOf) : new String(" Unable to parse "));
            }
        }
    }

    public void parseStringAttributes(Constraint set, String attributes) {
        String[] splitString = splitString(attributes);
        for (int i2 = 0; i2 < splitString.length; i2++) {
            String[] split = splitString[i2].split("=");
            String valueOf = String.valueOf(splitString[i2]);
            Log.w(TAG, valueOf.length() != 0 ? " Unable to parse ".concat(valueOf) : new String(" Unable to parse "));
            set.setStringValue(split[0], split[1]);
        }
    }

    public void readFallback(ConstraintSet set) {
        for (Integer num : set.mConstraints.keySet()) {
            int intValue = num.intValue();
            Constraint constraint = set.mConstraints.get(num);
            if (!this.mConstraints.containsKey(Integer.valueOf(intValue))) {
                this.mConstraints.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(intValue));
            if (constraint2 != null) {
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String str : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(str)) {
                        constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                    }
                }
            }
        }
    }

    public void removeAttribute(String attributeName) {
        this.mSavedAttributes.remove(attributeName);
    }

    public void removeFromHorizontalChain(int viewId) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(viewId)) || (constraint = this.mConstraints.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        Layout layout = constraint.layout;
        int i2 = layout.leftToRight;
        int i3 = layout.rightToLeft;
        if (i2 == -1 && i3 == -1) {
            int i4 = layout.startToEnd;
            int i5 = layout.endToStart;
            if (i4 != -1 || i5 != -1) {
                if (i4 != -1 && i5 != -1) {
                    connect(i4, 7, i5, 6, 0);
                    connect(i5, 6, i2, 7, 0);
                } else if (i5 != -1) {
                    int i6 = layout.rightToRight;
                    if (i6 != -1) {
                        connect(i2, 7, i6, 7, 0);
                    } else {
                        int i7 = layout.leftToLeft;
                        if (i7 != -1) {
                            connect(i5, 6, i7, 6, 0);
                        }
                    }
                }
            }
            clear(viewId, 6);
            clear(viewId, 7);
            return;
        }
        if (i2 != -1 && i3 != -1) {
            connect(i2, 2, i3, 1, 0);
            connect(i3, 1, i2, 2, 0);
        } else {
            int i8 = layout.rightToRight;
            if (i8 != -1) {
                connect(i2, 2, i8, 2, 0);
            } else {
                int i9 = layout.leftToLeft;
                if (i9 != -1) {
                    connect(i3, 1, i9, 1, 0);
                }
            }
        }
        clear(viewId, 1);
        clear(viewId, 2);
    }

    public void removeFromVerticalChain(int viewId) {
        if (this.mConstraints.containsKey(Integer.valueOf(viewId))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(viewId));
            if (constraint == null) {
                return;
            }
            Layout layout = constraint.layout;
            int i2 = layout.topToBottom;
            int i3 = layout.bottomToTop;
            if (i2 != -1 || i3 != -1) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 4, i3, 3, 0);
                    connect(i3, 3, i2, 4, 0);
                } else {
                    int i4 = layout.bottomToBottom;
                    if (i4 != -1) {
                        connect(i2, 4, i4, 4, 0);
                    } else {
                        int i5 = layout.topToTop;
                        if (i5 != -1) {
                            connect(i3, 3, i5, 3, 0);
                        }
                    }
                }
            }
        }
        clear(viewId, 3);
        clear(viewId, 4);
    }

    public void setAlpha(int viewId, float alpha) {
        get(viewId).propertySet.alpha = alpha;
    }

    public void setApplyElevation(int viewId, boolean apply) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(viewId).transform.applyElevation = apply;
        }
    }

    public void setBarrierType(int id, int type) {
        get(id).layout.mHelperType = type;
    }

    public void setColorValue(int viewId, String attributeName, int value) {
        get(viewId).setColorValue(attributeName, value);
    }

    public void setDimensionRatio(int viewId, String ratio) {
        get(viewId).layout.dimensionRatio = ratio;
    }

    public void setEditorAbsoluteX(int viewId, int position) {
        get(viewId).layout.editorAbsoluteX = position;
    }

    public void setEditorAbsoluteY(int viewId, int position) {
        get(viewId).layout.editorAbsoluteY = position;
    }

    public void setElevation(int viewId, float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(viewId).transform.elevation = elevation;
            get(viewId).transform.applyElevation = true;
        }
    }

    public void setFloatValue(int viewId, String attributeName, float value) {
        get(viewId).setFloatValue(attributeName, value);
    }

    public void setForceId(boolean forceId) {
        this.mForceId = forceId;
    }

    public void setGoneMargin(int viewId, int anchor, int value) {
        Constraint constraint = get(viewId);
        switch (anchor) {
            case 1:
                constraint.layout.goneLeftMargin = value;
                return;
            case 2:
                constraint.layout.goneRightMargin = value;
                return;
            case 3:
                constraint.layout.goneTopMargin = value;
                return;
            case 4:
                constraint.layout.goneBottomMargin = value;
                return;
            case 5:
                constraint.layout.goneBaselineMargin = value;
                return;
            case 6:
                constraint.layout.goneStartMargin = value;
                return;
            case 7:
                constraint.layout.goneEndMargin = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int guidelineID, int margin) {
        get(guidelineID).layout.guideBegin = margin;
        get(guidelineID).layout.guideEnd = -1;
        get(guidelineID).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int guidelineID, int margin) {
        get(guidelineID).layout.guideEnd = margin;
        get(guidelineID).layout.guideBegin = -1;
        get(guidelineID).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int guidelineID, float ratio) {
        get(guidelineID).layout.guidePercent = ratio;
        get(guidelineID).layout.guideEnd = -1;
        get(guidelineID).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int viewId, float bias) {
        get(viewId).layout.horizontalBias = bias;
    }

    public void setHorizontalChainStyle(int viewId, int chainStyle) {
        get(viewId).layout.horizontalChainStyle = chainStyle;
    }

    public void setHorizontalWeight(int viewId, float weight) {
        get(viewId).layout.horizontalWeight = weight;
    }

    public void setIntValue(int viewId, String attributeName, int value) {
        get(viewId).setIntValue(attributeName, value);
    }

    public void setLayoutWrapBehavior(int viewId, int behavior) {
        if (behavior < 0 || behavior > 3) {
            return;
        }
        get(viewId).layout.mWrapBehavior = behavior;
    }

    public void setMargin(int viewId, int anchor, int value) {
        Constraint constraint = get(viewId);
        switch (anchor) {
            case 1:
                constraint.layout.leftMargin = value;
                return;
            case 2:
                constraint.layout.rightMargin = value;
                return;
            case 3:
                constraint.layout.topMargin = value;
                return;
            case 4:
                constraint.layout.bottomMargin = value;
                return;
            case 5:
                constraint.layout.baselineMargin = value;
                return;
            case 6:
                constraint.layout.startMargin = value;
                return;
            case 7:
                constraint.layout.endMargin = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int id, int... referenced) {
        get(id).layout.mReferenceIds = referenced;
    }

    public void setRotation(int viewId, float rotation) {
        get(viewId).transform.rotation = rotation;
    }

    public void setRotationX(int viewId, float rotationX) {
        get(viewId).transform.rotationX = rotationX;
    }

    public void setRotationY(int viewId, float rotationY) {
        get(viewId).transform.rotationY = rotationY;
    }

    public void setScaleX(int viewId, float scaleX) {
        get(viewId).transform.scaleX = scaleX;
    }

    public void setScaleY(int viewId, float scaleY) {
        get(viewId).transform.scaleY = scaleY;
    }

    public void setStringValue(int viewId, String attributeName, String value) {
        get(viewId).setStringValue(attributeName, value);
    }

    public void setTransformPivot(int viewId, float transformPivotX, float transformPivotY) {
        Transform transform = get(viewId).transform;
        transform.transformPivotY = transformPivotY;
        transform.transformPivotX = transformPivotX;
    }

    public void setTransformPivotX(int viewId, float transformPivotX) {
        get(viewId).transform.transformPivotX = transformPivotX;
    }

    public void setTransformPivotY(int viewId, float transformPivotY) {
        get(viewId).transform.transformPivotY = transformPivotY;
    }

    public void setTranslation(int viewId, float translationX, float translationY) {
        Transform transform = get(viewId).transform;
        transform.translationX = translationX;
        transform.translationY = translationY;
    }

    public void setTranslationX(int viewId, float translationX) {
        get(viewId).transform.translationX = translationX;
    }

    public void setTranslationY(int viewId, float translationY) {
        get(viewId).transform.translationY = translationY;
    }

    public void setTranslationZ(int viewId, float translationZ) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(viewId).transform.translationZ = translationZ;
        }
    }

    public void setValidateOnParse(boolean validate) {
        this.mValidate = validate;
    }

    public void setVerticalBias(int viewId, float bias) {
        get(viewId).layout.verticalBias = bias;
    }

    public void setVerticalChainStyle(int viewId, int chainStyle) {
        get(viewId).layout.verticalChainStyle = chainStyle;
    }

    public void setVerticalWeight(int viewId, float weight) {
        get(viewId).layout.verticalWeight = weight;
    }

    public void setVisibility(int viewId, int visibility) {
        get(viewId).propertySet.visibility = visibility;
    }

    public void setVisibilityMode(int viewId, int visibilityMode) {
        get(viewId).propertySet.mVisibilityMode = visibilityMode;
    }

    public void writeState(Writer writer, ConstraintLayout layout, int flags) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((flags & 1) == 1) {
            new WriteXmlEngine(writer, layout, flags).writeLayout();
        } else {
            new WriteJsonEngine(writer, layout, flags).writeLayout();
        }
        writer.write("\n---------------------------------------------\n");
    }

    private void createHorizontalChain(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style, int left, int right) {
        if (chainIds.length >= 2) {
            if (weights != null && weights.length != chainIds.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (weights != null) {
                get(chainIds[0]).layout.horizontalWeight = weights[0];
            }
            get(chainIds[0]).layout.horizontalChainStyle = style;
            connect(chainIds[0], left, leftId, leftSide, -1);
            for (int i2 = 1; i2 < chainIds.length; i2++) {
                int i3 = chainIds[i2];
                int i4 = i2 - 1;
                connect(chainIds[i2], left, chainIds[i4], right, -1);
                connect(chainIds[i4], right, chainIds[i2], left, -1);
                if (weights != null) {
                    get(chainIds[i2]).layout.horizontalWeight = weights[i2];
                }
            }
            connect(chainIds[chainIds.length - 1], right, rightId, rightSide, -1);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void clear(int viewId, int anchor) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(viewId)) || (constraint = this.mConstraints.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        switch (anchor) {
            case 1:
                Layout layout = constraint.layout;
                layout.leftToRight = -1;
                layout.leftToLeft = -1;
                layout.leftMargin = -1;
                layout.goneLeftMargin = Integer.MIN_VALUE;
                return;
            case 2:
                Layout layout2 = constraint.layout;
                layout2.rightToRight = -1;
                layout2.rightToLeft = -1;
                layout2.rightMargin = -1;
                layout2.goneRightMargin = Integer.MIN_VALUE;
                return;
            case 3:
                Layout layout3 = constraint.layout;
                layout3.topToBottom = -1;
                layout3.topToTop = -1;
                layout3.topMargin = 0;
                layout3.goneTopMargin = Integer.MIN_VALUE;
                return;
            case 4:
                Layout layout4 = constraint.layout;
                layout4.bottomToTop = -1;
                layout4.bottomToBottom = -1;
                layout4.bottomMargin = 0;
                layout4.goneBottomMargin = Integer.MIN_VALUE;
                return;
            case 5:
                Layout layout5 = constraint.layout;
                layout5.baselineToBaseline = -1;
                layout5.baselineToTop = -1;
                layout5.baselineToBottom = -1;
                layout5.baselineMargin = 0;
                layout5.goneBaselineMargin = Integer.MIN_VALUE;
                return;
            case 6:
                Layout layout6 = constraint.layout;
                layout6.startToEnd = -1;
                layout6.startToStart = -1;
                layout6.startMargin = 0;
                layout6.goneStartMargin = Integer.MIN_VALUE;
                return;
            case 7:
                Layout layout7 = constraint.layout;
                layout7.endToStart = -1;
                layout7.endToEnd = -1;
                layout7.endMargin = 0;
                layout7.goneEndMargin = Integer.MIN_VALUE;
                return;
            case 8:
                Layout layout8 = constraint.layout;
                layout8.circleAngle = -1.0f;
                layout8.circleRadius = -1;
                layout8.circleConstraint = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void clone(ConstraintSet set) {
        this.mConstraints.clear();
        for (Integer num : set.mConstraints.keySet()) {
            Constraint constraint = set.mConstraints.get(num);
            if (constraint != null) {
                this.mConstraints.put(num, constraint.m5clone());
            }
        }
    }

    /* loaded from: classes.dex */
    public class WriteJsonEngine {
        private static final String SPACE = "       ";
        public Context context;
        public int flags;
        public ConstraintLayout layout;
        public Writer writer;
        public int unknownCount = 0;
        public final String LEFT = "'left'";
        public final String RIGHT = "'right'";
        public final String BASELINE = "'baseline'";
        public final String BOTTOM = "'bottom'";
        public final String TOP = "'top'";
        public final String START = "'start'";
        public final String END = "'end'";
        public HashMap<Integer, String> idMap = new HashMap<>();

        public WriteJsonEngine(Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.writer = writer;
            this.layout = layout;
            this.context = layout.getContext();
            this.flags = flags;
        }

        private void writeDimension(String dimString, int dim, int dimDefault, float dimPercent, int dimMin, int dimMax, boolean constrainedDim) throws IOException {
            if (dim != 0) {
                if (dim == -2) {
                    Writer writer = this.writer;
                    StringBuilder sb = new StringBuilder(String.valueOf(dimString).length() + 16);
                    sb.append(SPACE);
                    sb.append(dimString);
                    sb.append(": 'wrap'\n");
                    writer.write(sb.toString());
                } else if (dim == -1) {
                    Writer writer2 = this.writer;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(dimString).length() + 18);
                    sb2.append(SPACE);
                    sb2.append(dimString);
                    sb2.append(": 'parent'\n");
                    writer2.write(sb2.toString());
                } else {
                    Writer writer3 = this.writer;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(dimString).length() + 22);
                    sb3.append(SPACE);
                    sb3.append(dimString);
                    sb3.append(": ");
                    sb3.append(dim);
                    sb3.append(",\n");
                    writer3.write(sb3.toString());
                }
            } else if (dimMax == -1 && dimMin == -1) {
                if (dimDefault == 1) {
                    Writer writer4 = this.writer;
                    StringBuilder sb4 = new StringBuilder(String.valueOf(dimString).length() + 24);
                    sb4.append(SPACE);
                    sb4.append(dimString);
                    sb4.append(": '???????????',\n");
                    writer4.write(sb4.toString());
                } else if (dimDefault != 2) {
                } else {
                    Writer writer5 = this.writer;
                    StringBuilder sb5 = new StringBuilder(String.valueOf(dimString).length() + 29);
                    sb5.append(SPACE);
                    sb5.append(dimString);
                    sb5.append(": '");
                    sb5.append(dimPercent);
                    sb5.append("%',\n");
                    writer5.write(sb5.toString());
                }
            } else if (dimDefault == 0) {
                Writer writer6 = this.writer;
                StringBuilder sb6 = new StringBuilder(String.valueOf(dimString).length() + 46);
                sb6.append(SPACE);
                sb6.append(dimString);
                sb6.append(": {'spread' ,");
                sb6.append(dimMin);
                sb6.append(", ");
                sb6.append(dimMax);
                sb6.append("}\n");
                writer6.write(sb6.toString());
            } else if (dimDefault == 1) {
                Writer writer7 = this.writer;
                StringBuilder sb7 = new StringBuilder(String.valueOf(dimString).length() + 44);
                sb7.append(SPACE);
                sb7.append(dimString);
                sb7.append(": {'wrap' ,");
                sb7.append(dimMin);
                sb7.append(", ");
                sb7.append(dimMax);
                sb7.append("}\n");
                writer7.write(sb7.toString());
            } else if (dimDefault != 2) {
            } else {
                Writer writer8 = this.writer;
                StringBuilder sb8 = new StringBuilder(String.valueOf(dimString).length() + 56);
                sb8.append(SPACE);
                sb8.append(dimString);
                sb8.append(": {'");
                sb8.append(dimPercent);
                sb8.append("'% ,");
                sb8.append(dimMin);
                sb8.append(", ");
                sb8.append(dimMax);
                sb8.append("}\n");
                writer8.write(sb8.toString());
            }
        }

        private void writeGuideline(int orientation, int guideBegin, int guideEnd, float guidePercent) {
        }

        public String getName(int id) {
            if (this.idMap.containsKey(Integer.valueOf(id))) {
                String str = this.idMap.get(Integer.valueOf(id));
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2);
                sb.append("'");
                sb.append(str);
                sb.append("'");
                return sb.toString();
            } else if (id == 0) {
                return "'parent'";
            } else {
                String lookup = lookup(id);
                this.idMap.put(Integer.valueOf(id), lookup);
                StringBuilder sb2 = new StringBuilder(String.valueOf(lookup).length() + 2);
                sb2.append("'");
                sb2.append(lookup);
                sb2.append("'");
                return sb2.toString();
            }
        }

        public String lookup(int id) {
            try {
                if (id != -1) {
                    return this.context.getResources().getResourceEntryName(id);
                }
                int i2 = this.unknownCount + 1;
                this.unknownCount = i2;
                StringBuilder sb = new StringBuilder(18);
                sb.append("unknown");
                sb.append(i2);
                return sb.toString();
            } catch (Exception unused) {
                int i3 = this.unknownCount + 1;
                this.unknownCount = i3;
                StringBuilder sb2 = new StringBuilder(18);
                sb2.append("unknown");
                sb2.append(i3);
                return sb2.toString();
            }
        }

        public void writeCircle(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint == -1) {
                return;
            }
            this.writer.write("       circle");
            this.writer.write(":[");
            this.writer.write(getName(circleConstraint));
            Writer writer = this.writer;
            StringBuilder sb = new StringBuilder(17);
            sb.append(", ");
            sb.append(circleAngle);
            writer.write(sb.toString());
            Writer writer2 = this.writer;
            StringBuilder sb2 = new StringBuilder(12);
            sb2.append(circleRadius);
            sb2.append("]");
            writer2.write(sb2.toString());
        }

        public void writeConstraint(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(my);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            this.writer.write(":[");
            this.writer.write(getName(leftToLeft));
            this.writer.write(" , ");
            this.writer.write(other);
            if (margin != 0) {
                Writer writer2 = this.writer;
                StringBuilder sb = new StringBuilder(14);
                sb.append(" , ");
                sb.append(margin);
                writer2.write(sb.toString());
            }
            this.writer.write("],\n");
        }

        public void writeLayout() throws IOException {
            this.writer.write("\n'ConstraintSet':{\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                this.writer.write(String.valueOf(getName(num.intValue())).concat(":{\n"));
                Layout layout = ((Constraint) ConstraintSet.this.mConstraints.get(num)).layout;
                writeDimension("height", layout.mHeight, layout.heightDefault, layout.heightPercent, layout.heightMin, layout.heightMax, layout.constrainedHeight);
                writeDimension("width", layout.mWidth, layout.widthDefault, layout.widthPercent, layout.widthMin, layout.widthMax, layout.constrainedWidth);
                writeConstraint("'left'", layout.leftToLeft, "'left'", layout.leftMargin, layout.goneLeftMargin);
                writeConstraint("'left'", layout.leftToRight, "'right'", layout.leftMargin, layout.goneLeftMargin);
                writeConstraint("'right'", layout.rightToLeft, "'left'", layout.rightMargin, layout.goneRightMargin);
                writeConstraint("'right'", layout.rightToRight, "'right'", layout.rightMargin, layout.goneRightMargin);
                writeConstraint("'baseline'", layout.baselineToBaseline, "'baseline'", -1, layout.goneBaselineMargin);
                writeConstraint("'baseline'", layout.baselineToTop, "'top'", -1, layout.goneBaselineMargin);
                writeConstraint("'baseline'", layout.baselineToBottom, "'bottom'", -1, layout.goneBaselineMargin);
                writeConstraint("'top'", layout.topToBottom, "'bottom'", layout.topMargin, layout.goneTopMargin);
                writeConstraint("'top'", layout.topToTop, "'top'", layout.topMargin, layout.goneTopMargin);
                writeConstraint("'bottom'", layout.bottomToBottom, "'bottom'", layout.bottomMargin, layout.goneBottomMargin);
                writeConstraint("'bottom'", layout.bottomToTop, "'top'", layout.bottomMargin, layout.goneBottomMargin);
                writeConstraint("'start'", layout.startToStart, "'start'", layout.startMargin, layout.goneStartMargin);
                writeConstraint("'start'", layout.startToEnd, "'end'", layout.startMargin, layout.goneStartMargin);
                writeConstraint("'end'", layout.endToStart, "'start'", layout.endMargin, layout.goneEndMargin);
                writeConstraint("'end'", layout.endToEnd, "'end'", layout.endMargin, layout.goneEndMargin);
                writeVariable("'horizontalBias'", layout.horizontalBias, 0.5f);
                writeVariable("'verticalBias'", layout.verticalBias, 0.5f);
                writeCircle(layout.circleConstraint, layout.circleAngle, layout.circleRadius);
                writeGuideline(layout.orientation, layout.guideBegin, layout.guideEnd, layout.guidePercent);
                writeVariable("'dimensionRatio'", layout.dimensionRatio);
                writeVariable("'barrierMargin'", layout.mBarrierMargin);
                writeVariable("'type'", layout.mHelperType);
                writeVariable("'ReferenceId'", layout.mReferenceIdString);
                writeVariable("'mBarrierAllowsGoneWidgets'", layout.mBarrierAllowsGoneWidgets, true);
                writeVariable("'WrapBehavior'", layout.mWrapBehavior);
                writeVariable("'verticalWeight'", layout.verticalWeight);
                writeVariable("'horizontalWeight'", layout.horizontalWeight);
                writeVariable("'horizontalChainStyle'", layout.horizontalChainStyle);
                writeVariable("'verticalChainStyle'", layout.verticalChainStyle);
                writeVariable("'barrierDirection'", layout.mBarrierDirection);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writeVariable("'ReferenceIds'", iArr);
                }
                this.writer.write("}\n");
            }
            this.writer.write("}\n");
        }

        public void writeVariable(String name, int value) throws IOException {
            if (value == 0 || value == -1) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            this.writer.write(Constants.COLON_SEPARATOR);
            Writer writer2 = this.writer;
            StringBuilder sb = new StringBuilder(13);
            sb.append(", ");
            sb.append(value);
            writer2.write(sb.toString());
            this.writer.write("\n");
        }

        public void writeVariable(String name, float value) throws IOException {
            if (value == -1.0f) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            Writer writer2 = this.writer;
            StringBuilder sb = new StringBuilder(17);
            sb.append(": ");
            sb.append(value);
            writer2.write(sb.toString());
            this.writer.write(",\n");
        }

        public void writeVariable(String name, float value, float def) throws IOException {
            if (value == def) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            Writer writer2 = this.writer;
            StringBuilder sb = new StringBuilder(17);
            sb.append(": ");
            sb.append(value);
            writer2.write(sb.toString());
            this.writer.write(",\n");
        }

        public void writeVariable(String name, boolean value) throws IOException {
            if (value) {
                Writer writer = this.writer;
                String valueOf = String.valueOf(name);
                writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
                Writer writer2 = this.writer;
                StringBuilder sb = new StringBuilder(7);
                sb.append(": ");
                sb.append(value);
                writer2.write(sb.toString());
                this.writer.write(",\n");
            }
        }

        public void writeVariable(String name, boolean value, boolean def) throws IOException {
            if (value == def) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            Writer writer2 = this.writer;
            StringBuilder sb = new StringBuilder(7);
            sb.append(": ");
            sb.append(value);
            writer2.write(sb.toString());
            this.writer.write(",\n");
        }

        public void writeVariable(String name, int[] value) throws IOException {
            if (value == null) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            this.writer.write(": ");
            int i2 = 0;
            while (i2 < value.length) {
                Writer writer2 = this.writer;
                String str = i2 == 0 ? "[" : ", ";
                String valueOf2 = String.valueOf(getName(value[i2]));
                writer2.write(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                i2++;
            }
            this.writer.write("],\n");
        }

        public void writeVariable(String name, String value) throws IOException {
            if (value == null) {
                return;
            }
            Writer writer = this.writer;
            String valueOf = String.valueOf(name);
            writer.write(valueOf.length() != 0 ? SPACE.concat(valueOf) : new String(SPACE));
            this.writer.write(Constants.COLON_SEPARATOR);
            Writer writer2 = this.writer;
            String valueOf2 = String.valueOf(value);
            writer2.write(valueOf2.length() != 0 ? ", ".concat(valueOf2) : new String(", "));
            this.writer.write("\n");
        }
    }

    public void centerHorizontally(int viewId, int toView) {
        if (toView == 0) {
            center(viewId, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(viewId, toView, 2, 0, toView, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int viewId, int toView) {
        if (toView == 0) {
            center(viewId, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(viewId, toView, 7, 0, toView, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int viewId, int toView) {
        if (toView == 0) {
            center(viewId, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(viewId, toView, 4, 0, toView, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
                constraint.fillFrom(id, layoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 17) {
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        Transform transform = constraint.transform;
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    if (i3 >= 21) {
                        constraint.transform.translationZ = childAt.getTranslationZ();
                        Transform transform2 = constraint.transform;
                        if (transform2.applyElevation) {
                            transform2.elevation = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cd, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                if (!constraint.layout.mApply) {
                    constraint.fillFrom(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 17) {
                    Transform transform = constraint.transform;
                    if (!transform.mApply) {
                        transform.mApply = true;
                        transform.rotation = childAt.getRotation();
                        constraint.transform.rotationX = childAt.getRotationX();
                        constraint.transform.rotationY = childAt.getRotationY();
                        constraint.transform.scaleX = childAt.getScaleX();
                        constraint.transform.scaleY = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (pivotX != 0.0d || pivotY != 0.0d) {
                            Transform transform2 = constraint.transform;
                            transform2.transformPivotX = pivotX;
                            transform2.transformPivotY = pivotY;
                        }
                        constraint.transform.translationX = childAt.getTranslationX();
                        constraint.transform.translationY = childAt.getTranslationY();
                        if (i3 >= 21) {
                            constraint.transform.translationZ = childAt.getTranslationZ();
                            Transform transform3 = constraint.transform;
                            if (transform3.applyElevation) {
                                transform3.elevation = childAt.getElevation();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c2, int type, int value) {
        if (type == 6) {
            c2.layout.editorAbsoluteX = value;
        } else if (type == 7) {
            c2.layout.editorAbsoluteY = value;
        } else if (type == 8) {
            c2.layout.endMargin = value;
        } else if (type == 27) {
            c2.layout.orientation = value;
        } else if (type == 28) {
            c2.layout.rightMargin = value;
        } else if (type == 41) {
            c2.layout.horizontalChainStyle = value;
        } else if (type == 42) {
            c2.layout.verticalChainStyle = value;
        } else if (type == 61) {
            c2.layout.circleConstraint = value;
        } else if (type == 62) {
            c2.layout.circleRadius = value;
        } else if (type == 72) {
            c2.layout.mBarrierDirection = value;
        } else if (type != 73) {
            switch (type) {
                case 2:
                    c2.layout.bottomMargin = value;
                    return;
                case 11:
                    c2.layout.goneBottomMargin = value;
                    return;
                case 12:
                    c2.layout.goneEndMargin = value;
                    return;
                case 13:
                    c2.layout.goneLeftMargin = value;
                    return;
                case 14:
                    c2.layout.goneRightMargin = value;
                    return;
                case 15:
                    c2.layout.goneStartMargin = value;
                    return;
                case 16:
                    c2.layout.goneTopMargin = value;
                    return;
                case 17:
                    c2.layout.guideBegin = value;
                    return;
                case 18:
                    c2.layout.guideEnd = value;
                    return;
                case 31:
                    c2.layout.startMargin = value;
                    return;
                case 34:
                    c2.layout.topMargin = value;
                    return;
                case 38:
                    c2.mViewId = value;
                    return;
                case 64:
                    c2.motion.mAnimateRelativeTo = value;
                    return;
                case 66:
                    c2.motion.mDrawPath = value;
                    return;
                case 76:
                    c2.motion.mPathMotionArc = value;
                    return;
                case 78:
                    c2.propertySet.mVisibilityMode = value;
                    return;
                case 93:
                    c2.layout.baselineMargin = value;
                    return;
                case 94:
                    c2.layout.goneBaselineMargin = value;
                    return;
                case 97:
                    c2.layout.mWrapBehavior = value;
                    return;
                default:
                    switch (type) {
                        case 21:
                            c2.layout.mHeight = value;
                            return;
                        case 22:
                            c2.propertySet.visibility = value;
                            return;
                        case 23:
                            c2.layout.mWidth = value;
                            return;
                        case 24:
                            c2.layout.leftMargin = value;
                            return;
                        default:
                            switch (type) {
                                case 54:
                                    c2.layout.widthDefault = value;
                                    return;
                                case 55:
                                    c2.layout.heightDefault = value;
                                    return;
                                case 56:
                                    c2.layout.widthMax = value;
                                    return;
                                case 57:
                                    c2.layout.heightMax = value;
                                    return;
                                case 58:
                                    c2.layout.widthMin = value;
                                    return;
                                case 59:
                                    c2.layout.heightMin = value;
                                    return;
                                default:
                                    switch (type) {
                                        case 82:
                                            c2.motion.mAnimateCircleAngleTo = value;
                                            return;
                                        case 83:
                                            c2.transform.transformPivotTarget = value;
                                            return;
                                        case 84:
                                            c2.motion.mQuantizeMotionSteps = value;
                                            return;
                                        default:
                                            switch (type) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    c2.motion.mQuantizeInterpolatorType = value;
                                                    return;
                                                case 89:
                                                    c2.motion.mQuantizeInterpolatorID = value;
                                                    return;
                                                default:
                                                    Log.w(TAG, "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            c2.layout.mBarrierMargin = value;
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    constraint.fillFromConstraints((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.fillFromConstraints(id, layoutParams);
            }
        }
    }

    public void connect(int startID, int startSide, int endID, int endSide) {
        if (!this.mConstraints.containsKey(Integer.valueOf(startID))) {
            this.mConstraints.put(Integer.valueOf(startID), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(startID));
        if (constraint == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = endID;
                    layout.leftToRight = -1;
                    return;
                } else if (endSide == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = endID;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    String sideToString = sideToString(endSide);
                    StringBuilder sb = new StringBuilder(String.valueOf(sideToString).length() + 18);
                    sb.append("left to ");
                    sb.append(sideToString);
                    sb.append(" undefined");
                    throw new IllegalArgumentException(sb.toString());
                }
            case 2:
                if (endSide == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = endID;
                    layout3.rightToRight = -1;
                    return;
                } else if (endSide == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = endID;
                    layout4.rightToLeft = -1;
                    return;
                } else {
                    String sideToString2 = sideToString(endSide);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(sideToString2).length() + 19);
                    sb2.append("right to ");
                    sb2.append(sideToString2);
                    sb2.append(" undefined");
                    throw new IllegalArgumentException(sb2.toString());
                }
            case 3:
                if (endSide == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = endID;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                    return;
                } else if (endSide == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = endID;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                    return;
                } else {
                    String sideToString3 = sideToString(endSide);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(sideToString3).length() + 19);
                    sb3.append("right to ");
                    sb3.append(sideToString3);
                    sb3.append(" undefined");
                    throw new IllegalArgumentException(sb3.toString());
                }
            case 4:
                if (endSide == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = endID;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                    return;
                } else if (endSide == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = endID;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                    return;
                } else {
                    String sideToString4 = sideToString(endSide);
                    StringBuilder sb4 = new StringBuilder(String.valueOf(sideToString4).length() + 19);
                    sb4.append("right to ");
                    sb4.append(sideToString4);
                    sb4.append(" undefined");
                    throw new IllegalArgumentException(sb4.toString());
                }
            case 5:
                if (endSide == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = endID;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                } else if (endSide == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = endID;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                } else if (endSide == 4) {
                    Layout layout11 = constraint.layout;
                    layout11.baselineToBottom = endID;
                    layout11.bottomToBottom = -1;
                    layout11.bottomToTop = -1;
                    layout11.topToTop = -1;
                    layout11.topToBottom = -1;
                    return;
                } else {
                    String sideToString5 = sideToString(endSide);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(sideToString5).length() + 19);
                    sb5.append("right to ");
                    sb5.append(sideToString5);
                    sb5.append(" undefined");
                    throw new IllegalArgumentException(sb5.toString());
                }
            case 6:
                if (endSide == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = endID;
                    layout12.startToEnd = -1;
                    return;
                } else if (endSide == 7) {
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = endID;
                    layout13.startToStart = -1;
                    return;
                } else {
                    String sideToString6 = sideToString(endSide);
                    StringBuilder sb6 = new StringBuilder(String.valueOf(sideToString6).length() + 19);
                    sb6.append("right to ");
                    sb6.append(sideToString6);
                    sb6.append(" undefined");
                    throw new IllegalArgumentException(sb6.toString());
                }
            case 7:
                if (endSide == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = endID;
                    layout14.endToStart = -1;
                    return;
                } else if (endSide == 6) {
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = endID;
                    layout15.endToEnd = -1;
                    return;
                } else {
                    String sideToString7 = sideToString(endSide);
                    StringBuilder sb7 = new StringBuilder(String.valueOf(sideToString7).length() + 19);
                    sb7.append("right to ");
                    sb7.append(sideToString7);
                    sb7.append(" undefined");
                    throw new IllegalArgumentException(sb7.toString());
                }
            default:
                String sideToString8 = sideToString(startSide);
                String sideToString9 = sideToString(endSide);
                StringBuilder sb8 = new StringBuilder(String.valueOf(sideToString8).length() + 12 + String.valueOf(sideToString9).length());
                sb8.append(sideToString8);
                sb8.append(" to ");
                sb8.append(sideToString9);
                sb8.append(" unknown");
                throw new IllegalArgumentException(sb8.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c2, int type, String value) {
        if (type == 5) {
            c2.layout.dimensionRatio = value;
        } else if (type == 65) {
            c2.motion.mTransitionEasing = value;
        } else if (type == 74) {
            Layout layout = c2.layout;
            layout.mReferenceIdString = value;
            layout.mReferenceIds = null;
        } else if (type == 77) {
            c2.layout.mConstraintTag = value;
        } else if (type != 87) {
            if (type != 90) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                c2.motion.mQuantizeInterpolatorString = value;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint c2, int type, boolean value) {
        if (type == 44) {
            c2.transform.applyElevation = value;
        } else if (type == 75) {
            c2.layout.mBarrierAllowsGoneWidgets = value;
        } else if (type != 87) {
            if (type == 80) {
                c2.layout.constrainedWidth = value;
            } else if (type != 81) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                c2.layout.constrainedHeight = value;
            }
        }
    }
}
