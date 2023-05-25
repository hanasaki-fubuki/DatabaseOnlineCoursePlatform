<template>
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: 0 }">
		<template #title>
			<a-row type="flex">
				<a-col :span="24" :md="12">
					<h5 class="font-semibold m-0">学生提问列表</h5>
				</a-col>
			</a-row>
		</template>
		<li>
			<a-descriptions title="" :column="1">
				<a-descriptions-item label="当前已登录教师用户名">
					{{ userInfo.username }}
				</a-descriptions-item>
			</a-descriptions>
		</li>
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
					<p>该提问条目唯一识别码：{{ item.id }}</p>
					<p>该提问条目所属学生唯一识别码：{{ item.uid }}</p>
					<template v-if="item.solution">
						<p>答案：{{ item.solution }}</p>
					</template>
					<template v-else>
						<a-textarea :placeholder="'请输入对[' + item.subject + ']的回答'" />
						<a-button type="primary" class="btn-edit"
											:data-id="item.id"
											:data-uid="item.uid"
											:data-subject="item.subject"
											:data-chapter="item.chapter"
											:data-submitTime="item.submitTime"
											:data-content="item.content"
											:data-solution="item.solution"
											v-on:click="solve($event)"
						>
							确认答疑
						</a-button>
					</template>
				</a-list-item>
			</a-list>
		</template>
	</a-card>

</template>

<script>
import form from "ant-design-vue/es/form";

export default ({
	computed: {
		form() {
			return form
		}
	},
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
				pageSize: 4,
			},
		};
	},
	async mounted() {
		const userStr = sessionStorage.getItem("currentUser");
		if (userStr) {
			this.userInfo = JSON.parse(userStr);
		}
		this.$message.info('正在获取学生提问列表，请稍等...');
		await this.fetchData();
	},
	methods: {
		solve(e) {
			this.$message.info('正在尝试提交答疑信息，请稍候！')
			this.$axios
					.post('/solve-problem', {
						id: e.target.getAttribute('data-id'),
						uid: e.target.getAttribute('data-uid'),
						subject: e.target.getAttribute('data-subject'),
						chapter: e.target.getAttribute('data-chapter'),
						submitTime: e.target.getAttribute('data-submitTime'),
						content: e.target.getAttribute('data-content'),
						solution: e.target.previousElementSibling.value
					},{
						headers: {
							'Content-Type': 'application/json'
						}
					})
					.then(successResponse => {
						if (successResponse.data.code === 200) {
							this.$message.success('答疑信息已提交！')
							location.reload()
						} else {
							this.$message.error('很抱歉，出于未知原因，答疑信息提交失败。请尝试联系系统管理员。')
						}
					})
					.catch(failResponse => {})
		},
		async fetchData() {
			await this.$axios
					.post('/problem-list')
					.then(response => {
						this.$message.success('获取学生提问列表成功！')
						this.listData = response.data;
					})
					.catch(error => {
						this.$message.error('获取学生提问列表失败！')
						console.log(error);
					});
		},
	},
})
</script>
<style></style>