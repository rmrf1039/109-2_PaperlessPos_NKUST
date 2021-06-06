<template>
  <div class="content-body">
    <!-- row -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-body">
              <div class="card-title-a">消費清單</div>
              <div class="table-responsive">
                <table id="receipts" class="table table-hover table-bordered zero-configuration">
                  <thead>
                    <tr>
                      <th>商店</th>
                      <th>發票號碼</th>
                      <th>發票金額</th>
                      <th>日期</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr @click="displayReceiptDetail(receipt)" v-for="receipt in receipts" :key="receipt.number">
                      <td>{{ receipt.seller_id }}</td>
                      <td>
                        <span class="badge-primar">{{ receipt.track }}-{{ receipt.number }}</span>
                      </td>
                      <td>{{ receipt.amount }}</td>
                      <td>{{ moment(receipt.created_at).format("YYYY/MM/DD HH:mm") }}</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <ReceiptDetail v-on:closeReceiptDetail="closeReceiptDetail" :backgroundMaskActive="backgroundMaskActive" :display="this.class.display" :targetedReceipt="targetedReceipt"></ReceiptDetail>
  </div>
</template>

<style src="../assets/css/dataTables.bootstrap4.min.css"></style>

<script>
import moment from 'moment'
import ReceiptDetail from '../components/receiptDetail';

//Bootstrap and jQuery libraries
import 'jquery/dist/jquery.min.js';
//Datatable Modules
import 'datatables.net-dt/js/dataTables.dataTables';
import $ from 'jquery';

export default {
  props: ['backgroundMaskActive', 'carrier'],
  components: {
    ReceiptDetail,
  },
  data() {
    return {
      class: {
        display: false,
      },
      receipts: {},
      targetedReceipt: {}
    };
  },
  created() {
    this.moment = moment;
  },
  mounted() {
    this.getReceipts();
    this.changeBackgroundMask(false);
    $('#receipts').DataTable();
  },
  updated() {
    $('#receipts').DataTable();
  },
  methods: {
    getReceipts() {
      this.$axios
        .get('http://127.0.0.1:8000/api/receipts/', {
          params: {
            carrier: this.carrier,
          },
        })
        .then((response) => {
          this.receipts = response.data.receipts;
          $('#receipts')
            .DataTable()
            .destroy();
        })
        .catch((error) => {
          console.log(error);
          $('#receipts').DataTable();
        });
    },

    displayReceiptDetail(data) {
      this.targetedReceipt = data;
      this.class.display = true;
      this.changeBackgroundMask(true);
    },

    closeReceiptDetail() {
      this.class.display = false;
      this.changeBackgroundMask(false);
    },

    changeBackgroundMask(bool) {
      this.backgroundMaskActive(bool);
    },
  },
};
</script>
