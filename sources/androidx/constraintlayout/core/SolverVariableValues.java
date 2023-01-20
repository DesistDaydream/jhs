package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    public final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    public int[] keys = new int[16];
    public int[] nextKeys = new int[16];
    public int[] variables = new int[16];
    public float[] values = new float[16];
    public int[] previous = new int[16];
    public int[] next = new int[16];
    public int mCount = 0;
    public int head = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i2) {
        int[] iArr;
        int i3 = solverVariable.id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.nextKeys;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.nextKeys[i2] = -1;
    }

    private void addVariable(int i2, SolverVariable solverVariable, float f2) {
        this.variables[i2] = solverVariable.id;
        this.values[i2] = f2;
        this.previous[i2] = -1;
        this.next[i2] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i2 = 0; i2 < this.HASH_SIZE; i2++) {
            if (this.keys[i2] != -1) {
                String str = hashCode() + " hash [" + i2 + "] => ";
                int i3 = this.keys[i2];
                boolean z = false;
                while (!z) {
                    str = str + ExpandableTextView.N + this.variables[i3];
                    int[] iArr = this.nextKeys;
                    if (iArr[i3] != -1) {
                        i3 = iArr[i3];
                    } else {
                        z = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i2 = 0; i2 < this.SIZE; i2++) {
            if (this.variables[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i2 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i2);
        this.values = Arrays.copyOf(this.values, i2);
        this.previous = Arrays.copyOf(this.previous, i2);
        this.next = Arrays.copyOf(this.next, i2);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i2);
        for (int i3 = this.SIZE; i3 < i2; i3++) {
            this.variables[i3] = -1;
            this.nextKeys[i3] = -1;
        }
        this.SIZE = i2;
    }

    private void insertVariable(int i2, SolverVariable solverVariable, float f2) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f2);
        if (i2 != -1) {
            this.previous[findEmptySlot] = i2;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i2];
            iArr[i2] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int[] iArr2 = this.next;
        if (iArr2[findEmptySlot] != -1) {
            this.previous[iArr2[findEmptySlot]] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i2 = solverVariable.id;
        int i3 = i2 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            return;
        }
        if (this.variables[i4] == i2) {
            int[] iArr3 = this.nextKeys;
            iArr2[i3] = iArr3[i4];
            iArr3[i4] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            if (iArr[i4] == -1 || this.variables[iArr[i4]] == i2) {
                break;
            }
            i4 = iArr[i4];
        }
        int i5 = iArr[i4];
        if (i5 == -1 || this.variables[i5] != i2) {
            return;
        }
        iArr[i4] = iArr[i5];
        iArr[i5] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f2, boolean z) {
        float f3 = epsilon;
        if (f2 <= (-f3) || f2 >= f3) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f2);
                return;
            }
            float[] fArr = this.values;
            fArr[indexOf] = fArr[indexOf] + f2;
            float f4 = fArr[indexOf];
            float f5 = epsilon;
            if (f4 <= (-f5) || fArr[indexOf] >= f5) {
                return;
            }
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i2 = this.mCount;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i4 = 0; i4 < this.SIZE; i4++) {
            this.variables[i4] = -1;
            this.nextKeys[i4] = -1;
        }
        for (int i5 = 0; i5 < this.HASH_SIZE; i5++) {
            this.keys[i5] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i2 = this.mCount;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i3) + ExpandableTextView.N);
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f2) {
        int i2 = this.mCount;
        int i3 = this.head;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.values;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.next[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i2) {
        int i3 = this.mCount;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.head;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i4]];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i2) {
        int i3 = this.mCount;
        int i4 = this.head;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.values[i4];
            }
            i4 = this.next[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int[] iArr;
        if (this.mCount != 0 && solverVariable != null) {
            int i2 = solverVariable.id;
            int i3 = this.keys[i2 % this.HASH_SIZE];
            if (i3 == -1) {
                return -1;
            }
            if (this.variables[i3] == i2) {
                return i3;
            }
            while (true) {
                iArr = this.nextKeys;
                if (iArr[i3] == -1 || this.variables[iArr[i3]] == i2) {
                    break;
                }
                i3 = iArr[i3];
            }
            if (iArr[i3] != -1 && this.variables[iArr[i3]] == i2) {
                return iArr[i3];
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i2 = this.mCount;
        int i3 = this.head;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.values;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.next[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f2) {
        float f3 = epsilon;
        if (f2 > (-f3) && f2 < f3) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f2);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f2;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i2 = this.mCount;
        int i3 = this.head;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            int[] iArr = this.variables;
            int i6 = iArr[i3];
            int i7 = solverVariable.id;
            if (i6 == i7) {
                this.values[i3] = f2;
                return;
            }
            if (iArr[i3] < i7) {
                i4 = i3;
            }
            i3 = this.next[i3];
            if (i3 == -1) {
                break;
            }
        }
        insertVariable(i4, solverVariable, f2);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f2 = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        if (iArr[indexOf] != -1) {
            int[] iArr2 = this.next;
            iArr2[iArr[indexOf]] = iArr2[indexOf];
        }
        int[] iArr3 = this.next;
        if (iArr3[indexOf] != -1) {
            iArr[iArr3[indexOf]] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f2;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i2 = this.mCount;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                String str2 = str + variable + " = " + getVariableValue(i3) + ExpandableTextView.N;
                int indexOf = indexOf(variable);
                String str3 = str2 + "[p: ";
                String str4 = (this.previous[indexOf] != -1 ? str3 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]] : str3 + "none") + ", n: ";
                str = (this.next[indexOf] != -1 ? str4 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f2 = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i2 = solverVariableValues.head;
        int i3 = 0;
        int i4 = 0;
        while (i3 < currentSize) {
            int[] iArr = solverVariableValues.variables;
            if (iArr[i4] != -1) {
                add(this.mCache.mIndexedVariables[iArr[i4]], solverVariableValues.values[i4] * f2, z);
                i3++;
            }
            i4++;
        }
        return f2;
    }
}
