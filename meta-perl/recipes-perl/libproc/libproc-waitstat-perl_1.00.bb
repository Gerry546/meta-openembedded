SUMMARY = "Interpret and act on wait() status values"
DESCRIPTION = "This module contains functions for interpreting and acting \
on wait status values."

HOMEPAGE = "https://metacpan.org/dist/Proc-WaitStat"
SECTION = "libraries"

LICENSE = "Artistic-1.0 | GPL-1.0-or-later"
LIC_FILES_CHKSUM = "file://README;beginline=21;endline=23;md5=f36550f59a0ae5e6e3b0be6a4da60d26"

RDEPENDS:${PN} += "perl libipc-signal-perl"

S = "${UNPACKDIR}/Proc-WaitStat-${PV}"

SRC_URI = "${CPAN_MIRROR}/authors/id/R/RO/ROSCH/Proc-WaitStat-${PV}.tar.gz"

SRC_URI[sha256sum] = "d07563f5e787909d16e7390241e877f49ab739b1de9d0e2ea1a41bd0bf4474bc"

inherit cpan
