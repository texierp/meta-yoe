# Yoe QT5/Wayland sample image
require yoe-simple-image.bb

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require qt5.inc

REQUIRED_DISTRO_FEATURES = "wayland"

IMAGE_FEATURES += "splash"

CORE_IMAGE_BASE_INSTALL += " \
  weston weston-init \
  weston-examples \
  ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland', '', d)} \
  ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland-plugins', '', d)} \
  ${QT5APPS} \
  ${QT5BASE} \
"
export IMAGE_BASENAME = "yoe-qt5-wayland-image"
