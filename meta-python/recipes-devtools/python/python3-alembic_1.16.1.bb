DESCRIPTION = "A database migration tool for SQLAlchemy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2ee18d90dcc02d96b76e9e953629936"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "43d37ba24b3d17bc1eb1024fe0f51cd1dc95aeb5464594a02c6bb9ca9864bfa4"

RDEPENDS:${PN} += "\
    python3-dateutil \
    python3-editor \
    python3-mako \
    python3-sqlalchemy \
    python3-misc \
"

BBCLASSEXTEND = "native nativesdk"
