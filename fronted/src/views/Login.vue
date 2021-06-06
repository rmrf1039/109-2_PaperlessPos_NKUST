<template>
  <div id="main-wrapper">
    <div class="login-form-bg h-100">
      <div class="container h-100">
        <div class="row justify-content-center h-100">
          <div class="col-xl-6">
            <div class="form-input-content">
              <div class="card login-form mb-0">
                <div class="card-body pt-5">
                  <a class="text-center"> <h1>登入</h1></a>

                  <form class="mt-5 mb-5 login-input" action="receipt.html">
                    <div class="form-group">
                      <label for="mobile">手機號碼</label>
                      <input type="mobile" class="form-control" v-model="inputs.phone" />
                    </div>
                    <div class="form-group">
                      <label for="mobile">驗證碼(密碼)</label>
                      <input type="password" class="form-control" v-model="inputs.password" />
                    </div>
                    <input type="submit" class="btn login-form__btn submit w-100" value="Sign In" @click.prevent="submit" />
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss">
@import '@/assets/scss/app.scss';
</style>

<script>
export default {
  data() {
    return {
      inputs: {
        phone: '',
        password: '',
      },
    };
  },
  methods: {
    submit() {
      this.$axios
        .post('http://127.0.0.1:8000/api/login', {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
          },
        })
        .then((response) => {
          this.latest_news = response.data.latest_news;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
