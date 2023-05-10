<template>

	<!-- Billing Information Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: '16px' }">
		<template #title>
			<h6 class="font-semibold m-0">用户数据表（为保护用户隐私，此处不显示年龄、性别等敏感信息，并将密码加密处理，不显示明文）</h6>
		</template>
		<template>
			<a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="userListData" :split="false">
				<a-list-item slot="renderItem" key="item.title" slot-scope="item, index">
					<a-col :span="24">
						<a-card :bordered="false" class="card-billing-info">
							<div class="col-info">
								<a-descriptions :title="`${item.name}`" :column="1">
									<a-descriptions-item label="用户名">
										{{ item.username }}
									</a-descriptions-item>
									<a-descriptions-item label="密码（已加密）">
										{{ item.password }}
									</a-descriptions-item>
									<a-descriptions-item label="用户角色">
										{{ roleMapping[item.role] }}
									</a-descriptions-item>
								</a-descriptions>
							</div>
							<div class="col-action">
								<a-button type="link"
													size="small"
													:data-id="item.id"
													:data-username="item.username"
													:data-password="item.password"
													:data-role="1"
													:data-name="item.name"
													:data-gender="item.gender"
													:data-age="item.age"
													:data-email="item.email"
													:data-phone="item.phone"
													v-on:click="elevation($event)"
													v-if="item.role !== 0"
								>
									<svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
										<path class="fill-muted" d="M13.5858 3.58579C14.3668 2.80474 15.6332 2.80474 16.4142 3.58579C17.1953 4.36683 17.1953 5.63316 16.4142 6.41421L15.6213 7.20711L12.7929 4.37868L13.5858 3.58579Z" fill="#111827"/>
										<path class="fill-muted" d="M11.3787 5.79289L3 14.1716V17H5.82842L14.2071 8.62132L11.3787 5.79289Z" fill="#111827"/>
									</svg>
									<span class="text-dark">提权为教师用户</span>
								</a-button>
								<a-button type="link"
													size="small"
													:data-id="item.id"
													:data-username="item.username"
													:data-password="item.password"
													:data-role="2"
													:data-name="item.name"
													:data-gender="item.gender"
													:data-age="item.age"
													:data-email="item.email"
													:data-phone="item.phone"
													v-on:click="delevation($event)"
													v-if="item.role !== 0"
								>
									<svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
										<path class="fill-muted" d="M13.5858 3.58579C14.3668 2.80474 15.6332 2.80474 16.4142 3.58579C17.1953 4.36683 17.1953 5.63316 16.4142 6.41421L15.6213 7.20711L12.7929 4.37868L13.5858 3.58579Z" fill="#111827"/>
										<path class="fill-muted" d="M11.3787 5.79289L3 14.1716V17H5.82842L14.2071 8.62132L11.3787 5.79289Z" fill="#111827"/>
									</svg>
									<span class="text-dark">降权为学生用户</span>
								</a-button>
							</div>
						</a-card>
					</a-col>
				</a-list-item>
			</a-list>
		</template>
	</a-card>
	<!-- / Billing Information Card -->

</template>

<script>

	export default ({
		data() {
			return {
				userListData: [],
				pagination: {
					onChange: page => {
						console.log(page);
					},
					pageSize: 5,
				},
				roleMapping: {
					0: '超级管理员/维护',
					1: '教师/课程管理员',
					2: '学生/普通用户',
				},
			}
		},
		async mounted() {
			await this.fetchUserTable();
		},
		methods: {
			elevation(e) {
				this.$message.info('正在尝试提权用户，请稍候！')
				this.$axios
						.post('/user-elevation', {
							id: e.target.getAttribute('data-id'),
							username: e.target.getAttribute('data-username'),
							password: e.target.getAttribute('data-password'),
							role: e.target.getAttribute('data-role'),
							name: e.target.getAttribute('data-name'),
							gender: e.target.getAttribute('data-gender'),
							age: e.target.getAttribute('data-age'),
							email: e.target.getAttribute('data-email'),
							phone: e.target.getAttribute('data-phone'),
						},{
							headers: {
								'Content-Type': 'application/json'
							}
						})
						.then(successResponse => {
							if (successResponse.data.code === 200) {
								this.$message.success('用户提权成功！')
								this.fetchUserTable()
							} else {
								this.$message.error('用户提权失败！')
							}
						})
						.catch(failResponse => {})
			},
			delevation(e) {
				this.$message.info('正在尝试降权用户，请稍候！')
				this.$axios
						.post('/user-delevation', {
							id: e.target.getAttribute('data-id'),
							username: e.target.getAttribute('data-username'),
							password: e.target.getAttribute('data-password'),
							role: e.target.getAttribute('data-role'),
							name: e.target.getAttribute('data-name'),
							gender: e.target.getAttribute('data-gender'),
							age: e.target.getAttribute('data-age'),
							email: e.target.getAttribute('data-email'),
							phone: e.target.getAttribute('data-phone'),
						},{
							headers: {
								'Content-Type': 'application/json'
							}
						})
						.then(successResponse => {
							if (successResponse.data.code === 200) {
								this.$message.success('用户降权成功！')
								this.fetchUserTable()
							} else {
								this.$message.error('用户降权失败！')
							}
						})
						.catch(failResponse => {})
			},
			async fetchUserTable() {
				await this.$axios
						.post('/user-table')
						.then(response => {
							this.$message.success('用户表数据读取成功！')
							this.userListData = response.data;
						})
						.catch(error => {
							this.$message.error('用户表数据读取失败！')
							console.log(error);
						});
			},
		},
	})

</script>