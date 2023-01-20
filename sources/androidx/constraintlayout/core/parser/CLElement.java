package androidx.constraintlayout.core.parser;

import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class CLElement {
    public static int BASE_INDENT = 2;
    public static int MAX_LINE = 80;
    private int line;
    public CLContainer mContainer;
    private final char[] mContent;
    public long start = -1;
    public long end = Long.MAX_VALUE;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    public void addIndent(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
    }

    public String content() {
        String str = new String(this.mContent);
        long j2 = this.end;
        if (j2 != Long.MAX_VALUE) {
            long j3 = this.start;
            if (j2 >= j3) {
                return str.substring((int) j3, ((int) j2) + 1);
            }
        }
        long j4 = this.start;
        return str.substring((int) j4, ((int) j4) + 1);
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public String getDebugName() {
        if (CLParser.DEBUG) {
            return getStrClass() + " -> ";
        }
        return "";
    }

    public long getEnd() {
        return this.end;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.line;
    }

    public long getStart() {
        return this.start;
    }

    public String getStrClass() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    public boolean isDone() {
        return this.end != Long.MAX_VALUE;
    }

    public boolean isStarted() {
        return this.start > -1;
    }

    public boolean notStarted() {
        return this.start == -1;
    }

    public void setContainer(CLContainer cLContainer) {
        this.mContainer = cLContainer;
    }

    public void setEnd(long j2) {
        if (this.end != Long.MAX_VALUE) {
            return;
        }
        this.end = j2;
        if (CLParser.DEBUG) {
            PrintStream printStream = System.out;
            printStream.println("closing " + hashCode() + " -> " + this);
        }
        CLContainer cLContainer = this.mContainer;
        if (cLContainer != null) {
            cLContainer.add(this);
        }
    }

    public void setLine(int i2) {
        this.line = i2;
    }

    public void setStart(long j2) {
        this.start = j2;
    }

    public String toFormattedJSON(int i2, int i3) {
        return "";
    }

    public String toJSON() {
        return "";
    }

    public String toString() {
        long j2 = this.start;
        long j3 = this.end;
        if (j2 <= j3 && j3 != Long.MAX_VALUE) {
            String substring = new String(this.mContent).substring((int) this.start, ((int) this.end) + 1);
            return getStrClass() + " (" + this.start + " : " + this.end + ") <<" + substring + ">>";
        }
        return getClass() + " (INVALID, " + this.start + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.end + ")";
    }
}
