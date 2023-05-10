<!--
	This is the sign up page, it uses the dashboard layout in:
	"./layouts/Default.vue" .
 -->

<template>
  <div>

    <!-- Sign Up Image And Headings -->
    <div class="sign-up-header" style="background-image: url('images/bg-signup.jpg')">
      <div class="content">
        <h1 class="mb-5">注册新的账户</h1>
        <p class="text-lg">仅需注册一个账户即可使用Microdream提供的的所有服务</p>
      </div>
    </div>
    <!-- / Sign Up Image And Headings -->

    <!-- Sign Up Form -->
    <a-card :bordered="false" class="card-signup header-solid h-full" :bodyStyle="{paddingTop: 0}">
      <!--			<template #title>-->
      <!--				<h5 class="font-semibold text-center">Register With</h5>-->
      <!--			</template>-->
      <!--			<div class="sign-up-gateways">-->
      <!--    			<a-button>-->
      <!--					<img src="images/logos/logos-facebook.svg" alt="">-->
      <!--				</a-button>-->
      <!--    			<a-button>-->
      <!--					<img src="images/logos/logo-apple.svg" alt="">-->
      <!--				</a-button>-->
      <!--    			<a-button>-->
      <!--					<img src="images/logos/Google__G__Logo.svg.png" alt="">-->
      <!--				</a-button>-->
      <!--			</div>-->
      <!--			<p class="text-center my-25 font-semibold text-muted">Or</p>-->


      <p class="text-center my-25 font-semibold text-muted"></p>
      <a-form
          id="components-form-demo-normal-login"
          :form="form"
          class="login-form"
          @submit="handleSubmit"
      >
        <p class="text-left mb-5 font-semibold">用户名: </p>
        <a-form-item class="mb-10" :validate-status="usernameError() ? 'error' : ''" :help="usernameError() || ''">
          <a-input
              v-decorator="[
						'username',
						{ rules: [
                { required: true, message: '请输入您选择的用户名！' },
                { min: 3, message: '长度不少于3个字符！'}, // 长度校验
                { max: 32, message: '长度不超过32个字符！'}, // 长度校验
                { pattern: /^[a-zA-Z0-9_-]+$/, message: '用户名只能包含字母、数字、连字符和下划线！'}, // 正则校验
                ] },
						]"
              placeholder="Name"
          >
            <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
          </a-input>
        </a-form-item>
        <p class="text-left mb-5 font-semibold">邮箱: </p>
        <a-form-item class="mb-10" :validate-status="emailError() ? 'error' : ''" :help="emailError() || ''">
          <a-input
              v-decorator="[
						'email',
						{ rules: [
                { required: true, message: '请输入您的邮箱！' },
                { type: 'email', message: '请输入正确的邮箱地址！' },
                { max: 256, message: '邮箱长度不超过256个字符！'}
            ] },
						]"
              placeholder="Email"
          >
            <a-icon slot="prefix" type="mail" style="color: rgba(0,0,0,.25)" />
          </a-input>
        </a-form-item>
        <p class="text-left mb-5 font-semibold">手机: </p>
        <a-form-item class="mb-10" :validate-status="phoneError() ? 'error' : ''" :help="phoneError() || ''">
          <a-input
              v-decorator="[
						'phone',
						{ rules: [
                { required: true, message: '请输入您的手机号码！' },
                { pattern: /^[0-9]+$/, message: '请输入正确的手机号码！' },
                { max: 32, message: '手机号码长度不超过32个字符！'}
            ] },
						]"
              placeholder="Phone"
          >
            <a-icon slot="prefix" type="phone" style="color: rgba(0,0,0,.25)" />
          </a-input>
        </a-form-item>
        <p class="text-left mb-5 font-semibold">密码: </p>
        <a-form-item class="mb-10" :validate-status="passwordError() ? 'error' : ''" :help="passwordError() || ''">
          <a-input
              v-decorator="[
						'password',
						{ rules: [
              { required: true, message: '请输入您的密码！'},//此处开启校验必填
              { min: 8, message: '长度不少于8个字符！'}, // 长度校验
              { max: 128, message: '长度不超过128个字符！'}, // 长度校验
              { pattern: /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/, message: '密码必须包含大小写字母和数字！'}, // 正则校验
            ] },
						]"
              type="password"
              placeholder="Password"
          >
            <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
          </a-input>
        </a-form-item>
        <p class="text-left mb-5 font-semibold">确认密码: </p>
        <a-form-item class="mb-10" :validate-status="passConfError() ? 'error' : ''" :help="passConfError() || ''">
          <a-input v-decorator="['passwordConf',validatorRules.passwordConf]" type="password" placeholder="Confirm Password">
            <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
          </a-input>
        </a-form-item>
        <p class="text-left mb-5 font-semibold">昵称: </p>
        <a-form-item class="mb-10" :validate-status="nameError() ? 'error' : ''" :help="nameError() || ''">
          <a-input
              v-decorator="[
						'name',
						{ rules: [
                { required: true, message: '请输入您的昵称！' },
                { max: 32, message: '昵称长度不超过32个字符！'}
            ] },
						]"
              placeholder="Nickname"
          >
            <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
          </a-input>
        </a-form-item>
        <p class="text-left mb-5 font-semibold">性别: </p>
        <a-form-item class="mb-10">
          <a-select
              style="width: 240px"
              v-decorator="[
                  'gender',
                  {
                    initialValue: '1',
                  },

              ]"
          >
            <a-select-option value="1">
              男
            </a-select-option>
            <a-select-option value="0">
              女
            </a-select-option>
          </a-select>
        </a-form-item>
        <p class="text-left mb-5 font-semibold">年龄: </p>
        <a-form-item class="mb-5" :validate-status="ageError() ? 'error' : ''" :help="ageError() || ''">
          <a-input
              v-decorator="[
						'age',
						{ rules: [
                { required: true, message: '请输入您的年龄！' },
                { pattern: /^[0-9]+$/, message: '请输入正确的年龄数字！' },
                { max: 3, message: '年龄长度不超过3个字符！'}
            ] },
						]"
              placeholder="Age"
          >
            <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
          </a-input>
        </a-form-item>
        <a-form-item class="mb-10">
          <a-checkbox default-checked disabled>
            若要注册，您必须同意 <a href="#" class="font-bold text-dark">用户协议与许可条款</a>
          </a-checkbox>
        </a-form-item>
        <a-form-item>
          <a-button type="primary" block html-type="submit" class="login-form-button"  v-on:click="signup()" :disabled="hasErrors(form.getFieldsError())">
            立即注册
          </a-button>
        </a-form-item>
      </a-form>
      <p class="font-semibold text-muted text-center">已有Microdream账户？<router-link to="/sign-in" class="font-bold text-dark">立即登录</router-link></p>
    </a-card>
    <!-- / Sign Up Form -->

  </div>
