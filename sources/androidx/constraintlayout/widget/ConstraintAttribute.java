package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ConstraintAttribute {
    private static final String TAG = "TransitionLayout";
    public boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    public String mName;
    private String mStringValue;
    private AttributeType mType;

    /* renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;

        static {
            int[] iArr = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public ConstraintAttribute(String name, AttributeType attributeType) {
        this.mMethod = false;
        this.mName = name;
        this.mType = attributeType;
    }

    private static int clamp(int c2) {
        int i2 = (c2 & (~(c2 >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> base, View view) {
        HashMap<String, ConstraintAttribute> hashMap = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : base.keySet()) {
            ConstraintAttribute constraintAttribute = base.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    String valueOf = String.valueOf(str);
                    hashMap.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod(valueOf.length() != 0 ? "getMap".concat(valueOf) : new String("getMap"), new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return hashMap;
    }

    public static void parse(Context context, XmlPullParser parser, HashMap<String, ConstraintAttribute> custom) {
        AttributeType attributeType;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        boolean z = false;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    char upperCase = Character.toUpperCase(str.charAt(0));
                    String substring = str.substring(1);
                    StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 1);
                    sb.append(upperCase);
                    sb.append(substring);
                    str = sb.toString();
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.CustomAttribute_customReference) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            custom.put(str, new ConstraintAttribute(str, attributeType2, obj, z));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> map) {
        String str;
        Class<?> cls = view.getClass();
        for (String str2 : map.keySet()) {
            ConstraintAttribute constraintAttribute = map.get(str2);
            if (constraintAttribute.mMethod) {
                str = str2;
            } else {
                String valueOf = String.valueOf(str2);
                str = valueOf.length() != 0 ? "set".concat(valueOf) : new String("set");
            }
            try {
                switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[constraintAttribute.mType.ordinal()]) {
                    case 1:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.mIntegerValue));
                        break;
                    case 2:
                        cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.mBooleanValue));
                        break;
                    case 3:
                        cls.getMethod(str, CharSequence.class).invoke(view, constraintAttribute.mStringValue);
                        break;
                    case 4:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.mColorValue));
                        break;
                    case 5:
                        Method method = cls.getMethod(str, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.mColorValue);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.mIntegerValue));
                        break;
                    case 7:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                    case 8:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                }
            } catch (IllegalAccessException e2) {
                String name = cls.getName();
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 34 + String.valueOf(name).length());
                sb.append(" Custom Attribute \"");
                sb.append(str2);
                sb.append("\" not found on ");
                sb.append(name);
                Log.e(TAG, sb.toString());
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                Log.e(TAG, e3.getMessage());
                String name2 = cls.getName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 34 + String.valueOf(name2).length());
                sb2.append(" Custom Attribute \"");
                sb2.append(str2);
                sb2.append("\" not found on ");
                sb2.append(name2);
                Log.e(TAG, sb2.toString());
                String name3 = cls.getName();
                StringBuilder sb3 = new StringBuilder(String.valueOf(name3).length() + 20 + String.valueOf(str).length());
                sb3.append(name3);
                sb3.append(" must have a method ");
                sb3.append(str);
                Log.e(TAG, sb3.toString());
            } catch (InvocationTargetException e4) {
                String name4 = cls.getName();
                StringBuilder sb4 = new StringBuilder(String.valueOf(str2).length() + 34 + String.valueOf(name4).length());
                sb4.append(" Custom Attribute \"");
                sb4.append(str2);
                sb4.append("\" not found on ");
                sb4.append(name4);
                Log.e(TAG, sb4.toString());
                e4.printStackTrace();
            }
        }
    }

    public void applyCustom(View view) {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.mName;
        if (this.mMethod) {
            str = str2;
        } else {
            String valueOf = String.valueOf(str2);
            str = valueOf.length() != 0 ? "set".concat(valueOf) : new String("set");
        }
        try {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                case 1:
                case 6:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.mIntegerValue));
                    return;
                case 2:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(this.mBooleanValue));
                    return;
                case 3:
                    cls.getMethod(str, CharSequence.class).invoke(view, this.mStringValue);
                    return;
                case 4:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.mColorValue));
                    return;
                case 5:
                    Method method = cls.getMethod(str, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.mColorValue);
                    method.invoke(view, colorDrawable);
                    return;
                case 7:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.mFloatValue));
                    return;
                case 8:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.mFloatValue));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e2) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 34 + String.valueOf(name).length());
            sb.append(" Custom Attribute \"");
            sb.append(str2);
            sb.append("\" not found on ");
            sb.append(name);
            Log.e(TAG, sb.toString());
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            Log.e(TAG, e3.getMessage());
            String name2 = cls.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 34 + String.valueOf(name2).length());
            sb2.append(" Custom Attribute \"");
            sb2.append(str2);
            sb2.append("\" not found on ");
            sb2.append(name2);
            Log.e(TAG, sb2.toString());
            String name3 = cls.getName();
            StringBuilder sb3 = new StringBuilder(String.valueOf(name3).length() + 20 + String.valueOf(str).length());
            sb3.append(name3);
            sb3.append(" must have a method ");
            sb3.append(str);
            Log.e(TAG, sb3.toString());
        } catch (InvocationTargetException e4) {
            String name4 = cls.getName();
            StringBuilder sb4 = new StringBuilder(String.valueOf(str2).length() + 34 + String.valueOf(name4).length());
            sb4.append(" Custom Attribute \"");
            sb4.append(str2);
            sb4.append("\" not found on ");
            sb4.append(name4);
            Log.e(TAG, sb4.toString());
            e4.printStackTrace();
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        AttributeType attributeType;
        if (constraintAttribute == null || (attributeType = this.mType) != constraintAttribute.mType) {
            return false;
        }
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[attributeType.ordinal()]) {
            case 1:
            case 6:
                return this.mIntegerValue == constraintAttribute.mIntegerValue;
            case 2:
                return this.mBooleanValue == constraintAttribute.mBooleanValue;
            case 3:
                return this.mIntegerValue == constraintAttribute.mIntegerValue;
            case 4:
            case 5:
                return this.mColorValue == constraintAttribute.mColorValue;
            case 7:
                return this.mFloatValue == constraintAttribute.mFloatValue;
            case 8:
                return this.mFloatValue == constraintAttribute.mFloatValue;
            default:
                return false;
        }
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 2:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.mIntegerValue;
            case 7:
                return this.mFloatValue;
            case 8:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] ret) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 2:
                ret[0] = this.mBooleanValue ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i2 = this.mColorValue;
                float pow = (float) Math.pow(((i2 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i2 >> 8) & 255) / 255.0f, 2.2d);
                ret[0] = pow;
                ret[1] = pow2;
                ret[2] = (float) Math.pow((i2 & 255) / 255.0f, 2.2d);
                ret[3] = ((i2 >> 24) & 255) / 255.0f;
                return;
            case 6:
                ret[0] = this.mIntegerValue;
                return;
            case 7:
                ret[0] = this.mFloatValue;
                return;
            case 8:
                ret[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        return (i2 == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        return (i2 == 4 || i2 == 5) ? 4 : 1;
    }

    public void setColorValue(int value) {
        this.mColorValue = value;
    }

    public void setFloatValue(float value) {
        this.mFloatValue = value;
    }

    public void setIntValue(int value) {
        this.mIntegerValue = value;
    }

    public void setInterpolatedValue(View view, float[] value) {
        Class<?> cls = view.getClass();
        String valueOf = String.valueOf(this.mName);
        String concat = valueOf.length() != 0 ? "set".concat(valueOf) : new String("set");
        try {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                case 2:
                    Method method = cls.getMethod(concat, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(value[0] > 0.5f);
                    method.invoke(view, objArr);
                    return;
                case 3:
                    String valueOf2 = String.valueOf(this.mName);
                    throw new RuntimeException(valueOf2.length() != 0 ? "unable to interpolate strings ".concat(valueOf2) : new String("unable to interpolate strings "));
                case 4:
                    cls.getMethod(concat, Integer.TYPE).invoke(view, Integer.valueOf((clamp((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (value[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 5:
                    Method method2 = cls.getMethod(concat, Drawable.class);
                    int clamp = clamp((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f));
                    int clamp2 = clamp((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((clamp << 16) | (clamp((int) (value[3] * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f)));
                    method2.invoke(view, colorDrawable);
                    return;
                case 6:
                    cls.getMethod(concat, Integer.TYPE).invoke(view, Integer.valueOf((int) value[0]));
                    return;
                case 7:
                    cls.getMethod(concat, Float.TYPE).invoke(view, Float.valueOf(value[0]));
                    return;
                case 8:
                    cls.getMethod(concat, Float.TYPE).invoke(view, Float.valueOf(value[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e2) {
            String name = Debug.getName(view);
            StringBuilder sb = new StringBuilder(String.valueOf(concat).length() + 32 + String.valueOf(name).length());
            sb.append("cannot access method ");
            sb.append(concat);
            sb.append(" on View \"");
            sb.append(name);
            sb.append("\"");
            Log.e(TAG, sb.toString());
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            String name2 = Debug.getName(view);
            StringBuilder sb2 = new StringBuilder(String.valueOf(concat).length() + 21 + String.valueOf(name2).length());
            sb2.append("no method ");
            sb2.append(concat);
            sb2.append(" on View \"");
            sb2.append(name2);
            sb2.append("\"");
            Log.e(TAG, sb2.toString());
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void setStringValue(String value) {
        this.mStringValue = value;
    }

    public void setValue(float[] value) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = (int) value[0];
                return;
            case 2:
                this.mBooleanValue = ((double) value[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int HSVToColor = Color.HSVToColor(value);
                this.mColorValue = HSVToColor;
                this.mColorValue = (clamp((int) (value[3] * 255.0f)) << 24) | (HSVToColor & 16777215);
                return;
            case 7:
                this.mFloatValue = value[0];
                return;
            case 8:
                this.mFloatValue = value[0];
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(String name, AttributeType attributeType, Object value, boolean method) {
        this.mMethod = false;
        this.mName = name;
        this.mType = attributeType;
        this.mMethod = method;
        setValue(value);
    }

    public void setValue(Object value) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = ((Integer) value).intValue();
                return;
            case 2:
                this.mBooleanValue = ((Boolean) value).booleanValue();
                return;
            case 3:
                this.mStringValue = (String) value;
                return;
            case 4:
            case 5:
                this.mColorValue = ((Integer) value).intValue();
                return;
            case 7:
                this.mFloatValue = ((Float) value).floatValue();
                return;
            case 8:
                this.mFloatValue = ((Float) value).floatValue();
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(ConstraintAttribute source, Object value) {
        this.mMethod = false;
        this.mName = source.mName;
        this.mType = source.mType;
        setValue(value);
    }
}
