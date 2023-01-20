package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class TypedBundle {
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

    public void add(int i2, int i3) {
        int i4 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i4 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i5 = this.mCountInt;
        iArr3[i5] = i2;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i5 + 1;
        iArr4[i5] = i3;
    }

    public void addIfNotNull(int i2, String str) {
        if (str != null) {
            add(i2, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i2 = 0; i2 < this.mCountInt; i2++) {
            typedValues.setValue(this.mTypeInt[i2], this.mValueInt[i2]);
        }
        for (int i3 = 0; i3 < this.mCountFloat; i3++) {
            typedValues.setValue(this.mTypeFloat[i3], this.mValueFloat[i3]);
        }
        for (int i4 = 0; i4 < this.mCountString; i4++) {
            typedValues.setValue(this.mTypeString[i4], this.mValueString[i4]);
        }
        for (int i5 = 0; i5 < this.mCountBoolean; i5++) {
            typedValues.setValue(this.mTypeBoolean[i5], this.mValueBoolean[i5]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i2) {
        for (int i3 = 0; i3 < this.mCountInt; i3++) {
            if (this.mTypeInt[i3] == i2) {
                return this.mValueInt[i3];
            }
        }
        return -1;
    }

    public void add(int i2, float f2) {
        int i3 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i3 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i4 = this.mCountFloat;
        iArr2[i4] = i2;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i4 + 1;
        fArr2[i4] = f2;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i2 = 0; i2 < this.mCountInt; i2++) {
            typedBundle.add(this.mTypeInt[i2], this.mValueInt[i2]);
        }
        for (int i3 = 0; i3 < this.mCountFloat; i3++) {
            typedBundle.add(this.mTypeFloat[i3], this.mValueFloat[i3]);
        }
        for (int i4 = 0; i4 < this.mCountString; i4++) {
            typedBundle.add(this.mTypeString[i4], this.mValueString[i4]);
        }
        for (int i5 = 0; i5 < this.mCountBoolean; i5++) {
            typedBundle.add(this.mTypeBoolean[i5], this.mValueBoolean[i5]);
        }
    }

    public void add(int i2, String str) {
        int i3 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i3 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i4 = this.mCountString;
        iArr2[i4] = i2;
        String[] strArr2 = this.mValueString;
        this.mCountString = i4 + 1;
        strArr2[i4] = str;
    }

    public void add(int i2, boolean z) {
        int i3 = this.mCountBoolean;
        int[] iArr = this.mTypeBoolean;
        if (i3 >= iArr.length) {
            this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.mValueBoolean;
            this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.mTypeBoolean;
        int i4 = this.mCountBoolean;
        iArr2[i4] = i2;
        boolean[] zArr2 = this.mValueBoolean;
        this.mCountBoolean = i4 + 1;
        zArr2[i4] = z;
    }
}
