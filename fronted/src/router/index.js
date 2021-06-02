import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  mode: 'history',
  linkActiveClass: 'active',
  linkExactActiveClass: '',
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
        }
      ],
    },
  ],
});

export default router;