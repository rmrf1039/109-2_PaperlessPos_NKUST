import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  mode: 'history',
  linkActiveClass: '',
  linkExactActiveClass: 'active',
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'base',
      component: () => import('../views/Base'),
      children: [
        {
          path: '',
          component: () => import('../views/PurchaseHistory'),
        },
        {
          path: '/coupons',
          component: () => import('../views/Coupons'),
        },
        {
          path: '/barcode',
          component: () => import('../views/Barcode'),
        },
      ],
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/Login'),
    },
  ],
});

export default router;
