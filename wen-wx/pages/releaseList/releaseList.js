const {env} = require("../../utils/config")

var defaultImageUrl = "https://mmbiz.qpic.cn/mmbiz/icTdbqWNOwNRna42FI242Lcia07jQodd2FJGIYQfG0LAJGFxM4FbnQP6yfMxBgJ0F3YRqJCJ1aPAK2dQagdusBZg/0"

Page({
  data: {
    showDialog: false,
    src: "",
    showCameraDialog: false,
    hasChooseImage: false,
    imageUrl: defaultImageUrl,
    imagePath: ""
  },
  uploadData() {

  },
  chooseImage() {
    var that = this
    var thatJson = JSON
    wx.chooseMedia({
      count: 1,
      mediaType: ['image'],
      sourceType: ['album'],
      maxDuration: 30,
      camera: 'back',
      success(res) {
        console.log(res)
        const tempFilePath = res.tempFiles[0].tempFilePath
        //上传文件
        wx.uploadFile({
          url: env.APP_BASE_URL + '/file/upload_image',
          filePath: tempFilePath,
          name: 'imgFile',
          success(res) {
            const data = thatJson.parse(res.data)
            console.log(thatJson.parse(res.data))
            console.log(res.data)
            that.setData({
              imagePath: data.data,
              imageUrl: env.APP_BASE_URL + data.data
            })
          }
        })
      }
    })
  },
  takePhoto() {
    console.log("拍照")
    this.ctx.takePhoto({
      quality: 'high',
      success: (res) => {
        this.setData({
          src: res.tempImagePath,
          showCameraDialog: false
        })
      }
    })
  },
  // 点击按钮显示弹窗
  showDialog() {
    this.setData({
      showDialog: true,
      showCameraDialog: true
    });
  },
  // 点击弹窗以外区域隐藏弹窗
  hideDialog() {
    this.setData({
      showDialog: false
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.ctx = wx.createCameraContext()
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})