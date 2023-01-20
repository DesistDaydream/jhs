package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.SerializationException;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.Normalizer;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.ParseSettings;
import h.t2.y;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class Attributes implements Iterable<Attribute>, Cloneable {
    private static final String[] Empty = new String[0];
    private static final String EmptyString = "";
    private static final int GrowthFactor = 2;
    private static final int InitialCapacity = 2;
    public static final char InternalPrefix = '/';
    public static final int NotFound = -1;
    public static final String dataPrefix = "data-";
    public String[] keys;
    private int size = 0;
    public String[] vals;

    /* loaded from: classes2.dex */
    public static class Dataset extends AbstractMap<String, String> {
        private final Attributes attributes;

        /* loaded from: classes2.dex */
        public class DatasetIterator implements Iterator<Map.Entry<String, String>> {
            private Attribute attr;
            private Iterator<Attribute> attrIter;

            private DatasetIterator() {
                this.attrIter = Dataset.this.attributes.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                while (this.attrIter.hasNext()) {
                    Attribute next = this.attrIter.next();
                    this.attr = next;
                    if (next.isDataAttribute()) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                Dataset.this.attributes.remove(this.attr.getKey());
            }

            @Override // java.util.Iterator
            public Map.Entry<String, String> next() {
                return new Attribute(this.attr.getKey().substring(5), this.attr.getValue());
            }
        }

        /* loaded from: classes2.dex */
        public class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private EntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<String, String>> iterator() {
                return new DatasetIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i2 = 0;
                while (new DatasetIterator().hasNext()) {
                    i2++;
                }
                return i2;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<String, String>> entrySet() {
            return new EntrySet();
        }

        private Dataset(Attributes attributes) {
            this.attributes = attributes;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public String put(String str, String str2) {
            String dataKey = Attributes.dataKey(str);
            String str3 = this.attributes.hasKey(dataKey) ? this.attributes.get(dataKey) : null;
            this.attributes.put(dataKey, str2);
            return str3;
        }
    }

    public Attributes() {
        String[] strArr = Empty;
        this.keys = strArr;
        this.vals = strArr;
    }

    private void checkCapacity(int i2) {
        Validate.isTrue(i2 >= this.size);
        String[] strArr = this.keys;
        int length = strArr.length;
        if (length >= i2) {
            return;
        }
        int i3 = length >= 2 ? this.size * 2 : 2;
        if (i2 <= i3) {
            i2 = i3;
        }
        this.keys = (String[]) Arrays.copyOf(strArr, i2);
        this.vals = (String[]) Arrays.copyOf(this.vals, i2);
    }

    public static String checkNotNull(String str) {
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dataKey(String str) {
        return dataPrefix + str;
    }

    private int indexOfKeyIgnoreCase(String str) {
        Validate.notNull(str);
        for (int i2 = 0; i2 < this.size; i2++) {
            if (str.equalsIgnoreCase(this.keys[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public static String internalKey(String str) {
        return InternalPrefix + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalKey(String str) {
        return str != null && str.length() > 1 && str.charAt(0) == '/';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remove(int i2) {
        Validate.isFalse(i2 >= this.size);
        int i3 = (this.size - i2) - 1;
        if (i3 > 0) {
            String[] strArr = this.keys;
            int i4 = i2 + 1;
            System.arraycopy(strArr, i4, strArr, i2, i3);
            String[] strArr2 = this.vals;
            System.arraycopy(strArr2, i4, strArr2, i2, i3);
        }
        int i5 = this.size - 1;
        this.size = i5;
        this.keys[i5] = null;
        this.vals[i5] = null;
    }

    public Attributes add(String str, String str2) {
        checkCapacity(this.size + 1);
        String[] strArr = this.keys;
        int i2 = this.size;
        strArr[i2] = str;
        this.vals[i2] = str2;
        this.size = i2 + 1;
        return this;
    }

    public void addAll(Attributes attributes) {
        if (attributes.size() == 0) {
            return;
        }
        checkCapacity(this.size + attributes.size);
        Iterator<Attribute> it = attributes.iterator();
        while (it.hasNext()) {
            put(it.next());
        }
    }

    public List<Attribute> asList() {
        ArrayList arrayList = new ArrayList(this.size);
        for (int i2 = 0; i2 < this.size; i2++) {
            if (!isInternalKey(this.keys[i2])) {
                arrayList.add(new Attribute(this.keys[i2], this.vals[i2], this));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Map<String, String> dataset() {
        return new Dataset();
    }

    public int deduplicate(ParseSettings parseSettings) {
        int i2 = 0;
        if (isEmpty()) {
            return 0;
        }
        boolean preserveAttributeCase = parseSettings.preserveAttributeCase();
        int i3 = 0;
        while (i2 < this.keys.length) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                String[] strArr = this.keys;
                if (i5 < strArr.length && strArr[i5] != null) {
                    if (!preserveAttributeCase || !strArr[i2].equals(strArr[i5])) {
                        if (!preserveAttributeCase) {
                            String[] strArr2 = this.keys;
                            if (!strArr2[i2].equalsIgnoreCase(strArr2[i5])) {
                            }
                        }
                        i5++;
                    }
                    i3++;
                    remove(i5);
                    i5--;
                    i5++;
                }
            }
            i2 = i4;
        }
        return i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.size == attributes.size && Arrays.equals(this.keys, attributes.keys)) {
            return Arrays.equals(this.vals, attributes.vals);
        }
        return false;
    }

    public String get(String str) {
        int indexOfKey = indexOfKey(str);
        return indexOfKey == -1 ? "" : checkNotNull(this.vals[indexOfKey]);
    }

    public String getIgnoreCase(String str) {
        int indexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        return indexOfKeyIgnoreCase == -1 ? "" : checkNotNull(this.vals[indexOfKeyIgnoreCase]);
    }

    public boolean hasDeclaredValueForKey(String str) {
        int indexOfKey = indexOfKey(str);
        return (indexOfKey == -1 || this.vals[indexOfKey] == null) ? false : true;
    }

    public boolean hasDeclaredValueForKeyIgnoreCase(String str) {
        int indexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        return (indexOfKeyIgnoreCase == -1 || this.vals[indexOfKeyIgnoreCase] == null) ? false : true;
    }

    public boolean hasKey(String str) {
        return indexOfKey(str) != -1;
    }

    public boolean hasKeyIgnoreCase(String str) {
        return indexOfKeyIgnoreCase(str) != -1;
    }

    public int hashCode() {
        return (((this.size * 31) + Arrays.hashCode(this.keys)) * 31) + Arrays.hashCode(this.vals);
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            html(borrowBuilder, new Document("").outputSettings());
            return StringUtil.releaseBuilder(borrowBuilder);
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public int indexOfKey(String str) {
        Validate.notNull(str);
        for (int i2 = 0; i2 < this.size; i2++) {
            if (str.equals(this.keys[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<Attribute> iterator() {
        return new Iterator<Attribute>() { // from class: com.moor.imkf.lib.jsoup.nodes.Attributes.1

            /* renamed from: i  reason: collision with root package name */
            public int f4969i = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                while (this.f4969i < Attributes.this.size) {
                    Attributes attributes = Attributes.this;
                    if (!attributes.isInternalKey(attributes.keys[this.f4969i])) {
                        break;
                    }
                    this.f4969i++;
                }
                return this.f4969i < Attributes.this.size;
            }

            @Override // java.util.Iterator
            public void remove() {
                Attributes attributes = Attributes.this;
                int i2 = this.f4969i - 1;
                this.f4969i = i2;
                attributes.remove(i2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Attribute next() {
                Attributes attributes = Attributes.this;
                String[] strArr = attributes.keys;
                int i2 = this.f4969i;
                Attribute attribute = new Attribute(strArr[i2], attributes.vals[i2], attributes);
                this.f4969i++;
                return attribute;
            }
        };
    }

    public void normalize() {
        for (int i2 = 0; i2 < this.size; i2++) {
            String[] strArr = this.keys;
            strArr[i2] = Normalizer.lowerCase(strArr[i2]);
        }
    }

    public Attributes put(String str, String str2) {
        Validate.notNull(str);
        int indexOfKey = indexOfKey(str);
        if (indexOfKey != -1) {
            this.vals[indexOfKey] = str2;
        } else {
            add(str, str2);
        }
        return this;
    }

    public void putIgnoreCase(String str, String str2) {
        int indexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        if (indexOfKeyIgnoreCase != -1) {
            this.vals[indexOfKeyIgnoreCase] = str2;
            if (this.keys[indexOfKeyIgnoreCase].equals(str)) {
                return;
            }
            this.keys[indexOfKeyIgnoreCase] = str;
            return;
        }
        add(str, str2);
    }

    public void removeIgnoreCase(String str) {
        int indexOfKeyIgnoreCase = indexOfKeyIgnoreCase(str);
        if (indexOfKeyIgnoreCase != -1) {
            remove(indexOfKeyIgnoreCase);
        }
    }

    public int size() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.size; i3++) {
            if (!isInternalKey(this.keys[i3])) {
                i2++;
            }
        }
        return i2;
    }

    public String toString() {
        return html();
    }

    /* renamed from: clone */
    public Attributes m34clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.size = this.size;
            this.keys = (String[]) Arrays.copyOf(this.keys, this.size);
            this.vals = (String[]) Arrays.copyOf(this.vals, this.size);
            return attributes;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void html(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (!isInternalKey(this.keys[i3])) {
                String str = this.keys[i3];
                String str2 = this.vals[i3];
                appendable.append(' ').append(str);
                if (!Attribute.shouldCollapseAttribute(str, str2, outputSettings)) {
                    appendable.append("=\"");
                    if (str2 == null) {
                        str2 = "";
                    }
                    Entities.escape(appendable, str2, outputSettings, true, false, false);
                    appendable.append(y.a);
                }
            }
        }
    }

    public Attributes put(String str, boolean z) {
        if (z) {
            putIgnoreCase(str, null);
        } else {
            remove(str);
        }
        return this;
    }

    public Attributes put(Attribute attribute) {
        Validate.notNull(attribute);
        put(attribute.getKey(), attribute.getValue());
        attribute.parent = this;
        return this;
    }

    public void remove(String str) {
        int indexOfKey = indexOfKey(str);
        if (indexOfKey != -1) {
            remove(indexOfKey);
        }
    }
}
