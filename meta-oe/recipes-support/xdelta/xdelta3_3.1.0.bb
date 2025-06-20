SUMMARY = "Xdelta is a tool for differential compression"
DESCRIPTION = "Open-source binary diff, differential compression tools, \
               VCDIFF (RFC 3284) delta compression."
HOMEPAGE = "http://xdelta.org/"
SECTION = "console/utils"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://github.com/jmacd/xdelta.git;branch=release3_1_apl;protocol=https"
SRCREV = "4b4aed71a959fe11852e45242bb6524be85d3709"
S = "${UNPACKDIR}/${BP}/xdelta3"

inherit autotools

# Optional secondary compression
PACKAGECONFIG ??= ""
PACKAGECONFIG[lzma] = "--with-liblzma,--without-liblzma,xz"

BBCLASSEXTEND = "native nativesdk"
