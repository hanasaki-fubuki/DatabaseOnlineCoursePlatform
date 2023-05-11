<template>
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{padding: 0,}">
		<template #title>
			<a-row type="flex" align="middle">
				<a-col :span="24" :md="12">
					<h6>课程章节热度</h6>
				</a-col>
			</a-row>
		</template>
		<div class="demo-infinite-container">
			<a-table :columns="columns" :data-source="courseHeatList" :pagination="false">
				<template slot="chapter" slot-scope="text, record">
					<h6 class="m-0">
						<img src="images/logos/logo-jira.svg" width="25" class="mr-10">
						{{ record.chapterName }}
					</h6>
				</template>
				<template slot="heat" slot-scope="text, record">
					<span class="font-bold text-muted text-sm">{{ record.heatLabel ? record.heatLabel : record }}</span>
					<a-progress :percent="record.heatValue ? record.heatValue : record" :show-info="false" size="small" :status="record.heatStatus ? record.heatStatus : 'normal'" />
				</template>
			</a-table>
		</div>
	</a-card>
</template>

<script>
	export default ({
		props: {
			columns: {
				type: Array,
				default: () => [
					{
						title: '章节名',
						dataIndex: 'chapter',
						scopedSlots: { customRender: 'chapter' },
						width: 300,
					},
					{
						title: '章节热度',
						scopedSlots: { customRender: 'heat' },
						dataIndex: 'heat',
					},
				],
			},
		},
		data() {
			return {
				courseHeatList: [],
			}
		},
		methods: {
			async fetchData() {
				await this.$axios
						.post('/course-heat')
						.then(response => {
							this.courseHeatList = response.data;
							console.log(response.data);
						})
						.catch(error => {
							console.log(error);
						});
			},
		},
		async mounted() {
			await this.fetchData();
		}
	})
</script>

<style>
.demo-infinite-container {
	border: 1px solid #e8e8e8;
	border-radius: 4px;
	overflow: auto;
	padding: 8px 24px;
	height: 495px;
}
</style>