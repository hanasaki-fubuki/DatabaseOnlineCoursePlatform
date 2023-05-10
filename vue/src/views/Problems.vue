<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
    <div>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <CardNewProblem></CardNewProblem>
            </a-col>
        </a-row>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <CardProblemList></CardProblemList>
            </a-col>
        </a-row>
    </div>
</template>

<script>

import CardNewProblem from '../components/CardNewProblem.vue' ;
import CardProblemList from "@/components/Cards/CardProblemList.vue";

export default ({
    components: {
        CardNewProblem,
        CardProblemList,
    },
    data() {
        return {
        }
    },
})

</script>

<style lang="scss">
</style>