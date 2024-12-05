<template>
  <div class="contents contents--full">
    <div class="contents__wrap">
      <div class="sub-top">
        <h3>품질평가 통계</h3>
        <div class="sub-top__navi">
          <span class="icon-home navi--home"></span>
          <span>품질평가 통계</span>
        </div>
      </div>

      <div class="container">
        <!-- 통계 테이블 -->
        <table class="stats-table">
          <thead>
            <tr>
              <th>Domain</th>
              <th>Principle</th>
              <th>Standard</th>
              <th>세부평가코드</th>
              <th>세부평가사항</th>
              <th>세부평가점수</th>
            </tr>
          </thead>
          <tbody>
            <!-- 도메인별 반복 -->
            <template v-for="(domain, domainIndex) in transformedDomains" :key="domainIndex">
              <template v-for="(principle, principleIndex) in domain.principles" :key="principleIndex">
                <template v-for="(standard, standardIndex) in principle.standards" :key="standardIndex">
                  <template v-for="(evaluation, evalIndex) in standard.evaluations" :key="evalIndex">
                    <tr>
                      <!-- Domain -->
                      <td v-if="principleIndex === 0 && standardIndex === 0 && evalIndex === 0" :rowspan="getDomainRowspan(domain)">
                        {{ domain.domainName }}
                      </td>
                      <!-- Principle -->
                      <td v-if="standardIndex === 0 && evalIndex === 0" :rowspan="getPrincipleRowspan(principle)">
                        {{ principle.principleName }}
                      </td>
                      <!-- Standard -->
                      <td v-if="evalIndex === 0" :rowspan="standard.evaluations.length">
                        {{ standard.standardName }}
                      </td>
                      <!-- Evaluation -->
                      <td>{{ evaluation.evaluationCode }}</td>
                      <td>{{ evaluation.evaluationName }}</td>
                      <td>{{ evaluationScores[evaluation.evaluationCode] || "평가중" }}</td>
                    </tr>
                  </template>
                </template>
              </template>
            </template>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed, reactive, onMounted } from "vue";
import { useStore } from "vuex";

const store = useStore();

// 도메인 데이터와 평가 데이터 가져오기
const domainList = computed(() => store.state.grid.domainData);
const orgEvlList = computed(() => store.state.grid.evlOrgData);
const checkUserId = computed(() => store.state.temp.userInfo);

// 평가 점수 매핑 객체
const evaluationScores = reactive({});

// 트리 구조 변환 함수
const transformToTreeStructure = (data) => {
  const groupedData = {};

  data.forEach((item) => {
    if (!groupedData[item.domainCode]) {
      groupedData[item.domainCode] = {
        domainCode: item.domainCode,
        domainName: item.domainName,
        principles: {},
      };
    }
    const domain = groupedData[item.domainCode];

    if (!domain.principles[item.principleCode]) {
      domain.principles[item.principleCode] = {
        principleCode: item.principleCode,
        principleName: item.principleName,
        standards: {},
      };
    }
    const principle = domain.principles[item.principleCode];

    if (!principle.standards[item.standardCode]) {
      principle.standards[item.standardCode] = {
        standardCode: item.standardCode,
        standardName: item.standardName,
        evaluations: [],
      };
    }
    const standard = principle.standards[item.standardCode];

    standard.evaluations.push({
      evaluationCode: item.evaluationCode,
      evaluationName: item.evaluationName,
    });
  });

  return Object.values(groupedData).map((domain) => ({
    ...domain,
    principles: Object.values(domain.principles).map((principle) => ({
      ...principle,
      standards: Object.values(principle.standards),
    })),
  }));
};

// 트리 데이터 생성
const transformedDomains = computed(() => transformToTreeStructure(domainList.value));

// rowspan 계산
const getDomainRowspan = (domain) => {
  return domain.principles.reduce((total, principle) => {
    return total + principle.standards.reduce((count, standard) => count + standard.evaluations.length, 0);
  }, 0);
};

const getPrincipleRowspan = (principle) => {
  return principle.standards.reduce((count, standard) => count + standard.evaluations.length, 0);
};

// 평가 점수 매핑 함수
const mapEvaluationScores = () => {
  orgEvlList.value.forEach((item) => {
    if (item.evaluationCode && item.evaluationScore !== null) {
      evaluationScores[item.evaluationCode] = item.evaluationScore;
    }
  });
};

// 데이터 가져오기
const getGridData = async () => {
  let param = {
    memberCode: checkUserId.value.memberCode,
  };
  await store.dispatch("grid/fetchDomain", param);
};

const getEvlData = async () => {
  let param = {
    memberCode: checkUserId.value.memberCode,
  };
  await store.dispatch("grid/fetchEvlOrg", param);
  mapEvaluationScores(); // 평가 점수 매핑
};

// onMounted 실행
onMounted(async () => {
  await getGridData();
  await getEvlData();
});
</script>

<style>
.stats-table {
  width: 100%;
  border-collapse: collapse;
  text-align: left;
}

.stats-table th,
.stats-table td {
  border: 1px solid #ddd;
  padding: 8px;
}

.stats-table th {
  background-color: #f4f4f4;
  font-weight: bold;
}

.stats-table td {
  vertical-align: top;
}
</style>
