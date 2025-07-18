SUMMARY = "Menu for quick access to folders, documents and removable media"
DESCRIPTION = "Panel plugin displaying menu with quick access to folders, documents and removable media"
HOMEPAGE = "https://docs.xfce.org/panel-plugins/xfce4-places-plugin/start"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b6952d9a47fc2ad0f315510e1290455f"

inherit xfce-panel-plugin

SRC_URI[sha256sum] = "ba766a5d31580fad043fbd1fd66b811cbda706229473d24a734a590d49ef710e"

PACKAGECONFIG ??= "notify"
PACKAGECONFIG[notify] = "--enable-notifications,--disable-notifications,libnotify"
