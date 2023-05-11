<!-- 
	This is the user profile page, it uses the dashboard layout in: 
	"./layouts/Dashboard.vue" .
 -->

<template>
	<div>

		<!-- Header Background Image -->
		<div class="profile-nav-bg" style="background-image: url('images/bg-profile.jpg')"></div>
		<!-- / Header Background Image -->

		<!-- User Profile Card -->
		<a-card :bordered="false" class="card-profile-head" :bodyStyle="{padding: 0,}">
			<template #title>
				<a-row type="flex" align="middle">
					<a-col :span="24" :md="12" class="col-info">
						<a-avatar :size="74" shape="square" src="images/face-1.jpg" />
						<div class="avatar-info">
							<h4 class="font-semibold m-0">{{ userInfo.name }}</h4>
							<p>用户角色：{{ roleMapping[userInfo.role] }}</p>
						</div>
					</a-col>
				</a-row>
			</template>
		</a-card>
		<!-- User Profile Card -->

		<a-row type="flex" :gutter="24">
			<a-col :span="24" :md="12" class="mb-24">
				<CardProfileInformation></CardProfileInformation>
			</a-col>
			<a-col :span="24" :md="12" class="mb-24">
				<CardChangePassword></CardChangePassword>
			</a-col>
		</a-row>
	</div>
</template>

<script>

	import CardChangePassword from "../components/Cards/CardChangePassword.vue"
	import CardProfileInformation from "../components/Cards/CardProfileInformation.vue"

	export default ({
		components: {
			CardChangePassword,
			CardProfileInformation,
		},
		async fetchData() {
			const username = window.sessionStorage.getItem('username')
		},
		data() {
			return {
				userInfo: {},
				roleMapping: {
					0: '超级管理员/维护',
					1: '教师/课程管理员',
					2: '学生/普通用户',
				},
			}
		},
		created() {
			const userStr = sessionStorage.getItem("currentUser");
			if (userStr) {
				this.userInfo = JSON.parse(userStr);
			}
		},
		async mounted() {

		}
	})

</script>

<style lang="scss">
</style>