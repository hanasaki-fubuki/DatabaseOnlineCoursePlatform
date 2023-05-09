<template>

	<!-- Authors Table Card -->
	<a-card :bordered="false" class="header-solid h-full" :bodyStyle="{padding: 0,}">
		<template #title>
			<a-row type="flex">
				<a-col :span="24" :md="12">
					<h5 class="font-semibold m-0">课程列表</h5>
				</a-col>
			</a-row>
		</template>
    <a-collapse accordion>
      <a-collapse-panel key="1" header="1.1 数据库系统三级模式结构">
        <a-upload :file-list="fileList1" action="1" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="2" header="1.2 ER图及向关系的转换">
        <a-upload :file-list="fileList2" action="2" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="3" header="2.1 关系的性质和完整性约束">
        <a-upload :file-list="fileList3" action="3" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="4" header="2.2 关系代数的基本运算">
        <a-upload :file-list="fileList4" action="4" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="5" header="2.3 关系代数练习">
        <a-upload :file-list="fileList5" action="5" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="6" header="3.1 SQL概述-实验环境及DDL">
        <a-upload :file-list="fileList6" action="6" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="7" header="3.2 SQL的数据查询">
        <a-upload :file-list="fileList7" action="7" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="8" header="3.3 SQL的数据更新">
        <a-upload :file-list="fileList8" action="8" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="9" header="3.4 视图">
        <a-upload :file-list="fileList9" action="9" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="10" header="3.5 授予与回收权限">
        <a-upload :file-list="fileList10" action="10" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="11" header="4.1 游标">
        <a-upload :file-list="fileList11" action="11" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="12" header="4.2 存储过程和函数">
        <a-upload :file-list="fileList12" action="12" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="13" header="5.1 数据库的完整性">
        <a-upload :file-list="fileList13" action="13" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="14" header="5.2 在被参照关系中删除元组时的问题">
        <a-upload :file-list="fileList14" action="14" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="15" header="5.3 外码是否可以接受空值的问题">
        <a-upload :file-list="fileList15" action="15" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="16" header="5.4 修改被参照关系中主码的问题">
        <a-upload :file-list="fileList16" action="16" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="17" header="5.5 在参照关系中插入元组时的问题">
        <a-upload :file-list="fileList17" action="17" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="18" header="5.6 触发器">
        <a-upload :file-list="fileList18" action="18" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="19" header="6.1 基本概念">
        <a-upload :file-list="fileList19" action="19" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="20" header="6.2 范式分析">
        <a-upload :file-list="fileList20" action="20" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="21" header="6.3 函数依赖的公理系统">
        <a-upload :file-list="fileList21" action="21" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="22" header="6.4 求候选码">
        <a-upload :file-list="fileList22" action="22" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="23" header="6.5 模式分解">
        <a-upload :file-list="fileList23" action="23" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="24" header="7.1 事务的基本概念及ACID特性">
        <a-upload :file-list="fileList24" action="24" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="25" header="7.2 三种故障及其恢复">
        <a-upload :file-list="fileList25" action="25" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="26" header="7.3 转储和日志文件的基本概念">
        <a-upload :file-list="fileList26" action="26" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="27" header="7.4 具有检查点的恢复技术和数据库镜像">
        <a-upload :file-list="fileList27" action="27" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="28" header="8.1 并发调度的可串行性和两段锁协议">
        <a-upload :file-list="fileList28" action="28" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="29" header="8.2 活锁和死锁">
        <a-upload :file-list="fileList29" action="29" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="30" header="8.3 封锁粒度">
        <a-upload :file-list="fileList30" action="30" :customRequest="handleUpload" @preview="handleDownload" :remove="handleRemove">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
    </a-collapse>
	</a-card>
	<!-- / Authors Table Card -->

</template>

<script>
import {UploadOutlined} from '@ant-design/icons-vue';

export default {
    components: {
      UploadOutlined,
    },
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
    data () {
      return {
        fileList1: [],
        fileList2: [],
        fileList3: [],
        fileList4: [],
        fileList5: [],
        fileList6: [],
        fileList7: [],
        fileList8: [],
        fileList9: [],
        fileList10: [],
        fileList11: [],
        fileList12: [],
        fileList13: [],
        fileList14: [],
        fileList15: [],
        fileList16: [],
        fileList17: [],
        fileList18: [],
        fileList19: [],
        fileList20: [],
        fileList21: [],
        fileList22: [],
        fileList23: [],
        fileList24: [],
        fileList25: [],
        fileList26: [],
        fileList27: [],
        fileList28: [],
        fileList29: [],
        fileList30: [],
      }
    },

    methods: {
        
        // 对上传成功返回的数据进行格式化处理，格式化a-upload能显示在已上传列表中的格式（这个格式官方文档有给出的）
        fileFormatter(fileData) {
            return {
                name: fileData.filename,
                url: fileData.url,
                uid: fileData.id,
                status: 'done',
            }
        },

        // 删除文件调用
        async handleRemove(file) {
            console.log(file)
            const params = new FormData()
            params.append('id', file.uid)

            const res = await this.$http.post('/file-delete', params)
            if (res.data.code === 200) {
                this.$message.success("文件删除成功，正在更新文件列表，请稍等！")
                await this.fetchData()
                this.$message.success("文件列表更新成功！")
            } else {
                this.$message.error("文件删除失败！")
            }

        },

        // 下载文件调用
        handleDownload(file) {
            console.log(file)
            this.$axios.get(`${file.url}`)
                .then(response => {
                    console.log(response)
                    // response.data是二进制流数据，需要转成blob
                    const blob = new Blob([response.data], { type: 'application/octet-stream' })
                    // 创建一个a标签
                    const a = document.createElement('a')
                    // 将blob转成url
                    a.href = URL.createObjectURL(blob)
                    // 设置下载的文件名（可以通过response获取，也可以自定义）
                    a.download = file.name
                    // 模拟点击
                    a.click()
                    // 释放url
                    URL.revokeObjectURL(a.href)
                })
                .catch(error => {
                    console.log(error);
                });
        },

        async fetchData() {
            for (let i = 1; i <= 30; i++) {
                const response = await this.$axios.post('/file-list', { listNum: String(i) })
                    .then(response => {
                        this.$message.info("正在更新文件列表" + i + "/30...")
                        console.log(response.data)
                        // 将获取到的fileList赋值给组件的fileList属性
                        this[`fileList${i}`] = response.data.map(file => {
                            return this.fileFormatter(file);
                        });
                    })
                    .catch(error => {
                        console.log(error);
                    });
            }
        },
      // 重写a-upload的文件上传处理方式
      async handleUpload (options) {
        const params = new FormData()
        // 把文件放入表单中
        params.append('files', options.file)
        // 放入自定义的参数
        params.append('filename', this.name)
        // 设置listNum
        params.append('listNum', options.action)
        // 调用后端上传
        const res = await this.$http.post("/file-upload", params)

        if (res.data.code === 200) {
          // 成功回调函数
          options.onSuccess(res, options.file)
          this.$message.success("文件上传成功，正在更新文件列表，请稍等！")
            await this.fetchData();
          this.$message.success("文件列表更新成功！")
        } else {
          this.$message.error("文件上传失败！")
        }
      },

    },
    async mounted() {
        this.$message.info("正在获取文件列表，请稍等！")
        await this.fetchData();
        this.$message.success("文件列表获取成功！")
    }
	}

</script>