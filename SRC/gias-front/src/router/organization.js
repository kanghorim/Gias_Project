import organization       from '@/pages/organization'
import organizationView       from '@/pages/organization/view'
import organizationGiasStats       from '@/pages/organization/orgGiasStats'
export default [
    {
        path: '/organization-list', 
        name: 'organization',
        component: organization,
    },
    {
        path: '/organization-view', 
        name: 'organizationView',
        component: organizationView,
    },
    {
        path: '/organization-giasStats', 
        name: 'organizationGiasStats',
        component: organizationGiasStats,
    }
]
