# Copyright (C) 2017 Aaron Brice <aaron.brice@datasoft.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Administration tool for IP sets"
HOMEPAGE = "http://ipset.netfilter.org"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "base"

DEPENDS = "libtool libmnl"

SRC_URI = "http://ftp.netfilter.org/pub/ipset/${BP}.tar.bz2 \
           file://0001-ipset-Define-portable-basename-function.patch"
SRC_URI[sha256sum] = "f6ac5a47c3ef9f4c67fcbdf55e791cbfe38eb0a4aa1baacd12646a140abacdd9"

inherit autotools pkgconfig module-base

EXTRA_OECONF += "-with-kbuild=${KBUILD_OUTPUT} --with-ksource=${STAGING_KERNEL_DIR}"

RRECOMMENDS:${PN} = "\
    kernel-module-ip-set \
"
