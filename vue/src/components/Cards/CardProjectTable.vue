<template>
				
	<!-- Projects Table Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{padding: 0,}">
		<template #title>
			<a-row type="flex" align="middle">
				<a-col :span="24" :md="12">
					<h6>课程热度</h6>
					<p>此处仅显示本月数据 <span class="text-primary"></span></p>
				</a-col>
			</a-row>
		</template>
		<a-table :columns="columns" :data-source="data" :pagination="false">

			<a-space slot="members" slot-scope="members" :size="-12" class="avatar-chips">
				<template v-for="member in members">
					<a-avatar :key="member" size="small" :src="member" />
				</template>
			</a-space>

			<template slot="course" slot-scope="course">
				<h6 class="m-0">
					<img :src="course.logo" width="25" class="mr-10">
					{{ course.name }}
				</h6>
			</template>

			<template slot="completion" slot-scope="completion">
				<span class="font-bold text-muted text-sm">{{ completion.label ? completion.label : completion }}</span>
				<a-progress :percent="completion.value ? completion.value : completion" :show-info="false" size="small" :status="completion.status ? completion.status : 'normal'" />
			</template>

		</a-table>
	</a-card>
	<!-- / Projects Table Card -->

</template>

<script>

	export default ({
		props: {
			data: {
				type: Array,
				default: () => [],
			},
			columns: {
				type: Array,
				default: () => [],
			},
		},
		data() {
			return {

				// Active button for the "Projects" table's card header radio button group.
				projectHeaderBtns: 'all',
			}
		},
	})

</script>