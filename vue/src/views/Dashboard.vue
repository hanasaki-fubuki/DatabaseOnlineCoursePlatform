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

	export default ({
		components: {
			WidgetCounter,
			CardCourseHeat,
			CardUpdateLog,
		},
		data() {
			return {
				stats: [],
			}
		},
		methods: {
			async fetchData() {
				await this.$axios
						.post('/dashboard-counter')
						.then(response => {
							this.stats = response.data;
						})
						.catch(error => {
							console.log(error);
						});
			},
		},
		async mounted() {
			await this.fetchData();
		},
	})

</script>

<style lang="scss">
</style>