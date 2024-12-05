import { createRouter, createWebHistory } from 'vue-router'
import Home from '../pages/home'
// import push from './push'
import admin from './admin'
import organization from './organization'
import notice from './notice'
import login from './login'
import giasInput from './giasInput'
//import store from '../store'
const router = createRouter({
    history: createWebHistory(),
    // routes: dynamic(store)
    routes: [
        {
            path: '/', 
            name: 'Home', 
            component: Home,
            beforeEnter: (to, from, next) => {
                //console.log("home router111", to, from)
                //console.log("home store", store.state.treeMenu.tree)
                //console.log("123123123")
                //store.commit('temp/setIsMain', false)
                next()
            }
        },
        ...admin,
        ...notice,
        ...login,
        ...organization,
        ...giasInput,
    ]
})

export default router;  
