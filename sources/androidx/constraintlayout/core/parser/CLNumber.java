package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLNumber extends CLElement {
    public float value;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.value = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.value)) {
            this.value = Float.parseFloat(content());
        }
        return this.value;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.value)) {
            this.value = Integer.parseInt(content());
        }
        return (int) this.value;
    }

    public boolean isInt() {
        float f2 = getFloat();
        return ((float) ((int) f2)) == f2;
    }

    public void putValue(float f2) {
        this.value = f2;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i2);
        float f2 = getFloat();
        int i4 = (int) f2;
        if (i4 == f2) {
            sb.append(i4);
        } else {
            sb.append(f2);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f2 = getFloat();
        int i2 = (int) f2;
        if (i2 == f2) {
            return "" + i2;
        }
        return "" + f2;
    }

    public CLNumber(float f2) {
        super(null);
        this.value = Float.NaN;
        this.value = f2;
    }
}
