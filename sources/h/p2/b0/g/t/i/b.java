package h.p2.b0.g.t.i;

import h.p2.b0.g.t.i.a;
import h.p2.b0.g.t.i.n;
import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes3.dex */
public abstract class b<MessageType extends n> implements p<MessageType> {
    private static final f a = f.c();

    private MessageType e(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    private UninitializedMessageException f(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // h.p2.b0.g.t.i.p
    /* renamed from: g */
    public MessageType d(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(j(inputStream, fVar));
    }

    @Override // h.p2.b0.g.t.i.p
    /* renamed from: h */
    public MessageType a(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return e(k(inputStream, fVar));
    }

    @Override // h.p2.b0.g.t.i.p
    /* renamed from: i */
    public MessageType b(d dVar, f fVar) throws InvalidProtocolBufferException {
        return e(l(dVar, fVar));
    }

    public MessageType j(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return k(new a.AbstractC0459a.C0460a(inputStream, e.B(read, inputStream)), fVar);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }

    public MessageType k(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        e g2 = e.g(inputStream);
        MessageType messagetype = (MessageType) c(g2, fVar);
        try {
            g2.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType l(d dVar, f fVar) throws InvalidProtocolBufferException {
        try {
            e s = dVar.s();
            MessageType messagetype = (MessageType) c(s, fVar);
            try {
                s.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }
}
