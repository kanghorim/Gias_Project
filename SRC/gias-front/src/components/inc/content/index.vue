<template>
   <router-view/>
</template>

<script setup>
import { useStore } from 'vuex'
import { computed } from 'vue'

    const store = useStore();
    const isMain = computed(() => {
        return true //store.state.temp.isMain
    })
        
</script>

<style scoped>

</style> 