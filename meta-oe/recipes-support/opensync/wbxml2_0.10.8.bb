SUMMARY = "WBXML parsing and encoding library"
HOMEPAGE = "http://libwbxml.opensync.org/"
SECTION = "libs"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=c1128ee5341ccd5927d8bafe4b6266e1"

DEPENDS = "expat"

SRC_URI = "${SOURCEFORGE_MIRROR}/libwbxml/libwbxml-${PV}.tar.gz"

SRC_URI[sha256sum] = "a057daa098f12838eb4e635bb28413027f1b73819872c3fbf64e3207790a3f7d"

S = "${UNPACKDIR}/libwbxml-${PV}"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')}"

PACKAGES += "${PN}-tools"

FILES:${PN}-tools = "${bindir}"
FILES:${PN} = "${libdir}/*.so.*"
