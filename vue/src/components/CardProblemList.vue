<template>
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: 0 }">
		<template #title>
			<a-row type="flex">
				<a-col :span="24" :md="12">
					<h5 class="font-semibold m-0">您的提问列表</h5>
				</a-col>
			</a-row>
		</template>
		<template>
			<a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="listData">
				<a-list-item slot="renderItem" key="item.title" slot-scope="item, index">
					<a-list-item-meta>
						<template slot="description">
							问题所属章节：{{ chapterText[item.chapter - 1] }}
						</template>
						<a slot="title" :href="item.href">{{ item.subject }}</a>
					</a-list-item-meta>
					<p>提问时间：{{ item.submitTime }}</p>
					<p>问题描述：{{ item.content }}</p>
					<p>教师给出的解决方案：{{ item.solution }}</p>
				</a-list-item>
			</a-list>
		</template>
	</a-card>

</template>

<script>

export default {
	data() {
		return {
			chapterText: [
				'1 - 数据库三级模式结构与ER图',
				'2 - 关系的性质及约束、关系模型与关系代数',
				'3 - SQL语言基础语法概述及实践',
				'4 - 游标、存储过程与函数',
				'5 - 数据库的完整性、参照关系、与参照关系相关的主键与外键以及触发器',
				'6 - 关系数据理论基本概念与范式分析',
				'7 - 数据库的安全性与完整性（备份、恢复、日志与检查点）',
				'8 - 活锁、死锁与并发控制、封锁粒度'
			],
			listData: [],
			userInfo: {},
			pagination: {
				onChange: page => {
					console.log(page);
				},
				pageSize: 3,
			},
		};
	},
	mounted() {
		const userStr = sessionStorage.getItem("currentUser");
		if (userStr) {
			this.userInfo = JSON.parse(userStr);
		}
		this.fetchData();
	},
	methods: {
		fetchData() {
			console.log(this.userInfo.id)
			const formData = new FormData();
			formData.append('uid', this.userInfo.id);
			this.$axios
					.post('/user-problem-list', formData, {
						headers: {
							'Content-Type': 'multipart/form-data',
						},})
					.then(response => {
						this.listData = response.data;
					})
					.catch(error => {
						console.log(error);
					});
		},
	},
};
</script>
<style></style>