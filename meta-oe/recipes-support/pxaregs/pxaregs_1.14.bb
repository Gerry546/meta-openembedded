SUMMARY = "Tool to display and modify PXA registers at runtime"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://pxaregs.c;endline=12;md5=668d061b7637acc68cb8071c9be372e6"
HOMEPAGE = "http://www.mn-logistik.de/unsupported/pxa250/"

SRC_URI = "file://pxaregs.c \
           file://i2c.patch \
           file://munmap.patch \
           file://serial.patch \
           file://usb.patch "

S = "${UNPACKDIR}"

do_compile() {
    ${CC} pxaregs.c -o pxaregs ${CFLAGS} ${LDFLAGS}
}

do_install() {
    install -d ${D}${sbindir}/
    install -m 0755 pxaregs ${D}${sbindir}/
}

SRC_URI[sha256sum] = "f339b91cd8ab348052c36b36d20033e4bffc3666bc836ff72d5704f025e1c057"
