<template>
  <div class="content-body">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-3" v-for="coupon in coupons" :key="coupon.uuid">
          <div class="card">
            <div class="card-body">
              <div class="text-center">
                <img alt="" width="100" class="rounded-circle mt-4" src="/assets/images/store.png" />
                <h3 class="mt-3">{{ coupon.sell_id }}</h3>
                <h4>{{ coupon.title }}</h4>
                <a @click="displayCouponDetail(coupon)" class="btn gradient-9 btn-lg border-0 btn-rounded px-5">使用</a>
                <div class="text-center mt-4">
                  <h5>活動期間</h5>
                  <span>{{ moment(coupon.created_at).format("YYYY/MM/DD") }}~{{ moment(coupon.expired_date).format("YYYY/MM/DD") }}</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <CouponDetail v-on:closeCouponDetail="closeCouponDetail" :backgroundMaskActive="backgroundMaskActive" :display="this.class.display" :targetedCoupon="targetedCoupon"></CouponDetail>
  </div>
</template>

<script>
import moment from 'moment'
import CouponDetail from '../components/couponDetail';

export default {
  props: ['backgroundMaskActive', 'carrier'],
  components: {
    CouponDetail,
  },
  data() {
    return {
      class: {
        display: false,
      },
      coupons: {},
      targetedCoupon: {},
    };
  },
  created() {
    this.moment = moment;
  },
  mounted() {
    this.getCoupons();
  },
  methods: {
    getCoupons() {
      this.$axios
        .get('http://127.0.0.1:8000/api/coupons/', {
          params: {
            carrier: this.carrier,
          },
        })
        .then((response) => {
          this.coupons = response.data.coupons;
        })
        .catch((error) => {
          console.log(error);
        });
    },

    displayCouponDetail(data) {
      this.targetedCoupon = data;
      this.class.display = true;
      this.changeBackgroundMask(true);
    },

    closeCouponDetail() {
      this.class.display = false;
      this.changeBackgroundMask(false);
    },

    changeBackgroundMask(bool) {
      this.backgroundMaskActive(bool);
    },
  },
};
</script>
