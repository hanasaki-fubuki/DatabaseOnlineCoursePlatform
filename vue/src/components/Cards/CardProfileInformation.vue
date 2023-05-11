<template>

	<!-- Profile Information Card -->
	<a-card :bordered="false" class="header-solid h-full card-profile-information" :bodyStyle="{paddingTop: 0, paddingBottom: '16px' }" :headStyle="{paddingRight: 0,}">
		<template #title>
			<h6 class="font-semibold m-0">用户基本信息</h6>
		</template>
		<p class="text-dark">
			本栏显示用户基本信息，包括昵称、手机号码、邮箱、位置等。您可以再次查看您的基本信息。
		</p>
		<hr class="my-25">
		<a-descriptions title="个人信息" :column="1">
			<a-descriptions-item label="昵称">
				{{ userInfo.name }}
			</a-descriptions-item>
			<a-descriptions-item label="性别">
				{{ genderMapping[userInfo.gender] }}
			</a-descriptions-item>
			<a-descriptions-item label="年龄">
				{{ userInfo.age }}
			</a-descriptions-item>
			<a-descriptions-item label="手机号码">
				{{ userInfo.phone }}
			</a-descriptions-item>
			<a-descriptions-item label="邮箱">
				{{ userInfo.email }}
			</a-descriptions-item>
			<a-descriptions-item label="位置">
				中国大陆
			</a-descriptions-item>
		</a-descriptions>
	</a-card>
	<!-- / Profile Information Card -->

</template>

<script>

	export default ({
		data() {
			return {
				userInfo: {},
				genderMapping: {
					0: '女',
					1: '男',
				},
			}
		},
		created() {
			const userStr = sessionStorage.getItem("currentUser");
			if (userStr) {
				this.userInfo = JSON.parse(userStr);
			}
		},
	})

</script>