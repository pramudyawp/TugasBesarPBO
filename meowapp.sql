PGDMP     /                    y            meowapp    13.2    13.2 '    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    66235    meowapp    DATABASE     g   CREATE DATABASE meowapp WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Indonesia.1252';
    DROP DATABASE meowapp;
                postgres    false            ?            1259    66362 	   aksesoris    TABLE     4  CREATE TABLE public.aksesoris (
    id_aksesoris integer NOT NULL,
    merk character varying(50) NOT NULL,
    nama character varying(100) NOT NULL,
    kemasan character varying(30) NOT NULL,
    berat integer NOT NULL,
    stok integer NOT NULL,
    harga integer NOT NULL,
    deskripsi text NOT NULL
);
    DROP TABLE public.aksesoris;
       public         heap    postgres    false            ?            1259    66360    aksesoris_id_aksesoris_seq    SEQUENCE     ?   CREATE SEQUENCE public.aksesoris_id_aksesoris_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.aksesoris_id_aksesoris_seq;
       public          postgres    false    203            ?           0    0    aksesoris_id_aksesoris_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.aksesoris_id_aksesoris_seq OWNED BY public.aksesoris.id_aksesoris;
          public          postgres    false    202            ?            1259    66376    mainan    TABLE     .  CREATE TABLE public.mainan (
    id_mainan integer NOT NULL,
    merk character varying(50) NOT NULL,
    nama character varying(100) NOT NULL,
    kemasan character varying(30) NOT NULL,
    berat integer NOT NULL,
    stok integer NOT NULL,
    harga integer NOT NULL,
    deskripsi text NOT NULL
);
    DROP TABLE public.mainan;
       public         heap    postgres    false            ?            1259    66374    mainan_id_mainan_seq    SEQUENCE     ?   CREATE SEQUENCE public.mainan_id_mainan_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.mainan_id_mainan_seq;
       public          postgres    false    205            ?           0    0    mainan_id_mainan_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.mainan_id_mainan_seq OWNED BY public.mainan.id_mainan;
          public          postgres    false    204            ?            1259    66423    makanan    TABLE     B  CREATE TABLE public.makanan (
    id_makanan integer NOT NULL,
    merk character varying(50) NOT NULL,
    nama character varying(100) NOT NULL,
    kemasan character varying(20) NOT NULL,
    berat integer NOT NULL,
    stok integer NOT NULL,
    harga integer NOT NULL,
    deskripsi character varying(100) NOT NULL
);
    DROP TABLE public.makanan;
       public         heap    postgres    false            ?            1259    66421    makanan_id_makanan_seq    SEQUENCE     ?   CREATE SEQUENCE public.makanan_id_makanan_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.makanan_id_makanan_seq;
       public          postgres    false    209            ?           0    0    makanan_id_makanan_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.makanan_id_makanan_seq OWNED BY public.makanan.id_makanan;
          public          postgres    false    208            ?            1259    66331    pegawai    TABLE     ;  CREATE TABLE public.pegawai (
    id_pegawai integer NOT NULL,
    nama_pegawai character varying(100) NOT NULL,
    jenis_kelamin character varying(10) NOT NULL,
    alamat_pegawai character varying(100) NOT NULL,
    kota_pegawai character varying(20) NOT NULL,
    telp_pegawai character varying(13) NOT NULL
);
    DROP TABLE public.pegawai;
       public         heap    postgres    false            ?            1259    66329    pegawai_id_pegawai_seq    SEQUENCE     ?   CREATE SEQUENCE public.pegawai_id_pegawai_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.pegawai_id_pegawai_seq;
       public          postgres    false    201            ?           0    0    pegawai_id_pegawai_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.pegawai_id_pegawai_seq OWNED BY public.pegawai.id_pegawai;
          public          postgres    false    200            ?            1259    66415    transaksi_produk    TABLE       CREATE TABLE public.transaksi_produk (
    id_transaksi integer NOT NULL,
    tanggal character varying(10) NOT NULL,
    nama_produk character varying(100) NOT NULL,
    jumlah_produk integer NOT NULL,
    harga integer NOT NULL,
    total_harga integer NOT NULL
);
 $   DROP TABLE public.transaksi_produk;
       public         heap    postgres    false            ?            1259    66413 !   transaksi_produk_id_transaksi_seq    SEQUENCE     ?   CREATE SEQUENCE public.transaksi_produk_id_transaksi_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.transaksi_produk_id_transaksi_seq;
       public          postgres    false    207            ?           0    0 !   transaksi_produk_id_transaksi_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.transaksi_produk_id_transaksi_seq OWNED BY public.transaksi_produk.id_transaksi;
          public          postgres    false    206            =           2604    66365    aksesoris id_aksesoris    DEFAULT     ?   ALTER TABLE ONLY public.aksesoris ALTER COLUMN id_aksesoris SET DEFAULT nextval('public.aksesoris_id_aksesoris_seq'::regclass);
 E   ALTER TABLE public.aksesoris ALTER COLUMN id_aksesoris DROP DEFAULT;
       public          postgres    false    202    203    203            >           2604    66379    mainan id_mainan    DEFAULT     t   ALTER TABLE ONLY public.mainan ALTER COLUMN id_mainan SET DEFAULT nextval('public.mainan_id_mainan_seq'::regclass);
 ?   ALTER TABLE public.mainan ALTER COLUMN id_mainan DROP DEFAULT;
       public          postgres    false    205    204    205            @           2604    66426    makanan id_makanan    DEFAULT     x   ALTER TABLE ONLY public.makanan ALTER COLUMN id_makanan SET DEFAULT nextval('public.makanan_id_makanan_seq'::regclass);
 A   ALTER TABLE public.makanan ALTER COLUMN id_makanan DROP DEFAULT;
       public          postgres    false    208    209    209            <           2604    66334    pegawai id_pegawai    DEFAULT     x   ALTER TABLE ONLY public.pegawai ALTER COLUMN id_pegawai SET DEFAULT nextval('public.pegawai_id_pegawai_seq'::regclass);
 A   ALTER TABLE public.pegawai ALTER COLUMN id_pegawai DROP DEFAULT;
       public          postgres    false    201    200    201            ?           2604    66418    transaksi_produk id_transaksi    DEFAULT     ?   ALTER TABLE ONLY public.transaksi_produk ALTER COLUMN id_transaksi SET DEFAULT nextval('public.transaksi_produk_id_transaksi_seq'::regclass);
 L   ALTER TABLE public.transaksi_produk ALTER COLUMN id_transaksi DROP DEFAULT;
       public          postgres    false    207    206    207            ?          0    66362 	   aksesoris 
   TABLE DATA           e   COPY public.aksesoris (id_aksesoris, merk, nama, kemasan, berat, stok, harga, deskripsi) FROM stdin;
    public          postgres    false    203   j.       ?          0    66376    mainan 
   TABLE DATA           _   COPY public.mainan (id_mainan, merk, nama, kemasan, berat, stok, harga, deskripsi) FROM stdin;
    public          postgres    false    205   ?.       ?          0    66423    makanan 
   TABLE DATA           a   COPY public.makanan (id_makanan, merk, nama, kemasan, berat, stok, harga, deskripsi) FROM stdin;
    public          postgres    false    209   o/       ?          0    66331    pegawai 
   TABLE DATA           v   COPY public.pegawai (id_pegawai, nama_pegawai, jenis_kelamin, alamat_pegawai, kota_pegawai, telp_pegawai) FROM stdin;
    public          postgres    false    201   ?/       ?          0    66415    transaksi_produk 
   TABLE DATA           q   COPY public.transaksi_produk (id_transaksi, tanggal, nama_produk, jumlah_produk, harga, total_harga) FROM stdin;
    public          postgres    false    207   ?0       ?           0    0    aksesoris_id_aksesoris_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.aksesoris_id_aksesoris_seq', 3, true);
          public          postgres    false    202            ?           0    0    mainan_id_mainan_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.mainan_id_mainan_seq', 4, true);
          public          postgres    false    204            ?           0    0    makanan_id_makanan_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.makanan_id_makanan_seq', 7, true);
          public          postgres    false    208            ?           0    0    pegawai_id_pegawai_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.pegawai_id_pegawai_seq', 17, true);
          public          postgres    false    200            ?           0    0 !   transaksi_produk_id_transaksi_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.transaksi_produk_id_transaksi_seq', 26, true);
          public          postgres    false    206            D           2606    66370    aksesoris aksesoris_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.aksesoris
    ADD CONSTRAINT aksesoris_pkey PRIMARY KEY (id_aksesoris);
 B   ALTER TABLE ONLY public.aksesoris DROP CONSTRAINT aksesoris_pkey;
       public            postgres    false    203            F           2606    66384    mainan mainan_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.mainan
    ADD CONSTRAINT mainan_pkey PRIMARY KEY (id_mainan);
 <   ALTER TABLE ONLY public.mainan DROP CONSTRAINT mainan_pkey;
       public            postgres    false    205            J           2606    66428    makanan makanan_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.makanan
    ADD CONSTRAINT makanan_pkey PRIMARY KEY (id_makanan);
 >   ALTER TABLE ONLY public.makanan DROP CONSTRAINT makanan_pkey;
       public            postgres    false    209            B           2606    66336    pegawai pegawai_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pegawai
    ADD CONSTRAINT pegawai_pkey PRIMARY KEY (id_pegawai);
 >   ALTER TABLE ONLY public.pegawai DROP CONSTRAINT pegawai_pkey;
       public            postgres    false    201            H           2606    66420 &   transaksi_produk transaksi_produk_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.transaksi_produk
    ADD CONSTRAINT transaksi_produk_pkey PRIMARY KEY (id_transaksi);
 P   ALTER TABLE ONLY public.transaksi_produk DROP CONSTRAINT transaksi_produk_pkey;
       public            postgres    false    207            ?   X   x?3??N-H,)?tʯ?4?41?425 ??̪TC???̼t.#?H?Hg?N?ĬR΀?????lNCNcN?r??`??=... ??      ?   ?   x?5??
?0???S?	Ĵ?^?P?xYJ?!&???????=??Ǯ????X?69?K򖓎PO?IH?-??t?qp,?C??j?ٙw?	?]?݃?8??`?_B???l??g??H?(qM?S????7Ś???V?@????"? Q?2      ?   u   x?3?ʯL?QpN????4?5Vp*?I???I,.???4?44?42 N.3???????b??? ? Ns??P???\?pծ~?ޜ?
!??y?N?@e??&`?E?????\1z\\\ ϖ%^      ?   ?   x?]α?0????}	m???????rն?B???n.??]??9??Y?;N)?j|??????mp?=??????!@?yT??JH&?fN8?팝?????7?9????~??
???I0QR??RL???{??&.??)z??m?a?5Ei??P?#c?}??>?      ?   ?   x?eα!?z?????????0??!?I????s!!q6?ev(??(i)8?O???ۀ?4s???ķ??5o??*??H?~α(?Ʃ*?w????jloK??O???Ss??eMk(?B?&?H?5??3?|?%2q     