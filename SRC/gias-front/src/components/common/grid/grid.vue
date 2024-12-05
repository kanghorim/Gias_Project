<template>
    <!--게시판리스트-->
    <div class="board-list board-list-sm table-overflow-md">
        <table>
            <colgroup>
                <col v-for="(item, index) of gridInfo.colstyle" :style="item" :key="index">
            </colgroup>
            <tr>
                <th v-for="(item, index) of gridInfo.header" :key="index">
                    {{ item }}
                </th>
            </tr>
            <tr v-for="(vo, index) of dataList" :key="index">
                <template v-for="(cnt, idx) in gridInfo.cell" :key="idx">
                    <td :class="cnt.class" >
                        <template v-if="cnt.link">
                            <router-link :to="{path: gridInfo.detailPath, query: {no : vo[gridInfo.pk], boardType : gridInfo?.boardType}}">
                                {{vo[cnt.key]}}
                            </router-link>
                        </template>
                        <template v-else>
                            {{vo[cnt.key]}}
                        </template>
                    </td>
                </template>
            </tr>
        </table>
    </div>
</template>

<script setup>
    const props = defineProps({
        gridInfo : Object,
        dataList : Array
    })

    const emits = defineEmits([])

</script>

<style>

</style>