<template>
   <!--페이징-->
   <div class="paging--simple spacing--xs">
        <a type="button" class="paging__btn icon-first disable" v-if="pagingBean?.pageNo > 1" @click="gridLoad(1)"/>        
        <a type="button" class="paging__btn icon-prev disable" v-if="pagingBean?.pageStartNo - 1 > 1" @click="gridLoad(pagingBean?.pageStartNo - 1)"/>        
        <a v-for="num of pageGroupArr" :key="num" type="button" :class="pagingBean?.pageNo == num ? 'on' : ''" @click="gridLoad(num)">
            {{ num }}
        </a>
        <a type="button" class="paging__btn icon-next" v-if="pagingBean?.pageEndNo + 1 < pagingBean?.totalPageCount" @click="gridLoad(pagingBean?.pageEndNo + 1)"/>        
        <a type="button" class="paging__btn icon-last" v-if="pagingBean?.pageNo < pagingBean?.totalPageCount" @click="gridLoad(pagingBean?.totalPageCount)"/>        
	</div>
</template>

<script setup>
    //import { getCookie } from '@/util/util';
    import { computed } from 'vue'
    import { useStore } from 'vuex'
    import { useRoute } from 'vue-router'
    import { onMounted, onUnmounted } from 'vue'

    const store = useStore()
    const route = useRoute()   
	//const cookie = getCookie(document.cookie)
    
    const props = defineProps({
        editorType : String,
        boardType : Number
    })

    const isAdmin = computed(() => {
        return store.state.temp.isAdmin
    })

    const emit = defineEmits(['getGridData'])

    const pagingBean = computed(() => {
        return store.state.grid.pagination 
    })

    const pageGroupArr = computed(() => {
        const arr = []
        const end =  store.state.grid.pagination?.pageEndNo
        const start =  store.state.grid.pagination?.pageStartNo
        if(start > 0) {
            for (let i = start ; i <= end ; i++) {
                arr.push(i)
            }
        }
        
        return arr
    })

    const gridLoad = (pageNo) => {
        store.commit('temp/setSearchParam', {key : 'pageNo', value : pageNo})
        emit('getGridData')
    }

    const getMessgage = (e) => {
		if(e.origin == process.env.VUE_APP_API_URL) {
			getGridData()
		}
	}

    onMounted(async () => {
        //await store.dispatch('detail/fetchBoardDetail', { bdNo: route.query?.no, bdTypeCd: route.query?.boardType })
        // 글쓰기, 수정하기 이벤트리스너 체크
        window.addEventListener('message', getMessgage)
    })

    onUnmounted(() => {
        // 페이지 닫힐 때 해당 리스너 삭제
        window.removeEventListener('message', getMessgage)
    })    

</script>

<style>

</style>