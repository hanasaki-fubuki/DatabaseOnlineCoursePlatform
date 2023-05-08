module.exports = {
	// 配置跨域
	devServer:{
		proxy: 'http://localhost:8081'
	},
	runtimeCompiler: true,

	chainWebpack: config => {
		config
			.plugin('html')
			.tap(args => {
				args[0].title = 'Microdream 数据库第四课堂学习平台'
				return args
			})
	}
}
