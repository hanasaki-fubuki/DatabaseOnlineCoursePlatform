<template>

	<!-- Projects Table Column -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{padding: 0,}">
		<template #title>
			<a-row type="flex" align="middle">
				<a-col :span="24" :md="12">
					<h5 class="font-semibold m-0">向教师提问</h5>
				</a-col>
			</a-row>
		</template>
		<p class="text-center my-25 font-semibold text-muted"></p>
		<a-form
				id="components-form-demo-normal-login"
				class="login-form"
		>
			<p class="text-left mb-5 font-semibold">用户名: </p>
			<a-form-item class="mb-10">
				<a-input
						v-decorator="['username',]"
						placeholder="Name"
				>
					<a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
				</a-input>
			</a-form-item>
			<p class="text-left mb-5 font-semibold">邮箱: </p>
			<a-form-item class="mb-10">
				<a-input
						v-decorator="['email',]"
						placeholder="Email"
				>
					<a-icon slot="prefix" type="mail" style="color: rgba(0,0,0,.25)" />
				</a-input>
			</a-form-item>
			<p class="text-left mb-5 font-semibold">手机: </p>
			<a-form-item class="mb-10">
				<a-input
						v-decorator="['phone',]"
						placeholder="Phone"
				>
					<a-icon slot="prefix" type="phone" style="color: rgba(0,0,0,.25)" />
				</a-input>
			</a-form-item>
			<p class="text-left mb-5 font-semibold">密码: </p>
			<a-form-item class="mb-10">
				<a-input
						v-decorator="['password',]"
						type="password"
						placeholder="Password"
				>
					<a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
				</a-input>
			</a-form-item>
			<p class="text-left mb-5 font-semibold">确认密码: </p>
			<a-form-item class="mb-10">
				<a-input v-decorator="['passwordConf']" type="password" placeholder="Confirm Password">
					<a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
				</a-input>
			</a-form-item>
			<p class="text-left mb-5 font-semibold">昵称: </p>
			<a-form-item class="mb-10">
				<a-input
						v-decorator="['name']"
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
			<a-form-item class="mb-5">
				<a-input
						v-decorator="['age',]"
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
				<a-button type="primary" block html-type="submit" class="login-form-button"  v-on:click="signup()">
					立即注册
				</a-button>
			</a-form-item>
		</a-form>
		<p class="font-semibold text-muted text-center">已有Microdream账户？<router-link to="/sign-in" class="font-bold text-dark">立即登录</router-link></p>

		<div class="table-upload-btn">
			<a-button type="dashed" block>
				<svg width="16" height="16" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
					<path fill-rule="evenodd" clip-rule="evenodd" d="M3 17C3 16.4477 3.44772 16 4 16H16C16.5523 16 17 16.4477 17 17C17 17.5523 16.5523 18 16 18H4C3.44772 18 3 17.5523 3 17ZM6.29289 6.70711C5.90237 6.31658 5.90237 5.68342 6.29289 5.29289L9.29289 2.29289C9.48043 2.10536 9.73478 2 10 2C10.2652 2 10.5196 2.10536 10.7071 2.29289L13.7071 5.29289C14.0976 5.68342 14.0976 6.31658 13.7071 6.70711C13.3166 7.09763 12.6834 7.09763 12.2929 6.70711L11 5.41421L11 13C11 13.5523 10.5523 14 10 14C9.44771 14 9 13.5523 9 13L9 5.41421L7.70711 6.70711C7.31658 7.09763 6.68342 7.09763 6.29289 6.70711Z" fill="#111827"/>
				</svg>
				提交问题表单
			</a-button>
		</div>
	</a-card>
	<!-- / Projects Table Column -->

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