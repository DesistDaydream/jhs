package com.jihuanshe;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.l.k.b0;
import e.l.k.b1;
import e.l.k.b2;
import e.l.k.b3;
import e.l.k.b4;
import e.l.k.b5;
import e.l.k.b6;
import e.l.k.b7;
import e.l.k.b8;
import e.l.k.b9;
import e.l.k.ba;
import e.l.k.bb;
import e.l.k.bc;
import e.l.k.bd;
import e.l.k.be;
import e.l.k.bf;
import e.l.k.bg;
import e.l.k.d;
import e.l.k.d0;
import e.l.k.d1;
import e.l.k.d2;
import e.l.k.d3;
import e.l.k.d4;
import e.l.k.d5;
import e.l.k.d6;
import e.l.k.d7;
import e.l.k.d8;
import e.l.k.d9;
import e.l.k.da;
import e.l.k.db;
import e.l.k.dc;
import e.l.k.dd;
import e.l.k.de;
import e.l.k.df;
import e.l.k.dg;
import e.l.k.f;
import e.l.k.f0;
import e.l.k.f1;
import e.l.k.f2;
import e.l.k.f3;
import e.l.k.f4;
import e.l.k.f5;
import e.l.k.f6;
import e.l.k.f7;
import e.l.k.f8;
import e.l.k.f9;
import e.l.k.fa;
import e.l.k.fb;
import e.l.k.fc;
import e.l.k.fd;
import e.l.k.fe;
import e.l.k.ff;
import e.l.k.fg;
import e.l.k.h;
import e.l.k.h0;
import e.l.k.h1;
import e.l.k.h2;
import e.l.k.h3;
import e.l.k.h4;
import e.l.k.h5;
import e.l.k.h6;
import e.l.k.h7;
import e.l.k.h8;
import e.l.k.h9;
import e.l.k.ha;
import e.l.k.hb;
import e.l.k.hc;
import e.l.k.hd;
import e.l.k.he;
import e.l.k.hf;
import e.l.k.hg;
import e.l.k.j;
import e.l.k.j0;
import e.l.k.j1;
import e.l.k.j2;
import e.l.k.j3;
import e.l.k.j4;
import e.l.k.j5;
import e.l.k.j6;
import e.l.k.j7;
import e.l.k.j8;
import e.l.k.j9;
import e.l.k.ja;
import e.l.k.jb;
import e.l.k.jc;
import e.l.k.jd;
import e.l.k.je;
import e.l.k.jf;
import e.l.k.jg;
import e.l.k.l;
import e.l.k.l0;
import e.l.k.l1;
import e.l.k.l2;
import e.l.k.l3;
import e.l.k.l4;
import e.l.k.l5;
import e.l.k.l6;
import e.l.k.l7;
import e.l.k.l8;
import e.l.k.l9;
import e.l.k.la;
import e.l.k.lb;
import e.l.k.lc;
import e.l.k.ld;
import e.l.k.le;
import e.l.k.lf;
import e.l.k.lg;
import e.l.k.n;
import e.l.k.n0;
import e.l.k.n1;
import e.l.k.n2;
import e.l.k.n3;
import e.l.k.n4;
import e.l.k.n5;
import e.l.k.n6;
import e.l.k.n7;
import e.l.k.n8;
import e.l.k.n9;
import e.l.k.na;
import e.l.k.nb;
import e.l.k.nc;
import e.l.k.nd;
import e.l.k.ne;
import e.l.k.nf;
import e.l.k.ng;
import e.l.k.p;
import e.l.k.p0;
import e.l.k.p1;
import e.l.k.p2;
import e.l.k.p3;
import e.l.k.p4;
import e.l.k.p5;
import e.l.k.p6;
import e.l.k.p7;
import e.l.k.p8;
import e.l.k.p9;
import e.l.k.pa;
import e.l.k.pb;
import e.l.k.pc;
import e.l.k.pd;
import e.l.k.pe;
import e.l.k.pf;
import e.l.k.pg;
import e.l.k.r;
import e.l.k.r0;
import e.l.k.r1;
import e.l.k.r2;
import e.l.k.r3;
import e.l.k.r4;
import e.l.k.r5;
import e.l.k.r6;
import e.l.k.r7;
import e.l.k.r8;
import e.l.k.r9;
import e.l.k.ra;
import e.l.k.rb;
import e.l.k.rc;
import e.l.k.rd;
import e.l.k.re;
import e.l.k.rf;
import e.l.k.rg;
import e.l.k.t;
import e.l.k.t0;
import e.l.k.t1;
import e.l.k.t2;
import e.l.k.t3;
import e.l.k.t4;
import e.l.k.t5;
import e.l.k.t6;
import e.l.k.t7;
import e.l.k.t8;
import e.l.k.t9;
import e.l.k.ta;
import e.l.k.tb;
import e.l.k.tc;
import e.l.k.td;
import e.l.k.te;
import e.l.k.tf;
import e.l.k.v;
import e.l.k.v0;
import e.l.k.v1;
import e.l.k.v2;
import e.l.k.v3;
import e.l.k.v4;
import e.l.k.v5;
import e.l.k.v6;
import e.l.k.v7;
import e.l.k.v8;
import e.l.k.v9;
import e.l.k.va;
import e.l.k.vb;
import e.l.k.vc;
import e.l.k.vd;
import e.l.k.ve;
import e.l.k.vf;
import e.l.k.x;
import e.l.k.x0;
import e.l.k.x1;
import e.l.k.x2;
import e.l.k.x3;
import e.l.k.x4;
import e.l.k.x5;
import e.l.k.x6;
import e.l.k.x7;
import e.l.k.x8;
import e.l.k.x9;
import e.l.k.xa;
import e.l.k.xb;
import e.l.k.xc;
import e.l.k.xd;
import e.l.k.xe;
import e.l.k.xf;
import e.l.k.z;
import e.l.k.z0;
import e.l.k.z1;
import e.l.k.z2;
import e.l.k.z3;
import e.l.k.z4;
import e.l.k.z5;
import e.l.k.z6;
import e.l.k.z7;
import e.l.k.z8;
import e.l.k.z9;
import e.l.k.za;
import e.l.k.zb;
import e.l.k.zc;
import e.l.k.zd;
import e.l.k.ze;
import e.l.k.zf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final int A = 27;
    private static final int A0 = 79;
    private static final int A1 = 131;
    private static final int A2 = 183;
    private static final int B = 28;
    private static final int B0 = 80;
    private static final int B1 = 132;
    private static final int B2 = 184;
    private static final int C = 29;
    private static final int C0 = 81;
    private static final int C1 = 133;
    private static final int C2 = 185;
    private static final int D = 30;
    private static final int D0 = 82;
    private static final int D1 = 134;
    private static final int D2 = 186;
    private static final int E = 31;
    private static final int E0 = 83;
    private static final int E1 = 135;
    private static final int E2 = 187;
    private static final int F = 32;
    private static final int F0 = 84;
    private static final int F1 = 136;
    private static final int F2 = 188;
    private static final int G = 33;
    private static final int G0 = 85;
    private static final int G1 = 137;
    private static final int G2 = 189;
    private static final int H = 34;
    private static final int H0 = 86;
    private static final int H1 = 138;
    private static final int H2 = 190;
    private static final int I = 35;
    private static final int I0 = 87;
    private static final int I1 = 139;
    private static final int I2 = 191;
    private static final int J = 36;
    private static final int J0 = 88;
    private static final int J1 = 140;
    private static final int J2 = 192;
    private static final int K = 37;
    private static final int K0 = 89;
    private static final int K1 = 141;
    private static final int K2 = 193;
    private static final int L = 38;
    private static final int L0 = 90;
    private static final int L1 = 142;
    private static final int L2 = 194;
    private static final int M = 39;
    private static final int M0 = 91;
    private static final int M1 = 143;
    private static final int M2 = 195;
    private static final int N = 40;
    private static final int N0 = 92;
    private static final int N1 = 144;
    private static final int N2 = 196;
    private static final int O = 41;
    private static final int O0 = 93;
    private static final int O1 = 145;
    private static final int O2 = 197;
    private static final int P = 42;
    private static final int P0 = 94;
    private static final int P1 = 146;
    private static final int P2 = 198;
    private static final int Q = 43;
    private static final int Q0 = 95;
    private static final int Q1 = 147;
    private static final int Q2 = 199;
    private static final int R = 44;
    private static final int R0 = 96;
    private static final int R1 = 148;
    private static final int R2 = 200;
    private static final int S = 45;
    private static final int S0 = 97;
    private static final int S1 = 149;
    private static final int S2 = 201;
    private static final int T = 46;
    private static final int T0 = 98;
    private static final int T1 = 150;
    private static final int T2 = 202;
    private static final int U = 47;
    private static final int U0 = 99;
    private static final int U1 = 151;
    private static final int U2 = 203;
    private static final int V = 48;
    private static final int V0 = 100;
    private static final int V1 = 152;
    private static final int V2 = 204;
    private static final int W = 49;
    private static final int W0 = 101;
    private static final int W1 = 153;
    private static final int W2 = 205;
    private static final int X = 50;
    private static final int X0 = 102;
    private static final int X1 = 154;
    private static final int X2 = 206;
    private static final int Y = 51;
    private static final int Y0 = 103;
    private static final int Y1 = 155;
    private static final int Y2 = 207;
    private static final int Z = 52;
    private static final int Z0 = 104;
    private static final int Z1 = 156;
    private static final int Z2 = 208;
    private static final int a = 1;
    private static final int a0 = 53;
    private static final int a1 = 105;
    private static final int a2 = 157;
    private static final int a3 = 209;
    private static final int b = 2;
    private static final int b0 = 54;
    private static final int b1 = 106;
    private static final int b2 = 158;
    private static final int b3 = 210;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3724c = 3;
    private static final int c0 = 55;
    private static final int c1 = 107;
    private static final int c2 = 159;
    private static final int c3 = 211;

    /* renamed from: d  reason: collision with root package name */
    private static final int f3725d = 4;
    private static final int d0 = 56;
    private static final int d1 = 108;
    private static final int d2 = 160;
    private static final int d3 = 212;

    /* renamed from: e  reason: collision with root package name */
    private static final int f3726e = 5;
    private static final int e0 = 57;
    private static final int e1 = 109;
    private static final int e2 = 161;
    private static final int e3 = 213;

    /* renamed from: f  reason: collision with root package name */
    private static final int f3727f = 6;
    private static final int f0 = 58;
    private static final int f1 = 110;
    private static final int f2 = 162;
    private static final int f3 = 214;

    /* renamed from: g  reason: collision with root package name */
    private static final int f3728g = 7;
    private static final int g0 = 59;
    private static final int g1 = 111;
    private static final int g2 = 163;
    private static final int g3 = 215;

    /* renamed from: h  reason: collision with root package name */
    private static final int f3729h = 8;
    private static final int h0 = 60;
    private static final int h1 = 112;
    private static final int h2 = 164;
    private static final int h3 = 216;

    /* renamed from: i  reason: collision with root package name */
    private static final int f3730i = 9;
    private static final int i0 = 61;
    private static final int i1 = 113;
    private static final int i2 = 165;
    private static final int i3 = 217;

    /* renamed from: j  reason: collision with root package name */
    private static final int f3731j = 10;
    private static final int j0 = 62;
    private static final int j1 = 114;
    private static final int j2 = 166;
    private static final int j3 = 218;

    /* renamed from: k  reason: collision with root package name */
    private static final int f3732k = 11;
    private static final int k0 = 63;
    private static final int k1 = 115;
    private static final int k2 = 167;
    private static final int k3 = 219;

    /* renamed from: l  reason: collision with root package name */
    private static final int f3733l = 12;
    private static final int l0 = 64;
    private static final int l1 = 116;
    private static final int l2 = 168;
    private static final int l3 = 220;

    /* renamed from: m  reason: collision with root package name */
    private static final int f3734m = 13;
    private static final int m0 = 65;
    private static final int m1 = 117;
    private static final int m2 = 169;
    private static final int m3 = 221;
    private static final int n = 14;
    private static final int n0 = 66;
    private static final int n1 = 118;
    private static final int n2 = 170;
    private static final int n3 = 222;
    private static final int o = 15;
    private static final int o0 = 67;
    private static final int o1 = 119;
    private static final int o2 = 171;
    private static final int o3 = 223;
    private static final int p = 16;
    private static final int p0 = 68;
    private static final int p1 = 120;
    private static final int p2 = 172;
    private static final int p3 = 224;
    private static final int q = 17;
    private static final int q0 = 69;
    private static final int q1 = 121;
    private static final int q2 = 173;
    private static final int q3 = 225;
    private static final int r = 18;
    private static final int r0 = 70;
    private static final int r1 = 122;
    private static final int r2 = 174;
    private static final int r3 = 226;
    private static final int s = 19;
    private static final int s0 = 71;
    private static final int s1 = 123;
    private static final int s2 = 175;
    private static final int s3 = 227;
    private static final int t = 20;
    private static final int t0 = 72;
    private static final int t1 = 124;
    private static final int t2 = 176;
    private static final int t3 = 228;
    private static final int u = 21;
    private static final int u0 = 73;
    private static final int u1 = 125;
    private static final int u2 = 177;
    private static final int u3 = 229;
    private static final int v = 22;
    private static final int v0 = 74;
    private static final int v1 = 126;
    private static final int v2 = 178;
    private static final int v3 = 230;
    private static final int w = 23;
    private static final int w0 = 75;
    private static final int w1 = 127;
    private static final int w2 = 179;
    private static final SparseIntArray w3;
    private static final int x = 24;
    private static final int x0 = 76;
    private static final int x1 = 128;
    private static final int x2 = 180;
    private static final int y = 25;
    private static final int y0 = 77;
    private static final int y1 = 129;
    private static final int y2 = 181;
    private static final int z = 26;
    private static final int z0 = 78;
    private static final int z1 = 130;
    private static final int z2 = 182;

    /* loaded from: classes2.dex */
    public static class a {
        public static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(22);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "activity");
            sparseArray.put(2, "adapter");
            sparseArray.put(3, "defaultImage");
            sparseArray.put(4, "dialog");
            sparseArray.put(5, "fragment");
            sparseArray.put(6, "impl");
            sparseArray.put(7, "index");
            sparseArray.put(8, "item");
            sparseArray.put(9, "msg");
            sparseArray.put(10, TUIConstants.TUIChat.OWNER);
            sparseArray.put(11, "pos");
            sparseArray.put(12, PangleAdapterUtils.MEDIA_EXTRA_PRODUCT);
            sparseArray.put(13, "reviewViewModel");
            sparseArray.put(14, "sel");
            sparseArray.put(15, "select");
            sparseArray.put(16, "selected");
            sparseArray.put(17, "shape");
            sparseArray.put(18, "toast");
            sparseArray.put(19, "view");
            sparseArray.put(20, "viewModel");
            sparseArray.put(21, "viewmodel");
        }

        private a() {
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>((int) DataBinderMapperImpl.v3);
            a = hashMap;
            hashMap.put("layout/activity_about_0", Integer.valueOf((int) R.layout.activity_about));
            hashMap.put("layout/activity_account_manager_0", Integer.valueOf((int) R.layout.activity_account_manager));
            hashMap.put("layout/activity_add_address_0", Integer.valueOf((int) R.layout.activity_add_address));
            hashMap.put("layout/activity_add_card_0", Integer.valueOf((int) R.layout.activity_add_card));
            hashMap.put("layout/activity_add_product_0", Integer.valueOf((int) R.layout.activity_add_product));
            hashMap.put("layout/activity_address_0", Integer.valueOf((int) R.layout.activity_address));
            hashMap.put("layout/activity_black_list_0", Integer.valueOf((int) R.layout.activity_black_list));
            hashMap.put("layout/activity_capture_0", Integer.valueOf((int) R.layout.activity_capture));
            hashMap.put("layout/activity_card_detail_0", Integer.valueOf((int) R.layout.activity_card_detail));
            hashMap.put("layout/activity_card_pack_detail_0", Integer.valueOf((int) R.layout.activity_card_pack_detail));
            hashMap.put("layout/activity_card_pack_list_0", Integer.valueOf((int) R.layout.activity_card_pack_list));
            hashMap.put("layout/activity_choose_card_0", Integer.valueOf((int) R.layout.activity_choose_card));
            hashMap.put("layout/activity_choose_photo_0", Integer.valueOf((int) R.layout.activity_choose_photo));
            hashMap.put("layout/activity_close_account_0", Integer.valueOf((int) R.layout.activity_close_account));
            hashMap.put("layout/activity_coin_0", Integer.valueOf((int) R.layout.activity_coin));
            hashMap.put("layout/activity_common_webview_0", Integer.valueOf((int) R.layout.activity_common_webview));
            hashMap.put("layout/activity_con_order_details_0", Integer.valueOf((int) R.layout.activity_con_order_details));
            hashMap.put("layout/activity_consignment_order_0", Integer.valueOf((int) R.layout.activity_consignment_order));
            hashMap.put("layout/activity_edit_phone_number_0", Integer.valueOf((int) R.layout.activity_edit_phone_number));
            hashMap.put("layout/activity_edit_user_0", Integer.valueOf((int) R.layout.activity_edit_user));
            hashMap.put("layout/activity_entrepot_apply_for_0", Integer.valueOf((int) R.layout.activity_entrepot_apply_for));
            hashMap.put("layout/activity_entrepot_apply_for_return_0", Integer.valueOf((int) R.layout.activity_entrepot_apply_for_return));
            hashMap.put("layout/activity_etiquette_exam_0", Integer.valueOf((int) R.layout.activity_etiquette_exam));
            hashMap.put("layout/activity_fans_0", Integer.valueOf((int) R.layout.activity_fans));
            hashMap.put("layout/activity_follow_0", Integer.valueOf((int) R.layout.activity_follow));
            hashMap.put("layout/activity_help_0", Integer.valueOf((int) R.layout.activity_help));
            hashMap.put("layout/activity_illegal_list_0", Integer.valueOf((int) R.layout.activity_illegal_list));
            hashMap.put("layout/activity_image_preview_0", Integer.valueOf((int) R.layout.activity_image_preview));
            hashMap.put("layout/activity_interact_message_0", Integer.valueOf((int) R.layout.activity_interact_message));
            hashMap.put("layout/activity_login_0", Integer.valueOf((int) R.layout.activity_login));
            hashMap.put("layout/activity_main_0", Integer.valueOf((int) R.layout.activity_main));
            hashMap.put("layout/activity_mine_entrepot_0", Integer.valueOf((int) R.layout.activity_mine_entrepot));
            hashMap.put("layout/activity_mine_storehouse_0", Integer.valueOf((int) R.layout.activity_mine_storehouse));
            hashMap.put("layout/activity_order_confirm_0", Integer.valueOf((int) R.layout.activity_order_confirm));
            hashMap.put("layout/activity_order_detail_0", Integer.valueOf((int) R.layout.activity_order_detail));
            hashMap.put("layout/activity_order_list_0", Integer.valueOf((int) R.layout.activity_order_list));
            hashMap.put("layout/activity_rank_0", Integer.valueOf((int) R.layout.activity_rank));
            hashMap.put("layout/activity_reply_list_0", Integer.valueOf((int) R.layout.activity_reply_list));
            hashMap.put("layout/activity_review_list_0", Integer.valueOf((int) R.layout.activity_review_list));
            hashMap.put("layout/activity_search_0", Integer.valueOf((int) R.layout.activity_search));
            hashMap.put("layout/activity_search_bank_0", Integer.valueOf((int) R.layout.activity_search_bank));
            hashMap.put("layout/activity_sell_calendar_0", Integer.valueOf((int) R.layout.activity_sell_calendar));
            hashMap.put("layout/activity_seller_confirm_0", Integer.valueOf((int) R.layout.activity_seller_confirm));
            hashMap.put("layout/activity_seller_detail_0", Integer.valueOf((int) R.layout.activity_seller_detail));
            hashMap.put("layout/activity_seller_order_detail_0", Integer.valueOf((int) R.layout.activity_seller_order_detail));
            hashMap.put("layout/activity_selling_0", Integer.valueOf((int) R.layout.activity_selling));
            hashMap.put("layout/activity_shop_car_0", Integer.valueOf((int) R.layout.activity_shop_car));
            hashMap.put("layout/activity_shop_owner_confirm_0", Integer.valueOf((int) R.layout.activity_shop_owner_confirm));
            hashMap.put("layout/activity_splash_0", Integer.valueOf((int) R.layout.activity_splash));
            hashMap.put("layout/activity_submit_order_0", Integer.valueOf((int) R.layout.activity_submit_order));
            hashMap.put("layout/activity_submit_order_return_0", Integer.valueOf((int) R.layout.activity_submit_order_return));
            hashMap.put("layout/activity_want_buy_0", Integer.valueOf((int) R.layout.activity_want_buy));
            hashMap.put("layout/activity_want_buy_match_0", Integer.valueOf((int) R.layout.activity_want_buy_match));
            hashMap.put("layout/activity_want_card_list_0", Integer.valueOf((int) R.layout.activity_want_card_list));
            hashMap.put("layout/activity_wish_list_0", Integer.valueOf((int) R.layout.activity_wish_list));
            hashMap.put("layout/dialog_address2_0", Integer.valueOf((int) R.layout.dialog_address2));
            hashMap.put("layout/dialog_address3_0", Integer.valueOf((int) R.layout.dialog_address3));
            hashMap.put("layout/dialog_back_good_reason_0", Integer.valueOf((int) R.layout.dialog_back_good_reason));
            hashMap.put("layout/dialog_back_goods_0", Integer.valueOf((int) R.layout.dialog_back_goods));
            hashMap.put("layout/dialog_buyer_cancel_reason_0", Integer.valueOf((int) R.layout.dialog_buyer_cancel_reason));
            hashMap.put("layout/dialog_card_base_info_detail_0", Integer.valueOf((int) R.layout.dialog_card_base_info_detail));
            hashMap.put("layout/dialog_card_comments_0", Integer.valueOf((int) R.layout.dialog_card_comments));
            hashMap.put("layout/dialog_card_detail_0", Integer.valueOf((int) R.layout.dialog_card_detail));
            hashMap.put("layout/dialog_card_error_correct_0", Integer.valueOf((int) R.layout.dialog_card_error_correct));
            hashMap.put("layout/dialog_card_pack_list_0", Integer.valueOf((int) R.layout.dialog_card_pack_list));
            hashMap.put("layout/dialog_change_price_0", Integer.valueOf((int) R.layout.dialog_change_price));
            hashMap.put("layout/dialog_choose_new_0", Integer.valueOf((int) R.layout.dialog_choose_new));
            hashMap.put("layout/dialog_common_report_0", Integer.valueOf((int) R.layout.dialog_common_report));
            hashMap.put("layout/dialog_common_tips_0", Integer.valueOf((int) R.layout.dialog_common_tips));
            hashMap.put("layout/dialog_contact_0", Integer.valueOf((int) R.layout.dialog_contact));
            hashMap.put("layout/dialog_create_list_0", Integer.valueOf((int) R.layout.dialog_create_list));
            hashMap.put("layout/dialog_date_of_birth_0", Integer.valueOf((int) R.layout.dialog_date_of_birth));
            hashMap.put("layout/dialog_delete_0", Integer.valueOf((int) R.layout.dialog_delete));
            hashMap.put("layout/dialog_edit_product_0", Integer.valueOf((int) R.layout.dialog_edit_product));
            hashMap.put("layout/dialog_edit_user_0", Integer.valueOf((int) R.layout.dialog_edit_user));
            hashMap.put("layout/dialog_express_0", Integer.valueOf((int) R.layout.dialog_express));
            hashMap.put("layout/dialog_express_details_0", Integer.valueOf((int) R.layout.dialog_express_details));
            hashMap.put("layout/dialog_fragment_card_product_0", Integer.valueOf((int) R.layout.dialog_fragment_card_product));
            hashMap.put("layout/dialog_home_want_sell_0", Integer.valueOf((int) R.layout.dialog_home_want_sell));
            hashMap.put("layout/dialog_info_upload_0", Integer.valueOf((int) R.layout.dialog_info_upload));
            hashMap.put("layout/dialog_list_0", Integer.valueOf((int) R.layout.dialog_list));
            hashMap.put("layout/dialog_notice_0", Integer.valueOf((int) R.layout.dialog_notice));
            hashMap.put("layout/dialog_permission_request_layout_0", Integer.valueOf((int) R.layout.dialog_permission_request_layout));
            hashMap.put("layout/dialog_poster_0", Integer.valueOf((int) R.layout.dialog_poster));
            hashMap.put("layout/dialog_private_0", Integer.valueOf((int) R.layout.dialog_private));
            hashMap.put("layout/dialog_report_0", Integer.valueOf((int) R.layout.dialog_report));
            hashMap.put("layout/dialog_seller_cancel_reason_0", Integer.valueOf((int) R.layout.dialog_seller_cancel_reason));
            hashMap.put("layout/dialog_share_0", Integer.valueOf((int) R.layout.dialog_share));
            hashMap.put("layout/dialog_side_0", Integer.valueOf((int) R.layout.dialog_side));
            hashMap.put("layout/dialog_sold_out_card_0", Integer.valueOf((int) R.layout.dialog_sold_out_card));
            hashMap.put("layout/dialog_tips_0", Integer.valueOf((int) R.layout.dialog_tips));
            hashMap.put("layout/dialog_wait_check_0", Integer.valueOf((int) R.layout.dialog_wait_check));
            hashMap.put("layout/dialog_want_buy_0", Integer.valueOf((int) R.layout.dialog_want_buy));
            hashMap.put("layout/dialog_want_card_0", Integer.valueOf((int) R.layout.dialog_want_card));
            hashMap.put("layout/dialog_want_consignment_card_0", Integer.valueOf((int) R.layout.dialog_want_consignment_card));
            hashMap.put("layout/fragment_at_me_0", Integer.valueOf((int) R.layout.fragment_at_me));
            hashMap.put("layout/fragment_child_selling_0", Integer.valueOf((int) R.layout.fragment_child_selling));
            hashMap.put("layout/fragment_consignment_order_0", Integer.valueOf((int) R.layout.fragment_consignment_order));
            hashMap.put("layout/fragment_desire_0", Integer.valueOf((int) R.layout.fragment_desire));
            hashMap.put("layout/fragment_empty_0", Integer.valueOf((int) R.layout.fragment_empty));
            hashMap.put("layout/fragment_global_search_0", Integer.valueOf((int) R.layout.fragment_global_search));
            hashMap.put("layout/fragment_global_search_product_0", Integer.valueOf((int) R.layout.fragment_global_search_product));
            hashMap.put("layout/fragment_like_0", Integer.valueOf((int) R.layout.fragment_like));
            hashMap.put("layout/fragment_me_0", Integer.valueOf((int) R.layout.fragment_me));
            hashMap.put("layout/fragment_mediation_0", Integer.valueOf((int) R.layout.fragment_mediation));
            hashMap.put("layout/fragment_mine_storehouse_0", Integer.valueOf((int) R.layout.fragment_mine_storehouse));
            hashMap.put("layout/fragment_order_list_0", Integer.valueOf((int) R.layout.fragment_order_list));
            hashMap.put("layout/fragment_rank_list_0", Integer.valueOf((int) R.layout.fragment_rank_list));
            hashMap.put("layout/fragment_recent_photo_0", Integer.valueOf((int) R.layout.fragment_recent_photo));
            hashMap.put("layout/fragment_reply_me_0", Integer.valueOf((int) R.layout.fragment_reply_me));
            hashMap.put("layout/fragment_search_card_repo_0", Integer.valueOf((int) R.layout.fragment_search_card_repo));
            hashMap.put("layout/fragment_search_child_check_0", Integer.valueOf((int) R.layout.fragment_search_child_check));
            hashMap.put("layout/fragment_search_child_no_pass_0", Integer.valueOf((int) R.layout.fragment_search_child_no_pass));
            hashMap.put("layout/fragment_search_house_product_0", Integer.valueOf((int) R.layout.fragment_search_house_product));
            hashMap.put("layout/fragment_search_my_storehouse_0", Integer.valueOf((int) R.layout.fragment_search_my_storehouse));
            hashMap.put("layout/fragment_search_product_0", Integer.valueOf((int) R.layout.fragment_search_product));
            hashMap.put("layout/fragment_search_sold_0", Integer.valueOf((int) R.layout.fragment_search_sold));
            hashMap.put("layout/fragment_search_user_0", Integer.valueOf((int) R.layout.fragment_search_user));
            hashMap.put("layout/fragment_search_want_card_list_0", Integer.valueOf((int) R.layout.fragment_search_want_card_list));
            hashMap.put("layout/fragment_seller_order_list_0", Integer.valueOf((int) R.layout.fragment_seller_order_list));
            hashMap.put("layout/fragment_selling_0", Integer.valueOf((int) R.layout.fragment_selling));
            hashMap.put("layout/fragment_shop_0", Integer.valueOf((int) R.layout.fragment_shop));
            hashMap.put("layout/fragment_shop_copy_0", Integer.valueOf((int) R.layout.fragment_shop_copy));
            hashMap.put("layout/fragment_wish_list_0", Integer.valueOf((int) R.layout.fragment_wish_list));
            hashMap.put("layout/header_search_product_0", Integer.valueOf((int) R.layout.header_search_product));
            hashMap.put("layout/item_address_0", Integer.valueOf((int) R.layout.item_address));
            hashMap.put("layout/item_answer_0", Integer.valueOf((int) R.layout.item_answer));
            hashMap.put("layout/item_apply_for_0", Integer.valueOf((int) R.layout.item_apply_for));
            hashMap.put("layout/item_apply_for_return_0", Integer.valueOf((int) R.layout.item_apply_for_return));
            hashMap.put("layout/item_apply_for_return_part_0", Integer.valueOf((int) R.layout.item_apply_for_return_part));
            hashMap.put("layout/item_at_me_0", Integer.valueOf((int) R.layout.item_at_me));
            hashMap.put("layout/item_bank_0", Integer.valueOf((int) R.layout.item_bank));
            hashMap.put("layout/item_black_list_0", Integer.valueOf((int) R.layout.item_black_list));
            hashMap.put("layout/item_card_con_0", Integer.valueOf((int) R.layout.item_card_con));
            hashMap.put("layout/item_card_detail_0", Integer.valueOf((int) R.layout.item_card_detail));
            hashMap.put("layout/item_card_detail_list_0", Integer.valueOf((int) R.layout.item_card_detail_list));
            hashMap.put("layout/item_card_list_0", Integer.valueOf((int) R.layout.item_card_list));
            hashMap.put("layout/item_card_pack_list_0", Integer.valueOf((int) R.layout.item_card_pack_list));
            hashMap.put("layout/item_card_product_0", Integer.valueOf((int) R.layout.item_card_product));
            hashMap.put("layout/item_choose_0", Integer.valueOf((int) R.layout.item_choose));
            hashMap.put("layout/item_choose_new_0", Integer.valueOf((int) R.layout.item_choose_new));
            hashMap.put("layout/item_coin_0", Integer.valueOf((int) R.layout.item_coin));
            hashMap.put("layout/item_con_order_detail_0", Integer.valueOf((int) R.layout.item_con_order_detail));
            hashMap.put("layout/item_condition_0", Integer.valueOf((int) R.layout.item_condition));
            hashMap.put("layout/item_edit_product_0", Integer.valueOf((int) R.layout.item_edit_product));
            hashMap.put("layout/item_empty_0", Integer.valueOf((int) R.layout.item_empty));
            hashMap.put("layout/item_empty_white_0", Integer.valueOf((int) R.layout.item_empty_white));
            hashMap.put("layout/item_express_0", Integer.valueOf((int) R.layout.item_express));
            hashMap.put("layout/item_fans_0", Integer.valueOf((int) R.layout.item_fans));
            hashMap.put("layout/item_follow_0", Integer.valueOf((int) R.layout.item_follow));
            hashMap.put("layout/item_game_card_0", Integer.valueOf((int) R.layout.item_game_card));
            hashMap.put("layout/item_game_card2_0", Integer.valueOf((int) R.layout.item_game_card2));
            hashMap.put("layout/item_illegal_0", Integer.valueOf((int) R.layout.item_illegal));
            hashMap.put("layout/item_kind_0", Integer.valueOf((int) R.layout.item_kind));
            hashMap.put("layout/item_like_0", Integer.valueOf((int) R.layout.item_like));
            hashMap.put("layout/item_match_0", Integer.valueOf((int) R.layout.item_match));
            hashMap.put("layout/item_mine_storehouse_0", Integer.valueOf((int) R.layout.item_mine_storehouse));
            hashMap.put("layout/item_mine_storehouse_fail_0", Integer.valueOf((int) R.layout.item_mine_storehouse_fail));
            hashMap.put("layout/item_mine_storehouse_sold_0", Integer.valueOf((int) R.layout.item_mine_storehouse_sold));
            hashMap.put("layout/item_on_sell_0", Integer.valueOf((int) R.layout.item_on_sell));
            hashMap.put("layout/item_order_0", Integer.valueOf((int) R.layout.item_order));
            hashMap.put("layout/item_order_product_0", Integer.valueOf((int) R.layout.item_order_product));
            hashMap.put("layout/item_order_return_product_0", Integer.valueOf((int) R.layout.item_order_return_product));
            hashMap.put("layout/item_pack_0", Integer.valueOf((int) R.layout.item_pack));
            hashMap.put("layout/item_pack_card_list_0", Integer.valueOf((int) R.layout.item_pack_card_list));
            hashMap.put("layout/item_pop_filter_0", Integer.valueOf((int) R.layout.item_pop_filter));
            hashMap.put("layout/item_pop_filter_info_0", Integer.valueOf((int) R.layout.item_pop_filter_info));
            hashMap.put("layout/item_pop_game_0", Integer.valueOf((int) R.layout.item_pop_game));
            hashMap.put("layout/item_pop_game_filter_0", Integer.valueOf((int) R.layout.item_pop_game_filter));
            hashMap.put("layout/item_pop_list_0", Integer.valueOf((int) R.layout.item_pop_list));
            hashMap.put("layout/item_rank_card_0", Integer.valueOf((int) R.layout.item_rank_card));
            hashMap.put("layout/item_rank_pack_0", Integer.valueOf((int) R.layout.item_rank_pack));
            hashMap.put("layout/item_reply_list_0", Integer.valueOf((int) R.layout.item_reply_list));
            hashMap.put("layout/item_reply_me_0", Integer.valueOf((int) R.layout.item_reply_me));
            hashMap.put("layout/item_report_seller_0", Integer.valueOf((int) R.layout.item_report_seller));
            hashMap.put("layout/item_review_list_0", Integer.valueOf((int) R.layout.item_review_list));
            hashMap.put("layout/item_search_child_check_0", Integer.valueOf((int) R.layout.item_search_child_check));
            hashMap.put("layout/item_search_pack_0", Integer.valueOf((int) R.layout.item_search_pack));
            hashMap.put("layout/item_search_product_0", Integer.valueOf((int) R.layout.item_search_product));
            hashMap.put("layout/item_search_user_0", Integer.valueOf((int) R.layout.item_search_user));
            hashMap.put("layout/item_sell_calendar_0", Integer.valueOf((int) R.layout.item_sell_calendar));
            hashMap.put("layout/item_seller_detail_card_0", Integer.valueOf((int) R.layout.item_seller_detail_card));
            hashMap.put("layout/item_seller_order_0", Integer.valueOf((int) R.layout.item_seller_order));
            hashMap.put("layout/item_shop_card_0", Integer.valueOf((int) R.layout.item_shop_card));
            hashMap.put("layout/item_shop_cart_0", Integer.valueOf((int) R.layout.item_shop_cart));
            hashMap.put("layout/item_sort_0", Integer.valueOf((int) R.layout.item_sort));
            hashMap.put("layout/item_star_0", Integer.valueOf((int) R.layout.item_star));
            hashMap.put("layout/item_title_kind_0", Integer.valueOf((int) R.layout.item_title_kind));
            hashMap.put("layout/item_top_comment_0", Integer.valueOf((int) R.layout.item_top_comment));
            hashMap.put("layout/item_view_photo_0", Integer.valueOf((int) R.layout.item_view_photo));
            hashMap.put("layout/item_want_buy_list_0", Integer.valueOf((int) R.layout.item_want_buy_list));
            hashMap.put("layout/item_want_card_new_0", Integer.valueOf((int) R.layout.item_want_card_new));
            hashMap.put("layout/item_wish_pack_0", Integer.valueOf((int) R.layout.item_wish_pack));
            hashMap.put("layout/item_wish_product_0", Integer.valueOf((int) R.layout.item_wish_product));
            hashMap.put("layout/pop_coin_0", Integer.valueOf((int) R.layout.pop_coin));
            hashMap.put("layout/pop_condition_0", Integer.valueOf((int) R.layout.pop_condition));
            hashMap.put("layout/pop_copy_0", Integer.valueOf((int) R.layout.pop_copy));
            hashMap.put("layout/pop_filter_0", Integer.valueOf((int) R.layout.pop_filter));
            hashMap.put("layout/pop_filter_info_0", Integer.valueOf((int) R.layout.pop_filter_info));
            hashMap.put("layout/pop_game_bar_0", Integer.valueOf((int) R.layout.pop_game_bar));
            hashMap.put("layout/pop_games_bar_0", Integer.valueOf((int) R.layout.pop_games_bar));
            hashMap.put("layout/pop_interact_0", Integer.valueOf((int) R.layout.pop_interact));
            hashMap.put("layout/pop_one_0", Integer.valueOf((int) R.layout.pop_one));
            hashMap.put("layout/pop_phone_bar_0", Integer.valueOf((int) R.layout.pop_phone_bar));
            hashMap.put("layout/pop_review_0", Integer.valueOf((int) R.layout.pop_review));
            hashMap.put("layout/pop_want_buy_0", Integer.valueOf((int) R.layout.pop_want_buy));
            hashMap.put("layout/view_card_package_0", Integer.valueOf((int) R.layout.view_card_package));
            hashMap.put("layout/view_card_package_first_0", Integer.valueOf((int) R.layout.view_card_package_first));
            hashMap.put("layout/view_condition_change_0", Integer.valueOf((int) R.layout.view_condition_change));
            hashMap.put("layout/view_filter_bar_card_pack_0", Integer.valueOf((int) R.layout.view_filter_bar_card_pack));
            hashMap.put("layout/view_filter_bar_selling_0", Integer.valueOf((int) R.layout.view_filter_bar_selling));
            hashMap.put("layout/view_filter_bar_shop_home_0", Integer.valueOf((int) R.layout.view_filter_bar_shop_home));
            hashMap.put("layout/view_filter_bar_user_shop_0", Integer.valueOf((int) R.layout.view_filter_bar_user_shop));
            hashMap.put("layout/view_filter_tv_0", Integer.valueOf((int) R.layout.view_filter_tv));
            hashMap.put("layout/view_game_bar_drop_0", Integer.valueOf((int) R.layout.view_game_bar_drop));
            hashMap.put("layout/view_game_drop_box_0", Integer.valueOf((int) R.layout.view_game_drop_box));
            hashMap.put("layout/view_game_drop_box_small_0", Integer.valueOf((int) R.layout.view_game_drop_box_small));
            hashMap.put("layout/view_header_banner_0", Integer.valueOf((int) R.layout.view_header_banner));
            hashMap.put("layout/view_header_coin_0", Integer.valueOf((int) R.layout.view_header_coin));
            hashMap.put("layout/view_header_match_0", Integer.valueOf((int) R.layout.view_header_match));
            hashMap.put("layout/view_header_reply_list_0", Integer.valueOf((int) R.layout.view_header_reply_list));
            hashMap.put("layout/view_header_review_list_0", Integer.valueOf((int) R.layout.view_header_review_list));
            hashMap.put("layout/view_header_storehouse_left_0", Integer.valueOf((int) R.layout.view_header_storehouse_left));
            hashMap.put("layout/view_header_ware_banner_0", Integer.valueOf((int) R.layout.view_header_ware_banner));
            hashMap.put("layout/view_product_header_0", Integer.valueOf((int) R.layout.view_product_header));
            hashMap.put("layout/view_product_info_edit_0", Integer.valueOf((int) R.layout.view_product_info_edit));
            hashMap.put("layout/view_rarity_0", Integer.valueOf((int) R.layout.view_rarity));
            hashMap.put("layout/view_search_bar_0", Integer.valueOf((int) R.layout.view_search_bar));
            hashMap.put("layout/view_search_history_0", Integer.valueOf((int) R.layout.view_search_history));
            hashMap.put("layout/view_user_bar_0", Integer.valueOf((int) R.layout.view_user_bar));
        }

        private b() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(v3);
        w3 = sparseIntArray;
        sparseIntArray.put(R.layout.activity_about, 1);
        sparseIntArray.put(R.layout.activity_account_manager, 2);
        sparseIntArray.put(R.layout.activity_add_address, 3);
        sparseIntArray.put(R.layout.activity_add_card, 4);
        sparseIntArray.put(R.layout.activity_add_product, 5);
        sparseIntArray.put(R.layout.activity_address, 6);
        sparseIntArray.put(R.layout.activity_black_list, 7);
        sparseIntArray.put(R.layout.activity_capture, 8);
        sparseIntArray.put(R.layout.activity_card_detail, 9);
        sparseIntArray.put(R.layout.activity_card_pack_detail, 10);
        sparseIntArray.put(R.layout.activity_card_pack_list, 11);
        sparseIntArray.put(R.layout.activity_choose_card, 12);
        sparseIntArray.put(R.layout.activity_choose_photo, 13);
        sparseIntArray.put(R.layout.activity_close_account, 14);
        sparseIntArray.put(R.layout.activity_coin, 15);
        sparseIntArray.put(R.layout.activity_common_webview, 16);
        sparseIntArray.put(R.layout.activity_con_order_details, 17);
        sparseIntArray.put(R.layout.activity_consignment_order, 18);
        sparseIntArray.put(R.layout.activity_edit_phone_number, 19);
        sparseIntArray.put(R.layout.activity_edit_user, 20);
        sparseIntArray.put(R.layout.activity_entrepot_apply_for, 21);
        sparseIntArray.put(R.layout.activity_entrepot_apply_for_return, 22);
        sparseIntArray.put(R.layout.activity_etiquette_exam, 23);
        sparseIntArray.put(R.layout.activity_fans, 24);
        sparseIntArray.put(R.layout.activity_follow, 25);
        sparseIntArray.put(R.layout.activity_help, 26);
        sparseIntArray.put(R.layout.activity_illegal_list, 27);
        sparseIntArray.put(R.layout.activity_image_preview, 28);
        sparseIntArray.put(R.layout.activity_interact_message, 29);
        sparseIntArray.put(R.layout.activity_login, 30);
        sparseIntArray.put(R.layout.activity_main, 31);
        sparseIntArray.put(R.layout.activity_mine_entrepot, 32);
        sparseIntArray.put(R.layout.activity_mine_storehouse, 33);
        sparseIntArray.put(R.layout.activity_order_confirm, 34);
        sparseIntArray.put(R.layout.activity_order_detail, 35);
        sparseIntArray.put(R.layout.activity_order_list, 36);
        sparseIntArray.put(R.layout.activity_rank, 37);
        sparseIntArray.put(R.layout.activity_reply_list, 38);
        sparseIntArray.put(R.layout.activity_review_list, 39);
        sparseIntArray.put(R.layout.activity_search, 40);
        sparseIntArray.put(R.layout.activity_search_bank, 41);
        sparseIntArray.put(R.layout.activity_sell_calendar, 42);
        sparseIntArray.put(R.layout.activity_seller_confirm, 43);
        sparseIntArray.put(R.layout.activity_seller_detail, 44);
        sparseIntArray.put(R.layout.activity_seller_order_detail, 45);
        sparseIntArray.put(R.layout.activity_selling, 46);
        sparseIntArray.put(R.layout.activity_shop_car, 47);
        sparseIntArray.put(R.layout.activity_shop_owner_confirm, 48);
        sparseIntArray.put(R.layout.activity_splash, 49);
        sparseIntArray.put(R.layout.activity_submit_order, 50);
        sparseIntArray.put(R.layout.activity_submit_order_return, 51);
        sparseIntArray.put(R.layout.activity_want_buy, 52);
        sparseIntArray.put(R.layout.activity_want_buy_match, 53);
        sparseIntArray.put(R.layout.activity_want_card_list, 54);
        sparseIntArray.put(R.layout.activity_wish_list, 55);
        sparseIntArray.put(R.layout.dialog_address2, 56);
        sparseIntArray.put(R.layout.dialog_address3, 57);
        sparseIntArray.put(R.layout.dialog_back_good_reason, 58);
        sparseIntArray.put(R.layout.dialog_back_goods, 59);
        sparseIntArray.put(R.layout.dialog_buyer_cancel_reason, 60);
        sparseIntArray.put(R.layout.dialog_card_base_info_detail, 61);
        sparseIntArray.put(R.layout.dialog_card_comments, 62);
        sparseIntArray.put(R.layout.dialog_card_detail, 63);
        sparseIntArray.put(R.layout.dialog_card_error_correct, 64);
        sparseIntArray.put(R.layout.dialog_card_pack_list, 65);
        sparseIntArray.put(R.layout.dialog_change_price, 66);
        sparseIntArray.put(R.layout.dialog_choose_new, 67);
        sparseIntArray.put(R.layout.dialog_common_report, 68);
        sparseIntArray.put(R.layout.dialog_common_tips, 69);
        sparseIntArray.put(R.layout.dialog_contact, 70);
        sparseIntArray.put(R.layout.dialog_create_list, 71);
        sparseIntArray.put(R.layout.dialog_date_of_birth, 72);
        sparseIntArray.put(R.layout.dialog_delete, 73);
        sparseIntArray.put(R.layout.dialog_edit_product, 74);
        sparseIntArray.put(R.layout.dialog_edit_user, 75);
        sparseIntArray.put(R.layout.dialog_express, 76);
        sparseIntArray.put(R.layout.dialog_express_details, 77);
        sparseIntArray.put(R.layout.dialog_fragment_card_product, 78);
        sparseIntArray.put(R.layout.dialog_home_want_sell, 79);
        sparseIntArray.put(R.layout.dialog_info_upload, 80);
        sparseIntArray.put(R.layout.dialog_list, 81);
        sparseIntArray.put(R.layout.dialog_notice, 82);
        sparseIntArray.put(R.layout.dialog_permission_request_layout, 83);
        sparseIntArray.put(R.layout.dialog_poster, 84);
        sparseIntArray.put(R.layout.dialog_private, 85);
        sparseIntArray.put(R.layout.dialog_report, 86);
        sparseIntArray.put(R.layout.dialog_seller_cancel_reason, 87);
        sparseIntArray.put(R.layout.dialog_share, 88);
        sparseIntArray.put(R.layout.dialog_side, 89);
        sparseIntArray.put(R.layout.dialog_sold_out_card, 90);
        sparseIntArray.put(R.layout.dialog_tips, 91);
        sparseIntArray.put(R.layout.dialog_wait_check, 92);
        sparseIntArray.put(R.layout.dialog_want_buy, 93);
        sparseIntArray.put(R.layout.dialog_want_card, 94);
        sparseIntArray.put(R.layout.dialog_want_consignment_card, 95);
        sparseIntArray.put(R.layout.fragment_at_me, 96);
        sparseIntArray.put(R.layout.fragment_child_selling, 97);
        sparseIntArray.put(R.layout.fragment_consignment_order, 98);
        sparseIntArray.put(R.layout.fragment_desire, 99);
        sparseIntArray.put(R.layout.fragment_empty, 100);
        sparseIntArray.put(R.layout.fragment_global_search, 101);
        sparseIntArray.put(R.layout.fragment_global_search_product, 102);
        sparseIntArray.put(R.layout.fragment_like, 103);
        sparseIntArray.put(R.layout.fragment_me, 104);
        sparseIntArray.put(R.layout.fragment_mediation, 105);
        sparseIntArray.put(R.layout.fragment_mine_storehouse, 106);
        sparseIntArray.put(R.layout.fragment_order_list, 107);
        sparseIntArray.put(R.layout.fragment_rank_list, 108);
        sparseIntArray.put(R.layout.fragment_recent_photo, 109);
        sparseIntArray.put(R.layout.fragment_reply_me, 110);
        sparseIntArray.put(R.layout.fragment_search_card_repo, 111);
        sparseIntArray.put(R.layout.fragment_search_child_check, 112);
        sparseIntArray.put(R.layout.fragment_search_child_no_pass, 113);
        sparseIntArray.put(R.layout.fragment_search_house_product, 114);
        sparseIntArray.put(R.layout.fragment_search_my_storehouse, 115);
        sparseIntArray.put(R.layout.fragment_search_product, 116);
        sparseIntArray.put(R.layout.fragment_search_sold, 117);
        sparseIntArray.put(R.layout.fragment_search_user, 118);
        sparseIntArray.put(R.layout.fragment_search_want_card_list, 119);
        sparseIntArray.put(R.layout.fragment_seller_order_list, 120);
        sparseIntArray.put(R.layout.fragment_selling, 121);
        sparseIntArray.put(R.layout.fragment_shop, 122);
        sparseIntArray.put(R.layout.fragment_shop_copy, 123);
        sparseIntArray.put(R.layout.fragment_wish_list, 124);
        sparseIntArray.put(R.layout.header_search_product, 125);
        sparseIntArray.put(R.layout.item_address, 126);
        sparseIntArray.put(R.layout.item_answer, 127);
        sparseIntArray.put(R.layout.item_apply_for, 128);
        sparseIntArray.put(R.layout.item_apply_for_return, 129);
        sparseIntArray.put(R.layout.item_apply_for_return_part, z1);
        sparseIntArray.put(R.layout.item_at_me, A1);
        sparseIntArray.put(R.layout.item_bank, B1);
        sparseIntArray.put(R.layout.item_black_list, C1);
        sparseIntArray.put(R.layout.item_card_con, D1);
        sparseIntArray.put(R.layout.item_card_detail, E1);
        sparseIntArray.put(R.layout.item_card_detail_list, F1);
        sparseIntArray.put(R.layout.item_card_list, G1);
        sparseIntArray.put(R.layout.item_card_pack_list, H1);
        sparseIntArray.put(R.layout.item_card_product, I1);
        sparseIntArray.put(R.layout.item_choose, J1);
        sparseIntArray.put(R.layout.item_choose_new, K1);
        sparseIntArray.put(R.layout.item_coin, L1);
        sparseIntArray.put(R.layout.item_con_order_detail, M1);
        sparseIntArray.put(R.layout.item_condition, 144);
        sparseIntArray.put(R.layout.item_edit_product, 145);
        sparseIntArray.put(R.layout.item_empty, P1);
        sparseIntArray.put(R.layout.item_empty_white, Q1);
        sparseIntArray.put(R.layout.item_express, 148);
        sparseIntArray.put(R.layout.item_fans, S1);
        sparseIntArray.put(R.layout.item_follow, T1);
        sparseIntArray.put(R.layout.item_game_card, U1);
        sparseIntArray.put(R.layout.item_game_card2, V1);
        sparseIntArray.put(R.layout.item_illegal, W1);
        sparseIntArray.put(R.layout.item_kind, X1);
        sparseIntArray.put(R.layout.item_like, Y1);
        sparseIntArray.put(R.layout.item_match, Z1);
        sparseIntArray.put(R.layout.item_mine_storehouse, a2);
        sparseIntArray.put(R.layout.item_mine_storehouse_fail, b2);
        sparseIntArray.put(R.layout.item_mine_storehouse_sold, c2);
        sparseIntArray.put(R.layout.item_on_sell, d2);
        sparseIntArray.put(R.layout.item_order, e2);
        sparseIntArray.put(R.layout.item_order_product, f2);
        sparseIntArray.put(R.layout.item_order_return_product, g2);
        sparseIntArray.put(R.layout.item_pack, h2);
        sparseIntArray.put(R.layout.item_pack_card_list, i2);
        sparseIntArray.put(R.layout.item_pop_filter, 166);
        sparseIntArray.put(R.layout.item_pop_filter_info, k2);
        sparseIntArray.put(R.layout.item_pop_game, l2);
        sparseIntArray.put(R.layout.item_pop_game_filter, m2);
        sparseIntArray.put(R.layout.item_pop_list, n2);
        sparseIntArray.put(R.layout.item_rank_card, o2);
        sparseIntArray.put(R.layout.item_rank_pack, p2);
        sparseIntArray.put(R.layout.item_reply_list, q2);
        sparseIntArray.put(R.layout.item_reply_me, r2);
        sparseIntArray.put(R.layout.item_report_seller, 175);
        sparseIntArray.put(R.layout.item_review_list, t2);
        sparseIntArray.put(R.layout.item_search_child_check, u2);
        sparseIntArray.put(R.layout.item_search_pack, v2);
        sparseIntArray.put(R.layout.item_search_product, w2);
        sparseIntArray.put(R.layout.item_search_user, 180);
        sparseIntArray.put(R.layout.item_sell_calendar, y2);
        sparseIntArray.put(R.layout.item_seller_detail_card, z2);
        sparseIntArray.put(R.layout.item_seller_order, A2);
        sparseIntArray.put(R.layout.item_shop_card, B2);
        sparseIntArray.put(R.layout.item_shop_cart, C2);
        sparseIntArray.put(R.layout.item_sort, D2);
        sparseIntArray.put(R.layout.item_star, E2);
        sparseIntArray.put(R.layout.item_title_kind, F2);
        sparseIntArray.put(R.layout.item_top_comment, G2);
        sparseIntArray.put(R.layout.item_view_photo, H2);
        sparseIntArray.put(R.layout.item_want_buy_list, I2);
        sparseIntArray.put(R.layout.item_want_card_new, J2);
        sparseIntArray.put(R.layout.item_wish_pack, K2);
        sparseIntArray.put(R.layout.item_wish_product, L2);
        sparseIntArray.put(R.layout.pop_coin, M2);
        sparseIntArray.put(R.layout.pop_condition, N2);
        sparseIntArray.put(R.layout.pop_copy, O2);
        sparseIntArray.put(R.layout.pop_filter, P2);
        sparseIntArray.put(R.layout.pop_filter_info, Q2);
        sparseIntArray.put(R.layout.pop_game_bar, 200);
        sparseIntArray.put(R.layout.pop_games_bar, 201);
        sparseIntArray.put(R.layout.pop_interact, 202);
        sparseIntArray.put(R.layout.pop_one, 203);
        sparseIntArray.put(R.layout.pop_phone_bar, 204);
        sparseIntArray.put(R.layout.pop_review, 205);
        sparseIntArray.put(R.layout.pop_want_buy, 206);
        sparseIntArray.put(R.layout.view_card_package, 207);
        sparseIntArray.put(R.layout.view_card_package_first, 208);
        sparseIntArray.put(R.layout.view_condition_change, 209);
        sparseIntArray.put(R.layout.view_filter_bar_card_pack, 210);
        sparseIntArray.put(R.layout.view_filter_bar_selling, 211);
        sparseIntArray.put(R.layout.view_filter_bar_shop_home, 212);
        sparseIntArray.put(R.layout.view_filter_bar_user_shop, 213);
        sparseIntArray.put(R.layout.view_filter_tv, f3);
        sparseIntArray.put(R.layout.view_game_bar_drop, g3);
        sparseIntArray.put(R.layout.view_game_drop_box, h3);
        sparseIntArray.put(R.layout.view_game_drop_box_small, i3);
        sparseIntArray.put(R.layout.view_header_banner, j3);
        sparseIntArray.put(R.layout.view_header_coin, k3);
        sparseIntArray.put(R.layout.view_header_match, l3);
        sparseIntArray.put(R.layout.view_header_reply_list, m3);
        sparseIntArray.put(R.layout.view_header_review_list, n3);
        sparseIntArray.put(R.layout.view_header_storehouse_left, o3);
        sparseIntArray.put(R.layout.view_header_ware_banner, p3);
        sparseIntArray.put(R.layout.view_product_header, 225);
        sparseIntArray.put(R.layout.view_product_info_edit, r3);
        sparseIntArray.put(R.layout.view_rarity, s3);
        sparseIntArray.put(R.layout.view_search_bar, t3);
        sparseIntArray.put(R.layout.view_search_history, u3);
        sparseIntArray.put(R.layout.view_user_bar, v3);
    }

    private final ViewDataBinding a(DataBindingComponent dataBindingComponent, View view, int i4, Object obj) {
        switch (i4) {
            case 1:
                if ("layout/activity_about_0".equals(obj)) {
                    return new e.l.k.b(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_about is invalid. Received: " + obj);
            case 2:
                if ("layout/activity_account_manager_0".equals(obj)) {
                    return new d(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_account_manager is invalid. Received: " + obj);
            case 3:
                if ("layout/activity_add_address_0".equals(obj)) {
                    return new f(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_add_address is invalid. Received: " + obj);
            case 4:
                if ("layout/activity_add_card_0".equals(obj)) {
                    return new h(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_add_card is invalid. Received: " + obj);
            case 5:
                if ("layout/activity_add_product_0".equals(obj)) {
                    return new j(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_add_product is invalid. Received: " + obj);
            case 6:
                if ("layout/activity_address_0".equals(obj)) {
                    return new l(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_address is invalid. Received: " + obj);
            case 7:
                if ("layout/activity_black_list_0".equals(obj)) {
                    return new n(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_black_list is invalid. Received: " + obj);
            case 8:
                if ("layout/activity_capture_0".equals(obj)) {
                    return new p(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_capture is invalid. Received: " + obj);
            case 9:
                if ("layout/activity_card_detail_0".equals(obj)) {
                    return new r(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_card_detail is invalid. Received: " + obj);
            case 10:
                if ("layout/activity_card_pack_detail_0".equals(obj)) {
                    return new t(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_card_pack_detail is invalid. Received: " + obj);
            case 11:
                if ("layout/activity_card_pack_list_0".equals(obj)) {
                    return new v(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_card_pack_list is invalid. Received: " + obj);
            case 12:
                if ("layout/activity_choose_card_0".equals(obj)) {
                    return new x(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_choose_card is invalid. Received: " + obj);
            case 13:
                if ("layout/activity_choose_photo_0".equals(obj)) {
                    return new z(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_choose_photo is invalid. Received: " + obj);
            case 14:
                if ("layout/activity_close_account_0".equals(obj)) {
                    return new b0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_close_account is invalid. Received: " + obj);
            case 15:
                if ("layout/activity_coin_0".equals(obj)) {
                    return new d0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_coin is invalid. Received: " + obj);
            case 16:
                if ("layout/activity_common_webview_0".equals(obj)) {
                    return new f0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_common_webview is invalid. Received: " + obj);
            case 17:
                if ("layout/activity_con_order_details_0".equals(obj)) {
                    return new h0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_con_order_details is invalid. Received: " + obj);
            case 18:
                if ("layout/activity_consignment_order_0".equals(obj)) {
                    return new j0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_consignment_order is invalid. Received: " + obj);
            case 19:
                if ("layout/activity_edit_phone_number_0".equals(obj)) {
                    return new l0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_edit_phone_number is invalid. Received: " + obj);
            case 20:
                if ("layout/activity_edit_user_0".equals(obj)) {
                    return new n0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_edit_user is invalid. Received: " + obj);
            case 21:
                if ("layout/activity_entrepot_apply_for_0".equals(obj)) {
                    return new p0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_entrepot_apply_for is invalid. Received: " + obj);
            case 22:
                if ("layout/activity_entrepot_apply_for_return_0".equals(obj)) {
                    return new r0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_entrepot_apply_for_return is invalid. Received: " + obj);
            case 23:
                if ("layout/activity_etiquette_exam_0".equals(obj)) {
                    return new t0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_etiquette_exam is invalid. Received: " + obj);
            case 24:
                if ("layout/activity_fans_0".equals(obj)) {
                    return new v0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_fans is invalid. Received: " + obj);
            case 25:
                if ("layout/activity_follow_0".equals(obj)) {
                    return new x0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_follow is invalid. Received: " + obj);
            case 26:
                if ("layout/activity_help_0".equals(obj)) {
                    return new z0(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_help is invalid. Received: " + obj);
            case 27:
                if ("layout/activity_illegal_list_0".equals(obj)) {
                    return new b1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_illegal_list is invalid. Received: " + obj);
            case 28:
                if ("layout/activity_image_preview_0".equals(obj)) {
                    return new d1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_image_preview is invalid. Received: " + obj);
            case 29:
                if ("layout/activity_interact_message_0".equals(obj)) {
                    return new f1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_interact_message is invalid. Received: " + obj);
            case 30:
                if ("layout/activity_login_0".equals(obj)) {
                    return new h1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + obj);
            case 31:
                if ("layout/activity_main_0".equals(obj)) {
                    return new j1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + obj);
            case 32:
                if ("layout/activity_mine_entrepot_0".equals(obj)) {
                    return new l1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_mine_entrepot is invalid. Received: " + obj);
            case 33:
                if ("layout/activity_mine_storehouse_0".equals(obj)) {
                    return new n1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_mine_storehouse is invalid. Received: " + obj);
            case 34:
                if ("layout/activity_order_confirm_0".equals(obj)) {
                    return new p1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_order_confirm is invalid. Received: " + obj);
            case 35:
                if ("layout/activity_order_detail_0".equals(obj)) {
                    return new r1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_order_detail is invalid. Received: " + obj);
            case 36:
                if ("layout/activity_order_list_0".equals(obj)) {
                    return new t1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_order_list is invalid. Received: " + obj);
            case 37:
                if ("layout/activity_rank_0".equals(obj)) {
                    return new v1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_rank is invalid. Received: " + obj);
            case 38:
                if ("layout/activity_reply_list_0".equals(obj)) {
                    return new x1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_reply_list is invalid. Received: " + obj);
            case 39:
                if ("layout/activity_review_list_0".equals(obj)) {
                    return new z1(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_review_list is invalid. Received: " + obj);
            case 40:
                if ("layout/activity_search_0".equals(obj)) {
                    return new d2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_search is invalid. Received: " + obj);
            case 41:
                if ("layout/activity_search_bank_0".equals(obj)) {
                    return new b2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_search_bank is invalid. Received: " + obj);
            case 42:
                if ("layout/activity_sell_calendar_0".equals(obj)) {
                    return new f2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_sell_calendar is invalid. Received: " + obj);
            case 43:
                if ("layout/activity_seller_confirm_0".equals(obj)) {
                    return new h2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_seller_confirm is invalid. Received: " + obj);
            case 44:
                if ("layout/activity_seller_detail_0".equals(obj)) {
                    return new j2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_seller_detail is invalid. Received: " + obj);
            case 45:
                if ("layout/activity_seller_order_detail_0".equals(obj)) {
                    return new l2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_seller_order_detail is invalid. Received: " + obj);
            case 46:
                if ("layout/activity_selling_0".equals(obj)) {
                    return new n2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_selling is invalid. Received: " + obj);
            case 47:
                if ("layout/activity_shop_car_0".equals(obj)) {
                    return new p2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_shop_car is invalid. Received: " + obj);
            case 48:
                if ("layout/activity_shop_owner_confirm_0".equals(obj)) {
                    return new r2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_shop_owner_confirm is invalid. Received: " + obj);
            case 49:
                if ("layout/activity_splash_0".equals(obj)) {
                    return new t2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + obj);
            case 50:
                if ("layout/activity_submit_order_0".equals(obj)) {
                    return new v2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_submit_order is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i4, Object obj) {
        switch (i4) {
            case 51:
                if ("layout/activity_submit_order_return_0".equals(obj)) {
                    return new x2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_submit_order_return is invalid. Received: " + obj);
            case 52:
                if ("layout/activity_want_buy_0".equals(obj)) {
                    return new z2(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_want_buy is invalid. Received: " + obj);
            case 53:
                if ("layout/activity_want_buy_match_0".equals(obj)) {
                    return new b3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_want_buy_match is invalid. Received: " + obj);
            case 54:
                if ("layout/activity_want_card_list_0".equals(obj)) {
                    return new d3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_want_card_list is invalid. Received: " + obj);
            case 55:
                if ("layout/activity_wish_list_0".equals(obj)) {
                    return new f3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_wish_list is invalid. Received: " + obj);
            case 56:
                if ("layout/dialog_address2_0".equals(obj)) {
                    return new h3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_address2 is invalid. Received: " + obj);
            case 57:
                if ("layout/dialog_address3_0".equals(obj)) {
                    return new j3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_address3 is invalid. Received: " + obj);
            case 58:
                if ("layout/dialog_back_good_reason_0".equals(obj)) {
                    return new l3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_back_good_reason is invalid. Received: " + obj);
            case 59:
                if ("layout/dialog_back_goods_0".equals(obj)) {
                    return new n3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_back_goods is invalid. Received: " + obj);
            case 60:
                if ("layout/dialog_buyer_cancel_reason_0".equals(obj)) {
                    return new p3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_buyer_cancel_reason is invalid. Received: " + obj);
            case 61:
                if ("layout/dialog_card_base_info_detail_0".equals(obj)) {
                    return new r3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_card_base_info_detail is invalid. Received: " + obj);
            case 62:
                if ("layout/dialog_card_comments_0".equals(obj)) {
                    return new t3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_card_comments is invalid. Received: " + obj);
            case 63:
                if ("layout/dialog_card_detail_0".equals(obj)) {
                    return new v3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_card_detail is invalid. Received: " + obj);
            case 64:
                if ("layout/dialog_card_error_correct_0".equals(obj)) {
                    return new x3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_card_error_correct is invalid. Received: " + obj);
            case 65:
                if ("layout/dialog_card_pack_list_0".equals(obj)) {
                    return new z3(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_card_pack_list is invalid. Received: " + obj);
            case 66:
                if ("layout/dialog_change_price_0".equals(obj)) {
                    return new b4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_change_price is invalid. Received: " + obj);
            case 67:
                if ("layout/dialog_choose_new_0".equals(obj)) {
                    return new d4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_choose_new is invalid. Received: " + obj);
            case 68:
                if ("layout/dialog_common_report_0".equals(obj)) {
                    return new f4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_common_report is invalid. Received: " + obj);
            case 69:
                if ("layout/dialog_common_tips_0".equals(obj)) {
                    return new h4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_common_tips is invalid. Received: " + obj);
            case 70:
                if ("layout/dialog_contact_0".equals(obj)) {
                    return new j4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_contact is invalid. Received: " + obj);
            case 71:
                if ("layout/dialog_create_list_0".equals(obj)) {
                    return new l4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_create_list is invalid. Received: " + obj);
            case 72:
                if ("layout/dialog_date_of_birth_0".equals(obj)) {
                    return new n4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_date_of_birth is invalid. Received: " + obj);
            case 73:
                if ("layout/dialog_delete_0".equals(obj)) {
                    return new p4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_delete is invalid. Received: " + obj);
            case 74:
                if ("layout/dialog_edit_product_0".equals(obj)) {
                    return new r4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_edit_product is invalid. Received: " + obj);
            case 75:
                if ("layout/dialog_edit_user_0".equals(obj)) {
                    return new t4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_edit_user is invalid. Received: " + obj);
            case 76:
                if ("layout/dialog_express_0".equals(obj)) {
                    return new v4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_express is invalid. Received: " + obj);
            case 77:
                if ("layout/dialog_express_details_0".equals(obj)) {
                    return new x4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_express_details is invalid. Received: " + obj);
            case 78:
                if ("layout/dialog_fragment_card_product_0".equals(obj)) {
                    return new z4(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_fragment_card_product is invalid. Received: " + obj);
            case 79:
                if ("layout/dialog_home_want_sell_0".equals(obj)) {
                    return new b5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_home_want_sell is invalid. Received: " + obj);
            case 80:
                if ("layout/dialog_info_upload_0".equals(obj)) {
                    return new d5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_info_upload is invalid. Received: " + obj);
            case 81:
                if ("layout/dialog_list_0".equals(obj)) {
                    return new f5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_list is invalid. Received: " + obj);
            case 82:
                if ("layout/dialog_notice_0".equals(obj)) {
                    return new h5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_notice is invalid. Received: " + obj);
            case 83:
                if ("layout/dialog_permission_request_layout_0".equals(obj)) {
                    return new j5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_permission_request_layout is invalid. Received: " + obj);
            case 84:
                if ("layout/dialog_poster_0".equals(obj)) {
                    return new l5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_poster is invalid. Received: " + obj);
            case 85:
                if ("layout/dialog_private_0".equals(obj)) {
                    return new n5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_private is invalid. Received: " + obj);
            case 86:
                if ("layout/dialog_report_0".equals(obj)) {
                    return new p5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_report is invalid. Received: " + obj);
            case 87:
                if ("layout/dialog_seller_cancel_reason_0".equals(obj)) {
                    return new r5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_seller_cancel_reason is invalid. Received: " + obj);
            case 88:
                if ("layout/dialog_share_0".equals(obj)) {
                    return new t5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_share is invalid. Received: " + obj);
            case 89:
                if ("layout/dialog_side_0".equals(obj)) {
                    return new v5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_side is invalid. Received: " + obj);
            case 90:
                if ("layout/dialog_sold_out_card_0".equals(obj)) {
                    return new x5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_sold_out_card is invalid. Received: " + obj);
            case 91:
                if ("layout/dialog_tips_0".equals(obj)) {
                    return new z5(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_tips is invalid. Received: " + obj);
            case 92:
                if ("layout/dialog_wait_check_0".equals(obj)) {
                    return new b6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_wait_check is invalid. Received: " + obj);
            case 93:
                if ("layout/dialog_want_buy_0".equals(obj)) {
                    return new d6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_want_buy is invalid. Received: " + obj);
            case 94:
                if ("layout/dialog_want_card_0".equals(obj)) {
                    return new f6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_want_card is invalid. Received: " + obj);
            case 95:
                if ("layout/dialog_want_consignment_card_0".equals(obj)) {
                    return new h6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_want_consignment_card is invalid. Received: " + obj);
            case 96:
                if ("layout/fragment_at_me_0".equals(obj)) {
                    return new j6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_at_me is invalid. Received: " + obj);
            case 97:
                if ("layout/fragment_child_selling_0".equals(obj)) {
                    return new l6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_child_selling is invalid. Received: " + obj);
            case 98:
                if ("layout/fragment_consignment_order_0".equals(obj)) {
                    return new n6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_consignment_order is invalid. Received: " + obj);
            case 99:
                if ("layout/fragment_desire_0".equals(obj)) {
                    return new p6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_desire is invalid. Received: " + obj);
            case 100:
                if ("layout/fragment_empty_0".equals(obj)) {
                    return new r6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_empty is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding c(DataBindingComponent dataBindingComponent, View view, int i4, Object obj) {
        switch (i4) {
            case 101:
                if ("layout/fragment_global_search_0".equals(obj)) {
                    return new t6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_global_search is invalid. Received: " + obj);
            case 102:
                if ("layout/fragment_global_search_product_0".equals(obj)) {
                    return new v6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_global_search_product is invalid. Received: " + obj);
            case 103:
                if ("layout/fragment_like_0".equals(obj)) {
                    return new x6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_like is invalid. Received: " + obj);
            case 104:
                if ("layout/fragment_me_0".equals(obj)) {
                    return new z6(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_me is invalid. Received: " + obj);
            case 105:
                if ("layout/fragment_mediation_0".equals(obj)) {
                    return new b7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_mediation is invalid. Received: " + obj);
            case 106:
                if ("layout/fragment_mine_storehouse_0".equals(obj)) {
                    return new d7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_mine_storehouse is invalid. Received: " + obj);
            case 107:
                if ("layout/fragment_order_list_0".equals(obj)) {
                    return new f7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_order_list is invalid. Received: " + obj);
            case 108:
                if ("layout/fragment_rank_list_0".equals(obj)) {
                    return new h7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_rank_list is invalid. Received: " + obj);
            case 109:
                if ("layout/fragment_recent_photo_0".equals(obj)) {
                    return new j7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_recent_photo is invalid. Received: " + obj);
            case 110:
                if ("layout/fragment_reply_me_0".equals(obj)) {
                    return new l7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_reply_me is invalid. Received: " + obj);
            case 111:
                if ("layout/fragment_search_card_repo_0".equals(obj)) {
                    return new n7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_card_repo is invalid. Received: " + obj);
            case 112:
                if ("layout/fragment_search_child_check_0".equals(obj)) {
                    return new p7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_child_check is invalid. Received: " + obj);
            case 113:
                if ("layout/fragment_search_child_no_pass_0".equals(obj)) {
                    return new r7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_child_no_pass is invalid. Received: " + obj);
            case 114:
                if ("layout/fragment_search_house_product_0".equals(obj)) {
                    return new t7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_house_product is invalid. Received: " + obj);
            case 115:
                if ("layout/fragment_search_my_storehouse_0".equals(obj)) {
                    return new v7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_my_storehouse is invalid. Received: " + obj);
            case 116:
                if ("layout/fragment_search_product_0".equals(obj)) {
                    return new x7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_product is invalid. Received: " + obj);
            case 117:
                if ("layout/fragment_search_sold_0".equals(obj)) {
                    return new z7(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_sold is invalid. Received: " + obj);
            case 118:
                if ("layout/fragment_search_user_0".equals(obj)) {
                    return new b8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_user is invalid. Received: " + obj);
            case 119:
                if ("layout/fragment_search_want_card_list_0".equals(obj)) {
                    return new d8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_want_card_list is invalid. Received: " + obj);
            case 120:
                if ("layout/fragment_seller_order_list_0".equals(obj)) {
                    return new f8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_seller_order_list is invalid. Received: " + obj);
            case 121:
                if ("layout/fragment_selling_0".equals(obj)) {
                    return new h8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_selling is invalid. Received: " + obj);
            case 122:
                if ("layout/fragment_shop_0".equals(obj)) {
                    return new j8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_shop is invalid. Received: " + obj);
            case 123:
                if ("layout/fragment_shop_copy_0".equals(obj)) {
                    return new l8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_shop_copy is invalid. Received: " + obj);
            case 124:
                if ("layout/fragment_wish_list_0".equals(obj)) {
                    return new n8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_wish_list is invalid. Received: " + obj);
            case 125:
                if ("layout/header_search_product_0".equals(obj)) {
                    return new p8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for header_search_product is invalid. Received: " + obj);
            case 126:
                if ("layout/item_address_0".equals(obj)) {
                    return new r8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_address is invalid. Received: " + obj);
            case 127:
                if ("layout/item_answer_0".equals(obj)) {
                    return new t8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_answer is invalid. Received: " + obj);
            case 128:
                if ("layout/item_apply_for_0".equals(obj)) {
                    return new v8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_apply_for is invalid. Received: " + obj);
            case 129:
                if ("layout/item_apply_for_return_0".equals(obj)) {
                    return new x8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_apply_for_return is invalid. Received: " + obj);
            case z1 /* 130 */:
                if ("layout/item_apply_for_return_part_0".equals(obj)) {
                    return new z8(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_apply_for_return_part is invalid. Received: " + obj);
            case A1 /* 131 */:
                if ("layout/item_at_me_0".equals(obj)) {
                    return new b9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_at_me is invalid. Received: " + obj);
            case B1 /* 132 */:
                if ("layout/item_bank_0".equals(obj)) {
                    return new d9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_bank is invalid. Received: " + obj);
            case C1 /* 133 */:
                if ("layout/item_black_list_0".equals(obj)) {
                    return new f9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_black_list is invalid. Received: " + obj);
            case D1 /* 134 */:
                if ("layout/item_card_con_0".equals(obj)) {
                    return new h9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_con is invalid. Received: " + obj);
            case E1 /* 135 */:
                if ("layout/item_card_detail_0".equals(obj)) {
                    return new j9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_detail is invalid. Received: " + obj);
            case F1 /* 136 */:
                if ("layout/item_card_detail_list_0".equals(obj)) {
                    return new l9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_detail_list is invalid. Received: " + obj);
            case G1 /* 137 */:
                if ("layout/item_card_list_0".equals(obj)) {
                    return new n9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_list is invalid. Received: " + obj);
            case H1 /* 138 */:
                if ("layout/item_card_pack_list_0".equals(obj)) {
                    return new p9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_pack_list is invalid. Received: " + obj);
            case I1 /* 139 */:
                if ("layout/item_card_product_0".equals(obj)) {
                    return new r9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_card_product is invalid. Received: " + obj);
            case J1 /* 140 */:
                if ("layout/item_choose_0".equals(obj)) {
                    return new t9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_choose is invalid. Received: " + obj);
            case K1 /* 141 */:
                if ("layout/item_choose_new_0".equals(obj)) {
                    return new v9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_choose_new is invalid. Received: " + obj);
            case L1 /* 142 */:
                if ("layout/item_coin_0".equals(obj)) {
                    return new x9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_coin is invalid. Received: " + obj);
            case M1 /* 143 */:
                if ("layout/item_con_order_detail_0".equals(obj)) {
                    return new z9(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_con_order_detail is invalid. Received: " + obj);
            case 144:
                if ("layout/item_condition_0".equals(obj)) {
                    return new ba(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_condition is invalid. Received: " + obj);
            case 145:
                if ("layout/item_edit_product_0".equals(obj)) {
                    return new da(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_edit_product is invalid. Received: " + obj);
            case P1 /* 146 */:
                if ("layout/item_empty_0".equals(obj)) {
                    return new fa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_empty is invalid. Received: " + obj);
            case Q1 /* 147 */:
                if ("layout/item_empty_white_0".equals(obj)) {
                    return new ha(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_empty_white is invalid. Received: " + obj);
            case 148:
                if ("layout/item_express_0".equals(obj)) {
                    return new ja(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_express is invalid. Received: " + obj);
            case S1 /* 149 */:
                if ("layout/item_fans_0".equals(obj)) {
                    return new la(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_fans is invalid. Received: " + obj);
            case T1 /* 150 */:
                if ("layout/item_follow_0".equals(obj)) {
                    return new na(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_follow is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding d(DataBindingComponent dataBindingComponent, View view, int i4, Object obj) {
        switch (i4) {
            case U1 /* 151 */:
                if ("layout/item_game_card_0".equals(obj)) {
                    return new ra(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_game_card is invalid. Received: " + obj);
            case V1 /* 152 */:
                if ("layout/item_game_card2_0".equals(obj)) {
                    return new pa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_game_card2 is invalid. Received: " + obj);
            case W1 /* 153 */:
                if ("layout/item_illegal_0".equals(obj)) {
                    return new ta(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_illegal is invalid. Received: " + obj);
            case X1 /* 154 */:
                if ("layout/item_kind_0".equals(obj)) {
                    return new va(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_kind is invalid. Received: " + obj);
            case Y1 /* 155 */:
                if ("layout/item_like_0".equals(obj)) {
                    return new xa(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_like is invalid. Received: " + obj);
            case Z1 /* 156 */:
                if ("layout/item_match_0".equals(obj)) {
                    return new za(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_match is invalid. Received: " + obj);
            case a2 /* 157 */:
                if ("layout/item_mine_storehouse_0".equals(obj)) {
                    return new bb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_mine_storehouse is invalid. Received: " + obj);
            case b2 /* 158 */:
                if ("layout/item_mine_storehouse_fail_0".equals(obj)) {
                    return new db(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_mine_storehouse_fail is invalid. Received: " + obj);
            case c2 /* 159 */:
                if ("layout/item_mine_storehouse_sold_0".equals(obj)) {
                    return new fb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_mine_storehouse_sold is invalid. Received: " + obj);
            case d2 /* 160 */:
                if ("layout/item_on_sell_0".equals(obj)) {
                    return new hb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_on_sell is invalid. Received: " + obj);
            case e2 /* 161 */:
                if ("layout/item_order_0".equals(obj)) {
                    return new jb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order is invalid. Received: " + obj);
            case f2 /* 162 */:
                if ("layout/item_order_product_0".equals(obj)) {
                    return new lb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order_product is invalid. Received: " + obj);
            case g2 /* 163 */:
                if ("layout/item_order_return_product_0".equals(obj)) {
                    return new nb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_order_return_product is invalid. Received: " + obj);
            case h2 /* 164 */:
                if ("layout/item_pack_0".equals(obj)) {
                    return new pb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pack is invalid. Received: " + obj);
            case i2 /* 165 */:
                if ("layout/item_pack_card_list_0".equals(obj)) {
                    return new rb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pack_card_list is invalid. Received: " + obj);
            case 166:
                if ("layout/item_pop_filter_0".equals(obj)) {
                    return new tb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pop_filter is invalid. Received: " + obj);
            case k2 /* 167 */:
                if ("layout/item_pop_filter_info_0".equals(obj)) {
                    return new vb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pop_filter_info is invalid. Received: " + obj);
            case l2 /* 168 */:
                if ("layout/item_pop_game_0".equals(obj)) {
                    return new xb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pop_game is invalid. Received: " + obj);
            case m2 /* 169 */:
                if ("layout/item_pop_game_filter_0".equals(obj)) {
                    return new zb(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pop_game_filter is invalid. Received: " + obj);
            case n2 /* 170 */:
                if ("layout/item_pop_list_0".equals(obj)) {
                    return new bc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_pop_list is invalid. Received: " + obj);
            case o2 /* 171 */:
                if ("layout/item_rank_card_0".equals(obj)) {
                    return new dc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_rank_card is invalid. Received: " + obj);
            case p2 /* 172 */:
                if ("layout/item_rank_pack_0".equals(obj)) {
                    return new fc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_rank_pack is invalid. Received: " + obj);
            case q2 /* 173 */:
                if ("layout/item_reply_list_0".equals(obj)) {
                    return new hc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_reply_list is invalid. Received: " + obj);
            case r2 /* 174 */:
                if ("layout/item_reply_me_0".equals(obj)) {
                    return new jc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_reply_me is invalid. Received: " + obj);
            case 175:
                if ("layout/item_report_seller_0".equals(obj)) {
                    return new lc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_report_seller is invalid. Received: " + obj);
            case t2 /* 176 */:
                if ("layout/item_review_list_0".equals(obj)) {
                    return new nc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_review_list is invalid. Received: " + obj);
            case u2 /* 177 */:
                if ("layout/item_search_child_check_0".equals(obj)) {
                    return new pc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_child_check is invalid. Received: " + obj);
            case v2 /* 178 */:
                if ("layout/item_search_pack_0".equals(obj)) {
                    return new rc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_pack is invalid. Received: " + obj);
            case w2 /* 179 */:
                if ("layout/item_search_product_0".equals(obj)) {
                    return new tc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_product is invalid. Received: " + obj);
            case 180:
                if ("layout/item_search_user_0".equals(obj)) {
                    return new vc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_search_user is invalid. Received: " + obj);
            case y2 /* 181 */:
                if ("layout/item_sell_calendar_0".equals(obj)) {
                    return new xc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sell_calendar is invalid. Received: " + obj);
            case z2 /* 182 */:
                if ("layout/item_seller_detail_card_0".equals(obj)) {
                    return new zc(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_seller_detail_card is invalid. Received: " + obj);
            case A2 /* 183 */:
                if ("layout/item_seller_order_0".equals(obj)) {
                    return new bd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_seller_order is invalid. Received: " + obj);
            case B2 /* 184 */:
                if ("layout/item_shop_card_0".equals(obj)) {
                    return new dd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_shop_card is invalid. Received: " + obj);
            case C2 /* 185 */:
                if ("layout/item_shop_cart_0".equals(obj)) {
                    return new fd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_shop_cart is invalid. Received: " + obj);
            case D2 /* 186 */:
                if ("layout/item_sort_0".equals(obj)) {
                    return new hd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sort is invalid. Received: " + obj);
            case E2 /* 187 */:
                if ("layout/item_star_0".equals(obj)) {
                    return new jd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_star is invalid. Received: " + obj);
            case F2 /* 188 */:
                if ("layout/item_title_kind_0".equals(obj)) {
                    return new ld(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_title_kind is invalid. Received: " + obj);
            case G2 /* 189 */:
                if ("layout/item_top_comment_0".equals(obj)) {
                    return new nd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_top_comment is invalid. Received: " + obj);
            case H2 /* 190 */:
                if ("layout/item_view_photo_0".equals(obj)) {
                    return new pd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_view_photo is invalid. Received: " + obj);
            case I2 /* 191 */:
                if ("layout/item_want_buy_list_0".equals(obj)) {
                    return new rd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_want_buy_list is invalid. Received: " + obj);
            case J2 /* 192 */:
                if ("layout/item_want_card_new_0".equals(obj)) {
                    return new td(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_want_card_new is invalid. Received: " + obj);
            case K2 /* 193 */:
                if ("layout/item_wish_pack_0".equals(obj)) {
                    return new vd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_wish_pack is invalid. Received: " + obj);
            case L2 /* 194 */:
                if ("layout/item_wish_product_0".equals(obj)) {
                    return new xd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_wish_product is invalid. Received: " + obj);
            case M2 /* 195 */:
                if ("layout/pop_coin_0".equals(obj)) {
                    return new zd(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_coin is invalid. Received: " + obj);
            case N2 /* 196 */:
                if ("layout/pop_condition_0".equals(obj)) {
                    return new be(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_condition is invalid. Received: " + obj);
            case O2 /* 197 */:
                if ("layout/pop_copy_0".equals(obj)) {
                    return new de(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_copy is invalid. Received: " + obj);
            case P2 /* 198 */:
                if ("layout/pop_filter_0".equals(obj)) {
                    return new fe(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_filter is invalid. Received: " + obj);
            case Q2 /* 199 */:
                if ("layout/pop_filter_info_0".equals(obj)) {
                    return new he(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_filter_info is invalid. Received: " + obj);
            case 200:
                if ("layout/pop_game_bar_0".equals(obj)) {
                    return new je(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_game_bar is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding e(DataBindingComponent dataBindingComponent, View view, int i4, Object obj) {
        switch (i4) {
            case 201:
                if ("layout/pop_games_bar_0".equals(obj)) {
                    return new le(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_games_bar is invalid. Received: " + obj);
            case 202:
                if ("layout/pop_interact_0".equals(obj)) {
                    return new ne(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_interact is invalid. Received: " + obj);
            case 203:
                if ("layout/pop_one_0".equals(obj)) {
                    return new pe(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_one is invalid. Received: " + obj);
            case 204:
                if ("layout/pop_phone_bar_0".equals(obj)) {
                    return new re(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_phone_bar is invalid. Received: " + obj);
            case 205:
                if ("layout/pop_review_0".equals(obj)) {
                    return new te(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_review is invalid. Received: " + obj);
            case 206:
                if ("layout/pop_want_buy_0".equals(obj)) {
                    return new ve(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pop_want_buy is invalid. Received: " + obj);
            case 207:
                if ("layout/view_card_package_0".equals(obj)) {
                    return new xe(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_card_package is invalid. Received: " + obj);
            case 208:
                if ("layout/view_card_package_first_0".equals(obj)) {
                    return new ze(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_card_package_first is invalid. Received: " + obj);
            case 209:
                if ("layout/view_condition_change_0".equals(obj)) {
                    return new bf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_condition_change is invalid. Received: " + obj);
            case 210:
                if ("layout/view_filter_bar_card_pack_0".equals(obj)) {
                    return new df(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_filter_bar_card_pack is invalid. Received: " + obj);
            case 211:
                if ("layout/view_filter_bar_selling_0".equals(obj)) {
                    return new ff(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_filter_bar_selling is invalid. Received: " + obj);
            case 212:
                if ("layout/view_filter_bar_shop_home_0".equals(obj)) {
                    return new hf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_filter_bar_shop_home is invalid. Received: " + obj);
            case 213:
                if ("layout/view_filter_bar_user_shop_0".equals(obj)) {
                    return new jf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_filter_bar_user_shop is invalid. Received: " + obj);
            case f3 /* 214 */:
                if ("layout/view_filter_tv_0".equals(obj)) {
                    return new lf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_filter_tv is invalid. Received: " + obj);
            case g3 /* 215 */:
                if ("layout/view_game_bar_drop_0".equals(obj)) {
                    return new nf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_game_bar_drop is invalid. Received: " + obj);
            case h3 /* 216 */:
                if ("layout/view_game_drop_box_0".equals(obj)) {
                    return new pf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_game_drop_box is invalid. Received: " + obj);
            case i3 /* 217 */:
                if ("layout/view_game_drop_box_small_0".equals(obj)) {
                    return new rf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_game_drop_box_small is invalid. Received: " + obj);
            case j3 /* 218 */:
                if ("layout/view_header_banner_0".equals(obj)) {
                    return new tf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_header_banner is invalid. Received: " + obj);
            case k3 /* 219 */:
                if ("layout/view_header_coin_0".equals(obj)) {
                    return new vf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_header_coin is invalid. Received: " + obj);
            case l3 /* 220 */:
                if ("layout/view_header_match_0".equals(obj)) {
                    return new xf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_header_match is invalid. Received: " + obj);
            case m3 /* 221 */:
                if ("layout/view_header_reply_list_0".equals(obj)) {
                    return new zf(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_header_reply_list is invalid. Received: " + obj);
            case n3 /* 222 */:
                if ("layout/view_header_review_list_0".equals(obj)) {
                    return new bg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_header_review_list is invalid. Received: " + obj);
            case o3 /* 223 */:
                if ("layout/view_header_storehouse_left_0".equals(obj)) {
                    return new dg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_header_storehouse_left is invalid. Received: " + obj);
            case p3 /* 224 */:
                if ("layout/view_header_ware_banner_0".equals(obj)) {
                    return new fg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_header_ware_banner is invalid. Received: " + obj);
            case 225:
                if ("layout/view_product_header_0".equals(obj)) {
                    return new hg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_product_header is invalid. Received: " + obj);
            case r3 /* 226 */:
                if ("layout/view_product_info_edit_0".equals(obj)) {
                    return new jg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_product_info_edit is invalid. Received: " + obj);
            case s3 /* 227 */:
                if ("layout/view_rarity_0".equals(obj)) {
                    return new lg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_rarity is invalid. Received: " + obj);
            case t3 /* 228 */:
                if ("layout/view_search_bar_0".equals(obj)) {
                    return new ng(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_search_bar is invalid. Received: " + obj);
            case u3 /* 229 */:
                if ("layout/view_search_history_0".equals(obj)) {
                    return new pg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_search_history is invalid. Received: " + obj);
            case v3 /* 230 */:
                if ("layout/view_user_bar_0".equals(obj)) {
                    return new rg(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_user_bar is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.jihuanshe.base.DataBinderMapperImpl());
        arrayList.add(new com.vector.DataBinderMapperImpl());
        arrayList.add(new com.xres.address_selector.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i4) {
        return a.a.get(i4);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i4) {
        int i5 = w3.get(i4);
        if (i5 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                int i6 = (i5 - 1) / 50;
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                if (i6 != 4) {
                                    return null;
                                }
                                return e(dataBindingComponent, view, i5, tag);
                            }
                            return d(dataBindingComponent, view, i5, tag);
                        }
                        return c(dataBindingComponent, view, i5, tag);
                    }
                    return b(dataBindingComponent, view, i5, tag);
                }
                return a(dataBindingComponent, view, i5, tag);
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i4) {
        if (viewArr == null || viewArr.length == 0 || w3.get(i4) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
