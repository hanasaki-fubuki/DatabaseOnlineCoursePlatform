<!--
	This is the tables page, it uses the dashboard layout in:
	"./layouts/Dashboard.vue" .
 -->

<template>
    <div>
        <a-row :gutter="24" type="flex">
            <a-col :span="24" class="mb-24">
                <CardProjectTable2></CardProjectTable2>
            </a-col>
        </a-row>
    </div>
</template>

<script>

import CardProjectTable2 from '../components/Cards/CardProjectTable2' ;

export default ({
    components: {
        CardProjectTable2,
    },
    data() {
        return {
        }
    },
})

</script>

<style lang="scss">
</style>