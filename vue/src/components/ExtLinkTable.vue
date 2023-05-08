<template>

	<!-- extlinks Table Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{padding: 0,}">
		<template #title>
			<a-row type="flex">
				<a-col :span="24" :md="12">
					<h5 class="font-semibold m-0">国内学习链接</h5>
				</a-col>
			</a-row>
		</template>
		<a-table :columns="columns" :data-source="data" :pagination="false">

			<template slot="extlink" slot-scope="extlink">
				<div class="table-avatar-info">
					<div class="avatar-info">
						<h6>{{ extlink.name }}</h6>
						<p>{{ extlink.link }}</p>
					</div>
				</div>
			</template>

			<template slot="func" slot-scope="func">
				<div class="extlink-info">
					<h6 class="m-0">{{ func.type }}</h6>
				</div>
			</template>

			<template slot="status" slot-scope="status">
				<a-tag class="tag-status" :class="status ? 'ant-tag-primary' : 'ant-tag-muted'">
					{{ status ? "ONLINE, STABLE FROM CHINA MAINLAND" : "OFFLINE" }}
				</a-tag>
			</template>

			<template slot="editBtn" slot-scope="row">
				<a-button type="link" :data-link="row.extlink.link" class="btn-edit" v-on:click="jumplink($event)">
					跳转到该平台
				</a-button>
			</template>

		</a-table>
	</a-card>
	<!-- / extlinks Table Card -->

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

			}
		},
    methods: {
      jumplink(e) {
        window.open(e.target.getAttribute('data-link'),"_blank")
      }
    }
	})

</script>