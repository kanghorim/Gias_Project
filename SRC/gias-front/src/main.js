import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// Vue의 경고 비활성화
const app = createApp(App);


// const vuetify = createVuetify({
//   components,
//   directives,
// }) 

//createApp(App).use(router).use(vueDompurifyHTML).mount('#app')
//createApp(App).use(store).use(Antd).use(router).use(vueDompurifyHTML).use(vuetify).mount('#app') 
// 앱 구성
app.use(router)
//    .use(Antd)
    .use(store)
//    .use(vueDompurifyHTML)
//    .use(vuetify)
   .mount('#app'); 
