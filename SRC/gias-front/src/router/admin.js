import admin       from '@/pages/admin/list'
import adminView       from '@/pages/admin/view'
export default [
    {
        path: '/admin', 
        name: 'admin',
        component: admin,
    },
    {
        path: '/adminView', 
        name: 'adminView',
        component: adminView,
    }
]
