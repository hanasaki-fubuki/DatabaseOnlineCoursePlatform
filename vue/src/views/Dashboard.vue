<!-- 
	This is the dashboard page, it uses the dashboard layout in: 
	"./layouts/Dashboard.vue" .
 -->

<template>
	<div>
		<!-- Counter Widgets -->
		<a-row :gutter="24">
			<a-col :span="24" :lg="12" :xl="6" class="mb-24" v-for="(stat, index) in stats" :key="index">
				<!-- Widget 1 Card -->
				<WidgetCounter
					:title="stat.title"
					:value="stat.value"
					:suffix="stat.suffix"
					:status="stat.status"
				></WidgetCounter>
				<!-- / Widget 1 Card -->
			</a-col>
		</a-row>
		<!-- / Counter Widgets -->

		<!-- Table & Timeline -->
		<a-row :gutter="24" type="flex" align="stretch">
			<!-- Table -->
			<a-col :span="24" :lg="16" class="mb-24">
				<CardCourseHeat></CardCourseHeat>
			</a-col>
			<a-col :span="24" :lg="8" class="mb-24">
				<CardUpdateLog></CardUpdateLog>
			</a-col>
		</a-row>
	</div>
</template>

<script>

	import WidgetCounter from '../components/Widgets/WidgetCounter' ;
	import CardCourseHeat from '../components/Cards/CardCourseHeat.vue' ;
	import CardUpdateLog from '../components/Cards/CardUpdateLog.vue' ;

	// Counter Widgets stats
	const stats = [
		{
			title: "课程总点击量",
			value: 53000,
			suffix: "次课程点击",
		},
		{
			title: "登录用户总次数",
			value: 3200,
			suffix: "次登录",
		},
		{
			title: "当前课程文件数",
			value: 1200,
			suffix: "个课程文件",
		},
		{
			title: "总用户数",
			value: 13200,
			suffix: "位用户",
		},
	] ;


	export default ({
		components: {
			WidgetCounter,
			CardCourseHeat,
			CardUpdateLog,
		},
		data() {
			return {
				// Counter Widgets Stats
				stats,
			}
		},
	})

</script>

<style lang="scss">
</style>