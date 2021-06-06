<template>
  <div class="card" id="coupon" :class="{ show: display }">
    <div class="card-body">
      <div>
        <div class="text-center">
          <img width="100" src="/assets/images/store.png" class="mr-3 rounded-circle" />
          <h2 class="card-title-c">{{ targetedCoupon.seller_id }}</h2>
          <h2>{{ targetedCoupon.title }}</h2>
          <div class="mb-0">使用期限：{{ moment(targetedCoupon.created_at).format("YYYY/MM/DD") }}~{{ moment(targetedCoupon.expired_date).format("YYYY/MM/DD") }}</div>
        </div>
      </div>
      <hr />
      <h4 class="card-title-b">注意事項</h4>
      <div class="active-member">
        <div class="table-responsive">
          <table class="table table-xs mb-0">
            <thead>
              <div class="text-center mb-0">
                <p>每家商店、每次結帳，只能使用一張折價卷。</p>
                <p>折價卷最多只能折抵該次購買總金額的30％。</p>
                <p>折價卷僅能使用一次且不找零，一經使用無法恢復。</p>
                <p>使用折價卷的訂單如取消或退貨，折價卷將自動失效且不會歸還。</p>
              </div>
            </thead>
            <hr />
          </table>
          <div class="text-center  mb-5">
            <p>兌換條碼</p>
            <img width="200" src="/assets/images/code.png" />
          </div>
          <div class="text-center">
            <input type="button" @click="$emit('closeCouponDetail')" class="btn print submit w-25" value="回上頁" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
#coupon {
  opacity: 0;
  visibility: hidden;
  transition-duration: 0.2s;
}
#coupon.show {
  opacity: 1;
  visibility: visible;
}
</style>

<script>
import moment from 'moment';

export default {
  props: ['backgroundMaskActive', 'display', 'targetedCoupon'],
  data() {
    return {};
  },
  created() {
    this.moment = moment;
  }
};
</script>
