<template>
  <teleport to="#defaultPop">
      <!-- 평가원 스탠다드 권한부여 -->
      <ApprovedStandard v-if="isApprovedStandard"/> 
      <DistributionStatus v-if="isDistributionStatus"/> 
      <GiasStatus v-if="isGiasStatus"/> 
  </teleport>
  <Home />
</template>

<script setup>
import Home from '@/layouts/home'
import ApprovedStandard from '@/layouts/popup'
import DistributionStatus from '@/layouts/popup/distStatPopup'
import GiasStatus from '@/layouts/popup/giasStatPopup'
import * as Utils from '@/common/util/util'
import { onBeforeMount, computed, toRefs } from 'vue'
import { useStore } from 'vuex'
import { useRouter, useRoute } from 'vue-router'

const store = useStore()
const router = useRouter()
const route = useRoute()
const {  
  isApprovedStandard,
  isDistributionStatus,
  isGiasStatus,
} = toRefs(store.state.temp) 

onBeforeMount(() => {
  const checkUserId = computed(() => store.state.temp.userInfo)

  // 로그인이 필요 없는 경로 목록
  const publicPaths = ["/login", "/join"]

  // 현재 경로가 로그인이 필요 없는 경로인지 확인
  const isPublicPath = publicPaths.includes(route.path)

  if (!isPublicPath && (!checkUserId.value.memberCode || checkUserId.value.memberCode === "")) {
    store.commit('temp/clearUserInfo')
    store.commit('grid/clearSearchParam')
    alert("로그인이 필요한 서비스입니다.")
    router.push("/login") // 로그인 페이지로 이동
  }
})
</script>

