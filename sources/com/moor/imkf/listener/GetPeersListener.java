package com.moor.imkf.listener;

import com.moor.imkf.model.entity.Peer;
import java.util.List;

/* loaded from: classes2.dex */
public interface GetPeersListener {
    void onFailed();

    void onSuccess(List<Peer> list);
}
