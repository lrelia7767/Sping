import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import changdiguanliyuanList from '../pages/changdiguanliyuan/list'
import changdiguanliyuanDetail from '../pages/changdiguanliyuan/detail'
import changdiguanliyuanAdd from '../pages/changdiguanliyuan/add'
import fenleiList from '../pages/fenlei/list'
import fenleiDetail from '../pages/fenlei/detail'
import fenleiAdd from '../pages/fenlei/add'
import changguanxinxiList from '../pages/changguanxinxi/list'
import changguanxinxiDetail from '../pages/changguanxinxi/detail'
import changguanxinxiAdd from '../pages/changguanxinxi/add'
import yuyuexinxiList from '../pages/yuyuexinxi/list'
import yuyuexinxiDetail from '../pages/yuyuexinxi/detail'
import yuyuexinxiAdd from '../pages/yuyuexinxi/add'
import daochangxinxiList from '../pages/daochangxinxi/list'
import daochangxinxiDetail from '../pages/daochangxinxi/detail'
import daochangxinxiAdd from '../pages/daochangxinxi/add'
import lichangxinxiList from '../pages/lichangxinxi/list'
import lichangxinxiDetail from '../pages/lichangxinxi/detail'
import lichangxinxiAdd from '../pages/lichangxinxi/add'
import pingjiaxinxiList from '../pages/pingjiaxinxi/list'
import pingjiaxinxiDetail from '../pages/pingjiaxinxi/detail'
import pingjiaxinxiAdd from '../pages/pingjiaxinxi/add'
import xinyupingjiaList from '../pages/xinyupingjia/list'
import xinyupingjiaDetail from '../pages/xinyupingjia/detail'
import xinyupingjiaAdd from '../pages/xinyupingjia/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'changdiguanliyuan',
					component: changdiguanliyuanList
				},
				{
					path: 'changdiguanliyuanDetail',
					component: changdiguanliyuanDetail
				},
				{
					path: 'changdiguanliyuanAdd',
					component: changdiguanliyuanAdd
				},
				{
					path: 'fenlei',
					component: fenleiList
				},
				{
					path: 'fenleiDetail',
					component: fenleiDetail
				},
				{
					path: 'fenleiAdd',
					component: fenleiAdd
				},
				{
					path: 'changguanxinxi',
					component: changguanxinxiList
				},
				{
					path: 'changguanxinxiDetail',
					component: changguanxinxiDetail
				},
				{
					path: 'changguanxinxiAdd',
					component: changguanxinxiAdd
				},
				{
					path: 'yuyuexinxi',
					component: yuyuexinxiList
				},
				{
					path: 'yuyuexinxiDetail',
					component: yuyuexinxiDetail
				},
				{
					path: 'yuyuexinxiAdd',
					component: yuyuexinxiAdd
				},
				{
					path: 'daochangxinxi',
					component: daochangxinxiList
				},
				{
					path: 'daochangxinxiDetail',
					component: daochangxinxiDetail
				},
				{
					path: 'daochangxinxiAdd',
					component: daochangxinxiAdd
				},
				{
					path: 'lichangxinxi',
					component: lichangxinxiList
				},
				{
					path: 'lichangxinxiDetail',
					component: lichangxinxiDetail
				},
				{
					path: 'lichangxinxiAdd',
					component: lichangxinxiAdd
				},
				{
					path: 'pingjiaxinxi',
					component: pingjiaxinxiList
				},
				{
					path: 'pingjiaxinxiDetail',
					component: pingjiaxinxiDetail
				},
				{
					path: 'pingjiaxinxiAdd',
					component: pingjiaxinxiAdd
				},
				{
					path: 'xinyupingjia',
					component: xinyupingjiaList
				},
				{
					path: 'xinyupingjiaDetail',
					component: xinyupingjiaDetail
				},
				{
					path: 'xinyupingjiaAdd',
					component: xinyupingjiaAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
