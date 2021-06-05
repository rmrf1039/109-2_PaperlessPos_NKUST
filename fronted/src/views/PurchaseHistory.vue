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
                    <tr v-for="receipt in receipts" :key="receipt.number">
                      <td>{{ receipt.seller_id }}</td>
                      <td><span class="badge-primar">{{ receipt.number }}</span></td>
                      <td>{{ receipt.amount }}</td>
                      <td>{{ receipt.created_at }}</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style src="../assets/css/dataTables.bootstrap4.min.css"></style>

<script>
//Bootstrap and jQuery libraries
import 'jquery/dist/jquery.min.js';
//Datatable Modules
import 'datatables.net-dt/js/dataTables.dataTables';
import $ from 'jquery';

export default {
  props: ['backgroundMaskActive', 'carrier'],
  data() {
    return {
      class: {},
      receipts: {}
    };
  },
  mounted() {
    this.getReceipts();
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
          $('#receipts').DataTable().destroy();
        })
        .catch((error) => {
          console.log(error);
        });
    },

    changeBackgroundMask(bool) {
      this.backgroundMaskActive(bool);
    },
  },
};
</script>
