<template>
  <!--Main wrapper-->
  <div id="main-wrapper">
    <!--Nav header-->
    <div class="nav-header">
      <div class="brand-logo">
        <a href="index.html">
          <b class="logo-abbr"><img src="/assets/images//logo1.png" alt="" /> </b>
          <span class="logo-compact"><img src="/assets/images//logo2.png" alt=""/></span>
          <span class="brand-title">
            <img src="/assets/images//logo2.png" alt="" />
          </span>
        </a>
      </div>
    </div>

    <!--Header-->
    <div class="header">
      <div class="header-content clearfix">
        <div class="nav-control">
          <div class="hamburger">
            <span class="toggle-icon"><i class="icon-menu"></i></span>
          </div>
        </div>
        <div class="header-left">
          <div class="input-group icons"></div>
        </div>
        <div class="header-right">
          <ul class="clearfix">
            <li class="icons dropdown">
              <div class="user-img c-pointer position-relative" data-toggle="dropdown">
                <img src="/assets/images//user/01.png" height="40" width="40" alt="" />
              </div>
              <div class="drop-down dropdown-profile animated fadeIn dropdown-menu">
                <div class="dropdown-content-body">
                  <ul>
                    <li>
                      <a href="index.html"><i class="ti-export"></i> <span>登出</span></a>
                    </li>
                  </ul>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <!--Sidebar-->
    <div class="nk-sidebar">
      <div class="nk-nav-scroll">
        <ul class="metismenu" id="menu">
          <li>
            <a href="receipt.html" aria-expanded="false"> <i class="ti-receipt menu-icon"></i><span class="nav-text">消費清單</span> </a>
          </li>
          <li>
            <a href="coupon.html" aria-expanded="false"> <i class="icon-tag menu-icon"></i><span class="nav-text">優惠卷</span> </a>
          </li>
          <li>
            <a href="user_barcode.html" aria-expanded="false"> <i class="ti-layout-column4-alt menu-icon"></i><span class="nav-text">條碼</span> </a>
          </li>
          <li>
            <a href="index.html" aria-expanded="false"> <i class="ti-export menu-icon"></i><span class="nav-text">登出</span> </a>
          </li>
        </ul>
      </div>
    </div>

    <!--Content body-->
    <router-view />
  </div>

  
</template>

<style lang="scss">
@import '@/assets/scss/app.scss';
</style>

<script>
export default {
  data() {
    return {};
  },
};
</script>
