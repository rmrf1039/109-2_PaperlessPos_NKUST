<template>
  <div class="content-body">
    <div class="container-fluid mt-3">
      <div class="row">
        <div class="col-lg-12">
          <div class="card card-widget">
            <div class="card-body">
              <div class="text-center">
                <h2 class="card-title-c">電子載具</h2>
                <hr />
                <div class="mb-4">結帳時請出示給店員掃描</div>
                <img class="mb-4" width="200" src="/assets/images/code.png" />
                <div class="mb-3">手機條碼：/-Q7A123</div>
              </div>
              <div class="text-center">
                <input type="button" onclick="javascript:history.go(-1);" class="btn print submit w-25" value="回上頁" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      
    }
  }, methods: {
    
  },
}
</script>
