SUMMARY = "Mixed sync-async queue to interoperate between asyncio tasks and classic threads"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=23878c357ebb4c8ce1109be365043349"

SRC_URI[sha256sum] = "0634df8b2b31f8afda4311abcf7fea912686fef717d13769eeaa01ae08d2b84c"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-asyncio \
    python3-threading \
"

BBCLASSEXTEND = "native nativesdk"
