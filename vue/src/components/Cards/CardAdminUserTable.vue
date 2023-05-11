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
								<a-descriptions :title="`[UID: ${item.id}] ${item.name}`" :column="1">
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
								<a-button type="link" size="small" v-if="item.role === 0" :disabled="true">
									<svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
										<path class="fill-muted" d="M13.5858 3.58579C14.3668 2.80474 15.6332 2.80474 16.4142 3.58579C17.1953 4.36683 17.1953 5.63316 16.4142 6.41421L15.6213 7.20711L12.7929 4.37868L13.5858 3.58579Z" fill="#111827"/>
										<path class="fill-muted" d="M11.3787 5.79289L3 14.1716V17H5.82842L14.2071 8.62132L11.3787 5.79289Z" fill="#111827"/>
									</svg>
									<span class="text-disabled">无法修改超级管理员用户的权限</span>
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
								<a-button
										type="link"
										size="small"
										:data-id="item.id"
										:data-username="item.username"
										:data-password="item.password"
										:data-role="item.role"
										:data-name="item.name"
										:data-gender="item.gender"
										:data-age="item.age"
										:data-email="item.email"
										:data-phone="item.phone"
										v-on:click="removeUser($event)"
										v-if="item.role !== 0"
								>
									<svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
										<path class="fill-danger" fill-rule="evenodd" clip-rule="evenodd" d="M9 2C8.62123 2 8.27497 2.214 8.10557 2.55279L7.38197 4H4C3.44772 4 3 4.44772 3 5C3 5.55228 3.44772 6 4 6L4 16C4 17.1046 4.89543 18 6 18H14C15.1046 18 16 17.1046 16 16V6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H12.618L11.8944 2.55279C11.725 2.214 11.3788 2 11 2H9ZM7 8C7 7.44772 7.44772 7 8 7C8.55228 7 9 7.44772 9 8V14C9 14.5523 8.55228 15 8 15C7.44772 15 7 14.5523 7 14V8ZM12 7C11.4477 7 11 7.44772 11 8V14C11 14.5523 11.4477 15 12 15C12.5523 15 13 14.5523 13 14V8C13 7.44772 12.5523 7 12 7Z" fill="#111827"/>
									</svg>
									<span class="text-danger">删除用户</span>
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
			async elevation(e) {
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
						.then(async successResponse => {
							if (successResponse.data.code === 200) {
								this.$message.success('用户提权成功！')
								await this.fetchUserTable()
							} else {
								this.$message.error('用户提权失败！')
							}
						})
						.catch(failResponse => {})
			},
			async delevation(e) {
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
						.then(async successResponse => {
							if (successResponse.data.code === 200) {
								this.$message.success('用户降权成功！')
								await this.fetchUserTable()
							} else {
								this.$message.error('用户降权失败！')
							}
						})
						.catch(failResponse => {})
			},
			async removeUser(e) {
				this.$message.info('正在删除用户，请稍候！')
				this.$axios
						.post('/remove-user', {
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
						.then(async successResponse => {
							if (successResponse.data.code === 200) {
								this.$message.success('用户已删除！')
								await this.fetchUserTable()
							} else {
								this.$message.error('删除用户失败！')
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