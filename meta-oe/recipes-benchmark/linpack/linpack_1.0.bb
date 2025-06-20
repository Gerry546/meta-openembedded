DESCRIPTION = "LINPACK Benchmarks are a measure of a system's floating point computing power"
SUMMARY = "LINPACK is a software library for performing numerical linear algebra on digital computers"

LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/linpacknew.c;beginline=1;endline=23;md5=aa025e3bc44190c71e4c5e3b084fed87"

SRC_URI = "http://www.netlib.org/benchmark/linpackc.new;downloadfilename=linpacknew.c \
           file://0001-linpack-Define-DP-only-when-SP-is-not-defined.patch \
		   file://0001-Fix-build-error-in-gcc-15.0.1-due-to-function-redecl.patch \
          "
SRC_URI[sha256sum] = "a63f2ec86512959f1fd926bfafb85905b2d7b7402942ffae3af374d48745e97e"

S = "${UNPACKDIR}"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} -DDP -o linpack_dp linpacknew.c -lm
	${CC} ${CFLAGS} ${LDFLAGS} -DSP -o linpack_sp linpacknew.c -lm
}

do_install () {
	install -Dm 0755 linpack_dp ${D}${bindir}/linpack_dp
	install -Dm 0755 linpack_sp ${D}${bindir}/linpack_sp
}

