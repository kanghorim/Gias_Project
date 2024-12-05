<template>
    <!-- 특정 라우트가 아닌 경우에만 Header와 Footer를 표시 -->
    <Header v-if="showHeaderFooter" />
    <!-- <Side v-if="isMain" /> -->
    <Content />
    <Footer v-if="showHeaderFooter" />
</template>

<script>
import Header from '@/components/inc/header'
import Footer from '@/components/inc/footer'
import Content from '@/components/inc/content'
import { computed } from 'vue'
import { useRoute } from 'vue-router'

export default {
    components: {
        Header,
        Footer,
        Content
    },
    setup() {
        const route = useRoute()

        // 특정 경로에 따라 헤더와 푸터 표시 여부를 결정
        const showHeaderFooter = computed(() => {
            const hiddenRoutes = ['login', 'join']; // 헤더/푸터를 숨기고 싶은 페이지의 이름
            return !hiddenRoutes.includes(route.name); // 현재 라우트의 이름이 hiddenRoutes에 포함되지 않을 때만 표시
        });

        const isMain = computed(() => {
            // 필요 시 스토어의 값을 활용해 Side 컴포넌트 표시 여부 결정
            return store.state.temp.isMain;
        });

        return {
            isMain,
            showHeaderFooter
        }
    }
}
</script>
