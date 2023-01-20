package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* loaded from: classes.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    /* loaded from: classes.dex */
    public class CLObjectIterator implements Iterator {
        public int index = 0;
        public CLObject myObject;

        public CLObjectIterator(CLObject cLObject) {
            this.myObject = cLObject;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.myObject.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            CLKey cLKey = (CLKey) this.myObject.mElements.get(this.index);
            this.index++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "{ ");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next.toJSON());
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i3) {
        StringBuilder sb = new StringBuilder(getDebugName());
        sb.append("{\n");
        Iterator<CLElement> it = this.mElements.iterator();
        boolean z = true;
        while (it.hasNext()) {
            CLElement next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(",\n");
            }
            sb.append(next.toFormattedJSON(CLElement.BASE_INDENT + i2, i3 - 1));
        }
        sb.append("\n");
        addIndent(sb, i2);
        sb.append("}");
        return sb.toString();
    }
}
