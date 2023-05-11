<template>

	<!-- Settings Drawer -->
	<a-drawer
		class="settings-drawer"
		:closable="false"
		:visible="showSettingsDrawer"
		width="360"
		:getContainer="() => wrapper"
		@close="$emit('toggleSettingsDrawer', false)"
	>

		<!-- Settings Drawer Close Button -->
		<a-button type="link" class="btn-close" @click="$emit('toggleSettingsDrawer', false)">
			<svg xmlns="http://www.w3.org/2000/svg" width="9" height="9" viewBox="0 0 9 9">
				<g id="close" transform="translate(0.75 0.75)">
					<path id="Path" d="M7.5,0,0,7.5" fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
					<path id="Path-2" data-name="Path" d="M0,0,7.5,7.5" fill="none" stroke="#000" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
				</g>
			</svg>
		</a-button>
		<!-- / Settings Drawer Close Button -->
		
		<!-- Settings Drawer Content -->
		<div class="drawer-content">
			<h6>全局视觉设置</h6>
			<p>可以在这里让页面变得更好看哦！</p>
			<hr>
			<div class="sidebar-color">
				<h6>左侧导航栏颜色</h6>
				<a-radio-group v-model="sidebarColorModel" @change="$emit('updateSidebarColor', $event.target.value)" defaultValue="primary">
					<a-radio-button value="primary" class="bg-primary"></a-radio-button>
					<a-radio-button value="secondary" class="bg-secondary"></a-radio-button>
					<a-radio-button value="success" class="bg-success"></a-radio-button>
					<a-radio-button value="danger" class="bg-danger"></a-radio-button>
					<a-radio-button value="warning" class="bg-warning"></a-radio-button>
					<a-radio-button value="black" class="bg-dark"></a-radio-button>
				</a-radio-group>
			</div>
			<div class="sidenav-type">
				<h6>侧边导航栏样式</h6>
				<p>两种左侧导航栏样式任选其一</p>
				<a-radio-group button-style="solid" v-model="sidebarThemeModel" @change="$emit('updateSidebarTheme', $event.target.value)" defaultValue="primary">
					<a-radio-button value="light">透明亚克力</a-radio-button>
					<a-radio-button value="white">纯白</a-radio-button>
				</a-radio-group>
			</div>
			<div class="navbar-fixed">
				<h6>固定顶部标题导航栏</h6>
				<a-switch default-checked @change="$emit('toggleNavbarPosition', navbarFixedModel)"/>
			</div>
			<div class="download">
        <router-link to="/sign-in">
          <a-button type="primary" block target="_blank">注销当前登录用户</a-button>
        </router-link>
				<a-button type="secondary" href="mailto:support@microdream.tech" block target="_blank">邮箱联系我们</a-button>
			</div>
			<div class="github-stars">
				<gh-btns-star slug="hanasaki-fubuki/DatabaseOnlineCoursePlatform" show-count></gh-btns-star>
			</div>
			<div class="sharing">
				<h6>如果您觉得不错，记得分享学习平台哦！</h6>
			</div>
		</div>
		<!-- / Settings Drawer Content -->

	</a-drawer>
	<!-- / Settings Drawer -->

</template>

<script>
	import 'vue-github-buttons/dist/vue-github-buttons.css'; // Stylesheet
	import VueGitHubButtons from 'vue-github-buttons';
	import Vue from 'vue';
	Vue.use(VueGitHubButtons, { useCache: true });

	export default ({
		props: {
			// Settings drawer visiblility status.
			showSettingsDrawer: {
				type: Boolean,
				default: false,
			},
			
			// Main sidebar color.
			sidebarColor: {
				type: String,
				default: "primary",
			},
			
			// Main sidebar theme : light, white, dark.
			sidebarTheme: {
				type: String,
				default: "light",
			},

			// Header fixed status.
			navbarFixed: {
				type: Boolean,
				default: true,
			},

		},
		data() {
			return {
				// The wrapper element to attach dropdowns to.
				wrapper: document.body,
				
				// Main sidebar color.
				sidebarColorModel: this.sidebarColor,
				
				// Main sidebar theme : light, white, dark.
				sidebarThemeModel: this.sidebarTheme,

				// Header fixed status.
				navbarFixedModel: this.navbarFixed,
			}
		},
		mounted: function(){
			// Set the wrapper to the proper element, layout wrapper.
			this.wrapper = document.getElementById('layout-dashboard') ;
			this.toggleNavbarPosition();
		},
		methods: {
			toggleNavbarPosition() {
				this.$emit('toggleNavbarPosition', true);
			}
		},
	})

</script>
