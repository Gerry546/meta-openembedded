SUMMARY = "A Python module for decorators, wrappers and monkey patching."
HOMEPAGE = "https://wrapt.readthedocs.org/"
LICENSE = "BSD-2-Clause"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc34cbad60bc961452eb7ade801d25f7"

SRC_URI[sha256sum] = "5f370f952971e7d17c7d1ead40e49f32345a7f7a5373571ef44d800d06b1899d"

inherit setuptools3 ptest-python-pytest

SRCREV = "bcc1f26b2fe8fc962f5033c3a3a773425500789a"
SRC_URI += "git://github.com/GrahamDumpleton/wrapt;protocol=https;branch=master \
"


# python3-misc for 'this' module
RDEPENDS:${PN}-ptest += " \
	python3-misc \
"

RDEPENDS:${PN}:class-target += "\
    python3-stringold \
    python3-threading \
"

BBCLASSEXTEND = "native"
