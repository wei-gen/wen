const envConf = {
  // 开发版-本地环境
  develop: {
      mode: 'dev',
      APP_BASE_URL: 'http://192.168.0.109:9090',
  },
  // 体验版-测试环境
  trial: {
      mode: 'test',
      APP_BASE_URL: 'API地址',
  },
  // 正式版-正式环境
  release: {
      mode: 'prod',
      APP_BASE_URL: 'API地址',
  }
}
module.exports = {
  env: envConf[wx.getAccountInfoSync().miniProgram.envVersion]
}
