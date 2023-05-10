<template>
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: 0 }">
		<template #title>
			<a-row type="flex">
				<a-col :span="24" :md="12">
					<h5 class="font-semibold m-0">学生自主提问</h5>
				</a-col>
			</a-row>
		</template>
		<a-col :span="24" :md="12" class="col-info">
			<li>
				<a-descriptions title="" :column="1">
					<a-descriptions-item label="您的用户名">
						{{ userInfo.username }}
					</a-descriptions-item>
				</a-descriptions>
			</li>
		</a-col>
		<a-col :span="24" :md="12" style="display: flex; align-items: center; justify-content: flex-end">
			<a-button type="primary" block html-type="submit" class="login-form-button" v-on:click="submit()" :disabled="hasErrors(form.getFieldsError())">
				我要提问！
			</a-button>
		</a-col>
		<a-form :form="form" @submit="handleSubmit">
			<ul class="list settings-list">
				<p class="text-left mb-5 font-semibold">问题描述</p>
				<a-form-item class="mb-10" :validate-status="subjectError() ? 'error' : ''" :help="subjectError() || ''">
					<a-input
							v-decorator="[
						'subject',
						{ rules: [
                { required: true, message: '请输入您的问题描述！' },
                { max: 64, message: '长度不超过64个字符！'} // 长度校验
                ] },
						]"
							placeholder="Problem Subject"
					>
					</a-input>
				</a-form-item>
				<p class="text-left mb-5 font-semibold">问题所属章节</p>
				<a-form-item class="mb-10">
					<a-select
							style="width: 720px"
							v-decorator="[
                  'chapter',
                  {
                    initialValue: '1',
                  },

              ]"
					>
						<a-select-option value="1">
							1 - 数据库三级模式结构与ER图
						</a-select-option>
						<a-select-option value="2">
							2 - 关系的性质及约束、关系模型与关系代数
						</a-select-option>
						<a-select-option value="3">
							3 - SQL语言基础语法概述及实践
						</a-select-option>
						<a-select-option value="4">
							4 - 游标、存储过程与函数
						</a-select-option>
						<a-select-option value="5">
							5 - 数据库的完整性、参照关系、与参照关系相关的主键与外键以及触发器
						</a-select-option>
						<a-select-option value="6">
							6 - 关系数据理论基本概念与范式分析
						</a-select-option>
						<a-select-option value="7">
							7 - 数据库的安全性与完整性（备份、恢复、日志与检查点）
						</a-select-option>
						<a-select-option value="8">
							8 - 活锁、死锁与并发控制、封锁粒度
						</a-select-option>
					</a-select>
				</a-form-item>
				<p class="text-left mb-5 font-semibold">问题描述</p>
				<a-form-item class="mb-10" :validate-status="contentError() ? 'error' : ''" :help="contentError() || ''">
					<a-textarea style="height: 200px"
							v-decorator="[
						'content',
						{ rules: [
                { required: true, message: '请输入您的问题详细信息！' },
                { max: 2048, message: '长度不超过2048个字符！'} // 长度校验
                ] },
						]"
							placeholder="Problem Content"
					>
					</a-textarea>
				</a-form-item>
			</ul>
		</a-form>
	</a-card>

</template>

<script>
import form from "ant-design-vue/es/form";

function hasErrors(fieldsError) {
	return Object.keys(fieldsError).some(field => fieldsError[field]);
}
export default ({
	data() {
		return {
			hasErrors,
			uid: '',
			subject: '',
			chapter: '',
			content: '',
			userInfo: {},

		}
	},
	mounted() {
		const userStr = sessionStorage.getItem("currentUser");
		if (userStr) {
			this.userInfo = JSON.parse(userStr);
		}
		this.$nextTick(() => {
			// To disabled submit button at the beginning.
			this.form.validateFields();
		});
	},
	beforeCreate() {
		// Creates the form and adds to it component's "form" property.
		this.form = this.$form.createForm(this, { name: 'normal_login' });
	},
	methods: {
		submit() {
			this.$axios
					.post('/submit-problem', {
						uid: this.userInfo.uid,
						subject: this.form.getFieldValue('subject'),
						chapter: this.form.getFieldValue('chapter'),
						content: this.form.getFieldValue('content'),
					},{
						headers: {
							'Content-Type': 'application/json'
						}
					})
					.then(successResponse => {
						if (successResponse.data.code === 200) {
							console.log(successResponse.data)
							this.$message.success('您的提问已经提交，请等候教师回复！')
							location.reload()
						} else {
							alert('很抱歉，提交失败，请联系教师或管理员！')
						}
					})
					.catch(failResponse => {})
		},
		// Only show error after a field is touched.
		subjectError() {
			const { getFieldError, isFieldTouched } = this.form;
			return isFieldTouched('subject') && getFieldError('subject');
		},
		contentError() {
			const { getFieldError, isFieldTouched } = this.form;
			return isFieldTouched('content') && getFieldError('content');
		},
		handleSubmit(e) {
			e.preventDefault();
			this.form.validateFields((err, values) => {
				if ( !err ) {
					console.log('Received values of form: ', values) ;
				}
			});
		},
	}
})

</script>