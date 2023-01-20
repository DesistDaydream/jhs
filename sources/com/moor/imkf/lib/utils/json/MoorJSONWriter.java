package com.moor.imkf.lib.utils.json;

import com.tencent.bugly.Bugly;
import com.xiaomi.mipush.sdk.Constants;
import h.t2.y;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.StringCharacterIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes2.dex */
public class MoorJSONWriter {
    public static char[] hex = "0123456789ABCDEF".toCharArray();
    private StringBuffer buf;
    private Stack<Object> calls;
    public boolean emitClassName;

    public MoorJSONWriter(boolean z) {
        this.buf = new StringBuffer();
        this.calls = new Stack<>();
        this.emitClassName = true;
        this.emitClassName = z;
    }

    private void add(String str, Object obj) {
        add(y.a);
        add(str);
        add("\":");
        value(obj);
    }

    private void array(Iterator it) {
        add("[");
        while (it.hasNext()) {
            value(it.next());
            if (it.hasNext()) {
                add(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        add("]");
    }

    private void bean(Object obj) {
        add("{");
        try {
            Field[] fields = obj.getClass().getFields();
            int i2 = 0;
            boolean z = false;
            while (i2 < fields.length) {
                Field field = fields[i2];
                if (z) {
                    add(',');
                }
                add(field.getName(), field.get(obj));
                i2++;
                z = true;
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        add("}");
    }

    private void bool(boolean z) {
        add(z ? "true" : Bugly.SDK_IS_DEV);
    }

    private boolean cyclic(Object obj) {
        Iterator<Object> it = this.calls.iterator();
        while (it.hasNext()) {
            if (obj == it.next()) {
                return true;
            }
        }
        return false;
    }

    private void map(Map map) {
        add("{");
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            value(entry.getKey());
            add(Constants.COLON_SEPARATOR);
            value(entry.getValue());
            if (it.hasNext()) {
                add(',');
            }
        }
        add("}");
    }

    private void string(Object obj) {
        add(y.a);
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(obj.toString());
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '\"') {
                add("\\\"");
            } else if (first == '\\') {
                add("\\\\");
            } else if (first == '\b') {
                add("\\b");
            } else if (first == '\f') {
                add("\\f");
            } else if (first == '\n') {
                add("\\n");
            } else if (first == '\r') {
                add("\\r");
            } else if (first == '\t') {
                add("\\t");
            } else if (Character.isISOControl(first)) {
                unicode(first);
            } else {
                add(first);
            }
        }
        add(y.a);
    }

    private void unicode(char c2) {
        add("\\u");
        int i2 = 0;
        int i3 = c2;
        while (i2 < 4) {
            add(hex[(61440 & i3) >> 12]);
            i2++;
            i3 <<= 4;
        }
    }

    private void value(Object obj) {
        if (obj != null && !cyclic(obj)) {
            this.calls.push(obj);
            if (obj instanceof Class) {
                string(obj);
            } else if (obj instanceof Boolean) {
                bool(((Boolean) obj).booleanValue());
            } else if (obj instanceof Number) {
                add(obj);
            } else if (obj instanceof String) {
                string(obj);
            } else if (obj instanceof Character) {
                string(obj);
            } else if (obj instanceof Map) {
                map((Map) obj);
            } else if (obj.getClass().isArray()) {
                array(obj);
            } else if (obj instanceof Iterator) {
                array((Iterator) obj);
            } else if (obj instanceof Collection) {
                array(((Collection) obj).iterator());
            } else {
                bean(obj);
            }
            this.calls.pop();
            return;
        }
        add("null");
    }

    public String write(Object obj) {
        this.buf.setLength(0);
        value(obj);
        return this.buf.toString();
    }

    public String write(long j2) {
        return String.valueOf(j2);
    }

    private void add(Object obj) {
        this.buf.append(obj);
    }

    public String write(double d2) {
        return String.valueOf(d2);
    }

    public MoorJSONWriter() {
        this(true);
    }

    private void add(char c2) {
        this.buf.append(c2);
    }

    private void array(Object obj) {
        add("[");
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            value(Array.get(obj, i2));
            if (i2 < length - 1) {
                add(',');
            }
        }
        add("]");
    }

    public String write(char c2) {
        return "\"" + c2 + "\"";
    }

    public String write(boolean z) {
        return String.valueOf(z);
    }
}
