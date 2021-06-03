import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import axios from 'axios';
import print from 'vue3-print-nb'
import { VueCookieNext } from 'vue-cookie-next';

require('bootstrap');

const app = createApp(App);

app
  .use(store)
  .use(router)
  .use(VueCookieNext)
  .use(print)
  .mount('#app');

app.config.globalProperties.$axios = axios;
