<!-- 
	This is the billing page, it uses the dashboard layout in: 
	"./layouts/Dashboard.vue" .
 -->

<template>
	<div>
		<a-row type="flex" :gutter="24">
			<a-col :span="24" :md="16">
				<a-row type="flex" :gutter="24">
					<a-col :span="24" :xl="12" class="mb-24">
						<CardAdminTitle></CardAdminTitle>
					</a-col>
					<a-col :span="12" :xl="6" class="mb-24" v-for="(salary, index) in adminStatus" :key="index">
						<CardAdminStatus
								:value="salary.value"
								:prefix="salary.prefix"
								:icon="salary.icon"
								:title="salary.title"
								:content="salary.content"
						></CardAdminStatus>
					</a-col>
					<a-col :span="24" class="mb-24">
						<CardSU></CardSU>
					</a-col>
					<CardAdminUserTable></CardAdminUserTable>
				</a-row>
			</a-col>
			<a-col :span="24" :md="8" class="mb-24">
				<CardSystemLog></CardSystemLog>
			</a-col>
		</a-row>
	</div>
</template>

<script>

	import CardAdminTitle from "../components/Cards/CardAdminTitle.vue"
	import CardAdminStatus from "../components/Cards/CardAdminStatus.vue"
	import CardSU from "../components/Cards/CardSU.vue"
	import CardSystemLog from "../components/Cards/CardSystemLog.vue"
	import CardAdminUserTable from "../components/Cards/CardAdminUserTable.vue"


	const adminStatus = [
		{
			value: "正常运行",
			icon: `
										<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 22 22">
											<g id="bank" transform="translate(0.75 0.75)">
												<path id="Shape" transform="translate(0.707 9.543)" fill="none" stroke="#fff" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
												<path id="Path" d="M10.25,0,20.5,9.19H0Z" fill="none" stroke="#fff" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
												<path id="Path-2" data-name="Path" d="M0,.707H20.5" transform="translate(0 19.793)" fill="none" stroke="#fff" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
											</g>
										</svg>`,
			title: "系统运行状态",
			content: "This is currently a fake module. ",
		},
		{
			value: "正常运行",
			icon: `
										<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 22 22">
											<g id="bank" transform="translate(0.75 0.75)">
												<path id="Shape" transform="translate(0.707 9.543)" fill="none" stroke="#fff" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
												<path id="Path" d="M10.25,0,20.5,9.19H0Z" fill="none" stroke="#fff" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
												<path id="Path-2" data-name="Path" d="M0,.707H20.5" transform="translate(0 19.793)" fill="none" stroke="#fff" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="1.5"/>
											</g>
										</svg>`,
			title: "数据库状态",
			content: "This is currently a fake module. ",
		},
	] ;

	// "Invoices" list data.
	const invoiceData = [
		{
			title: "March, 01, 2021",
			code: "#MS-415646",
			amount: "180",
		},
		{
			title: "February, 12, 2021",
			code: "#RV-126749",
			amount: "250",
		},
		{
			title: "April, 05, 2020",
			code: "#FB-212562",
			amount: "550",
		},
		{
			title: "June, 25, 2019",
			code: "#QW-103578",
			amount: "400",
		},
		{
			title: "March, 03, 2019",
			code: "#AR-803481",
			amount: "700",
		},
	] ;

	export default ({
		components: {
			CardAdminTitle,
			CardAdminStatus,
			CardSU,
			CardSystemLog,
			CardAdminUserTable,
		},
		data() {
			return {
				adminStatus,

				// Associating "Invoices" list data with its corresponding property.
				invoiceData,
			}
		},
	})

</script>

<style lang="scss">
</style>