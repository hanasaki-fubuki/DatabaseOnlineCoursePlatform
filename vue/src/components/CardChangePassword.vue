<template>
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{paddingTop: 0, paddingBottom: 0 }">
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
			<a-button type="primary" block html-type="submit" class="login-form-button" v-on:click="changePass()" :disabled="hasErrors(form.getFieldsError())">
				确认修改密码
			</a-button>
		</a-col>
		<template #title>
			<h6 class="font-semibold m-0">修改您的密码</h6>
		</template>
		<a-form :form="form" @submit="handleSubmit">
			<ul class="list settings-list">
				<li>
					<h6 class="list-header text-sm text-muted m-0">原密码</h6>
				</li>
				<a-form-item class="mb-10" :validate-status="passwordError() ? 'error' : ''" :help="passwordError() || ''">
					<a-input
							v-decorator="[
						'oriPassword',
						{ rules: [
              { required: true, message: '请输入您的原密码！'},//此处开启校验必填
              { max: 128, message: '长度不超过128个字符！'}, // 长度校验
            ] },
						]"
							type="password"
							placeholder="Original Password"
					>
						<a-icon slot="prefix" type="key" style="color: rgba(0,0,0,.25)" />
					</a-input>
				</a-form-item>
				<li>
					<h6 class="list-header text-sm text-muted m-0">新密码</h6>
				</li>
				<a-form-item class="mb-10" :validate-status="newPasswordError() ? 'error' : ''" :help="newPasswordError() || ''">
					<a-input
							v-decorator="[
						'newPassword',
						{ rules: [
              { required: true, message: '请输入您的新密码！'},//此处开启校验必填
              { min: 8, message: '长度不少于8个字符！'}, // 长度校验
              { max: 128, message: '长度不超过128个字符！'}, // 长度校验
              { pattern: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/, message: '密码必须包含大小写字母和数字！'}, // 正则校验
            ] },
						]"
							type="password"
							placeholder="New Password"
					>
						<a-icon slot="prefix" type="key" style="color: rgba(0,0,0,.25)" />
					</a-input>
				</a-form-item>
				<li>
					<h6 class="list-header text-sm text-muted m-0">确认新密码</h6>
				</li>
				<a-form-item class="mb-10" :validate-status="newPasswordConfError() ? 'error' : ''" :help="newPasswordConfError() || ''">
					<a-input
							v-decorator="[
									'newPasswordConf',
									{
										rules: [
											{ required: true, message: '请再次输入您的密码！'},//此处开启校验必填
											{ validator: this.validatePassword},//校验规则函数，
										],
										trigger: 'blur' // 触发方式
									}
									]"
							type="password"
							placeholder="Confirm New Password"
					>
						<a-icon slot="prefix" type="key" style="color: rgba(0,0,0,.25)" />
					</a-input>
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
				id: '',
				username: '',
				oriPassword: '',
				newPassword: '',
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
			// Only show error after a field is touched.
			passwordError() {
				const { getFieldError, isFieldTouched } = this.form;
				return isFieldTouched('password') && getFieldError('password');
			},
			newPasswordError() {
				const { getFieldError, isFieldTouched } = this.form;
				return isFieldTouched('newPassword') && getFieldError('newPassword');
			},
			newPasswordConfError() {
				const { getFieldError, isFieldTouched } = this.form;
				return isFieldTouched('newPasswordConf') && getFieldError('newPasswordConf');
			},
			validatePassword(rule, value, callback) {
				if (value && value !== this.form.getFieldValue('newPassword')) {
					callback('两次密码输入不一致！');
				} else {
					callback();
				}
			},
			changePass() {
				this.$axios
						.post('/change-pass', {
							user: this.userInfo,
							oriPassword: this.form.getFieldValue('oriPassword'),
							newPassword: this.form.getFieldValue('newPassword'),

						},{
							headers: {
								'Content-Type': 'application/json'
							}
						})
						.then(successResponse => {
							if (successResponse.data.code === 200) {
								console.log(successResponse.data)
								this.$message.success('密码修改成功，请重新登录！')
								// 清空sessionStorage，重新登录
								window.sessionStorage.clear()
								this.$router.replace({path: '/sign-in'})
							} else {
								alert('原密码错误，密码修改失败！')
							}
						})
						.catch(failResponse => {})
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