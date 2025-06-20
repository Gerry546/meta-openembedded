SUMMARY = "Fast property caching"
HOMEPAGE = "https://github.com/aio-libs/propcache"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "20d7d62e4e7ef05f221e0db2856b979540686342e7dd9973b815599c7057e168"

inherit pypi python_setuptools_build_meta ptest-python-pytest cython

DEPENDS += " \
	python3-expandvars-native \
"

RDEPENDS:${PN}-ptest += " \
	python3-pytest-codspeed \
	python3-pytest-xdist \
	python3-rich \
	python3-statistics \
"

