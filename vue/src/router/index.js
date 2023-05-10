import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

let routes = [
	{
		// will match everything
		path: '*',
		component: () => import('../views/404.vue'),
	},
	{
		path: '/',
		name: 'root',
		redirect: '/sign-in',
	},
	{
		path: '/dashboard',
		name: '学习数据仪表板',
		layout: "dashboard",
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () => import(/* webpackChunkName: "dashboard" */ '../views/Dashboard.vue'),
	},
	{
		path: '/courses',
		name: '学生课程学习页',
		layout: "dashboard",
		component: () => import('../views/Courses.vue'),
	},
	{
		path: '/courses-manage',
		name: '教师课程管理页',
		layout: "dashboard",
		component: () => import('../views/CoursesManage.vue'),
	},
	{
		path: '/links',
		name: '外部学习链接页',
		layout: "dashboard",
		component: () => import('../views/Links.vue'),
	},
	{
		path: '/problems',
		name: '学生自主提问页',
		layout: "dashboard",
		component: () => import('../views/Problems.vue'),
	},
	{
		path: '/solutions',
		name: '教师统一答疑页',
		layout: "dashboard",
		component: () => import('../views/Solutions.vue'),
	},
	{
		path: '/administration',
		name: 'Administration',
		layout: "dashboard",
		component: () => import('../views/Administration.vue'),
	},
	{
		path: '/profile',
		name: '用户个人资料页',

		layout: "dashboard",
		meta: {
			layoutClass: 'layout-profile',
		},
		component: () => import('../views/Profile.vue'),
	},
	{
		path: '/sign-in',
		name: 'Sign-In',
		component: () => import('../views/Sign-In.vue'),
	},
	{
		path: '/sign-up',
		name: 'Sign-Up',
		meta: {
			layoutClass: 'layout-sign-up',
		},
		component: () => import('../views/Sign-Up.vue'),
	},
]

// Adding layout property from each route to the meta
// object so it can be accessed later.
function addLayoutToRoute( route, parentLayout = "default" )
{
	route.meta = route.meta || {} ;
	route.meta.layout = route.layout || parentLayout ;
	
	if( route.children )
	{
		route.children = route.children.map( ( childRoute ) => addLayoutToRoute( childRoute, route.meta.layout ) ) ;
	}
	return route ;
}

routes = routes.map( ( route ) => addLayoutToRoute( route ) ) ;

const router = new VueRouter({
	mode: 'hash',
	base: process.env.BASE_URL,
	routes,
	scrollBehavior (to, from, savedPosition) {
		if ( to.hash ) {
			return {
				selector: to.hash,
				behavior: 'smooth',
			}
		}
		return {
			x: 0,
			y: 0,
			behavior: 'smooth',
		}
	}
})
router.beforeEach((to, from, next) => {
	const isAuthenticated = window.sessionStorage.getItem('currentUser');
	if (to.path !== '/sign-in' && !isAuthenticated) {
		// 如果未登录且访问的不是登录页面，则跳转到登录页面
		next('/sign-in');
	} else {
		// 否则放行
		next();
	}
});

export default router
