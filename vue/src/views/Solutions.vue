<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
    <div>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <CardSolution></CardSolution>
            </a-col>
        </a-row>
    </div>
</template>

<script>

import CardSolution from '../components/Cards/CardSolution.vue' ;

export default ({
    components: {
        CardSolution,
    },
    data() {
        return {
        }
    },
})

</script>

<style lang="scss">
</style>