import noticeList       from '@/pages/notice/list'
import noticeregister   from '@/pages/notice/register'
import noticeView       from '@/pages/notice/view'
export default [
    {
        path: '/notice-list', 
        name: 'noticeList',
        component: noticeList,
    }, 
    {
        path: '/notice-register', 
        name: 'register',
        component: noticeregister,
    },
    {
        path: '/notice-view', 
        name: 'noticeView',
        component: noticeView,
    }
]