</template>

<script>
function hasErrors(fieldsError) {
  return Object.keys(fieldsError).some(field => fieldsError[field]);
}
export default ({

  data() {
    return {
      hasErrors,
      username: '',
      password: '',
      name: '',
      gender: '',
      age: '',
      email: '',
      phone: '',

      validatorRules: {
        passwordConf : {//name与v-decorator中属性对应
          rules: [
            { required: true, message: '请再次输入您的密码！'},//此处开启校验必填
            { validator: this.validatePassword},//校验规则函数，
          ],
          trigger: 'blur' // 触发方式
        },
      },
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
    // Only show error after a field is touched.
    emailError() {
      const { getFieldError, isFieldTouched } = this.form;
      return isFieldTouched('email') && getFieldError('email');
    },
    // Only show error after a field is touched.
    phoneError() {
      const { getFieldError, isFieldTouched } = this.form;
      return isFieldTouched('phone') && getFieldError('phone');
    },
    // Only show error after a field is touched.
    nameError() {
      const { getFieldError, isFieldTouched } = this.form;
      return isFieldTouched('name') && getFieldError('name');
    },
    ageError() {
      const { getFieldError, isFieldTouched } = this.form;
      return isFieldTouched('age') && getFieldError('age');
    },
    passConfError() {
      const { getFieldError, isFieldTouched } = this.form;
      return isFieldTouched('passwordConf') && getFieldError('passwordConf');
    },
    signup() {
      this.$axios
          .post('/sign-up', {
            username: this.form.getFieldValue('username'),
            password: this.form.getFieldValue('password'),
            name: this.form.getFieldValue('name'),
            gender: this.form.getFieldValue('gender'),
            age: this.form.getFieldValue('age'),
            email: this.form.getFieldValue('email'),
            phone: this.form.getFieldValue('phone')
          },{
            headers: {
              'Content-Type': 'application/json'
            }
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
                this.$message.success('注册成功！即将跳转登录页面......')
              this.$router.replace({path: '/sign-in'})
            } else if (successResponse.data.code === 100) {
                this.$message.error('很抱歉，注册失败。用户名已存在。')
            } else {
                this.$message.error('很抱歉，出于未知原因，注册失败。请尝试联系系统管理员。')
            }
          })
          .catch(failResponse => {})
    },
    validatePassword(rule, value, callback) {
      if (value && value !== this.form.getFieldValue('password')) {
        callback('两次密码输入不一致！');
      } else {
        callback();
      }
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
</style>