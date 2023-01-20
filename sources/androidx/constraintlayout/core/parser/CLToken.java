package androidx.constraintlayout.core.parser;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.bugly.Bugly;

/* loaded from: classes.dex */
public class CLToken extends CLElement {
    public int index;
    public char[] tokenFalse;
    public char[] tokenNull;
    public char[] tokenTrue;
    public Type type;

    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = iArr;
            try {
                iArr[Type.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.index = 0;
        this.type = Type.UNKNOWN;
        this.tokenTrue = "true".toCharArray();
        this.tokenFalse = Bugly.SDK_IS_DEV.toCharArray();
        this.tokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.type;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + SimpleComparison.GREATER_THAN_OPERATION, this);
    }

    public Type getType() {
        return this.type;
    }

    public boolean isNull() throws CLParsingException {
        if (this.type == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + SimpleComparison.GREATER_THAN_OPERATION, this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i2);
        sb.append(content());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (CLParser.DEBUG) {
            return SimpleComparison.LESS_THAN_OPERATION + content() + SimpleComparison.GREATER_THAN_OPERATION;
        }
        return content();
    }

    public boolean validate(char c2, long j2) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[this.type.ordinal()];
        if (i2 == 1) {
            char[] cArr = this.tokenTrue;
            int i3 = this.index;
            r1 = cArr[i3] == c2;
            if (r1 && i3 + 1 == cArr.length) {
                setEnd(j2);
            }
        } else if (i2 == 2) {
            char[] cArr2 = this.tokenFalse;
            int i4 = this.index;
            r1 = cArr2[i4] == c2;
            if (r1 && i4 + 1 == cArr2.length) {
                setEnd(j2);
            }
        } else if (i2 == 3) {
            char[] cArr3 = this.tokenNull;
            int i5 = this.index;
            r1 = cArr3[i5] == c2;
            if (r1 && i5 + 1 == cArr3.length) {
                setEnd(j2);
            }
        } else if (i2 == 4) {
            char[] cArr4 = this.tokenTrue;
            int i6 = this.index;
            if (cArr4[i6] == c2) {
                this.type = Type.TRUE;
            } else if (this.tokenFalse[i6] == c2) {
                this.type = Type.FALSE;
            } else if (this.tokenNull[i6] == c2) {
                this.type = Type.NULL;
            }
            r1 = true;
        }
        this.index++;
        return r1;
    }
}
