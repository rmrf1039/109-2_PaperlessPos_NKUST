<template>
  <!--Main wrapper-->
  <div id="main-wrapper" class="show" :class="{ 'menu-toggle': this.class.menu }">
    <!--Nav header-->
    <div class="nav-header">
      <div class="brand-logo">
        <a href="index.html">
          <b class="logo-abbr"><img src="/assets/images//logo1.png" alt="" /> </b>
          <span class="logo-compact"><img src="/assets/images/logo2.png" alt=""/></span>
          <span class="brand-title">
            <img src="/assets/images//logo2.png" alt="" />
          </span>
        </a>
      </div>
    </div>

    <!--Header-->
    <div class="header">
      <div class="header-content clearfix">
        <div class="nav-control" @click="menuBehavior">
          <div class="hamburger" :class="{ 'is-active': this.class.menu }">
            <span class="toggle-icon"><i class="icon-menu"></i></span>
          </div>
        </div>
        <div class="header-left">
          <div class="input-group icons"></div>
        </div>
      </div>
    </div>

    <!--Sidebar-->
    <div class="nk-sidebar">
      <div class="nk-nav-scroll">
        <ul class="metismenu" id="menu">
          <li>
            <router-link to="/" aria-expanded="false"> <i class="ti-receipt menu-icon"></i><span class="nav-text">消費清單</span></router-link>
          </li>
          <li>
            <router-link to="/coupons" aria-expanded="false"><i class="icon-tag menu-icon"></i><span class="nav-text">優惠卷</span></router-link>
          </li>
          <li>
            <router-link to="/barcode" aria-expanded="false"><i class="ti-layout-column4-alt menu-icon"></i><span class="nav-text">條碼</span></router-link>
          </li>
          <li>
            <a aria-expanded="false"><i class="ti-export menu-icon"></i><span class="nav-text">登出</span></a>
          </li>
        </ul>
      </div>
    </div>

    <!--Content body-->
    <router-view :backgroundMaskActive="changeBackgroundMask" :carrier="carrier"/>
  </div>

  <div id="background-cover" class="frosted-background" :class="{ backgroundMaskActive: backgroundMaskActive }"></div>
</template>

<style lang="scss">
@import '@/assets/scss/app.scss';

.frosted-background {
  -webkit-backdrop-filter: saturate(180%) blur(20px);
  backdrop-filter: saturate(180%) blur(20px);
  background-color: rgba(255, 255, 255, 0.77);

  transition: background-color 0.5s cubic-bezier(0.28, 0.11, 0.32, 1);
  -webkit-transition-property: background-color, -webkit-backdrop-filter;
  transition-property: background-color, -webkit-backdrop-filter;
  transition-property: background-color, backdrop-filter;
  transition-property: background-color, backdrop-filter, -webkit-backdrop-filter;
}

#background-cover {
  background-color: rgba(#000, 0.7);
  position: absolute;
  z-index: 91;
  height: 100vh;
  width: 100vw;
  top: 0;
  opacity: 0;
  visibility: hidden;
  transition-duration: 0.2s;
}
.backgroundMaskActive {
  visibility: visible !important;
  opacity: 1 !important;
}
</style>

<script>
export default {
  data() {
    return {
      backgroundMaskActive: false,
      class: {
        menu: false,
      },
      carrier: ''
    };
  },
  methods: {
    menuBehavior() {
      this.class.menu = this.class.menu ? false : true;
    },
    changeBackgroundMask(request) {
      this.backgroundMaskActive = request;
    },
  },
  created() {
    if (this.$cookie.getCookie("carrier") == null) {
      this.$cookie.setCookie("carrier", "/1ZXCASD")
    }

    this.carrier = this.$cookie.getCookie("carrier");
  },
};
</script>
