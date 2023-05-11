<template>

	<!-- Payment Methods Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0,}">
		<template #title>
			<a-row type="flex" align="middle">
				<h6 class="font-semibold m-0">系统超级管理员用户状态</h6>
			</a-row>
		</template>
		<a-row :gutter="[24, 24]">
			<a-col :span="24" :md="12">
				<a-card class="payment-method-card" style="height: 60px">
					<img src="images/superuser.jpg" alt="">
					<h6>当前超级管理员：Hanasaki Fubuki</h6>
				</a-card>
			</a-col>
			<a-col :span="24" :md="12">
				<a-card class="payment-method-card" style="height: 60px">
					<h6>用户状态：正常，未发现安全问题</h6>
				</a-card>
			</a-col>
		</a-row>
	</a-card>
	<!-- Payment Methods Card -->

</template>

<script>

	export default ({
		data() {
			return {
			}
		},
	})

</script>