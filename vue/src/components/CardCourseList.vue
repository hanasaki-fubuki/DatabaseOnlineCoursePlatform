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
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="1.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="2" header="1.2 ER图及向关系的转换">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="1.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="3" header="2.1 关系的性质和完整性约束">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="2.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="4" header="2.2 关系代数的基本运算">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="2.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="5" header="2.3 关系代数练习">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="2.3" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="6" header="3.1 SQL概述-实验环境及DDL">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="3.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="7" header="3.2 SQL的数据查询">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="3.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="8" header="3.3 SQL的数据更新">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="3.3" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="9" header="3.4 视图">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="3.4" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="10" header="3.5 授予与回收权限">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="3.5" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="11" header="4.1 游标">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="4.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="12" header="4.2 存储过程和函数">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="4.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="13" header="5.1 数据库的完整性">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="5.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="14" header="5.2 在被参照关系中删除元组时的问题">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="5.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="15" header="5.3 外码是否可以接受空值的问题">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="5.3" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="16" header="5.4 修改被参照关系中主码的问题">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="5.4" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="17" header="5.5 在参照关系中插入元组时的问题">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="5.5" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="18" header="5.6 触发器">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="5.6" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="19" header="6.1 基本概念">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="6.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="20" header="6.2 范式分析">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="6.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="21" header="6.3 函数依赖的公理系统">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="6.3" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="22" header="6.4 求候选码">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="6.4" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="23" header="6.5 模式分解">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="6.5" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="24" header="7.1 事务的基本概念及ACID特性">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="7.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="25" header="7.2 三种故障及其恢复">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="7.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="26" header="7.3 转储和日志文件的基本概念">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="7.3" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="27" header="7.4 具有检查点的恢复技术和数据库镜像">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="7.4" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="28" header="8.1 并发调度的可串行性和两段锁协议">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="8.1" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="29" header="8.2 活锁和死锁">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="8.2" :customRequest="downloadFilesCustomRequest">
          <a-button>
            上传本课程相关文件
          </a-button>
        </a-upload>
      </a-collapse-panel>
      <a-collapse-panel key="30" header="8.3 封锁粒度">
        <a-upload v-model:file-list="fileList" action="/file-upload" :data-path="8.3" :customRequest="downloadFilesCustomRequest">
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
import { UploadOutlined } from '@ant-design/icons-vue';
	export default ({
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
        fileList: [],                            // 上传文件列表
      }
    },

    methods: {

      // 重写a-upload的文件上传处理方式
      async downloadFilesCustomRequest (options) {
        const path = options.file.attributes['data-path'].value;
        const params = new FormData()
        // 把文件放入表单中
        params.append('files', options.file)
        // 放入自定义的参数
        params.append('filename', this.name)
        // 设置上传文件路径
        params.append('path', path)
        // 调用后端上传
        const res = await this.$http.post("/file-upload", params)
        console.log(res, options)
        console.log(res, options)

        if (res.code === 200) {
          options.status = 'done'
          // 成功回调函数
          options.onSuccess(res, options.file)

        } else {
          this.$message.error(res.message)
        }
      },

      // 对上传成功返回的数据进行格式化处理，格式化a-upload能显示在已上传列表中的格式（这个格式官方文档有给出的）
      fileFormatter(data) {
        let file = {
          uid: data.uuid,    // 文件唯一标识，建议设置为负数，防止和内部产生的 id 冲突
          name: data.name,   // 文件名
          status: 'done', // 状态有：uploading done error removed
          response: '{"status": "success"}', // 服务端响应内容
        }
        return file
      },

      // 没错，删除某个已上传的文件的时候，就是调用的这里
      handleDownloadFileRemove (file) {
        const index = this.downloadFiles.indexOf(file)
        const newFileList = this.downloadFiles.slice()
        newFileList.splice(index, 1)
        this.downloadFiles = newFileList
      }
    },

	})

</script>