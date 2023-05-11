/*
=========================================================
Muse - Vue Ant Design Dashboard - v1.0.0
=========================================================

Product Page: https://www.creative-tim.com/product/vue-ant-design-dashboard
Copyright 2021 Creative Tim (https://www.creative-tim.com)
Coded by Creative Tim

=========================================================
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. 
*/

import Vue from 'vue'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import App from './App.vue'
import axios from "axios";
import DefaultLayout from './layouts/Default.vue'
import DashboardLayout from './layouts/Dashboard.vue'
import router from './router'
import VueAxios from 'vue-axios'
Vue.prototype.$axios = axios
Vue.use(VueAxios,axios);
axios.defaults.withCredentials = true;
// import './plugins/click-away'

import './scss/app.scss';
import CardCourseList from "@/components/Cards/CardCourseList.vue";

Vue.use(Antd);

Vue.config.productionTip = false

// Adding template layouts to the vue components.
Vue.component("layout-default", DefaultLayout);
Vue.component("layout-dashboard", DashboardLayout);
Vue.component("CardCourseList", CardCourseList);

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')