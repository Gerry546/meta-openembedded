SUMMARY = "Netscape Portable Runtime Library"
HOMEPAGE =  "http://www.mozilla.org/projects/nspr/"
LICENSE = "GPL-2.0-only | MPL-2.0 | LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://configure.in;beginline=3;endline=6;md5=90c2fdee38e45d6302abcfe475c8b5c5 \
                    file://Makefile.in;beginline=4;endline=38;md5=beda1dbb98a515f557d3e58ef06bca99"
SECTION = "libs/network"

SRC_URI = "http://ftp.mozilla.org/pub/nspr/releases/v${PV}/src/nspr-${PV}.tar.gz \
           file://0001-remove-rpath-from-tests.patch \
           file://0002-Fix-build-failure-on-x86_64.patch \
           file://0003-Add-nios2-support.patch \
           file://0004-md-Fix-build-with-musl.patch  \
           file://0005-Makefile.in-remove-_BUILD_STRING-and-_BUILD_TIME.patch \
           file://0006-config-nspr-config.in-don-t-pass-LDFLAGS.patch \
           file://nspr.pc.in \
           "

CACHED_CONFIGUREVARS:append:libc-musl = " CFLAGS='${CFLAGS} -D_PR_POLL_AVAILABLE \
                                          -D_PR_HAVE_LARGE_OFF_T -D_PR_INET6 -D_PR_HAVE_INET_NTOP \
                                          -D_PR_HAVE_GETHOSTBYNAME2 -D_PR_HAVE_GETADDRINFO \
                                          -D_PR_INET6_PROBE -DNO_DLOPEN_NULL'"

UPSTREAM_CHECK_URI = "http://ftp.mozilla.org/pub/nspr/releases/"
UPSTREAM_CHECK_REGEX = "v(?P<pver>\d+(\.\d+)+)/"

SRC_URI[sha256sum] = "55dec317f1401cd2e5dba844d340b930ab7547f818179a4002bce62e6f1c6895"

CVE_PRODUCT = "netscape_portable_runtime"

S = "${UNPACKDIR}/nspr-${PV}/nspr"

RDEPENDS:${PN}-dev += "perl"
TARGET_CC_ARCH += "${LDFLAGS}"

TESTS = " \
    accept \
    acceptread \
    acceptreademu \
    affinity \
    alarm \
    anonfm \
    atomic \
    attach \
    bigfile \
    cleanup \
    cltsrv  \
    concur \
    cvar \
    cvar2 \
    dlltest \
    dtoa \
    errcodes \
    exit \
    fdcach \
    fileio \
    foreign \
    formattm \
    fsync \
    gethost \
    getproto \
    i2l \
    initclk \
    inrval \
    instrumt \
    intrio \
    intrupt \
    io_timeout \
    ioconthr \
    join \
    joinkk \
    joinku \
    joinuk \
    joinuu \
    layer \
    lazyinit \
    libfilename \
    lltest \
    lock \
    lockfile \
    logfile \
    logger \
    many_cv \
    multiwait \
    nameshm1 \
    nblayer \
    nonblock \
    ntioto \
    ntoh \
    op_2long \
    op_excl \
    op_filnf \
    op_filok \
    op_nofil \
    parent \
    parsetm \
    peek \
    perf \
    pipeping \
    pipeping2 \
    pipeself \
    poll_nm \
    poll_to \
    pollable \
    prftest \
    primblok \
    provider \
    prpollml \
    ranfile \
    randseed \
    reinit \
    rwlocktest \
    sel_spd \
    selct_er \
    selct_nm \
    selct_to \
    selintr \
    sema \
    semaerr \
    semaping \
    sendzlf \
    server_test \
    servr_kk \
    servr_uk \
    servr_ku \
    servr_uu \
    short_thread \
    sigpipe \
    socket \
    sockopt \
    sockping \
    sprintf \
    stack \
    stdio \
    str2addr \
    strod \
    switch \
    system \
    testbit \
    testfile \
    threads \
    timemac \
    timetest \
    tpd \
    udpsrv \
    vercheck \
    version \
    writev \
    xnotify \
    zerolen"

inherit autotools multilib_script

MULTILIB_SCRIPTS = "${PN}-dev:${bindir}/nspr-config"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'ipv6', d)}"
PACKAGECONFIG[ipv6] = "--enable-ipv6,--disable-ipv6,"

# Do not install nspr in usr/include, but in usr/include/nspr, the
# preferred path upstream.
EXTRA_OECONF += "--includedir=${includedir}/nspr"

EXTRA_OEMAKE:append:class-native = " EXTRA_LIBS='-lpthread -lrt -ldl'"

do_compile:prepend() {
	oe_runmake CROSS_COMPILE=1 CFLAGS="-DXP_UNIX ${BUILD_CFLAGS}" LDFLAGS="" CC="${BUILD_CC}" -C config export
}

do_compile:append() {
	oe_runmake -C pr/tests
}

do_install:append() {
    install -D ${UNPACKDIR}/nspr.pc.in ${D}${libdir}/pkgconfig/nspr.pc
    sed -i  \
    -e 's:NSPRVERSION:${PV}:g' \
    -e 's:OEPREFIX:${prefix}:g' \
    -e 's:OELIBDIR:${libdir}:g' \
    -e 's:OEINCDIR:${includedir}:g' \
    -e 's:OEEXECPREFIX:${exec_prefix}:g' \
    ${D}${libdir}/pkgconfig/nspr.pc

    mkdir -p ${D}${libdir}/nspr/tests
    install -m 0755 ${S}/pr/tests/runtests.pl ${D}${libdir}/nspr/tests
    install -m 0755 ${S}/pr/tests/runtests.sh ${D}${libdir}/nspr/tests
    cd ${B}/pr/tests
    install -m 0755 ${TESTS} ${D}${libdir}/nspr/tests

    # delete compile-et.pl and perr.properties from ${bindir} because these are
    # only used to generate prerr.c and prerr.h files from prerr.et at compile
    # time
    rm ${D}${bindir}/compile-et.pl ${D}${bindir}/prerr.properties
}

FILES:${PN} = "${libdir}/lib*.so"
FILES:${PN}-dev = "${bindir}/* ${libdir}/nspr/tests/* ${libdir}/pkgconfig \
                ${includedir}/* ${datadir}/aclocal/* "

BBCLASSEXTEND = "native nativesdk"
