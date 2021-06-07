<template>
  <div class="card" id="receipt" :class="{ show: display }">
    <div class="card-body">
      <div>
        <div class="media pt-3 pb-3">
          <img width="80" src="/assets/images/store.png" class="mr-3 rounded-circle" />
          <div class="media-body">
            <h4 class="card-title-c">{{ targetedReceipt.seller_id }}</h4>
            <h4 class="mb-0">{{ targetedReceipt.track }}-{{ targetedReceipt.number }}</h4>
            <div class="mb-0">{{ moment(targetedReceipt.created_at).format('YYYY/MM/DD HH:mm') }}</div>
            <div class="mb-0" v-if="targetedReceipt.uniform_num != null">統編：{{ targetedReceipt.uniform_num }}</div>
          </div>
          <div>
            <p class="text-right">110年5-6月</p>
            <p style="margin-left: 1rem;">
              <qrcode-vue :value="targetedReceipt.track + targetedReceipt.number"></qrcode-vue>
              </p>
          </div>
        </div>
      </div>
      <hr />
      <h4 class="card-title-b text-left">消費明細</h4>
      <div class="active-member">
        <div class="table-responsive">
          <table class="table table-xs mb-0">
            <thead>
              <tr>
                <th>品名</th>
                <th class="text-center">數量</th>
                <th class="text-right">小計</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in targetedReceipt.detail" :key="item.name">
                <td>{{ item.name }}</td>
                <td class="text-center">x{{ item.quantity }}</td>
                <td class="text-right">{{ item.unit_price }}</td>
              </tr>
            </tbody>
            <tbody>
              <tr>
                <td></td>
                <td></td>
                <td class="text-right"><span>合計 </span>{{ targetedReceipt.amount }}<span> 元</span></td>
              </tr>
            </tbody>
          </table>
          <div class="text-center">
            <input @click="$emit('closeReceiptDetail')" class="btn print submit w-25" value="關閉" style="background: linear-gradient(230deg, #565251, #959796); margin-right: 15px" />
            <input v-print="'#receipt'" type="submit" class="btn print submit w-25" value="列印" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
#receipt {
  opacity: 0;
  visibility: hidden;
  transition-duration: 0.2s;
}
#receipt.show {
  opacity: 1;
  visibility: visible;
}
</style>

<script>
import QrcodeVue from 'qrcode.vue'
import moment from 'moment';

export default {
  props: ['backgroundMaskActive', 'display', 'targetedReceipt'],
  components: {
    QrcodeVue
  },
  data() {
    return {};
  },
  created() {
    this.moment = moment;
  }
};
</script>
