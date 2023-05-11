<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
  <div>

    <a-row :gutter="24" type="flex">
      <a-col :span="24" class="mb-24">
        <CardExtLinkTable2
            :data="table2Data"
            :columns="table2Columns"
        ></CardExtLinkTable2>
      </a-col>
    </a-row>

    <a-row :gutter="24" type="flex">
      <a-col :span="24" class="mb-24">
        <CardExtLinkTable
            :data="table1Data"
            :columns="table1Columns"
        ></CardExtLinkTable>
      </a-col>
    </a-row>

  </div>
</template>

<script>

import CardExtLinkTable from '../components/Cards/CardExtLinkTable.vue' ;
import CardExtLinkTable2 from '../components/Cards/CardExtLinkTable2.vue'

const table1Columns = [
  {
    title: '外部链接平台',
    dataIndex: 'extlink',
    scopedSlots: { customRender: 'extlink' },
  },
  {
    title: '平台类型',
    dataIndex: 'func',
    scopedSlots: { customRender: 'func' },
  },
  {
    title: '状态',
    dataIndex: 'status',
    scopedSlots: { customRender: 'status' },
  },
  {
    title: '跳转链接',
    scopedSlots: { customRender: 'editBtn' },
    width: 50,
  },
];

const table1Data = [
  {
    key: '1',
    extlink: {
      name: '中国大学MOOC',
      link: 'https://www.icourse163.org/',
    },
    func: {
      type: '多媒体课程学习平台',
    },
    status: 1,
  },
  {
    key: '2',
    extlink: {
      name: '知到智慧树在线教育',
      link: 'https://www.zhihuishu.com/',
    },
    func: {
      type: '多媒体课程学习平台',
    },
    status: 1,
  },
  {
    key: '3',
    extlink: {
      name: '超星学习通',
      link: 'http://i.chaoxing.com/',
    },
    func: {
      type: '管理式网络课程平台',
    },
    status: 1,
  },
  {
    key: '4',
    extlink: {
      name: '中国知网',
      link: 'https://www.cnki.net/',
    },
    func: {
      type: '国内权威论文期刊发布平台',
    },
    status: 1,
  },
  {
    key: '5',
    extlink: {
      name: 'CSDN',
      link: 'https://www.csdn.net/',
    },
    func: {
      type: '国内优质程序员交流论坛',
    },
    status: 1,
  },
  {
    key: '6',
    extlink: {
      name: 'PTA程序设计辅助教学平台',
      link: 'https://pintia.cn/home',
    },
    func: {
      type: '程序设计刷题练习平台',
    },
    status: 1,
  },
];

const table2Columns = [
  {
    title: '外部链接平台',
    dataIndex: 'extlink',
    scopedSlots: { customRender: 'extlink' },
  },
  {
    title: '平台类型',
    dataIndex: 'func',
    scopedSlots: { customRender: 'func' },
  },
  {
    title: '状态',
    dataIndex: 'status',
    scopedSlots: { customRender: 'status' },
  },
  {
    title: '跳转链接',
    scopedSlots: { customRender: 'editBtn' },
    width: 50,
  },
];

// "Authors" table list of rows and their properties.
const table2Data = [
  {
    key: '1',
    extlink: {
      name: 'IEEE',
      link: 'https://www.ieee.org/',
    },
    func: {
      type: '国外权威计算机类论文期刊发布平台',
    },
    status: 1,
  },
  {
    key: '2',
    extlink: {
      name: 'Stack Overflow',
      link: 'https://stackoverflow.com/',
    },
    func: {
      type: '国外优质程序员合作交流平台',
    },
    status: 1,
  },
  {
    key: '3',
    extlink: {
      name: 'GeeksforGeeks',
      link: 'https://www.geeksforgeeks.org/',
    },
    func: {
      type: '优质计算机科学技术知识平台',
    },
    status: 1,
  },
  {
    key: '4',
    extlink: {
      name: 'GitHub',
      link: 'https://github.com/',
    },
    func: {
      type: '全球最大的开源软件发布与合作平台',
    },
    status: 1,
  },

];

export default ({
  components: {
      CardExtLinkTable,
      CardExtLinkTable2,
  },
  data() {
    return {

      table1Data: table1Data,

      table1Columns: table1Columns,

      table2Data: table2Data,

      table2Columns: table2Columns,
    }
  },
})

</script>

<style lang="scss">
</style>