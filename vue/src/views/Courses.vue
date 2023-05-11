<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
  <div>
    <a-row :gutter="24" type="flex">
      <a-col :span="24" class="mb-24">
        <CardCourseList />
      </a-col>
    </a-row>
  </div>

</template>

<script>

// Course List component.
import CardCourseList from '../components/Cards/CardCourseList.vue' ;


export default ({
  components: {
    CardCourseList,
  },
  data() {
    return {

    }
  },
})

</script>

<style lang="scss">
</style>