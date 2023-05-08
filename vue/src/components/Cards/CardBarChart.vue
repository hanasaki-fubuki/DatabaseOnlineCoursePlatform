<template>

	<!-- Active Users Card -->
	<a-card :bordered="false" class="dashboard-bar-chart">
		<chart-bar :height="220" :data="barChartData"></chart-bar>
		<div class="card-title">
			<h6>活跃用户量</h6>
			<p>相较于上周 <span class="text-success">+23%</span></p>
		</div>
		<div class="card-content">
			<p>*数据来自后台数据库，部分情况下可能出现微小数据差错。</p>
		</div>
		<a-row class="card-footer" type="flex" justify="center" align="top">
			<a-col :span="6">
				<h4>13,200</h4>
				<span>用户总数</span>
			</a-col>
			<a-col :span="6">
				<h4>53,000</h4>
				<span>今日点击量</span>
			</a-col>
			<a-col :span="6">
				<h4>3,200</h4>
				<span>今日用户</span>
			</a-col>
			<a-col :span="6">
				<h4>1,200</h4>
				<span>今日注册</span>
			</a-col>
		</a-row>
	</a-card>
	<!-- Active Users Card -->

</template>

<script>

	// Bar chart for "Active Users" card.
	import ChartBar from '../Charts/ChartBar' ;

	export default ({
		components: {
			ChartBar,
		},
		data() {
			return {
				// Data for bar chart.
				barChartData: {
					labels: ["01", "02", "03", "04", "05", "06", "07", "08", "09"],
					datasets: [{
						label: "Sales",
						backgroundColor: '#fff',
						borderWidth: 0,
						borderSkipped: false,
						borderRadius: 6,
						data: [850, 600, 500, 620, 900, 500, 900, 630, 900],
						maxBarThickness: 20,
					}, ],
				},
			}
		},
	})

</script>