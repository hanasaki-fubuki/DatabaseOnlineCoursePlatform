<template>

	<!-- Salary Card -->
	<a-card :bordered="false" class="widget-2 h-full">
		<a-statistic :value="value">
			<template #title>
				<div class="icon" v-html="icon"></div>
				<h6>{{ title }}</h6>
				<p>{{ content }}</p>
			</template>
		</a-statistic>
	</a-card>
	<!-- / Salary Card -->

</template>

<script>

	export default ({
		props: {
			value: {
				type: String,
				default: 0,
			},
			icon: {
				type: String,
				default: "",
			},
			title: {
				type: String,
				default: "",
			},
			content: {
				type: String,
				default: "",
			},
		},
		data() {
			return {
			}
		},
	})

</script>