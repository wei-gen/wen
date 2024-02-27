Component({
  options: {
    addGlobalClass: true,
  },
  properties: {
  },
  data: {
    tabBarList: [
      {
        "pagePath": "/pages/index/index",
        "text": "首页",
        "iconPath": "/static/icons/index_icon.png",
        "selectedIconPath": "/static/icons/index_icon_selected.png"
      },
      {
        "pagePath": "/pages/demo/demo",
        "text": "测试",
        "iconPath": "/static/icons/demo_icon.png",
        "selectedIconPath": "/static/icons/demo_icon_selected.png"
      },
      {
        "pagePath": "/pages/user/user",
        "text": "我的",
        "iconPath": "/static/icons/my_icon.png",
        "selectedIconPath": "/static/icons/my_icon_selected.png"
      }
    ],
  },
  methods: {
    switchTab(e) {
      const index = e.currentTarget.dataset.index;
      const path = this.data.tabBarList[index].pagePath;
      console.log("跳转到：" + path)
      wx.redirectTo({
        url: path,
      });
    },
  },
});
