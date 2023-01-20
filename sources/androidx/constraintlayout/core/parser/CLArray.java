package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i3 <= 0 && json.length() + i2 < CLElement.MAX_LINE) {
            sb.append(json);
        } else {
            sb.append("[\n");
            Iterator<CLElement> it = this.mElements.iterator();
            boolean z = true;
            while (it.hasNext()) {
                CLElement next = it.next();
                if (z) {
                    z = false;
                } else {
                    sb.append(",\n");
                }
                addIndent(sb, CLElement.BASE_INDENT + i2);
                sb.append(next.toFormattedJSON(CLElement.BASE_INDENT + i2, i3 - 1));
            }
            sb.append("\n");
            addIndent(sb, i2);
            sb.append("]");
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z = true;
        for (int i2 = 0; i2 < this.mElements.size(); i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.mElements.get(i2).toJSON());
        }
        return ((Object) sb) + "]";
    }
}
