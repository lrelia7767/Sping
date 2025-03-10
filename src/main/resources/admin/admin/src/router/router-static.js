import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import daochangxinxi from '@/views/modules/daochangxinxi/list'
    import pingjiaxinxi from '@/views/modules/pingjiaxinxi/list'
    import yuyuexinxi from '@/views/modules/yuyuexinxi/list'
    import changguanxinxi from '@/views/modules/changguanxinxi/list'
    import fenlei from '@/views/modules/fenlei/list'
    import forum from '@/views/modules/forum/list'
    import changdiguanliyuan from '@/views/modules/changdiguanliyuan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import lichangxinxi from '@/views/modules/lichangxinxi/list'
    import config from '@/views/modules/config/list'
    import xinyupingjia from '@/views/modules/xinyupingjia/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '通知公告',
        component: news
      }
      ,{
	path: '/daochangxinxi',
        name: '到场信息',
        component: daochangxinxi
      }
      ,{
	path: '/pingjiaxinxi',
        name: '评价信息',
        component: pingjiaxinxi
      }
      ,{
	path: '/yuyuexinxi',
        name: '预约信息',
        component: yuyuexinxi
      }
      ,{
	path: '/changguanxinxi',
        name: '场馆信息',
        component: changguanxinxi
      }
      ,{
	path: '/fenlei',
        name: '分类',
        component: fenlei
      }
      ,{
	path: '/forum',
        name: '论坛交流',
        component: forum
      }
      ,{
	path: '/changdiguanliyuan',
        name: '场地管理员',
        component: changdiguanliyuan
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/lichangxinxi',
        name: '离场信息',
        component: lichangxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/xinyupingjia',
        name: '信誉评价',
        component: xinyupingjia
      }
      ,{
	path: '/newstype',
        name: '通知公告分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
