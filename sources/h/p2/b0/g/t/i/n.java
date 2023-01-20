package h.p2.b0.g.t.i;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* loaded from: classes3.dex */
public interface n extends o {

    /* loaded from: classes3.dex */
    public interface a extends Cloneable, o {
        n build();

        a d(e eVar, f fVar) throws IOException;
    }

    p<? extends n> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
