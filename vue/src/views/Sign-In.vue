<!-- 
	This is the sign in page, it uses the dashboard layout in: 
	"./layouts/Default.vue" .
 -->

<template>
	<div class="sign-in">

		<a-row :gutter="[24,24]" align="middle" justify="space-around" type="flex">

			<!-- Sign In Form Column -->
			<a-col :span="24" :md="12" :lg="{span: 12, offset: 0}" :xl="{span: 6, offset: 2}" class="col-form">
				<h1 class="mb-15">登录到现有的账户</h1>
				<h5 class="font-regular text-muted">请输入您的用户名和密码登录系统以继续学习</h5>

				<!-- Sign In Form -->
				<a-form
					id="components-form-demo-normal-login"
					:form="form"
					class="login-form"
					@submit="handleSubmit"
					:hideRequiredMark="true"
				>
					<a-form-item class="mb-10" label="用户名" :colon="false" :validate-status="usernameError() ? 'error' : ''" :help="usernameError() || ''">
						<a-input
						v-decorator="[
						'username',
						{ rules: [
                { required: true, message: '请输入您的用户名！' },
                { pattern: /^[a-zA-Z0-9_-]+$/, message: '用户名只能包含字母、数字、连字符和下划线！'}, // 正则校验
                ] },
						]" placeholder="Username" >
              <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
            </a-input>
					</a-form-item>
					<a-form-item class="mb-5" label="密码" :colon="false" :validate-status="passwordError() ? 'error' : ''" :help="passwordError() || ''">
						<a-input
						v-decorator="[
						'password',
						{ rules: [{ required: true, message: '请输入您的密码！' }] },
						]" type="password" placeholder="Password" >
              <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
            </a-input>
					</a-form-item>
					<a-form-item>
						<a-button type="primary" block html-type="submit" class="login-form-button" v-on:click="signin()" :disabled="hasErrors(form.getFieldsError())">
							登录
						</a-button>
					</a-form-item>
				</a-form>
				<!-- / Sign In Form -->

				<p class="font-semibold text-muted">还没有Microdream账户？ <router-link to="/sign-up" class="font-bold text-dark">立即注册</router-link></p>
			</a-col>
			<!-- / Sign In Form Column -->

			<!-- Sign In Image Column -->
			<a-col :span="24" :md="12" :lg="12" :xl="12">
				<img src="images/img-signin.png" alt="" class="mypic">
			</a-col>
			<!-- Sign In Image Column -->

		</a-row>
		
	</div>
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
        username: '',
        password: '',
        responseResult: [],
				// Binded model property for "Sign In Form" switch button for "Remember Me" .
				rememberMe: true,
			}
		},
    mounted() {
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
      usernameError() {
        const { getFieldError, isFieldTouched } = this.form;
        return isFieldTouched('username') && getFieldError('username');
      },
      // Only show error after a field is touched.
      passwordError() {
        const { getFieldError, isFieldTouched } = this.form;
        return isFieldTouched('password') && getFieldError('password');
      },
      signin () {
				this.$message.info('正在尝试登录，请稍候！')
        this.$axios
            .post('/sign-in', {
              username: this.form.getFieldValue('username'),
              password: this.form.getFieldValue('password')
            },{
              headers: {
                'Content-Type': 'application/json'
              }
            })
            .then(successResponse => {
              if (successResponse.data.code === 200) {
								console.log(successResponse.data)
								// 保存sessionStorage
								sessionStorage.setItem('currentUser', JSON.stringify(successResponse.data.obj));
                this.$router.replace({path: '/dashboard'})
								this.$message.success('登录成功！')
              } else {
                this.$message.error("用户名或密码错误！")
              }
            })
            .catch(failResponse => {})

        },

			// Handles input validation after submission.
			handleSubmit(e) {
				e.preventDefault();
				this.form.validateFields((err, values) => {
					if ( !err ) {
						console.log('Received values of form: ', values) ;
					}
				});
			},
		},
	})

</script>

<style lang="scss">
	body {
		background-color: #ffffff;
	}
  .mypic{

    width: 80%  !important;
    height: 80%;
  }
</style>