Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUseGetUserProfile: false,
    list: [],
  },
  onLoad() {
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
  },
  getUserProfile(e) {
    wx.getUserProfile({
      desc: '用于完善会员资料',
      success: (res) => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
        var userInfo = res.userInfo
        //获取code
        wx.login({
          success (res) {
            if (res.code) {
              //获取openid
              wx.request({
                method: "POST",
                url: 'http://localhost:9090/user/get_wechat_code',
                dataType: "json",
                data: {
                  code: res.code
                },
                success: (res)=>{
                  console.log("openid: " + res.data.data.openid)
                  var openid = res.data.data.openid
                  //用户登陆
                  wx.request({
                    method: "POST",
                    url: 'http://localhost:9090/user/wechat_login',
                    dataType: "json",
                    data: {
                      openId: openid,
                      nickName: userInfo.nickName,
                      avatarUrl: userInfo.avatarUrl
                    },
                    success: (res)=>{
                      console.log("登陆成功");
                      console.log(res);
                    }
                  })
                }
              })
            } else {
              console.log('登录失败！' + res.errMsg)
            }
          }
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
})
