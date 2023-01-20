package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ad.GMRewardBaseAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PangleRewardVideoAdapter extends GMRewardBaseAdapter {
    public static final String TAG = "PgRewardVideoAdapter";
    public static final String VERSION_00 = "0.0";
    public static final String VERSION_4400 = "4.4.0.0";
    private Context A;
    private PangleRewardVideo z;

    /* loaded from: classes.dex */
    public class PangleRewardVideo extends TTBaseAd {
        private TTRewardVideoAd a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1850c;

        /* renamed from: d  reason: collision with root package name */
        public TTAdNative.RewardVideoAdListener f1851d = new AnonymousClass1();

        /* renamed from: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter$PangleRewardVideo$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements TTAdNative.RewardVideoAdListener {
            public AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                Logger.e("TTMediationSDK", "pangle_reward_onError code:" + i2 + "  message:" + str);
                PangleRewardVideo.this.b = false;
                PangleRewardVideoAdapter.this.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoAdLoad");
                if (tTRewardVideoAd == null) {
                    PangleRewardVideoAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                PangleRewardVideo.this.a = tTRewardVideoAd;
                PangleRewardVideo.this.setExpressAd(true);
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                pangleRewardVideo.setInteractionType(pangleRewardVideo.a.getInteractionType());
                Map<String, Object> mediaExtraInfo = PangleRewardVideo.this.a.getMediaExtraInfo();
                if (PangleRewardVideoAdapter.this.isClientBidding() && mediaExtraInfo != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleRewardVideoAdapter.this.getAdapterRit(), PangleRewardVideoAdapter.this.getAdSlotId()) + "pangle reward 返回的 cpm价格：" + value);
                    PangleRewardVideo pangleRewardVideo2 = PangleRewardVideo.this;
                    if (value <= 0.0d) {
                        value = 0.0d;
                    }
                    pangleRewardVideo2.setCpm(value);
                }
                if (mediaExtraInfo != null) {
                    Object obj = mediaExtraInfo.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        PangleRewardVideo.this.f1850c = ((Boolean) obj).booleanValue();
                        Logger.d("TTMediationSDK", "pangle 激励 返回的adnPreload：" + PangleRewardVideo.this.f1850c);
                    }
                }
                PangleRewardVideo.this.b = true;
                PangleRewardVideo.this.a.setRewardPlayAgainInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdClose-----------2");
                        if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.g().onRewardedAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdShow-----------2");
                        if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.g().onRewardedAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdVideoBarClick---------2");
                        if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.g().onRewardClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(final boolean z, final int i2, final Bundle bundle) {
                        if (PangleRewardVideo.this.l()) {
                            return;
                        }
                        Logger.e("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                        if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.g().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1.2
                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public float getAmount() {
                                    Bundle bundle2 = bundle;
                                    float f2 = bundle2 != null ? bundle2.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                    if (f2 >= 0.0f) {
                                        return f2;
                                    }
                                    GMAdSlotRewardVideo gMAdSlotRewardVideo = PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                                    if (gMAdSlotRewardVideo != null) {
                                        return gMAdSlotRewardVideo.getRewardAmount();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public Map<String, Object> getCustomData() {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(RewardItem.KEY_EXTRA_INFO, bundle);
                                    hashMap.put(RewardItem.KEY_REWARD_TYPE, Integer.valueOf(i2));
                                    return hashMap;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public String getRewardName() {
                                    Bundle bundle2 = bundle;
                                    String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                    if (TextUtils.isEmpty(string)) {
                                        GMAdSlotRewardVideo gMAdSlotRewardVideo = PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                                        return gMAdSlotRewardVideo != null ? gMAdSlotRewardVideo.getRewardName() : "";
                                    }
                                    return string;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public boolean rewardVerify() {
                                    return z;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    @Deprecated
                    public void onRewardVerify(final boolean z, final int i2, final String str, int i3, String str2) {
                        if (PangleRewardVideo.this.l()) {
                            Logger.e("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                            if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                                PangleRewardVideo.this.g().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1.1
                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public float getAmount() {
                                        int i4 = i2;
                                        if (i4 >= 0) {
                                            return i4;
                                        }
                                        if (PangleRewardVideoAdapter.this.mAdSlot != null) {
                                            return PangleRewardVideoAdapter.this.mAdSlot.getRewardAmount();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public Map<String, Object> getCustomData() {
                                        return null;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public String getRewardName() {
                                        return !TextUtils.isEmpty(str) ? str : PangleRewardVideoAdapter.this.mAdSlot != null ? PangleRewardVideoAdapter.this.mAdSlot.getRewardName() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public boolean rewardVerify() {
                                        return z;
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Logger.e("TTMediationSDK", "pangle_reward:onSkippedVideo-------------2");
                        if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.g().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoComplete----------2");
                        if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.g().onVideoComplete();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoError-----------2");
                        if (PangleRewardVideo.this.mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.g().onVideoError();
                        }
                    }
                });
                PangleRewardVideo.this.a.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.2
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdClose");
                        if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardedAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdShow");
                        if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardedAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdVideoBarClick");
                        if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(final boolean z, final int i2, final Bundle bundle) {
                        if (PangleRewardVideo.this.l()) {
                            return;
                        }
                        Logger.e("TTMediationSDK", "pangle_reward:onRewardArrived");
                        if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.2.2
                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public float getAmount() {
                                    Bundle bundle2 = bundle;
                                    float f2 = bundle2 != null ? bundle2.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                    if (f2 >= 0.0f) {
                                        return f2;
                                    }
                                    GMAdSlotRewardVideo gMAdSlotRewardVideo = PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                                    if (gMAdSlotRewardVideo != null) {
                                        return gMAdSlotRewardVideo.getRewardAmount();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public Map<String, Object> getCustomData() {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(RewardItem.KEY_EXTRA_INFO, bundle);
                                    hashMap.put(RewardItem.KEY_REWARD_TYPE, Integer.valueOf(i2));
                                    return hashMap;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public String getRewardName() {
                                    Bundle bundle2 = bundle;
                                    String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                    if (TextUtils.isEmpty(string)) {
                                        GMAdSlotRewardVideo gMAdSlotRewardVideo = PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                                        return gMAdSlotRewardVideo != null ? gMAdSlotRewardVideo.getRewardName() : "";
                                    }
                                    return string;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public boolean rewardVerify() {
                                    return z;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    @Deprecated
                    public void onRewardVerify(final boolean z, final int i2, final String str, int i3, String str2) {
                        if (PangleRewardVideo.this.l()) {
                            Logger.e("TTMediationSDK", "pangle_reward:onRewardVerify");
                            if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                                PangleRewardVideo.this.a().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.2.1
                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public float getAmount() {
                                        int i4 = i2;
                                        if (i4 >= 0) {
                                            return i4;
                                        }
                                        if (PangleRewardVideoAdapter.this.mAdSlot != null) {
                                            return PangleRewardVideoAdapter.this.mAdSlot.getRewardAmount();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public Map<String, Object> getCustomData() {
                                        return null;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public String getRewardName() {
                                        return !TextUtils.isEmpty(str) ? str : PangleRewardVideoAdapter.this.mAdSlot != null ? PangleRewardVideoAdapter.this.mAdSlot.getRewardName() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public boolean rewardVerify() {
                                        return z;
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Logger.e("TTMediationSDK", "pangle_reward:onSkippedVideo");
                        if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoComplete");
                        if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onVideoComplete();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoError");
                        if (PangleRewardVideo.this.mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onVideoError();
                        }
                    }
                });
                PangleRewardVideo pangleRewardVideo3 = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdLoaded(pangleRewardVideo3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdVideoCache(pangleRewardVideo, (AdError) null);
            }
        }

        public PangleRewardVideo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0014 A[SYNTHETIC] */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener a() {
            /*
                r4 = this;
            L0:
                r0 = 94
                r1 = 75
                r2 = 93
            L6:
                r3 = 92
                if (r0 == r3) goto Ld
                if (r0 == r2) goto L10
                goto L19
            Ld:
                switch(r1) {
                    case 21: goto L19;
                    case 22: goto L14;
                    case 23: goto L14;
                    default: goto L10;
                }
            L10:
                switch(r1) {
                    case 91: goto L0;
                    case 92: goto L19;
                    case 93: goto L14;
                    default: goto L13;
                }
            L13:
                goto L1e
            L14:
                com.bytedance.msdk.adapter.listener.ITTAdatperCallback r0 = r4.mTTAdatperCallback
                com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener r0 = (com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener) r0
                return r0
            L19:
                r0 = 93
                r1 = 93
                goto L6
            L1e:
                r1 = 91
                goto L10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.a():com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GMRewardedAdListener g() {
            return (GMRewardedAdListener) this.mTTAdatperRewardPlayAgainCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
            if (android.text.TextUtils.isEmpty(r1) == false) goto L5;
         */
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void j() {
            /*
                r10 = this;
                com.bytedance.sdk.openadsdk.TTAdManager r0 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                android.content.Context r1 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.D(r1)
                com.bytedance.sdk.openadsdk.TTAdNative r0 = r0.createAdNative(r1)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r1 = r1.mGMAdSlotRewardVideo
                java.util.Map r1 = r1.getCustomData()
                if (r1 == 0) goto L27
                java.lang.String r2 = "pangle"
                java.lang.Object r1 = r1.get(r2)
                java.lang.String r1 = (java.lang.String) r1
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                if (r2 != 0) goto L27
                goto L29
            L27:
                java.lang.String r1 = ""
            L29:
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.AdSlot r3 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.I(r2)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r4 = r2.mGMAdSlotRewardVideo
                java.lang.String r5 = r2.getAdSlotId()
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                java.lang.String r6 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.L(r2)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                java.lang.String r7 = r2.getClientReqId()
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                java.lang.String r8 = r2.getAdm()
                r9 = 0
                com.bytedance.sdk.openadsdk.AdSlot$Builder r2 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.buildPangleAdSlot(r3, r4, r5, r6, r7, r8, r9)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r3 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r3 = r3.mGMAdSlotRewardVideo
                java.lang.String r3 = r3.getUserID()
                com.bytedance.sdk.openadsdk.AdSlot$Builder r3 = r2.setUserID(r3)
                com.bytedance.sdk.openadsdk.AdSlot$Builder r1 = r3.setMediaExtra(r1)
                r3 = 1080(0x438, float:1.513E-42)
                r4 = 1920(0x780, float:2.69E-42)
                com.bytedance.sdk.openadsdk.AdSlot$Builder r1 = r1.setImageAcceptedSize(r3, r4)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r3 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r3 = r3.mGMAdSlotRewardVideo
                int r3 = r3.getOrientation()
                r1.setOrientation(r3)
                com.bytedance.sdk.openadsdk.AdSlot r1 = r2.build()
                com.bytedance.sdk.openadsdk.TTAdNative$RewardVideoAdListener r2 = r10.f1851d
                r0.loadRewardVideoAd(r1, r2)
            L7a:
                r0 = 18
            L7c:
                switch(r0) {
                    case 18: goto L81;
                    case 19: goto L80;
                    case 20: goto L81;
                    default: goto L7f;
                }
            L7f:
                goto L7a
            L80:
                return
            L81:
                r0 = 19
                goto L7c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.j():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            return !"0.0".equals(PangleRewardVideoAdapter.this.getSdkVersion()) && PangleRewardVideoAdapter.VERSION_4400.compareTo(PangleRewardVideoAdapter.this.getSdkVersion()) > 0;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return tTRewardVideoAd != null ? PangleAdapterUtils.getAdId(tTRewardVideoAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return tTRewardVideoAd != null ? PangleAdapterUtils.getCreativeId(tTRewardVideoAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTRewardVideoAd tTRewardVideoAd = this.a;
            if (tTRewardVideoAd == null || (mediaExtraInfo = tTRewardVideoAd.getMediaExtraInfo()) == null) {
                return super.getMediaExtraInfo();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            return hashMap;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return tTRewardVideoAd != null ? PangleAdapterUtils.getReqId(tTRewardVideoAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdnPreload() {
            return this.f1850c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return (tTRewardVideoAd == null || tTRewardVideoAd.getExpirationTimestamp() <= System.currentTimeMillis()) ? GMAdConstant.AdIsReadyStatus.AD_IS_EXPIRED : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            if (tTRewardVideoAd != null) {
                tTRewardVideoAd.setDownloadListener(null);
                this.a.setRewardAdInteractionListener(null);
                this.a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.a != null) {
                TTAdConstant.RitScenes ritScenes = PangleAdapterUtils.getRitScenes(map);
                String customRitScenes = PangleAdapterUtils.getCustomRitScenes(map);
                if (ritScenes != null) {
                    this.a.showRewardVideoAd(activity, ritScenes, customRitScenes);
                } else {
                    this.a.showRewardVideoAd(activity);
                }
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.ad.GMRewardBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    @JProtect
    public void loadAd(Context context, Map<String, Object> map) {
        super.loadAd(context, map);
        if (this.mGMAdSlotRewardVideo == null) {
            notifyLoadFailBecauseGMAdSlotIsNull();
            return;
        }
        this.A = context;
        if (map != null) {
            PangleRewardVideo pangleRewardVideo = new PangleRewardVideo();
            this.z = pangleRewardVideo;
            pangleRewardVideo.j();
        }
    }
}
