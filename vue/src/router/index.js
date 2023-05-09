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
		meta: {
			roles: ['admin', 'maintenance', 'user']
		},
		layout: "dashboard",
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () => import(/* webpackChunkName: "dashboard" */ '../views/Dashboard.vue'),
	},
	{
		path: '/courses',
		name: '课程学习页面',
		meta: {
			roles: ['admin', 'maintenance', 'user']
		},
		layout: "dashboard",
		component: () => import('../views/Courses.vue'),
	},
	{
		path: '/courses-manage',
		name: '教师课程管理页面',
		meta: {
			roles: ['admin', 'maintenance', 'user']
		},
		layout: "dashboard",
		component: () => import('../views/CoursesManage.vue'),
	},
	{
		path: '/links',
		name: '外部学习链接',
		meta: {
			roles: ['admin', 'maintenance', 'user']
		},
		layout: "dashboard",
		component: () => import('../views/Links.vue'),
	},
	{
		path: '/problems',
		name: '学生自主提问',
		meta: {
			roles: ['admin', 'maintenance', 'user']
		},
		layout: "dashboard",
		component: () => import('../views/Problems.vue'),
	},
	{
		path: '/administration',
		name: 'Administration',
		meta: {
			roles: ['admin', 'maintenance', 'user']
		},
		layout: "dashboard",
		component: () => import('../views/Administration.vue'),
	},
	{
		path: '/profile',
		name: '您的个人资料',

		layout: "dashboard",
		meta: {
			layoutClass: 'layout-profile',
			roles: ['admin', 'maintenance', 'user']
		},
		component: () => import('../views/Profile.vue'),
	},
	{
		path: '/sign-in',
		name: 'Sign-In',
		meta: {
			roles: ['admin', 'maintenance', 'user']
		},
		component: () => import('../views/Sign-In.vue'),
	},
	{
		path: '/sign-up',
		name: 'Sign-Up',
		meta: {
			layoutClass: 'layout-sign-up',
			roles: ['admin', 'maintenance', 'user']
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
const role = 'user'
router.beforeEach((to,from,next)=>{
	if (to.meta.roles.includes(role)) {
		next()	//放行
	} else {
		alert("很抱歉，我们无法获取您的身份信息，亦或是您没有权限访问该页面。我们将为您跳转登录页面，您可以尝试重新登录以解决该问题。")
		next({path:"/sign-in"})	//跳到登录页面
	}
})


export default router
