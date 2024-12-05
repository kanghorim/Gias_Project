import login       from '@/pages/login/memberLogin'
//import find   from '@/pages/login/find'
import join       from '@/pages/login/join'

export default [
    {
        path: '/join',
        name: 'join',
        component: join,
    },
    {
        path: '/login',
        name: 'login',
        component: login,
    }
]
