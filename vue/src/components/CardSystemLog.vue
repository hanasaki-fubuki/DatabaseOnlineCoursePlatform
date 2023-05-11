<template>

	<!-- Invoices Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: '16px' }">
		<template #title>
			<h6 class="font-semibold m-0">系统日志</h6>
		</template>
		<div class="demo-infinite-container">
			<a-list item-layout="horizontal" :split="false" :data-source="logData">
				<a-list-item slot="renderItem" slot-scope="item">
					<a-button
							slot="actions"
							type="link"
							:data-id="item.id"
							v-on:click="removeLog($event)"
					>
						<svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
							<path class="fill-danger" fill-rule="evenodd" clip-rule="evenodd" d="M9 2C8.62123 2 8.27497 2.214 8.10557 2.55279L7.38197 4H4C3.44772 4 3 4.44772 3 5C3 5.55228 3.44772 6 4 6L4 16C4 17.1046 4.89543 18 6 18H14C15.1046 18 16 17.1046 16 16V6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H12.618L11.8944 2.55279C11.725 2.214 11.3788 2 11 2H9ZM7 8C7 7.44772 7.44772 7 8 7C8.55228 7 9 7.44772 9 8V14C9 14.5523 8.55228 15 8 15C7.44772 15 7 14.5523 7 14V8ZM12 7C11.4477 7 11 7.44772 11 8V14C11 14.5523 11.4477 15 12 15C12.5523 15 13 14.5523 13 14V8C13 7.44772 12.5523 7 12 7Z" fill="#111827"/>
						</svg>
						<span class="text-danger">删除记录</span>
					</a-button>
					<a-list-item-meta
							:title="item.event"
							:description="item.logTime"
					></a-list-item-meta>
					<div>UID: {{ item.uid }}</div>
				</a-list-item>
			</a-list>
		</div>

	</a-card>
	<!-- / Invoices Card -->

</template>

<script>

	export default ({
		data() {
			return {
				logData:[],
			}
		},
		async mounted() {
			await this.fetchLogs();
		},
		methods: {
			async removeLog(e) {
				this.$axios
						.post('/remove-log', {
							id: e.target.getAttribute('data-id'),
						},{
							headers: {
								'Content-Type': 'application/json'
							}
						})
						.then(async successResponse => {
							if (successResponse.data.code === 200) {
								this.$message.success('日志条目已删除！')
								await this.fetchLogs()
							} else {
								this.$message.error('删除条目失败！')
							}
						})
						.catch(failResponse => {})
			},
			async fetchLogs() {
				await this.$axios
						.post('/system-log')
						.then(response => {
							this.$message.success('系统日志数据读取成功！')
							this.logData = response.data;
						})
						.catch(error => {
							this.$message.error('系统日志数据读取失败！')
							console.log(error);
						});
			}
		},
	})

</script>
<style>
.demo-infinite-container {
	border: 1px solid #e8e8e8;
	border-radius: 4px;
	overflow: auto;
	padding: 8px 24px;
	height: 1242px;
}
</style>