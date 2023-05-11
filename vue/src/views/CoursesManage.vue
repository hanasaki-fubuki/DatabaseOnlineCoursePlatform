<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
  <div>
    <a-row :gutter="24" type="flex">
      <a-col :span="24" class="mb-24">
        <CardCourseManage />
      </a-col>
    </a-row>
  </div>

</template>

<script>

// Course List component.
import CardCourseManage from '../components/Cards/CardCourseManage.vue' ;


export default ({
  components: {
    CardCourseManage,
  },
  data() {
    return {

    }
  },
})

</script>

<style lang="scss">
</style>