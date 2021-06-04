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
                    <tr onclick="document.location='receipt_detail.html'">
                      <td>全家便利商店股份有限公司</td>
                      <td><span class="badge-primar">NG12345678</span></td>
                      <td>199</td>
                      <td>110/05/13</td>
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

<script>
//Bootstrap and jQuery libraries
import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min.js';
//Datatable Modules
import "datatables.net-dt/js/dataTables.dataTables"
import $ from 'jquery';

export default {
  props: ['backgroundMaskActive'],
  data() {
    return {
      class: {},
    };
  },
  methods: {
    changeBackgroundMask(bool) {
      this.backgroundMaskActive(bool);
    },

    getReceipts() {
      this.$axios
        .get('http://127.0.0.1:8000/api/receipts/' + 'X6zv6Ll5Ox')
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {
    $('#receipts').DataTable();
  },
};
</script>

<!--<style scoped src="../assets/css/dataTables.bootstrap4.min.css"></style>-->
