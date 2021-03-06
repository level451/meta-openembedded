DESCRIPTION = "\
IPC::Run allows you run and interact with child processes \
using files, pipes, and pseudo-ttys. Both system()-style and scripted \
usages are supported and may be mixed. Likewise, functional and OO API \
styles are both supported and may be mixed."
HOMEPAGE = "https://metacpan.org/release/IPC-Run"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0ebd37caf53781e8b7223e6b99b63f4e"
DEPENDS = "perl"

SRC_URI = "git://github.com/toddr/IPC-Run.git"
SRCREV = "5b990b641a73eb0bc1e2b4c19daeef390d4d797a"

S = "${WORKDIR}/git"

inherit cpan

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

do_compile() {
    export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
    cpan_do_compile
}
