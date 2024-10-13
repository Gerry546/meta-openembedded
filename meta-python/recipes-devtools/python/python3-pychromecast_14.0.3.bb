SUMMARY = "Library for Python 3.6+ to communicate with the Google Chromecast."
HOMEPAGE = "https://github.com/balloob/pychromecast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1dbd4e85f47b389bdadee9c694669f5"

SRC_URI += "file://0001-Allow-newer-version-of-wheel-and-setuptools.patch"
SRC_URI[sha256sum] = "4b0357c09cb0974af9b6b710347ef722ef596628e5323e2c9727818a7b7fc797"

PYPI_PACKAGE = "PyChromecast"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-zeroconf (>=0.135.0) \
    python3-protobuf (>=5.28.2) \
    python3-casttube (>=0.2.1) \
"
